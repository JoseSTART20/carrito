package com.example.carrito

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(
    private val productList: List<Product>, // Lista de productos
    private val listener: OnProductClickListener // Interfaz para manejar eventos de clic
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    // Interfaz para manejar el clic en "Agregar al Carrito"
    interface OnProductClickListener {
        fun onAddToCartClick(product: Product)
    }

    // Vinculamos cada vista con el layout de item_product
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    // Vinculamos los datos de cada producto con su vista correspondiente
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.bind(product)
    }

    // Cantidad de productos a mostrar
    override fun getItemCount(): Int = productList.size

    // Clase interna que contiene las vistas de cada producto
    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val productName: TextView = itemView.findViewById(R.id.productName)
        private val productPrice: TextView = itemView.findViewById(R.id.productPrice)
        private val addToCartButton: Button = itemView.findViewById(R.id.buttonAddToCart)

        // Método para vincular los datos con las vistas
        fun bind(product: Product) {
            productName.text = product.name
            productPrice.text = product.price.toString()
            addToCartButton.setOnClickListener {
                listener.onAddToCartClick(product)
            }
        }
    }
}
