package com.example.testapp.views

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.R
import com.example.testapp.model.MaterialData
import com.skyfishjy.library.RippleBackground
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

open class CustomViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
class MaterialViewHolder(itemView: View): CustomViewHolder(itemView){
    val tvMaterialName: TextView = itemView.findViewById(R.id.tvMaterialName)

    fun bind(data: MaterialData.MaterialItem){
        tvMaterialName.text = data.name
    }
}
class GroupViewHolder(itemView: View): CustomViewHolder(itemView){
    val tvGroupName: TextView = itemView.findViewById(R.id.tvGroupName)
    val clGroup: View = itemView.findViewById(R.id.clGroup)
    val ripple: RippleBackground = itemView.findViewById(R.id.ripple)

    fun bind(data: MaterialData.GroupItem){
        tvGroupName.text = data.name

        clGroup.setOnClickListener {
            ripple.startRippleAnimation()
        }
    }
}