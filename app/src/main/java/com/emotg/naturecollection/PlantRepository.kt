package com.emotg.naturecollection

import com.emotg.naturecollection.PlantRepository.Signleton.databaseRef
import com.emotg.naturecollection.PlantRepository.Signleton.plantList
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class PlantRepository {

    object Signleton {
        // Se connecter à la refference "plants"
        val databaseRef = FirebaseDatabase.getInstance().getReference("plants")

        // creer une liste qui va contenir nos plante
        val plantList = arrayListOf<PlantModel>()
    }

    fun updateData() {
        // absorber les données dépuis la databaseRef -> liste de plantes
        databaseRef.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                // recolter la liste
                for (ds in snapshot.children) {
                    // construire un object plant
                    val plant = ds.getValue(PlantModel::class.java)

                    // vérifier si la plante n'est pas nulle
                    if (plant != null) {
                        // ajouter la plante à la liste
                        plantList.add(plant)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {}

        })
    }

}