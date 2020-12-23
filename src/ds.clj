(ns ds
  "Simple namespace with an abbreviated name for quick use during debugging. The
  namespace is split among four separate files, similar to the clojure.core
  source. The source files rely on the requires in this primary file, but those
  files can't use the dependency aliases using `:as`, so most of the aliases are
  omitted below."
  (:require
   [clojure.core.cache]
   [clojure.inspector]
   [clojure.pprint :as pprint]
   [clojure.string :as str]
   [clojure.walk]
   [hashp.core :as hashp]
   [incanter.charts]
   [incanter.core]
   [puget.printer]
   [rhizome.viz]))

(defn current-trace []
  (let [{:keys [ns fn line]}
        (->> (hashp/current-stacktrace)
             (filter :clojure)
             (remove (comp (partial = "ds") :ns))
             first)]
    (if (and ns fn line)
      (format "[%s/%s:%s]" ns fn line)
      "[location unknown]")))

(defn location-line-and-form
  "Prints the namespace, fn, and line where the literal was placed, and also
  prints the original form that is being inspected if it's different than the
  result of evaluating that form."
  [form evaluated]
  (if (not= evaluated form)
    (let [orig-form# (with-out-str (pprint/pprint form))]
      `~(println (current-trace)
                 (clojure.string/trim-newline (or orig-form# "")) ;; nil-safe
                 "=>"))
    `~(println (current-trace)
               "=>")))

(load "data_scope/charts")
(load "data_scope/graphs")
(load "data_scope/inspect")
(load "data_scope/pprint")
