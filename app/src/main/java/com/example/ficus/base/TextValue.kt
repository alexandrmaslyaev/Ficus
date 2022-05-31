package com.example.ficus.base

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.PluralsRes
import androidx.annotation.StringRes
import com.example.ficus.ex.quantityStr
import com.example.ficus.ex.str
import kotlinx.parcelize.Parcelize

sealed class TextValue : Parcelable {

    abstract fun getText(context: Context): CharSequence

    fun getString(context: Context) = getText(context).toString()

    class Resource(
        @StringRes val id: Int,
        vararg val args: TextValue,
    ) : TextValue() {

        override fun getText(context: Context): CharSequence {
            val resolvedArgs = args.map { it.getText(context) }
            return context.str(id, *resolvedArgs.toTypedArray())
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            with(parcel) {
                writeInt(id)
                writeInt(args.size)
                args.forEach {
                    writeParcelable(it, flags)
                }
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Resource

            if (id != other.id) return false
            if (!args.contentEquals(other.args)) return false

            return true
        }

        override fun hashCode(): Int {
            var result = id
            result = 31 * result + args.contentHashCode()
            return result
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<Resource> {
            override fun createFromParcel(parcel: Parcel): Resource {
                return with(parcel) {
                    val id = readInt()
                    val argsSize = readInt()
                    val formatArgs = (0 until argsSize)
                        .mapNotNull { readParcelable(TextValue::class.java.classLoader) as? TextValue }
                        .toTypedArray()
                    Resource(id = id, args = formatArgs)
                }
            }

            override fun newArray(size: Int): Array<Resource?> {
                return arrayOfNulls(size)
            }
        }
    }

    @Parcelize
    data class Chars(val value: CharSequence) : TextValue() {
        override fun getText(context: Context): CharSequence = value
    }

    class Plural(
        @PluralsRes private val id: Int,
        val quantity: Int,
        vararg val args: TextValue,
    ) : TextValue() {

        override fun getText(context: Context): CharSequence {
            val resolvedArgs = args.map { it.getText(context) }
            return context.quantityStr(id, quantity, *resolvedArgs.toTypedArray())
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            with(parcel) {
                writeInt(id)
                writeInt(quantity)
                writeInt(args.size)
                args.forEach {
                    writeParcelable(it, flags)
                }
            }
        }

        override fun describeContents(): Int {
            return 0
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Plural

            if (id != other.id) return false
            if (quantity != other.quantity) return false
            if (!args.contentEquals(other.args)) return false

            return true
        }

        override fun hashCode(): Int {
            var result = id
            result = 31 * result + quantity
            result = 31 * result + args.contentHashCode()
            return result
        }

        companion object CREATOR : Parcelable.Creator<Plural> {
            override fun createFromParcel(parcel: Parcel): Plural {
                return with(parcel) {
                    val id = readInt()
                    val quantity = readInt()
                    val argsSize = readInt()
                    val formatArgs = (0 until argsSize)
                        .mapNotNull { readParcelable(TextValue::class.java.classLoader) as? TextValue }
                        .toTypedArray()
                    Plural(id = id, quantity = quantity, args = formatArgs)
                }
            }

            override fun newArray(size: Int): Array<Plural?> {
                return arrayOfNulls(size)
            }
        }
    }
}

fun CharSequence.toTextValueChars() = TextValue.Chars(value = this)
fun Int.toTextValueResource(vararg formatArgs: Any) =
    TextValue.Resource(
        id = this,
        args = formatArgs
            .map {
                when (it) {
                    is TextValue -> it
                    is String -> it.toTextValueChars()
                    else -> it.toString().toTextValueChars()
                }
            }.toTypedArray()
    )



