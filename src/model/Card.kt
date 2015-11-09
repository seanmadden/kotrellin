public data class Card (
    val id: String,
    val badges: Badges,
    val checkItemStates: List<Any>,
    val closed: Boolean,
    val dateLastActivity: String?,
    val desc: String,
    val descData: Any?,
    val due: String?,
    val email: String?,
    val idAttachmentCover: String?,
    val idBoard: String,
    val idChecklists: List<Any>,
    val idLabels: List<Any>,
    val idList: String,
    val idMembers: List<Any>,
    val idMembersVoted: List<Any>,
    val idShort: Int,
    val labels: List<Any>,
    val manualCoverAttachment: Boolean?,
    val name: String,
    val pos: Double,
    val shortLink: String,
    val shortUrl: String,
    val subscribed: Boolean?,
    val url: String
)

public data class Badges (
        val votes: Int,
        val viewingMemberVoted: Boolean,
        val subscribed: Boolean,
        val fogbugz: String,
        val checkItems: Int,
        val checkItemsChecked: Int,
        val comments: Int,
        val attachments: Int,
        val description: Boolean,
        val due: String?

)

public data class CardMetadata(
        val id: String,
        var name: String
)
