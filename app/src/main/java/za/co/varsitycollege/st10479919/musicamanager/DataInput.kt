package za.co.varsitycollege.st10479919.musicamanager

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DataInput : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_data_input)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Display and input for Song Title
        val songTitleText = findViewById<TextView>(R.id.songTitleText);
        val songTitleInput = findViewById<EditText>(R.id.titleInput);
        // Display and input for Artist
        val songArtist = findViewById<TextView>(R.id.artistNameText);
        val songArtistInput = findViewById<EditText>(R.id.artistInput);
        // Display and input for Rating
        val songRating = findViewById<TextView>(R.id.ratingText);
        val songRatingInput = findViewById<RatingBar>(R.id.ratingInput);
        // Display and input for Comment
        val songComment = findViewById<TextView>(R.id.userCommentText);
        val songCommentInput = findViewById<EditText>(R.id.commentInput);

        // Button to confirm input data
        val confirmButton = findViewById<Button>(R.id.confirmButton);
        // Button to go to DetailedView.kt
        val toDetailedViewButton = findViewById<Button>(R.id.toDetailedViewButton);
        // Button to exit app
        val exitButton = findViewById<Button>(R.id.exitButton);

    }

}