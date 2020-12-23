# Change Log

## [Unreleased]

## [0.1.3] - 2020-12-23 (forked from jsofra/data-scope)
### Added
- Previously unreleased support for thread-first and thread-last `pp` macros (`ds/pp->` and `ds/pp->>`), with new unit tests.
- Combined all namespaces into one all-encompassing, easy-to-utilize namespace for quick debugging: `ds`
- Created shorter, un-namespaced versions of the `pp` macros. (Not technically Clojure best practice, but practical for a debug tool.)
- Added namespace, line number, and output of the original inspected form to the `pp` macros.
- Revved all the dependency versions.

## [0.1.2] - 2016-20-13
### Fixed
- For ref types return the ref instance not the data.

## [0.1.1] - 2016-20-12
### Added
- Support for tagging reference types (atom, agent, var, ref) with chart tags.
  * When tagged a watch will be added to update the chart data on state change.

### Fixed
- All tags now only eval the form once.

## 0.1.0 - 2016-09-25
### Added
- Initial Release!

[Unreleased]: https://github.com/jsofra/data-scope/compare/0.1.3...HEAD
[0.1.3]: https://github.com/tervorz/data-scope/compare/0.1.2..0.1.3
[0.1.2]: https://github.com/tervorz/data-scope/compare/0.1.1...0.1.2
[0.1.1]: https://github.com/tervorz/data-scope/compare/0.1.0...0.1.1
[0.1.0]: https://github.com/tervorz/data-scope/compare/0.1.0-SNAPSHOT...0.1.0
