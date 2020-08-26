package com.example.testaddfragment.screen.main

import android.os.AsyncTask
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.testaddfragment.R
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.MalformedURLException
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setupTabFragment(TableLayoutFragment())
    }

    private fun setupTabFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            add(R.id.main, fragment)
            addToBackStack(null)
            commit()
        }
    }


}