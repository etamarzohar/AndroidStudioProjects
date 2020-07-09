package com.example.inventorymanagement
import android.media.MediaPlayer
import android.net.Uri
import kotlinx.android.synthetic.main.content_main.*
import com.example.inventorymanagement.R.raw.track1
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_products.*
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.blue
import androidx.core.graphics.red
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.video_page.*
import kotlinx.android.synthetic.main.add_products.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL

class AddProductActivity: AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_products)

        supportFragmentManager.beginTransaction().replace(R.id.backFrame, BackGround()).commit()

        mytheme.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                backFrame.visibility = View.VISIBLE
                editTextProductName.setTextColor(getColor(R.color.design_default_color_background))
                editTextProductName.setHintTextColor(getColor(R.color.design_default_color_background))
                editTextTextPersonName.setTextColor(getColor(R.color.design_default_color_background))
                editTextTextPersonName.setHintTextColor(getColor(R.color.design_default_color_background))
                editTextNumber.setTextColor(getColor(R.color.design_default_color_background))
                editTextNumber.setHintTextColor(getColor(R.color.design_default_color_background))
                textViewProduct0.setTextColor(getColor(R.color.design_default_color_background))
            } else {
                backFrame.visibility = View.GONE
                editTextProductName.setTextColor(getColor(R.color.colorPrimary))
                editTextProductName.setHintTextColor(getColor(R.color.colorPrimary))
                editTextTextPersonName.setTextColor(getColor(R.color.colorPrimary))
                editTextTextPersonName.setHintTextColor(getColor(R.color.colorPrimary))
                editTextNumber.setTextColor(getColor(R.color.colorPrimary))
                editTextNumber.setHintTextColor(getColor(R.color.colorPrimary))
                textViewProduct0.setTextColor(getColor(R.color.colorPrimary))
            }
        }


        buttonInternet.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                val myTextViewContainer = URL("https://github.com/etamarzohar/mywebsite/blob/master/message.txt").readText()
                val database = getSharedPreferences("database", Context.MODE_PRIVATE)
                database.edit().apply {
                    putString("savedProductName", myTextViewContainer)
                }.apply()
                val preferences = getSharedPreferences("database", Context.MODE_PRIVATE)
                val savedName = preferences.getString("savedProductName", "This value doesn't exist")
                Log.d("Zohar", "saved msg is: $savedName")
                d("Zohar","$myTextViewContainer")
                textViewProduct0.text = myTextViewContainer
            }
//             I will keep it for display textView content in the add_product layout!!!
        }

        buttonDATA.setOnClickListener {
            val productName = editTextProductName.text.toString()
            val ownerName = editTextTextPersonName.text.toString()
            val yearPurchase = editTextNumber.text.toString()
            textViewProduct0.text = "$productName\n$ownerName\n$yearPurchase"
        }

        btnext.setOnClickListener {

            Toast.makeText(this ,"Hi, Wellcome to my app :)" , Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, VideoPlayer::class.java))

        }
    }

}