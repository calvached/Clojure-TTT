(ns tictactoe.rulebook
  (:gen-class))

(defn dimensions
  [board]
  (int (Math/sqrt (count board)))
)

(defn rows
  [board]
  (map vec (partition (dimensions board) board))
)

(defn columns
  [board]
  (apply map vector (rows board))
)

(defn diagonal-indices
  [board]
  (range 0 (dimensions board))
)

(defn left-diagonal
  [board]
  (reduce
    (fn [diagonals i]
      (conj diagonals (nth (nth (rows board) i) i))
    )
    []
    (diagonal-indices board))
)

(defn rotate
  [board]
  (->> board (rows) (map reverse) (flatten) (vec))
)

(defn right-diagonal
  [board]
  (left-diagonal(rotate board))
)

(defn diagonals
  [board]
  [(left-diagonal board) (right-diagonal board)]
)

(defn possibilities
  [board]
  (vec (concat (rows board) (columns board) (diagonals board)))
)

(defn single-piece-in
  [subspace]
  (= 1 (count (distinct subspace)))
)

(defn get-game-piece
  [subspace]
  (first (distinct subspace))
)

(defn not-an-empty
  [subspace]
  (not= " " (get-game-piece subspace))
)

(defn is-win?
  [subspace]
  (and (not-an-empty subspace) (single-piece-in subspace))
)

(defn is-full?
  [board]
  (if (some #{" "} board) false true)
)

(defn winning-game-piece
  [board]
  (first (remove nil? (map
    (fn [combo]
      (if (is-win? combo) (get-game-piece combo)))
    (possibilities board))))
)

(defn winner-found?
  [board]
  (if (winning-game-piece board) true false)
)

(defn game-over?
  [board]
  (or (winner-found? board) (is-full? board))
)
