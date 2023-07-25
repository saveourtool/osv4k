@file:OptIn(ExperimentalSerializationApi::class)

package com.saveourtool.osv4k

import com.saveourtool.osv4k.utils.EnumAsValueSerializer
import com.saveourtool.osv4k.utils.LocalDateTimeRfc3339Serializer
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

typealias RawOsvSchema = OsvSchema<JsonObject, JsonObject, JsonObject, JsonObject>

/**
 * A schema for describing a vulnerability in an open source package.
 */
@Serializable
data class OsvSchema<D, A_D, A_E, A_R_D> (
    @SerialName("schema_version")
    // TODO: add validation to SemVer or re-use library for it
    val schemaVersion: String = "1.0.0",

    val id: String,
    @Serializable(with = LocalDateTimeRfc3339Serializer::class)
    val modified: LocalDateTime,

    @Serializable(with = LocalDateTimeRfc3339Serializer::class)
    val published: LocalDateTime? = null,
    @Serializable(with = LocalDateTimeRfc3339Serializer::class)
    val withdrawn: LocalDateTime? = null,

    val aliases: List<String>? = null,
    val related: List<String>? = null,
    val summary: String? = null,
    val details: String? = null,
    val severity: List<Severity>? = null,
    val affected: List<Affected<A_D, A_E, A_R_D>>? = null,
    val references: List<Reference>? = null,
    val credits: List<Credit>? = null,
    @SerialName("database_specific")
    val databaseSpecific: D? = null,
)

@Serializable
data class Affected<D, E, R_D> (
    val `package`: Package? = null,

    val severity: List<Severity>? = null,
    val ranges: List<Range<R_D>>? = null,
    val versions: List<String>? = null,

    @SerialName("ecosystem_specific")
    val ecosystemSpecific: E? = null,
    @SerialName("database_specific")
    val databaseSpecific: D? = null,
)

@Serializable
data class Package (
    val ecosystem: String,
    val name: String,
    val purl: String? = null
)

@Serializable
data class Range<D> (
    val type: RangeType,
    val repo: String? = null,
    val events: List<Event>,
    // TODO: do
    @SerialName("database_specific")
    val databaseSpecific: D? = null,
)

@Serializable
data class Event (
    val introduced: String? = null,
    val fixed: String? = null,

    @SerialName("last_affected")
    val lastAffected: String? = null,

    val limit: String? = null
)

@Serializable(with = RangeType.Companion::class)
enum class RangeType(val value: String) {
    Ecosystem("ECOSYSTEM"),
    Git("GIT"),
    Semver("SEMVER"),
    ;

    companion object : EnumAsValueSerializer<RangeType>("RangeType", RangeType::value, RangeType.entries)
}

@Serializable
data class Severity (
    val type: SeverityType,
    val score: String
)

@Serializable(with = SeverityType.Companion::class)
enum class SeverityType(val value: String) {
    CvssV2("CVSS_V2"),
    CvssV3("CVSS_V3"),
    ;

    companion object : EnumAsValueSerializer<SeverityType>("SeverityType", SeverityType::value, SeverityType.entries)
}

@Serializable
data class Credit (
    val name: String,
    val contact: List<String>? = null,
    val type: CreditType? = null
)

@Serializable(with = CreditType.Companion::class)
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

    companion object : EnumAsValueSerializer<CreditType>("CreditType", CreditType::value, CreditType.entries)
}

@Serializable
data class Reference (
    val type: ReferenceType,
    val url: String
)

@Serializable(with = ReferenceType.Companion::class)
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

    companion object : EnumAsValueSerializer<ReferenceType>("ReferenceType", ReferenceType::value, ReferenceType.entries)
}

