(ns tictactoe.rulebook-test
  (:require [clojure.test :refer :all]
            [tictactoe.rulebook :refer :all]))

(deftest rulebook-test
  (testing "finds the dimensions of a board"
    (is (= 3 (dimensions [" " " " " "
                          " " " " " "
                          " " " " " "])))
  )

  (testing "finds the indices for diagonals"
    (is (= [0 1 2] (diagonal-indices [" " " " " "
                                      " " " " " "
                                      " " " " " "])))
  )

  (testing "returns list of rows from a board"
    (is (= [["X" "X" "X"]
            [" " " " " "]
            [" " " " " "]]
           (rows ["X" "X" "X"
                  " " " " " "
                  " " " " " "])))
  )

  (testing "returns columns from a board"
    (is (= [["X" " " " "]
            ["X" " " " "]
            ["X" " " " "]]
           (columns ["X" "X" "X"
                     " " " " " "
                     " " " " " "])))
  )

  (testing "returns left diagonal from a 3x3 board"
    (is (= ["X" "X" " "]
           (left-diagonal ["X" "X" " "
                           " " "X" " "
                           " " " " " "])))
  )

  (testing "returns left diagonal from a 4x4 board"
    (is (= ["X" "X" " " "X"]
           (left-diagonal ["X" "X" " " " "
                           " " "X" " " " "
                           " " " " " " " "
                           " " " " " " "X"])))
  )

  (testing "returns right diagonal from a 3x3 board"
    (is (= [" " "X" " "]
           (right-diagonal ["X" "X" " "
                           " " "X" " "
                           " " " " " "])))
  )

  (testing "returns right diagonal from a 4x4 board"
    (is (= ["X" " " " " " "]
           (right-diagonal ["X" "X" " " "X"
                           " " "X" " " " "
                           " " " " " " " "
                           " " " " " " "X"])))
  )

  (testing "returns diagonals from a board"
    (is (= [["X" "X" " "]
            [" " "X" " "]]
           (diagonals ["X" "X" " "
                       " " "X" " "
                       " " " " " "])))
  )

  (testing "returns all winning possibilities"
    (is (= [["X" "X" " "]
            [" " "X" " "]
            [" " " " " "]
            ["X" " " " "]
            ["X" "X" " "]
            [" " " " " "]
            ["X" "X" " "]
            [" " "X" " "]]
           (possibilities ["X" "X" " "
                           " " "X" " "
                           " " " " " "])))
  )

  (testing "returns true if a single piece occupies the entire subspace"
    (is (= true
           (single-piece-in ["X" "X" "X"])))
  )

  (testing "returns false if multiple pieces occupy a subspace"
    (is (= false
           (single-piece-in ["X" "X" "O"])))
  )

  (testing "returns the first game piece"
    (is (= "O"
           (get-game-piece ["O" "O" "O"])))
  )

  (testing "returns true if subspace is not empty"
    (is (= true
           (not-an-empty ["O" "O" "O"])))
  )

  (testing "returns false if subspace is empty"
    (is (= false
           (not-an-empty [" " " " " "])))
  )

  (testing "returns true if a win exists"
    (is (= true
           (is-win? ["X" "X" "X"])))
  )

  (testing "returns false if a win is not found"
    (is (= false
           (is-win? ["O" "X" "X"])))
  )

  (testing "returns false if a subspace is empty"
    (is (= false
           (is-win? [" " " " " "])))
  )

  (testing "returns the winning game piece"
    (is (= "X"
           (winning-game-piece ["X" "X" "O"
                                " " "X" "O"
                                "O" " " "X"])))
  )

  (testing "returns true if the board is full"
    (is (= true
           (is-full? ["O" "X" "X"
                      "X" "O" "O"
                      "X" "O" "X"])))
  )

  (testing "returns false if the board is not full"
    (is (= false
           (is-full? ["X" "X" "O"
                      "O" " " "O"
                      " " "X" "X"])))
  )

  (testing "returns nil if no winning game piece"
    (is (= nil
           (winning-game-piece ["X" "X" "O"
                                " " " " "O"
                                "O" " " "X"])))
  )

  (testing "returns true if a winner is found"
    (is (= true
           (winner-found? ["X" "X" "O"
                           " " "X" "O"
                           "O" " " "X"])))
  )

  (testing "returns false if no winner found"
    (is (= false
           (winner-found? ["X" "X" "O"
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
)
