(ns tictactoe.human-test
  (:require [clojure.test :refer :all]
            [tictactoe.human :refer :all]))

(deftest human-test
  (testing "it gets an index for a number inputed by the user"
    (is (= "3" (with-in-str "3" (make-move [" " " " " "
                                            " " " " " "
                                            " " " " " "] "X"))))
  )
)
