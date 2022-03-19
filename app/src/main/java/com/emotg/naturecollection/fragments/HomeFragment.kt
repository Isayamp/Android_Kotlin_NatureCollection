package com.emotg.naturecollection.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.emotg.naturecollection.PlantModel
import com.emotg.naturecollection.R
import com.emotg.naturecollection.adapter.PlantAdapter
import com.emotg.naturecollection.adapter.PlantItemDecoration

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater?.inflate(R.layout.fragment_home, container, false)

        // Créer une liste qui va stocker les plantes
        val plantList = arrayListOf<PlantModel>()

        // Entegistrer la première plante
        plantList.add(PlantModel(
            "Clivia Maniata",
            "Blanc soleil",
            "https://cdn.pixabay.com/photo/2013/07/25/18/46/clivia-miniata-167169_960_720.jpg",
            false
        ))

        // Entegistrer la deuxième plante
        plantList.add(PlantModel(
            "Protea Cynaroides",
            "ça pique peu",
            "https://cdn.pixabay.com/photo/2017/05/09/20/43/protea-2299215_960_720.jpg",
            true
        ))

        // Entegistrer la deuxième plante
        plantList.add(PlantModel(
            "Pelargonium",
            "C'est beau",
            "https://cdn.pixabay.com/photo/2017/09/22/18/54/geranium-2776719_960_720.jpg",
            false
        ))

        // Entegistrer la troisième plante
        plantList.add(PlantModel(
            "Oxalis Hirta",
            "C'est magnifique",
            "https://www.cfgphoto.com/data/media/2206/CFGx824.jpg",
            false
        ))

        // Entegistrer la quatième plante
        plantList.add(PlantModel(
            "Tulipe",
            "C'est jolie",
            "https://www.cfgphoto.com/data/media/2206/CFGx824.jpg",
            false
        ))


        // Récuperer le RecyclerView
        val horizontalRecyclerView = view.findViewById<RecyclerView>(R.id.horizontal_recycler_view)
        horizontalRecyclerView.adapter = PlantAdapter(R.layout.item_horizontal_plant)

        // Récuperer le secong RecyclerView
        val verticalRecyclerView =  view.findViewById<RecyclerView>(R.id.vertical_recycler_view)
        verticalRecyclerView.adapter = PlantAdapter(R.layout.item_vertical_plant)

        // Margin entre les dernières plantes
        verticalRecyclerView.addItemDecoration(PlantItemDecoration())

        return view
    }
}