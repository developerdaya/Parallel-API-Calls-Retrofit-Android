package com.developerdaya.parallel_api_calls_retrofit_android.model


import com.google.gson.annotations.SerializedName

data class StudentNameListResp(
    @SerializedName("Students")
    val students: List<Student>
) {
    data class Student(
        @SerializedName("name")
        val name: String,
        @SerializedName("profile")
        val stream: String
    )
}