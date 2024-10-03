import android.os.Parcel
import android.os.Parcelable

// Clase Product que implementa Parcelable para permitir su paso entre Activities
data class Product(
    val name: String,
    val price: Double,
    val quantity: Int
) : Parcelable {
    // Constructor que se utiliza para reconstruir el objeto Product a partir de un Parcel
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "", // Asegura que nunca sea null
        parcel.readDouble(),
        parcel.readInt()
    )

    // Escribe las propiedades del objeto en el Parcel
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeDouble(price)
        parcel.writeInt(quantity)
    }

    // Describe el contenido del Parcel, usualmente 0
    override fun describeContents(): Int = 0

    // Companion object para permitir la creación de Product desde un Parcel
    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }
}
