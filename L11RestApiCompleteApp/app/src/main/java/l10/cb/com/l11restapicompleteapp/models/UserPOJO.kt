package l10.cb.com.l11restapicompleteapp.models

/**
 * Created by ip510 feih on 29-06-2017.
 */

data class UserPOJO(

        val id: kotlin.Int,
        val name: String,
        val username: String,
        val email: String,
        val address: Address,
        val phone : String

) {

    data class Address(

            val street: String,
            val suite: String,
            val city: String

    )


}
