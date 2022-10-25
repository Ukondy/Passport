package com.example.passport.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.passport.databinding.ActivityMainBinding
import com.example.passport.databinding.PassItemBinding
import com.example.passport.model.PassItem
import com.example.passport.model.PassItemDao

class PassAdapter constructor(
    private var listPass: List<PassItem>
): RecyclerView.Adapter<PassAdapter.ViewHolder>()
{




    inner class ViewHolder constructor(var bindingPass: PassItemBinding): RecyclerView.ViewHolder(bindingPass.root){
        fun add(passItem: PassItem) {
            bindingPass.textPass.text = passItem.namePass.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(PassItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.add(listPass[position])
    }

    override fun getItemCount(): Int {
        return listPass.size
    }
}