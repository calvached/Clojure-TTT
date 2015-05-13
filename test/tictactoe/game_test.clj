(ns tictactoe.game-test
  (:require [clojure.test :refer :all]
            [tictactoe.game :refer :all]))

(deftest game-test
  (testing "prints a winning game message on game over"
    (with-redefs [tictactoe.messenger/welcome (fn [] "")
                  tictactoe.messenger/display (fn [board] "")
                  tictactoe.messenger/winning-message (fn [piece] (println "Game has Winner!"))
                  tictactoe.board/gameboard (fn [size] [["X" "O" "O"]
                                                        ["O" "X" "O"]
                                                        ["O" "O" "X"]])]
        (is (= "Game has Winner!\n" (with-out-str (run {:player1 "X"
                                                        :player2 "O"
                                                        :difficulty "Easy"
                                                        :board-size "3"})))))
  )

  (testing "prints a draw game message on game over"
    (with-redefs [tictactoe.messenger/welcome (fn [] "")
                  tictactoe.messenger/display (fn [board] "")
                  tictactoe.messenger/draw-message (fn [] (println "Game is Draw!"))
                  tictactoe.board/gameboard (fn [size] [["X" "O" "X"]
                                                        ["X" "O" "O"]
                                                        ["O" "X" "X"]])]
        (is (= "Game is Draw!\n" (with-out-str (run {:player1 "X"
                                                     :player2 "O"
                                                     :difficulty "Easy"
                                                     :board-size "3"})))))
  )

  (testing "it plays the game"
    (with-redefs [tictactoe.messenger/welcome (fn [] "")
                  tictactoe.messenger/display (fn [board] "")]

        (is (= "X has won!\n" (with-out-str (run {:player1 "X"
                                                  :player2 "X"
                                                  :difficulty "Easy"
                                                  :board-size "3"})))))
  )
)
