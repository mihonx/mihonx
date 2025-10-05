/*
 * Copyright (C) 2025 AntsyLich and MihonX contributors.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 * SPDX-License-Identifier: MPL-2.0
 */
package mihonx.gradle.extensions

import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.accessors.dm.LibrariesForMihonx
import org.gradle.api.Project
import org.gradle.api.plugins.PluginManager
import org.gradle.kotlin.dsl.the

internal val Project.libs get() = the<LibrariesForLibs>()
internal val Project.mihonx get() = the<LibrariesForMihonx>()

internal fun Project.plugins(action: PluginManager.() -> Unit) {
    pluginManager.action()
}
