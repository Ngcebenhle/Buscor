package com.example.buscor.views


import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.buscor.R


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)

//        val db = UserDatabase.getDatabase(applicationContext)
//        val userDao = db.userDao()
//
//        val repository by lazy { UserRepository(db.userDao()) }
//        val viewModel: UserViewModel by viewModels{
//            MyViewModelFactory(repository)
//        }

        //  splash screen activation
        val splashScreen = installSplashScreen()


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)



    }

}