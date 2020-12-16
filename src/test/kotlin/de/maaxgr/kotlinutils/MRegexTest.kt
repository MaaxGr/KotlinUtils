package de.maaxgr.kotlinutils

import de.maaxgr.kotlinutils.extensions.MRegex
import de.maaxgr.kotlinutils.extensions.FindFirstResult
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.net.InetSocketAddress

class MRegexTest {

    @Test
    fun test() {
        var socketAddress: InetSocketAddress? = null

        val regex = MRegex("http:\\/\\/([a-z0-9-\\.]+):(\\d+)")
        val analze = regex.findFirst("http://my.test.com:3128")

        if (analze is FindFirstResult.SingleMatch) {
            val (hostname: String, port: String) = analze.groups
            socketAddress = InetSocketAddress(hostname, port.toInt())
        }

        Assertions.assertEquals(3128, socketAddress!!.port)
        Assertions.assertEquals("my.test.com", socketAddress.hostName)
    }






}