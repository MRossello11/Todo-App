package com.example.testapp.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.R
import com.example.testapp.model.MaterialData
import com.example.testapp.views.CustomViewHolder
import com.example.testapp.views.GroupViewHolder
import com.example.testapp.views.MaterialViewHolder

class MaterialDataAdapter(
    var dataList: List<MaterialData>
): RecyclerView.Adapter<CustomViewHolder>() {

    companion object{
        const val TAG = "MaterialDataAdapter"
        val VIEW_GROUP = R.layout.row_group
        val VIEW_ITEM = R.layout.row_material
    }
    override fun getItemViewType(position: Int): Int {
        return if (dataList[position] is MaterialData.GroupItem){
            VIEW_GROUP
        } else {
            VIEW_ITEM
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return if (viewType == VIEW_GROUP){
            GroupViewHolder(LayoutInflater.from(parent.context).inflate(VIEW_GROUP, parent, false))
        } else {
            MaterialViewHolder(LayoutInflater.from(parent.context).inflate(VIEW_ITEM, parent, false))
        }
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val item = dataList[position]
        when (holder) {
            is GroupViewHolder -> {
                holder.bind(item as MaterialData.GroupItem)
            }
            is MaterialViewHolder -> {
                holder.bind(item as MaterialData.MaterialItem)
            }
            else -> {
                throw ClassNotFoundException("Class not found")
            }
        }
    }

    override fun getItemCount() = dataList.size

    fun setData(list: MutableList<MaterialData>){
        this.dataList = list
        notifyDataSetChanged()
    }
}
