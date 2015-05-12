(ns tictactoe.game
  (:use [tictactoe.board :only [gameboard valid-placement? place-piece]])
  (:use [tictactoe.rulebook :only [game-over? winning-game-piece draw?]])
  (:use [tictactoe.messenger])
  (:use [tictactoe.human :only [make-move]])
  (:use [tictactoe.ai-selector :only [get-move]])
  (:gen-class))

(defn- prompt-human-move
  [board player]
  (ask-for-piece-placement)
  (loop [move (make-move board player)]
    (if (valid-placement? move board) move
      (do
        (invalid-selection)
        (recur (make-move board player))
      )
    )
  )
)

(defn- ai-move
  [difficulty board player]
  (get-move difficulty board player)
)

(defn- get-player-move
  [difficulty board player]
  (if (= player "X") (ai-move difficulty board player)
    (prompt-human-move board player))
)

(defn- determine-results
  [board]
  (if (draw? board) (draw-message)
    (winning-message (winning-game-piece board)))
)

(defn convert-to-2d
  [board]
  (into [] (map vec (partition 3 board)))
)

(defn run
  [settings]
  (welcome)
  (loop [board (gameboard (get settings :board-size))
         difficulty (get settings :difficulty)
         current-player (get settings :player1)
         next-player (get settings :player2)]

    (display board)

    (if (game-over? (convert-to-2d board)) (determine-results (convert-to-2d board))
      (let [move (get-player-move difficulty board current-player)]
        (let [next-board (place-piece move current-player board)]
          (recur next-board difficulty next-player current-player)
        )
      )
    )
  )
)
