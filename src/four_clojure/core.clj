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

;Write a function which reverses a sequence.
(defn reverse-seq
  [arr]
  (into '() arr))

(reverse-seq [5 4 3 2 1])
(reverse-seq (sorted-set 5 7 2 7))
(= (reverse-seq [1 2 3 4 5]) [5 4 3 2 1])
(= (reverse-seq (sorted-set 5 7 2 7)) '(7 5 2))
(= (reverse-seq [[1 2] [3 4] [5 6]]) [[5 6] [3 4] [1 2]])

;Write a function which returns the sum of a sequence of numbers.
(defn my-sum
  [arr]
  (reduce + 0 arr))

(= (my-sum [1 2 3]) 6)
(= (my-sum (list 0 -2 5 5)) 8)
(= (my-sum (list 0 -2 5 5)) 8)
(= (my-sum '(0 0 -1)) -1)
(= (my-sum '(1 10 3)) 14)

;; Write a function which returns only the odd numbers from a sequence.
(defn odd
  [arr]
  (filter #(> (rem % 2) 0) arr))

(= (odd #{1 2 3 4 5}) '(1 3 5))
(= (odd [4 2 1 6]) '(1))
(= (odd [2 2 4 6]) '())
(= (odd [2 2 4 6]) '())

;; Write a function which returns the first X fibonacci numbers.
(defn fbn
  [n]
  (loop [curr 1
         next 1
         result []
         n n]
    (if-not (zero? n)
      (recur next (+ curr next) (conj result curr) (dec n))
      result)))

(= (fbn 3) '(1 1 2))
(= (fbn 6) '(1 1 2 3 5 8))
(= (fbn 8) '(1 1 2 3 5 8 13 21))

;; #27 Write a function which returns true if the given sequence is a palindrome.