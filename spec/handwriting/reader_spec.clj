(ns handwriting.reader-spec
  (:require [speclj.core :refer :all]
            [handwriting.reader :as reader]))

(describe "reading csvs"

  (describe "creating the map"
    (it "produces a map from a seq"
      (should= {[1 2 3] 1 [4 5 6] 4} (reader/make-map [[1 1 2 3] [4 4 5 6]]))))

  (describe "text conversion"
    (it "converts lines of strings to int lines"
      (should= [[1 2 3] [4 5 6]] (reader/parse-character-lines ["1,2,3" "4,5,6"])))))
