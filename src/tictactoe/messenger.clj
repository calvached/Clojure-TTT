(ns tictactoe.messenger
  (:use [tictactoe.templater])
  (:gen-class))

(defn welcome []
  (println "Welcome To Tic Tac Toe!")
)

(defn ask-for-piece-placement []
  (println "Please enter a number to place your piece on: ")
)

(defn invalid-selection []
  (println "Invalid selection. Try again.")
)

(defn winning-message
  [piece]
  (print piece)
  (println " has won!")
)

(defn- dimension [board]
  (int (Math/sqrt (count board)))
)

(defn display
  [board]
  (println (create-template-for board (dimension board)))
)
