(ns tictactoe.messenger
  (:gen-class))

(defn welcome []
  (println "Welcome To Tic Tac Toe!")
)

(defn ask-for-piece-placement []
  (print "Please enter a number to place your piece on: ")
)

(defn choose-again []
  (print "Choose again: ")
)
