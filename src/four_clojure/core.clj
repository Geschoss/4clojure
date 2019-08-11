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

;Write a function which returns the total number of elements in a sequence.
(defn count-seq
  [arr]
  (reduce (fn [acc _] (inc acc)) 0 arr))

(count-seq '(1 2 3 4))
(= (count-seq '(1 2 3 3 1)) 5)
(= (count-seq "Hello World") 11)
(= (count-seq '(13)) 1)
(= (count-seq '(13)) 1)
