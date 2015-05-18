(ns tictactoe.easy-ai
  (:use [tictactoe.board :only [available-cells]])
  (:gen-class))

(defn make-move
  [board]
  (rand-nth (available-cells board)))
