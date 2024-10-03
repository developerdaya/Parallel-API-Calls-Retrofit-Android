package com.developerdaya.parallel_api_calls_retrofit_android.base

import androidx.lifecycle.ViewModel
import com.developerdaya.parallel_api_calls_retrofit_android.network.ApiInterface
import com.developerdaya.parallel_api_calls_retrofit_android.network.RetrofitUtil

abstract class BaseViewModel : ViewModel() {
    val api: ApiInterface by lazy {
        RetrofitUtil.createBaseApiService()
    }
}
