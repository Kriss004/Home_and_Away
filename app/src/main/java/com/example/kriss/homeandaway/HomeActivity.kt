package com.example.kriss.homeandaway

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.ticket.view.*

class HomeActivity : AppCompatActivity() {


    private var destinationlist=ArrayList<Destination>()
    private var adapter:DestinationAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        destinationlist.add(Destination("Bamburi Beach Hotel",R.drawable.bamburi_beach_hotel,"15,000.00 Ksh"))
        destinationlist.add(Destination("The Boma Nairobi",R.drawable.boma_hotel,"18,499.00 Ksh"))
        destinationlist.add(Destination("Crowne Plaza Hotel",R.drawable.crowne_plaza_hotel,"8,500.00 Ksh"))
        destinationlist.add(Destination("Eka Hotel",R.drawable.eka_hotel,"5,000.00 Ksh"))
        destinationlist.add(Destination("Emara Ole Sereni",R.drawable.emara_ole_sereni,"21,999.00 Ksh"))
        destinationlist.add(Destination("The Marriot",R.drawable.marriot,"14,499.00 Ksh"))
        destinationlist.add(Destination("Medina Palms Watamu",R.drawable.medina_palms_watamu,"12,000.00 Ksh"))
        destinationlist.add(Destination("Ole Sereni Hotel",R.drawable.ole_sereni_hotel,"16,200.00 Ksh"))
        destinationlist.add(Destination("Sarabi Sankara Hotel",R.drawable.sarabi_sankara_hotel,"20,000.00 Ksh"))
        destinationlist.add(Destination("Sarova Woodlands",R.drawable.sarova_woodlands,"15,500.00 Ksh"))
        destinationlist.add(Destination("Silver Springs Hotel",R.drawable.silver_springs_hotel,"18,000.00 Ksh"))
        destinationlist.add(Destination("Sun and Sand Beach Resort",R.drawable.sun_and_sand_beach_resort,"28,000.00 Ksh"))
        destinationlist.add(Destination("The Monarch Hotel",R.drawable.the_monarch_hotel,"18,700.00 Ksh"))
        destinationlist.add(Destination("Villa Rosa Kempinski",R.drawable.villa_rosa_kempinski,"30,000.00 Ksh"))
        destinationlist.add(Destination("Voyager Beach Resort",R.drawable.voyager_beach_resort,"11,399.00 Ksh"))

        adapter= DestinationAdapter(destinationlist,this)
        gvDestinations.adapter=adapter


    }

    class DestinationAdapter(private var destinationlist: ArrayList<Destination>, var context: Context?) :
        BaseAdapter() {


        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

            val destination=this.destinationlist[position]
            val inflator=context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

            val destinationView=inflator.inflate(R.layout.ticket,null)
            destinationView.ivDestinations.setImageResource(destination.image!!)
            destinationView.ivDestinations.setOnClickListener {

                val intent=Intent(context,DetailsActivity::class.java)
                 intent.putExtra("names",destination.names!!)
                 intent.putExtra("image",destination.image!!)
                 intent.putExtra("price",destination.price!!)


                context!!.startActivity(intent)


            }


            destinationView.tvDestinations.text=destination.names!!
            return destinationView

        }

        override fun getItem(position: Int): Any {

            return destinationlist[position]
        }

        override fun getItemId(position: Int): Long {

            return position.toLong()
        }

        override fun getCount(): Int {

            return destinationlist.size
        }

    }

}
