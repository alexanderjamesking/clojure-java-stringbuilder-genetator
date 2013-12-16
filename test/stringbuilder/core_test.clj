(ns stringbuilder.core-test
  (:require [clojure.test :refer :all]
            [stringbuilder.core :refer :all]))

(deftest a-test
  (testing "wrap line"
    (is (= "sb.append(\"foo\");\n" (wrap-line "foo")))))
