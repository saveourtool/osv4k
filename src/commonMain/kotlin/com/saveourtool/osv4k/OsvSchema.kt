package com.saveourtool.osv4k

import com.saveourtool.osv4k.annotations.*
import com.saveourtool.osv4k.utils.LocalDateTimeRfc3339JacksonDeserializer
import com.saveourtool.osv4k.utils.LocalDateTimeRfc3339JacksonSerializer
import com.saveourtool.osv4k.utils.LocalDateTimeRfc3339Serializer
import kotlinx.datetime.LocalDateTime
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
    @JsonProperty(value = "schema_version", namespace = "", required = true, index = -1, defaultValue = "", access = JsonPropertyAccess.AUTO)
    // TODO: add validation to SemVer or re-use library for it
    val schemaVersion: String = "1.0.0",

    val id: String,
    @Serializable(with = LocalDateTimeRfc3339Serializer::class)
    @JsonSerialize(
        using = LocalDateTimeRfc3339JacksonSerializer::class,
        contentUsing = JsonSerializerNone::class,
        keyUsing = JsonSerializerNone::class,
        nullsUsing = JsonSerializerNone::class,
        `as` = JavaVoid::class,
        keyAs = JavaVoid::class,
        contentAs = JavaVoid::class,
        typing = JsonSerializeTyping.DEFAULT_TYPING,
        converter = ConverterNone::class,
        contentConverter = ConverterNone::class,
        include = JsonSerializeInclusion.DEFAULT_INCLUSION,
    )
    @JsonDeserialize(
        using = LocalDateTimeRfc3339JacksonDeserializer::class,
        contentUsing = JsonDeserializerNone::class,
        keyUsing = KeyDeserializerNone::class,
        builder = JavaVoid::class,
        converter = ConverterNone::class,
        contentConverter = ConverterNone::class,
        `as` = JavaVoid::class,
        keyAs = JavaVoid::class,
        contentAs = JavaVoid::class,
    )
    val modified: LocalDateTime,

    @Serializable(with = LocalDateTimeRfc3339Serializer::class)
    @JsonSerialize(
        using = LocalDateTimeRfc3339JacksonSerializer::class,
        contentUsing = JsonSerializerNone::class,
        keyUsing = JsonSerializerNone::class,
        nullsUsing = JsonSerializerNone::class,
        `as` = JavaVoid::class,
        keyAs = JavaVoid::class,
        contentAs = JavaVoid::class,
        typing = JsonSerializeTyping.DEFAULT_TYPING,
        converter = ConverterNone::class,
        contentConverter = ConverterNone::class,
        include = JsonSerializeInclusion.DEFAULT_INCLUSION,
    )
    @JsonDeserialize(
        using = LocalDateTimeRfc3339JacksonDeserializer::class,
        contentUsing = JsonDeserializerNone::class,
        keyUsing = KeyDeserializerNone::class,
        builder = JavaVoid::class,
        converter = ConverterNone::class,
        contentConverter = ConverterNone::class,
        `as` = JavaVoid::class,
        keyAs = JavaVoid::class,
        contentAs = JavaVoid::class,
    )
    val published: LocalDateTime? = null,
    @Serializable(with = LocalDateTimeRfc3339Serializer::class)
    @JsonSerialize(
        using = LocalDateTimeRfc3339JacksonSerializer::class,
        contentUsing = JsonSerializerNone::class,
        keyUsing = JsonSerializerNone::class,
        nullsUsing = JsonSerializerNone::class,
        `as` = JavaVoid::class,
        keyAs = JavaVoid::class,
        contentAs = JavaVoid::class,
        typing = JsonSerializeTyping.DEFAULT_TYPING,
        converter = ConverterNone::class,
        contentConverter = ConverterNone::class,
        include = JsonSerializeInclusion.DEFAULT_INCLUSION,
    )
    @JsonDeserialize(
        using = LocalDateTimeRfc3339JacksonDeserializer::class,
        contentUsing = JsonDeserializerNone::class,
        keyUsing = KeyDeserializerNone::class,
        builder = JavaVoid::class,
        converter = ConverterNone::class,
        contentConverter = ConverterNone::class,
        `as` = JavaVoid::class,
        keyAs = JavaVoid::class,
        contentAs = JavaVoid::class,
    )
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
    @JsonProperty(value = "database_specific", namespace = "", required = false, index = -1, defaultValue = "", access = JsonPropertyAccess.AUTO)
    val databaseSpecific: D? = null,
)

@Serializable
data class Affected<D, E, R_D> (
    val `package`: Package? = null,

    val severity: List<Severity>? = null,
    val ranges: List<Range<R_D>>? = null,
    val versions: List<String>? = null,

    @SerialName("ecosystem_specific")
    @JsonProperty(value = "ecosystem_specific", namespace = "", required = false, index = -1, defaultValue = "", access = JsonPropertyAccess.AUTO)
    val ecosystemSpecific: E? = null,
    @SerialName("database_specific")
    @JsonProperty(value = "database_specific", namespace = "", required = false, index = -1, defaultValue = "", access = JsonPropertyAccess.AUTO)
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

//@Serializable
enum class RangeType {
    ECOSYSTEM,
    GIT,
    SEMVER,
    ;
}

@Serializable
data class Severity (
    val type: SeverityType,
    val score: String
)

enum class SeverityType {
    CVSS_V2,
    CVSS_V3,
    ;
}

@Serializable
data class Credit (
    val name: String,
    val contact: List<String>? = null,
    val type: CreditType? = null
)

enum class CreditType {
    ANALYST,
    COORDINATOR,
    FINDER,
    OTHER,
    REMEDIATION_DEVELOPER,
    REMEDIATION_REVIEWER,
    REMEDIATION_VERIFIER,
    REPORTER,
    SPONSOR,
    TOOL,
    ;
}

@Serializable
data class Reference (
    val type: ReferenceType,
    val url: String
)

enum class ReferenceType {
    ADVISORY,
    ARTICLE,
    DETECTION,
    DISCUSSION,
    EVIDENCE,
    FIX,
    GIT,
    INTRODUCED,
    PACKAGE,
    REPORT,
    WEB,
    ;
}

