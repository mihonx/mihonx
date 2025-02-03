package mihonx.source.model

/**
 * Represents the lock status of a [Chapter].
 *
 * @property isLocked Indicates whether the chapter is locked.
 *
 * @since 1.0.0
 */
@Suppress("UNUSED")
enum class ChapterLockStatus(val isLocked: Boolean) {
    /**
     * The chapter is unlocked for all.
     *
     * @since 1.0.0
     */
    NONE(isLocked = false),

    /**
     * The chapter is locked.
     *
     * @since 1.0.0
     */
    LOCKED(isLocked = true),

    /**
     * The chapter is unlocked for the user.
     *
     * @since 1.0.0
     */
    UNLOCKED(isLocked = false),
}
