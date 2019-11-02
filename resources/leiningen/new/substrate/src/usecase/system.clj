(ns {{name}}.usecase.system
  (:require
   [com.stuartsierra.component :as component]
   [{{name}}.service.server :as server]
   [{{name}}.service.router :as router]
   [{{name}}.service.health :as health]
   [{{name}}.handler.rest :as handler-rest]))

(defn system [{:keys [rest-api health cancel-ch] :as conf}]
  (component/system-map
   :handler-rest (handler-rest/start-handler {})
   :router (component/using
            (router/start-router {})
            {:handler :handler-rest})
   :health-router (health/start-health)
   :server (component/using
            (server/start-server rest-api)
            {:router :router})
   :health (component/using
            (server/start-server health)
            {:router :health-router
             :rest-server :server})))
