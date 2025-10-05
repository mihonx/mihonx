/*
 * Copyright (C) 2025 AntsyLich and MihonX contributors.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 * SPDX-License-Identifier: MPL-2.0
 */
import com.android.build.api.dsl.KotlinMultiplatformAndroidCompilation
import com.android.build.api.dsl.androidLibrary
import compat.patrouille.configureJavaCompatibility
import compat.patrouille.configureKotlinCompatibility
import mihonx.gradle.extensions.alias
import mihonx.gradle.extensions.coreLibraryDesugaring
import mihonx.gradle.extensions.libs
import mihonx.gradle.extensions.mihonx
import mihonx.gradle.extensions.plugins
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.dsl.abi.AbiValidationMultiplatformExtension
import org.jetbrains.kotlin.gradle.dsl.abi.AbiValidationMultiplatformVariantSpec
import org.jetbrains.kotlin.gradle.dsl.abi.AbiValidationVariantSpec
import org.jetbrains.kotlin.gradle.dsl.abi.ExperimentalAbiValidation

internal class PluginKotlinMultiplatform : Plugin<Project> {
    override fun apply(target: Project): Unit = with(target) {
        plugins {
            alias(libs.plugins.kotlin.multiplatform)
            alias(libs.plugins.android.kmp.library)
        }

        configureJavaCompatibility(mihonx.versions.java.get().toInt())
        configureKotlinCompatibility(mihonx.versions.kotlin.get())

        kotlin {
            explicitApi()
            @OptIn(ExperimentalAbiValidation::class)
            abiValidation {
                enabled.set(true)

                klib {
                    enabled.set(true)
                }
            }

            @Suppress("UnstableApiUsage")
            androidLibrary {
                compileSdk = mihonx.versions.android.sdk.compile.get().toInt()
                minSdk = mihonx.versions.android.sdk.min.get().toInt()
                enableCoreLibraryDesugaring = true
            }
            jvm()

            @OptIn(ExperimentalKotlinGradlePluginApi::class)
            applyDefaultHierarchyTemplate {
                common {
                    withCompilations { true }

                    group("commonJvm") {
                        withCompilations { it is KotlinMultiplatformAndroidCompilation }
                        withJvm()
                    }

                    group("nonAndroid") {
                        withIos()
                        withJvm()
                        withMacos()
                    }

                    group("nonJvm") {
                        withIos()
                        withMacos()
                    }
                }
            }
        }

        dependencies {
            coreLibraryDesugaring(libs.android.desugar)
        }
    }
}

private fun Project.kotlin(block: KotlinMultiplatformExtension.() -> Unit) {
    extensions.configure(block)
}

private fun KotlinMultiplatformExtension.abiValidation(block: AbiValidationMultiplatformExtension.() -> Unit) {
    extensions.configure(block)
}

@OptIn(ExperimentalAbiValidation::class)
private fun AbiValidationMultiplatformExtension.klib(block: AbiValidationMultiplatformVariantSpec.() -> Unit) {
    variants.getByName(AbiValidationVariantSpec.MAIN_VARIANT_NAME).block()
}
