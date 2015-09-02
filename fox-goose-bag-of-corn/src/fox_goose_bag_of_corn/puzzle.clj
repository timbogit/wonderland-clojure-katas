(ns fox-goose-bag-of-corn.puzzle)

(def start-pos [[[:fox :goose :corn :you] [:boat] []]])

(def other-steps
  [[[:fox :corn] [:boat :you :goose] []]
   [[:fox :corn] [:boat] [:goose :you]]
   [[:fox :corn] [:boat :you] [:goose]]
   [[:fox :corn :you] [:boat] [:goose]]
   [[:corn] [:boat :you :fox] [:goose]]
   [[:corn] [:boat] [:goose :you :fox]]
   [[:corn] [:boat :fox :you] [:goose]]
   [[:corn :fox :you] [:boat] [:goose]]
   [[:fox] [:boat :corn :you] [:goose]]
   [[:fox] [:boat] [:goose :corn :you]]
   [[:fox] [:boat :goose :you] [:corn]]
   [[:fox :goose :you] [:boat] [:corn]]
   [[:goose] [:boat :fox :you] [:corn]]
   [[:goose] [:boat] [:corn :fox :you]]
   [[:goose] [:boat :you] [:corn :fox]]
   [[:goose :you] [:boat] [:corn :fox]]
   [[] [:boat :you :goose] [:corn :fox]]
   [[] [:boat] [:corn :fox :you :goose]]])

(defn river-crossing-plan []
  (into start-pos other-steps))
