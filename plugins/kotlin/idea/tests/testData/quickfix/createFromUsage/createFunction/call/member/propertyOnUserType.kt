// "Create member function 'foo'" "false"

class A<T>(val n: T) {
    fun foo(p: Int) {

    }
}

fun test() {
    A(1).<caret>foo(1)
}