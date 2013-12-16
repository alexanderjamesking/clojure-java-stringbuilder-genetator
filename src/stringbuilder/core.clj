(ns stringbuilder.core)

(def mystring "<html>
  <div class=\"main\">
    some content
  </div>
</html>")

(defn escape-quotes 
  [s] 
  (clojure.string/replace s "\"" "\\\""))

(defn wrap-line 
  [s] 
  (str "sb.append(\"" (escape-quotes s) "\");\n"))

(defn wrap-lines
  [lines]
  (apply str (map wrap-line lines)))

(defn to-string-builder 
  [s]
  (let [prefix "StringBuilder sb = new StringBuilder();\n"
        lines  (clojure.string/split-lines s)
        suffix "String s = sb.toString();"]
    (str prefix (wrap-lines lines) suffix)))

;(println (to-string-builder mystring))