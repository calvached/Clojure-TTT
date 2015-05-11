(ns tictactoe.templater
  (:gen-class))

(defn- cell-filler [index cell-contents]
  (if (= cell-contents " ") (+ index 1) cell-contents)
)

(defn- end-of-row? [index dimension]
  (= (rem index dimension) (- dimension 1))
)

(defn- create-row [index dimension]
  (if (end-of-row? index dimension) "\n" "  |  ")
)

(defn create-template-for [board dimension]
  (apply str
    (map-indexed
      (fn [index cell-contents]
        (str (cell-filler index cell-contents)
             (create-row index dimension))
      )
      board
    )
  )
)
