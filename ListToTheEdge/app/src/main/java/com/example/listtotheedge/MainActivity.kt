package com.example.listtotheedge

import android.app.AlertDialog
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val listDataManager: ListDataManager = ListDataManager(this)
    private lateinit var listsRecyclerView: RecyclerView
    private val lists = listDataManager.readLists()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        listsRecyclerView = findViewById(R.id.lists_recyclerview)
        listsRecyclerView.layoutManager = LinearLayoutManager(this)
        listsRecyclerView.adapter = ListSelectionRecyclerViewAdapter(lists)


        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener {
            showCreateListDialog()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
    private fun addList(list:TaskList){
        lists.add(list)
        notif

    }
    private fun showCreateListDialog() : Unit{

        /*
            Creating Alert dialog for creating list !
         */

        val dialogtitles = getString(R.string.name_of_list)
        val addButtonTitle = getString(R.string.create_list)

        val alertBuilder = AlertDialog.Builder(this)
        val listEditText = EditText(this)

        alertBuilder.setTitle((dialogtitles))
        alertBuilder.setView(listEditText)
        alertBuilder.setPositiveButton(addButtonTitle){dialog, _ ->
            val list =TaskList(listEditText.text.toString())
            listDataManager.saveList(list)
            val recyclerAdapter = listsRecyclerView.adapter as ListSelectionRecyclerViewAdapter
            recyclerAdapter.addList(list)
            dialog.dismiss()
        }

        alertBuilder.create().show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}