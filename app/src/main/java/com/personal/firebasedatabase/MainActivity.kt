package com.personal.firebasedatabase

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val dao = Dao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        send_button.setOnClickListener {
            val obj = Object()
            obj.name = name_edit_text.text.toString()
            obj.description = description_edit_text.text.toString()
            name_edit_text.text = null
            description_edit_text.text = null
            dao.save(obj)
        }
    }

    override fun onResume() {
        super.onResume()
        dao.getObject {
            name_edit_text.setText(it?.name ?: "")
            description_edit_text.setText(it?.description ?: "")
        }
    }
}