import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

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
    alias(mihonx.plugins.kotlin.multiplatform)
    alias(mihonx.plugins.maven.publish)
    alias(mihonx.plugins.spotless)
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    androidLibrary {
        namespace = "mihonx.auth"
    }

    @OptIn(ExperimentalKotlinGradlePluginApi::class)
    dependencies {
        implementation(libs.kotlinx.coroutines.core)
        implementation(libs.kotlinx.serialization.json)
    }
}
