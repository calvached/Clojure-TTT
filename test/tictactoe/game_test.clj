(ns tictactoe.game-test
  (:require [clojure.test :refer :all]
            [tictactoe.game :refer :all]))

(deftest game-test
  (testing "prints an end game message"
    (with-redefs [tictactoe.messenger/welcome (fn [] "")
                  tictactoe.messenger/display (fn [board] "")
                  tictactoe.messenger/winning-message (fn [piece] (println "Game finished"))
                  tictactoe.board/gameboard (fn [size] ["X" "O" "O"
                                                        "O" "X" "O"
                                                        "O" "O" "X"])]
        (is (= "Game finished\n" (with-out-str (run {:player1 "X"
                                                     :player2 "O"
                                                     :difficulty "Easy"
                                                     :board-size "3"})))))
  )

  (testing "it plays the game"
    (with-redefs [tictactoe.messenger/welcome (fn [] "")
                  tictactoe.messenger/display (fn [board] "")
                  tictactoe.board/gameboard (fn [size] [" " " " " "
                                                        " " " " " "
                                                        " " " " " "])]
        (is (= "X has won!\n" (with-out-str (run {:player1 "X"
                                                  :player2 "X"
                                                  :difficulty "Easy"
                                                  :board-size "3"})))))
  )
)
