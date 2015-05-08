(ns tictactoe.ai-selector-test
  (:require [clojure.test :refer :all]
            [tictactoe.ai-selector :refer :all]))

(deftest ai-selector-test
  (testing "returns a move from an Easy Ai"
    (is (= 1 (get-move "Easy" [" " " " " "
                               " " " " " "
                               " " " " " "] "X")))
  )
)
