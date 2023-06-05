package com.example.kriss.homeandaway

import android.content.Intent
import android.os.Bundle
import android.os.Message
import android.se.omapi.Session
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_details.*
import java.util.*

class DetailsActivity : AppCompatActivity() {

    /*private fun sendEmail(to: String) {
        val from = "homeandawayorg@gmail.com"
        val subject = "Your Reservation"
        val ticket = "You have successfully reserved a room. Your ticket number is "

        val props = Properties()
        props.put("mail.smtp.host","smtp.gmail.com")
        props.put("mail.transport.protocol", "smtp")
        props.put("mail.smtp.starttls.enable", "true")
        props.put("mail.smtp.port", "587")
        val session = Session.getDefaultInstance(props)

        try {
            val fromAddress = InternetAddress(from)
            val toAddress = InternetAddress(to)

            val msg = MimeMessage(session)
            msg.setFrom(fromAddress)
            msg.setRecipient(Message.RecipientType.TO, toAddress)
            msg.subject = subject
            msg.sentDate = Date()

            val messagePart = MimeBodyPart()
            messagePart.setText(ticket)

            msg.setContent(messagePart)
        }
    }*/
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
                //sendEmail(LoginActivity().email)
                Toast.makeText(this, "You Have Successfully Made Reservations.", Toast.LENGTH_LONG).show()
                this.startActivity(Intent(this, HomeActivity::class.java))
            } else {
                Toast.makeText(this, "Please Complete the Form above", Toast.LENGTH_LONG).show()
            }
        }



    }

}