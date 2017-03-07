package  mat

import main.BYTES
import main.f
import mat.operators.mat2x2_operators
import vec.Vec2t
import vec._2.Vec2
import main.Glm.inverse
import main.Glm.transpose

/**
 * Created by GBarbieri on 10.11.2016.
 */
data class Mat2x2(override var value: MutableList<Vec2>) : Mat2x2t<Vec2> {


    // -- Constructors --

    constructor() : this(mutableListOf(
            Vec2(1f, 0f),
            Vec2(0f, 1f)))

    constructor(scalar: Number) : this(mutableListOf(
            Vec2(scalar, 0),
            Vec2(0, scalar)))

    constructor(x0: Number, x1: Number, y0: Number, y1: Number) : this(mutableListOf(
            Vec2(x0, y0),
            Vec2(x1, y1)))

    constructor(v0: Vec2t<out Number>, v1: Vec2t<out Number>) : this(mutableListOf(
            Vec2(v0),
            Vec2(v1)))

    // -- Matrix conversions --

    constructor(mat2x2: Mat2x2t<*>) : this(mutableListOf(
            Vec2(mat2x2[0]),
            Vec2(mat2x2[1])))

    constructor(mat3: Mat3x3) : this(mutableListOf(
            Vec2(mat3[0]),
            Vec2(mat3[1])))

    constructor(mat4: Mat4x4) : this(mutableListOf(
            Vec2(mat4[0]),
            Vec2(mat4[1])))

    constructor(mat2x3: Mat2x3t<*>) : this(mutableListOf(
            Vec2(mat2x3[0]),
            Vec2(mat2x3[1])))

    constructor(mat3x2: Mat3x2t<*>) : this(mutableListOf(
            Vec2(mat3x2[0]),
            Vec2(mat3x2[1])))

    constructor(mat2x4: Mat2x4t<*>) : this(mutableListOf(
            Vec2(mat2x4[0]),
            Vec2(mat2x4[1])))

    constructor(mat4x2: Mat4x2t<*>) : this(mutableListOf(
            Vec2(mat4x2[0]),
            Vec2(mat4x2[1])))

    // to
    fun to(mat2x2: Mat2x2t<*>) {
        value = mutableListOf(
                Vec2(mat2x2.value[0]),
                Vec2(mat2x2.value[1]))
    }

    fun to(scalar: Number) {
        value = mutableListOf(
                Vec2(scalar.f, 0),
                Vec2(0, scalar.f))
    }

    fun to(x0: Number, x1: Number, y0: Number, y1: Number) {
        value = mutableListOf(
                Vec2(x0.f, y0.f),
                Vec2(x1.f, y1.f))
    }

    fun to(v0: Vec2t<*>, v1: Vec2t<*>) {
        value = mutableListOf(
                Vec2(v0),
                Vec2(v1))
    }

    // -- Accesses --

    override operator fun get(i: Int) = value[i]

    operator fun set(i: Int, v: Vec2) = value[i] put v

    // -- Matrix functions --

    fun det() = value[0][0] * value[1][1] - value[1][0] * value[0][1]

    fun inverse(res: Mat2x2 = Mat2x2()) = inverse(res, this)
    fun inverse_() = inverse(this, this)

    fun transpose(res: Mat2x2 = Mat2x2()) = transpose(res, this)
    fun transpose_() = transpose(this, this)

    // TODO inc


    fun identity(): Mat2x2 {
        value[0][0] = 1f; value[1][0] = 0f
        value[0][1] = 0f; value[1][1] = 1f
        return this
    }


    companion object : mat2x2_operators {

        @JvmField val SIZE = 2 * 2 * Float.BYTES
    }


    // -- operators --

    operator fun plus(b: Mat2x2) = Mat2x2.add(Mat2x2(), this, b)
    operator fun plus(b: Float) = Mat2x2.add(Mat2x2(), this, b)

    infix fun add(b: Mat2x2) = Mat2x2.add(Mat2x2(), this, b)
    infix fun add(b: Float) = Mat2x2.add(Mat2x2(), this, b)

    fun add(b: Mat2x2, res: Mat2x2) = Mat2x2.add(res, this, b)
    fun add(b: Float, res: Mat2x2) = Mat2x2.add(res, this, b)

    fun add_(b: Mat2x2) = Mat2x2.add(this, this, b)
    fun add_(b: Float) = Mat2x2.add(this, this, b)


    operator fun minus(b: Mat2x2) = Mat2x2.sub(Mat2x2(), this, b)
    operator fun minus(b: Float) = Mat2x2.sub(Mat2x2(), this, b)

    infix fun sub(b: Mat2x2) = Mat2x2.sub(Mat2x2(), this, b)
    infix fun sub(b: Float) = Mat2x2.sub(Mat2x2(), this, b)

    fun sub(b: Mat2x2, res: Mat2x2) = Mat2x2.sub(res, this, b)
    fun sub(b: Float, res: Mat2x2) = Mat2x2.sub(res, this, b)

    fun sub_(b: Mat2x2) = Mat2x2.sub(this, this, b)
    fun sub_(b: Float) = Mat2x2.sub(this, this, b)


    operator fun times(b: Mat2x2) = Mat2x2.mul(Mat2x2(), this, b)
    operator fun times(b: Mat3x2) = Mat2x2.mul(TODO(), this, b)
    operator fun times(b: Mat4x2) = Mat2x2.mul(TODO(), this, b)
    operator fun times(b: Float) = Mat2x2.mul(Mat2x2(), this, b)

    infix fun mul(b: Mat2x2) = Mat2x2.mul(Mat2x2(), this, b)
    infix fun mul(b: Float) = Mat2x2.mul(Mat2x2(), this, b)

    fun mul(b: Mat2x2, res: Mat2x2) = Mat2x2.mul(res, this, b)
    fun mul(b: Float, res: Mat2x2) = Mat2x2.mul(res, this, b)

    fun mul_(b: Mat2x2) = Mat2x2.mul(this, this, b)
    fun mul_(b: Float) = Mat2x2.mul(this, this, b)


    infix operator fun div(b: Mat2x2) = Mat2x2.div(Mat2x2(), this, b)
    infix operator fun div(b: Float) = Mat2x2.div(Mat2x2(), this, b)

    fun div(b: Mat2x2, res: Mat2x2) = Mat2x2.div(res, this, b)
    fun div(b: Float, res: Mat2x2) = Mat2x2.div(res, this, b)

    fun div_(b: Mat2x2) = Mat2x2.div(this, this, b)
    fun div_(b: Float) = Mat2x2.div(this, this, b)


    // TODO others
    var a0: Float
        @JvmName("v00") get() = value[0][0]
        @JvmName("v00") set(v) {
            value[0][0] = v
        }
    var a1: Float
        @JvmName("v01") get() = value[0][1]
        @JvmName("v01") set(v) {
            value[0][1] = v
        }

    var b0: Float
        @JvmName("v10") get() = value[1][0]
        @JvmName("v10") set(v) {
            value[1][0] = v
        }
    var b1: Float
        @JvmName("v11") get() = value[1][1]
        @JvmName("v11") set(v) {
            value[1][1] = v
        }

    override fun equals(other: Any?) =
            if (other is Mat2x2)
                this[0] == other[0] && this[1] == other[1]
            else false
}