(ns tictactoe.easy-ai-test
  (:require [clojure.test :refer :all]
            [tictactoe.easy-ai :refer :all]))

(deftest easy-ai-test
  (testing "it generates a random index within the bounds of the gameboard"
    (is (some #{(make-move [" " " " " "
                            " " " " " "
                            " " " " " "])} '(0 1 2 3 4 5 6 7 8)))
  )

  (testing "selects a random index only from available cells"
    (is (= 4 (make-move ["X" "O" "X"
                         "O" " " "O"
                         "O" "X" "X"])))

    (is (= 0 (make-move [" " "O" "X"
                         "O" "X" "O"
                         "O" "X" "X"])))

    (is (= 7 (make-move ["X" "O" "X"
                         "O" "X" "O"
                         "O" " " "X"])))
  )
)
