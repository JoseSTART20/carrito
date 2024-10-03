package com.example.carrito

import Product
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val productList = mutableListOf<Product>()
    private val cartList = mutableListOf<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar la lista de productos
        initProductList()

        // Configurar el RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewProducts)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Configurar el adaptador para el RecyclerView
        val adapter = ProductAdapter(productList, object : ProductAdapter.OnProductClickListener {
            override fun onAddToCartClick(product: Product) {
                addToCart(product)
            }
        })
        recyclerView.adapter = adapter

        // Botón "Ver Carrito"
        findViewById<Button>(R.id.buttonViewCart).setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            intent.putParcelableArrayListExtra("cartList", ArrayList(cartList))
            startActivity(intent)
        }
    }

    private fun initProductList() {
        productList.add(Product("Producto 1", 10.0, 1))
        productList.add(Product("Producto 2", 20.0, 1))
        productList.add(Product("Producto 3", 30.0, 1))
    }

    private fun addToCart(product: Product) {
        cartList.add(product)
        Toast.makeText(this, "${product.name} agregado al carrito", Toast.LENGTH_SHORT).show()
    }
}

