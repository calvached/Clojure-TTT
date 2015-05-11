(ns tictactoe.rulebook-test
  (:require [clojure.test :refer :all]
            [tictactoe.rulebook :refer :all]))

(deftest rulebook-test
  (testing "returns the winning game piece"
    (is (= "X"
           (winning-game-piece ["X" "X" "O"
                                " " "X" "O"
                                "O" " " "X"])))
  )

  (testing "returns nil if no winning game piece"
    (is (= nil
           (winning-game-piece ["X" "X" "O"
                                " " " " "O"
                                "O" " " "X"])))
  )

  (testing "it returns true if the game is over"
    (is (= true
           (game-over? ["X" "O" "O"
                        "O" "X" "O"
                        "O" "O" "X"])))
  )

  (testing "it returns false if the game is not over"
    (is (= false
           (game-over? ["O" " " "O"
                        " " "O" " "
                        " " "O" " "])))
  )

  (testing "it returns true if the game is a draw"
    (is (= true
           (draw? ["O" "X" "O"
                   "X" "O" "X"
                   "X" "O" "X"])))
  )

  (testing "it returns false if the game is not a draw"
    (is (= false
           (draw? ["X" "O" "O"
                   "O" "X" "O"
                   "O" "O" "X"])))
  )
)
