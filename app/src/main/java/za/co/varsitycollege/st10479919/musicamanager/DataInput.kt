// Petrus Jakobus Venter ST10479919
package za.co.varsitycollege.st10479919.musicamanager

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
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

        var titleArray = arrayOf<String>("", "", "", "");
        var artistArray = arrayOf<String>("","","","");
        var songRatingArray = IntArray(4);
        var songCommentArray = arrayOf<String>("","","","");

        // Displays help for user
        val userHelpText = findViewById<TextView>(R.id.userHelpText);

        // Display and input for Song Title
        val songTitleText = findViewById<TextView>(R.id.songTitleText);
        val songTitleInput = findViewById<EditText>(R.id.titleInput);
        // Display and input for Artist
        val songArtistText = findViewById<TextView>(R.id.artistNameText);
        val songArtistInput = findViewById<EditText>(R.id.artistInput);
        // Display and input for Rating
        val songRatingText = findViewById<TextView>(R.id.ratingText);
        val songRatingInput = findViewById<RatingBar>(R.id.ratingInput);
        // Display and input for Comment
        val songCommentText = findViewById<TextView>(R.id.userCommentText);
        val songCommentInput = findViewById<EditText>(R.id.commentInput);

        // Button to confirm input data
        val confirmButton = findViewById<Button>(R.id.confirmButton);
        // Button to go to DetailedView.kt
        val toDetailedViewButton = findViewById<Button>(R.id.toDetailedViewButton);
        // Button to exit app
        val exitButton = findViewById<Button>(R.id.exitButton);

        // Incrementor
        var i = 0;

        toDetailedViewButton.isEnabled = false;

        // Button to store data
        confirmButton.setOnClickListener {
            // Input validation
            if (i < titleArray.size && isValidString(songTitleInput.text.toString()) == true && isValidString(songArtistInput.text.toString()) == true && isValidString(songCommentInput.text.toString()) == true){
                userHelpText.text = "Song data ${i + 1} Added."

                // Add elements to array from input
                titleArray[i] = songTitleInput.text.toString()
                Log.v("Title added:", "${titleArray[i]} at ${i}")
                artistArray[i] = songArtistInput.text.toString()
                Log.v("Artist added:", "${artistArray[i]} at ${i}")
                songRatingArray[i] = songRatingInput.rating.toInt()
                Log.v("Rating added:", "${songRatingArray[i]} at ${i}")
                songCommentArray[i] = songCommentInput.text.toString()
                Log.v("Comment added:", "${songCommentArray[i]} at ${i}")
                // Increment to next subscript
                i++
                // Clear all inputs
                songTitleInput.text.clear()
                songArtistInput.text.clear()
                songRatingInput.rating = 0.0F
                songCommentInput.text.clear()
                // User completed populating arrays
                if (i == 4) {
                    userHelpText.text = "Please press the Review button to check your data."
                    // Disable button for input
                    confirmButton.isEnabled = false;
                    // Enable button to go to next screen
                    toDetailedViewButton.isEnabled = true;
                }
            }
            else if (i < titleArray.size) {

                Toast.makeText(this,"Please enter valid items!", Toast.LENGTH_SHORT).show();
                Log.v("User Error:", "Invalid input");
                Log.v("Title:", songTitleInput.text.toString());
                Log.v("Artist:", songArtistInput.text.toString());
                Log.v("Rating:", songRatingInput.rating.toInt().toString());
                Log.v("Comment:",songCommentInput.text.toString());
            }
            // In case user in error state
            else {
                userHelpText.text = "Please press the Review button to check your data."
                // Disable button for input
                confirmButton.isEnabled = false;
                // Enable button to go to next screen
                toDetailedViewButton.isEnabled = true;
            }

        }

        // Moves to the DetailedView screen to display data that was inputted
        toDetailedViewButton.setOnClickListener {
            val toDetailedView = Intent(this, DetailedView::class.java);
            toDetailedView.putExtra("titleArray", titleArray);
            toDetailedView.putExtra("artistArray", artistArray);
            toDetailedView.putExtra("songRatingArray", songRatingArray);
            toDetailedView.putExtra("songCommentArray", songCommentArray);
            startActivity(toDetailedView);
            finish();
        }

        // Exits the app
        exitButton.setOnClickListener {
            finish();
        }

    }
    fun isValidString(input: String): Boolean {
        if (input.isNotEmpty() && input != null) {
            return true
        }
        else return false;
    }

}