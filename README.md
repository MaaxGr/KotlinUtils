
# BashUtil

## Install via Gradle

```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

```
dependencies {
    implementation 'com.github.MaaxGr:KotlinUtils:Tag'
}
```


## Code Examples

### BashUtil.executeCommand()

* Execute a bash command
* Possibility to handle each output line
* Possibility to handle complete output result.
* No Deadlock => executeCommand() can handle huge output

````kotlin
val result = BashUtil.executeCommand("echo 'Hello World'") { line ->
    // handle read line. e.g. print it out
    println(line)
}

// result is the complete output string
println(result)
````

### MRegex

* `findFirst(input: String)` find first match for input on regex 
* `findAll(input: String)` find all matches for input on regex 
 
````kotlin
val regex = MRegex("http:\\/\\/([a-z0-9-\\.]+):(\\d+)")
val analze = regex.findFirst("http://my.test.com:3128")

if (analze is FindFirstResult.SingleMatch) {
    val (hostname: String, port: String) = analze.groups
    println("Host: $hostname; Port $port")
}
````

### StringExtensions

* `camelToSnakeCase()`
* `snakeToUpperCamelCase()`
* `snakeToLowerCamelCase()`