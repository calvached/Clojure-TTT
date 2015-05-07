(ns tictactoe.config-test
  (:require [clojure.test :refer :all]
            [tictactoe.config :refer :all]))

(deftest config-test
  (testing "it returns a player game piece from settings"
    (is (= player1 (get (settings) :player1)))
  )

  (testing "it returns an opponent piece from settings"
    (is (= player2 (get (settings) :player2)))
  )

  (testing "it returns a difficulty level"
    (is (= difficulty (get (settings) :difficulty)))
  )

  (testing "it returns a board size"
    (is (= board-size (get (settings) :board-size)))
  )
)
