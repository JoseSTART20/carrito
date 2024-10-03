package com.example.carrito

import android.os.Bundle
import android.util.Log  // Importar Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CartActivity : AppCompatActivity() {

    private var cartList: ArrayList<Product>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        // Recuperar la lista del intent
        cartList = intent.getParcelableArrayListExtra<Product>("cartList")

        // Depuración: Verificar si la lista no es nula y mostrar un mensaje en Logcat
        if (cartList == null || cartList!!.isEmpty()) {
            Toast.makeText(this, "El carrito está vacío.", Toast.LENGTH_SHORT).show()
        } else {
            // Depuración: Mostrar en log el tamaño de la lista
            Log.d("CartActivity", "Tamaño del carrito: ${cartList!!.size}")
        }

        // Configurar el RecyclerView para mostrar los productos del carrito
        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewCart)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Crear un adaptador para el carrito
        val adapter = ProductAdapter(cartList!!) // Asegúrate de usar el adaptador correcto
        recyclerView.adapter = adapter
    }
}

