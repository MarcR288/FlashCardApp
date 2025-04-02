package com.example.flashcardapp;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class FlashCardActivity extends AppCompatActivity {

    private ActivityResultLauncher<Intent> updateCardLauncher;
    private int currentRow = 0; // Current row position in cursor
    private int currentCardId;
    private Cursor cursor;
    DatabaseHelper dbHelper;
    TextView questionTextView;
    TextView answerTextView;
    Button nextCardButton;
    Button flipCardButton;
    Button masteredCardButton;
    Button editCardButton;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flash_card_activity);

        // Initialize DatabaseHelper and TextViews
        dbHelper = new DatabaseHelper(this);
        questionTextView = findViewById(R.id.question_text);
        answerTextView = findViewById(R.id.answer_text);
        nextCardButton = findViewById(R.id.b_next_card);
        flipCardButton = findViewById(R.id.b_flip);
        masteredCardButton = findViewById(R.id.b_mastered);
        editCardButton = findViewById(R.id.b_edit_card);

        // Display data from database
        displayDataFromDatabase();
        displayNextQuestion();

        // Next Button Listener
        nextCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNextQuestion();
                answerTextView.setVisibility(View.GONE);
            }
        });

        // Reveal Answer Listener
        answerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answerTextView.getVisibility() != View.VISIBLE){
                    answerTextView.setVisibility(View.VISIBLE);
                } else {
                    answerTextView.setVisibility(View.GONE);
                }

            }
        });

        // Flip Card Listener
        flipCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerTextView.setVisibility(View.VISIBLE);
            }
        });

        // Mark as Mastered Listener
        masteredCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                markCardAsMastered();
                displayNextQuestion();
                answerTextView.setVisibility(View.GONE);
            }
        });

        //Update card Initialize the Activity Result Launcher
        updateCardLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            // Extract the updated question and answer
                            String updatedQuestion = data.getStringExtra("updated_question");
                            String updatedAnswer = data.getStringExtra("updated_answer");

                            // Update the TextViews with the updated question and answer
                            questionTextView.setText("Q: " + updatedQuestion);  // Set "Q:" prefix again if needed
                            answerTextView.setText("A: " + updatedAnswer);      // Set "A:" prefix again if needed
                        }
                    }
                });
        // Update Card Activity Listener
        editCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FlashCardActivity.this, UpdateCardActivity.class);

// Pass the card ID as is, since it's an integer
                intent.putExtra("card_id", currentCardId);

// Convert the question and answer to remove unwanted parts
                String cardIDString = String.valueOf(currentCardId);  // Convert the integer ID to a string
                String cleanedQuestion = questionTextView.getText().toString()
                        .replace("Q:", "").trim()
                        .replace("ID:", "").trim()
                        .replace(cardIDString, "");  // Remove the card ID from the question if necessary

                String cleanedAnswer = answerTextView.getText().toString().replace("A:", "").trim();

// Pass the cleaned data to the next activity
                intent.putExtra("card_question", cleanedQuestion.trim());
                intent.putExtra("card_answer", cleanedAnswer.trim());
                Log.d("FlashCardActivity", "Passing question: " + cleanedQuestion);
                Log.d("FlashCardActivity", "Passing answer: " + cleanedAnswer);

// Start the UpdateCardActivity
                updateCardLauncher.launch(intent);

            }
        });
    }

    // Function to display data from the database
    private void displayDataFromDatabase() {
        StringBuilder qData = new StringBuilder();
        StringBuilder aData = new StringBuilder();

        // Query to fetch unmastered cards only
        SQLiteDatabase db = dbHelper.getReadableDatabaseInstance();
        cursor = db.query(
                DatabaseHelper.TABLE_NAME,          // Table name
                null,                               // Select all columns
                DatabaseHelper.COLUMN_MASTERED + " = ?", // WHERE clause to filter unmastered cards
                new String[]{"0"},                  // Arguments for WHERE clause (only unmastered cards)
                null,                               // Group By
                null,                               // Having
                null                                // Order By
        );

        if (cursor != null && cursor.moveToFirst()) {
            // Retrieve data for the first unmastered card
            @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID));
            @SuppressLint("Range") String question = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_QUESTION));
            @SuppressLint("Range") String answer = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_ANSWER));

            // Set the current card ID
            currentCardId = id;

            // Append data to the StringBuilder
            qData.append(question);
            aData.append(answer);

            // Set the text in the TextViews
            questionTextView.setText(qData.toString());
            answerTextView.setText(aData.toString());

            // Log the question and answer for debugging
            Log.v("FlashCardActivity", "Displaying card: " + question);
        }

        // Close the cursor
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }

    // Function to mark the current card as mastered
    private void markCardAsMastered() {
        if (currentCardId != 0) {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(DatabaseHelper.COLUMN_MASTERED, 1);  // Mark as mastered

            // Update the card where the ID matches
            int rowsUpdated = db.update(DatabaseHelper.TABLE_NAME, contentValues,
                    DatabaseHelper.COLUMN_ID + " = ?",
                    new String[]{String.valueOf(currentCardId)});

            // Log the number of updated rows
            Log.v("MASTERED_BUTTON", "Card marked as mastered. Rows updated: " + rowsUpdated);

            // Check if update was successful
            if (rowsUpdated > 0) {
                Log.v("MASTERED_BUTTON", "Card with ID " + currentCardId + " marked as mastered.");
            } else {
                Log.v("MASTERED_BUTTON", "Failed to update card with ID " + currentCardId);
            }
        }
    }

    // Function to display the next unmastered card (if exists)
    public void displayNextQuestion() {
        if (cursor != null && !cursor.isClosed() && cursor.moveToNext()) {
            // Move to the next row in the cursor
            @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID));
            @SuppressLint("Range") String question = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_QUESTION));
            @SuppressLint("Range") String answer = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_ANSWER));

            // Update the current card ID
            currentCardId = id;

            // Update the TextViews with the new question and answer
            questionTextView.setText(question);
            answerTextView.setText(answer);

            // Log the question for debugging
            Log.v("FlashCardActivity", "Next card: " + question);
        } else {
            // Reset cursor and start from the beginning if no unmastered cards are left
            resetCursorAndDisplay();
        }
    }

    // Function to reset the cursor and display the first unmastered card
    private void resetCursorAndDisplay() {
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }

        SQLiteDatabase db = dbHelper.getReadableDatabaseInstance();
        cursor = db.query(
                DatabaseHelper.TABLE_NAME,          // Table name
                null,                               // Select all columns
                DatabaseHelper.COLUMN_MASTERED + " = ?", // WHERE clause to filter unmastered cards
                new String[]{"0"},                  // Arguments for WHERE clause (only unmastered cards)
                null,                               // Group By
                null,                               // Having
                null                                // Order By
        );

        // Re-fetch the first unmastered card
        if (cursor != null && cursor.moveToFirst()) {
            // Retrieve data for the first unmastered card
            @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID));
            @SuppressLint("Range") String question = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_QUESTION));
            @SuppressLint("Range") String answer = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_ANSWER));

            // Set the current card ID
            currentCardId = id;

            // Update the TextViews with the first unmastered card
            questionTextView.setText(question);
            answerTextView.setText(answer);

            Log.v("FlashCardActivity", "First unmastered card: " + question);
        } else {
            // Handle the case when no unmastered cards are available
            questionTextView.setText("No more unmastered cards.");
            answerTextView.setText("");
        }
    }
}




