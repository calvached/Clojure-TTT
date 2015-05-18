(ns tictactoe.validator-test
  (:require [clojure.test :refer :all]
            [tictactoe.validator :refer :all]))

(deftest validator-test
  (testing "returns false when a string is input"
    (is (= false (valid-input? "abc")))
  )

  (testing "returns false when random string is given"
    (is (= false (valid-input? "?$#%^&*")))
  )

  (testing "returns true if a number is input"
    (is (= true (valid-input? "3")))
  )
)
