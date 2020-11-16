package br.com.micaelmacedo.basicconstraintlayout

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.*


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

        tvComma.setOnClickListener{ tv -> showChar(tv as TextView) }

        tvMinusPlus.setOnClickListener{
            minusPlus()
        }

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

        tvLog.setOnClickListener{
            var tv = it as TextView;
            var result = validateExpression(tvCalcScreen.text.split(" "))
            if (result.toString() != "null") {
                appendHistory(result)
                showResult(result.toString() + " log ")
            } else {
                putSpace(tv)
                showChar(tv)
                putSpace(tv)
            }
        }

        tvPower.setOnClickListener{
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
                appendHistory(result)
                showResult(result.toString())
            } else { showResult("Erro")}

        }

        //Funções com um componente
        tvPwrTwo.setOnClickListener{
            var tv = it as TextView
            var result = pwrTwo()
        }

        tvSqrRoot.setOnClickListener{
            var tv = it as TextView
            var result = sqrRoot()
        }

        tvTenPwr.setOnClickListener{
            var tv = it as TextView
            var result = tenPwr()
        }

        tvLn.setOnClickListener{
            var tv = it as TextView
            var result = lnFun()
        }

        tvDenominator.setOnClickListener{
            var tv = it as TextView
            var result = denominator()
        }
        tvModule.setOnClickListener{
            var tv = it as TextView
            var result = module()
        }
        tvFactorial.setOnClickListener{
            var tv = it as TextView
            var result = factorial()
        }

        tvTan.setOnClickListener{
            var tv = it as TextView
            var result = tanFun()
        }

        tvSin.setOnClickListener{
            var tv = it as TextView
            var result = sinFun()
        }

        tvCos.setOnClickListener{
            var tv = it as TextView
            var result = cosFun()
        }

        tvRevCos.setOnClickListener{
            var tv = it as TextView
            var result = revCos()
        }

        tvRevSin.setOnClickListener{
            var tv = it as TextView
            var result = revSin()
        }

        tvInvTan.setOnClickListener{
            var tv = it as TextView
            var result = revTan()
        }
    }

    private fun logFun(split: List<String>): Float? {
        if (split.size < 3) {
            return null;
        } else {
            return log(split[0].toDouble() , split[2].toDouble()).toFloat()

        }
    }

    private fun revCos() {
        var screenText = tvCalcScreen.text.split(" ").toMutableList()
        if (!validateNumber(screenText)) tvCalcScreen.text = "Erro"
        else {
            var target = screenText.last()
            val lastIndex = screenText.size
            val result = (1/cos(target.toFloat())).toString()
            screenText.set(lastIndex-1,result)
            tvCalcScreen.text = screenText.joinToString( separator = " ")
        }
    }

    private fun revSin() {
        var screenText = tvCalcScreen.text.split(" ").toMutableList()
        if (!validateNumber(screenText)) tvCalcScreen.text = "Erro"
        else {
            var target = screenText.last()
            val lastIndex = screenText.size
            val result = (1/sin(target.toFloat())).toString()
            screenText.set(lastIndex-1,result)
            tvCalcScreen.text = screenText.joinToString( separator = " ")
        }
    }

    private fun revTan() {
        var screenText = tvCalcScreen.text.split(" ").toMutableList()
        if (!validateNumber(screenText)) tvCalcScreen.text = "Erro"
        else {
            var target = screenText.last()
            val lastIndex = screenText.size
            val result = (1/tan(target.toFloat())).toString()
            screenText.set(lastIndex-1,result)
            tvCalcScreen.text = screenText.joinToString( separator = " ")
        }
    }

    private fun tanFun() {
        var screenText = tvCalcScreen.text.split(" ").toMutableList()
        if (!validateNumber(screenText)) tvCalcScreen.text = "Erro"
        else {
            var target = screenText.last()
            val lastIndex = screenText.size
            val result = (tan(target.toFloat())).toString()
            screenText.set(lastIndex-1,result)
            tvCalcScreen.text = screenText.joinToString( separator = " ")
        }
    }

    private fun cosFun() {
        var screenText = tvCalcScreen.text.split(" ").toMutableList()
        if (!validateNumber(screenText)) tvCalcScreen.text = "Erro"
        else {
            var target = screenText.last()
            val lastIndex = screenText.size
            val result = (cos(target.toFloat())).toString()
            screenText.set(lastIndex-1,result)
            tvCalcScreen.text = screenText.joinToString( separator = " ")
        }
    }

    private fun sinFun() {
        var screenText = tvCalcScreen.text.split(" ").toMutableList()
        if (!validateNumber(screenText)) tvCalcScreen.text = "Erro"
        else {
            var target = screenText.last()
            val lastIndex = screenText.size
            val result = (sin(target.toFloat())).toString()
            screenText.set(lastIndex-1,result)
            tvCalcScreen.text = screenText.joinToString( separator = " ")
        }
    }

    private fun pwrTwo(){
        var screenText = tvCalcScreen.text.split(" ").toMutableList()
        if (!validateNumber(screenText)) tvCalcScreen.text = "Erro"
        else {
            var target = screenText.last()
            val lastIndex = screenText.size
            val result = target.toFloat().pow(2).toString()
            screenText.set(lastIndex-1,result)
            tvCalcScreen.text = screenText.joinToString( separator = " ")
        }
    }

    private fun tenPwr(){
        var screenText = tvCalcScreen.text.split(" ").toMutableList()
        if (!validateNumber(screenText)) tvCalcScreen.text = "Erro"
        else {
            var target = screenText.last()
            val lastIndex = screenText.size
            val result = 10.toFloat().pow(target.toFloat()).toString()
            screenText.set(lastIndex-1,result)
            tvCalcScreen.text = screenText.joinToString( separator = " ")
        }
    }
    private fun lnFun(){
        var screenText = tvCalcScreen.text.split(" ").toMutableList()
        if (!validateNumber(screenText)) tvCalcScreen.text = "Erro"
        else {
            var target = screenText.last()
            val lastIndex = screenText.size
            val result = ln(target.toFloat()).toString()
            screenText.set(lastIndex-1,result)
            tvCalcScreen.text = screenText.joinToString( separator = " ")
        }
    }

    private fun sqrRoot(){
        var screenText = tvCalcScreen.text.split(" ").toMutableList()
        if (!validateNumber(screenText)) tvCalcScreen.text = "Erro"
        else {
            var target = screenText.last()
            val lastIndex = screenText.size
            val result = kotlin.math.sqrt(target.toFloat()).toString()
            screenText.set(lastIndex-1,result)
            tvCalcScreen.text = screenText.joinToString( separator = " ")
        }
    }

    private fun denominator(){
        var screenText = tvCalcScreen.text.split(" ").toMutableList()
        if (!validateNumber(screenText)) tvCalcScreen.text = "Erro"
        else {
            var target = screenText.last()
            val lastIndex = screenText.size
            val result = (1/(target.toFloat())).toString()
            screenText.set(lastIndex-1,result)
            tvCalcScreen.text = screenText.joinToString( separator = " ")
        }
    }

    private fun module(){
        var screenText = tvCalcScreen.text.split(" ").toMutableList()
        if (!validateNumber(screenText)) tvCalcScreen.text = "Erro"
        else {
            var target = screenText.last()
            val lastIndex = screenText.size
            val result = (target.toFloat().absoluteValue).toString()
            screenText.set(lastIndex-1,result)
            tvCalcScreen.text = screenText.joinToString( separator = " ")
        }
    }

    private fun factorial(){
        var screenText = tvCalcScreen.text.split(" ").toMutableList()
        if (!validateNumber(screenText)) tvCalcScreen.text = "Erro"
        else {
            var target = screenText.last()
            val lastIndex = screenText.size
            var i = target.toIntOrNull()
            var result = target
            var resultInt = result.toInt()
            if (i == null){
                result = "Erro"
            } else {
                while (i > 1) {
                    resultInt = resultInt * (i - 1)
                    i--
                }
                result = resultInt.toString()

            }
            screenText.set(lastIndex - 1, result)
            tvCalcScreen.text = screenText.joinToString( separator = " ")
        }
    }

    private fun minusPlus(){
        var screenText = tvCalcScreen.text.split(" ").toMutableList()
        if (!validateNumber(screenText)) tvCalcScreen.text = "Erro"
        else {
            var target = screenText.last()
            val lastIndex = screenText.size
            val minus = "-"
            var resultMinusPlus = ""
            if (target.contains("-")) {
                resultMinusPlus = target.replace("-", "")
            }
            else resultMinusPlus = "$minus$target"
            screenText.set(lastIndex-1, resultMinusPlus)
            tvCalcScreen.text = screenText.joinToString( separator = " ")
        }
    }

    private fun validateNumber(screenText:List<String>):Boolean{
        return (screenText.size > 0 && screenText.last().matches("-?\\d+(\\.\\d+)?".toRegex()))
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
    private fun power(split: List<String>): Float? {
        if (split.size < 3) {
            return null;
        } else {
            return split[0].toFloat().pow(split[2].toFloat())

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
            if (expression[1] == "^") result = power(expression)
            if (expression[1] == "log") result = logFun(expression)
            return result
        } else {
            return result
        }
    }
}





