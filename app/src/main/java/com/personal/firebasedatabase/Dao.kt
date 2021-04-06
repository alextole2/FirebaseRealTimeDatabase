package com.personal.firebasedatabase

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class Dao {
    private val dataBase = Firebase.getDataBase()

    fun getObject(callback: (Object?) -> Unit) {
        dataBase?.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                snapshot.children.forEach { data ->
                    val `object`: Object? = data.getValue(Object::class.java)
                    callback(`object`)
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })
    }

    fun save(`object`: Object) {
        dataBase?.child("object")?.setValue(`object`)
    }
}