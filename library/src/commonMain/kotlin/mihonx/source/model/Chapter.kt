/*
 * Copyright (C) 2025 AntsyLich and MihonX Open Source Project contributors
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package mihonx.source.model

/**
 * Represents a chapter of a [Manga], containing metadata such as chapter number, volume, and more.
 *
 * @property key            Unique identifier for a chapter, scoped to a [Manga]
 * @property language       Refer to [Source.language]. Should never be [Source.Language.MULTI]
 * @property number         The chapter number, with `-1` indicating an unknown number.
 * @property volume         The volume number, with `-1` indicating an unknown volume.
 * @property name           The optional name or title of the chapter.
 * @property dateUpload     The upload date of the chapter, represented as a Unix timestamp.
 * @property scanlators     List of scanlators (groups or individuals) who worked on this chapter.
 * @property type           Type of the chapter (e.g. monochrome/colored or chapter/volume etc.)
 * @property lockStatus     Indicates the lock status of the chapter.
 * @property auxiliaryData  Some string containing auxiliary data related to the chapter.
 *
 * @since 1.0.0
 */
@Suppress("MemberVisibilityCanBePrivate")
class Chapter(
    val key: String,
    val language: String,
    val number: Float = -1f,
    val volume: Float = -1f,
    val name: String? = null,
    val dateUpload: Long = 0,
    val scanlators: List<String> = emptyList(),
    val type: String? = null,
    val lockStatus: ChapterLockStatus = ChapterLockStatus.NONE,
    val auxiliaryData: String = "",
)
