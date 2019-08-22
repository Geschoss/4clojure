(ns four-clojure.brave.brave
  (:gen-class))

(def vampire-database
  {0 {:makes-blood-puns? false, :has-pulse? true  :name "McFishwich"}
   1 {:makes-blood-puns? false, :has-pulse? true  :name "McMackson"}
   2 {:makes-blood-puns? true,  :has-pulse? false :name "Damon Salvatore"}
   3 {:makes-blood-puns? true,  :has-pulse? true  :name "Mickey Mouse"}})

(defn vampire-related-details
  [social-security-number]
  (Thread/sleep 1000)
  (get vampire-database social-security-number))

(defn vampire?
  [record]
  (and (:makes-blood-puns? record)
       (not (:has-pulse? record))
       record))

(defn identify-vampire
  [social-security-numbers]
  (first (filter vampire?
                 (map vampire-related-details social-security-numbers))))

(concat (take 8 (repeat "na")) ["Batman!"])
(take 3 (repeatedly (fn [] (rand-int 10))))

(defn even-numbers
      ([] (even-numbers 0))
      ([n] (cons n (lazy-seq (even-numbers (+ n 2))))))

(take 10 (even-numbers))

(map identity {:sunlig=ht-reaction "Glitter"})

(into {} (map identity {:sunlight-reaction "Glitter!"}))
(into '() [1 2 3])
(into {:favorite-animal "kitty"} {:least-favorite-smell "dog"
                                  :relationship-with-teenager "creepy"})

;; conj

(conj [0] [1])
(into [0] [1])
(conj [0] 1 23 4 4)
(conj {:time "midnight"} [:place "ye olde cemetariom"])

(defn my-conj
  [target & additions]
  (into target additions))

(my-conj [0] 1 23 4)

;; apply

(apply max [1 2 3])

(defn my-into
      [target addition]
      (apply conj target addition))

(my-into [1] [1 2 3 4])

;; partial

(def add10 (partial + 10))
(add10 3)
(add10 4)

(def add-missing-elements
  (partial conj ["water" "air" "shit"]))
(add-missing-elements "top" "down")

(defn my-partial
  [partialized-fn & args]
  (fn [& more-args]
   (apply partialized-fn (into args more-args)) ))

(def add20 (my-partial + 20))
(add20 10)

(apply into [[1] [1 2 3]])

((fn [& args]
   (println args)) 1 2)

;; logger

(defn lousy-logger
  [log-level message]
  (condp = log-level
    :warn (clojure.string/lower-case message)
    :emergency (clojure.string/upper-case message)))

(def warn (partial lousy-logger :warn))
(def error (partial lousy-logger :emergency))

(warn "Warn")
(error "Eroro")

;; complement
(defn my-complement
  [fun]
  (fn
    [& args]
    (not (apply fun args))))

(def my-pos? (complement neg?))
(my-pos? -1)
(def not-vampire? (complement vampire?))

(defn identify-humans
  [social-security-numbers]
  (filter not-vampire?
          (map vampire-related-details social-security-numbers)))

