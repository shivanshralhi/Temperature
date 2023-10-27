package com.example.temperature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val customList = listOf<String>("°Fahrenheit", "°Celcius","Kelvin")
        val adapter = ArrayAdapter<String>(this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item,customList)

        val btnConvert = findViewById<Button>(R.id.btnConvert)
        val spInitialTemp = findViewById<Spinner>(R.id.spInitialTemp)
        var tvFinalTemp = findViewById<TextView>(R.id.tvFinalTemp)
        val spFinalTemp = findViewById<Spinner>(R.id.spFinalTemp)
        var etInitialTemp1 = findViewById<EditText>(R.id.etInitialTemp)
        spInitialTemp.adapter = adapter
        spFinalTemp.adapter = adapter

        btnConvert.setOnClickListener{

                var etInitialTemp = etInitialTemp1.text.toString().toDouble()
                val spitext = spInitialTemp.selectedItem.toString()
                val spftext = spFinalTemp.selectedItem.toString()

                var value : Double = 0.0
                if (spitext=="°Celcius"  && spftext=="°Fahrenheit"){
                    value = (etInitialTemp*(9.0/5.0))+32.0
                    val roundoff = String.format("%.1f", value)
                    tvFinalTemp.text = roundoff.toString()
                }

                else if (spitext=="°Fahrenheit"  && spftext=="°Celcius"){
                    value = ((etInitialTemp-32.0)*(5.0/9.0))
                    val roundoff = String.format("%.1f", value)
                    tvFinalTemp.text =  roundoff
                }

                else if (spitext=="°Celcius"  && spftext=="Kelvin"){
                    value = (etInitialTemp+273.0)
                    val roundoff = String.format("%.1f", value)
                    tvFinalTemp.text = roundoff
                }

                else if (spitext=="°Fahrenheit"  && spftext=="Kelvin") {
                    value = (((etInitialTemp-32.0)*(5.0/9.0))+273.0)
                    val roundoff = String.format("%.1f", value)
                    tvFinalTemp.text = roundoff
                }

                else if (spitext=="Kelvin"  && spftext=="°Fahrenheit"){
                    value = (((etInitialTemp-273.0)*(9.0/5.0))+32.0)
                    val roundoff = String.format("%.1f", value)
                    tvFinalTemp.text = roundoff
                }

                else if (spitext=="Kelvin" && spftext=="°Celcius"){
                    value = (etInitialTemp-273.0)
                    val roundoff = String.format("%.1f", value)
                    tvFinalTemp.text = roundoff
                }
                else tvFinalTemp.text = etInitialTemp.toString()
            }
        }
    }


