package com.example.testapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.testapp.MaterialRepo.Companion.getMaterialsData
import com.example.testapp.model.MaterialData

class MaterialViewModel(application: Application): AndroidViewModel(application) {
//    private var _groupList = MutableLiveData<MutableList<Group>>()
//    val groupList: MutableLiveData<MutableList<Group>>
//        get() = _groupList

//    private var _materialList = ArrayList<Material>()
//    val materialList: ArrayList<Material>
//        get() = _materialList

    // list to display
    private var _dataList = MutableLiveData<MutableList<MaterialData>>()
    val dataList: MutableLiveData<MutableList<MaterialData>>
        get() = _dataList

    // map to filter and store data
    private var _dataMap = mutableMapOf<String, List<MaterialData.MaterialItem>>()
    val dataMap: MutableMap<String, List<MaterialData.MaterialItem>>
        get() = _dataMap

    private lateinit var _actualItem: MaterialData.MaterialItem

    fun loadData(){
        /*val materials = getMaterials()
        val materialDataList = mutableListOf<MaterialData.MaterialItem>()
        for (i in materials){
            materialDataList.add(MaterialData.MaterialItem(i))
        }*/
        getHeaders(getMaterialsData())
//        _groupList.postValue(getGroups(getMaterials()))
    }

    /*private fun getGroups(materials: MutableList<Material>):MutableList<SimpleGroup>{
        var groups = mutableListOf<SimpleGroup>()
        var groupNames = mutableListOf<String>()

        for (material in materials){
            if (!groupNames.contains(material.group)){ groupNames.add(material.group)
                groups.add(SimpleGroup(name = material.group))

            }
        }

        return groups
    }*/

    fun getHeaders(materials: MutableList<MaterialData.MaterialItem>){
        val materialMap: MutableMap<String, List<MaterialData.MaterialItem>> = materials.groupBy { it.group }.toMutableMap()

        val materialList = mutableListOf<MaterialData>()
        for (i in materialMap.keys){
            // add header
            materialList.add(MaterialData.GroupItem(i))
            // add materials
            materialList.addAll(materialMap.getValue(i))
        }
        _dataMap = materialMap
        _dataList.postValue(materialList)
    }

    fun getMaterialDataFiltered(query: String): MutableList<MaterialData>{
        val filteredList = mutableListOf<MaterialData>()
        for(key in _dataMap.keys){
            val filteredMaterials = mutableListOf<MaterialData.MaterialItem>()
            for (material in _dataMap.getValue(key)){
                if (material.id.lowercase().contains(query)){
                    filteredMaterials.add(material)
                }

            }
            if (filteredMaterials.size >0){
                filteredList.add(MaterialData.GroupItem(key))
                filteredList.addAll(filteredMaterials)
            }
        }
        return filteredList
    }

    fun setActualMaterialItem(model: MaterialData.MaterialItem){
        _actualItem = model
    }

    fun getActualMaterialItem(): MaterialData.MaterialItem{
        return _actualItem
    }
}
