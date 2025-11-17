/*
 * Copyright (C) 2025 AntsyLich and MihonX contributors.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 * SPDX-License-Identifier: MPL-2.0
 */
package mihonx.tracker

import mihonx.tracker.models.TrackScoreType
import mihonx.tracker.models.TrackState
import mihonx.tracker.models.TrackStatus
import mihonx.tracker.models.TrackUpdate
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

public interface Tracker {

    public val id: String

    public val name: String

    public val capabilities: List<Capability>

    public val supportedStatuses: List<TrackStatus>

    public val scoreType: TrackScoreType?

    public fun search(query: String, includeNsfw: Boolean): List<TrackState>

    @OptIn(ExperimentalTime::class)
    public fun track(
        id: String,
        startedAt: Instant,
        progress: String?,
        progressUpdatedAt: Instant?,
        private: Boolean,
    ): TrackState

    public fun get(libraryId: String): TrackState

    public fun update(libraryId: String, update: TrackUpdate): TrackState

    public enum class Capability {
        PrivateTracking,
    }
}
