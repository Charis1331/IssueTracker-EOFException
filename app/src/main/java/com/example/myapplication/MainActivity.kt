package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import com.example.myapplication.data.VerifyData
import com.example.myapplication.data.SecondCaseDataWrapper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val data = VerifyData(3)
            val wrapper =
                SecondCaseDataWrapper<Parcelable, Parcelable>(data)
            val intent = SecondActivity.getIntent(this, wrapper)
            startActivity(intent)
        }
    }
}