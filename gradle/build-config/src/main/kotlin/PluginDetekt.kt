/*
 * Copyright (C) 2025 AntsyLich and MihonX contributors.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 * SPDX-License-Identifier: MPL-2.0
 */
import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import mihonx.gradle.extensions.alias
import mihonx.gradle.extensions.libs
import mihonx.gradle.extensions.plugins
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

internal class PluginDetekt : Plugin<Project> {
    override fun apply(target: Project): Unit = with(target) {
        plugins {
            alias(libs.plugins.detekt)
        }

        val detektConfigFile = rootProject.file("gradle/build-config/detekt/config.yml")
        detekt {
            parallel = true
            config.setFrom(detektConfigFile)
            buildUponDefaultConfig = true
        }
    }
}

private fun Project.detekt(action: DetektExtension.() -> Unit) {
    extensions.configure(action)
}
