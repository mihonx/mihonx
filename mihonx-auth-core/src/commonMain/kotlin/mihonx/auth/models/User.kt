package mihonx.auth.models

import kotlinx.serialization.Serializable

@Serializable
public data class User(
    val id: String,
    val name: String,
    val subtitle: String? = null,
    val memo: Map<String, String> = emptyMap(),
)
