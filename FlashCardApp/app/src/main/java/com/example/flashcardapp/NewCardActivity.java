package com.example.flashcardapp;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.ContentValues;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class NewCardActivity extends AppCompatActivity {
    Button addCardButton;
    EditText questionInput;
    EditText answerInput;
    TextView addCardResult;
    String newQuestion;
    String newAnswer;
    DatabaseHelper dbHelper;
    String result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_card_activity);
        questionInput = findViewById(R.id.new_card_question_input);
        answerInput = findViewById(R.id.new_card_answer_input);
        addCardButton = findViewById(R.id.b_add_new_card);
        addCardResult = findViewById(R.id.add_card_result_label);
        dbHelper = new DatabaseHelper(this);
        //listener for adding a card
        addCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newQuestion = questionInput.getText().toString();
                newAnswer = answerInput.getText().toString();
                Log.d("New Card", "New question: " + newQuestion);
                Log.d("New Card", "New answer: " + newAnswer);
                addCard(newQuestion, newAnswer, new Callback() {
                    @Override
                    public void onResult(String result) {
                        // Show the result in a Toast
                        Toast.makeText(NewCardActivity.this, result, Toast.LENGTH_SHORT).show();
                        addCardResult.setText(result);
                    }
                });
                questionInput.setText("");
                answerInput.setText("");
            }
        });
    }

    private void addCard(String question, String answer, final Callback callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SQLiteDatabase db = dbHelper.getWritableDatabaseInstance();

                // Create a ContentValues object to hold the values
                ContentValues values = new ContentValues();
                values.put("question", question);
                values.put("answer", answer);
                values.put("mastered", 0);

                long newRowId = db.insert("flash_cards", null, values);

                // Using runOnUiThread to safely update the UI from the background thread
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (newRowId == -1) {
                            // Insert failed, callback with error message
                            callback.onResult("Error inserting card.");
                        } else {
                            // Insert succeeded, callback with success message
                            callback.onResult("Card successfully inserted with row ID: " + newRowId);
                        }
                    }
                });
            }
        }).start();
    }


    public interface Callback {
        void onResult(String result);
    }
}
