package com.developerdaya.parallel_api_calls_retrofit_android.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.developerdaya.parallel_api_calls_retrofit_android.databinding.ItemEmployeeBinding
import com.developerdaya.parallel_api_calls_retrofit_android.model.CommonModel
import com.developerdaya.parallel_api_calls_retrofit_android.model.EmployeeNameListResp

class EmployeeAdapter(val employees: ArrayList<CommonModel.Employee>) :
    RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        val binding = ItemEmployeeBinding.inflate(inflater, parent, false)
        return EmployeeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
       holder.bind(employees[position])
    }

    override fun getItemCount(): Int = employees.size

    class EmployeeViewHolder(var binding: ItemEmployeeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(employee: CommonModel.Employee) {
            binding.textName.text = employee.name
            binding.textProfile.text = employee.profile
        }
    }
}
