(defproject tervorz/data-scope "0.1.3"
  :description "Tools for interactively examining data."
  :url "https://github.com/tervorz/data-scope"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 ;; explicit include to remedy CVE-2020-15250 in incanter-core
                 [junit "4.13.1"]
                 [incanter/incanter-core "1.9.3" :exclusions [junit]]
                 [incanter/incanter-charts "1.9.3"]
                 [hashp "0.2.0"]
                 [rhizome "0.2.9"]
                 [mvxcvi/puget "1.3.1"]
                 [org.clojure/core.cache "1.0.207"]]
  :plugins [[lein-cloverage "1.1.1"]
            [lein-nvd "1.3.1"]]
  :profiles {:repl {:dependencies [[org.clojure/tools.namespace "1.1.0"]]}})
