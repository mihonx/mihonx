/*
 * Copyright (C) 2025 AntsyLich and MihonX contributors.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 * SPDX-License-Identifier: MPL-2.0
 */
package mihonx.tracker.models

import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OptIn(ExperimentalTime::class)
public data class TrackState(
    val id: String,
    val libraryId: String,
    val score: Int?,
    val status: TrackStatus?,
    val chapterProgress: Double?,
    val volumeProgress: Double?,
    val totalChapters: Double?,
    val totalVolumes: Double?,
    val startDate: Instant?,
    val finishDate: Instant?,
)
