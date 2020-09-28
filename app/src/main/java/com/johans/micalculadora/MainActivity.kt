package com.johans.micalculadora

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.math.RoundingMode

@Suppress("IMPLICIT_CAST_TO_ANY")
class MainActivity : AppCompatActivity() {
        private var numero1: Double = 0.0
        private var numero2: Double = 0.0
        private var OPERACION = 0

        companion object{
            const val SUMA = 1
            const val RESTA = 2
            const val MULTI = 3
            const val DIVI = 4
            const val NO_OPERA = 0
        }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cero_btn.setOnClickListener{numeroP("0")}
        uno_btn.setOnClickListener{numeroP("1")}
        dos_btn.setOnClickListener{numeroP("2")}
        tres_btn.setOnClickListener{numeroP("3")}
        cuatro_btn.setOnClickListener{numeroP("4")}
        cinco_btn.setOnClickListener{numeroP("5")}
        seis_btn.setOnClickListener{numeroP("6")}
        siete_btn.setOnClickListener{numeroP("7")}
        ocho_btn.setOnClickListener{numeroP("8")}
        nueve_btn.setOnClickListener{numeroP("9")}
        punto_btn.setOnClickListener{numeroP(".")}

        suma_btn.setOnClickListener{funcionmate(SUMA)}
        resta_btn.setOnClickListener{funcionmate(RESTA)}
        mult_btn.setOnClickListener{funcionmate(MULTI)}
        div_btn.setOnClickListener{funcionmate(DIVI)}

        igual_btn.setOnClickListener{
            var igual:Double = when(OPERACION){
                SUMA -> numero1 + numero2
                RESTA -> numero1 - numero2
                MULTI -> numero1 * numero2
                DIVI -> {
                    if(numero2==0.0){
                        0.0}
                    else{
                        numero1/numero2
                    }

                }
                else  -> 0.0
            }
            if (OPERACION== DIVI && numero2==0.0){
                resultado_text.text = "error syntax"
                numero1 = 0.0
                numero2 = 0.0
            }
            else{
                val rounded:Double = igual.toBigDecimal().setScale(7, RoundingMode.UP).toDouble()
                resultado_text.text = rounded.toString()
                numero1 = resultado_text.text.toString().toDouble()
            }

        }

    }

    @SuppressLint("SetTextI18n")
    private fun numeroP(valor: String){
        resultado_text.text = "${resultado_text.text}$valor"

        if (OPERACION == NO_OPERA){
            numero1 = resultado_text.text.toString().toDouble()
        }
        else{
            numero2 = resultado_text.text.toString().toDouble()
        }
    }

    private fun funcionmate(oper: Int){
        OPERACION = oper
        resultado_text.text = ""
    }
}