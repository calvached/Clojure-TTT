(ns tictactoe.validator
  (:gen-class))

(defn valid-input?
  [input]
  (if (number? (read-string input)) true false))
