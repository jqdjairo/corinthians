package com.bandtec.simplify.estudante

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter

import android.widget.Spinner
import com.bandtec.simplify.R

class HorariosEstudante : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_horarios_estudante)

        val mySpinner : Spinner = findViewById(R.id.static_drop)

        ArrayAdapter.createFromResource(
                this,
                R.array.diasSemana,
                android.R.layout.simple_spinner_item
        ).also{ adapter -> adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            mySpinner.adapter = adapter
        }

//
//        val myAdapter: ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_list_item_1,
//            getResources().getStringArray(R.array.diasSemana))
//        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        mySpinner.setAdapter(myAdapter)

    }

    fun back(view: View) {
        onBackPressed();
    }
}