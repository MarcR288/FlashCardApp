package com.example.flashcardapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.progressindicator.CircularProgressIndicator;

public class ProgressTracker extends AppCompatActivity {

    Button homeButton;
    TextView progressExplanation;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress_tracker);
        progressExplanation = findViewById(R.id.progress_explanation_text);
        homeButton = findViewById(R.id.b_return_to_home);
        progressBar = findViewById(R.id.progressBar);
        scanProgress();

        //Home Button Listener
        findViewById(R.id.b_return_to_home).setOnClickListener(v -> {
            Intent intent = new Intent(ProgressTracker.this, MainActivity.class);
            startActivity(intent);
        });
    }

    public void scanProgress() {
        DatabaseHelper dbhelper = new DatabaseHelper(this);

        SQLiteDatabase db = dbhelper.getReadableDatabaseInstance();

        String[] columns = {
                DatabaseHelper.COLUMN_ID,
                DatabaseHelper.COLUMN_QUESTION,
                DatabaseHelper.COLUMN_ANSWER,
                DatabaseHelper.COLUMN_MASTERED
        };

        // Query the database to retrieve all rows from the table
        Cursor cursor = db.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);

        // Initialize counters
        int numMastered = 0;
        int numQuestions = 0;
        float percentage = 0;

        // Check if the cursor has data
        if (cursor != null && cursor.moveToFirst()) {
            // Loop through each row in the cursor
            do {
                // Get data from each column in the current row
                @SuppressLint("Range") int column1Value = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID));
                @SuppressLint("Range") String column2Value = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_QUESTION));
                @SuppressLint("Range") String column3Value = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_ANSWER));
                @SuppressLint("Range") int column4Value = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_MASTERED)); // Use getInt for an integer column

                // Log the values from each column
                Log.d("Database Row", "Column 1: " + column1Value + ", Column 2: " + column2Value + ", Column 3: " + column3Value);

                // Increase counters based on the "mastered" value (column4Value)
                if (column4Value == 1) { // Compare integer value with 1
                    numMastered++;
                }
                numQuestions++;

            } while (cursor.moveToNext()); // Move to the next row
        }

        progressBar.setMax(numQuestions);
        progressBar.setProgress(numMastered);
        percentage = (float) numMastered / numQuestions * 100;
        // Log the results
        Log.d("Scan Progress", "Questions: " + numQuestions + ", Mastered: " + numMastered);
        @SuppressLint("DefaultLocale") String formattedText = String.format("You have mastered %d questions out of %d!\n\nYou have mastered %.02f%% of the cards!", numMastered, numQuestions, percentage);
        progressExplanation.setText(formattedText);

        // Close the cursor and database after done
        if (cursor != null) {
            cursor.close();
        }
        db.close();
    }

}
