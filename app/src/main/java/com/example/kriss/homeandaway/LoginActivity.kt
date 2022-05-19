package com.example.kriss.homeandaway

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    private var mAuth=FirebaseAuth.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tvMoveSignUp.setOnClickListener {

            val intent=Intent(this,SignupActivity::class.java)
            startActivity(intent)

        }

        btnlogin.setOnClickListener {

            login()

        }


    }


    private fun login(){

        val email=etlgEmail.text.toString()
        val password=etlgPassword.text.toString()

        if (email.isNotEmpty() && password.isNotEmpty()){

            mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val intent=Intent(this,HomeActivity::class.java)
                        Toast.makeText(this,"Login successful",Toast.LENGTH_LONG).show()
                        startActivity(intent)

                    } else {
                        Toast.makeText(this,"Login unsuccessful",Toast.LENGTH_LONG).show()

                    }

                    // ...
                }

        }else{
            Toast.makeText(this,"Error! Please fill in credentials",Toast.LENGTH_LONG).show()
        }


    }



}
