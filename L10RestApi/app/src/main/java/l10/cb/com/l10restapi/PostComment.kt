package l10.cb.com.l10restapi

/**
 * Created by ip510 feih on 28-06-2017.
 */
data class PostComment(

        val postId : kotlin.Int,
        val id : kotlin.Int,
        val name : String,
        val email : String,
        val body : String

)