// Petrus Jakobus Venter ST10479919
package za.co.varsitycollege.st10479919.musicamanager

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class DetailedView : AppCompatActivity() {

    // Late declare for use inside entire class
    lateinit var  songTextView: ArrayList<TextView>
    lateinit var  artistTextView: ArrayList<TextView>
    lateinit var  ratingTextView: ArrayList<TextView>
    lateinit var  commentTextView: ArrayList<TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize array lists
        songTextView = ArrayList()
        artistTextView = ArrayList()
        ratingTextView = ArrayList()
        commentTextView = ArrayList()

        // Populate TextView arrays for looping
        findViewById<TextView>(R.id.songNameText0) ?. let { songTextView.add(it) };
        findViewById<TextView>(R.id.songNameText1) ?. let { songTextView.add(it) };
        findViewById<TextView>(R.id.songNameText2) ?. let { songTextView.add(it) };
        findViewById<TextView>(R.id.songNameText3) ?. let { songTextView.add(it) };

        findViewById<TextView>(R.id.artistNameText0) ?. let { artistTextView.add(it) };
        findViewById<TextView>(R.id.artistNameText1) ?. let { artistTextView.add(it) };
        findViewById<TextView>(R.id.artistNameText2) ?. let { artistTextView.add(it) };
        findViewById<TextView>(R.id.artistNameText3) ?. let { artistTextView.add(it) };

        findViewById<TextView>(R.id.ratingText0) ?. let { ratingTextView.add(it) };
        findViewById<TextView>(R.id.ratingText1) ?. let { ratingTextView.add(it) };
        findViewById<TextView>(R.id.ratingText2) ?. let { ratingTextView.add(it) };
        findViewById<TextView>(R.id.ratingText3) ?. let { ratingTextView.add(it) };

        findViewById<TextView>(R.id.commentText0) ?. let { commentTextView.add(it) };
        findViewById<TextView>(R.id.commentText1) ?. let { commentTextView.add(it) };
        findViewById<TextView>(R.id.commentText2) ?. let { commentTextView.add(it) };
        findViewById<TextView>(R.id.commentText3) ?. let { commentTextView.add(it) };

        // Text to display average rating
        val averageText = findViewById<TextView>(R.id.averageText);
        // Button to populate table with data
        val populateButton = findViewById<Button>(R.id.populateButton);
        // Button to calculate average rating
        val calculateAvgButton = findViewById<Button>(R.id.calculateAvgButton);
        // Button to return home
        val toHomeButton = findViewById<Button>(R.id.returnToMainScreenButton);

        var i = 0;



        // Get title from parsed data
        val titleArray = intent.getStringArrayExtra("titleArray")!!;
        for (i in 0 until titleArray.count()) {
            Log.v("Title array", "${titleArray[i]}")
        }
        // Get artists from parsed data
        val artistArray = intent.getStringArrayExtra("artistArray")!!;
        for (i in 0 until artistArray.count()){
            Log.v("Artist array", "${artistArray[i]}")
        }
        // Get rating from parsed data
        val songRatingArray = intent.getIntArrayExtra("songRatingArray")!!;
        for (i in 0 until songRatingArray.count()) {
            Log.v("Song Rating", "${songRatingArray[i]}");
        }
        // Get comment from parsed data
        val songCommentArray = intent.getStringArrayExtra("songCommentArray")!!;
        for (i in 0 until songCommentArray.count()) {
            Log.v("Song comment", "${songCommentArray[i]}");
        }


        populateButton.setOnClickListener {
            // Loop through array to populate table
            for (i in 0 until titleArray.count()) {
                // Check if array is not empty
                if (i < titleArray.count()) {
                songTextView[i].text = titleArray[i];
                artistTextView[i].text = artistArray[i];
                ratingTextView[i].text = songRatingArray[i].toString();
                commentTextView[i].text = songCommentArray[i];
                }
            }
            // Disable button
            populateButton.isEnabled = false;
        }

        calculateAvgButton.setOnClickListener {
            var avgRating = 0;
            // Loop through array to calculate average
            for (i in 0 until ratingTextView.count()) {
                avgRating += ratingTextView[i].text.toString().toInt();
            }
            // Divide by array size to get average
            avgRating /= ratingTextView.count();
            averageText.text = "Average Rating: ${avgRating}";
            // Disable button
            calculateAvgButton.isEnabled = false;
        }

        toHomeButton.setOnClickListener {
            val toHome = Intent(this, MainActivity::class.java);
            startActivity(toHome);
            finish();
        }

    }

}