package com.example.kriss.homeandaway

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)


        val bundle = intent.extras

        tvDestName.text = bundle!!.getString("names")
        ivDest.setImageResource(bundle.getInt("image"))
        tvPrice.text = bundle.getString("price")


        val checkin = etCheckin.text.toString()
        val checkout = etCheckout.text.toString()
        val adults = etAdults.text.toString()
        val children = etChildren.text.toString()
        val rooms = etRooms.text.toString()


        btReserve.setOnClickListener {

            if (checkin.isNotEmpty() && checkout.isNotEmpty() && adults.isNotEmpty() && children.isNotEmpty() && rooms.isNotEmpty()) {

                Toast.makeText(this,"You Have Successfully Made Reservations.",Toast.LENGTH_LONG).show()
                startActivity(Intent(this,HomeActivity::class.java))

            } else {

                Toast.makeText(this, "Please Complete the Form above", Toast.LENGTH_LONG).show()

            }

        }





    }

}