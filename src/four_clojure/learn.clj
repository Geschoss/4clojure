(ns four-clojure.learn)

;мульти методы
(def figs [{:type :rect :w 10 :h 20}
           {:type :rect :w 6 :h 6}
           {:type :circle :r 15}
           {:type :circle :r 6}
           {:type :triangle :a 6 :b 6 :c 7}])

(defn dispatch [{type :type}] type)

(defmulti perimeter dispatch)

(defmethod perimeter :circle [fig]
  (* 2 Math/PI (:r fig)))

(defmethod perimeter :rect [fig]
  (* 2 (+ (:w fig) (:h fig))))

(defmethod perimeter :triangle [{a :a b :b c :c}]
  (+ a b c))


(defmethod perimeter :default [_]
  nil)

(map perimeter figs)

(def bot { :memory :file
          :iface :console
          :brain :default})

;; bot derives file-memory
(defmulti remember (fn [bot k v] (:memory bot)))
(defmulti recall (fn [bot k] (:memory bot)))

;; bot derives console-iface
(defmulti print-msg (fn [bot s] (:iface bot)))
(defmulti read-msg (fn [bot s] (:iface bot)))

;; bot derives default-brain
(defmulti run-cmd (fn [bot cmd] (:brain bot)))

;; Write a function which returns only the odd numbers from a sequence.
(defn odd
  [arr]
  (filter #(> (rem % 2) 0) arr))

(= (odd #{1 2 3 4 5}) '(1 3 5))
(= (odd [4 2 1 6]) '(1))
(= (odd [2 2 4 6]) '())
(= (odd [2 2 4 6]) '())
