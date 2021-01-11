package de.maaxgr.kotlinutils.extensions

sealed class FindFirstResult {
    object NoMatch : FindFirstResult()
    data class SingleMatch(val match: String, val groups: List<String>) : FindFirstResult()
}

sealed class FindAllResult {
    object NoMatch : FindAllResult()
    data class MultiMatch(val matchGroups: Map<String, List<String>>) : FindAllResult()
}