/*
 * Copyright (C) 2025 AntsyLich and MihonX contributors.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 * SPDX-License-Identifier: MPL-2.0
 */
import com.vanniktech.maven.publish.MavenPublishBaseExtension
import mihonx.gradle.extensions.alias
import mihonx.gradle.extensions.libs
import mihonx.gradle.extensions.plugins
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class PluginMavenPublish : Plugin<Project> {
    override fun apply(target: Project): Unit = with(target) {
        plugins {
            alias(libs.plugins.maven.publish)
        }

        mavenPublishing {
            pom {
                url.set("https://github.com/mihonx/mihonx")

                licenses {
                    license {
                        name.set("Mozilla Public License 2.0")
                        url.set("https://www.mozilla.org/MPL/2.0")
                        distribution.set("repo")
                    }
                }

                organization {
                    name.set("MihonX")
                    url.set("https://github.com/mihonx")
                }

                developers {
                    developer {
                        id.set("antsylich")
                        name.set("AntsyLich")
                        url.set("https://github.com/AntsyLich")
                    }
                }

                scm {
                    url.set("https://github.com/mihonx/mihonx")
                    connection.set("scm:git:https://github.com/mihonx/mihonx.git")
                    developerConnection.set("scm:git:ssh://git@github.com/mihonx/mihonx.git")
                }

                issueManagement {
                    system.set("github")
                    url.set("https://github.com/mihonx/mihonx/issues")
                }

                ciManagement {
                    system.set("github")
                    url.set("https://github.com/mihonx/mihonx/actions")
                }
            }
        }
    }
}

private fun Project.mavenPublishing(action: MavenPublishBaseExtension.() -> Unit) {
    extensions.configure(action)
}
