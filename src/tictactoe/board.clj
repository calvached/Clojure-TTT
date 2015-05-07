(ns tictactoe.board
  (:gen-class))

(defn- raise-to-power
  [base exponent]
  (reduce * (repeat exponent base))
)

(defn gameboard
  [size]
  (into [] (repeat (raise-to-power size 2) " "))
)

(defn- index-of
  [location]
  (- location 1)
)

(defn valid-placement?
  [location board]
  (= (get board location) " ")
)

(defn place-piece
  [location piece board]
  (if
    (valid-placement? (index-of location) board)
    (assoc board (index-of location) piece)
    board)
)

(defn available-cells
  [board]
  (remove nil?
    (into []
      (map-indexed
        (fn [i cell]
          (if (= cell " ") i))
        board)))
)
