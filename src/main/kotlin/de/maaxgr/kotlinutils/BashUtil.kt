package de.maaxgr.kotlinutils

import java.io.BufferedReader
import java.io.InputStreamReader

object BashUtil {

    /**
     * Execute a bash command.
     * @param cmd bash command that will be executed
     * @param lineCallback callback function that is called, when a single line is read
     *
     * Example: executeCommand("echo 'Hello World'", System.out::println)
     * => Prints the result of the command to the commandline
     *
     * @return result of the command as a complete string
     */
    fun executeCommand(cmd: String, lineCallback: (String) -> Unit = {}): String {
        val commands = listOf("bash", "-c", cmd)

        val pb: ProcessBuilder = ProcessBuilder(commands)
                .redirectErrorStream(true)

        val process = pb.start()

        val result = StringBuilder(80)
        BufferedReader(InputStreamReader(process.inputStream)).use { input ->
            while (true) {
                val line = input.readLine() ?: break
                lineCallback(line)
                result.append(line).append(System.lineSeparator())
            }
        }
        return result.toString()
    }

    fun test() {

        val result = BashUtil.executeCommand("echo 'Hello World'") { line ->
            // handle read line. e.g. print it out
            println(line)
        }

        // result is the complete output string
        println(result)

    }

}