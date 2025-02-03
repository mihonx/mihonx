/*
 * Copyright (C) 2025 AntsyLich and MihonX Open Source Project contributors
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package mihonx.source.model

/**
 * Represents a page in a [Chapter].
 * A page can either contain a URL to an image, textual content, or other complete page formats.
 *
 * @since 1.0.0
 */
sealed interface Page

/**
 * Represents a page identified by a key, typically referring to a URL.
 * This page will require further processing or resolution to get [PageComplete].
 *
 * @property key           Key used to resolve [PageComplete].
 * @property auxiliaryData Some string containing auxiliary data related to the page.
 *
 * @since 1.0.0
 */
@Suppress("MemberVisibilityCanBePrivate")
class PageUrl(
    val key: String,
    val auxiliaryData: String = "",
) : Page

/**
 * Represents a fully resolved page that does not require additional processing.
 * This includes pages with complete image URLs or text.
 *
 * @since 1.0.0
 */
sealed interface PageComplete : Page

/**
 * Represents a page that contains one or more image URLs.
 *
 * @property urls The list of image URLs for the page.
 *
 * @since 1.0.0
 */
@Suppress("MemberVisibilityCanBePrivate", "UNUSED")
class PageImageUrl(val urls: List<String>) : PageComplete {
    /**
     * Constructs a [PageImageUrl] with a single image URL.
     *
     * @param url The URL of the image.
     * @since 1.0.0
     */
    constructor(url: String) : this(listOf(url))
}

/**
 * Represents a page that contains text instead of an image.
 *
 * @property text The textual content of the page.
 *
 * @since 1.0.0
 */
@Suppress("MemberVisibilityCanBePrivate", "UNUSED")
class PageText(val text: String) : PageComplete
