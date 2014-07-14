(ns modern-cljs.shopping
  (:require [domina :as dom]
            [domina.events :as ev]))

(defn calculate
  []
  (let [quantity (dom/value (dom/by-id "quantity"))
        price (dom/value (dom/by-id "price"))
        tax (dom/value (dom/by-id "tax"))
        discount (dom/value (dom/by-id "discount"))
        total (-> (* quantity price)
                  (* (+ 1 (/ tax 100)))
                  (- discount)
                  (.toFixed 2))]
    (dom/set-value! (dom/by-id "total") total)))

(defn ^:export init
  []
  (if (and js/document
           (.-getElementById js/document))
    (ev/capture! (dom/by-id "calc") :click calculate)))

