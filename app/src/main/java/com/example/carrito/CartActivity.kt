package com.example.carrito

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.carrito.Product

class CartActivity : AppCompatActivity() {

    private var cartList: ArrayList<Product>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        // Obtener el RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewCart)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Obtener la lista del carrito desde el Intent
        cartList = intent.getParcelableArrayListExtra<Product>("cartList")

        if (cartList != null) {
            // Configurar el adaptador para el RecyclerView
            val adapter = ProductAdapter(cartList!!)
            recyclerView.adapter = adapter
        } else {
            // Manejar el caso en el que cartList sea null
            Toast.makeText(this, "El carrito está vacío", Toast.LENGTH_SHORT).show()
        }
    }
}
