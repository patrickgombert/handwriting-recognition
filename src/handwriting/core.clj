(ns handwriting.core
  (:require [handwriting.reader :as reader]))

(declare training-set)

(defn squared-difference [cell1 cell2]
  (let [difference (- cell1 cell2)]
    (* difference difference)))

(defn distance [image1 image2]
  (reduce + (map squared-difference image1 image2)))

(defn- training-set []
  (reader/read-set ("data/digitssample.csv")))

(defn- test-set []
  (reader/read-set ("data/digitscheck.csv")))
