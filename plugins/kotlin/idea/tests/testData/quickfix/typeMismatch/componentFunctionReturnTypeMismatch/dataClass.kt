// "Change type of accessed property 'A.x' to 'String'" "true"

// See KT-15028 (CCE)
data class A(val x: Int, val y: String)

fun f1(a: A) {
    val (x: String, y) = a<caret>
}
// FUS_QUICKFIX_NAME: org.jetbrains.kotlin.idea.quickfix.ChangeCallableReturnTypeFix$ForCalled
// FUS_K2_QUICKFIX_NAME: org.jetbrains.kotlin.idea.k2.codeinsight.fixes.ChangeTypeQuickFixFactories$UpdateTypeQuickFix