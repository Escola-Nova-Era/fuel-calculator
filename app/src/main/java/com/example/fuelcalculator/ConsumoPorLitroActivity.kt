package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar

class ConsumoPorLitroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_consumo_por_litro)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar_consumo_litro)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        // Recuperar dados tela anterior
        // FindViewById
        // Navegar proxima tela
        // Passar dado do preco tela anterior e consumo digitado pelo usuario

        val precoCombustivel = intent.getDoubleExtra("PRECO_COMBUSTIVEL", 0.0)
        println("LOG ROQUE $precoCombustivel")

        val edtConsumoPorLitro = findViewById<EditText>(R.id.edtConsumoPorLitro)
        val btnConsumoPorLitro = findViewById<Button>(R.id.btnConsumoLitroProximo)

        btnConsumoPorLitro.setOnClickListener {
            val consumoPorLitroValor = edtConsumoPorLitro.text.toString().toInt()
            val intent = Intent(this, DistanciaActivity::class.java)
            intent.putExtra("PRECO_LITRO", precoCombustivel)
            intent.putExtra("CONSUMO_LITRO", consumoPorLitroValor)
            startActivity(intent)
        }


    }
}