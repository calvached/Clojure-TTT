(ns tictactoe.ai-selector-test
  (:require [clojure.test :refer :all]
            [tictactoe.ai-selector :refer :all]))

(deftest ai-selector-test
  (testing "returns a move from an Easy Ai"
    (is (some #{(get-move "Easy" [" " " " " "
                                  " " " " " "
                                  " " " " " "] "X")} '(0 1 2 3 4 5 6 7 8)))
  )
)
