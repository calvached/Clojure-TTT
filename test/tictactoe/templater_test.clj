(ns tictactoe.templater-test
  (:require [clojure.test :refer :all]
            [tictactoe.ui.templater :refer :all]))

(deftest templater-test
  (testing "returns a formatted board string"
    (is (= "  |   |  \n--|---|--\n  |   |  \n--|---|--\n  |   |  \n\n"
           (create-template-for [[" " " " " "]
                                 [" " " " " "]
                                 [" " " " " "]] 3)))
  )
)
