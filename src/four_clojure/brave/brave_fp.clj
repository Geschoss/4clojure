(ns four-clojure.brave.brave-fp)
(require '[clojure.string :as s])

(+ 1 2)

(defn wisdom
      [words]
  (str words ", Daniel-san"))

(wisdom "Always bathe on Fridays")

(defn year-end-evaluation
  []
  (if (> (rand) 0.5)
    "You get a raise"
    "Better luck next year!"))

(year-end-evaluation)

(def great-baby-name "Rosanthony")
(let [great-baby-name "Bloodthunder"]
  great-baby-name)

(defn sum
  ([vals] (sum vals 0))
  ([vals accumulating-total]
    (if (empty? vals)
      accumulating-total
      (recur (rest vals) (+ (first vals) accumulating-total)))))

(sum [1 23 4 34] 2)

(defn clean
  [text]
  (s/replace (s/trim text) #"lol" "LOL"))

(clean "My boa constrictor is so sassy lol! ")


((comp inc *) 2 3)

(def character
  {:name "Smooches McCutes"
   :attributes {:intelligence 10
                :strength 4
                :dexterity 5}})
(def s-int (comp :intelligence :attributes))
(def s-str (comp :strength :attributes))
(def s-dex (comp :dexterity :attributes))

(s-int character)
(s-str character)
(s-dex character)

(def spell-slots-comp (comp int inc #(/ % 2) s-int))
(spell-slots-comp character)

(defn my-comp
  ([f] identity)
  ([f g]
   (fn [& args]
     (f (apply g args)))))

(def m-s-int (my-comp :intelligence :attributes))
(m-s-int character)



