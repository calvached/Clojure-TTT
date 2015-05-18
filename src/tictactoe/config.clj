(ns tictactoe.config
  (:gen-class))

(def player1 "X")
(def player2 "O")
(def difficulty "Hard")
(def board-size 3)

(defn settings []
  {
    :player1 player1
    :player2 player2
    :difficulty difficulty
    :board-size board-size
  }
)
