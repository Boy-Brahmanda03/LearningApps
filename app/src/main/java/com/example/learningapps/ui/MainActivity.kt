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

        binding.ivNumber1.setOnClickListener(this)
        binding.ivNumber2.setOnClickListener(this)
        binding.ivNumber3.setOnClickListener(this)
        binding.ivNumber4.setOnClickListener(this)
        binding.ivNumber5.setOnClickListener(this)
        binding.ivNumber6.setOnClickListener(this)
        binding.ivNumber7.setOnClickListener(this)
        binding.ivNumber8.setOnClickListener(this)
        binding.ivNumber9.setOnClickListener(this)

        binding.ivSecondNumber1.setOnClickListener(this)
        binding.ivSecondNumber2.setOnClickListener(this)
        binding.ivSecondNumber3.setOnClickListener(this)
        binding.ivSecondNumber4.setOnClickListener(this)
        binding.ivSecondNumber5.setOnClickListener(this)
        binding.ivSecondNumber6.setOnClickListener(this)
        binding.ivSecondNumber7.setOnClickListener(this)
        binding.ivSecondNumber8.setOnClickListener(this)
        binding.ivSecondNumber9.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.iv_number_1 -> {
                first_number.value = 1
                showAlertDialog(FIRST_NUMBER)
                mainViewModel.getNumber(first_number, FIRST_NUMBER)
            }

            R.id.iv_number_2 -> {
                first_number.value = 2
                showAlertDialog(FIRST_NUMBER)
                mainViewModel.getNumber(first_number, FIRST_NUMBER)
            }

            R.id.iv_number_3 -> {
                first_number.value = 3
                showAlertDialog(FIRST_NUMBER)
                mainViewModel.getNumber(first_number, FIRST_NUMBER)
            }

            R.id.iv_number_4 -> {
                first_number.value = 4
                showAlertDialog(FIRST_NUMBER)
                mainViewModel.getNumber(first_number, FIRST_NUMBER)
            }

            R.id.iv_number_5 -> {
                first_number.value = 5
                showAlertDialog(FIRST_NUMBER)
                mainViewModel.getNumber(first_number, FIRST_NUMBER)
            }

            R.id.iv_number_6 -> {
                first_number.value = 7
                showAlertDialog(FIRST_NUMBER)
                mainViewModel.getNumber(first_number, FIRST_NUMBER)
            }

            R.id.iv_number_7 -> {
                first_number.value = 7
                showAlertDialog(FIRST_NUMBER)
                mainViewModel.getNumber(first_number, FIRST_NUMBER)
            }

            R.id.iv_number_8 -> {
                first_number.value = 8
                showAlertDialog(FIRST_NUMBER)
                mainViewModel.getNumber(first_number, FIRST_NUMBER)
            }

            R.id.iv_number_9 -> {
                first_number.value = 9
                showAlertDialog(FIRST_NUMBER)
                mainViewModel.getNumber(first_number, FIRST_NUMBER)
            }

            R.id.iv_second_number_1 -> {
                second_number.value = 1
                showAlertDialog(SECOND_NUMBER)
                mainViewModel.getNumber(second_number, SECOND_NUMBER)
            }

            R.id.iv_second_number_2 -> {
                second_number.value = 2
                showAlertDialog(SECOND_NUMBER)
                mainViewModel.getNumber(second_number, SECOND_NUMBER)
            }

            R.id.iv_second_number_3 -> {
                second_number.value = 3
                showAlertDialog(SECOND_NUMBER)
                mainViewModel.getNumber(second_number, SECOND_NUMBER)
            }

            R.id.iv_second_number_4 -> {
                second_number.value = 4
                showAlertDialog(SECOND_NUMBER)
                mainViewModel.getNumber(second_number, SECOND_NUMBER)
            }

            R.id.iv_second_number_5 -> {
                second_number.value = 5
                showAlertDialog(SECOND_NUMBER)
                mainViewModel.getNumber(second_number, SECOND_NUMBER)
            }

            R.id.iv_second_number_6 -> {
                second_number.value = 7
                showAlertDialog(SECOND_NUMBER)
                mainViewModel.getNumber(second_number, SECOND_NUMBER)
            }

            R.id.iv_second_number_7 -> {
                second_number.value = 7
                showAlertDialog(SECOND_NUMBER)
                mainViewModel.getNumber(second_number, SECOND_NUMBER)
            }

            R.id.iv__second_number_8 -> {
                second_number.value = 8
                showAlertDialog(SECOND_NUMBER)
                mainViewModel.getNumber(second_number, SECOND_NUMBER)
            }

            R.id.iv_second_number_9 -> {
                second_number.value = 9
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