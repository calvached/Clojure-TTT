(ns tictactoe.hard-ai-test
  (:require [clojure.test :refer :all]
            [tictactoe.hard-ai :refer :all]))

(deftest hard-ai-test
  (testing "it scores a win if possible"
    (is (= 6 (make-move [["X" "O" "O"]
                         ["X" " " " "]
                         [" " " " " "]] "X" "O")))
  )

  (testing "it makes the best move for a higher chance of winning"
    (is (= 7 (make-move [[" " "X" "O"]
                         ["O" " " " "]
                         ["X" " " " "]] "X" "O")))
  )

  (testing "it chooses a win over a block"
    (is (= 7 (make-move [["O" "X" " "]
                         ["O" "X" " "]
                         [" " " " " "]] "X" "O")))
  )

  (testing "it blocks a possible diagonal win"
    (is (= 6 (make-move [[" " " " "O"]
                         [" " "O" "X"]
                         [" " " " "X"]] "X" "O")))
  )

  (testing "it blocks a possible column win"
    (is (= 1 (make-move [[" " " " " "]
                         [" " "O" " "]
                         ["X" "O" "X"]] "X" "O")))
  )

  (testing "it blocks a possible row win"
    (is (= 5 (make-move [[" " "X" " "]
                         ["O" "O" " "]
                         [" " " " "X"]] "X" "O")))
  )

  (testing "it scores a win if possible"
    (is (= 8 (make-move [["O" "X" "X"]
                         [" " "O" " "]
                         [" " " " " "]] "O" "X")))
  )
)
