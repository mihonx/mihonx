/*
 * Copyright (C) 2025 AntsyLich and MihonX contributors.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 * SPDX-License-Identifier: MPL-2.0
 */
plugins {
    alias(mihonx.plugins.spotless)
    alias(mihonx.plugins.detekt)
}

val buildConfig = gradle.includedBuild("build-config")
tasks {
    listOf("detekt", "spotlessApply", "spotlessCheck").forEach {
        named(it) {
            dependsOn(buildConfig.task(":$it"))
        }
    }
}
