package com.dicoding.tourismapp.core.data.source.local.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tourism")
data class TourismEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "tourismId")
    var tourismId: String,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "description")
    var description: String,

    @ColumnInfo(name = "address")
    var address: String,

    @ColumnInfo(name = "latitude")
    var latitude: Double,

    @ColumnInfo(name = "longitude")
    var longitude: Double,

    @ColumnInfo(name = "like")
    var like: Int,

    @ColumnInfo(name = "image")
    var image: String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
) : Parcelable {

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(tourismId)
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeString(address)
        parcel.writeDouble(latitude)
        parcel.writeDouble(longitude)
        parcel.writeInt(like)
        parcel.writeString(image)
        parcel.writeByte(if (isFavorite) 1 else 0)
    }

    companion object CREATOR : Parcelable.Creator<TourismEntity> {
        override fun createFromParcel(parcel: Parcel): TourismEntity {
            return TourismEntity(
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

        override fun newArray(size: Int): Array<TourismEntity?> {
            return arrayOfNulls(size)
        }
    }
}
