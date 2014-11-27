(ns my-watch-list.web
  (:use ring.middleware.params
        ring.util.response
        ring.adapter.jetty
        )
   (:require [my-watch-list.core :refer :all]
            )
  )

;a method for testing client purpose
(defn fake-page-body
  [name]
  (do 
    (Thread/sleep (* 6 1000))
    (str "{\"gender\":[\"女款\",\"女鞋\"],\"price\":[\"180.0\",\"1.0\",\"2.3\",\"278.00\",\"915.00\"],\"size\":[\"39\",\"37\",\"38\",\"36\"],\"color\":[\"绿白红\",\"蓝白绿\",\"灰绿蓝\"]}")))

(defn handler 
  [{{name "uri-string"} :params, uri :uri}]
  (if (= "/extractor" uri)
  (-> (response (page-body name)) ;(fake-page-body name) or (page-body name)
      (content-type "application/json")
      (charset "gb2312")
      (header "Access-Control-Allow-Origin" "*")
      )
  (-> (response "PAGE not found ...")
      (status 404)))
  )

(def app
  (-> handler wrap-params))

(run-jetty app {:port 8080})