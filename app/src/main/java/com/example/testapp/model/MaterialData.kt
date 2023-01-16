package com.example.testapp.model

import com.google.gson.annotations.SerializedName

sealed class MaterialData{
        data class MaterialItem(
            @SerializedName("name")
            var name: String,
            @SerializedName("group")
            var group: String
            ): MaterialData(){
            val id = name
        }
        data class GroupItem(
            var name: String,
        ): MaterialData(){
            val id = name
        }
}
