(ns tictactoe.human
  (:gen-class))

(defn make-move
  [board assigned-piece]
  (- (Integer. (read-line)) 1)
)
