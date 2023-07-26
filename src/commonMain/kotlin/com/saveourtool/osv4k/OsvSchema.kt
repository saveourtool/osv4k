package com.saveourtool.osv4k

import com.saveourtool.osv4k.jackson.*
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
@JsonInclude(
    value = JsonIncludeType.NON_NULL,
    content = JsonIncludeType.ALWAYS,
    valueFilter = JavaVoid::class,
    contentFilter = JavaVoid::class,
)
data class OsvSchema<D, A_D, A_E, A_R_D>(
    @SerialName("schema_version")
    @get:JsonProperty(value = "schema_version", namespace = "", required = false, index = -1, defaultValue = "", access = JsonPropertyAccess.AUTO)
    @JsonProperty(value = "schema_version", namespace = "", required = false, index = -1, defaultValue = "", access = JsonPropertyAccess.AUTO)
    // TODO: add validation to SemVer or re-use library for it
    val schemaVersion: String = "1.0.0",

    @JsonProperty(value = "id", namespace = "", required = false, index = -1, defaultValue = "", access = JsonPropertyAccess.AUTO)
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
    @JsonProperty(value = "modified", namespace = "", required = false, index = -1, defaultValue = "", access = JsonPropertyAccess.AUTO)
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
    @JsonProperty(value = "published", namespace = "", required = false, index = -1, defaultValue = "", access = JsonPropertyAccess.AUTO)
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
    @JsonProperty(value = "withdrawn", namespace = "", required = false, index = -1, defaultValue = "", access = JsonPropertyAccess.AUTO)
    val withdrawn: LocalDateTime? = null,

    @JsonProperty(value = "aliases", namespace = "", required = false, index = -1, defaultValue = "", access = JsonPropertyAccess.AUTO)
    val aliases: List<String>? = null,
    @JsonProperty(value = "related", namespace = "", required = false, index = -1, defaultValue = "", access = JsonPropertyAccess.AUTO)
    val related: List<String>? = null,
    @JsonProperty(value = "summary", namespace = "", required = false, index = -1, defaultValue = "", access = JsonPropertyAccess.AUTO)
    val summary: String? = null,
    @JsonProperty(value = "details", namespace = "", required = false, index = -1, defaultValue = "", access = JsonPropertyAccess.AUTO)
    val details: String? = null,
    @JsonProperty(value = "severity", namespace = "", required = false, index = -1, defaultValue = "", access = JsonPropertyAccess.AUTO)
    val severity: List<Severity>? = null,
    @JsonProperty(value = "affected", namespace = "", required = false, index = -1, defaultValue = "", access = JsonPropertyAccess.AUTO)
    val affected: List<Affected<A_D, A_E, A_R_D>>? = null,
    @JsonProperty(value = "references", namespace = "", required = false, index = -1, defaultValue = "", access = JsonPropertyAccess.AUTO)
    val references: List<Reference>? = null,
    @JsonProperty(value = "credits", namespace = "", required = false, index = -1, defaultValue = "", access = JsonPropertyAccess.AUTO)
    val credits: List<Credit>? = null,
    @SerialName("database_specific")
    @get:JsonProperty(value = "database_specific", namespace = "", required = false, index = -1, defaultValue = "", access = JsonPropertyAccess.AUTO)
    @JsonProperty(value = "database_specific", namespace = "", required = false, index = -1, defaultValue = "", access = JsonPropertyAccess.AUTO)
    val databaseSpecific: D? = null,
)

@Serializable
@JsonInclude(
    value = JsonIncludeType.NON_NULL,
    content = JsonIncludeType.ALWAYS,
    valueFilter = JavaVoid::class,
    contentFilter = JavaVoid::class,
)
data class Affected<D, E, R_D> (
    @JsonProperty(value = "package", namespace = "", required = false, index = -1, defaultValue = "", access = JsonPropertyAccess.AUTO)
    val `package`: Package? = null,

    @JsonProperty(value = "severity", namespace = "", required = false, index = -1, defaultValue = "", access = JsonPropertyAccess.AUTO)
    val severity: List<Severity>? = null,
    @JsonProperty(value = "ranges", namespace = "", required = false, index = -1, defaultValue = "", access = JsonPropertyAccess.AUTO)
    val ranges: List<Range<R_D>>? = null,
    @JsonProperty(value = "versions", namespace = "", required = false, index = -1, defaultValue = "", access = JsonPropertyAccess.AUTO)
    val versions: List<String>? = null,

    @SerialName("ecosystem_specific")
    @get:JsonProperty(value = "ecosystem_specific", namespace = "", required = false, index = -1, defaultValue = "", access = JsonPropertyAccess.AUTO)
    @JsonProperty(value = "ecosystem_specific", namespace = "", required = false, index = -1, defaultValue = "", access = JsonPropertyAccess.AUTO)
    val ecosystemSpecific: E? = null,
    @SerialName("database_specific")
    @get:JsonProperty(value = "database_specific", namespace = "", required = false, index = -1, defaultValue = "", access = JsonPropertyAccess.AUTO)
    @JsonProperty(value = "database_specific", namespace = "", required = false, index = -1, defaultValue = "", access = JsonPropertyAccess.AUTO)
    val databaseSpecific: D? = null,
)

@Serializable
@JsonInclude(
    value = JsonIncludeType.NON_NULL,
    content = JsonIncludeType.ALWAYS,
    valueFilter = JavaVoid::class,
    contentFilter = JavaVoid::class,
)
data class Package (
    @JsonProperty(value = "ecosystem", namespace = "", required = false, index = -1, defaultValue = "", access = JsonPropertyAccess.AUTO)
    val ecosystem: String,
    @JsonProperty(value = "name", namespace = "", required = false, index = -1, defaultValue = "", access = JsonPropertyAccess.AUTO)
    val name: String,
    @JsonProperty(value = "purl", namespace = "", required = false, index = -1, defaultValue = "", access = JsonPropertyAccess.AUTO)
    val purl: String? = null
)

@Serializable
@JsonInclude(
    value = JsonIncludeType.NON_NULL,
    content = JsonIncludeType.ALWAYS,
    valueFilter = JavaVoid::class,
    contentFilter = JavaVoid::class,
)
data class Range<D> (
    @JsonProperty(value = "type", namespace = "", required = false, index = -1, defaultValue = "", access = JsonPropertyAccess.AUTO)
    val type: RangeType,
    @JsonProperty(value = "repo", namespace = "", required = false, index = -1, defaultValue = "", access = JsonPropertyAccess.AUTO)
    val repo: String? = null,
    @JsonProperty(value = "events", namespace = "", required = false, index = -1, defaultValue = "", access = JsonPropertyAccess.AUTO)
    val events: List<Event>,
    @SerialName("database_specific")
    @get:JsonProperty(value = "database_specific", namespace = "", required = false, index = -1, defaultValue = "", access = JsonPropertyAccess.AUTO)
    @JsonProperty(value = "database_specific", namespace = "", required = false, index = -1, defaultValue = "", access = JsonPropertyAccess.AUTO)
    val databaseSpecific: D? = null,
)

@Serializable
@JsonInclude(
    value = JsonIncludeType.NON_NULL,
    content = JsonIncludeType.ALWAYS,
    valueFilter = JavaVoid::class,
    contentFilter = JavaVoid::class,
)
data class Event (
    @JsonProperty(value = "introduced", namespace = "", required = false, index = -1, defaultValue = "", access = JsonPropertyAccess.AUTO)
    val introduced: String? = null,
    @JsonProperty(value = "fixed", namespace = "", required = false, index = -1, defaultValue = "", access = JsonPropertyAccess.AUTO)
    val fixed: String? = null,

    @SerialName("last_affected")
    @get:JsonProperty(value = "last_affected", namespace = "", required = false, index = -1, defaultValue = "", access = JsonPropertyAccess.AUTO)
    @JsonProperty(value = "last_affected", namespace = "", required = false, index = -1, defaultValue = "", access = JsonPropertyAccess.AUTO)
    val lastAffected: String? = null,

    @JsonProperty(value = "limit", namespace = "", required = false, index = -1, defaultValue = "", access = JsonPropertyAccess.AUTO)
    val limit: String? = null
)

enum class RangeType {
    ECOSYSTEM,
    GIT,
    SEMVER,
    ;
}

@Serializable
@JsonInclude(
    value = JsonIncludeType.NON_NULL,
    content = JsonIncludeType.ALWAYS,
    valueFilter = JavaVoid::class,
    contentFilter = JavaVoid::class,
)
data class Severity (
    @JsonProperty(value = "type", namespace = "", required = false, index = -1, defaultValue = "", access = JsonPropertyAccess.AUTO)
    val type: SeverityType,
    @JsonProperty(value = "score", namespace = "", required = false, index = -1, defaultValue = "", access = JsonPropertyAccess.AUTO)
    val score: String
)

enum class SeverityType {
    CVSS_V2,
    CVSS_V3,
    ;
}

@Serializable
@JsonInclude(
    value = JsonIncludeType.NON_NULL,
    content = JsonIncludeType.ALWAYS,
    valueFilter = JavaVoid::class,
    contentFilter = JavaVoid::class,
)
data class Credit (
    @JsonProperty(value = "name", namespace = "", required = false, index = -1, defaultValue = "", access = JsonPropertyAccess.AUTO)
    val name: String,
    @JsonProperty(value = "contact", namespace = "", required = false, index = -1, defaultValue = "", access = JsonPropertyAccess.AUTO)
    val contact: List<String>? = null,
    @JsonProperty(value = "type", namespace = "", required = false, index = -1, defaultValue = "", access = JsonPropertyAccess.AUTO)
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
@JsonInclude(
    value = JsonIncludeType.NON_NULL,
    content = JsonIncludeType.ALWAYS,
    valueFilter = JavaVoid::class,
    contentFilter = JavaVoid::class,
)
data class Reference (
    @JsonProperty(value = "type", namespace = "", required = false, index = -1, defaultValue = "", access = JsonPropertyAccess.AUTO)
    val type: ReferenceType,
    @JsonProperty(value = "url", namespace = "", required = false, index = -1, defaultValue = "", access = JsonPropertyAccess.AUTO)
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

