package com.emotg.naturecollection.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
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