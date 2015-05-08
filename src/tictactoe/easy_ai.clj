(ns tictactoe.easy-ai
  (:gen-class))

(defn make-move
  [board]
  (rand-int (count board))
)
