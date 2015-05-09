(ns tictactoe.messenger
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
