(ns four-clojure.practice)

(def earth {:name       "Earth"
            :moons      1
            :volume     1.08321e21                          ;; km^3
            :mass       5.97219e24                          ;; kg
            :aphelion   152098232                           ;; km, farthest from sun
            :perihelion 147098290                           ;; km, closest to sun
            :type       :Planet                             ;; entity type
            })

(defrecord Planet [name
                   moons
                   volume                                   ;; km^3
                   mass                                     ;; kg
                   aphelion                                 ;; km, farthest from sun
                   perihelion                               ;; km, closest to sun
                   ])

(def earth (->Planet "Earth" 1 1.08321e21 5.97219e24 152098232 147098290))
(def earth-map (map->Planet {:name       "Earth"
                         :moons      1
                         :volume     1.08321e21                          ;; km^3
                         :mass       5.97219e24                          ;; kg
                         :aphelion   152098232                           ;; km, farthest from sun
                         :perihelion 147098290                           ;; km, closest to sun
                         :type       :Planet                             ;; entity type
                         }))

