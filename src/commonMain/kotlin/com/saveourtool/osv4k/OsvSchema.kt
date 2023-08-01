@file:Suppress("HEADER_MISSING_IN_NON_SINGLE_CLASS_FILE", "FILE_IS_TOO_LONG")

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
 *
 * @param D The top level `database_specific`.
 * @param A_E `affected[].ecosystem_specific`.
 * @param A_D `affected[].database_specific`.
 * @param A_R_D `affected[].ranges[].database_specific`.
 * @property schemaVersion
 * @property id
 * @property modified
 * @property published
 * @property withdrawn
 * @property aliases
 * @property related
 * @property summary
 * @property details
 * @property severity
 * @property affected
 * @property references
 * @property credits
 * @property databaseSpecific
 */
@Serializable
@JsonInclude(
    value = JsonIncludeType.NON_NULL,
    content = JsonIncludeType.ALWAYS,
    valueFilter = JavaVoid::class,
    contentFilter = JavaVoid::class,
)
@Suppress("GENERIC_NAME", "TYPE_ALIAS")
data class OsvSchema<D, A_E, A_D, A_R_D>(
    @SerialName("schema_version")
    @get:JsonProperty(
        value = "schema_version",
        namespace = "",
        required = false,
        index = -1,
        defaultValue = "1.0.0",
        access = JsonPropertyAccess.AUTO
    )
    @JsonProperty(
        value = "schema_version",
        namespace = "",
        required = false,
        index = -1,
        defaultValue = "1.0.0",
        access = JsonPropertyAccess.AUTO
    )
    // TODO: add validation to SemVer or re-use library for it
    val schemaVersion: String = "1.0.0",

    @JsonProperty(
        value = "id",
        namespace = "",
        required = true,
        index = -1,
        defaultValue = "",
        access = JsonPropertyAccess.AUTO
    )
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
    @JsonProperty(
        value = "modified",
        namespace = "",
        required = true,
        index = -1,
        defaultValue = "",
        access = JsonPropertyAccess.AUTO
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
    @JsonProperty(
        value = "published",
        namespace = "",
        required = false,
        index = -1,
        defaultValue = "",
        access = JsonPropertyAccess.AUTO
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
    @JsonProperty(
        value = "withdrawn",
        namespace = "",
        required = false,
        index = -1,
        defaultValue = "",
        access = JsonPropertyAccess.AUTO
    )
    val withdrawn: LocalDateTime? = null,

    @JsonProperty(
        value = "aliases",
        namespace = "",
        required = false,
        index = -1,
        defaultValue = "",
        access = JsonPropertyAccess.AUTO
    )
    val aliases: List<String>? = null,
    @JsonProperty(
        value = "related",
        namespace = "",
        required = false,
        index = -1,
        defaultValue = "",
        access = JsonPropertyAccess.AUTO
    )
    val related: List<String>? = null,
    @JsonProperty(
        value = "summary",
        namespace = "",
        required = false,
        index = -1,
        defaultValue = "",
        access = JsonPropertyAccess.AUTO
    )
    val summary: String? = null,
    @JsonProperty(
        value = "details",
        namespace = "",
        required = false,
        index = -1,
        defaultValue = "",
        access = JsonPropertyAccess.AUTO
    )
    val details: String? = null,
    @JsonProperty(
        value = "severity",
        namespace = "",
        required = false,
        index = -1,
        defaultValue = "",
        access = JsonPropertyAccess.AUTO
    )
    val severity: List<Severity>? = null,
    @JsonProperty(
        value = "affected",
        namespace = "",
        required = false,
        index = -1,
        defaultValue = "",
        access = JsonPropertyAccess.AUTO
    )
    val affected: List<Affected<A_E, A_D, A_R_D>>? = null,
    @JsonProperty(
        value = "references",
        namespace = "",
        required = false,
        index = -1,
        defaultValue = "",
        access = JsonPropertyAccess.AUTO
    )
    val references: List<Reference>? = null,
    @JsonProperty(
        value = "credits",
        namespace = "",
        required = false,
        index = -1,
        defaultValue = "",
        access = JsonPropertyAccess.AUTO
    )
    val credits: List<Credit>? = null,
    @SerialName("database_specific")
    @get:JsonProperty(
        value = "database_specific",
        namespace = "",
        required = false,
        index = -1,
        defaultValue = "",
        access = JsonPropertyAccess.AUTO
    )
    @JsonProperty(
        value = "database_specific",
        namespace = "",
        required = false,
        index = -1,
        defaultValue = "",
        access = JsonPropertyAccess.AUTO
    )
    val databaseSpecific: D? = null,
)

/**
 * @property `package`
 * @property severity
 * @property ranges
 * @property versions
 * @property ecosystemSpecific
 * @property databaseSpecific
 */
@Serializable
@JsonInclude(
    value = JsonIncludeType.NON_NULL,
    content = JsonIncludeType.ALWAYS,
    valueFilter = JavaVoid::class,
    contentFilter = JavaVoid::class,
)
@Suppress(
    "KDOC_NO_CONSTRUCTOR_PROPERTY",
    "BACKTICKS_PROHIBITED",
    "GENERIC_NAME"
)
data class Affected<E, D, R_D>(
    @JsonProperty(
        value = "package",
        namespace = "",
        required = false,
        index = -1,
        defaultValue = "",
        access = JsonPropertyAccess.AUTO
    )
    val `package`: Package? = null,

    @JsonProperty(
        value = "severity",
        namespace = "",
        required = false,
        index = -1,
        defaultValue = "",
        access = JsonPropertyAccess.AUTO
    )
    val severity: List<Severity>? = null,
    @JsonProperty(
        value = "ranges",
        namespace = "",
        required = false,
        index = -1,
        defaultValue = "",
        access = JsonPropertyAccess.AUTO
    )
    val ranges: List<Range<R_D>>? = null,
    @JsonProperty(
        value = "versions",
        namespace = "",
        required = false,
        index = -1,
        defaultValue = "",
        access = JsonPropertyAccess.AUTO
    )
    val versions: List<String>? = null,

    @SerialName("ecosystem_specific")
    @get:JsonProperty(
        value = "ecosystem_specific",
        namespace = "",
        required = false,
        index = -1,
        defaultValue = "",
        access = JsonPropertyAccess.AUTO
    )
    @JsonProperty(
        value = "ecosystem_specific",
        namespace = "",
        required = false,
        index = -1,
        defaultValue = "",
        access = JsonPropertyAccess.AUTO
    )
    val ecosystemSpecific: E? = null,
    @SerialName("database_specific")
    @get:JsonProperty(
        value = "database_specific",
        namespace = "",
        required = false,
        index = -1,
        defaultValue = "",
        access = JsonPropertyAccess.AUTO
    )
    @JsonProperty(
        value = "database_specific",
        namespace = "",
        required = false,
        index = -1,
        defaultValue = "",
        access = JsonPropertyAccess.AUTO
    )
    val databaseSpecific: D? = null,
)

/**
 * @property ecosystem
 * @property name
 * @property purl
 */
@Serializable
@JsonInclude(
    value = JsonIncludeType.NON_NULL,
    content = JsonIncludeType.ALWAYS,
    valueFilter = JavaVoid::class,
    contentFilter = JavaVoid::class,
)
data class Package(
    @JsonProperty(
        value = "ecosystem",
        namespace = "",
        required = false,
        index = -1,
        defaultValue = "",
        access = JsonPropertyAccess.AUTO
    )
    val ecosystem: String,
    @JsonProperty(
        value = "name",
        namespace = "",
        required = false,
        index = -1,
        defaultValue = "",
        access = JsonPropertyAccess.AUTO
    )
    val name: String,
    @JsonProperty(
        value = "purl",
        namespace = "",
        required = false,
        index = -1,
        defaultValue = "",
        access = JsonPropertyAccess.AUTO
    )
    val purl: String? = null
)

/**
 * @property type
 * @property repo
 * @property events
 * @property databaseSpecific
 */
@Serializable
@JsonInclude(
    value = JsonIncludeType.NON_NULL,
    content = JsonIncludeType.ALWAYS,
    valueFilter = JavaVoid::class,
    contentFilter = JavaVoid::class,
)
data class Range<D>(
    @JsonProperty(
        value = "type",
        namespace = "",
        required = false,
        index = -1,
        defaultValue = "",
        access = JsonPropertyAccess.AUTO
    )
    val type: RangeType,
    @JsonProperty(
        value = "repo",
        namespace = "",
        required = false,
        index = -1,
        defaultValue = "",
        access = JsonPropertyAccess.AUTO
    )
    val repo: String? = null,
    @JsonProperty(
        value = "events",
        namespace = "",
        required = false,
        index = -1,
        defaultValue = "",
        access = JsonPropertyAccess.AUTO
    )
    val events: List<Event>,
    @SerialName("database_specific")
    @get:JsonProperty(
        value = "database_specific",
        namespace = "",
        required = false,
        index = -1,
        defaultValue = "",
        access = JsonPropertyAccess.AUTO
    )
    @JsonProperty(
        value = "database_specific",
        namespace = "",
        required = false,
        index = -1,
        defaultValue = "",
        access = JsonPropertyAccess.AUTO
    )
    val databaseSpecific: D? = null,
)

/**
 * @property introduced
 * @property fixed
 * @property lastAffected
 * @property limit
 */
@Serializable
@JsonInclude(
    value = JsonIncludeType.NON_NULL,
    content = JsonIncludeType.ALWAYS,
    valueFilter = JavaVoid::class,
    contentFilter = JavaVoid::class,
)
data class Event(
    @JsonProperty(
        value = "introduced",
        namespace = "",
        required = false,
        index = -1,
        defaultValue = "",
        access = JsonPropertyAccess.AUTO
    )
    val introduced: String? = null,
    @JsonProperty(
        value = "fixed",
        namespace = "",
        required = false,
        index = -1,
        defaultValue = "",
        access = JsonPropertyAccess.AUTO
    )
    val fixed: String? = null,

    @SerialName("last_affected")
    @get:JsonProperty(
        value = "last_affected",
        namespace = "",
        required = false,
        index = -1,
        defaultValue = "",
        access = JsonPropertyAccess.AUTO
    )
    @JsonProperty(
        value = "last_affected",
        namespace = "",
        required = false,
        index = -1,
        defaultValue = "",
        access = JsonPropertyAccess.AUTO
    )
    val lastAffected: String? = null,

    @JsonProperty(
        value = "limit",
        namespace = "",
        required = false,
        index = -1,
        defaultValue = "",
        access = JsonPropertyAccess.AUTO
    )
    val limit: String? = null
)

/**
 * In the `ranges` field, the `type` field is required.
 * It specifies the type of version range being recorded and defines the interpretation of the `events` object’s `introduced`, `fixed`, and any type-specific fields.
 *
 * The defined types and their additional fields are:
 */
enum class RangeType {
    /**
     * The versions introduced and fixed are arbitrary, uninterpreted strings specific to the package ecosystem, which does not conform to SemVer 2.0’s version ordering.
     *
     * It is recommended that you provide an explicitly enumerated versions list when specifying one or more ECOSYSTEM ranges,
     * because ECOSYSTEM range inclusion queries may not be able to be answered without reference
     * to the package ecosystem’s own logic and therefore may not be able to be used by ecosystem-independent processors.
     * The infrastructure and tooling provided by https://osv.dev also provides automation
     * for auto-populating the versions list based on supported ECOSYSTEM ranges as part of the ingestion process.
     */
    ECOSYSTEM,

    /**
     * The versions introduced and fixed are full-length Git commit hashes.
     * The repository’s commit graph is needed to evaluate whether a given version is in the range.
     * The relation u < v is true when commit u is a (perhaps distant) parent of commit v.
     *
     * Specifying one or more GIT ranges does NOT remove the requirement to specify an explicitly enumerated versions list,
     * because GIT range inclusion queries cannot be answered without access to a copy of the underlying Git repository.
     */
    GIT,

    /**
     * The versions introduced and fixed are semantic versions as defined by SemVer 2.0.0, with no leading “v” prefix.
     * The relation u < v denotes the precedence order defined in section 11 of SemVer 2.0.
     * Ranges listed with type SEMVER should not overlap: since SEMVER is a strict linear ordering, it is always possible to simplify to non-overlapping ranges.
     *
     * Specifying one or more SEMVER ranges removes the requirement to specify an explicit enumerated versions list (see the discussion above).
     *
     * Some ecosystems may recommend using SemVer 2.0 for versioning without explicitly enforcing it. In those cases you should use the ECOSYSTEM type instead.
     */
    SEMVER,
    ;
}

/**
 * @property type
 * @property score
 */
@Serializable
@JsonInclude(
    value = JsonIncludeType.NON_NULL,
    content = JsonIncludeType.ALWAYS,
    valueFilter = JavaVoid::class,
    contentFilter = JavaVoid::class,
)
data class Severity(
    @JsonProperty(
        value = "type",
        namespace = "",
        required = false,
        index = -1,
        defaultValue = "",
        access = JsonPropertyAccess.AUTO
    )
    val type: SeverityType,
    @JsonProperty(
        value = "score",
        namespace = "",
        required = false,
        index = -1,
        defaultValue = "",
        access = JsonPropertyAccess.AUTO
    )
    val score: String
)

/**
 * TODO
 */
enum class SeverityType {
    CVSS_V2,
    CVSS_V3,
    ;
}

/**
 * @property name
 * @property contact
 * @property type
 */
@Serializable
@JsonInclude(
    value = JsonIncludeType.NON_NULL,
    content = JsonIncludeType.ALWAYS,
    valueFilter = JavaVoid::class,
    contentFilter = JavaVoid::class,
)
data class Credit(
    @JsonProperty(
        value = "name",
        namespace = "",
        required = false,
        index = -1,
        defaultValue = "",
        access = JsonPropertyAccess.AUTO
    )
    val name: String,
    @JsonProperty(
        value = "contact",
        namespace = "",
        required = false,
        index = -1,
        defaultValue = "",
        access = JsonPropertyAccess.AUTO
    )
    val contact: List<String>? = null,
    @JsonProperty(
        value = "type",
        namespace = "",
        required = false,
        index = -1,
        defaultValue = "",
        access = JsonPropertyAccess.AUTO
    )
    val type: CreditType? = null
)

/**
 * TODO
 */
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

/**
 * @property type
 * @property url
 */
@Serializable
@JsonInclude(
    value = JsonIncludeType.NON_NULL,
    content = JsonIncludeType.ALWAYS,
    valueFilter = JavaVoid::class,
    contentFilter = JavaVoid::class,
)
data class Reference(
    @JsonProperty(
        value = "type",
        namespace = "",
        required = false,
        index = -1,
        defaultValue = "",
        access = JsonPropertyAccess.AUTO
    )
    val type: ReferenceType,
    @JsonProperty(
        value = "url",
        namespace = "",
        required = false,
        index = -1,
        defaultValue = "",
        access = JsonPropertyAccess.AUTO
    )
    val url: String
)

/**
 * The type specifies what kind of reference the URL is.
 *
 * The known reference type values are:
 */
enum class ReferenceType {
    /**
     * A published security advisory for the vulnerability.
     */
    ADVISORY,

    /**
     * An article or blog post describing the vulnerability.
     */
    ARTICLE,

    /**
     * A tool, script, scanner, or other mechanism that allows for detection of the vulnerability in production environments.
     * e.g. YARA rules, hashes, virus signature, or other scanners.
     */
    DETECTION,

    /**
     * A social media discussion regarding the vulnerability, e.g. a Twitter, Mastodon, Hacker News, or Reddit thread.
     */
    DISCUSSION,

    /**
     * A demonstration of the validity of a vulnerability claim, e.g. app.any.run replaying the exploitation of the vulnerability.
     */
    EVIDENCE,

    /**
     * A source code browser link to the fix (e.g., a GitHub commit)
     * Note that the fix type is meant for viewing by people using web browsers.
     * Programs interested in analyzing the exact commit range would do better to use the GIT-typed affected[].ranges entries (described above).
     */
    FIX,

    /**
     * A source code browser link to the fix (e.g., a GitHub commit)
     * Note that the fix type is meant for viewing by people using web browsers.
     * Programs interested in analyzing the exact commit range would do better to use the GIT-typed affected[].ranges entries (described above).
     */
    GIT,

    /**
     * A source code browser link to the introduction of the vulnerability (e.g., a GitHub commit) Note that the introduced type is meant for viewing by people using web browsers.
     */
    INTRODUCED,

    /**
     * A home web page for the package.
     */
    PACKAGE,

    /**
     * A report, typically on a bug or issue tracker, of the vulnerability.
     */
    REPORT,

    /**
     * A web page of some unspecified kind.
     */
    WEB,
    ;
}
