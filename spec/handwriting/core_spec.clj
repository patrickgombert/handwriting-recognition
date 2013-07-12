(ns handwriting.core-spec
  (:require [speclj.core :refer :all]
            [handwriting.core :as handwriting]))

(describe "handwriting recognition"

  (describe "squaring the difference"
    (it "takes two integer values and return the square of the difference"
      (should= 0 (handwriting/squared-difference 0 0))
      (should= 0 (handwriting/squared-difference 1 1))
      (should= 4 (handwriting/squared-difference 5 3))))

  (describe "finding the cartesian distance of two sequences"
    (it "finds no difference for empty items"
      (should= 0 (handwriting/distance [] [])))

    (it "finds a minimal difference"
      (should= 1 (handwriting/distance [0] [1])))

    (it "finds a difference for multiple points"
      (should= 27 (handwriting/distance [1 2 3] [4 5 6])))))
