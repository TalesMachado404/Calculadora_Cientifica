package com.example.calculadora_cientifica

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var MR = 0.0
        var temp1 = 0.0
        var temp2 = 0.0
        var operacao = 0
        var result = 0.0

        /*O display da tela*/
        val display = findViewById<TextView>(R.id.display)

        /*Botões de 0 a 9 e outos*/
        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btn3 = findViewById<Button>(R.id.btn3)
        val btn4 = findViewById<Button>(R.id.btn4)
        val btn5 = findViewById<Button>(R.id.btn5)
        val btn6 = findViewById<Button>(R.id.btn6)
        val btn7 = findViewById<Button>(R.id.btn7)
        val btn8 = findViewById<Button>(R.id.btn8)
        val btn9 = findViewById<Button>(R.id.btn9)
        val btn0 = findViewById<Button>(R.id.btn0)
        val btnPI = findViewById<Button>(R.id.btnPI)
        val btnE = findViewById<Button>(R.id.btnE)
        val pi = String.format("%.4f", Math.PI)
        val e = String.format("%.4f", Math.E)


        /*Operadores*/
        val btnMultiplicar = findViewById<Button>(R.id.btnMultiplicar)
        val btnMais = findViewById<Button>(R.id.btnMais)
        val btnMenos = findViewById<Button>(R.id.btnMenos)
        val btnDividir = findViewById<Button>(R.id.btnDividir)

        /*Operadores no display*/
        val btnPORC = findViewById<Button>(R.id.btnPORC)
        val btnFatorial = findViewById<Button>(R.id.btnFatorial)
        val btnRaizQ = findViewById<Button>(R.id.btnRaizQ)
        val btnLog = findViewById<Button>(R.id.btnlog)

        /*Exponenciais*/
        val btnEXPOG = findViewById<Button>(R.id.btnEXPOG)
        val btnEXPON = findViewById<Button>(R.id.btnEXPON)
        val btnEXPOD = findViewById<Button>(R.id.btnEXPOD)

        /*Angulos*/
        val btnCOS = findViewById<Button>(R.id.btnCOS)
        val btnSIN = findViewById<Button>(R.id.btnSIN)
        val btnTAN = findViewById<Button>(R.id.btnTAN)


        /*PONTO*/
        val btnPonto = findViewById<Button>(R.id.btnPonto)

        /*Botão de igual*/
        val btnIgual = findViewById<Button>(R.id.btnIgual)

        /*Manipuladores de Memoria*/
        val btnMC = findViewById<Button>(R.id.btnMC)
        val btnMRC = findViewById<Button>(R.id.btnMRC)
        val btnMMAIS = findViewById<Button>(R.id.btnMMais)
        val btnMMenos = findViewById<Button>(R.id.btnMMenos)

        /*Tipos de delete*/
        val btnCE = findViewById<Button>(R.id.btnCE)
        val btnDLT = findViewById<Button>(R.id.btnDLT)



        /*----------------------------------------------------------------------------------------------------*/


        btn0.setOnClickListener {
            if(!display.text.toString().equals("0"))
                display.setText(display.text.toString().plus("0"))

        }

        btn1.setOnClickListener {
            if(display.text.toString().equals("0"))
                display.setText("1")
            else
                display.setText(display.text.toString().plus("1"))

        }

        btn2.setOnClickListener {
            if(display.text.toString().equals("0"))
                display.setText("2")
            else
                display.setText(display.text.toString().plus("2"))

        }

        btn3.setOnClickListener {
            if(display.text.toString().equals("0"))
                display.setText("3")
            else
                display.setText(display.text.toString().plus("3"))

        }

        btn4.setOnClickListener {
            if(display.text.toString().equals("0"))
                display.setText("4")
            else
                display.setText(display.text.toString().plus("4"))

        }

        btn5.setOnClickListener {
            if(display.text.toString().equals("0"))
                display.setText("5")
            else
                display.setText(display.text.toString().plus("5"))

        }

        btn6.setOnClickListener {
            if(display.text.toString().equals("0"))
                display.setText("6")
            else
                display.setText(display.text.toString().plus("6"))

        }

        btn7.setOnClickListener {
            if(display.text.toString().equals("0"))
                display.setText("7")
            else
                display.setText(display.text.toString().plus("7"))

        }

        btn8.setOnClickListener {
            if(display.text.toString().equals("0"))
                display.setText("8")
            else
                display.setText(display.text.toString().plus("8"))

        }

        btn9.setOnClickListener {
            if(display.text.toString().equals("0"))
                display.setText("9")
            else
                display.setText(display.text.toString().plus("9"))

        }

        btnPI.setOnClickListener {
                display.setText(pi)
        }

        btnE.setOnClickListener {
                display.setText(e)
        }


        /*----------------------------------------------------------------------------------------------------*/


        btnCE.setOnClickListener {
            display.setText("0")
        }

        fun apagarUltimoCaractere(display: TextView) {
            val textoAtual = display.text.toString()
            if (textoAtual.isNotEmpty() && textoAtual != "0") {
                val novoTexto = textoAtual.dropLast(1)
                display.text = if (novoTexto.isEmpty()) "0" else novoTexto
            }
        }

        btnDLT.setOnClickListener{
            apagarUltimoCaractere(display)
        }




        /*----------------------------------------------------------------------------------------------------*/


        btnPonto.setOnClickListener {
            if(!display.text.toString().contains("."))
                display.setText(display.text.toString().plus("."))

        }


        /*----------------------------------------------------------------------------------------------------*/



        btnMRC.setOnClickListener {
            display.setText(MR.toString())

        }

        btnMC.setOnClickListener {
            MR = 0.0
            display.text ="0"
        }

        btnMMAIS.setOnClickListener {
            MR += display.text.toString().toDouble()
            display.setText("0")

        }

        btnMMenos.setOnClickListener {
            MR -= display.text.toString().toDouble()
            display.setText("0")

        }


        /*----------------------------------------------------------------------------------------------------*/


        btnEXPOG.setOnClickListener {
            temp1 = display.text.toString().toDouble()
            operacao = 5
            display.setText("0")
        }

        btnEXPON.setOnClickListener {
            val value = display.text.toString().toDoubleOrNull()

            if (value != null) {
                val result = Math.exp(value)
                display.text = String.format("%.4f", result)
            } else {
                display.text = "Erro"
            }
        }

        btnEXPOD.setOnClickListener {
            val value = display.text.toString().toDoubleOrNull()

            if (value != null) {
                val result = Math.pow(10.0, value)
                display.text = result.toString()
            } else {
                display.text = "Erro"
            }
        }



        /*----------------------------------------------------------------------------------------------------*/


        btnFatorial.setOnClickListener {
            val value = display.text.toString().toIntOrNull()

            if (value != null && value >= 0) {
                var result = 1
                for (i in 1..value) {
                    result *= i
                }
                display.text = result.toString()
            } else {
                display.text = "Erro"
            }
        }


        btnRaizQ.setOnClickListener {
            val value = display.text.toString().toDoubleOrNull()

            if (value != null) {
                val result = Math.sqrt(value)
                display.text = result.toString()
            } else {
                display.text = "Erro"
            }
        }


        btnPORC.setOnClickListener {
            val text = display.text.toString()
            if (text.isNotEmpty() && text.toDoubleOrNull() != null) {
                val current = text.toDouble()
                val result = temp1 * current / 100
                display.text = result.toString()
            } else {
                display.text = "Erro"
            }
        }

        btnLog.setOnClickListener {
            try {
                val value = display.text.toString().toDouble()
                val result = if (value > 0) log10(value) else Double.NaN
                display.text = if (result.isNaN()) "Erro" else result.toString()
            } catch (e: Exception) {
                display.text = "Erro"
            }
        }


        /*----------------------------------------------------------------------------------------------------*/


        btnCOS.setOnClickListener {
            try {
                val value = display.text.toString().toDouble()
                val result = cos(Math.toRadians(value))
                display.text = result.toString()
            } catch (e: Exception) {
                display.text = "Erro"
            }
        }

        btnSIN.setOnClickListener {
            try {
                val value = display.text.toString().toDouble()
                val result = sin(Math.toRadians(value))
                display.text = result.toString()
            } catch (e: Exception) {
                display.text = "Erro"
            }
        }

        btnTAN.setOnClickListener {
            try {
                val value = display.text.toString().toDouble()
                val result = tan(Math.toRadians(value))
                display.text = result.toString()
            } catch (e: Exception) {
                display.text = "Erro"
            }
        }


        /*----------------------------------------------------------------------------------------------------*/


        btnMais.setOnClickListener {
            temp1 = display.text.toString().toDouble()
            operacao = 1
            display.setText("0")

        }

        btnMenos.setOnClickListener {
            temp1 = display.text.toString().toDouble()
            operacao = 2
            display.setText("0")

        }
        btnMultiplicar.setOnClickListener {
            temp1 = display.text.toString().toDouble()
            operacao = 3
            display.setText("0")

        }

        btnDividir.setOnClickListener {
            temp1 = display.text.toString().toDouble()
            operacao = 4
            display.setText("0")

        }

        btnIgual.setOnClickListener {
            temp2 = display.text.toString().toDouble()
            when(operacao) {
                1 -> result = temp1 + temp2
                2 -> result = temp1 - temp2
                3 -> result = temp1 * temp2
                4 -> result = if (temp2 != 0.0) temp1 / temp2 else Double.NaN
                5 -> result = Math.pow(temp1, temp2)
                else -> 0.0
            }
            display.text = if (result.isNaN()) "Erro" else result.toString()
        }
    }
}