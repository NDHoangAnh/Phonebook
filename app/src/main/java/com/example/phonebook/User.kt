import android.os.Parcel
import android.os.Parcelable

class User(val id: Int, val name: String, val phoneNumber: String, val email: String) : Parcelable {

    // Parcel constructor
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    fun getUserName(): String {
        return name
    }

    fun getUserPhone(): String {
        return phoneNumber
    }

    fun getUserEmail(): String {
        return email
    }

    override fun toString(): String {
        return "User(id=$id, name=$name, phoneNumber=$phoneNumber, email=$email)"
    }

    // Function to write object data to a Parcel
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(phoneNumber)
        parcel.writeString(email)
    }

    // Creator that specifies how to create an instance of the class from a Parcel
    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        // Create an array of the class
        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }

    // Describe the kinds of special objects contained in this Parcelable instance
    override fun describeContents(): Int {
        return 0
    }
}
