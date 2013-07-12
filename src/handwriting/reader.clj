(ns handwriting.reader
  (:require [clojure.java.io :as io]))

(defn make-map [rows]
  (reduce (fn [acc item] (assoc acc (rest item) (first item))) {} rows))

(defn read-set [file-name]
  (with-open [file (io/reader file-name)]
    (let [file-stream (line-seq file)]
      (make-map (rest file-stream)))))

