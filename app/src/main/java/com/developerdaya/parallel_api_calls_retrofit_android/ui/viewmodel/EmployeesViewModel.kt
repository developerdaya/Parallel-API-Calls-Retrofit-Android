package com.developerdaya.parallel_api_calls_retrofit_android.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import com.developerdaya.parallel_api_calls_retrofit_android.base.BaseViewModel
import com.developerdaya.parallel_api_calls_retrofit_android.model.EmployeeNameListResp
import com.developerdaya.parallel_api_calls_retrofit_android.model.StudentNameListResp
import io.reactivex.disposables.Disposable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class EmployeesViewModel : BaseViewModel() {
    lateinit var disposable: Disposable
    val getEmployeesResp = MutableLiveData<EmployeeNameListResp>()
    val getStudentResp = MutableLiveData<StudentNameListResp>()
    var errorMessage = MutableLiveData<Throwable>()

    fun getEmployees() {
        disposable = api.getEmployees()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                getEmployeesResp.value = it
            }, {
                errorMessage.value = it
            })
    }

        fun getStudent() {
        disposable = api.getStudent()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                getStudentResp.value = it
            }, {
                errorMessage.value = it
            })
    }




}