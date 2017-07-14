package l10.cb.com.l10restapi

/**
 * Created by ip510 feih on 28-06-2017.
 */

data class UserDetail(

        val id : kotlin.Int,
        val name : String,
        val username : String,
        val address : Address
){

    data class Address(

            val street : String,
            val city : String,
            val suite : String

    )


}