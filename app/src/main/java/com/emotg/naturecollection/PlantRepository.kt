package com.emotg.naturecollection

import com.google.firebase.database.FirebaseDatabase

class PlantRepository {

    object Signleton {
        // Se connecter à la refference "plants"
        val databaseRef = FirebaseDatabase.getInstance().getReference("plants")

        // creer une liste qui va contenir nos plante
        val plantList = arrayListOf<PlantModel>()
    }

}