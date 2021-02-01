package com.example.praticapdm

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.praticapdm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main)


        binding.teste1.setOnClickListener {
            var i = Intent(this, TesteActivity::class.java)
            i.putExtra("opcao", "teste1")
            startActivityForResult(i, 1)
        }
        binding.teste2.setOnClickListener {
            var i = Intent(this, TesteActivity::class.java)
            i.putExtra("opcao", "teste2")
            startActivityForResult(i, 2)
        }
        binding.teste3.setOnClickListener {
            var i = Intent(this, TesteActivity::class.java)
            i.putExtra("opcao", "teste3")
            startActivityForResult(i, 3)
        }
        binding.verificar.setOnClickListener {
           if(binding.res1.text == "Resposta 1" || binding.res2.text == "Resposta 2" || binding.res3.text == "Resposta 3"){
               Toast.makeText(this, "Faça TODOS os testes", Toast.LENGTH_SHORT)
           }else{
               if(binding.res1.text == "29" && binding.res2.text == "74" && binding.res3.text == "8" ){
                   binding.resFinal.text = "VOcÊ tem chifre e uma visão normal"
               }else{
                   binding.resFinal.text = "Você é daltônico"
               }
           }

        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK){
            when(requestCode){
                1 -> {
                    binding.res1.text = data?.getStringExtra("result").toString()
                }
                2 -> {
                    binding.res2.text = data?.getStringExtra("result").toString()
                }
                3 -> {
                    binding.res3.text = data?.getStringExtra("result").toString()
                }
            }
        }

    }
}