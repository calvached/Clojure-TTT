(ns tictactoe.ai-selector
  (:require [tictactoe.easy-ai :as easy-ai])
  (:gen-class))

(defn get-move
  [difficulty board assigned-piece]
  (if (= difficulty "Easy") (easy-ai/make-move board assigned-piece))
)
