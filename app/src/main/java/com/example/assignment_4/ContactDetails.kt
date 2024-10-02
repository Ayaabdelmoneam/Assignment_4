package com.example.assignment_4

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment_4.databinding.ActivityContactDetailsBinding
import com.example.assignment_4.databinding.ActivityMainBinding


class ContactDetails : AppCompatActivity() {
    lateinit var Binding : ActivityContactDetailsBinding
    var list : MutableList<Contact> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Binding= ActivityContactDetailsBinding.inflate(layoutInflater)
        setContentView( Binding.root)
        var intent : Intent = getIntent()
         var contact = intent.getSerializableExtra("Contact")as? Contact
        Binding.name.text=contact?.name
        Binding.phone.text=contact?.phone
        Binding.Description.text=contact?.description
        Binding.backButton.setOnClickListener {
            finish()
        }

    }
}