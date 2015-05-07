(ns tictactoe.easy-ai
  (:gen-class))

(defn make-move
  [board assigned-piece]
  (rand-int (count board))
)
