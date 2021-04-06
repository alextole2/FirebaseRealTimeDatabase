package com.personal.firebasedatabase

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

object Firebase {
    private var firebaseDatabase: DatabaseReference? = null

    fun getDataBase(): DatabaseReference? {
        if (firebaseDatabase == null) {
            val instance = FirebaseDatabase.getInstance()
            instance.setPersistenceEnabled(true)
            firebaseDatabase = instance.reference
            firebaseDatabase?.keepSynced(true)
        }

        return firebaseDatabase
    }
}