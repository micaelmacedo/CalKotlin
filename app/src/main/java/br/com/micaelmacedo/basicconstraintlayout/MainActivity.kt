package br.com.micaelmacedo.basicconstraintlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import br.com.micaelmacedo.basicconstraintlayout.R
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvOne.setOnClickListener {
            tv ->
            showNumber(tv as TextView)
        }
        tvTwo.setOnClickListener {
            tv ->
            showNumber(tv as TextView)
        }
        tvThree.setOnClickListener {
            tv ->
            showNumber(tv as TextView)
        }
        tvFour.setOnClickListener {
            tv ->
            showNumber(tv as TextView)
        }
        tvFive.setOnClickListener {
            tv ->
            showNumber(tv as TextView)
        }
        tvSix.setOnClickListener { tv ->
            showNumber(tv as TextView)}
        tvSeven.setOnClickListener { tv ->
            showNumber(tv as TextView)}
        tvEight.setOnClickListener { tv ->
            showNumber(tv as TextView)}
        tvNine.setOnClickListener { tv ->
            showNumber(tv as TextView)}
        tvZero.setOnClickListener { tv ->
            showNumber(tv as TextView)}

    }

    private fun showNumber(v:TextView){

        tvCalcScreen.append(v.text)
    }

}