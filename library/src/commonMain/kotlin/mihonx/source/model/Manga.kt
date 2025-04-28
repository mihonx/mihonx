/*
 * Copyright (C) 2025 AntsyLich and MihonX Open Source Project contributors
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package mihonx.source.model

/**
 * Represents a manga entity with metadata such as title, authors, status, and more.
 *
 * @property key            Unique identifier for a manga, scoped to a [Source].
 * @property title          The main title of the manga.
 * @property coverKey       Key used to resolve the manga's cover image.
 * @property altTitles      List of alternative titles for the manga.
 * @property artists        List of artists who worked on the manga.
 * @property authors        List of authors who wrote the manga.
 * @property status         The publication status of the manga.
 * @property rating         The overall rating of the manga, or `null` if not available.
 * @property description    A synopsis or brief description of the manga.
 * @property genres         List of genres associated with the manga.
 * @property updateStrategy Specifies the update strategy for this manga while performing library update.
 * @property initialized    Indicates whether the manga's details have been fully loaded.
 * @property auxiliaryData  Some string containing auxiliary data related to the manga.
 *
 * @since 1.0.0
 */
@Suppress("MemberVisibilityCanBePrivate")
class Manga(
    val key: String,
    val title: String,
    val coverKey: String? = null,
    val altTitles: List<String> = emptyList(),
    val artists: List<String> = emptyList(),
    val authors: List<String> = emptyList(),
    val status: MangaStatus = MangaStatus.Unknown,
    val rating: Float? = null,
    val description: String = "",
    val genres: List<String> = emptyList(),
    val updateStrategy: MangaUpdateStrategy = MangaUpdateStrategy.AlwaysUpdate,
    val initialized: Boolean = false,
    val auxiliaryData: String = "",
)
