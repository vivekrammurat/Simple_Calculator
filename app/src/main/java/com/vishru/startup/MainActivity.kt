package com.vishru.startup

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun btnEvent(view:View){
        if (isNewOp == true)
            tv_input_txt.setText("")

        isNewOp = false
        val btnSelect = view as Button
        var btnClickValue:String = tv_input_txt.text.toString() //this takes the default values i.e 0
        //btnClickValue = ""
        when(btnSelect.id){//this is identify the btn and concatenate the string
            btnNum0.id -> btnClickValue += "0"
            btnNum1.id -> btnClickValue += "1"
            btnNum2.id -> btnClickValue += "2"
            btnNum3.id -> btnClickValue += "3"
            btnNum4.id -> btnClickValue += "4"
            btnNum5.id -> btnClickValue += "5"
            btnNum6.id -> btnClickValue += "6"
            btnNum7.id -> btnClickValue += "7"
            btnNum8.id -> btnClickValue += "8"
            btnNum9.id -> btnClickValue += "9"
            btnDel.id ->{
                //TODO:: prevent add only one value
                btnClickValue += "."
            }
        }
        tv_input_txt.setText(btnClickValue) //entered the string to displlay over the textbox

    }


    var oldNumber:String  = ""
    var oparation:String = ""
    var isNewOp = true
    fun btnOperation(view:View){
        val  btnSelect = view as Button
        when(btnSelect.id){
            btnDiv.id -> {
                oparation = "/"
            }
            btnMulti.id  -> {
                oparation = "*"
            }
            btnSub.id -> {
                oparation = "-"
            }
            btnAdd.id -> {
                oparation = "+"
            }
        }

        oldNumber = tv_input_txt.text.toString()
        isNewOp = true
    }

    fun btnEqlClick(view: View){
        val newNumber = tv_input_txt.text.toString()
        var finalNumber:Double?=tv_input_txt.text.toString().toDouble()

        when(oparation){
            "/" -> finalNumber = (oldNumber.toDouble() / newNumber.toDouble())
            "*" -> finalNumber = (oldNumber.toDouble() * newNumber.toDouble())
            "-" -> finalNumber = (oldNumber.toDouble() - newNumber.toDouble())
            "+" -> finalNumber = (oldNumber.toDouble() + newNumber.toDouble())

        }

        tv_input_txt.setText(finalNumber.toString())
    }

    fun btnClear(view: View){
        val btnSelect = view as Button

        when(btnSelect.id){
            btn_AC.id -> {
                tv_input_txt.setText("0")
                isNewOp = true
            }
        }
    }

    fun btnPercent(view: View){
        val number = tv_input_txt.text.toString()
        val percent:Double = number.toDouble() / 100
        tv_input_txt.setText(percent.toString())
        isNewOp = true
    }
}
