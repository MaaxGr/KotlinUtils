package de.maaxgr.kotlinutils.extensions

class MRegex(private val pattern: String) {

    private val regex = Regex(pattern)


    fun findFirst(input: String): FindFirstResult {
        val match = regex.find(input) ?: return FindFirstResult.NoMatch

        val groups = match.destructured.toList()

        return FindFirstResult.SingleMatch(match.value, groups)
    }

    fun findAll(input: String): FindAllResult {
        val matches = regex.findAll(input).toList()

        if (matches.isEmpty()) {
            return FindAllResult.NoMatch
        }

        val matchGroupMapping = matches.map {
            it.value to it.destructured.toList()
        }.toMap()

        return FindAllResult.MultiMatch(matchGroupMapping)
    }

}