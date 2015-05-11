(ns tictactoe.messenger-test
  (:require [clojure.test :refer :all]
            [tictactoe.messenger :refer :all]))

(deftest messenger-test
  (testing "prints a welcome message"
    (is (= "Welcome To Tic Tac Toe!\n"
           (with-out-str (welcome))))
  )

  (testing "asks a player to input a space to place a piece"
    (is (= "Please enter a number to place your piece on: \n"
           (with-out-str (ask-for-piece-placement))))
  )

  (testing "prints a welcome message"
    (is (= "Welcome To Tic Tac Toe!\n"
           (with-out-str (welcome))))
  )

  (testing "prints a message to choose again"
    (is (= "Invalid selection. Try again.\n"
           (with-out-str (invalid-selection))))
  )

  (testing "prints a winning message"
    (is (= "X has won!\n"
           (with-out-str (winning-message "X"))))
  )

  (testing "prints a board"
    (is (= "1  |  2  |  3\n4  |  5  |  6\n7  |  8  |  9\n\n"
           (with-out-str (display [" " " " " "
                                   " " " " " "
                                   " " " " " "]))))
  )

  (testing "prints a draw message"
    (is (= "Draw Game!!\n"
           (with-out-str (draw-message))))
  )
)
