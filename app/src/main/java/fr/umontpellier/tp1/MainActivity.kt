package fr.umontpellier.tp1

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val confirm_button = findViewById<Button>(R.id.confirm_button)
        val editTextNom = findViewById<EditText>(R.id.nom)
        val editTextPrenom = findViewById<EditText>(R.id.prenom)
        val editTelNumber = findViewById<EditText>(R.id.telephone)
        val domaineActiviteSpinner = findViewById<Spinner>(R.id.domaine_activite_spinner)

        ArrayAdapter.createFromResource(
            this,
            R.array.domaines_activite,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            domaineActiviteSpinner.adapter = adapter
        }


        confirm_button.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Confirmation")
            builder.setMessage("Voulez-vous confirmer les informations ?")

            builder.setPositiveButton("Confirmer") { dialog, which ->
                editTextNom.setBackgroundColor(Color.GREEN)
                editTextPrenom.setBackgroundColor(Color.GREEN)
                editTelNumber.setBackgroundColor(Color.GREEN)


                val intent = Intent(this, SecondActivity::class.java).apply {
                    putExtra("nom", editTextNom.text.toString())
                    putExtra("prenom", editTextPrenom.text.toString())
                    putExtra("num", editTelNumber.text.toString())
                    putExtra("domaineActivite", domaineActiviteSpinner.selectedItem.toString())
                }
                startActivity(intent)
            }

            builder.setNegativeButton("Annuler") { dialog, which ->
                editTextNom.setBackgroundColor(Color.TRANSPARENT)
                editTextPrenom.setBackgroundColor(Color.TRANSPARENT)
                editTelNumber.setBackgroundColor(Color.TRANSPARENT)
                editTextNom.setText("")
                editTextPrenom.setText("")
                editTelNumber.setText("")
            }

            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
    }

}