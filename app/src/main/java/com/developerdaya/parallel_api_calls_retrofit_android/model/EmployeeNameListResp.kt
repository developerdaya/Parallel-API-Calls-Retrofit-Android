package com.developerdaya.parallel_api_calls_retrofit_android.model


import com.google.gson.annotations.SerializedName

data class EmployeeNameListResp(
    @SerializedName("employees")
    val employees: List<Employee>
) {
    data class Employee(
        @SerializedName("name")
        val name: String,
        @SerializedName("profile")
        val profile: String
    )
}