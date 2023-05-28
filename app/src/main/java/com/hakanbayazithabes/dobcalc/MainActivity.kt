package com.hakanbayazithabes.dobcalc

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import com.hakanbayazithabes.dobcalc.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var tvSelectedDate: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        tvSelectedDate = binding.tvSelectedDate

        binding.btnDatePicker.setOnClickListener {
            clickDatePicker()
        }

    }

    fun clickDatePicker() {
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val dayOfMonth = myCalendar.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(
            this,
            { _, selectedYear, selectedMonth, selectedDayOfMonth ->
                Toast.makeText(
                    this,
                    "The chosen year is $selectedYear, the month is ${selectedMonth + 1} and the day is $selectedDayOfMonth",
                    Toast.LENGTH_LONG
                ).show()
                val selectedDate = "$selectedDayOfMonth/${selectedMonth + 1}/$selectedYear"

                tvSelectedDate?.text = selectedDate

                val asd = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

                val theDate = asd.parse(selectedDate)

            }, year, month, dayOfMonth
        ).show()

        Toast.makeText(this, "btnDataPicker pressed", Toast.LENGTH_SHORT).show()
    }
}