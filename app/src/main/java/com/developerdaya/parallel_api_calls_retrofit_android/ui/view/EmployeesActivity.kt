package com.developerdaya.parallel_api_calls_retrofit_android.ui.view
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.developerdaya.parallel_api_calls_retrofit_android.databinding.ActivityEmployeesBinding
import com.developerdaya.parallel_api_calls_retrofit_android.model.CommonModel
import com.developerdaya.parallel_api_calls_retrofit_android.ui.viewmodel.EmployeesViewModel

class EmployeesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEmployeesBinding
    private lateinit var viewModel: EmployeesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmployeesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[EmployeesViewModel::class.java]
        val startTime = System.currentTimeMillis()
        sequeneAPICall()
        observer(startTime)
    }

    private fun sequeneAPICall() {
        viewModel.getEmployees()
        viewModel.getStudent()
    }

    private fun observer(startTime: Long) {
        var employeeResponseReceived = false
        var studentResponseReceived = false
       viewModel.getEmployeesResp.observe(this) { employeesResponse ->
            employeeResponseReceived = true
            binding.mData.text = employeesResponse.employees.toString()
            checkIfAllResponsesReceived(startTime, employeeResponseReceived, studentResponseReceived)
        }

        viewModel.getStudentResp.observe(this) { studentResponse ->
            studentResponseReceived = true
            binding.mData2.text = studentResponse.students.toString()
            checkIfAllResponsesReceived(startTime, employeeResponseReceived, studentResponseReceived)
        }
        viewModel.errorMessage.observe(this)
        {
            Log.d("##############", "observer: $it")
        }
    }

    private fun checkIfAllResponsesReceived(startTime: Long, employeeReceived: Boolean, studentReceived: Boolean) {
        if (employeeReceived && studentReceived)
        {
            val endTime = System.currentTimeMillis()
            val duration = (endTime - startTime)
          //  binding.rvEmployelist.adapter = EmployeeAdapter(arrList)
            binding.statusName.text= "Total time taken: $duration mili second"
        }
    }
}
