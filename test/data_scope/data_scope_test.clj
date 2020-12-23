(ns data-scope.data-scope-test
  (:require
   [clojure.string :as str]
   [clojure.test :refer :all]
   [ds :refer :all]
   [puget.printer :as pugprint]))

(def counter (atom 0))
(def printed-values (atom []))

(defn bump []
  (swap! counter inc))

(defn make-eval-str
  "Takes some code `data`, adds an increment to `counter`, and puts the
  `tagged-literal` in front. Optionally, if testing something that requires
  the `tagged-literal` to go somewhere in the middle of the `data`, then will
  replace instances of `mock-reader` in `data` with the `tagged-literal` rather
  than prepending it to the front. (Useful for testing the pprints for
  thread-first and thread-last reader literals.)"
  [tagged-literal data]
  (let [data-str (str "(do (" #'bump ") " data ")")
        literal-str (str "#" (symbol tagged-literal))]
    (if (str/includes? data-str "mock-literal")
      (str/replace data-str #"mock-literal" literal-str)
      (str literal-str " " data-str))))

(defn no-op [& _]
  nil)

(defn mock-literal
  "Placeholder used in thread-first and thread-last tests so that the reader
  literal can be put into the middle of the form even though it doesn't get
  defined until later in the test. It is replaced by the real reader literal
  in `make-eval-str`. Assumes that a thread-first will pass only one argument
  and a thread-last test will pass two, and just returns what was passed in."
  [& args]
  (if (= 1 (count args))
    (first args)
    (second args)))

(defn mocked-pprint [arg]
  (swap! printed-values conj arg)
  nil)

(defn eval! [form-str]
  (eval (read-string form-str)))

(defmacro def-eval-once-test [tagged-literal fname data]
  (let [test-name (symbol (str (symbol fname) "-eval-once-test"))]
    `(deftest ~test-name
       (binding [*data-readers* {(quote ~tagged-literal) ~fname}]
         (testing (str ~fname " evaluates form exactly once")
           (let [str# (make-eval-str (quote ~tagged-literal) ~data)]
             (reset! counter 0)
             (with-redefs [clojure.inspector/inspect-table no-op
                           clojure.inspector/inspect-tree no-op
                           clojure.pprint/pprint no-op
                           clojure.pprint/print-table no-op
                           ds/view-dot no-op
                           ds/view-graph no-op
                           ds/view-tree* no-op
                           ds/view-chart no-op
                           puget.printer/cprint no-op
                           println no-op]
               (eval! str#))
             (is (= @counter 1))))))))

;; TODO: combine the two testing macros and spruce up the tests below to
;; also validate the pretty-printed values, the resulting evaluated forms,
;; and the new printed function and line number info
(defmacro def-eval-literal [tagged-literal fname value-expected print-expected data]
  (let [test-name    (symbol (str (symbol fname) "-test"))]
    `(deftest ~test-name
       (binding [*data-readers* {(quote ~tagged-literal) ~fname}]
         (let [str# (make-eval-str (quote ~tagged-literal) (quote ~data))]
           (with-redefs [pugprint/cprint            mocked-pprint
                         clojure.pprint/print-table mocked-pprint
                         println                    no-op]
             (testing (str ~fname " works as expected")
               (reset! printed-values [])
               (reset! counter 0)
               (let [result# (eval! str#)]
                 (is (= ~data result#))
                 (is (= ~value-expected result#))
                 (is (= ~print-expected (first @printed-values)))
                 (is (= 1 @counter))))))))))

(def-eval-once-test ds/b scope-bar [1 2])
(def-eval-once-test ds/b-sum scope-bar-sum {:a 1 :b 2})
(def-eval-once-test ds/b-sum* scope-bar-sum* {:a 1 :b 2})
(def-eval-once-test ds/b-max scope-bar-max {:a 1 :b 2})
(def-eval-once-test ds/b-max* scope-bar-max* {:a 1 :b 2})
(def-eval-once-test ds/b-min scope-bar-min {:a 1 :b 2})
(def-eval-once-test ds/b-min* scope-bar-min* {:a 1 :b 2})

(def-eval-once-test ds/l scope-line {:a 1 :b 2})
(def-eval-once-test ds/l-sum scope-line-sum {:a 1 :b 2})
(def-eval-once-test ds/l-sum* scope-line-sum* {:a 1 :b 2})
(def-eval-once-test ds/l-max scope-line-max {:a 1 :b 2})
(def-eval-once-test ds/l-max* scope-line-max* {:a 1 :b 2})
(def-eval-once-test ds/l-min scope-line-min {:a 1 :b 2})
(def-eval-once-test ds/l-min* scope-line-min* {:a 1 :b 2})

(def-eval-once-test ds/a scope-area {:a 1 :b 2})
(def-eval-once-test ds/a-sum scope-area-sum {:a 1 :b 2})
(def-eval-once-test ds/a-sum* scope-area-sum* {:a 1 :b 2})
(def-eval-once-test ds/a-max scope-area-max {:a 1 :b 2})
(def-eval-once-test ds/a-max* scope-area-max* {:a 1 :b 2})
(def-eval-once-test ds/a-min scope-area-min {:a 1 :b 2})
(def-eval-once-test ds/a-min* scope-area-min* {:a 1 :b 2})

(def-eval-once-test ds/sa scope-stacked-area {:a 1 :b 2})
(def-eval-once-test ds/sa-sum scope-stacked-area-sum {:a 1 :b 2})
(def-eval-once-test ds/sa-sum* scope-stacked-area-sum* {:a 1 :b 2})
(def-eval-once-test ds/sa-max scope-stacked-area-max {:a 1 :b 2})
(def-eval-once-test ds/sa-max* scope-stacked-area-max* {:a 1 :b 2})
(def-eval-once-test ds/sa-min scope-stacked-area-min {:a 1 :b 2})
(def-eval-once-test ds/sa-min* scope-stacked-area-min* {:a 1 :b 2})

(def-eval-once-test ds/p scope-pie {:a 1 :b 2})
(def-eval-once-test ds/p-sum scope-pie-sum {:a 1 :b 2})
(def-eval-once-test ds/p-sum* scope-pie-sum* {:a 1 :b 2})
(def-eval-once-test ds/p-max scope-pie-max {:a 1 :b 2})
(def-eval-once-test ds/p-max* scope-pie-max* {:a 1 :b 2})
(def-eval-once-test ds/p-min scope-pie-min {:a 1 :b 2})
(def-eval-once-test ds/p-min* scope-pie-min* {:a 1 :b 2})

(def-eval-once-test ds/graph scope-graph {:a [:b :c] :b [:c] :c [:a]})
(def-eval-once-test ds/tree scope-tree {:a 1 :b 2})
(def-eval-once-test ds/trie scope-trie {:a 1 :b 2})
(def-eval-once-test ds/dot scope-dot {:a 1 :b 2})

(def-eval-once-test ds/pp scope-pprint {:a 1 :b 2})
(def-eval-once-test ds/pt scope-print-table [{:a 1 :b 2} {:a 3 :b 4}])

(def-eval-once-test ds/i scope-inspect-tree {:a 1 :b 2})
(def-eval-once-test ds/it scope-inspect-table [{:a 1 :b 2} {:a 3 :b 4}])

(def-eval-literal ds/pp
  scope-pprint 2 2
  (+ 1 1))

(def-eval-literal ds/pp->
  scope-pprint-thread-first 2 3
  (-> 4
      mock-literal (- 1)
      dec))

(def-eval-literal ds/pp->>
  scope-pprint-thread-last 0 1
  (->> 4
       mock-literal (- 5)
       dec))

(def-eval-literal ds/t->
  scope-print-table-thread-first
  {:a 1 :b 2}
  [{:a 1 :b 2} {:a 3 :b 4}]
  (-> [{:a 1 :b 2}]
      mock-literal (conj {:a 3 :b 4})
      first))

(def-eval-literal ds/t->>
  scope-print-table-thread-last
  {:a 1 :b 2}
  [{:a 1 :b 2} {:a 3 :b 4}]
  (->> {:a 3 :b 4}
       mock-literal (conj [{:a 1 :b 2}])
       first))
