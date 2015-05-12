(ns tictactoe.rulebook
  (:gen-class))

(defn- dimensions
  [board]
  (count board)
)

(defn- columns
  [board]
  (apply map vector board)
)

(defn- left-diagonal
  [board]
  (reduce
    (fn [cells index]
      (conj cells(get (get board index) index))
    )
    []
    (range (dimensions board))
  )
)

(defn- right-diagonal
  [board]
  (reduce
    (fn [cells index]
      (conj cells(get (get board index) (- (- (dimensions board) 1) index)))
    )
    []
    (range (dimensions board))
  )
)

(defn- diagonals
  [board]
  [(left-diagonal board) (right-diagonal board)]
)

(defn- possibilities
  [board]
  (vec (concat board (columns board) (diagonals board)))
)

(defn- single-piece-in
  [subspace]
  (= 1 (count (distinct subspace)))
)

(defn- get-game-piece
  [subspace]
  (first (distinct subspace))
)

(defn- not-an-empty
  [subspace]
  (not= " " (get-game-piece subspace))
)

(defn- is-win?
  [subspace]
  (and (not-an-empty subspace) (single-piece-in subspace))
)

(defn- is-row-filled?
  [row]
  (if (some #{" "} row) "false" "true")
)

(defn- is-full?
  [board]

  (if (some #{"false"} (map
    (fn [row]
      (is-row-filled? row))
      board)) false true)
)

(defn winning-game-piece
  [board]
  (first (remove nil? (map
    (fn [combo]
      (if (is-win? combo) (get-game-piece combo)))
    (possibilities board)))
  )
)

(defn- winner-found?
  [board]
  (if (winning-game-piece board) true false)
)

(defn draw?
  [board]
  (and (not (winner-found? board)) (is-full? board))
)

(defn game-over?
  [board]
  (or (winner-found? board) (draw? board))
)
