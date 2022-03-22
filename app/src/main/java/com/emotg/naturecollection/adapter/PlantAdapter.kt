package com.emotg.naturecollection.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideExtension
import com.bumptech.glide.annotation.GlideModule
import com.emotg.naturecollection.MainActivity
import com.emotg.naturecollection.PlantModel
import com.emotg.naturecollection.R

class PlantAdapter(
    private val context: MainActivity,
    private val plantList: List<PlantModel>,
    private val layoutId: Int
    ) : RecyclerView.Adapter<PlantAdapter.ViewHolder>() {

    /* Boîte pour ranger tout les composants à contrôler */

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Récuperer l'image de la plante
        val plantImage = view.findViewById<ImageView>(R.id.image_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        // recuperer les informations de la plante
        val currentPlant = plantList[position]

        // utiliser Glide pour récuperer l'image à partir de son lien vers le composant
        Glide.with(context).load(Uri.parse(currentPlant.imageUrl)).into(holder.plantImage)
    }

    override fun getItemCount(): Int = plantList.size
}