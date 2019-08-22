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

(let my-null nil)

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




