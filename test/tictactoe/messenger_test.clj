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
)
