{
 ds/b      ds/scope-bar
 ds/b-sum  ds/scope-bar-sum
 ds/b-sum* ds/scope-bar-sum*
 ds/b-max  ds/scope-bar-max
 ds/b-max* ds/scope-bar-max*
 ds/b-min  ds/scope-bar-min
 ds/b-min* ds/scope-bar-min*

 ds/b!      ds/scope-bar-p
 ds/b-sum!  ds/scope-bar-sum-p
 ds/b-sum*! ds/scope-bar-sum*-p
 ds/b-max!  ds/scope-bar-max-p
 ds/b-max*! ds/scope-bar-max*-p
 ds/b-min!  ds/scope-bar-min-p
 ds/b-min*! ds/scope-bar-min*-p

 ds/b+      ds/scope-bar-a
 ds/b-sum+  ds/scope-bar-sum-a
 ds/b-sum*+ ds/scope-bar-sum*-a
 ds/b-max+  ds/scope-bar-max-a
 ds/b-max*+ ds/scope-bar-max*-a
 ds/b-min+  ds/scope-bar-min-a
 ds/b-min*+ ds/scope-bar-min*-a

 ds/l      ds/scope-line
 ds/l-sum  ds/scope-line-sum
 ds/l-sum* ds/scope-line-sum*
 ds/l-max  ds/scope-line-max
 ds/l-max* ds/scope-line-max*
 ds/l-min  ds/scope-line-min
 ds/l-min* ds/scope-line-min*

 ds/l!      ds/scope-line-p
 ds/l-sum!  ds/scope-line-sum-p
 ds/l-sum*! ds/scope-line-sum*-p
 ds/l-max!  ds/scope-line-max-p
 ds/l-max*! ds/scope-line-max*-p
 ds/l-min!  ds/scope-line-min-p
 ds/l-min*! ds/scope-line-min*-p

 ds/l+      ds/scope-line-a
 ds/l-sum+  ds/scope-line-sum-a
 ds/l-sum*+ ds/scope-line-sum*-a
 ds/l-max+  ds/scope-line-max-a
 ds/l-max*+ ds/scope-line-max*-a
 ds/l-min+  ds/scope-line-min-a
 ds/l-min*+ ds/scope-line-min*-a

 ds/a      ds/scope-area
 ds/a-sum  ds/scope-area-sum
 ds/a-sum* ds/scope-area-sum*
 ds/a-max  ds/scope-area-max
 ds/a-max* ds/scope-area-max*
 ds/a-min  ds/scope-area-min
 ds/a-min* ds/scope-area-min*

 ds/a!      ds/scope-area-p
 ds/a-sum!  ds/scope-area-sum-p
 ds/a-sum*! ds/scope-area-sum*-p
 ds/a-max!  ds/scope-area-max-p
 ds/a-max*! ds/scope-area-max*-p
 ds/a-min!  ds/scope-area-min-p
 ds/a-min*! ds/scope-area-min*-p

 ds/a+      ds/scope-area-a
 ds/a-sum+  ds/scope-area-sum-a
 ds/a-sum*+ ds/scope-area-sum*-a
 ds/a-max+  ds/scope-area-max-a
 ds/a-max*+ ds/scope-area-max*-a
 ds/a-min+  ds/scope-area-min-a
 ds/a-min*+ ds/scope-area-min*-a

 ds/sa      ds/scope-stacked-area
 ds/sa-sum  ds/scope-stacked-area-sum
 ds/sa-sum* ds/scope-stacked-area-sum*
 ds/sa-max  ds/scope-stacked-area-max
 ds/sa-max* ds/scope-stacked-area-max*
 ds/sa-min  ds/scope-stacked-area-min
 ds/sa-min* ds/scope-stacked-area-min*

 ds/sa!      ds/scope-stacked-area-p
 ds/sa-sum!  ds/scope-stacked-area-sum-p
 ds/sa-sum*! ds/scope-stacked-area-sum*-p
 ds/sa-max!  ds/scope-stacked-area-max-p
 ds/sa-max*! ds/scope-stacked-area-max*-p
 ds/sa-min!  ds/scope-stacked-area-min-p
 ds/sa-min*! ds/scope-stacked-area-min*-p

 ds/sa+      ds/scope-stacked-area-a
 ds/sa-sum+  ds/scope-stacked-area-sum-a
 ds/sa-sum*+ ds/scope-stacked-area-sum*-a
 ds/sa-max+  ds/scope-stacked-area-max-a
 ds/sa-max*+ ds/scope-stacked-area-max*-a
 ds/sa-min+  ds/scope-stacked-area-min-a
 ds/sa-min*+ ds/scope-stacked-area-min*-a

 ds/p      ds/scope-pie
 ds/p-sum  ds/scope-pie-sum
 ds/p-sum* ds/scope-pie-sum*
 ds/p-max  ds/scope-pie-max
 ds/p-max* ds/scope-pie-max*
 ds/p-min  ds/scope-pie-min
 ds/p-min* ds/scope-pie-min*

 ds/p!      ds/scope-pie-p
 ds/p-sum!  ds/scope-pie-sum-p
 ds/p-sum*! ds/scope-pie-sum*-p
 ds/p-max!  ds/scope-pie-max-p
 ds/p-max*! ds/scope-pie-max*-p
 ds/p-min!  ds/scope-pie-min-p
 ds/p-min*! ds/scope-pie-min*-p

 ds/p+      ds/scope-pie-a
 ds/p-sum+  ds/scope-pie-sum-a
 ds/p-sum*+ ds/scope-pie-sum*-a
 ds/p-max+  ds/scope-pie-max-a
 ds/p-max*+ ds/scope-pie-max*-a
 ds/p-min+  ds/scope-pie-min-a
 ds/p-min*+ ds/scope-pie-min*-a

 ds/hf ds/scope-histogram-frequency
 ds/hd ds/scope-histogram-density

 ds/graph ds/scope-graph
 ds/tree  ds/scope-tree
 ds/trie  ds/scope-trie
 ds/dot   ds/scope-dot

 ds/pp    ds/scope-pprint
 ds/pp->> ds/scope-pprint-thread-last
 ds/pp->  ds/scope-pprint-thread-first
 ds/pt    ds/scope-print-table
 ds/pt->> ds/scope-print-table-thread-last
 ds/pt->  ds/scope-print-table-thread-first

 ;; shorter versions for more commonly used ones
 pp    ds/scope-pprint
 pp->> ds/scope-pprint-thread-last
 pp->  ds/scope-pprint-thread-first

 ds/i     ds/scope-inspect-tree
 ds/i->>  ds/scope-inspect-tree-thread-last
 ds/i->   ds/scope-inspect-tree-thread-first
 ds/it    ds/scope-inspect-table
 ds/it->> ds/scope-inspect-table-thread-last
 ds/it->  ds/scope-inspect-table-thread-first}
