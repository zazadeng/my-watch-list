(ns my-watch-list.core
  (:import (java.io PushbackReader InputStreamReader FileInputStream))
  (:use my-watch-list.classifier
        hickory.core
        )
  (:require [clj-http.client]
            [hickory.select :as st]
            [clojure.data.json :as json]
            [clojure.edn :as ed]
            ))

(defn get-content-array
  ([vals]
     (get-content-array vals []))
  ([vals accumulating]
     (if (empty? vals)
       accumulating
       (recur (rest vals) (let[e (first vals)
                               c (:content e)] (if (nil? c) 
                                                 (conj accumulating e) 
                                                 (get-content-array c accumulating)))))))
(defn get-content-keyword [uri site-infos]
  (reduce (fn[s e] 
            (if (re-find (re-pattern(key e)) uri ) (:content-tag (val e)) s)) "" site-infos))

(defn get-site-action [site site-infos]
  (reduce (fn[s e] 
            (if (re-find (re-pattern(key e)) site ) (:action (val e)) s)) "" site-infos))
 
;(page-body "http://product.dangdang.com/1104552925.html")
;(page-body "http://www.ncix.com/detail/samsung-u28d590d-28in-4k-uhd-c5-95635-1370.htm")
(defn page-body [uri-string]
  (if (or (nil? uri-string) (= "" (clojure.string/trim uri-string)))
         ;dont extract
         (str "{}")
         ;start extraction
         (let [site-infos (ed/read (PushbackReader. (InputStreamReader. (FileInputStream. "sites.edn") "UTF-8")))
               site-action (keyword (get-site-action uri-string site-infos))
               site-htree (-> (clj-http.client/get uri-string {:as "gb2312"}) :body parse as-hickory)
               sel-form-string (str "(" "hickory.select/" (get-content-keyword uri-string site-infos) ")") ; based on the given dynamic tag 
               selector (st/child (eval (ed/read-string sel-form-string)))
               contents (get-content-array (st/select selector site-htree))
               ]
           
           (println "processing >>> " uri-string)
          (json/write-str 
            (->> 
              (map (fn [str] (extract-words site-action str)) contents)
              (reduce (fn[e1 e2] (map into e1 e2)))
              (zipmap (keys (:shopping action))))
            :escape-unicode false  ;chinese char shows
            :value-fn (fn[k v] (map (fn[e](clojure.string/replace e "\"" "")) v)); remove all double quotes  
           ))))
;expected result:
;"{\"gender\":[\"女款\",\"女鞋\"],\"price\":[\"100.0\",\"698.00\",\"258.00\",\"495.00\",\"5.8\",\"249.127\"],\"size\":[\"39\",\"37\",\"38\",\"36\"],\"color\":[\"绿白红\",\"蓝白绿\",\"灰绿蓝\"]}"
