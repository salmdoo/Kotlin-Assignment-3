package com.example.assignment3

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import java.lang.Error

class MainActivity : AppCompatActivity() {
     val MY_TAG = "DebugApp"

    private var version: EditText? = null
    private var codeName: EditText? = null
    lateinit var buttonAdd: Button
    lateinit var tableLayout: TableLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        version = findViewById(R.id.edit_text_version)
        codeName = findViewById(R.id.edit_text_code_made)
        buttonAdd = findViewById(R.id.button_add)
        tableLayout = findViewById(R.id.table_layout)

        buttonAdd.setOnClickListener { addNewRow() }
    }

    private fun addNewRow(){

        Log.e(MY_TAG, "Click is trigger")

        try {
            val tableRow = TableRow(this)

            tableRow.setBackgroundColor(Color.parseColor("#E91E63"))
            val layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT)
            layoutParams.setMargins(0, 10, 0, 0)
            tableRow.layoutParams = layoutParams

            val textView = TextView(this)
            textView.setTextAppearance(R.style.CustomRow)
            textView.text = version?.text ?: ""
            tableRow.addView(textView, 0)

            val textView2 = TextView(this)

            textView2.setTextAppearance(R.style.CustomRow)
            textView2.text = codeName?.text ?: ""
            tableRow.addView(textView2, 1)

            tableLayout.addView(tableRow)
        } catch (err: Error) {
            Log.e(MY_TAG, err.localizedMessage)
        }

    }
}