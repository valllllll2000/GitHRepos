package com.vaxapp.repos.list.model

import android.os.Parcel
import android.os.Parcelable

data class ViewRepo(
    val fullName: String,
    val owner: ViewOwner,
    val description: String,
    val updatedAt: String,
    val language: String?,
    val openIssuesCount: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readParcelable(ViewOwner::class.java.classLoader) ?: ViewOwner(
            "",
            "",
            ""
        ),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(fullName)
        parcel.writeParcelable(owner, flags)
        parcel.writeString(description)
        parcel.writeString(updatedAt)
        parcel.writeString(language)
        parcel.writeInt(openIssuesCount)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ViewRepo> {
        override fun createFromParcel(parcel: Parcel): ViewRepo {
            return ViewRepo(parcel)
        }

        override fun newArray(size: Int): Array<ViewRepo?> {
            return arrayOfNulls(size)
        }
    }
}

data class ViewOwner(
    val login: String,
    val avatarUrl: String,
    val type: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(login)
        parcel.writeString(avatarUrl)
        parcel.writeString(type)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ViewOwner> {
        override fun createFromParcel(parcel: Parcel): ViewOwner {
            return ViewOwner(parcel)
        }

        override fun newArray(size: Int): Array<ViewOwner?> {
            return arrayOfNulls(size)
        }
    }
}
