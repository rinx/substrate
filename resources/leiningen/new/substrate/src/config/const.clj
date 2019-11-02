(ns {{name}}.config.const)

(def default-opts
  {:rest-api
   {:name "REST API"
    :port 8080
    :prestop-duration 10}
   :health
   {:name "Health"
    :port 8081
    :prestop-duration 10}})

(def cli-header "Usage: {{name}} [options]")
(def cli-options
  [["-f" "--file PATH" "config"
    :id :config-filename
    :default "config.edn"]
   ["-h" "--help" :id :help?]])
