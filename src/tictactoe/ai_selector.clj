(ns tictactoe.ai-selector
  (:require [tictactoe.easy-ai :as easy-ai])
  (:require [tictactoe.hard-ai :as hard-ai])
  (:gen-class))

(defn get-move
  [difficulty board assigned-piece opponent-piece]
  (cond
    (= difficulty "Easy") (easy-ai/make-move board)
    (= difficulty "Hard") (hard-ai/make-move board assigned-piece opponent-piece)
  )
)
