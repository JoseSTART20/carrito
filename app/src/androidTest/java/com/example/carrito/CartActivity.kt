package com.example.carrito

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.os.Parcelable

class CartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart) // Vincula con el layout de la actividad del carrito

        // Obtener la lista de productos del carrito
        val cartList = intent.getParcelableArrayListExtra<Product>("cartList")

        // Mostrar la lista de productos en un TextView (puedes cambiar esto a un RecyclerView)
        val textViewCart: TextView = findViewById(R.id.textViewCart)

        // Mostrar los productos del carrito
        textViewCart.text = cartList?.joinToString("\n") { "${it.name} - \$${it.price}" }
    }
}
