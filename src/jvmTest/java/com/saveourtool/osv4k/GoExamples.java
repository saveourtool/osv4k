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
