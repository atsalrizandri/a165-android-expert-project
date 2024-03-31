package com.dicoding.tourismapp.core.domain.model

import android.os.Parcel
import android.os.Parcelable

data class Tourism(
    val tourismID: String,
    val name: String,
    val description: String,
    val address: String,
    val latitude: Double,
    val longtitude: Double,
    val like: Int,
    val image: String,
    val isFavorite: Boolean
): Parcelable {

    // Implementasi metode describeContents()
    override fun describeContents(): Int {
        return 0
    }

    // Implementasi metode writeToParcel()
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(tourismID)
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeString(address)
        parcel.writeDouble(latitude)
        parcel.writeDouble(longtitude)
        parcel.writeInt(like)
        parcel.writeString(image)
        parcel.writeByte(if (isFavorite) 1 else 0)
    }

    // Companion object untuk Parcelable.Creator
    companion object CREATOR : Parcelable.Creator<Tourism> {
        override fun createFromParcel(parcel: Parcel): Tourism {
            return Tourism(
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readDouble(),
                parcel.readDouble(),
                parcel.readInt(),
                parcel.readString()!!,
                parcel.readByte() != 0.toByte()
            )
        }

        override fun newArray(size: Int): Array<Tourism?> {
            return arrayOfNulls(size)
        }
    }
}
