package l10.cb.com.l11restapicompleteapp.models

/**
 * Created by ip510 feih on 29-06-2017.
 */

//create data class as its easier and simpler in kotlin
//models package will contain all the pojos
data class PostPOJO(

        val userId : kotlin.Int,
        val id : kotlin.Int,
        val title : String,
        val body : String

)
