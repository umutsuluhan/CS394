package com.example.projectt.activities

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import android.text.TextUtils
import android.util.Patterns
import android.content.Intent
import com.example.projectt.R
import com.example.projectt.api.ApiInterfaceCatering
import com.example.projectt.api.ApiInterfacePrivateLesson
import com.example.projectt.api.ApiInterfaceRenovation
import com.example.projectt.database.*
import com.google.common.reflect.TypeToken
import com.google.gson.Gson
import com.google.gson.JsonArray
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : AppCompatActivity(){


    public override fun onStart() {
        super.onStart()

        setContentView(R.layout.login_page)

        supportActionBar?.setDisplayShowHomeEnabled(true);
        supportActionBar?.setLogo(R.drawable.elma);
        supportActionBar?.setDisplayUseLogoEnabled(true);

        val reservationDao = ReservationDatabase.getInstance(application).reservationDao
        reservationDao.clear()

        val apiInterface_catering = ApiInterfaceCatering.create().getCaterings()

        val cateringDao = CateringDatabase.getInstance(application).cateringDao

        apiInterface_catering.enqueue( object :  Callback<JsonArray> {
            override fun onResponse(call: Call<JsonArray>, response: Response<JsonArray>) {

                Log.d("Catering", response.body().toString())

                val typeToken = object : TypeToken<List<Catering>>(){}.type
                val catering_services = Gson().fromJson<List<Catering>>(response.body().toString(), typeToken)
                cateringDao.clear()
                cateringDao.insertAll(catering_services)
                Log.d("Catering>Database", cateringDao.getAll().toString())

            }
            override fun onFailure(call: Call<JsonArray>, t: Throwable) {
                Log.e("Response Error", t.message.toString())
            }
        })

        val apiInterface_private_lesson = ApiInterfacePrivateLesson.create().getPrivateLessons()

        val privateLessonDao = PrivateLessonDatabase.getInstance(application).privateLessonDao

        apiInterface_private_lesson.enqueue( object :  Callback<JsonArray> {
            override fun onResponse(call: Call<JsonArray>, response: Response<JsonArray>) {

                Log.d("Private Lesson", response.body().toString())

                val typeToken = object : TypeToken<List<PrivateLesson>>(){}.type
                val private_lesson_services = Gson().fromJson<List<PrivateLesson>>(response.body().toString(), typeToken)
                privateLessonDao.clear()
                privateLessonDao.insertAll(private_lesson_services)
                Log.d("Private Lesson>Database", privateLessonDao.getAll().toString())

            }
            override fun onFailure(call: Call<JsonArray>, t: Throwable) {
                Log.e("Response Error", t.message.toString())
            }
        })

        val apiInterface_renovation = ApiInterfaceRenovation.create().getRenovations()

        val renovationDao = RenovationDatabase.getInstance(application).renovationDao

        apiInterface_renovation.enqueue( object :  Callback<JsonArray> {
            override fun onResponse(call: Call<JsonArray>, response: Response<JsonArray>) {

                Log.d("Renovation", response.body().toString())

                val typeToken = object : TypeToken<List<Renovation>>(){}.type
                val renovation_services = Gson().fromJson<List<Renovation>>(response.body().toString(), typeToken)
                renovationDao.clear()
                renovationDao.insertAll(renovation_services)
                Log.d("Renovation>Database", renovationDao.getAll().toString())

            }
            override fun onFailure(call: Call<JsonArray>, t: Throwable) {
                Log.e("Response Error", t.message.toString())
            }
        })

        val auth: FirebaseAuth = Firebase.auth

        lateinit var email: String
        lateinit var password: String

        val login_button = findViewById<Button>(R.id.login_button)
        login_button.setOnClickListener {
            val email_text = findViewById<EditText>(R.id.email_edit_text)
            email = email_text.text.toString()
            val password_text = findViewById<EditText>(R.id.password_edit_text)
            password = password_text.text.toString()

            if(!isValidEmail(email)){
                Toast.makeText(baseContext, "Please enter valid email",
                    Toast.LENGTH_SHORT).show()
                onStart()
            }

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this){task ->
                    if(task.isSuccessful){
                        Log.d(TAG, "signInWithEmail:success")
                        Toast.makeText(baseContext, "Access granted",
                            Toast.LENGTH_SHORT).show()
                        val switchActivityIntent = Intent(this, MainPageActivity::class.java)
                        startActivity(switchActivityIntent)
                    }else{
                        Log.w(TAG, "signInWithEmail:failure", task.exception)
                        Toast.makeText(baseContext, "Access denied.",
                            Toast.LENGTH_SHORT).show()
                        onStart()
                    }
                }
        }

        val sign_up_button = findViewById<Button>(R.id.singup_button)
        sign_up_button.setOnClickListener {
            val email_text = findViewById<EditText>(R.id.email_edit_text)
            email = email_text.text.toString()
            val password_text = findViewById<EditText>(R.id.password_edit_text)
            password = password_text.text.toString()

            if(!isValidEmail(email)){
                Toast.makeText(baseContext, "Please enter valid email",
                    Toast.LENGTH_SHORT).show()
                onStart()
            }

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "createUserWithEmail:success")
                        Toast.makeText(baseContext, "You are successfully signed-up.",
                            Toast.LENGTH_SHORT).show()
                        val user = auth.currentUser
                    } else {
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
                        Toast.makeText(baseContext, "User sign-up is failed.",
                            Toast.LENGTH_SHORT).show()
                    }
                }
        }


    }

    private fun isValidEmail(target: CharSequence?): Boolean {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }


}