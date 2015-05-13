(ns tictactoe.templater
  (:gen-class))

(defn- cell-separator [row-size index]
  (if (= index (- row-size 1)) "\n" " | ")
)

(defn- row-formatter
  [row]
  (apply str
    (map-indexed
      (fn [index cell]
        (str cell (cell-separator (count row) index))
      )
      row)
  )
)

(defn- row-separator [board-size index]
  (if (= index (- board-size 1)) "\n" "--|---|--\n")
)

(defn create-template-for
  [board dimension]
  (apply str
    (map-indexed
      (fn [index row]
        (str (row-formatter row) (row-separator (count board) index))
      )
       board
    )
  )
)
