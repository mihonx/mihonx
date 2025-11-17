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
 * Represents a user's authentication session.
 *
 * @property user The authenticated user.
 * @property authExpired Whether the authentication has expired.
 * @property authRevoked Whether the authentication has been revoked.
 * @property memo Extra metadata associated with the session.
 */
@Serializable
public data class AuthSession(
    val user: User,
    val authExpired: Boolean,
    val authRevoked: Boolean,
    val memo: Map<String, String>,
)
