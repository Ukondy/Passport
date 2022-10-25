package com.example.passport

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.lifecycle.lifecycleScope
import com.example.passport.App.App
import com.example.passport.adapter.PassAdapter
import com.example.passport.databinding.ActivityMainBinding
import com.example.passport.databinding.ActivityPasswordsPrintBinding
import com.example.passport.model.PassItem
import com.example.passport.model.PassItemDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PasswordsPrintActivity : AppCompatActivity() {
    lateinit var binding: ActivityPasswordsPrintBinding
    lateinit var adapter: PassAdapter
    lateinit var passDao: PassItemDao

     var listPass = ArrayList<PassItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPasswordsPrintBinding.inflate(layoutInflater)
        setContentView(binding.root)

        passDao = (application as App).getDataBase().passItemDao()



        lifecycleScope.launch(Dispatchers.IO){
           var  list = passDao.getAllPassItem() as ArrayList
            listPass.addAll(list)
            adapter = PassAdapter(listPass)

            withContext(Dispatchers.Main){
                binding.recycler.adapter = adapter
            }

        }


        binding.add.setOnClickListener() {
            var intent = Intent(this, AddPassActivity::class.java)
            startActivity(intent)
        }
    }
}