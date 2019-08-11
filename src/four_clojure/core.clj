(ns four-clojure.core
  (:gen-class))

;Write a function which returns the Nth element from a sequence.
(defn my-nth
  [arr i]
  (last (take (inc i) arr)))

(my-nth '(4 5 6 7) 2)

(= (my-nth '(4 5 6 7) 2) 6)

(= (my-nth [:a :b :c] 0) :a)

(= (my-nth [1 2 3 4] 1) 2)

