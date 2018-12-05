/*
 * Copyright (C) 2018 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.squareup.wire.gradle

import com.squareup.wire.WireCompiler
import com.squareup.wire.WireRun
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.SourceTask
import org.gradle.api.tasks.TaskAction
import java.io.File

open class WireTask : SourceTask() {
  @Input fun pluginVersion() = ""

  @get:OutputDirectory var outputDirectory: File? = null

  lateinit var sourceFolders: Iterable<File>

  @TaskAction
  fun generateWireFiles() {
    val wireRun = WireRun(sourcePath = listOf("sourceA", "sourceB"),
        protoPath = listOf("protoA", "protoB"),
        treeShakingRoots = listOf("rootA", "rootB"),
        treeShakingRubbish = listOf("rubbA", "rubbB"),
        targets = listOf(
            WireRun.Target.JavaTarget(
                elements = listOf("elementA", "elementB"),
                outDirectory = "/foo",
                android = false,
                androidAnnotations = false,
                compact = false),
            WireRun.Target.KotlinTarget(
                elements = listOf("elementK", "elementL"),
                outDirectory = "/bar",
                android = false,
                javaInterop = false
            )
        )
    )

    val wireCompiler = WireCompiler.forArgs(args = *arrayOf("..."))
    //wireCompiler.compile()
  }
}