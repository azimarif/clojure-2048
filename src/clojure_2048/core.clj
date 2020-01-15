(ns clojure-2048.core)

;constants
(def ZERO-SYMBOL 0)
(def MAX-ELEMENTS-TO-BE-ADDED 2)
(def ROW-SIZE 4)

(def not-zero (comp not zero?))

(def sum (partial apply +))

(def transpose-matrix (partial apply map vector))

(def left (comp
            (partial map sum)
            (partial mapcat (partial partition-all MAX-ELEMENTS-TO-BE-ADDED))
            (partial partition-by identity)
            (partial filter not-zero)))

(def padd-left (comp
                 (partial take ROW-SIZE)
                 #(concat % (repeat ZERO-SYMBOL))))

(def move-left (comp
                 padd-left
                 left))

(def move-right (comp
                  reverse
                  move-left
                  reverse))

(def play-right-side (partial map move-right))

(def play-left-side (partial map move-left))

(def play-up-side (comp
                    transpose-matrix
                    play-left-side
                    transpose-matrix))

(def play-down-side (comp
                      transpose-matrix
                      play-right-side
                      transpose-matrix))