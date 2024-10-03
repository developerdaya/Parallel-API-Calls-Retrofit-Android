package com.developerdaya.parallel_api_calls_retrofit_android.ui.view

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.developerdaya.parallel_api_calls_retrofit_android.databinding.ActivityEmployeesBinding
import com.developerdaya.parallel_api_calls_retrofit_android.ui.viewmodel.EmployeesViewModel
import kotlinx.coroutines.*

class EmployeesParallelActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEmployeesBinding
    private lateinit var viewModel: EmployeesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmployeesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[EmployeesViewModel::class.java]

        CoroutineScope(Dispatchers.IO).launch {

            withContext(Dispatchers.Main)
            {
                object :CountDownTimer(15000,1000){
                    override fun onTick(millisUntilFinished: Long) {
                        println("timer called: ${millisUntilFinished / 1000}")
                    }

                    override fun onFinish() {

                    }

                }
            }.start()

                val firstDeferred = async {
                    delay(10000) // 2 seconds delay
                    "called 1st method"
                }


                val secondDeferred = async {
                    delay(4000) // 3 seconds delay

                    "called 2nd method"
                }
               val result1 = firstDeferred.await()
                 println(result1)
               val result2 = secondDeferred.await()
                println(result2)

        }



     /*   observeData(startTime)*/
    }

    // Observer for LiveData responses from the ViewModel
    private fun observeData(startTime: Long) {
        var employeeResponseReceived = false
        var studentResponseReceived = false

        // Observe Employees Response
        viewModel.getEmployeesResp.observe(this) { employeesResponse ->
            employeeResponseReceived = true
            binding.mData.text = employeesResponse.employees.toString() // Ensure that 'employees' is a valid field
            checkIfAllResponsesReceived(startTime, employeeResponseReceived, studentResponseReceived)
        }

        // Observe Students Response
        viewModel.getStudentResp.observe(this) { studentResponse ->
            studentResponseReceived = true
            binding.mData2.text = studentResponse.students.toString() // Ensure that 'students' is a valid field
            checkIfAllResponsesReceived(startTime, employeeResponseReceived, studentResponseReceived)
        }

        // Observe Error Message
        viewModel.errorMessage.observe(this) {
            Log.d("##############", "observer: $it")
        }
    }

    // Function to check if both API responses have been received
    private fun checkIfAllResponsesReceived(startTime: Long, employeeReceived: Boolean, studentReceived: Boolean) {
        if (employeeReceived && studentReceived) {
            val endTime = System.currentTimeMillis()
            val duration = (endTime - startTime)
            binding.statusName.text = "Total time taken: $duration mili seconds"
        }
    }
}
