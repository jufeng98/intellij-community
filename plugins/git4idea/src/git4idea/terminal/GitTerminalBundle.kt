// Copyright 2000-2020 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package git4idea.terminal

import com.intellij.DynamicBundle
import org.jetbrains.annotations.Nls
import org.jetbrains.annotations.NonNls
import org.jetbrains.annotations.PropertyKey

object GitTerminalBundle {
  @NonNls
  const val BUNDLE: String = "messages.GitTerminalBundle"
  private val INSTANCE = DynamicBundle(GitTerminalBundle::class.java, BUNDLE)

  @Nls
  fun message(@PropertyKey(resourceBundle = BUNDLE) key: String, vararg params: Any): String {
    return INSTANCE.getMessage(key, *params)
  }
}