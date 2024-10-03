package com.example.assignment_4

import android.content.Intent
import android.content.res.ColorStateList
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

             if(Binding.edName.text.toString().isEmpty()) {
                 Binding.tilName.helperText = "Required"
                 Binding.tilName.isErrorEnabled=true
                 Binding.tilName.setHelperTextColor(ColorStateList.valueOf(getResources().getColor(R.color.error_red)))

             } else if(Binding.edName.text.toString().length < 3){
                 Binding.edName.error = "Name must be at least 3 characters"
             }


            if(Binding.edPhone.text.toString().isEmpty()) {
                Binding.tilPhone.helperText="Required"
                Binding.tilPhone.setHelperTextColor(ColorStateList.valueOf(getResources().getColor(R.color.error_red)))
            }else if(Binding.edPhone.text.toString().length != 11 ) {
            Binding.edPhone.error = "Phone must be 11 characters"
        }

                if(Binding.edName.text.toString().isNotEmpty()&& Binding.edPhone.text.toString().isNotEmpty()&&Binding.edPhone.text.toString().length == 11){

                    Binding.tilName.isHelperTextEnabled=false
                    Binding.tilPhone.isHelperTextEnabled=false
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