package com.saveourtool.osv4k

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A schema for describing a vulnerability in an open source package.
 */
data class OsvSchema (
    @SerialName("schema_version")
    // TODO: add validation to SemVer or re-use library for it
    val schemaVersion: String = "1.0.0",

    val id: String,
    val modified: LocalDateTime,

    val published: LocalDateTime? = null,
    val withdrawn: LocalDateTime? = null,

    val aliases: List<String>? = null,
    val related: List<String>? = null,
    val summary: String? = null,
    val details: String? = null,
    val severity: List<Severity>? = null,
    val affected: List<Affected>? = null,
    val credits: List<Credit>? = null,
    @SerialName("database_specific")
    val databaseSpecific: Map<String, Any?>? = null,


    val references: List<Reference>? = null,
)

data class Affected (
    val `package`: Package? = null,

    val severity: List<Severity>? = null,
    val ranges: List<Range>? = null,
    val versions: List<String>? = null,

    @SerialName("ecosystem_specific")
    val ecosystemSpecific: Map<String, Any?>? = null,
    @SerialName("database_specific")
    val databaseSpecific: Map<String, Any?>? = null,
)

data class Package (
    val ecosystem: String,
    val name: String,
    val purl: String? = null
)

data class Range (
    val type: RangeType,
    val repo: String? = null,
    val events: List<Event>,
    // TODO: do
    @SerialName("database_specific")
    val databaseSpecific: Map<String, Any?>? = null,
)

data class Event (
    val introduced: String? = null,
    val fixed: String? = null,

    @SerialName("last_affected")
    val lastAffected: String? = null,

    val limit: String? = null
)

enum class RangeType(val value: String) {
    Ecosystem("ECOSYSTEM"),
    Git("GIT"),
    Semver("SEMVER"),
    ;
}

@Serializable
data class Severity (
    val type: SeverityType,
    val score: String
)

enum class SeverityType(val value: String) {
    CvssV2("CVSS_V2"),
    CvssV3("CVSS_V3"),
    ;
}

@Serializable
data class Credit (
    val name: String,
    val contact: List<String>? = null,
    val type: CreditType? = null
)

enum class CreditType(val value: String) {
    Analyst("ANALYST"),
    Coordinator("COORDINATOR"),
    Finder("FINDER"),
    Other("OTHER"),
    RemediationDeveloper("REMEDIATION_DEVELOPER"),
    RemediationReviewer("REMEDIATION_REVIEWER"),
    RemediationVerifier("REMEDIATION_VERIFIER"),
    Reporter("REPORTER"),
    Sponsor("SPONSOR"),
    Tool("TOOL"),
    ;
}

@Serializable
data class Reference (
    val type: ReferenceType,
    val url: String
)

enum class ReferenceType(val value: String) {
    Advisory("ADVISORY"),
    Article("ARTICLE"),
    Detection("DETECTION"),
    Discussion("DISCUSSION"),
    Evidence("EVIDENCE"),
    Fix("FIX"),
    Git("GIT"),
    Introduced("INTRODUCED"),
    Package("PACKAGE"),
    Report("REPORT"),
    Web("WEB"),
    ;

    companion object {
        fun fromValue(value: String): ReferenceType = entries.find { it.value == value } ?: throw IllegalArgumentException()
    }
}