(ns handwriting.reader
  (:require [clojure.string :as str]
            [clojure.java.io :as io]))

(defn make-map [lines]
  (reduce (fn [acc item]
             (assoc acc
                (rest item)
                (first item)))
                {} lines))

(defn parse-character-lines [lines]
  (pmap (fn [line] (map (fn [character] (Long/parseLong character)) (str/split line #","))) lines))

(defn read-csv [file]
  (with-open [reader (io/reader file)]
    (let [lines (rest (line-seq reader))]
      (make-map (parse-character-lines lines)))))

