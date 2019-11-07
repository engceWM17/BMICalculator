package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculateB.setOnClickListener{
            calculateBMI()
        }
        resetB.setOnClickListener{
            resetOutput()
        }
    }

    private fun resetOutput() {
        imageView.setImageResource(R.drawable.empty)
        txtBMI.text=getString(R.string.bmi)
        txtStatus.text=getString(R.string.status)
        weight.text=null
        height.text=null
    }


    private fun calculateBMI(){

        if(height.text.isEmpty()){
            height.setError(getString(R.string.errorInput))
            return
        }
        if(weight.text.isEmpty()){
            weight.setError(getString(R.string.errorInput))
            return
        }

        val height :Float=height.text.toString().toFloat();
        val weight: Float=weight.text.toString().toFloat();
        val bmi=weight/height.pow(2);


        txtBMI.text=String.format("%s %.2f",getString(R.string.bmi),bmi)

        if(bmi<18.5){
            txtStatus.text=String.format("%s %s",getString(R.string.status),getString(R.string.underweight))
            imageView.setImageResource(R.drawable.under)
        }else if(bmi>=25){
            txtStatus.text=String.format("%s %s",getString(R.string.status),getString(R.string.overweight))
            imageView.setImageResource(R.drawable.over)
        }else{
            txtStatus.text=String.format("%s %s",getString(R.string.status),getString(R.string.normal))
            imageView.setImageResource(R.drawable.normal)
        }


    }

}
