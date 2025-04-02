# FlashCardApp
FlashCardApp is an Android application that helps users learn through flashcards. The app allows users to view, flip, and mark flashcards as "mastered". Users can add, edit, and track their progress by going through unmastered cards.

FlashCardACtivity

Features
    Flashcards: The app displays a flashcard with a question and its corresponding answer.
    Next Card: Users can move to the next card.
    Flip Card: Flip a card to reveal the answer.
    Master a Card: Mark a flashcard as mastered.
    Edit Cards: Edit existing flashcards to update questions or answers.
    Database Integration: Stores flashcards in an SQLite database, tracking which cards have been mastered and which have not.

NewCardActivity

Features:
    Add New Card: Users can input a new question and answer, and the app will add the card to the database.
    Feedback: After adding a card, the app displays a success or error message.
    UI Components:
    EditText for entering the question and answer.
    Button to trigger the addition of the card.
    TextView to display the result (success or error message).

ProgressTracker Activity

The ProgressTracker activity is designed to provide users with a visual representation of their progress in mastering flashcards. It shows the number of flashcards the user has mastered and displays a percentage indicating the user's overall progress.

Clearing the Database (Wiping All Cards)
    The app comes preloaded with 45+ theoritical programming questions and answers, but users have an option to clear all the flashcards from the database. This can be useful if you want to reset the app or remove all the data and fill the database with cards relevant for their own purposes. The feature includes a confirmation dialog to ensure the user intends to delete all the data.

CRUD Operations and SQL Database
    The Flashcard App uses a SQLite database to store and manage flashcards. The app supports CRUD operations: Create, Read, Update, and Delete. These operations enable users to add, view, modify, and delete flashcards in the app, while ensuring efficient data management.

SQL Database
    The app uses SQLite to manage the data locally on the device. The SQLite database is structured with a single table called flash_cards, where each row represents a flashcard. Each flashcard has the following fields:
        id: A unique identifier for each flashcard (auto-incremented).
        question: The question part of the flashcard.
        answer: The answer part of the flashcard.
        mastered: A flag (0 or 1) that indicates whether the flashcard has been mastered by the user (1 if mastered, 0 otherwise).

CRUD Operations in the App
    Create: Add a new flashcard to the database.
    Read: Retrieve and display flashcards from the database.
    Update: Modify an existing flashcard.
    Delete: Remove a flashcard from the database.

# How to Install FlashCardApp on Your Android Device
Follow these steps to install FlashCardApp on your Android device:

Download the APK:
Click the following link to download the FlashCardApp APK:
https://drive.google.com/file/d/1stRRl1GnbrMBcaZo7E6LbPPIs8kU-3Ar/view

Allow Installation from Unknown Sources:
Go to your Settings app.
Navigate to Security (or Apps & notifications > Install unknown apps).
Enable the option to install from the file manager or browser app where you will open the APK.

Install the APK:
Once the APK file has been downloaded, open the file from your Downloads or the location where you saved it.
Tap Install to start the installation process.
Open FlashCardApp:

