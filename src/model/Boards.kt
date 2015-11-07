import org.json.JSONObject

/**
 * Created by sean on 11/6/15.
 */


public class Boards(
        val id : String,
        var closed: Boolean,
        var dateLastActivity: String?,
        var dateLastView: String?,
        var desc: String,
        var descData: String?,
        var idOrganization: String?,
        var invitations: List<String>,
        var invited: Boolean,
        var labelNames: LabelNames,
        var memberships: Any,
        var name: String,
        var pinned: Boolean,
        var powerUps: List<Any>,
        var prefs: Any,
        val shortLink: String,
        val shortUrl: String,
        var starred: Boolean?,
        var subscribed: Boolean?,
        val url: String
)

public data class LabelNames (
        var green: String,
        var yellow: String,
        var orange: String,
        var red: String,
        var purple: String,
        var blue: String,
        var sky: String,
        var lime: String,
        var pink: String,
        var black: String
)
