/*
 * Copyright (C) 2025 AntsyLich and MihonX contributors.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 * SPDX-License-Identifier: MPL-2.0
 */
package mihonx.auth.models

import kotlinx.serialization.Serializable

/**
 * Represents a user.
 *
 * @property id The unique identifier of the user.
 * @property name The name of the user.
 * @property subtitle An optional subtitle for the user.
 * @property avatar An optional URL for the user's avatar.
 */
@Serializable
public data class User(
    val id: String,
    val name: String,
    val subtitle: String? = null,
    val avatar: String? = null,
)
