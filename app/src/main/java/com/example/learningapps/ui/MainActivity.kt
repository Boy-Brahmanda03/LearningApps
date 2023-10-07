package com.example.learningapps.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.learningapps.R
import com.example.learningapps.data.DataNumber
import com.example.learningapps.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {


    private lateinit var binding: ActivityMainBinding
    private val mainViewModel by viewModels<MainViewModel>()
    private var value: Int? = null
    private var type: Boolean? = null
    private var number = DataNumber(value, type)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setImageNumber()

        binding.btnNumber1.setOnClickListener(this)
        binding.btnSecondNumber1.setOnClickListener(this)
        binding.btnSecondNumber2.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_number_1 -> {
                number.value = 1
                showAlertDialog()
                mainViewModel.getNumber(number)
            }


            R.id.btn_second_number_1 -> {
                number.value = 1
                showAlertDialogSecond()
                mainViewModel.getNumber(number)
            }

            R.id.btn_second_number_2 -> {
                number.value = 2
                showAlertDialogSecond()
                mainViewModel.getNumber(number)
            }
        }
    }

    private fun showAlertDialog() {
        val dialogTitle = "Pilih jenis bilangan"
        val dialogMessage = "Pilihlah jenis bilangan"
        val alertDialogBuilder = AlertDialog.Builder(this@MainActivity)
        with(alertDialogBuilder) {
            setTitle(dialogTitle)
            setMessage(dialogMessage)
            setCancelable(false)
            setPositiveButton(getString(R.string.positive)) { _, _ ->
                number.type = true
                Toast.makeText(this@MainActivity, "${number.value}", Toast.LENGTH_SHORT).show()
                setImageNumber()
            }
            setNegativeButton(getString(R.string.negative)) { _, _ ->
                number.type = false
                number.value = -1
                Toast.makeText(this@MainActivity, "${number.value}", Toast.LENGTH_SHORT).show()
                setImageNumber()
            }
            val alertDialog = alertDialogBuilder.create()
            alertDialog.show()
        }
    }

    private fun showAlertDialogSecond() {
        val dialogTitle = "Pilih jenis bilangan"
        val dialogMessage = "Pilihlah jenis bilangan"
        val alertDialogBuilder = AlertDialog.Builder(this@MainActivity)
        with(alertDialogBuilder) {
            setTitle(dialogTitle)
            setMessage(dialogMessage)
            setCancelable(false)
            setPositiveButton(getString(R.string.positive)) { _, _ ->
                number.type = true
                Toast.makeText(this@MainActivity, "${number.value}", Toast.LENGTH_SHORT).show()
                setImageNumberSecond()
            }
            setNegativeButton(getString(R.string.negative)) { _, _ ->
                number.type = false
                number.value = -Math.abs(number.value!!)
                Toast.makeText(this@MainActivity, "${number.value}", Toast.LENGTH_SHORT).show()
                setImageNumberSecond()
            }
            val alertDialog = alertDialogBuilder.create()
            alertDialog.show()
        }
    }

    private fun setImageNumber(){
        mainViewModel.numberData.observe(this){
            if (it.type == true){
                binding.ivFirstNumber.setImageDrawable(getDrawable(R.drawable.baseline_add_24))
            } else {
                binding.ivFirstNumber.setImageDrawable(getDrawable(R.drawable.baseline_remove_24))
            }
        }
    }

    private fun setImageNumberSecond(){
        mainViewModel.numberData.observe(this){
            if (it.type == true){
                binding.ivSecondNumber.setImageDrawable(getDrawable(R.drawable.baseline_add_24))
            } else {
                binding.ivSecondNumber.setImageDrawable(getDrawable(R.drawable.baseline_remove_24))
            }
        }
    }
}