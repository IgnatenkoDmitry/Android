package com.example.mycalculator_ignatenko_32is_21

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Привязка переменных к кнопкам интерфейса
        val operation: TextView = findViewById(R.id.operation)
        val result: TextView = findViewById(R.id.result)
        val b_sqrt: TextView = findViewById(R.id.b_sqrt)
        val b_log2: TextView = findViewById(R.id.b_log2)
        val b_ln: TextView = findViewById(R.id.b_ln)
        val b_leftb: TextView = findViewById(R.id.b_leftb)
        val b_rightb: TextView = findViewById(R.id.b_rightb)
        val b_x_y: TextView = findViewById(R.id.b_x_y)
        val b_AC: TextView = findViewById(R.id.b_AC)
        val b_back: TextView = findViewById(R.id.b_back)
        val b_percent: TextView = findViewById(R.id.b_percent)
        val b_devision: TextView = findViewById(R.id.b_devision)
        val b_sin: TextView = findViewById(R.id.b_sin)
        val b_seven: TextView = findViewById(R.id.b_seven)
        val b_eight: TextView = findViewById(R.id.b_eight)
        val b_nine: TextView = findViewById(R.id.b_nine)
        val b_multiplication: TextView = findViewById(R.id.b_multiplication)
        val b_cos: TextView = findViewById(R.id.b_cos)
        val b_four: TextView = findViewById(R.id.b_four)
        val b_five: TextView = findViewById(R.id.b_five)
        val b_six: TextView = findViewById(R.id.b_six)
        val b_subtraction: TextView = findViewById(R.id.b_subtraction)
        val b_pi: TextView = findViewById(R.id.b_pi)
        val b_one: TextView = findViewById(R.id.b_one)
        val b_two: TextView = findViewById(R.id.b_two)
        val b_three: TextView = findViewById(R.id.b_three)
        val b_addition: TextView = findViewById(R.id.b_addition)
        val b_ex: TextView = findViewById(R.id.b_ex)
        val b_three_zero: TextView = findViewById(R.id.b_three_zero)
        val b_point: TextView = findViewById(R.id.b_point)
        val b_zero: TextView = findViewById(R.id.b_zero)
        val b_equals: TextView = findViewById(R.id.b_equals)

        // Установка слушателей для кнопок
        b_sqrt.setOnClickListener { operation.append("sqrt(") }
        b_log2.setOnClickListener { operation.append("log2(") }
        b_ln.setOnClickListener { operation.append("ln(") }
        b_leftb.setOnClickListener { operation.append("(") }
        b_rightb.setOnClickListener { operation.append(")") }
        b_x_y.setOnClickListener { operation.append("^") }
        b_AC.setOnClickListener { operation.text = ""; result.text = "" }
        b_back.setOnClickListener {
            val s = operation.text.toString()
            if (s.isNotEmpty()) {
                operation.text = s.substring(0, s.length - 1)
            }
        }
        b_percent.setOnClickListener { operation.append("%") }
        b_devision.setOnClickListener { operation.append("/") }
        b_sin.setOnClickListener { operation.append("sin(") }
        b_seven.setOnClickListener { operation.append("7") }
        b_eight.setOnClickListener { operation.append("8") }
        b_nine.setOnClickListener { operation.append("9") }
        b_multiplication.setOnClickListener { operation.append("*") }
        b_cos.setOnClickListener { operation.append("cos(") }
        b_four.setOnClickListener { operation.append("4") }
        b_five.setOnClickListener { operation.append("5") }
        b_six.setOnClickListener { operation.append("6") }
        b_subtraction.setOnClickListener { operation.append("-") }
        b_pi.setOnClickListener { operation.append("π") }
        b_one.setOnClickListener { operation.append("1") }
        b_two.setOnClickListener { operation.append("2") }
        b_three.setOnClickListener { operation.append("3") }
        b_addition.setOnClickListener { operation.append("+") }
        b_ex.setOnClickListener { operation.append("e") }
        b_three_zero.setOnClickListener { operation.append("000") }
        b_point.setOnClickListener { operation.append(".") }
        b_zero.setOnClickListener { operation.append("0") }
        b_equals.setOnClickListener {
            val optext = operation.text.toString()
            if (optext.isNotEmpty()) {
                try {
                    val expr = ExpressionBuilder(operation.text.toString()).build()
                    val res = expr.evaluate()
                    val longres = res.toLong()
                    if (longres.toDouble() == res) {
                        result.text = longres.toString()
                    } else {
                        result.text = res.toString()
                    }
                } catch (e: Exception) {
                    result.text = "Error"
                }
            }
        }
    }
}