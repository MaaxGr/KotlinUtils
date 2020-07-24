package de.maaxgr.kotlinutils.extensions

/**
 * Returns a regex group for given string on regex
 *
 * @param string String to search in
 * @param groupIndex Number of the group in regex
 *
 */
fun Regex.getGroupValueFor(string: String, groupIndex: Int): String? {
    return find(string)?.groupValues?.get(groupIndex)
}