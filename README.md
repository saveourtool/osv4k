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
### Reading: Kotlin using _Kotlinx Serialization_:

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

### Reading: Java using _Jackson Annotations_:

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

### Generating: Kotlin using _KotlinX Serialization_:

```kotlin

@Serializable
data class GoImports(
    val imports: List<GoImport>,
)

@Serializable
data class GoImport(
    val path: String,
    val symbols: List<String>,
)

@Serializable
data class GoUrl(
    val url: String,
)

val osvSchema = OsvSchema<GoUrl, GoImports, Unit, Unit>(
    schemaVersion = "1.3.1",
    id = "GO-2020-0015",
    modified = LocalDateTime(2023, 6, 12, 18, 45, 41),
    published = LocalDateTime(2021, 4, 14, 20, 4, 52),
    aliases = listOf("CVE-2020-14040", "GHSA-5rcv-m4m3-hfh7"),
    summary = "Infinite loop when decoding some inputs in golang.org/x/text",
    details = "An attacker could provide a single byte to a UTF16 decoder instantiated with UseBOM or ExpectBOM to trigger an infinite loop if the String function on the Decoder is called, or the Decoder is passed to transform.String. If used to parse user supplied input, this may be used as a denial of service vector.",
    affected = listOf(
        Affected(
            `package` = Package(
                ecosystem = "Go",
                name = "golang.org/x/text",
            ),
            ranges = listOf(
                Range(
                    type = RangeType.SEMVER,
                    events = listOf(
                        Event(introduced = "0"),
                        Event(fixed = "0.3.3"),
                    ),
                ),
            ),
            ecosystemSpecific = GoImports(
                imports = listOf(
                    GoImport(
                        path = "golang.org/x/text/encoding/unicode",
                        symbols = listOf("bomOverride.Transform", "utf16Decoder.Transform"),
                    ),
                    GoImport(
                        path = "golang.org/x/text/transform",
                        symbols = listOf("String"),
                    ),
                ),
            ),
        )
    ),
    references = listOf(
        Reference(
            type = ReferenceType.FIX,
            url = "https://go.dev/cl/238238",
        ),
        Reference(
            type = ReferenceType.FIX,
            url = "https://go.googlesource.com/text/+/23ae387dee1f90d29a23c0e87ee0b46038fbed0e",
        ),
        Reference(
            type = ReferenceType.REPORT,
            url = "https://go.dev/issue/39491",
        ),
        Reference(
            type = ReferenceType.WEB,
            url = "https://groups.google.com/g/golang-announce/c/bXVeAmGOqz0",
        ),
    ),
    credits = listOf(
        Credit(name = "@abacabadabacaba"),
        Credit(name = "Anton Gyllenberg"),
    ),
    databaseSpecific = GoUrl(url = "https://pkg.go.dev/vuln/GO-2020-0015"),
)
```

### Generating: Java using _Jackson Annotations_

```java
package com.saveourtool.osv4k;

import kotlinx.datetime.LocalDateTime;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class GoExamples {
    private GoExamples() {}

    public static class GoImports {
        private final List<GoImport> imports;

        public GoImports(List<GoImport> imports) {
            this.imports = imports;
        }

        public List<GoImport> getImports() {
            return Collections.unmodifiableList(imports);
        }
    }

    public static class GoImport {
        private final String path;
        private final List<String> symbols;

        public GoImport(String path, List<String> symbols) {
            this.path = path;
            this.symbols = symbols;
        }

        public String getPath() {
            return path;
        }

        public List<String> getSymbols() {
            return Collections.unmodifiableList(symbols);
        }
    }

    public static class GoUrl {
        private final String url;

        public GoUrl(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }
    }

    public static OsvSchema<GoUrl, GoImports, Void, Void> go_2020_00115() {
        return new OsvSchema<GoUrl, GoImports, Void, Void>(
            "1.3.1",
            "GO-2020-0015",
            new LocalDateTime(2023, 6, 12, 18, 45, 41, 0),
            new LocalDateTime(2021, 4, 14, 20, 4, 52, 0),
            null,
            Arrays.asList("CVE-2020-14040", "GHSA-5rcv-m4m3-hfh7"),
            null,
            "Infinite loop when decoding some inputs in golang.org/x/text",
            "An attacker could provide a single byte to a UTF16 decoder instantiated with UseBOM or ExpectBOM to trigger an infinite loop if the String function on the Decoder is called, or the Decoder is passed to transform.String. If used to parse user supplied input, this may be used as a denial of service vector.",
            null,
            Arrays.asList(
                new Affected<GoImports, Void, Void>(
                    new Package(
                        "Go",
                        "golang.org/x/text",
                        null
                    ),
                    null,
                    Arrays.asList(
                        new Range<>(
                            RangeType.SEMVER,
                            null,
                            Arrays.asList(
                                new Event("0", null, null, null),
                                new Event(null, "0.3.3", null, null)
                            ),
                            null
                        )
                    ),
                    null,
                    new GoImports(
                        Arrays.asList(
                            new GoImport(
                                "golang.org/x/text/encoding/unicode",
                                Arrays.asList("bomOverride.Transform", "utf16Decoder.Transform")
                            ),
                            new GoImport(
                                "golang.org/x/text/transform",
                                Arrays.asList("String")
                            )
                        )
                    ),
                    null
                )
            ),
            Arrays.asList(
                new Reference(ReferenceType.FIX, "https://go.dev/cl/238238"),
                new Reference(ReferenceType.FIX, "https://go.googlesource.com/text/+/23ae387dee1f90d29a23c0e87ee0b46038fbed0e" ),
                new Reference(ReferenceType.REPORT, "https://go.dev/issue/39491"),
                new Reference(ReferenceType.WEB, "https://groups.google.com/g/golang-announce/c/bXVeAmGOqz0")
            ),
            Arrays.asList(
                new Credit("@abacabadabacaba", null, null),
                new Credit("Anton Gyllenberg", null, null)
            ),
            new GoUrl("https://pkg.go.dev/vuln/GO-2020-0015")
        );
    }
}
```