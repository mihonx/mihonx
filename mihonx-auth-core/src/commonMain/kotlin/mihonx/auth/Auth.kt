package mihonx.auth

import kotlinx.coroutines.flow.Flow
import mihonx.auth.models.User

public sealed interface Auth {

    public val loggedInUser: Flow<User?>

    public fun logout()

    public interface OAuth : Auth {

        public fun getOAuthUrl(identifier: String): String

        public suspend fun onOAuthCallback(data: Map<String, String>): Boolean
    }
}
