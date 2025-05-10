package com.example.calculadora_cientifica

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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
        val display = findViewById<TextView>(R.id.display)
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
        val btnMultiplicar = findViewById<Button>(R.id.btnMultiplicar)
        val btnMais = findViewById<Button>(R.id.btnMais)
        val btnMenos = findViewById<Button>(R.id.btnMenos)
        val btnDividir = findViewById<Button>(R.id.btnDividir)
        val btnPonto = findViewById<Button>(R.id.btnPonto)
        val btnIgual = findViewById<Button>(R.id.btnIgual)
        val btnMC = findViewById<Button>(R.id.btnMC)
        val btnMRC = findViewById<Button>(R.id.btnMRC)
        val btnMMAIS = findViewById<Button>(R.id.btnMMais)
        val btnMMenos = findViewById<Button>(R.id.btnMMenos)
        val btnCE = findViewById<Button>(R.id.btnCE)
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


        btnCE.setOnClickListener {
            display.setText("0")
        }

        btnPonto.setOnClickListener {
            if(!display.text.toString().contains("."))
                display.setText(display.text.toString().plus("."))

        }


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
                4 -> if (temp2 != 0.0) temp1 / temp2 else Double.NaN
                else -> 0.0
            }
            display.text = if (result.isNaN()) "Erro" else result.toString()
        }
    }
}