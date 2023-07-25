package com.saveourtool.osv4k

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

// language=JSON
private typealias JsonString = String

class OsvSchemaTest {
    @OptIn(ExperimentalSerializationApi::class)
    private val prettyJson = Json {
        prettyPrint = true
        prettyPrintIndent = "  "
    }

    @Test
    fun testGo() {
        doEncodeDecodeAndCompare("""
            {
              "schema_version": "1.3.1",
              "id": "GO-2020-0015",
              "modified": "2023-06-12T18:45:41Z",
              "published": "2021-04-14T20:04:52Z",
              "aliases": [
                "CVE-2020-14040",
                "GHSA-5rcv-m4m3-hfh7"
              ],
              "summary": "Infinite loop when decoding some inputs in golang.org/x/text",
              "details": "An attacker could provide a single byte to a UTF16 decoder instantiated with UseBOM or ExpectBOM to trigger an infinite loop if the String function on the Decoder is called, or the Decoder is passed to transform.String. If used to parse user supplied input, this may be used as a denial of service vector.",
              "affected": [
                {
                  "package": {
                    "ecosystem": "Go",
                    "name": "golang.org/x/text"
                  },
                  "ranges": [
                    {
                      "type": "SEMVER",
                      "events": [
                        {
                          "introduced": "0"
                        },
                        {
                          "fixed": "0.3.3"
                        }
                      ]
                    }
                  ],
                  "ecosystem_specific": {
                    "imports": [
                      {
                        "path": "golang.org/x/text/encoding/unicode",
                        "symbols": [
                          "bomOverride.Transform",
                          "utf16Decoder.Transform"
                        ]
                      },
                      {
                        "path": "golang.org/x/text/transform",
                        "symbols": [
                          "String"
                        ]
                      }
                    ]
                  }
                }
              ],
              "references": [
                {
                  "type": "FIX",
                  "url": "https://go.dev/cl/238238"
                },
                {
                  "type": "FIX",
                  "url": "https://go.googlesource.com/text/+/23ae387dee1f90d29a23c0e87ee0b46038fbed0e"
                },
                {
                  "type": "REPORT",
                  "url": "https://go.dev/issue/39491"
                },
                {
                  "type": "WEB",
                  "url": "https://groups.google.com/g/golang-announce/c/bXVeAmGOqz0"
                }
              ],
              "credits": [
                {
                  "name": "@abacabadabacaba"
                },
                {
                  "name": "Anton Gyllenberg"
                }
              ],
              "database_specific": {
                "url": "https://pkg.go.dev/vuln/GO-2020-0015"
              }
            }
        """.trimIndent())
    }

    private fun doEncodeDecodeAndCompare(
        originalContent: JsonString,
    ) {
        val result = assertNotNull(
            Json.decodeFromString<RawOsvSchema>(originalContent)
        )
        assertEquals(originalContent, prettyJson.encodeToString(result))
    }
}