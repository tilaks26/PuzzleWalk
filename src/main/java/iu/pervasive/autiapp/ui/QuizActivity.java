package iu.pervasive.autiapp.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Random;

import iu.pervasive.autiapp.R;
import iu.pervasive.autiapp.util.Question;

public class QuizActivity extends AppCompatActivity {

    Button button;

    int[] puzzle_images = {R.drawable.p_1, R.drawable.p_2, R.drawable.p_3, R.drawable.p_4, R.drawable.p_5 };

    String[][] options = {
            {"Speed", "Hiking", "Distance", "Direction"},
            {"8", "9", "10", "11"},
            {"15", "25", "35", "45"},
            {"14", "13", "10", "15"},
            {"62", "56", "78", "81"}
    };
    String[] answers = {
            "Direction",
            "9",
            "35",
            "14",
            "56"
    };

    String message = "Walk 20 steps east for your next challenge!";

    int indexQuestion = 0;
    int actualScore = 0;

    public int getActualScore() {
        return actualScore;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        button = (Button) findViewById(R.id.button_puzzle);

    }

    public void onClick(View view){
        indexQuestion = getRandomID(puzzle_images.length);

        openDialog(buildDialog2(answers[indexQuestion], puzzle_images[indexQuestion], options[indexQuestion]));
    }

    public int getRandomID(int max_value){
        return new Random().nextInt(max_value) + 1;
    }

    public AlertDialog.Builder buildDialog2(final String Answer, int question_image, final String[] optns){
        ImageView image = new ImageView(this);
        image.setImageResource(question_image);

        return new AlertDialog.Builder(this)
                .setTitle("Select The Difficulty Level")
                .setView(image)
                .setSingleChoiceItems(optns, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int whichButton) {
                        if(optns[whichButton].equals(Answer)){
                            // TODO: Increase Score.
                            actualScore += 5;
                            Toast.makeText(getApplicationContext(), "Correct Answer!", Toast.LENGTH_LONG).show();
                        }else {
                            actualScore -= 2;
                            Toast.makeText(getApplicationContext(), "Wrong Answer!", Toast.LENGTH_LONG).show();
                        }
                        finish();
                    }
                });
    }

    public void openDialog(AlertDialog.Builder builder) {
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}
