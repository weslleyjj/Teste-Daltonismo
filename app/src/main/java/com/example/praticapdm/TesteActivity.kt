package com.example.praticapdm

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.databinding.DataBindingUtil

class TesteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teste)
        //var binding = DataBindingUtil.setContentView(this, R.layout.activity_teste)
        var image = findViewById<ImageView>(R.id.imTeste)
        var btnResposta = findViewById<Button>(R.id.btnResposta)
        var btnCancelar = findViewById<Button>(R.id.btnCancelar)
        var campoResposta = findViewById<EditText>(R.id.resposta)

        var params: Bundle? = intent.extras
        var opcao = params?.getString("opcao")
        if(opcao.toString() == "teste1"){
            image.setImageResource(R.drawable.teste1)
        }else if(opcao.toString() == "teste2"){
            image.setImageResource(R.drawable.teste2)
        }else if(opcao.toString() == "teste3"){
            image.setImageResource(R.drawable.teste3)
        }

        var intent = Intent(this, MainActivity::class.java)
        var bundle = Bundle()

        btnResposta.setOnClickListener {
            bundle.putString("result", campoResposta.text.toString())
            intent.putExtras(bundle)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        btnCancelar.setOnClickListener {
            finish()
        }
    }
}