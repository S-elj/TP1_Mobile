package fr.umontpellier.tp1

import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<AutoCompleteTextView>(R.id.role).setAdapter(
            ArrayAdapter(
                this,
                R.layout.activity_main,
                resources.getStringArray(R.array.roles)
            )
        )

        val confirm_button = findViewById<Button>(R.id.confirm_button)
        val editTextNom = findViewById<EditText>(R.id.nom)
        val editTextPrenom = findViewById<EditText>(R.id.prenom)
        val editTextDate = findViewById<EditText>(R.id.date)

        confirm_button.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Confirmation")
            builder.setMessage("Voulez-vous confirmer les informations ?")

            builder.setPositiveButton("Confirmer") { dialog, which ->
                editTextNom.setBackgroundColor(Color.GREEN)
                editTextPrenom.setBackgroundColor(Color.GREEN)
                editTextDate.setBackgroundColor(Color.GREEN)
            }

            builder.setNegativeButton("Annuler") { dialog, which ->
                editTextNom.setBackgroundColor(Color.TRANSPARENT)
                editTextPrenom.setBackgroundColor(Color.TRANSPARENT)
                editTextDate.setBackgroundColor(Color.TRANSPARENT)
                editTextNom.setText("")
                editTextPrenom.setText("")
                editTextDate.setText("")
            }

            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
    }

}