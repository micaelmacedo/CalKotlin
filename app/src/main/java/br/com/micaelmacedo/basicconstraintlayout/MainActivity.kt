package br.com.micaelmacedo.basicconstraintlayout

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Double.parseDouble


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Números
        tvOne.setOnClickListener { tv -> showChar(tv as TextView) }
        tvTwo.setOnClickListener { tv -> showChar(tv as TextView) }
        tvThree.setOnClickListener { tv -> showChar(tv as TextView) }
        tvFour.setOnClickListener { tv -> showChar(tv as TextView) }
        tvFive.setOnClickListener { tv -> showChar(tv as TextView) }
        tvSix.setOnClickListener { tv -> showChar(tv as TextView) }
        tvSeven.setOnClickListener { tv -> showChar(tv as TextView) }
        tvEight.setOnClickListener { tv -> showChar(tv as TextView) }
        tvNine.setOnClickListener { tv -> showChar(tv as TextView) }
        tvZero.setOnClickListener { tv -> showChar(tv as TextView) }

        //Funções com dois componentes
        tvSum.setOnClickListener {
            var tv = it as TextView;
            var result = validateExpression(tvCalcScreen.text.split(" "))
            if (result.toString() != "null") {
                appendHistory(result)
                showResult(result.toString() + " + ")

            } else {
                putSpace(tv)
                showChar(tv)
                putSpace(tv)
            }
        }

        tvSubtr.setOnClickListener {
            var tv = it as TextView;
            var result = validateExpression(tvCalcScreen.text.split(" "))
            if (result.toString() != "null") {
                appendHistory(result)
                showResult(result.toString() + " - ")

            } else {
                putSpace(tv)
                showChar(tv)
                putSpace(tv)
            }
        }

        tvDivision.setOnClickListener {
            var tv = it as TextView;
            var result = validateExpression(tvCalcScreen.text.split(" "))
            if (result.toString() != "null") {
                appendHistory(result)
                showResult(result.toString() + " ÷ ")

            } else {
                putSpace(tv)
                showChar(tv)
                putSpace(tv)
            }
        }

        tvMultiplication.setOnClickListener {
            var tv = it as TextView;
            var result = validateExpression(tvCalcScreen.text.split(" "))
            if (result.toString() != "null") {
                appendHistory(result)
                showResult(result.toString() + " x ")
            } else {
                putSpace(tv)
                showChar(tv)
                putSpace(tv)
            }
        }

        //Operação da calculadora
        tvClean.setOnClickListener { tv -> cleanScreen(tv as TextView) }

        tvResult.setOnClickListener {
            var result = validateExpression(tvCalcScreen.text.split(" "))
            if (result.toString() != "null") {
                showResult(result.toString())
                appendHistory(result)
            } else { showResult("Erro")}

        }

        //Funções com um componente
    }

    private fun showChar(v: TextView) {
        tvCalcScreen.append(v.text)
    }

    private fun showResult(result: CharSequence) {
        tvCalcScreen.text = result
    }

    private fun putSpace(v: TextView) {
        tvCalcScreen.append(" ")
    }

    private fun cleanScreen(v: TextView) {
        tvCalcScreen.text = "";
    }

    private fun appendHistory(result:Float?) {
        if (result != null) {
            var operation = tvCalcScreen.text
            operation = "$operation\n"
            tvCalcHistory.append(operation)
        }
    }

    private fun calculate(v: TextView) {
        var operation = replaceOperation(tvCalcScreen.text.toString());
        val operationBuild = ExpressionBuilder(operation).build()
        try {

            val result = operationBuild.evaluate()
            showResult(result.toString())
        } catch (ex: ArithmeticException) {

            showResult("Error")
        }
    }

    private fun replaceOperation(operation: String): String {
        var operation = operation.replace("÷", "/")
        operation = operation.replace("x", "*")
        return operation
    }

    private fun splitExpression(expression: String): List<String> {
        var split = expression.split(" ");
        return split
    }


    private fun sum(split: List<String>): Float? {
        if (split.size < 3) {
            return null
        } else {
            return split[0].toFloat() + split[2].toFloat();

        }
    }

    private fun subtr(split: List<String>): Float? {
        if (split.size < 3) {
            return null;
        } else {
            return split[0].toFloat() - split[2].toFloat()

        }
    }

    private fun multi(split: List<String>): Float? {
        if (split.size < 3) {
            return null;
        } else {
            return split[0].toFloat() * split[2].toFloat();

        }
    }


    private fun division(split: List<String>): Float? {
        if (split.size < 3) {
            return null;
        } else {
            return split[0].toFloat() / split[2].toFloat()

        }
    }

    private fun validateExpression(expression: List<String>): Float? {
        var result: Float? = null
        if ((!expression.last().matches("-?\\d+(\\.\\d+)?".toRegex()) || !expression.first()
                .matches("-?\\d+(\\.\\d+)?".toRegex()))
        ) {
            return result
        }
        if (expression.size == 3) {
            if (expression[1] == "+") result = sum(expression)
            if (expression[1] == "-") result = subtr(expression)
            if (expression[1] == "x") result = multi(expression)
            if (expression[1] == "÷") result = division(expression)
            return result
        } else {
            return result
        }
    }
}





