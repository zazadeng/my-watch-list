(ns my-watch-list.core-test
  (:use midje.sweet) 
  (:require [clojure.test :refer :all]
            [my-watch-list.core :refer :all]
            ))

(fact "1:test shopping catagory"
      (let [data "var prdJson = {\"prd\":[ {\"prdid\":\"1104552925\",\"itemid\":\"1104553025\",\"color\":\"女款 蓝白绿\",\"size\":\"36\",\"num_image\":\"1\",\"image\":\"http://img35.ddimg.cn/26/17/1104553025-1_h.jpg\",\"salePrice\":\"278.00\",\"OriginalPrice\":\"1193\",\"discount\":\"2.3\",\"economy\":\"915.00\",\"vipPrice\":\"278.00\",\"points\":\"0\",\"color_index\":\"0\",\"size_index\":\"0\",\"isChange\":\"wrong\",\"product_type\":\"88\"},{\"prdid\":\"1104552925\",\"itemid\":\"1104553125\",\"color\":\"女款 蓝白绿\",\"size\":\"37\",\"num_image\":\"1\",\"image\":\"http://img35.ddimg.cn/27/6/1104553125-1_h.jpg\",\"salePrice\":\"278.00\",\"OriginalPrice\":\"1193\",\"discount\":\"2.3\",\"economy\":\"915.00\",\"vipPrice\":\"278.00\",\"points\":\"0\",\"color_index\":\"0\",\"size_index\":\"0\",\"isChange\":\"wrong\",\"product_type\":\"88\"},{\"prdid\":\"1104552925\",\"itemid\":\"1104553225\",\"color\":\"女款 蓝白绿\",\"size\":\"38\",\"num_image\":\"1\",\"image\":\"http://img35.ddimg.cn/28/32/1104553225-1_h.jpg\",\"salePrice\":\"278.00\",\"OriginalPrice\":\"1193\",\"discount\":\"2.3\",\"economy\":\"915.00\",\"vipPrice\":\"278.00\",\"points\":\"0\",\"color_index\":\"0\",\"size_index\":\"0\",\"isChange\":\"wrong\",\"product_type\":\"88\"},{\"prdid\":\"1104552925\",\"itemid\":\"1104553325\",\"color\":\"女款 蓝白绿\",\"size\":\"39\",\"num_image\":\"1\",\"image\":\"http://img35.ddimg.cn/29/21/1104553325-1_h.jpg\",\"salePrice\":\"278.00\",\"OriginalPrice\":\"1193\",\"discount\":\"2.3\",\"economy\":\"915.00\",\"vipPrice\":\"278.00\",\"points\":\"0\",\"color_index\":\"0\",\"size_index\":\"0\",\"isChange\":\"wrong\",\"product_type\":\"88\"},{\"prdid\":\"1104552925\",\"itemid\":\"1104553425\",\"color\":\"女款 绿白红\",\"size\":\"36\",\"num_image\":\"1\",\"image\":\"http://img35.ddimg.cn/30/10/1104553425-1_h.jpg\",\"salePrice\":\"278.00\",\"OriginalPrice\":\"1193\",\"discount\":\"2.3\",\"economy\":\"915.00\",\"vipPrice\":\"278.00\",\"points\":\"0\",\"color_index\":\"0\",\"size_index\":\"0\",\"isChange\":\"wrong\",\"product_type\":\"88\"},{\"prdid\":\"1104552925\",\"itemid\":\"1104553525\",\"color\":\"女款 绿白红\",\"size\":\"37\",\"num_image\":\"1\",\"image\":\"http://img35.ddimg.cn/31/36/1104553525-1_h.jpg\",\"salePrice\":\"278.00\",\"OriginalPrice\":\"1193\",\"discount\":\"2.3\",\"economy\":\"915.00\",\"vipPrice\":\"278.00\",\"points\":\"0\",\"color_index\":\"0\",\"size_index\":\"0\",\"isChange\":\"wrong\",\"product_type\":\"88\"},{\"prdid\":\"1104552925\",\"itemid\":\"1104553625\",\"color\":\"女款 绿白红\",\"size\":\"38\",\"num_image\":\"1\",\"image\":\"http://img35.ddimg.cn/32/25/1104553625-1_h.jpg\",\"salePrice\":\"278.00\",\"OriginalPrice\":\"1193\",\"discount\":\"2.3\",\"economy\":\"915.00\",\"vipPrice\":\"278.00\",\"points\":\"0\",\"color_index\":\"0\",\"size_index\":\"0\",\"isChange\":\"wrong\",\"product_type\":\"88\"},{\"prdid\":\"1104552925\",\"itemid\":\"1104553725\",\"color\":\"女款 绿白红\",\"size\":\"39\",\"num_image\":\"1\",\"image\":\"http://img35.ddimg.cn/33/14/1104553725-1_h.jpg\",\"salePrice\":\"278.00\",\"OriginalPrice\":\"1193\",\"discount\":\"2.3\",\"economy\":\"915.00\",\"vipPrice\":\"278.00\",\"points\":\"0\",\"color_index\":\"0\",\"size_index\":\"0\",\"isChange\":\"wrong\",\"product_type\":\"88\"},{\"prdid\":\"1104552925\",\"itemid\":\"1104553825\",\"color\":\"女款 灰绿蓝\",\"size\":\"36\",\"num_image\":\"1\",\"image\":\"http://img35.ddimg.cn/34/3/1104553825-1_h.jpg\",\"salePrice\":\"278.00\",\"OriginalPrice\":\"1193\",\"discount\":\"2.3\",\"economy\":\"915.00\",\"vipPrice\":\"278.00\",\"points\":\"0\",\"color_index\":\"0\",\"size_index\":\"0\",\"isChange\":\"wrong\",\"product_type\":\"88\"},{\"prdid\":\"1104552925\",\"itemid\":\"1104553925\",\"color\":\"女款 灰绿蓝\",\"size\":\"37\",\"num_image\":\"1\",\"image\":\"http://img35.ddimg.cn/35/29/1104553925-1_h.jpg\",\"salePrice\":\"278.00\",\"OriginalPrice\":\"1193\",\"discount\":\"2.3\",\"economy\":\"915.00\",\"vipPrice\":\"278.00\",\"points\":\"0\",\"color_index\":\"0\",\"size_index\":\"0\",\"isChange\":\"wrong\",\"product_type\":\"88\"},{\"prdid\":\"1104552925\",\"itemid\":\"1104554025\",\"color\":\"女款 灰绿蓝\",\"size\":\"38\",\"num_image\":\"1\",\"image\":\"http://img35.ddimg.cn/36/18/1104554025-1_h.jpg\",\"salePrice\":\"278.00\",\"OriginalPrice\":\"1193\",\"discount\":\"2.3\",\"economy\":\"915.00\",\"vipPrice\":\"278.00\",\"points\":\"0\",\"color_index\":\"0\",\"size_index\":\"0\",\"isChange\":\"wrong\",\"product_type\":\"88\"},{\"prdid\":\"1104552925\",\"itemid\":\"1104554125\",\"color\":\"女款 灰绿蓝\",\"size\":\"39\",\"num_image\":\"1\",\"image\":\"http://img35.ddimg.cn/37/7/1104554125-1_h.jpg\",\"salePrice\":\"278.00\",\"OriginalPrice\":\"1193\",\"discount\":\"2.3\",\"economy\":\"915.00\",\"vipPrice\":\"278.00\",\"points\":\"0\",\"color_index\":\"0\",\"size_index\":\"0\",\"isChange\":\"wrong\",\"product_type\":\"88\"}]};"]
        (extract :shopping data)) 
      => '(#{"绿白红" "蓝白绿" "灰绿蓝"} #{"\"39\"" "\"37\"" "\"38\"" "\"36\""} #{"2.3" "278.00" "915.00"} #{"女款"})
   )

(fact "2:test shopping catagory"
      (let [data "纽巴伦 新款百搭英伦女鞋复古经典休闲跑步鞋574马尔代夫系列"]
        (extract :shopping data)) 
      => '(#{} #{} #{} #{"女鞋"})
   )

(fact "3:test shopping catagory"
      (let [data "{:type :element, :attrs {:id dp_presell}, :tag :span, :content nil}"]
        (extract :shopping data)) 
      => '(#{} #{} #{} #{})
   )

(fact "4:test shopping catagory"
      (let [data ""]
        (extract :shopping data)) 
      => '(#{} #{} #{} #{})
   )

(fact "5:test shopping catagory"
      (let [data "价格 评论 四级地区等信息展示区 begin "]
        (extract :shopping data)) 
      => '(#{} #{} #{} #{})
   )

(fact "6:test shopping catagory"
      (let [data "278.00"]
        (extract :shopping data)) 
      => '(#{} #{} #{"278.00"} #{})
   )

(fact "7:test shopping catagory"
      (let [data "var the_s = '190481';function inverseTime(){var limit_time = setInterval(Promotion.view_outlets_time,1000);};"]
        (extract :shopping data)) 
      => '(#{} #{} #{} #{})
   )
