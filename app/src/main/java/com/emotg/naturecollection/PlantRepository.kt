package com.emotg.naturecollection

import com.google.firebase.database.FirebaseDatabase

class PlantRepository {

    // Se connecter à la refference "plants"
    val databaseRef = FirebaseDatabase.getInstance().getReference("plants")
}