(ns tictactoe.board
  (:gen-class))

(defn- raise-to-power
  [base exponent]
  (reduce * (repeat exponent base))
)

(defn gameboard
  [size]
  (into [] (repeat (raise-to-power (read-string size) 2) " "))
)

(defn valid-placement?
  [location board]
  (= (get board location) " ")
)

(defn place-piece
  [location piece board]
  (assoc board location piece)
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
