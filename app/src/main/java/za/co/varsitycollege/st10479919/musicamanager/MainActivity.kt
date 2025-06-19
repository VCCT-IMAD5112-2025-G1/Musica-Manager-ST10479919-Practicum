// Petrus Jakobus Venter ST10479919
package za.co.varsitycollege.st10479919.musicamanager

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Text that welcomes users
        val welcomeText = findViewById<TextView>(R.id.welcomeText);
        // Button should move to the next screen
        val moveToInputData = findViewById<Button>(R.id.moveToInputDataButton);
        // Button to exit the app
        val exitButton = findViewById<Button>(R.id.exitButton);


    }
}