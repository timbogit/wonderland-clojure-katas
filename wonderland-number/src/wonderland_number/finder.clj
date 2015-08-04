(ns wonderland-number.finder)


(defn same-digits? [n1 n2]
  (let [s1 (set (str n1))
        s2 (set (str n2))]
    (= s1 s2)))

(def candidates (range 100000 (/ 1000002 6)))

(defn wonderland-number []
  ;; calculate me
  (loop [candidate (first candidates)
         others    (rest candidates)]
    (if (and (= 6 (count (str candidate)))
             (same-digits? candidate (* 2 candidate))
             (same-digits? candidate (* 3 candidate))
             (same-digits? candidate (* 4 candidate))
             (same-digits? candidate (* 5 candidate))
             (same-digits? candidate (* 6 candidate)))
      candidate
      (recur (first others) (rest others)))))
