/*
 * Copyright (C) 2025 AntsyLich and MihonX Open Source Project contributors
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package mihonx.source

import mihonx.Extension
import mihonx.ExtensionContext
import mihonx.source.model.Chapter
import mihonx.source.model.Filter
import mihonx.source.model.Listing
import mihonx.source.model.Manga
import mihonx.source.model.Page

/**
 * A type of extension that lets user read various [Manga]
 */
@Suppress("UNUSED")
abstract class Source(context: ExtensionContext) : Extension(context) {
    /**
     * Unique identifier of the source
     *
     * @since 1.0.0
     */
    abstract val id: Long

    /**
     * Name of the source
     *
     * @since 1.0.0
     */
    abstract val name: String

    /**
     * Represents an IETF BCP 47 compliant language tag applicable for the source.
     * Special cases include: [Language.MULTI], [Language.OTHER]
     *
     * @since 1.0.0
     */
    abstract val language: String

    /**
     * An ordered list of [Listing] applicable for the source
     *
     * @since 1.0.0
     */
    abstract suspend fun getListings(): List<Listing>

    /**
     * An ordered list of [Filter] applicable for the source
     *
     * @since 1.0.0
     */
    abstract suspend fun getSearchFilters(): List<Filter>

    // TODO: Appropriate description
    /**
     * @since 1.0.0
     */
    // TODO: Formulate the return type. Should be something like 'androidx.paging.PagingSource'
    abstract suspend fun getMangaList(listing: Listing)

    // TODO: Appropriate description
    /**
     * @since 1.0.0
     */
    // TODO: Formulate the return type. Should be something like 'androidx.paging.PagingSource'
    abstract suspend fun getMangaList(query: String, filters: List<Filter>?)

    /**
     * Get the updated details for a manga and its chapters
     *
     * @param manga         manga to get details and chapters for
     * @param updateManga   whether to update the manga details or not
     * @param fetchChapters whether to fetch chapters or not
     *
     * @since 1.0.0
     */
    abstract suspend fun getMangaDetails(manga: Manga, updateManga: Boolean, fetchChapters: Boolean): Pair<Manga, List<Chapter>>

    /**
     * Get an ordered list of pages a chapter has
     *
     * @param chapter the chapter.
     *
     * @since 1.0.0
     */
    abstract suspend fun getChapterPages(chapter: Chapter): List<Page>

    /**
     * Object for holding the special cases supported by [Source.language].
     *
     * @since 1.0.0
     */
    object Language {
        /**
         * Indicates multiple languages
         *
         * @since 1.0.0
         */
        const val MULTI = "multi"

        /**
         * Indicates that the language isn't explicitly defined (e.g. text less)
         *
         * @since 1.0.0
         */
        const val OTHER = "other"
    }
}
