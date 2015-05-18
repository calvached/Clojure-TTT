(ns tictactoe.game
  (:use [tictactoe.board :only [gameboard valid-placement? place-piece]])
  (:use [tictactoe.rulebook :only [game-over? winning-game-piece draw?]])
  (:use [tictactoe.messenger])
  (:use [tictactoe.validator])
  (:use [tictactoe.human :only [make-move]])
  (:use [tictactoe.ai-selector :only [get-move]])
  (:gen-class))

(defn- move-valid?
  [board move]
  (and (valid-input? move) (valid-placement? (read-string move) board))
)

(defn- prompt-human-move
  [board player]
  (ask-for-piece-placement)
  (loop [move (make-move board player)]
    (if (move-valid? board move) (read-string move)
      (do
        (invalid-selection)
        (recur (make-move board player))
      )
    )
  )
)

(defn- ai-move
  [difficulty board player opponent]
  (get-move difficulty board player opponent)
)

(defn- get-player-move
  [difficulty board current-player next-player]
  (if (= current-player "X") (ai-move difficulty board current-player next-player)
    (prompt-human-move board current-player))
)

(defn- determine-results
  [board]
  (if (draw? board) (draw-message)
    (winning-message (winning-game-piece board)))
)

(defn run
  [settings]
  (welcome)
  (loop [board (gameboard (get settings :board-size))
         difficulty (get settings :difficulty)
         current-player (get settings :player1)
         next-player (get settings :player2)]

    (display board)

    (if (game-over? board) (determine-results board)
      (let [move (get-player-move difficulty board current-player next-player)]
        (let [next-board (place-piece move current-player board)]
          (recur next-board difficulty next-player current-player)
        )
      )
    )
  )
)
