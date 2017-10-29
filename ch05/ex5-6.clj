(map (fn [x] (.getBytes x)) ["amit" "rob" "kyle"])

(map #(.getBytes %) ["amit" "rob" "kyle"])

(memfn getBytes)

(memfn ^String getBytes)

(map (memfn getBytes) ["amit" "rob" "kyle"])

(.subSequence "Clojure" 2 5)
;=> "oju"

((memfn ^String subSequence ^Long start ^Long end) "Clojure" 2 5)
;=> "oju"


(bean (Calendar/getInstance))
; {:weeksInWeekYear 52, :timeZone #object[sun.util.calendar.ZoneInfo 0x196f221 "sun.util.calendar.ZoneInfo[id=\"Asia/Seoul\",offset=32400000,dstSavings=0,useDaylight=false,transitions=22,lastRule=null]"], :weekDateSupported true, :weekYear 2017, :lenient true, :time #inst "2017-10-26T14:56:26.101-00:00", :calendarType "gregory", :timeInMillis 1509029786101, :class java.util.GregorianCalendar, :firstDayOfWeek 1, :gregorianChange #inst "1582-10-15T00:00:00.000-00:00", :minimalDaysInFirstWeek 1}


(def tokens (.split "clojure.in.action" "\\."))
