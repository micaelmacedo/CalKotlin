package br.com.micaelmacedo.basicconstraintlayout

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Números
        tvOne.setOnClickListener { tv ->showChar(tv as TextView) }
        tvTwo.setOnClickListener { tv ->showChar(tv as TextView) }
        tvThree.setOnClickListener { tv ->showChar(tv as TextView) }
        tvFour.setOnClickListener { tv ->showChar(tv as TextView) }
        tvFive.setOnClickListener { tv ->showChar(tv as TextView) }
        tvSix.setOnClickListener { tv ->showChar(tv as TextView) }
        tvSeven.setOnClickListener { tv -> showChar(tv as TextView) }
        tvEight.setOnClickListener { tv -> showChar(tv as TextView) }
        tvNine.setOnClickListener { tv -> showChar(tv as TextView) }
        tvZero.setOnClickListener { tv -> showChar(tv as TextView) }

        //Funções com dois componentes
        tvSum.setOnClickListener{
            var tv = it as TextView;
            var result = sum(tvCalcScreen as TextView)
            if (result.toString() != "null") {
                showResult(result.toString())
            } else {
                putSpace(tv)
                showChar(tv)
                putSpace(tv)
            }
        }

        tvSubtr.setOnClickListener{tv->
            var result = subtr(tv as TextView)
            if (result.toString() != "null") {
                showResult(result.toString())
            } else {
                putSpace(tv)
                showChar(tv)
                putSpace(tv)
            }
        }

        //Operação da calculadora
        tvClean.setOnClickListener{tv -> cleanScreen(tv as TextView)}

        tvResult.setOnClickListener{tv ->
            appendHistory(tv as TextView)
            calculate(tv)
        }

        //Funções com um componente
    }

    private fun showChar(v:TextView){
        tvCalcScreen.append(v.text)
    }

    private fun showResult(result:CharSequence){
        tvCalcScreen.text = result
    }

    private fun putSpace(v:TextView){
        tvCalcScreen.append(" ")
    }

    private fun cleanScreen(v:TextView){
        tvCalcScreen.text = "";
    }

    private fun appendHistory(v:TextView){
        var operation = tvCalcScreen.text;
        operation = "$operation\n";
        tvCalcHistory.append(operation);

    }

    private fun calculate(v:TextView){
        var operation = tvCalcScreen.text.toString();
        showResult("faz esse troço funcionar");
    }

    private fun splitExpression(expression:String):List<String>{
        var split = expression.split(" ");
        return split
    }

    private fun sum(v:TextView):Float?{
        var split = splitExpression(v.text.toString())
        if(split.size<3) {
            return null
        } else {
            var res = split[0].toFloat()+split[2].toFloat();
            return res;
        }
    }

    private fun subtr(v:TextView):Float?{
        var split = splitExpression(v.text.toString())
        if(split.size<3) {
            return null;
        } else {
            var res = split[0].toFloat()-split[2].toFloat();
            return res;
        }
    }

    private fun multi(v:TextView):Float?{
        var split = splitExpression(v.text.toString())
        if(split.size==3) {
            return null;
        } else {
            var res = split[0].toFloat()*split[2].toFloat();
            return res;
        }
    }

    private fun division(v:TextView):Float?{
        var split = splitExpression(v.text.toString())
        if(split.size==3) {
            return null;
        } else {
            var res = split[0].toFloat()/split[2].toFloat();
            return res;
        }
    }





}