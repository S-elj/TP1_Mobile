package fr.umontpellier.tp1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val nom = intent.getStringExtra("nom")
        val prenom = intent.getStringExtra("prenom")
        val date = intent.getStringExtra("date")

        findViewById<TextView>(R.id.textViewNom).text = nom
        findViewById<TextView>(R.id.textViewPrenom).text = prenom
        findViewById<TextView>(R.id.textViewDate).text = date

        // Gestionnaire de clics pour le bouton OK
        findViewById<Button>(R.id.buttonOk).setOnClickListener {
            startActivity(Intent(this, ThirdActivity::class.java))
        }

        // Gestionnaire de clics pour le bouton Retour
        findViewById<Button>(R.id.buttonRetour).setOnClickListener {
            finish()
        }
    }
}
