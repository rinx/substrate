(ns leiningen.new.substrate
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "substrate"))

(defn substrate
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' substrate project.")
    (->files data
             [".gitignore" (render "gitignore" data)]
             ["LICENSE" (render "LICENSE" data)]
             ["README.md" (render "README.md" data)]
             ["Dockerfile" (render "Dockerfile" data)]
             ["project.clj" (render "project.clj" data)]
             [".github/workflows/docker.yml" (render "github/workflows/docker.yml" data)]
             ["dev/user.clj" (render "dev/user.clj" data)]
             ["dev/dev.clj" (render "dev/dev.clj" data)]
             ["src/{{sanitized}}/core.clj" (render "src/core.clj" data)]
             ["src/{{sanitized}}/config/const.clj" (render "src/config/const.clj" data)]
             ["src/{{sanitized}}/handler/rest.clj" (render "src/handler/rest.clj" data)]
             ["src/{{sanitized}}/service/health.clj" (render "src/service/health.clj" data)]
             ["src/{{sanitized}}/service/router.clj" (render "src/service/router.clj" data)]
             ["src/{{sanitized}}/service/server.clj" (render "src/service/server.clj" data)]
             ["src/{{sanitized}}/usecase/system.clj" (render "src/usecase/system.clj" data)]
             ["resources/config.edn" (render "resources/config.edn" data)])))
