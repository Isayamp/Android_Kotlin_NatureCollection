package com.emotg.naturecollection.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
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
        // Récuperer le nom de la plante
        val plantName:TextView? = view.findViewById(R.id.name_item)
        // Récuperer la description de la plante
        val plantDescription:TextView? = view.findViewById(R.id.description_item)
        // Récuperer l'état de like de la plante
        val starIcon = view.findViewById<ImageView>(R.id.star_icon)
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

        // Mettre à jour le nom de la plante
        holder.plantName?.text = currentPlant.neme

        // Mettre à jour la description
        holder.plantDescription?.text  = currentPlant.description

        // Verifier si la plante a été likée
        if (currentPlant.liked) {
            holder.starIcon.setImageResource(R.drawable.ic_star)
        }
        else {
            holder.starIcon.setImageResource(R.drawable.ic_unlike)
        }


        // Ajouter ou retirer un like
        holder.starIcon.setOnClickListener {
            // Inverser si la plante est likée ou non
            currentPlant.liked = !currentPlant.liked
            //
        }
    }

    override fun getItemCount(): Int = plantList.size
}