package com.example.passport.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.passport.App.App
import com.example.passport.databinding.ActivityAddPassBinding
import com.example.passport.model.PassItem
import com.example.passport.model.PassItemDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddPassActivity : AppCompatActivity() {
    lateinit var passItemDao: PassItemDao
    lateinit var binding: ActivityAddPassBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddPassBinding.inflate(layoutInflater)
        setContentView(binding.root)
        passItemDao = (application as App).getDataBase().passItemDao()

            addPassItem()

    }
    fun addPassItem (){
        binding.btnAdd.setOnClickListener() {
            val pass = binding.password.text.toString()
            val email = binding.email.text.toString()
            val login = binding.login.text.toString()
            val name = binding.name.text.toString()

            val passItem: PassItem = PassItem(0, pass, email, login, name)

            lifecycleScope.launch(context = Dispatchers.IO) {
                passItemDao.putPassItem(passItem)
            }
        }
    }

}
