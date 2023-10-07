package com.example.learningapps.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import com.example.learningapps.R
import com.example.learningapps.data.DataNumber
import com.example.learningapps.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {


    private lateinit var binding: ActivityMainBinding
    private val mainViewModel by viewModels<MainViewModel>()
    private var value: Int? = null
    private var type: Boolean? = null
    private var first_number = DataNumber(value, type)
    private var second_number = DataNumber(value, type)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setImageNumber()
        setSecondImageNumber()

        binding.btnNumber1.setOnClickListener(this)
        binding.btnSecondNumber1.setOnClickListener(this)
        binding.btnSecondNumber2.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_number_1 -> {
                first_number.value = 1
                showAlertDialog(FIRST_NUMBER)
                mainViewModel.getNumber(first_number, FIRST_NUMBER)
            }

            R.id.btn_second_number_1 -> {
                second_number.value = 1
                showAlertDialog(SECOND_NUMBER)
                mainViewModel.getNumber(second_number, SECOND_NUMBER)
            }

            R.id.btn_second_number_2 -> {
                second_number.value = 2
                showAlertDialog(SECOND_NUMBER)
                mainViewModel.getNumber(second_number, SECOND_NUMBER)
            }

//            R.id.btn_add -> {
//                val result = mainViewModel.AddNumber(first_number.value, second_number.value)
//                Toast.makeText(this, "$result", Toast.LENGTH_SHORT).show()
//            }
        }
    }

    private fun showAlertDialog(type: Int) {
        val dialogTitle = "Pilih jenis bilangan"
        val dialogMessage = "Pilihlah jenis bilangan"
        val alertDialogBuilder = AlertDialog.Builder(this@MainActivity)
        with(alertDialogBuilder) {
            setTitle(dialogTitle)
            setMessage(dialogMessage)
            setCancelable(false)
            setPositiveButton(getString(R.string.positive)) { _, _ ->
                if (type == FIRST_NUMBER){
                    mainViewModel.setNumber(first_number, true)
                    Toast.makeText(this@MainActivity, "${first_number.value}", Toast.LENGTH_SHORT)
                        .show()
                    setImageNumber()
                } else {
                    mainViewModel.setSecondNumber(second_number, true)
                    Toast.makeText(this@MainActivity, "${second_number.value}", Toast.LENGTH_SHORT)
                        .show()
                    setSecondImageNumber()
                }
            }
            setNegativeButton(getString(R.string.negative)) { _, _ ->
                mainViewModel.setNumber(first_number, false)
                mainViewModel.setNumber(second_number, false)
                Toast.makeText(this@MainActivity, "${first_number.value}", Toast.LENGTH_SHORT)
                    .show()
                Toast.makeText(this@MainActivity, "${second_number.value}", Toast.LENGTH_SHORT)
                    .show()
            }
            val alertDialog = alertDialogBuilder.create()
            alertDialog.show()
        }
    }

    private fun setImageNumber() {
        mainViewModel.firstNumber.observe(this) {
            if (it.type == true) {
                binding.ivFirstNumber.setImageDrawable(AppCompatResources.getDrawable(
                    binding.ivFirstNumber.context,
                    R.drawable.baseline_add_24)
                )
            } else {
                binding.ivFirstNumber.setImageDrawable(AppCompatResources.getDrawable(binding.ivFirstNumber.context,R.drawable.baseline_remove_24))
            }
        }
    }

    private fun setSecondImageNumber() {
        mainViewModel.secondNumber.observe(this) {
            if (it.type == true) {
                binding.ivSecondNumber.setImageDrawable(AppCompatResources.getDrawable(
                    binding.ivSecondNumber.context,
                    R.drawable.baseline_add_24)
                )
            } else {
                binding.ivSecondNumber.setImageDrawable(AppCompatResources.getDrawable(binding.ivSecondNumber.context,R.drawable.baseline_remove_24))
            }
        }
    }

    companion object {
        const val FIRST_NUMBER = 1
        const val SECOND_NUMBER = 2
    }
}