package com.codeludo.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.ViewAnimator
import androidx.databinding.DataBindingUtil
import com.codeludo.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var done_button: Button
    private lateinit var nickname_text: TextView
    private lateinit var nickname_edit: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        nickname_text = findViewById(R.id.nickname_text)
        nickname_edit = findViewById(R.id.nickname_edit)
        done_button = findViewById(R.id.done_button)

        done_button.setOnClickListener {
            addNickname(it)
        }

        nickname_text.setOnClickListener{
            updateNickname(it)
        }

    }

    private fun addNickname(view: View){

        // agregar nickname
        nickname_text.text = nickname_edit.text
        // esconder editText
        nickname_edit.visibility = View.GONE
        // esconder boton
        view.visibility = View.GONE
        // hacer visible el nickname
        nickname_text.visibility = View.VISIBLE

        // esconder el teclado
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickname(view: View) {
        nickname_edit.visibility = View.VISIBLE
        done_button.visibility = View.VISIBLE
        view.visibility = View.GONE
        nickname_edit.text.clear()
        nickname_edit.requestFocus()

        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(nickname_edit, 0)
    }
}