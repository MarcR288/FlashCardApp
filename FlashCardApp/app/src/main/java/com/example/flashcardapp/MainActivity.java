package com.example.flashcardapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button clearCardsButton = findViewById(R.id.b_clear_cards);
        DatabaseHelper dbhelper = new DatabaseHelper(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //FlashCard Activity
        findViewById(R.id.b_start_flashCard_activity).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FlashCardActivity.class);
            startActivity(intent);

        });
        //Add New Card Activity
        findViewById(R.id.b_start_new_card_activity).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, NewCardActivity.class);
            startActivity(intent);
        });
        //Track Progress Activity
        findViewById(R.id.b_start_progress_activity).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ProgressTracker.class);
            startActivity(intent);
        });
        //Clear Database
        clearCardsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Show confirmation dialog
                new AlertDialog.Builder(MainActivity.this)
                        .setMessage("This will delete all cards from the database.\nAre you sure?")
                        .setCancelable(false) // Prevents dismissal when tapping outside
                        .setPositiveButton("Yes", (dialog, id) -> {
                            // Do the action on "Yes"
                            Toast.makeText(MainActivity.this, "Table Wiped", Toast.LENGTH_SHORT).show();
                            dbhelper.wipeTable();
                        })
                        .setNegativeButton("No", (dialog, id) -> {
                            // Do nothing on "No"
                            dialog.dismiss();
                        })
                        .create()
                        .show();
            }
        });

    }
}