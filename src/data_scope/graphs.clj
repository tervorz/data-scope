(in-ns 'ds)
(clojure.core/refer-clojure)

(defn view-graph [g]
  (rhizome.viz/view-graph
   (keys g) g
   :node->descriptor (fn [n]
                       {:label n})))

(defn view-tree* [t branch? label?]
  (rhizome.viz/view-tree
   branch? seq t
   :node->descriptor (fn [n] {:label (when (label? n) n)})))

(defn view-tree [t]
  (view-tree* t sequential? #(not (sequential? %))))

(defn view-trie [t]
  (view-tree* t list? vector?))

(def view-dot (comp rhizome.viz/view-image rhizome.viz/dot->image))

(defn ^:private graph-scope [f form] `(let [form# ~form] (~f form#) form#))

(defn scope-graph [form] (graph-scope `view-graph form))
(defn scope-tree  [form] (graph-scope `view-tree form))
(defn scope-trie  [form] (graph-scope `view-trie form))
(defn scope-dot   [form] (graph-scope `view-dot form))
