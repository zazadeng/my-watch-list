(ns my-watch-list.classifier)

(def color-reg #"[灰蓝绿白红]+")
(def size-reg #"\"\s*[34][0-9]\s*\"")
(def price-reg #"[1-9]\d*\.\d+")
(def gender-reg #"[女男].")

(def action 
  {:shopping 
   { :color color-reg
     :size size-reg
     :price price-reg
     :gender gender-reg
    }
   }
)

(defn extract-words [key data]
  (map (fn [reg-map-entry](into #{} (re-seq (val reg-map-entry) (str data))))(key action))
  )