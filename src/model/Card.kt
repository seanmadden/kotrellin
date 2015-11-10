public data class Card (
    val id: String = "",
    val badges: Badges = Badges(),
    val checkItemStates: List<Any> = kotlin.emptyList(),
    val closed: Boolean = false,
    val dateLastActivity: String? = "",
    val desc: String = "",
    val descData: Any? = "",
    val due: String? = "",
    val email: String? = "",
    val idAttachmentCover: String? = "",
    val idBoard: String = "",
    val idChecklists: List<Checklist> = kotlin.emptyList(),
    val idLabels: List<Any> = kotlin.emptyList(),
    val idList: String = "",
    val idMembers: List<Any> = kotlin.emptyList(),
    val idMembersVoted: List<Any> = kotlin.emptyList(),
    val idShort: Int = 0,
    val labels: List<Any> = kotlin.emptyList(),
    val manualCoverAttachment: Boolean? = false,
    val name: String = "",
    val pos: Double = 0.0,
    val shortLink: String = "",
    val shortUrl: String = "",
    val subscribed: Boolean? = false,
    val url: String = ""
)

public data class Badges (
        val votes: Int = 0,
        val viewingMemberVoted: Boolean = false,
        val subscribed: Boolean = false,
        val fogbugz: String = "",
        val checkItems: Int = 0,
        val checkItemsChecked: Int = 0,
        val comments: Int = 0,
        val attachments: Int = 0,
        val description: Boolean = false ,
        val due: String? = ""
)

public data class CardMetadata(
        val id: String,
        var name: String
)
