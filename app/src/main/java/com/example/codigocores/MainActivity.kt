package com.example.codigocores

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var stateButtonStriteColor: Boolean = false
    var stateButtonStriteNum: Boolean = true
    var stripeNum: Int = 1
    var resistorValue: String = ""
    var stripeValue: String = ""
    var stripeQuant: Int = 0
    var stripe: String = ""
    var MultValueStripe_GoSi: Int = 0
    val toleranceList = arrayOf<Double>(0.0, 1.0, 2.0, 0.0, 0.0, 0.5, 0.25, 0.1, 0.05, 0.0, 5.0, 10.0)
    var resistorValueEnd: Double = 0.0
    var toleranceValue: Double = 0.0
    var resistorMinRange: Double = 0.0
    var resistorMaxRange: Double = 0.0
    val coeficiTemp_ppm_c = arrayOf<Int>(0, 100, 50, 15, 25, 0, 10, 5)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      if (stripeQuant == 0) {stateButtonColor()}

        button_restart.setOnClickListener {
            stateButtonStriteColor = false
            stateButtonColor()
            stateButtonStriteNum = true
            stateButtonNum()
            stripeNum = 1
            stripe = ""
            MultValueStripe_GoSi = 0
            resistorValue = ""
            resistorValueEnd = 0.0
            resistorMinRange = 0.0
            resistorMaxRange = 0.0
            colorStripeClear()
            textView_info.setTextSize(20f)
            textView_info.setTextColor(Color.BLACK)
            textView_info.text = ("Informe o tipo: 4 ou 5 ou 6 listras.")
            textView_value.setTextSize(14f)
            textView_value.setTextColor(Color.GRAY)
            textView_value.text = ("O valor será expresso aqui:")
            button_restart.visibility = View.INVISIBLE
        }

        button_4stripe.setOnClickListener {
            textView_info.text = ("Informe a sequência das 4 listras, para obter o valor:")
            stripeQuant = 4
            stateButtonStriteColor = true
            stateButtonColor()
            stateButtonStriteNum = false
            stateButtonNum()
        }

        button_5stripe.setOnClickListener {
            textView_info.text = ("Informe a sequência das 5 listras, para obter o valor:")
            stripeQuant = 5
            stateButtonStriteColor = true
            stateButtonColor()
            stateButtonStriteNum = false
            stateButtonNum()
        }
        button_6stripe.setOnClickListener {
            textView_info.text = ("Informe a sequência das 6 listras, para obter o valor:")
            stripeQuant = 6
            stateButtonStriteColor = true
            stateButtonColor()
            stateButtonStriteNum = false
            stateButtonNum()
        }
        button00.setOnClickListener {
            stripeValue = "0"
            positionStripe()
        }
        button01.setOnClickListener {
            stripeValue = "1"
            positionStripe()
        }
        button02.setOnClickListener {
            stripeValue = "2"
            positionStripe()
        }
        button03.setOnClickListener {
            stripeValue = "3"
            positionStripe()
        }
        button04.setOnClickListener {
            stripeValue = "4"
            positionStripe()
        }
        button05.setOnClickListener {
            stripeValue = "5"
            positionStripe()
        }
        button06.setOnClickListener {
            stripeValue = "6"
            positionStripe()
        }
        button07.setOnClickListener {
            stripeValue = "7"
            positionStripe()
        }
        button08.setOnClickListener {
            stripeValue = "8"
            positionStripe()
        }
        button09.setOnClickListener {
            stripeValue = "9"
            positionStripe()
        }
        button_go.setOnClickListener {
            stripeValue = "10"
            positionStripe()
        }
        button_si.setOnClickListener {
            stripeValue = "11"
            positionStripe()
        }
    }

    fun stateButtonColor() {
        button00.setEnabled(stateButtonStriteColor)
        button01.setEnabled(stateButtonStriteColor)
        button02.setEnabled(stateButtonStriteColor)
        button03.setEnabled(stateButtonStriteColor)
        button04.setEnabled(stateButtonStriteColor)
        button05.setEnabled(stateButtonStriteColor)
        button06.setEnabled(stateButtonStriteColor)
        button07.setEnabled(stateButtonStriteColor)
        button08.setEnabled(stateButtonStriteColor)
        button09.setEnabled(stateButtonStriteColor)
        button_go.setEnabled(stateButtonStriteColor)
        button_si.setEnabled(stateButtonStriteColor)
    }
    fun stateButtonNum() {
        button_4stripe.setEnabled(stateButtonStriteNum)
        button_5stripe.setEnabled(stateButtonStriteNum)
        button_6stripe.setEnabled(stateButtonStriteNum)
    }
    fun positionStripe(){
        textView_value.setTextSize(20f)
        textView_value.setTextColor(Color.BLUE)
        when{
            stripeNum == 1 -> {
               if((stripeValue == "0")||(stripeValue == "10")||(stripeValue == "11")){
                   stripeNum = 1
                   textView_value.setTextSize(24f)
                   textView_value.setTextColor(Color.RED)
                   textView_value.text = ("Opção inválida para a 1ª listra; escolha outra cor.")
               }else {
                   resistorValue = resistorValue + stripeValue
                   colorStripe()
                   stripeNum++
               }
            }
            stripeNum == 2 -> {
               if((stripeValue == "10")||(stripeValue == "11")){
                   stripeNum = 2
                   textView_value.setTextSize(24f)
                   textView_value.setTextColor(Color.RED)
                   textView_value.text = ("Opção inválida para a 2ª listra; escolha outra cor.")
               }else {
                   resistorValue = resistorValue + stripeValue
                   colorStripe()
                   stripeNum++
               }
            }
            stripeNum == 3 -> {
                if(((stripeValue == "10")||(stripeValue == "11"))&&(stripeQuant != 4)){
                    stripeNum = 3
                    textView_value.setTextSize(24f)
                    textView_value.setTextColor(Color.RED)
                    textView_value.text = ("Opção inválida para a 3ª listra; escolha outra cor.")
                }else {
                    if((stripeValue != "10")&&(stripeValue != "11")){
                       resistorValue = resistorValue + stripeValue
                    }else {
                        if(stripeValue == "10") {
                            MultValueStripe_GoSi = 10
                        }else {
                            MultValueStripe_GoSi = 11
                        }
                    }
                    colorStripe()
                    stripeNum++
                }
            }
            stripeNum == 4 -> {
                if((toleranceList[stripeValue.toInt()] == 0.0)&&(stripeQuant == 4)){
                    stripeNum = 4
                    textView_value.setTextSize(24f)
                    textView_value.setTextColor(Color.RED)
                    textView_value.text = ("Opção inválida para a 4ª listra; escolha outra cor.")
                }else {
                    colorStripe()
                    if (stripeQuant == 4) {
                        stateButtonStriteColor = false
                        stateButtonColor()
                        toleranceValue = toleranceList[stripeValue.toInt()]
                        valueResistor()
                        textView_info.text = ("")
                        button_restart.visibility = View.VISIBLE
                    }else {
                        if((stripeValue != "10")&&(stripeValue != "11")){
                            resistorValue = resistorValue + stripeValue
                        }else {
                            if(stripeValue == "10") {
                                MultValueStripe_GoSi = 10
                            }else {
                                MultValueStripe_GoSi = 11
                            }
                        }
                    }
                    stripeNum++
                }
            }
            stripeNum == 5 -> {
                if((toleranceList[stripeValue.toInt()] == 0.0)&&((stripeQuant == 5)||(stripeQuant == 6))){
                    stripeNum = 5
                    textView_value.setTextSize(24f)
                    textView_value.setTextColor(Color.RED)
                    textView_value.text = ("Opção inválida para a 5ª listra; escolha outra cor.")
                }else {
                    toleranceValue = toleranceList[stripeValue.toInt()]
                    colorStripe()
                    if (stripeQuant == 5) {
                        stateButtonStriteColor = false
                        stateButtonColor()
                        valueResistor()
                        textView_info.text = ("")
                        button_restart.visibility = View.VISIBLE
                    }
                    stripeNum++
                }
            }
            stripeNum == 6 -> {
                     if ((stripeValue.toInt() == 0)||(stripeValue.toInt() == 5)||(stripeValue.toInt() > 7)){
                         stripeNum = 6
                         textView_value.setTextSize(24f)
                         textView_value.setTextColor(Color.RED)
                         textView_value.text = ("Opção inválida para a 6ª listra; escolha outra cor.")
                     }else {
                         colorStripe()
                         stateButtonStriteColor = false
                         stateButtonColor()
                         valueResistor()
                         button_restart.visibility = View.VISIBLE
                     }
                }
            else -> {}
        }
    }
    fun valueResistor() {
        var x: Int = 0
        if (stripeQuant == 4) {
            x = 2
        }else {
            x = 3
        }
            for (i in 0..(x - 1)) {
                stripe = stripe + resistorValue[i]
            }
            // Cálculo do valor ôhmico. ---------------------------------------------------
            if (MultValueStripe_GoSi == 0) {

                resistorValueEnd = (Integer.parseInt(stripe.toString())) *
                        Math.pow(10.0, (Integer.parseInt(resistorValue[x].toString()).toDouble()))
            } else {

                if (MultValueStripe_GoSi == 10) {
                    resistorValueEnd = ((Integer.parseInt(stripe.toString())).toDouble()) / 10
                } else {
                    resistorValueEnd = ((Integer.parseInt(stripe.toString())).toDouble()) / 100
                }
            }
            // Cálculo da faixa de variação (tolerância). ---------------------------------------------------
            resistorMinRange = (resistorValueEnd - ((resistorValueEnd * toleranceValue) / 100)).toDouble()
            resistorMaxRange = (resistorValueEnd + ((resistorValueEnd * toleranceValue) / 100)).toDouble()
            valueResistorPrint()
    }
    fun valueResistorPrint() {
        if (stripeQuant == 6) {
            if (resistorValueEnd < 1000) {
                textView_value.text = ("R = " + resistorValueEnd
                        + " Ω" + " +-" + toleranceValue + "%  "
                        + coeficiTemp_ppm_c[stripeValue.toInt()] + " PPM/°C"
                        + System.getProperty("line.separator") + ""
                        + System.getProperty("line.separator") + "Faixa: "
                        + String.format("%.3f", resistorMinRange) + " Ω" + " a "
                        + String.format("%.3f", resistorMaxRange) + " Ω")
            } else {
                if ((resistorValueEnd >= 1000) && (resistorValueEnd < 1000000)) {
                    resistorValueEnd = resistorValueEnd / 1000
                    textView_value.text = ("R = " + resistorValueEnd
                            + " kΩ" + " +-" + toleranceValue + "% "
                            + coeficiTemp_ppm_c[stripeValue.toInt()] + " PPM/°C"
                            + System.getProperty("line.separator") + ""
                            + System.getProperty("line.separator") + "Faixa: "
                            + String.format("%.3f", resistorMinRange) + " Ω" + " a "
                            + String.format("%.3f", resistorMaxRange) + " Ω")
                } else {
                    resistorValueEnd = resistorValueEnd / 1000000
                    resistorMinRange = resistorMinRange / 1000
                    resistorMaxRange = resistorMaxRange / 1000

                    textView_value.text = ("R = " + resistorValueEnd
                            + " MΩ" + " +-" + toleranceValue + "% "
                            + coeficiTemp_ppm_c[stripeValue.toInt()] + " PPM/°C"
                            + System.getProperty("line.separator") + ""
                            + System.getProperty("line.separator") + "Faixa: "
                            + String.format("%.3f", resistorMinRange) + " kΩ" + " a "
                            + String.format("%.3f", resistorMaxRange) + " kΩ")
                }
            }
        } else {
            if (resistorValueEnd < 1000) {

                textView_value.text = ("R = " + resistorValueEnd
                        + " Ω" + " +-" + toleranceValue + "%  "
                        + System.getProperty("line.separator") + ""
                        + System.getProperty("line.separator") + "Faixa: "
                        + String.format("%.3f", resistorMinRange) + " Ω" + " a "
                        + String.format("%.3f", resistorMaxRange) + " Ω")
            } else {
                if ((resistorValueEnd >= 1000) && (resistorValueEnd < 1000000)) {

                    resistorValueEnd = resistorValueEnd / 1000
                    textView_value.text = ("R = " + resistorValueEnd
                            + " kΩ" + " +-" + toleranceValue + "%"
                            + System.getProperty("line.separator") + ""
                            + System.getProperty("line.separator") + "Faixa: "
                            + String.format("%.3f", resistorMinRange) + " Ω" + " a "
                            + String.format("%.3f", resistorMaxRange) + " Ω")
                } else {
                    resistorValueEnd = resistorValueEnd / 1000000
                    resistorMinRange = resistorMinRange / 1000
                    resistorMaxRange = resistorMaxRange / 1000

                    textView_value.text = ("R = " + resistorValueEnd
                            + " MΩ" + " +-" + toleranceValue + "%"
                            + System.getProperty("line.separator") + ""
                            + System.getProperty("line.separator") + "Faixa: "
                            + String.format("%.3f", resistorMinRange) + " kΩ" + " a "
                            + String.format("%.3f", resistorMaxRange) + " kΩ")
                }
            }
        }
    }
    fun colorStripe(){
        when{
            stripeValue == "0" -> {
                when{
                    stripeNum == 1 -> {textView_l1.setBackgroundResource(R.color.r0)}
                    stripeNum == 2 -> {textView_l2.setBackgroundResource(R.color.r0)}
                    stripeNum == 3 -> {textView_l3.setBackgroundResource(R.color.r0)}
                    stripeNum == 4 -> {textView_l4.setBackgroundResource(R.color.r0)}
                    stripeNum == 5 -> {textView_l5.setBackgroundResource(R.color.r0)}
                    stripeNum == 6 -> {textView_l6.setBackgroundResource(R.color.r0)}
                    else -> {}
                }
            }
            stripeValue == "1" -> {
                when{
                    stripeNum == 1 -> {textView_l1.setBackgroundResource(R.color.r1)}
                    stripeNum == 2 -> {textView_l2.setBackgroundResource(R.color.r1)}
                    stripeNum == 3 -> {textView_l3.setBackgroundResource(R.color.r1)}
                    stripeNum == 4 -> {textView_l4.setBackgroundResource(R.color.r1)}
                    stripeNum == 5 -> {textView_l5.setBackgroundResource(R.color.r1)}
                    stripeNum == 6 -> {textView_l6.setBackgroundResource(R.color.r1)}
                    else -> {}
                }
            }
            stripeValue == "2" -> {
                when{
                    stripeNum == 1 -> {textView_l1.setBackgroundResource(R.color.r2)}
                    stripeNum == 2 -> {textView_l2.setBackgroundResource(R.color.r2)}
                    stripeNum == 3 -> {textView_l3.setBackgroundResource(R.color.r2)}
                    stripeNum == 4 -> {textView_l4.setBackgroundResource(R.color.r2)}
                    stripeNum == 5 -> {textView_l5.setBackgroundResource(R.color.r2)}
                    stripeNum == 6 -> {textView_l6.setBackgroundResource(R.color.r2)}
                    else -> {}
                }
            }
            stripeValue == "3" -> {
                when{
                    stripeNum == 1 -> {textView_l1.setBackgroundResource(R.color.r3)}
                    stripeNum == 2 -> {textView_l2.setBackgroundResource(R.color.r3)}
                    stripeNum == 3 -> {textView_l3.setBackgroundResource(R.color.r3)}
                    stripeNum == 4 -> {textView_l4.setBackgroundResource(R.color.r3)}
                    stripeNum == 5 -> {textView_l5.setBackgroundResource(R.color.r3)}
                    stripeNum == 6 -> {textView_l6.setBackgroundResource(R.color.r3)}
                    else -> {}
                }
            }
            stripeValue == "4" -> {
                when{
                    stripeNum == 1 -> {textView_l1.setBackgroundResource(R.color.r4)}
                    stripeNum == 2 -> {textView_l2.setBackgroundResource(R.color.r4)}
                    stripeNum == 3 -> {textView_l3.setBackgroundResource(R.color.r4)}
                    stripeNum == 4 -> {textView_l4.setBackgroundResource(R.color.r4)}
                    stripeNum == 5 -> {textView_l5.setBackgroundResource(R.color.r4)}
                    stripeNum == 6 -> {textView_l6.setBackgroundResource(R.color.r4)}
                    else -> {}
                }
            }
            stripeValue == "5" -> {
                when{
                    stripeNum == 1 -> {textView_l1.setBackgroundResource(R.color.r5)}
                    stripeNum == 2 -> {textView_l2.setBackgroundResource(R.color.r5)}
                    stripeNum == 3 -> {textView_l3.setBackgroundResource(R.color.r5)}
                    stripeNum == 4 -> {textView_l4.setBackgroundResource(R.color.r5)}
                    stripeNum == 5 -> {textView_l5.setBackgroundResource(R.color.r5)}
                    stripeNum == 6 -> {textView_l6.setBackgroundResource(R.color.r5)}
                    else -> {}
                }
            }
            stripeValue == "6" -> {
                when{
                    stripeNum == 1 -> {textView_l1.setBackgroundResource(R.color.r6)}
                    stripeNum == 2 -> {textView_l2.setBackgroundResource(R.color.r6)}
                    stripeNum == 3 -> {textView_l3.setBackgroundResource(R.color.r6)}
                    stripeNum == 4 -> {textView_l4.setBackgroundResource(R.color.r6)}
                    stripeNum == 5 -> {textView_l5.setBackgroundResource(R.color.r6)}
                    stripeNum == 6 -> {textView_l6.setBackgroundResource(R.color.r6)}
                    else -> {}
                }
            }
            stripeValue == "7" -> {
                when{
                    stripeNum == 1 -> {textView_l1.setBackgroundResource(R.color.r7)}
                    stripeNum == 2 -> {textView_l2.setBackgroundResource(R.color.r7)}
                    stripeNum == 3 -> {textView_l3.setBackgroundResource(R.color.r7)}
                    stripeNum == 4 -> {textView_l4.setBackgroundResource(R.color.r7)}
                    stripeNum == 5 -> {textView_l5.setBackgroundResource(R.color.r7)}
                    stripeNum == 6 -> {textView_l6.setBackgroundResource(R.color.r7)}
                    else -> {}
                }
            }
            stripeValue == "8" -> {
                when{
                    stripeNum == 1 -> {textView_l1.setBackgroundResource(R.color.r8)}
                    stripeNum == 2 -> {textView_l2.setBackgroundResource(R.color.r8)}
                    stripeNum == 3 -> {textView_l3.setBackgroundResource(R.color.r8)}
                    stripeNum == 4 -> {textView_l4.setBackgroundResource(R.color.r8)}
                    stripeNum == 5 -> {textView_l5.setBackgroundResource(R.color.r8)}
                    stripeNum == 6 -> {textView_l6.setBackgroundResource(R.color.r8)}
                    else -> {}
                }
            }
            stripeValue == "9" -> {
                when{
                    stripeNum == 1 -> {textView_l1.setBackgroundResource(R.color.r9)}
                    stripeNum == 2 -> {textView_l2.setBackgroundResource(R.color.r9)}
                    stripeNum == 3 -> {textView_l3.setBackgroundResource(R.color.r9)}
                    stripeNum == 4 -> {textView_l4.setBackgroundResource(R.color.r9)}
                    stripeNum == 5 -> {textView_l5.setBackgroundResource(R.color.r9)}
                    stripeNum == 6 -> {textView_l6.setBackgroundResource(R.color.r9)}
                    else -> {}
                }
            }
            stripeValue == "10" -> {
                when{
                    stripeNum == 1 -> {textView_l1.setBackgroundResource(R.color.go)}
                    stripeNum == 2 -> {textView_l2.setBackgroundResource(R.color.go)}
                    stripeNum == 3 -> {textView_l3.setBackgroundResource(R.color.go)}
                    stripeNum == 4 -> {textView_l4.setBackgroundResource(R.color.go)}
                    stripeNum == 5 -> {textView_l5.setBackgroundResource(R.color.go)}
                    stripeNum == 6 -> {textView_l6.setBackgroundResource(R.color.go)}
                    else -> {}
                }
            }
            stripeValue == "11" -> {
                when{
                    stripeNum == 1 -> {textView_l1.setBackgroundResource(R.color.si)}
                    stripeNum == 2 -> {textView_l2.setBackgroundResource(R.color.si)}
                    stripeNum == 3 -> {textView_l3.setBackgroundResource(R.color.si)}
                    stripeNum == 4 -> {textView_l4.setBackgroundResource(R.color.si)}
                    stripeNum == 5 -> {textView_l5.setBackgroundResource(R.color.si)}
                    stripeNum == 6 -> {textView_l6.setBackgroundResource(R.color.si)}
                    else -> {}
                }
            }
            else -> {}
        }
    }
    fun colorStripeClear(){
        textView_l1.setBackgroundResource(R.color.StripeClear)
        textView_l2.setBackgroundResource(R.color.StripeClear)
        textView_l3.setBackgroundResource(R.color.StripeClear)
        textView_l4.setBackgroundResource(R.color.StripeClear)
        textView_l5.setBackgroundResource(R.color.StripeClear)
        textView_l6.setBackgroundResource(R.color.StripeClear)
    }
}