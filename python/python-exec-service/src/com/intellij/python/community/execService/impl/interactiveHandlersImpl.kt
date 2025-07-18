// Copyright 2000-2025 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package com.intellij.python.community.execService.impl

import com.intellij.platform.eel.EelProcess
import com.intellij.platform.eel.provider.utils.EelProcessExecutionResult
import com.intellij.python.community.execService.CustomErrorMessage
import com.intellij.python.community.execService.ProcessInteractiveHandler
import com.intellij.python.community.execService.ProcessSemiInteractiveFun
import com.jetbrains.python.Result
import com.jetbrains.python.mapError
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

internal class ProcessSemiInteractiveHandlerImpl<T>(private val code: ProcessSemiInteractiveFun<T>) : ProcessInteractiveHandler<T> {
  override suspend fun getResultFromProcess(process: EelProcess): Result<T, Pair<EelProcessExecutionResult, CustomErrorMessage?>> =
    coroutineScope {
      val processOutput = async { process.awaitWithReporting() }
      val result = code(process.stdin, process.exitCode)
      return@coroutineScope result.mapError { customErrorMessage ->
        Pair(processOutput.await(), customErrorMessage)
      }
    }
}
