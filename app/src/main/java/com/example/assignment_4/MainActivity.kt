package com.example.assignment_4

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment_4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var Adapter:Adapter
    lateinit var Binding : ActivityMainBinding
    var list : MutableList<Contact> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Binding=ActivityMainBinding.inflate(layoutInflater)

        setContentView( Binding.main)
        recyclerView=Binding.Recycler
        Binding.buttonSave.setOnClickListener {
            if(Binding.edName.text.toString()!=""&& Binding.edPhone.text.toString()!=""){


            var contact=  Contact(Binding.edName.text.toString(),Binding.edPhone.text.toString(),Binding.edDescription.text.toString())

            list.add(contact)
            Adapter=Adapter(list){ contact, _ ->

                var intent  = Intent(this,ContactDetails::class.java)

                intent.putExtra("Contact",contact)
                startActivity(intent)
            }
            Binding.edName.text=null
            Binding.edName.clearFocus()
            Binding.edPhone.text=null
            Binding.edPhone.clearComposingText()
            Binding.edDescription.text=null


            recyclerView.adapter=Adapter


        }

        }

    }
}