/*
 * Copyright (C) 2025 AntsyLich and MihonX Open Source Project contributors
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package mihonx.source.model

/**
 * Represents the publication status of a manga.
 *
 * @since 1.0.0
 */
@Suppress("UNUSED")
enum class MangaStatus {
    /**
     * The status of the manga is unknown.
     *
     * @since 1.0.0
     */
    Unknown,

    /**
     * The manga is currently ongoing and new chapters may be released.
     *
     * @since 1.0.0
     */
    Ongoing,

    /**
     * The manga has been completed.
     *
     * @since 1.0.0
     */
    Completed,

    /**
     * The manga has been licensed for official distribution.
     *
     * @since 1.0.0
     */
    Licensed,

    /**
     * The manga has finished publishing, but may not be considered "Completed".
     *
     * @since 1.0.0
     */
    PublishingFinished,

    /**
     * The manga has been officially canceled and will not continue.
     *
     * @since 1.0.0
     */
    Cancelled,

    /**
     * The manga is currently on hiatus and may resume in the future.
     *
     * @since 1.0.0
     */
    OnHiatus,
}
