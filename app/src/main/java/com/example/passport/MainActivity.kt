package com.example.passport

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.passport.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var prefManager: PrefManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prefManager = PrefManager(this)
        initInterface()
        binding.btn1.setOnClickListener() {
            registration()
        }
        binding.btnConnect.setOnClickListener() {
            enter()
        }
    }

    private fun initInterface() {
       val pass = prefManager.getString("pass")
        if (pass !=null){
            binding.ETextOne.visibility = View.GONE
            binding.ETextTwo.visibility = View.GONE
            binding.btn1.visibility = View.GONE

            binding.ETextOneConnect.visibility = View.VISIBLE
            binding.btnConnect.visibility = View.VISIBLE
        }else{
            binding.ETextOne.visibility = View.VISIBLE
            binding.ETextTwo.visibility = View.VISIBLE
            binding.btn1.visibility = View.VISIBLE

            binding.ETextOneConnect.visibility = View.GONE
            binding.btnConnect.visibility = View.GONE
        }
    }


    private fun registration(): Int {
        var passOne: String = binding.passOne.text.toString()
        var passTwo: String = binding.passTwo.text.toString()
        if(passOne != passTwo || passOne == "" || passOne == " ") {
            println("Ошибка!")
            return -1
        } else if(passOne.length <= 16) {
            binding.passOne.hint = "Слишком маленький пароль"
            binding.passTwo.hint = "Слишком маленький пароль"
            return -1
        }
        prefManager.putString("pass", passOne)

        return 1
    }
    private fun enter(): Int {
        var passOne: String = binding.passTwo.text.toString()
        if(passOne == "" || passOne == " ") {
            println("Ошибка!")
            return -1
        } else if(passOne.length <= 16) {
            binding.passOneConnect.hint = "Слишком маленький пароль"
            return -1
        }
        var intent = Intent(this, PasswordsPrintActivity::class.java)
        startActivity(intent)
        return 1
    }
}