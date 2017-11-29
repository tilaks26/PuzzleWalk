package iu.pervasive.autiapp.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

import iu.pervasive.autiapp.R;
import iu.pervasive.autiapp.util.Question;

public class QuizActivity extends AppCompatActivity {

    TextView question;
    Button optionA;
    Button optionB;
    Button optionC;
    Button optionD;
    TextView score;
    ArrayList<Question> questions = new ArrayList<>();
    int indexQuestion = 0;
    int actualScore = 0;
    String message = "Walk 20 steps east for your next challenge!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        question = (TextView) findViewById(R.id.question);
        optionA = (Button) findViewById(R.id.optionA);
        optionB = (Button) findViewById(R.id.optionB);
        optionC = (Button) findViewById(R.id.optionC);
        optionD = (Button) findViewById(R.id.optionD);

        loadQuestions();
        display(indexQuestion);
        openDialog(buildDialog(indexQuestion));

    }

    public void loadQuestions() {
        // TODO: Load from DB. List of Puzzles
        Question one = new Question("Who is the president of the United States of America?", "Obama", "Trump", "Bush", "Clinton", "Trump");
        Question two = new Question("What is the capital of California?", "San Fransisco", "Los Angeles", "Sacramento", "San Jose", "Sacramento");
        Question three = new Question("Which is the largest country?", "Russia", "USA", "India", "Canada", "Russia");
        Question four = new Question("Identify the odd one out", "Pen", "Dog", "Book", "Paper", "Dog");
        Question five = new Question("When is Christmas celebrated?", "Dec 21", "Feb 16", "Jul 30", "Dec 26", "Dec 26");
        questions.add(one);
        questions.add(two);
        questions.add(three);
        questions.add(four);
        questions.add(five);
    }

    public void display(int index) {
        question.setText(questions.get(index).getQuestion());
        optionA.setText(questions.get(index).getOptionA());
        optionB.setText(questions.get(index).getOptionB());
        optionC.setText(questions.get(index).getOptionC());
        optionD.setText(questions.get(index).getOptionD());
    }

    public void onOptionClick(View v) {
        Button clicked = (Button) findViewById(v.getId());
        String userAnswer = (String) clicked.getText();
        String actualAnswer = questions.get(indexQuestion).getAnswer();
        ;
        boolean correct = false;

        if (actualAnswer.equals(userAnswer)) {
            correct = true;
            Toast.makeText(getApplicationContext(), "Correct Answer!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Wrong Answer!", Toast.LENGTH_SHORT).show();
        }

        if (correct) {
            actualScore += 1;
            // TODO: show achievement.
            // TODO: Get text for next action / next move.
            displayNextAction(message);
        }

        indexQuestion += 1;
        if (indexQuestion >= questions.size()) {
            indexQuestion = 0;
        }

        display(indexQuestion);
    }

    public AlertDialog.Builder buildDialog(int indexQuestion) {
        ListView list;
        String[] itemname = {
                "Safari",
                "Camera",
                "Global",
                "FireFox",
                "UC Browser",
                "Android Folder",
                "VLC Player",
                "Cold War"
        };

        Integer[] imgid = {
                R.drawable.pic1,
                R.drawable.pic2,
                R.drawable.pic3,
                R.drawable.pic4,
                R.drawable.pic5,
                R.drawable.pic6,
                R.drawable.pic7,
                R.drawable.pic8,
        };

//        ListAdapter adapter = new ListAdapter(this, itemname, imgid);
//        list = (ListView) findViewById(R.id.list);
//        list.setAdapter(adapter);

        // get data from the table by the ListAdapter
        //ListAdapter customAdapter = new ListAdapter(this, itemname, imgid);

        //list.setAdapter(customAdapter);

        AlertDialog.Builder builder = new AlertDialog.Builder(QuizActivity.this);
        LayoutInflater inflater = this.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.mylist, null, true);
        builder.setView(rowView);
        // TODO: Dynamic set of array for puzzles.
        builder.setTitle("Pick a right answer!");

//                .setItems(, new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                        // We Will know which one was selected. through which = index.
//                    }
//                });
        //.setView(adapter.getView());
        return builder;
    }

    public void openDialog(AlertDialog.Builder builder) {
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void displayNextAction(String message) {

    }

    public void showAchievement(String message) {

    }

}
