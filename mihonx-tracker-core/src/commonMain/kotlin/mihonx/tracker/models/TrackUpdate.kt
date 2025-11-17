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
public interface TrackUpdate {

    public val status: Field<TrackStatus>?

    public val chapterProgress: Field<Double>?

    public val volumeProgress: Field<Double>?

    public val score: Field<Int>?

    public val startDate: Field<Instant>?

    public val finishDate: Field<Instant>?

    public val private: Field<Boolean>?

    public class Field<T>(public val value: T?)

    public companion object {
        public operator fun invoke(block: TrackUpdateBuilder.() -> Unit): TrackUpdate = TrackUpdateBuilder().apply(block).build()
    }
}
