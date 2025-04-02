package com.example.flashcardapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateCardActivity extends AppCompatActivity {

    EditText questionEditField, answerEditField;
    Button editButton, deleteButton;
    int cardId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_card_activity);

        questionEditField = findViewById(R.id.edit_question_field);
        answerEditField = findViewById(R.id.edit_answer_field);
        editButton = findViewById(R.id.b_save_changes);
        deleteButton = findViewById(R.id.b_delete_card);
        FlashCardActivity flashCardActivity = new FlashCardActivity();



        Intent intent = getIntent();
        cardId = intent.getIntExtra("card_id", -1);
        String question = intent.getStringExtra("card_question");
        String answer = intent.getStringExtra("card_answer");

        questionEditField.setText(question);
        answerEditField.setText(answer);

        //Save Changes listener:
        editButton.setOnClickListener(v -> {
            String updatedQuestion = questionEditField.getText().toString();
            String updatedAnswer = answerEditField.getText().toString();
            updateCardInDatabase(cardId, updatedQuestion, updatedAnswer);
        });
        //Delete Button listener
        deleteButton.setOnClickListener(v -> {
            try {
                deleteCardInDatabase(cardId);
                flashCardActivity.displayNextQuestion();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

    }

    private void updateCardInDatabase(int cardId, String updatedQuestion, String updatedAnswer) {
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // Prepare the content values
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COLUMN_QUESTION, updatedQuestion);
        contentValues.put(DatabaseHelper.COLUMN_ANSWER, updatedAnswer);
        contentValues.put(DatabaseHelper.COLUMN_MASTERED, 0);  // Optionally reset the "mastered" status

        // Update the card in the database
        int rowsUpdated = db.update(DatabaseHelper.TABLE_NAME, contentValues,
                DatabaseHelper.COLUMN_ID + " = ?",
                new String[]{String.valueOf(cardId)});

        if (rowsUpdated > 0) {
            Log.v("EditCardActivity", "Card updated successfully.");

            // Send the updated data back to the FlashCardActivity
            Intent resultIntent = new Intent();
            resultIntent.putExtra("updated_question", updatedQuestion);
            resultIntent.putExtra("updated_answer", updatedAnswer);
            setResult(RESULT_OK, resultIntent);  // Indicate a successful result

            finish(); // Close UpdateCardActivity and return to FlashCardActivity
        } else {
            Log.v("EditCardActivity", "Failed to update card.");
        }
    }

    private void deleteCardInDatabase(int cardId) throws InterruptedException {

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // Define the condition for the deletion (WHERE clause)
        String whereClause = DatabaseHelper.COLUMN_ID + " = ?";
        String[] whereArgs = { String.valueOf(cardId) };

        // Perform the deletion and get the number of rows affected
        int rowsDeleted = db.delete(DatabaseHelper.TABLE_NAME, whereClause, whereArgs);

        // Check if the deletion was successful
        if (rowsDeleted > 0) {
            Log.v("DeleteCardActivity", "Card with ID " + cardId + " was deleted successfully.");

            // Optionally, you can send a result back to the calling activity if needed
            Intent resultIntent = new Intent();
            resultIntent.putExtra("deleted_card_id", cardId);
            setResult(RESULT_OK, resultIntent);

        } else {
            Log.v("DeleteCardActivity", "No card found with ID " + cardId);
        }

        db.close(); // Close the database connection
    }


}
