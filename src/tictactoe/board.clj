(ns tictactoe.board
  (:gen-class))

(defn- raise-to-power
  [base exponent]
  (reduce * (repeat exponent base))
)

(defn- board-1d
  [size]
  (into [] (repeat (raise-to-power size 2) " "))
)

(defn- convert-to-2d
  [board size]
  (into [] (map vec (partition size board)))
)

(defn gameboard
  [size]
  (convert-to-2d (board-1d (read-string size)) (read-string size))
)

(defn- convert-to-1d
  [board]
  (into [] (flatten board))
)

(defn valid-placement?
  [location board]
  (= (get (convert-to-1d board) location) " ")
)

(defn place-piece
  [location piece board]
  (convert-to-2d
    (assoc (convert-to-1d board) location piece)
    (count board)
  )
)

(defn available-cells
  [board]
  (remove nil?
    (into []
      (map-indexed
        (fn [i cell]
          (if (= cell " ") i))
        (convert-to-1d board))))
)
