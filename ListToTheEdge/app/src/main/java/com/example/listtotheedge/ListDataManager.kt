package com.example.listtotheedge

import android.content.Context
import android.preference.PreferenceManager

class ListDataManager (private val context : Context) {
   public fun saveList(list : TaskList){
    /* Saving A List to sharedPrefences*/
       val sharedPrefences = PreferenceManager.getDefaultSharedPreferences(context).edit()
       sharedPrefences.putString(list.name, list.tasks.toHashSet().toString())
       sharedPrefences.apply()
   }

    public fun readLists(): ArrayList<TaskList>{
        /*Retrieve list from sharedPrefences */
        val sharedPrefences = PreferenceManager.getDefaultSharedPreferences(context)
        val sharedPrefencesContents = sharedPrefences.all
        val taskLists = ArrayList<TaskList>()

        for (tasklist in sharedPrefencesContents){
            val itemHashSet = ArrayList(tasklist.value as HashSet<String>)
            val list = TaskList(tasklist.key, itemHashSet)

            taskLists.add(list)

        }
        return taskLists
    }
}