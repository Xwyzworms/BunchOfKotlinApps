package com.example.listtotheedge

class TaskList (private var named :String, val tasks :ArrayList<String> = ArrayList()) {
         var name : String = named
            get() = field ?: "Ga Ada NAma"
            set(value){
                field = value
            }

}
