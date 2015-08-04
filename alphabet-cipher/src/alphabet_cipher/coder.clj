(ns alphabet-cipher.coder)

(defn rotations
  [xs]
  (take (count xs) (partition (count xs) 1 (cycle xs))))

(def a-to-z (map char (range (int \a) (-> \z int inc))))

(def alphabet-matrix-map (->> a-to-z
                              rotations
                              (interleave a-to-z)
                              (apply assoc {})))

(defn encode-letter
  [key letter]
  (-> alphabet-matrix-map
      (get key)
      (nth (- (int letter) (int \a)))))

(defn encode
  [keyword message]
  (let [kw-to-use (take (count message) (cycle keyword))]
    (->> message
         seq
         (map encode-letter kw-to-use)
         (apply str))))

(defn decode
  [keyword message]
  (->> (encode keyword message)
       (iterate #(encode keyword %))
       (take 25)
       last))
