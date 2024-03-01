package fr.umontpellier.tp1

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val numTel = intent.getStringExtra("numTel")
        findViewById<TextView>(R.id.textViewPhone).text = numTel

        findViewById<ImageButton>(R.id.phoneLogo).setOnClickListener {
            val numTel = intent.getStringExtra("numTel")
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), REQUEST_PHONE_CALL)
            } else {
                startCall(numTel)
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_PHONE_CALL && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            startCall(intent.getStringExtra("numTel"))
        }
    }

    private fun startCall(phoneNumber: String?) {
        phoneNumber?.let {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:$it")
            startActivity(intent)
        }
    }

    companion object {
        private const val REQUEST_PHONE_CALL = 1
    }


}
