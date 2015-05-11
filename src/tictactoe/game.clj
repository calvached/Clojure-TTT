(ns tictactoe.game
  (:use [tictactoe.board :only [gameboard valid-placement? place-piece]])
  (:use [tictactoe.rulebook :only [game-over? winning-game-piece]])
  (:use [tictactoe.messenger])
  (:use [tictactoe.human :only [make-move]])
  (:use [tictactoe.ai-selector :only [get-move]])
  (:gen-class))

(defn- prompt-valid-move
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

(defn- prompt-valid-ai-move
  [difficulty board player]
  (loop [move (get-move difficulty board player)]
    (if (valid-placement? move board) move
        (recur (get-move difficulty board player)))
  )
)

(defn- get-player-move
  [difficulty board player]
  (if (= player "X") (prompt-valid-ai-move difficulty board player)
    (prompt-valid-move board player))
)

(defn run
  [settings]
  (welcome)
  (loop [board (gameboard (get settings :board-size))
         difficulty (get settings :difficulty)
         current-player (get settings :player1)
         next-player (get settings :player2)]

    (display board)

    (if (game-over? board) (winning-message (winning-game-piece board))
      (let [move (get-player-move difficulty board current-player)]
        (let [next-board (place-piece move current-player board)]
          (recur next-board difficulty next-player current-player)
        )
      )
    )
  )
)
