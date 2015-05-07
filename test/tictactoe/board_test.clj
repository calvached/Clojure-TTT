(ns tictactoe.board-test
  (:require [clojure.test :refer :all]
            [tictactoe.board :refer :all]))

(deftest board-test
  (testing "it creates a board with 9 cells"
    (is (= [" " " " " "
            " " " " " "
            " " " " " "] (gameboard "3")))
  )

  (testing "it creates a board with 25 cells"
    (is (= [" " " " " " " " " "
            " " " " " " " " " "
            " " " " " " " " " "
            " " " " " " " " " "
            " " " " " " " " " "] (gameboard "5")))
  )

  (testing "returns true if cell is not occupied"
    (is (= true
           (valid-placement? 2 [" " "X" " " " " " " " " " " " " " "])))
  )

  (testing "returns false if cell is occupied"
    (is (= false
           (valid-placement? 1 [" " "X" " " " " " " " " " " " " " "])))
  )

  (testing "it places a piece on the board"
    (is (= [" " " " " " " " "X" " " " " " " " "]
           (place-piece 5 "X" [" " " " " " " " " " " " " " " " " "])))
  )

  (testing "it does not place a piece if a piece exists in a cell"
    (is (= ["O" " " " " " " "X" " " " " " " " "]
           (place-piece 1 "X" ["O" " " " " " " "X" " " " " " " " "])))
  )

  (testing "returns a list of indices for all available cells"
    (is (= [2 5 6 7 8]
           (available-cells ["X" "O" " " "O" "X" " " " " " " " "])))
  )
)
