(ns tictactoe.core
  (:use [tictactoe.config :only [settings]])
  (:use [tictactoe.game :only [run]])
  (:gen-class))

(defn -main
  [& args]
  (run (settings)))
