// Copyright 2000-2023 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package com.intellij.java.codeInspection.java19api

import com.intellij.codeInspection.java19api.NameConverterUtil
import junit.framework.TestCase

class Java9GenerateModuleDescriptorsTest : TestCase() {

  fun testNameConverter() {
    doTestName("foo", ".foo")
    doTestName("foo", "foo.")
    doTestName("foo", ".foo")
    doTestName("foo", ".foo.")
    doTestName("foo.bar", "foo.bar")
    doTestName("foo.bar", ".foo.bar...")

    doTestName("module0", "0")
    doTestName("module1.foo", "1.foo")
    doTestName("foo2", "foo.2")
    doTestName("foo3.bar", "foo.3.bar")
    doTestName("foo45.bar", "foo.45.bar")
    doTestName("foo67.bar", "foo.6.7.bar")
    doTestName("module8.foo.bar9", "8.foo.bar.9")
    doTestName("forx.intx.open", "for.int.open")
  }

  private fun doTestName(expected:String, name:String) {
    assertEquals(expected, NameConverterUtil.convertModuleName(name))
  }
}