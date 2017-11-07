(defrecord NewExpense [date amount-dollars amount-cents category
                       merchant-name])


(NewExpense. "2010-04-01" 29 95 "gift" "1-800-flowers")
;=> #user.NewExpense{:date "2010-04-01", :amount-dollars 29, :amount-cents 95, :category "gift", :merchant-name "1-800-flowers"}



