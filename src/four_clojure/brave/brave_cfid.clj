(ns four-clojure.brave.brave_cfid
  (:gen-class))
(def filename "suspects.csv")

(slurp filename)

(def vamp-keys [:name :glitter-index])
(defn str->int
  [str]
  (Integer. str))

(def conversions {:name identity
                  :glitter-index str->int})

(defn convert
  [vamp-key value]
  ((get conversions vamp-key) value))

(defn parse
  "Convert a CSV into rows of columns"
  [string]
  (map #(clojure.string/split % #",")
       (clojure.string/split string #"\n")))

(parse (slurp filename))

(defn mapify
  "Return a seq of maps like {:name \"Edward Cullen\" :glitter-index 10}"
  [rows]
  (map (fn
         [unmapped-row]
         (reduce (fn
                   [row-map [vamp-key value]]
                   (assoc row-map vamp-key (convert vamp-key value)))
                 {}
                 (map vector vamp-keys unmapped-row)))
       rows))

(def suspects (mapify (parse (slurp filename))))

(defn glitter-filter
  [minimum-glitter records]
  (map #(:name %) (filter #(>= (:glitter-index %) minimum-glitter) records)))

(glitter-filter 3 (mapify (parse (slurp filename))))

(println suspects)
(def suspect {:name "Pavel Kolomnikov", :glitter-index 16})

(take-while #(some? (get suspect %)) vamp-keys)

(defn validate [keys struct]
  (loop [[key & rest] keys]
   (cond
     (nil? (get struct key)) false
     (empty? rest) true
     :else (recur rest))))

(validate vamp-keys suspect)


(defn append
  [v map]
  (if (validate vamp-keys v)
    (conj map v)
    map))

(append suspect suspects)

(map println (vals suspect))
(defn convert-str->csv [str]
  (clojure.string/join
    "\n"
    (map
      #(clojure.string/join "," (vals %))
      str)))

(convert-str->csv suspects)