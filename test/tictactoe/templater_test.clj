(ns tictactoe.templater-test
  (:require [clojure.test :refer :all]
            [tictactoe.templater :refer :all]))

(deftest templater-test
  (testing "returns a formatted board string"
    (is (= "1  |  2  |  3\n4  |  5  |  6\n7  |  8  |  9\n"
           (create-template-for [" " " " " "
                                 " " " " " "
                                 " " " " " "] 3)))
  )
)
