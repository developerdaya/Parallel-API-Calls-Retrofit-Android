package com.developerdaya.parallel_api_calls_retrofit_android.network

import com.developerdaya.parallel_api_calls_retrofit_android.model.EmployeeNameListResp
import com.developerdaya.parallel_api_calls_retrofit_android.model.StudentNameListResp
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiInterface {

    // EmployeeEndUrl
    @GET("3fafcc1b-3b16-4b44-93ff-039990d96720")
    fun getEmployees(): Observable<EmployeeNameListResp>


 // StudentEndUrl
    @GET("2499d7ca-874f-43c7-ad48-5fce6c6f4ef5")
    fun getStudent(): Observable<StudentNameListResp>




}