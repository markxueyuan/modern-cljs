(ns modern-cljs.shopping
  (:use [domina :only [by-id value set-value!]]))

(defn calculate
  []
  (let [quantity (value (by-id "quantity"))
        price (value (by-id "price"))
        tax (value (by-id "tax"))
        discount (value (by-id "discount"))
        total (-> (* quantity price)
                  (* (+ 1 (/ tax 100)))
                  (- discount)
                  (.toFixed 2))]
    (set-value! (by-id "total") total)
    false))

(defn init
  []
  (if (and js/document
           (.-getElementById js/document))
    (let [theForm (.getElementById js/document "shoppingForm")]
      (set! (.-onSubmit theForm) calculate))))

(set! (.-onLoad js/window) init)
