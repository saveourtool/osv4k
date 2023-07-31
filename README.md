# osv4k

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![GitHub release](https://img.shields.io/github/release/saveourtool/osv4k.svg)](https://github.com/saveourtool/osv4k/releases/)
[![Maven Central](https://img.shields.io/maven-central/v/com.saveourtool.osv4k/osv4k.svg)](https://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.saveourtool.osv4k%22)
[![javadoc](https://javadoc.io/badge2/com.saveourtool.osv4k/osv4k/javadoc.svg)](https://javadoc.io/doc/com.saveourtool.osv4k/osv4k)
[![Build](https://github.com/saveourtool/osv4k/actions/workflows/build.yml/badge.svg?branch=main)](https://github.com/saveourtool/osv4k/actions/workflows/build.yml?query=branch%3Amain)
[![Dependencies](https://github.com/saveourtool/osv4k/actions/workflows/dependencies.yml/badge.svg?branch=main)](https://github.com/saveourtool/osv4k/actions/workflows/dependencies.yml?query=branch%3Amain)

_Kotlin_ model for [OSV](https://ossf.github.io/osv-schema/) Schema.

This library is inspired by the tool [detekt/sarif4k](https://github.com/detekt/sarif4k).

See the [project website](https://saveourtool.github.io/osv4k/) for documentation and APIs.

## Features

- Support [_Kotlin Multiplatform_](https://kotlinlang.org/docs/multiplatform.html): _jvm_, _js_, _linuxX64_/_mingwX64_/_macosX64_.
- Support [_KotlinX Serialization_](https://github.com/Kotlin/kotlinx.serialization).
- Support [_Jackson annotations_](https://github.com/FasterXML/jackson-annotations) for _jvm_ target.

## Releases

The latest release is available from both _GitHub Packages_ and _Maven Central_.
For _GitHub Packages_, the repository can be added as follows.

For `build.gradle.kts`:

```kotlin
repositories {
    maven {
        name = "saveourtool/osv4k"
        url = uri("https://maven.pkg.github.com/saveourtool/osv4k")
        content {
            includeGroup("com.saveourtool.osv4k")
        }
        credentials {
            username = project.findProperty("gpr.user") as String? ?: System.getenv("GITHUB_ACTOR")
            password = project.findProperty("gpr.key") as String? ?: System.getenv("GITHUB_TOKEN")
        }
    }
}
```

For `settings.gradle.kts`:

```kotlin
dependencyResolutionManagement {
    repositories {
        maven {
            name = "saveourtool/osv4k"
            url = uri("https://maven.pkg.github.com/saveourtool/osv4k")
            content {
                includeGroup("com.saveourtool.osv4k")
            }
            credentials {
                username = providers.gradleProperty("gpr.user").orNull
                    ?: System.getenv("GITHUB_ACTOR")
                password = providers.gradleProperty("gpr.key").orNull
                    ?: System.getenv("GITHUB_TOKEN")
            }
        }
    }
}
```

Then add the dependency as usual:
  - Gradle
    ```kotlin
    dependencies {
        implementation("com.saveourtool.osv4k:osv4k:1.0.0")
    }
    ```
  - Maven
    ```xml
    <dependency>
        <groupId>com.saveourtool.osv4k</groupId>
        <artifactId>osv4k-jvm</artifactId>
        <version>1.0.0</version>
    </dependency>
    ```

## Database and ecosystem specific fields

_OSV Schema_ has extensions points for database and ecosystem specific fields:
1. The top level `database_specific`.
2. In the `affected[]` object:
   - `affected[].ecosystem_specific`;
   - `affected[].database_specific`.
3. `affected[].ranges[].database`.

_OSV4K Model_ implements it using generic type:
```kotlin
/**
 * @param D The top level `database_specific`.
 * @param A_E `affected[].ecosystem_specific`.
 * @param A_D `affected[].database_specific`.
 * @param A_R_D `affected[].ranges[].database_specific`.
 */
data class OsvSchema<D, A_D, A_E, A_R_D>
```

*Note #1*: these types should be serializable for selected engine.
*Note #2*: there is alias `com.saveourtool.osv4k.RawOsvSchema` for `KotlinX Serialization` which uses `kotlinx.serialization.json.JsonObject` as raw type.

## Usage
### Kotlin using _Kotlinx Serialization_:

```kotlin
import com.saveourtool.osv4k.*
import java.nio.file.Path
import kotlin.io.path.readText
import kotlinx.serialization.json.Json

fun readFromFile(pathToFile: Path) {
    val content = pathToFile.readText()
    val schema: RawOsvSchema = Json.decodeFromString(content)
    // do something with RawOsvSchema
}
```

### Java using _Jackson Annotations_:

```java
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;

class Test {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    static void readFromFile(final Path pathToFile) {
        final OsvSchema result = objectMapper.readValue(pathToFile.toFile(), OsvSchema.class);
        // do something with OsvSchema
    }
}
```
