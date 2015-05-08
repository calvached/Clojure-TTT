(ns tictactoe.easy-ai-test
  (:require [clojure.test :refer :all]
            [tictactoe.easy-ai :refer :all]))

(deftest easy-ai-test
  (testing "it generates a random index within the bounds of the gameboard"
    (is (some #{(make-move [" " " " " "
                            " " " " " "
                            " " " " " "])} '(0 1 2 3 4 5 6 7 8)))
  )
)
