/**
 * A schema for describing a vulnerability in an open source package.
 */
data class OsvSchema (
    val affected: List<Affected>? = null,
    val aliases: List<String>? = null,
    val credits: List<Credit>? = null,

    @Json(name = "database_specific")
    val databaseSpecific: Map<String, Any?>? = null,

    val details: String? = null,
    val id: String,
    val modified: String,
    val published: String? = null,
    val references: List<Reference>? = null,
    val related: List<String>? = null,

    @Json(name = "schema_version")
    val schemaVersion: String? = null,

    val severity: List<OsvSchem>? = null,
    val summary: String? = null,
    val withdrawn: String? = null
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<OsvSchema>(json)
    }
}

data class Affected (
    @Json(name = "database_specific")
    val databaseSpecific: Map<String, Any?>? = null,

    @Json(name = "ecosystem_specific")
    val ecosystemSpecific: Map<String, Any?>? = null,

    @Json(name = "package")
    val affectedPackage: Package? = null,

    val ranges: List<Range>? = null,
    val severity: List<OsvSchem>? = null,
    val versions: List<String>? = null
)

data class Package (
    val ecosystem: String,
    val name: String,
    val purl: String? = null
)

data class Range (
    @Json(name = "database_specific")
    val databaseSpecific: Map<String, Any?>? = null,

    val events: List<Event>,
    val repo: String? = null,
    val type: RangeType
)

data class Event (
    val introduced: String? = null,
    val fixed: String? = null,

    @Json(name = "last_affected")
    val lastAffected: String? = null,

    val limit: String? = null
)

enum class RangeType(val value: String) {
    Ecosystem("ECOSYSTEM"),
    Git("GIT"),
    Semver("SEMVER");

    companion object {
        public fun fromValue(value: String): RangeType = when (value) {
            "ECOSYSTEM" -> Ecosystem
            "GIT"       -> Git
            "SEMVER"    -> Semver
            else        -> throw IllegalArgumentException()
        }
    }
}

data class OsvSchem (
    val score: String,
    val type: SeverityType
)

enum class SeverityType(val value: String) {
    CvssV2("CVSS_V2"),
    CvssV3("CVSS_V3");

    companion object {
        public fun fromValue(value: String): SeverityType = when (value) {
            "CVSS_V2" -> CvssV2
            "CVSS_V3" -> CvssV3
            else      -> throw IllegalArgumentException()
        }
    }
}

data class Credit (
    val contact: List<String>? = null,
    val name: String,
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
    Tool("TOOL");

    companion object {
        public fun fromValue(value: String): CreditType = when (value) {
            "ANALYST"               -> Analyst
            "COORDINATOR"           -> Coordinator
            "FINDER"                -> Finder
            "OTHER"                 -> Other
            "REMEDIATION_DEVELOPER" -> RemediationDeveloper
            "REMEDIATION_REVIEWER"  -> RemediationReviewer
            "REMEDIATION_VERIFIER"  -> RemediationVerifier
            "REPORTER"              -> Reporter
            "SPONSOR"               -> Sponsor
            "TOOL"                  -> Tool
            else                    -> throw IllegalArgumentException()
        }
    }
}

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
    Web("WEB");

    companion object {
        public fun fromValue(value: String): ReferenceType = when (value) {
            "ADVISORY"   -> Advisory
            "ARTICLE"    -> Article
            "DETECTION"  -> Detection
            "DISCUSSION" -> Discussion
            "EVIDENCE"   -> Evidence
            "FIX"        -> Fix
            "GIT"        -> Git
            "INTRODUCED" -> Introduced
            "PACKAGE"    -> Package
            "REPORT"     -> Report
            "WEB"        -> Web
            else         -> throw IllegalArgumentException()
        }
    }
}