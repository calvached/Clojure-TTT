(ns tictactoe.hard-ai
  (:use [tictactoe.board :only [place-piece available-cells]])
  (:use [tictactoe.rulebook :only [winning-game-piece game-over? draw?]])
  (:gen-class))

(declare scoring)
(def player-piece (atom ""))

(defn- remember
  [piece]
  (reset! player-piece piece)
)

(defn- ai-wins?
  [board]
  (= (winning-game-piece board) @player-piece)
)

(defn generate-score
  [board depth]
  (cond
    (draw? board) 0
    (ai-wins? board) (- 10 depth)
    :else (+ -10 depth)
  )
)

(defn- minimax
   [board-state current-player next-player depth]
   (if (game-over? board-state)
     (generate-score board-state depth)
     (let [scoreboard (vec (scoring board-state next-player current-player depth))]
       (if (= current-player @player-piece)
         (apply min scoreboard)
         (apply max scoreboard)
       )
     )
   )
)

(defn- scoring
  [board current-player next-player depth]
  (for [move (available-cells board)]
    (let [next-board (place-piece move current-player board)]
      (minimax next-board current-player next-player (inc depth))
    )
  )
)

(defn- moves-with-scores
  [board current-player next-player depth]
  (zipmap (available-cells board) (scoring board current-player next-player depth))
)

(defn- find-best-move
  [scores]
  (first (first (sort-by second > scores)))
)

(defn- best-move
  [board current-player next-player depth]
    (find-best-move (moves-with-scores board current-player next-player depth))
)

(defn make-move
  [board assigned-piece opponent-piece]
  (remember assigned-piece)

  (best-move board assigned-piece opponent-piece 0)
)
