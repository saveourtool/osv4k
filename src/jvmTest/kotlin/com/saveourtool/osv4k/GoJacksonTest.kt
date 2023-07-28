@file:Suppress(
    "LONG_LINE",
    "TOO_LONG_FUNCTION",
    "LongMethod",
)

package com.saveourtool.osv4k

import com.saveourtool.osv4k.OsvSchemaJacksonTestUtil.doEncodeDecodeAndCompare
import kotlin.test.Test

class GoJacksonTest {
    @Test
    fun `GO-2020-0015`() {
        doEncodeDecodeAndCompare(
            """
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
            """.trimIndent()
        )
    }

    @Test
    fun `GO-2022-0189`() {
        // language=JSON
        doEncodeDecodeAndCompare(
            """
                        {
                          "schema_version": "1.3.1",
                          "id": "GO-2022-0189",
                          "modified": "2023-06-12T18:45:41Z",
                          "published": "2022-08-04T21:30:35Z",
                          "aliases": [
                            "CVE-2018-16873"
                          ],
                          "summary": "Remote command execution via \"go get\" with \"-u\" flag in cmd/go",
                          "details": "The \"go get\" command is vulnerable to remote code execution when executed with the -u flag and the import path of a malicious Go package, or a package that imports it directly or indirectly.\n\nSpecifically, it is only vulnerable in GOPATH mode, but not in module mode (the distinction is documented at https://golang.org/cmd/go/#hdr-Module_aware_go_get).\n\nUsing custom domains, it's possible to arrange things so that a Git repository is cloned to a folder named \".git\" by using a vanity import path that ends with \"/.git\". If the Git repository root contains a \"HEAD\" file, a \"config\" file, an \"objects\" directory, a \"refs\" directory, with some work to ensure the proper ordering of operations, \"go get -u\" can be tricked into considering the parent directory as a repository root, and running Git commands on it. That will use the \"config\" file in the original Git repository root for its configuration, and if that config file contains malicious commands, they will execute on the system running \"go get -u\".\n\nNote that forbidding import paths with a .git element might not be sufficient to mitigate this issue, as on certain systems there can be other aliases for VCS state folders.",
                          "affected": [
                            {
                              "package": {
                                "ecosystem": "Go",
                                "name": "toolchain"
                              },
                              "ranges": [
                                {
                                  "type": "SEMVER",
                                  "events": [
                                    {
                                      "introduced": "0"
                                    },
                                    {
                                      "fixed": "1.10.6"
                                    },
                                    {
                                      "introduced": "1.11.0-0"
                                    },
                                    {
                                      "fixed": "1.11.3"
                                    }
                                  ]
                                }
                              ],
                              "ecosystem_specific": {
                                "imports": [
                                  {
                                    "path": "cmd/go/internal/get",
                                    "symbols": [
                                      "downloadPackage"
                                    ]
                                  }
                                ]
                              }
                            }
                          ],
                          "references": [
                            {
                              "type": "FIX",
                              "url": "https://go.dev/cl/154101"
                            },
                            {
                              "type": "FIX",
                              "url": "https://go.googlesource.com/go/+/bc82d7c7db83487e05d7a88e06549d4ae2a688c3"
                            },
                            {
                              "type": "REPORT",
                              "url": "https://go.dev/issue/29230"
                            },
                            {
                              "type": "WEB",
                              "url": "https://groups.google.com/g/golang-announce/c/Kw31K8G7Fi0"
                            }
                          ],
                          "credits": [
                            {
                              "name": "Etienne Stalmans of Heroku"
                            }
                          ],
                          "database_specific": {
                            "url": "https://pkg.go.dev/vuln/GO-2022-0189"
                          }
                        }
            """.trimIndent()
        )
    }

    @Test
    fun `GO-2022-0191`() {
        // language=JSON
        doEncodeDecodeAndCompare(
            """
                        {
                          "schema_version": "1.3.1",
                          "id": "GO-2022-0191",
                          "modified": "2023-06-12T18:45:41Z",
                          "published": "2022-07-15T23:03:26Z",
                          "aliases": [
                            "CVE-2018-16875"
                          ],
                          "summary": "Denial of service in chain verification in crypto/x509",
                          "details": "The crypto/x509 package does not limit the amount of work performed for each chain verification, which might allow attackers to craft pathological inputs leading to a CPU denial of service. Go TLS servers accepting client certificates and TLS clients verifying certificates are affected.",
                          "affected": [
                            {
                              "package": {
                                "ecosystem": "Go",
                                "name": "stdlib"
                              },
                              "ranges": [
                                {
                                  "type": "SEMVER",
                                  "events": [
                                    {
                                      "introduced": "0"
                                    },
                                    {
                                      "fixed": "1.10.6"
                                    },
                                    {
                                      "introduced": "1.11.0-0"
                                    },
                                    {
                                      "fixed": "1.11.3"
                                    }
                                  ]
                                }
                              ],
                              "ecosystem_specific": {
                                "imports": [
                                  {
                                    "path": "crypto/x509",
                                    "symbols": [
                                      "CertPool.findVerifiedParents",
                                      "Certificate.buildChains"
                                    ]
                                  }
                                ]
                              }
                            }
                          ],
                          "references": [
                            {
                              "type": "FIX",
                              "url": "https://go.dev/cl/154105"
                            },
                            {
                              "type": "FIX",
                              "url": "https://go.googlesource.com/go/+/770130659b6fb2acf271476579a3644e093dda7f"
                            },
                            {
                              "type": "REPORT",
                              "url": "https://go.dev/issue/29233"
                            },
                            {
                              "type": "WEB",
                              "url": "https://groups.google.com/g/golang-announce/c/Kw31K8G7Fi0"
                            }
                          ],
                          "credits": [
                            {
                              "name": "Netflix"
                            }
                          ],
                          "database_specific": {
                            "url": "https://pkg.go.dev/vuln/GO-2022-0191"
                          }
                        }
            """.trimIndent()
        )
    }
}
