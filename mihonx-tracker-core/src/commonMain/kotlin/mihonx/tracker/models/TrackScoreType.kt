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

public abstract class TrackScoreType {
    public abstract val options: List<String>

    public abstract fun toPercentile(value: String): Int

    public abstract fun fromPercentile(value: Int): String

    public data object TenPoint : TrackScoreType() {

        override val options: List<String> = (0..10).map(Int::toString)

        override fun toPercentile(value: String): Int = value.toInt() * 10

        override fun fromPercentile(value: Int): String = (value / 10).toString()
    }

    public data object TenPointDecimal : TrackScoreType() {

        override val options: List<String> = (0..10).flatMap {
            if (it == 10) return@flatMap listOf("10")
            (0..9).map { dec -> "$it.$dec" }
        }

        override fun toPercentile(value: String): Int = (value.toFloat() * 10).toInt()

        override fun fromPercentile(value: Int): String = (value / 10f).toString()
    }

    public data object HundredPoint : TrackScoreType() {

        override val options: List<String> = (0..100).map(Int::toString)

        override fun toPercentile(value: String): Int = value.toInt()

        override fun fromPercentile(value: Int): String = value.toString()
    }

    public data object FiveStar : TrackScoreType() {
        override val options: List<String> = (0..5).map { "$it ★" }

        override fun toPercentile(value: String): Int = options.indexOf(value) * 20

        override fun fromPercentile(value: Int): String = options[value / 20]
    }

    public data object Smiley : TrackScoreType() {
        override val options: List<String> = listOf("-", "😒", "😐", "😊")

        override fun toPercentile(value: String): Int = options.indexOf(value) * 33

        override fun fromPercentile(value: Int): String = options[value / 33]
    }

    // TODO(antsy): Kitsu, MangaUpdates
}
