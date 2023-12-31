package com.example.learningapps.ui

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import com.example.learningapps.R
import com.example.learningapps.data.DataNumber
import com.example.learningapps.databinding.ActivityMainBinding
import kotlin.math.abs

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val imagePositiveMap = mapOf(
        0 to R.drawable.baseline_remove_24,
        1 to R.drawable.tanda_01,
        2 to R.drawable.tanda_02,
        3 to R.drawable.tanda_03,
        4 to R.drawable.tanda_04,
        5 to R.drawable.tanda_05,
        6 to R.drawable.tanda_06,
        7 to R.drawable.tanda_07,
        8 to R.drawable.tanda_08,
        9 to R.drawable.tanda_09,
        10 to R.drawable.tanda_37,
        11 to R.drawable.tanda_38,
        12 to R.drawable.tanda_39,
        13 to R.drawable.tanda_40,
        14 to R.drawable.tanda_41,
        15 to R.drawable.tanda_42,
        16 to R.drawable.tanda_43,
        17 to R.drawable.tanda_44,
        18 to R.drawable.tanda_45

    )

    private val imageNegativeMap = mapOf(
        0 to R.drawable.baseline_remove_24,
        1 to R.drawable.tanda_10,
        2 to R.drawable.tanda_11,
        3 to R.drawable.tanda_12,
        4 to R.drawable.tanda_13,
        5 to R.drawable.tanda_14,
        6 to R.drawable.tanda_15,
        7 to R.drawable.tanda_16,
        8 to R.drawable.tanda_17,
        9 to R.drawable.tanda_18,
        10 to R.drawable.tanda_28,
        11 to R.drawable.tanda_29,
        12 to R.drawable.tanda_30,
        13 to R.drawable.tanda_31,
        14 to R.drawable.tanda_32,
        15 to R.drawable.tanda_33,
        16 to R.drawable.tanda_34,
        17 to R.drawable.tanda_35,
        18 to R.drawable.tanda_36,


    )

    private val imageNetralMap = mapOf(
        0 to R.drawable.baseline_remove_24,
        1 to R.drawable.tanda_19,
        2 to R.drawable.tanda_20,
        3 to R.drawable.tanda_21,
        4 to R.drawable.tanda_22,
        5 to R.drawable.tanda_23,
        6 to R.drawable.tanda_24,
        7 to R.drawable.tanda_25,
        8 to R.drawable.tanda_26,
        9 to R.drawable.tanda_27,
    )

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel by viewModels<MainViewModel>()
    private var value: Int? = null
    private var type: Boolean? = null
    private var firstNumber = DataNumber(value, type)
    private var secondNumber = DataNumber(value, type)
    private var isAdd: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()

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

        binding.ivMinus.setOnClickListener {
            isAdd = false
        }

        binding.ivAdd.setOnClickListener {
            isAdd = true
        }

        setImageNumber()
        setSecondImageNumber()


        binding.btnCount.setOnClickListener {
            if (firstNumber.value == null) {
                Toast.makeText(this, "input Manik Pertama!", Toast.LENGTH_SHORT).show()
            } else if (secondNumber.value == null){
                Toast.makeText(this, "input Manik Kedua!", Toast.LENGTH_SHORT).show()
            } else {
                setCals(isAdd)
                finalResult(isAdd)
                restCals(firstNumber.value!!, secondNumber.value!!)
            }

        }



        binding.btnReset.setOnClickListener {
            finish()
            startActivity(intent)
        }
    }

    override fun onClick(v: View) {
        firstNumber.type = false
        secondNumber.type = false
        when (v.id) {
            R.id.iv_number_1 -> {
                firstNumber.value = 1
                showAlertDialog(FIRST_NUMBER)
                mainViewModel.getNumber(firstNumber, FIRST_NUMBER)
            }

            R.id.iv_number_2 -> {
                firstNumber.value = 2
                showAlertDialog(FIRST_NUMBER)
                mainViewModel.getNumber(firstNumber, FIRST_NUMBER)
            }

            R.id.iv_number_3 -> {
                firstNumber.value = 3
                showAlertDialog(FIRST_NUMBER)
                mainViewModel.getNumber(firstNumber, FIRST_NUMBER)
            }

            R.id.iv_number_4 -> {
                firstNumber.value = 4
                showAlertDialog(FIRST_NUMBER)
                mainViewModel.getNumber(firstNumber, FIRST_NUMBER)
            }

            R.id.iv_number_5 -> {
                firstNumber.value = 5
                showAlertDialog(FIRST_NUMBER)
                mainViewModel.getNumber(firstNumber, FIRST_NUMBER)
            }

            R.id.iv_number_6 -> {
                firstNumber.value = 7
                showAlertDialog(FIRST_NUMBER)
                mainViewModel.getNumber(firstNumber, FIRST_NUMBER)
            }

            R.id.iv_number_7 -> {
                firstNumber.value = 7
                showAlertDialog(FIRST_NUMBER)
                mainViewModel.getNumber(firstNumber, FIRST_NUMBER)
            }

            R.id.iv_number_8 -> {
                firstNumber.value = 8
                showAlertDialog(FIRST_NUMBER)
                mainViewModel.getNumber(firstNumber, FIRST_NUMBER)
            }

            R.id.iv_number_9 -> {
                firstNumber.value = 9
                showAlertDialog(FIRST_NUMBER)
                mainViewModel.getNumber(firstNumber, FIRST_NUMBER)
            }

            R.id.iv_second_number_1 -> {
                secondNumber.value = 1
                showAlertDialog(SECOND_NUMBER)
                mainViewModel.getNumber(secondNumber, SECOND_NUMBER)
            }

            R.id.iv_second_number_2 -> {
                secondNumber.value = 2
                showAlertDialog(SECOND_NUMBER)
                mainViewModel.getNumber(secondNumber, SECOND_NUMBER)
            }

            R.id.iv_second_number_3 -> {
                secondNumber.value = 3
                showAlertDialog(SECOND_NUMBER)
                mainViewModel.getNumber(secondNumber, SECOND_NUMBER)
            }

            R.id.iv_second_number_4 -> {
                secondNumber.value = 4
                showAlertDialog(SECOND_NUMBER)
                mainViewModel.getNumber(secondNumber, SECOND_NUMBER)
            }

            R.id.iv_second_number_5 -> {
                secondNumber.value = 5
                showAlertDialog(SECOND_NUMBER)
                mainViewModel.getNumber(secondNumber, SECOND_NUMBER)
            }

            R.id.iv_second_number_6 -> {
                secondNumber.value = 7
                showAlertDialog(SECOND_NUMBER)
                mainViewModel.getNumber(secondNumber, SECOND_NUMBER)
            }

            R.id.iv_second_number_7 -> {
                secondNumber.value = 7
                showAlertDialog(SECOND_NUMBER)
                mainViewModel.getNumber(secondNumber, SECOND_NUMBER)
            }

            R.id.iv__second_number_8 -> {
                secondNumber.value = 8
                showAlertDialog(SECOND_NUMBER)
                mainViewModel.getNumber(secondNumber, SECOND_NUMBER)
            }

            R.id.iv_second_number_9 -> {
                secondNumber.value = 9
                showAlertDialog(SECOND_NUMBER)
                mainViewModel.getNumber(secondNumber, SECOND_NUMBER)
            }
        }
    }

    private fun showAlertDialog(type: Int) {
        val alertDialogBuilder = AlertDialog.Builder(this@MainActivity).create()
        val view = layoutInflater.inflate(R.layout.choose_layout, null)
        alertDialogBuilder.setView(view)
        val btnPositive = view.findViewById<Button>(R.id.btn_plus)
        val btnNegative = view.findViewById<Button>(R.id.btn_minus)
        alertDialogBuilder.setCanceledOnTouchOutside(false)
        btnPositive.setOnClickListener {
            if (type == FIRST_NUMBER) {
                mainViewModel.setNumber(firstNumber, true)
                Toast.makeText(this@MainActivity, "${firstNumber.value}", Toast.LENGTH_SHORT)
                    .show()
                setImageNumber()
            } else {
                mainViewModel.setSecondNumber(secondNumber, true)
                Toast.makeText(this@MainActivity, "${secondNumber.value}", Toast.LENGTH_SHORT)
                    .show()
                setSecondImageNumber()
            }
            alertDialogBuilder.dismiss()
        }
        btnNegative.setOnClickListener {
            if (type == FIRST_NUMBER) {
                mainViewModel.setNumber(firstNumber, false)
                Toast.makeText(this@MainActivity, "${firstNumber.value}", Toast.LENGTH_SHORT)
                    .show()
                setImageNumber()
            } else {
                mainViewModel.setSecondNumber(secondNumber, false)
                Toast.makeText(this@MainActivity, "${secondNumber.value}", Toast.LENGTH_SHORT)
                    .show()
                setSecondImageNumber()
            }
            alertDialogBuilder.dismiss()
        }
        alertDialogBuilder.show()
    }

    private fun setImageNumber() {
        val posKey = imagePositiveMap.keys
        val negKey = imageNegativeMap.keys
        mainViewModel.firstNumber.observe(this) {
            if (it.type == true) {
                for (k in posKey) {
                    if (k == it.value) {
                        binding.ivFirstNumber.setImageDrawable(
                            AppCompatResources.getDrawable(
                                binding.ivFirstNumber.context,
                                imagePositiveMap.getValue(k)
                            )
                        )
                    }
                }
            } else {
                for (k in negKey) {
                    if (k == it.value) {
                        binding.ivFirstNumber.setImageDrawable(
                            AppCompatResources.getDrawable(
                                binding.ivFirstNumber.context,
                                imageNegativeMap.getValue(k)
                            )
                        )
                    }
                }
            }
        }
    }

    private fun setSecondImageNumber() {
        val posKey = imagePositiveMap.keys
        val negKey = imageNegativeMap.keys
        mainViewModel.secondNumber.observe(this) {
            if (it.type == true) {
                for (k in posKey) {
                    if (k == it.value) {
                        binding.ivSecondNumber.setImageDrawable(
                            AppCompatResources.getDrawable(
                                binding.ivSecondNumber.context,
                                imagePositiveMap.getValue(k)
                            )
                        )
                    }
                }
            } else if (it.type == false) {
                for (k in negKey) {
                    if (k == it.value) {
                        binding.ivSecondNumber.setImageDrawable(
                            AppCompatResources.getDrawable(
                                binding.ivSecondNumber.context,
                                imageNegativeMap.getValue(k)
                            )
                        )
                    }
                }
            }
        }
    }

    private fun setImageResultList(result: Int) {
        val imageResult: Int
        val key = imagePositiveMap.keys
        val keySecond = imageNegativeMap.keys
        if (result > 0) {
            imageResult = abs(result)
            for (k in key) {
                if (imageResult == k) {
                    binding.ivResult.setImageDrawable(
                        AppCompatResources.getDrawable(
                            binding.ivResult.context,
                            imagePositiveMap.getValue(imageResult)
                        )
                    )
                }
            }
        } else if (result < 0) {
            imageResult = abs(result)
            for (k in keySecond) {
                if (imageResult == k) {
                    binding.ivResult.setImageDrawable(
                        AppCompatResources.getDrawable(
                            binding.ivResult.context,
                            imageNegativeMap.getValue(imageResult)
                        )
                    )
                }
            }
        } else {
            binding.ivResult.setImageDrawable(
                AppCompatResources.getDrawable(
                    binding.ivResult.context,
                    imageNegativeMap.getValue(0)
                )
            )

        }
    }


    private fun restCals(firstNumber: Int, secondNumber: Int) {
        if (firstNumber > 0 && secondNumber > 0) {
            binding.ivRest.setImageDrawable(
                AppCompatResources.getDrawable(
                    binding.ivResult.context,
                    imageNegativeMap.getValue(0)
                )
            )
        }
        else if (firstNumber < 0 && secondNumber < 0 ){
            binding.ivRest.setImageDrawable(
               AppCompatResources.getDrawable(
                    binding.ivResult.context,
                   imageNegativeMap.getValue(0)
                )
            )
        }
        else {
            val firstRest = abs(firstNumber)
            val secondRest = abs(secondNumber)
            val key = imageNetralMap.keys
            if (firstRest < secondRest) {
                for (k in key) {
                    if (firstRest == k) {
                        binding.ivRest.setImageDrawable(
                            AppCompatResources.getDrawable(
                                binding.ivResult.context,
                                imageNetralMap.getValue(firstRest)
                            )
                        )
                    }
                }
            } else if (secondRest < firstRest) {
                for (k in key) {
                    if (secondRest == k) {
                        binding.ivRest.setImageDrawable(
                            AppCompatResources.getDrawable(
                                binding.ivResult.context,
                                imageNetralMap.getValue(secondRest)
                            )
                        )
                    }
                }
            } else {
                for (k in key){
                    binding.ivRest.setImageDrawable(
                        AppCompatResources.getDrawable(
                            binding.ivResult.context,
                            imageNetralMap.getValue(firstRest)
                        )
                    )
                }

            }
        }

    }

    private fun setCals(isAdd: Boolean) {
        if (isAdd) {
            binding.tvCals.text = "${firstNumber.value} + ${secondNumber.value} ="
        } else {
            binding.tvCals.text = "${firstNumber.value} - ${secondNumber.value} ="
        }

    }

    private fun finalResult(isAdd: Boolean) {
        val result: Int
        if (isAdd) {
            result = mainViewModel.add(firstNumber.value, secondNumber.value)
            setImageResultList(result)
        } else {
            result = mainViewModel.minus(firstNumber.value!!, secondNumber.value!!)
            setImageResultList(result)
        }
        binding.tvFinalResult.text = "$result"
    }

    private fun setupView() {
        @Suppress("DEPRECATION")
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        supportActionBar?.hide()
    }

    companion object {
        const val FIRST_NUMBER = 1
        const val SECOND_NUMBER = 2
    }
}