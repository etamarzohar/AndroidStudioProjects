package com.example.inventorymanagement

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.content_main.*
import android.widget.Toast
import com.example.inventorymanagement.R.raw.track1
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_products.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        setSupportActionBar(findViewById(R.id.toolbar))

        val mp: MediaPlayer = MediaPlayer.create(this, track1)
        music1.setOnClickListener { mp.start() }
        music2.setOnClickListener { mp.pause() }

        switch1.setOnCheckedChangeListener { compoundButton, isChecked_ ->
            if(isChecked_) {
                goToAddProduct.visibility = View.VISIBLE
            }
            else{ goToAddProduct.visibility = View.GONE }
        }
            switch2.setOnCheckedChangeListener { compoundButton, isChecked_ ->
                if (isChecked_) {
                    ourFrame.visibility = View.VISIBLE
                } else {
                    ourFrame.visibility = View.GONE
                }
        }


        supportFragmentManager.beginTransaction().replace(R.id.ourFrame, FirstFragment()).commit()


        goToAddProduct.setOnClickListener {
            Toast.makeText(this ,"Hi, Wellcome to my app :)" , Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, AddProductActivity::class.java))
        }

        fab.setOnClickListener {
            var uri =
                Uri.parse("https://mail.google.com/mail/mu/mp/469/#tl/priority/%5Esmartlabel_personal") // missing 'http://' will cause crashed
            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        fab2.setOnClickListener {
            var uri =
                Uri.parse("https://www.facebook.com/profile.php?id=100037675373927") // missing 'http://' will cause crashed
            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }
}



