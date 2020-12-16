package de.maaxgr.kotlinutils.extensions

class MRegex(private val pattern: String) {

    private val regex = Regex(pattern)

    fun findFirst(input: String): FindFirstResult {

        if (!regex.matches(input)) {
            return FindFirstResult.NoMatch
        }

        val match = regex.find(input)!!
        val groups = match.destructured.toList()

        return FindFirstResult.SingleMatch(groups)
    }

    fun findAll(input: String): FindAllResult {
        if (!regex.matches(input)) {
            return FindAllResult.NoMatch
        }

        val matches = regex.findAll(input).toList()

        val matchGroupMapping = matches.map {
            it.value to it.destructured.toList()
        }.toMap()

        return FindAllResult.MultiMatch(matchGroupMapping)
    }

}