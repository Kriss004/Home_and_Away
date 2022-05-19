package com.example.kriss.homeandaway

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_signup.*


class SignupActivity : AppCompatActivity() {

    private var mAuth=FirebaseAuth.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)




        tvMoveLogin.setOnClickListener {

            val intent=Intent(this,LoginActivity::class.java)
            startActivity(intent)

        }

        btnRegister.setOnClickListener {

            signup()

        }


    }

    private fun signup(){

        val name=etName.text.toString()
        val phone=etPhone.text.toString()
        val id=etID.text.toString()
        val email=etEmail.text.toString()
        val password=etPassword.text.toString()
        val repass=etRepass.text.toString()


        if (name.isNotEmpty() && phone.isNotEmpty() && id.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && repass.isNotEmpty()) {

            if (repass == password) {


                mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "User successfully created", Toast.LENGTH_LONG)
                                .show()
                            startActivity(Intent(this, LoginActivity::class.java))

                        } else {
                            Toast.makeText(this, "Error signing up", Toast.LENGTH_LONG).show()
                        }


                    }

            } else {
                Toast.makeText(this,"Make sure passwords entered similar",Toast.LENGTH_LONG).show()
            }

        } else{
            Toast.makeText(this,"Please fill credentials",Toast.LENGTH_LONG).show()
        }



    }
}
