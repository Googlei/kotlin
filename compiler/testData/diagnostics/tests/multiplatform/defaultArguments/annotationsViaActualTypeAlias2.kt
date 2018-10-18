// !LANGUAGE: +MultiPlatformProjects
// MODULE: m1-common
// FILE: common.kt

import kotlin.reflect.KClass

expect annotation class Anno(
    val b: Byte = 1.toByte(),
    val c: Char = 'x',
    val d: Double = 3.14,
    val f: Float = -2.72f,
    val i: Int = 42424242,
    val j: Long = 239239239239239L,
    val j2: Long = 239239L,
    val s: Short = 42.toShort(),
    val z: Boolean = true,
    val ba: ByteArray = [(-1).toByte()],
    val ca: CharArray = ['y'],
    val da: DoubleArray = [-3.14159],
    val fa: FloatArray = [2.7218f],
    val ia: IntArray = [424242],
    val ja: LongArray = [239239239239L, 239239L],
    val sa: ShortArray = [(-43).toShort()],
    val za: BooleanArray = [false, true],
    val str: String = "fizz",
    // TODO: val k: KClass<*> = Number::class,
    val e: E = E.E1,
    // TODO: val a: A = A("1"),
    val stra: Array<String> = ["bu", "zz"],
    // TODO: val ka: Array<KClass<*>> = [Double::class, String::class, LongArray::class, Array<Array<Array<Int>>>::class],
    val ea: Array<E> = [E.E2, E.E3]
    // TODO: val aa: Array<A> = [A("2"), A("3")]
)

enum class E { E1, E2, E3 }

annotation class A(val value: String)

@Anno
fun test() {}

// MODULE: m2-jvm(m1-common)
// FILE: jvm.kt

actual typealias Anno = Jnno

// FILE: Jnno.java

public @interface Jnno {
    byte b() default 1;
    char c() default 'x';
    double d() default 3.14;
    float f() default -2.72f;
    int i() default 42424242;
    long j() default 239239239239239L;
    long j2() default 239239;
    short s() default 42;
    boolean z() default true;
    byte[] ba() default {-1};
    char[] ca() default {'y'};
    double[] da() default {-3.14159};
    float[] fa() default {2.7218f};
    int[] ia() default {424242};
    long[] ja() default {239239239239L, 239239};
    short[] sa() default {-43};
    boolean[] za() default {false, true};
    String str() default "fizz";
    // TODO: Class<?> k() default Number.class;
    E e() default E.E1;
    // TODO: A a() default @A("1");
    String[] stra() default {"bu", "zz"};
    // TODO: Class<?>[] ka() default {double.class, String.class, long[].class, Integer[][][].class};
    E[] ea() default {E.E2, E.E3};
    // TODO: A[] aa() default {@A("2"), @A("3")};
}
