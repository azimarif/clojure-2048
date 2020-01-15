(ns clojure-2048.core-test
  (:require [clojure.test :refer :all]
            [clojure-2048.core :refer :all]))

(def GAME-STATE '((0 0 2 2)
                  (2 2 0 0)
                  (2 0 2 0)
                  (0 2 2 0)))

(deftest library-test-2048
  (testing "2048 game all 4 side play"
    (is (= '((4 0 0 0)
             (4 0 0 0)
             (4 0 0 0)
             (4 0 0 0)) (play-left-side GAME-STATE)))

    (is (= '((0 0 0 4)
             (0 0 0 4)
             (0 0 0 4)
             (0 0 0 4)) (play-right-side GAME-STATE)))

    (is (= '((4 4 4 2)
             (0 0 2 0)
             (0 0 0 0)
             (0 0 0 0)) (play-up-side GAME-STATE)))

    (is (= '((0 0 0 0)
             (0 0 0 0)
             (0 0 2 0)
             (4 4 4 2)) (play-down-side GAME-STATE)))
    ))
