(ns handwriting.core
  (:require [handwriting.reader :as reader]))

(def training-set (reader/read-csv "data/digitssample.csv"))

(defn squared-difference [cell1 cell2]
  (let [difference (- cell1 cell2)]
    (* difference difference)))

(defn distance [image1 image2]
  (reduce + (map squared-difference image1 image2)))

(defn distances-from [image]
  (reduce (fn [acc training-image]
            (conj acc
                   {:distance (distance image (key training-image)) :guess (val training-image)}))
          [] training-set))

(defn guess-from-top-n [image n]
  (let [top-matches (take n (sort-by :distance (distances-from image)))]
    (->> top-matches
      (map :guess)
      frequencies
      (sort-by val)
      reverse
      first
      first)))

