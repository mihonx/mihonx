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
public class TrackUpdateBuilder internal constructor() {
    private var _status: TrackUpdate.Field<TrackStatus>? = null
    private var _chapterProgress: TrackUpdate.Field<Double>? = null
    private var _volumeProgress: TrackUpdate.Field<Double>? = null
    private var _score: TrackUpdate.Field<Int>? = null
    private var _startDate: TrackUpdate.Field<Instant>? = null
    private var _finishDate: TrackUpdate.Field<Instant>? = null
    private var _private: TrackUpdate.Field<Boolean>? = null

    public var status: TrackStatus?
        get() = _status?.value
        set(value) {
            _status = TrackUpdate.Field(value)
        }

    public var chapterProgress: Double?
        get() = _chapterProgress?.value
        set(value) {
            _chapterProgress = TrackUpdate.Field(value)
        }

    public var volumeProgress: Double?
        get() = _volumeProgress?.value
        set(value) {
            _volumeProgress = TrackUpdate.Field(value)
        }

    public var score: Int?
        get() = _score?.value
        set(value) {
            _score = TrackUpdate.Field(value)
        }

    public var startDate: Instant?
        get() = _startDate?.value
        set(value) {
            _startDate = TrackUpdate.Field(value)
        }

    public var finishDate: Instant?
        get() = _finishDate?.value
        set(value) {
            _finishDate = TrackUpdate.Field(value)
        }

    public var private: Boolean?
        get() = _private?.value
        set(value) {
            _private = TrackUpdate.Field(value)
        }

    public fun build(): TrackUpdate = TrackUpdateImpl(
        status = _status,
        chapterProgress = _chapterProgress,
        volumeProgress = _volumeProgress,
        score = _score,
        startDate = _startDate,
        finishDate = _finishDate,
        private = _private,
    )

    @OptIn(ExperimentalTime::class)
    private data class TrackUpdateImpl(
        override val status: TrackUpdate.Field<TrackStatus>?,
        override val chapterProgress: TrackUpdate.Field<Double>?,
        override val volumeProgress: TrackUpdate.Field<Double>?,
        override val score: TrackUpdate.Field<Int>?,
        override val startDate: TrackUpdate.Field<Instant>?,
        override val finishDate: TrackUpdate.Field<Instant>?,
        override val private: TrackUpdate.Field<Boolean>?,
    ) : TrackUpdate
}
