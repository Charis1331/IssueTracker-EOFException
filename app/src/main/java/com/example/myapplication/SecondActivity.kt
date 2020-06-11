package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.data.SecondCaseDataWrapper

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // TODO Calling to retrieve the parcelable obj here will throw a RunTimeException
        val secondCaseDataWrapper: SecondCaseDataWrapper<*, *>? = intent.extras?.getParcelable(EXTRA_DATA)
    }

    companion object {
        private const val EXTRA_DATA = "VerifyData"
        private const val EXTRA_ENTER_ACTIVITY_OVERRIDDEN_ANIM =
            "EXTRA_ENTER_ACTIVITY_OVERRIDDEN_ANIM"
        private const val EXTRA_EXIT_ACTIVITY_OVERRIDDEN_ANIM =
            "EXTRA_EXIT_ACTIVITY_OVERRIDDEN_ANIM"

        fun getIntent(calling: Activity, secondCaseDataWrapper: SecondCaseDataWrapper<*, *>): Intent =
            Intent(calling, SecondActivity::class.java).apply {
                putExtra(EXTRA_DATA, secondCaseDataWrapper)
                putExtra(EXTRA_ENTER_ACTIVITY_OVERRIDDEN_ANIM, 1)
                putExtra(EXTRA_EXIT_ACTIVITY_OVERRIDDEN_ANIM, 2)
            }
    }
}