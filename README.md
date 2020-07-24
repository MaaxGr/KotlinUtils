
# BashUtil

## executeCommand()

* Execute a bash command
* Possibility to handle each output line
* Possibility to handle complete output result.
* No Deadlock => executeCommand() can handle huge output


### Example:
````kotlin
val result = BashUtil.executeCommand("echo 'Hello World'") { line ->
    // handle read line. e.g. print it out
    println(line)
}

// result is the complete output string
println(result)
````

# RegexExtensions

* Get Regex-Group


### Example:
````kotlin
val versionTagString = Regex("gitlab\\/gitlab-ce:(.+)")
    .getGroupValueFor(dockerComposeContent, 1)
````