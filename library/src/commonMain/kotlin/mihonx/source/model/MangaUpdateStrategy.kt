package mihonx.source.model

/**
 * Defines the update strategy for manga metadata and chapters.
 *
 * @since 1.0.0
 */
@Suppress("UNUSED")
enum class MangaUpdateStrategy {
    /**
     * Both manga metadata and chapters should always be updated when new information is available.
     *
     * @since 1.0.0
     */
    AlwaysUpdate,

    /**
     * Both manga metadata and chapters are fetched only once and will not be updated afterward.
     *
     * @since 1.0.0
     */
    OnlyFetchOnce,
}
