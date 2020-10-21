package com.example.randomtriviaapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int question = 1;
    private int answered = 0;
    private double score = 0;
    private TextView topText, questionText, resultText;
    private ImageView imageView;
    private Button aBtn, bBtn, cBtn, dBtn, nextBtn, resetBtn, quitBtn;
    SoundPool sound;
    int rightSound, wrongSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topText = (TextView) findViewById(R.id.topText);
        questionText = (TextView) findViewById(R.id.questionText);
        resultText = (TextView) findViewById(R.id.resultText);
        imageView = (ImageView) findViewById(R.id.imageView);
        aBtn = (Button) findViewById(R.id.aBtn);
        bBtn = (Button) findViewById(R.id.bBtn);
        cBtn = (Button) findViewById(R.id.cBtn);
        dBtn = (Button) findViewById(R.id.dBtn);
        nextBtn = (Button) findViewById(R.id.nextBtn);
        resetBtn = (Button) findViewById(R.id.resetBtn);
        quitBtn = (Button) findViewById(R.id.quitBtn);

        nextBtn.setText("Next");

        AudioAttributes
                audioAttributes
                = new AudioAttributes
                .Builder()
                .setUsage(
                        AudioAttributes
                                .USAGE_ASSISTANCE_SONIFICATION)
                .setContentType(
                        AudioAttributes
                                .CONTENT_TYPE_SONIFICATION)
                .build();
        sound = new SoundPool
                .Builder()
                .setMaxStreams(3)
                .setAudioAttributes(
                        audioAttributes)
                .build();

        rightSound = sound.load(this, R.raw.right, 1);
        wrongSound = sound.load(this,R.raw.wrong,1);

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                question = 1;
                score = 0;
                answered = 0;
                triviaQuestions();
            }
        });
        quitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                question = 1;
                score = 0;
                answered = 0;
                System.exit(0);
            }
        });
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(question < 11) {
                    question++;
                    triviaQuestions();
                }
                else if (question >= 11)
                {
                    dialog();
                }
            }
        });

        triviaQuestions();
    }

    public void triviaQuestions()
    {
        resultText.setText("");
        aBtn.setEnabled(true);
        bBtn.setEnabled(true);
        cBtn.setEnabled(true);
        dBtn.setEnabled(true);

        aBtn.setBackgroundColor(Color.parseColor("#E040FB"));
        bBtn.setBackgroundColor(Color.parseColor("#E040FB"));
        cBtn.setBackgroundColor(Color.parseColor("#E040FB"));
        dBtn.setBackgroundColor(Color.parseColor("#E040FB"));


        if (question == 1)
        {
            nextBtn.setText("Next");
            topText.setText("Question 1 of 10");
            imageView.setBackgroundResource(R.drawable.guitar);
            questionText.setText("What is the standard tuning of a 6 string guitar?");
            aBtn.setText("FGACBD");
            bBtn.setText("EADGBE");
            cBtn.setText("BAGDAG");
            dBtn.setText("EGBDF");

            aBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    aBtn.setBackgroundColor(Color.parseColor("#FF7C4DFF"));
                    incorrect();
                }
            });
            bBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bBtn.setBackgroundColor(Color.parseColor("#FF7C4DFF"));
                    correct();
                }
            });
            cBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cBtn.setBackgroundColor(Color.parseColor("#FF7C4DFF"));
                    incorrect();
                }
            });
            dBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dBtn.setBackgroundColor(Color.parseColor("#FF7C4DFF"));
                    incorrect();
                }
            });

        }
        else if (question == 2)
        {
            topText.setText("Question 2 of 10");
            imageView.setBackgroundResource(R.drawable.road);
            questionText.setText("How many feet are in 1 mile?");
            aBtn.setText("7500");
            bBtn.setText("2349");
            cBtn.setText("6693");
            dBtn.setText("5280");

            aBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    aBtn.setBackgroundColor(Color.parseColor("#FF7C4DFF"));
                    incorrect();
                }
            });
            bBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bBtn.setBackgroundColor(Color.parseColor("#FF7C4DFF"));
                    incorrect();
                }
            });
            cBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cBtn.setBackgroundColor(Color.parseColor("#FF7C4DFF"));
                    incorrect();
                }
            });
            dBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dBtn.setBackgroundColor(Color.parseColor("#FF7C4DFF"));
                    correct();
                }
            });
        }
        else if (question == 3)
        {
            topText.setText("Question 3 of 10");
            imageView.setBackgroundResource(R.drawable.apple);
            questionText.setText("What is gravity's rate of acceleration?");
            aBtn.setText("9.8 f/s^2");
            bBtn.setText("8.5 m/s^2");
            cBtn.setText("9.8 m/s^2");
            dBtn.setText("8.25 f/s^2");

            aBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    aBtn.setBackgroundColor(Color.parseColor("#FF7C4DFF"));
                    incorrect();
                }
            });
            bBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bBtn.setBackgroundColor(Color.parseColor("#FF7C4DFF"));
                    incorrect();
                }
            });
            cBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cBtn.setBackgroundColor(Color.parseColor("#FF7C4DFF"));
                    correct();
                }
            });
            dBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dBtn.setBackgroundColor(Color.parseColor("#FF7C4DFF"));
                    incorrect();
                }
            });
        }
        else if (question == 4)
        {
            topText.setText("Question 4 of 10");
            imageView.setBackgroundResource(R.drawable.moon);
            questionText.setText("What causes the moon's phases?");
            aBtn.setText("The Earth's shadow");
            bBtn.setText("The Earth's tides");
            cBtn.setText("The Moon's angle");
            dBtn.setText("Moonlight");

            aBtn.setTextSize(14);
            bBtn.setTextSize(14);
            cBtn.setTextSize(14);
            dBtn.setTextSize(14);

            aBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    aBtn.setBackgroundColor(Color.parseColor("#FF7C4DFF"));
                    incorrect();
                }
            });
            bBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bBtn.setBackgroundColor(Color.parseColor("#FF7C4DFF"));
                    incorrect();
                }
            });
            cBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cBtn.setBackgroundColor(Color.parseColor("#FF7C4DFF"));
                    correct();
                }
            });
            dBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dBtn.setBackgroundColor(Color.parseColor("#FF7C4DFF"));
                    incorrect();
                }
            });
        }
        else if (question == 5)
        {
            topText.setText("Question 5 of 10");
            imageView.setBackgroundResource(R.drawable.laptop);
            questionText.setText("What does HTML stand for?");
            aBtn.setText("HyperTraction Media Log");
            bBtn.setText("HalfTime Metadata Lag");
            cBtn.setText("HyperText Markup Language");
            dBtn.setText("HyperTool Metadata Log");

            aBtn.setTextSize(12);
            bBtn.setTextSize(12);
            cBtn.setTextSize(12);
            dBtn.setTextSize(12);

            aBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    aBtn.setBackgroundColor(Color.parseColor("#FF7C4DFF"));
                    incorrect();
                }
            });
            bBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bBtn.setBackgroundColor(Color.parseColor("#FF7C4DFF"));
                    incorrect();
                }
            });
            cBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cBtn.setBackgroundColor(Color.parseColor("#FF7C4DFF"));
                    correct();
                }
            });
            dBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dBtn.setBackgroundColor(Color.parseColor("#FF7C4DFF"));
                    incorrect();
                }
            });
        }
        else if (question == 6)
        {
            topText.setText("Question 6 of 10");
            imageView.setBackgroundResource(R.drawable.tennis);
            questionText.setText("Tennis uses a point scoring system per \"game\" in each set. What is the name of each \"point?\"");

            aBtn.setText("Love, 15, 30, 40");
            bBtn.setText("0, 5, 10, 15");
            cBtn.setText("5, 10, 15, 20");
            dBtn.setText("25, 50, 75, 100");

            aBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    aBtn.setBackgroundColor(Color.parseColor("#FF7C4DFF"));
                    correct();
                }
            });
            bBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bBtn.setBackgroundColor(Color.parseColor("#FF7C4DFF"));
                    incorrect();
                }
            });
            cBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cBtn.setBackgroundColor(Color.parseColor("#FF7C4DFF"));
                    incorrect();
                }
            });
            dBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dBtn.setBackgroundColor(Color.parseColor("#FF7C4DFF"));
                    incorrect();
                }
            });

        }
        else if (question == 7)
        {
            topText.setText("Question 7 of 10");
            imageView.setBackgroundResource(R.drawable.corpus);
            questionText.setText("What is the original name of the city of Corpus Christi?");
            aBtn.setText("Star City");
            bBtn.setText("Alameda Market Post");
            cBtn.setText("Kinney's Trading Post");
            dBtn.setText("Starling City");

            aBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    aBtn.setBackgroundColor(Color.parseColor("#FF7C4DFF"));
                    incorrect();
                }
            });
            bBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bBtn.setBackgroundColor(Color.parseColor("#FF7C4DFF"));
                    incorrect();
                }
            });
            cBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cBtn.setBackgroundColor(Color.parseColor("#FF7C4DFF"));
                    correct();
                }
            });
            dBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dBtn.setBackgroundColor(Color.parseColor("#FF7C4DFF"));
                    incorrect();
                }
            });

        }
        else if (question == 8)
        {
            topText.setText("Question 8 of 10");
            imageView.setBackgroundResource(R.drawable.cake);
            questionText.setText("What is the minimal amount of cuts made to cut a round cake into 8 slices?");
            aBtn.setText("4");
            bBtn.setText("3");
            cBtn.setText("5");
            dBtn.setText("2");

            aBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    aBtn.setBackgroundColor(Color.parseColor("#FF7C4DFF"));
                    incorrect();
                }
            });
            bBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bBtn.setBackgroundColor(Color.parseColor("#FF7C4DFF"));
                    correct();
                }
            });
            cBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cBtn.setBackgroundColor(Color.parseColor("#FF7C4DFF"));
                    incorrect();
                }
            });
            dBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dBtn.setBackgroundColor(Color.parseColor("#FF7C4DFF"));
                    incorrect();
                }
            });
        }
        else if (question == 9)
        {
            topText.setText("Question 9 of 10");
            imageView.setBackgroundResource(R.drawable.eye);
            questionText.setText("She has played multiple characters, notably one called 'Alice' and another called \"Leelu.\"");
            aBtn.setTextSize(14);
            bBtn.setTextSize(14);
            cBtn.setTextSize(14);
            dBtn.setTextSize(14);
            aBtn.setText("Mary Elizabeth Winstead");
            bBtn.setText("Milla Jovovich");
            cBtn.setText("Angelina Jolie");
            dBtn.setText("Winona Ryder");

            aBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    aBtn.setBackgroundColor(Color.parseColor("#FF7C4DFF"));
                    incorrect();
                }
            });
            bBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bBtn.setBackgroundColor(Color.parseColor("#FF7C4DFF"));
                    correct();
                }
            });
            cBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cBtn.setBackgroundColor(Color.parseColor("#FF7C4DFF"));
                    incorrect();
                }
            });
            dBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dBtn.setBackgroundColor(Color.parseColor("#FF7C4DFF"));
                    incorrect();
                }
            });
        }
        else if (question == 10)
        {
            nextBtn.setText("Finish");
            topText.setText("Question 10 of 10");
            imageView.setBackgroundResource(R.drawable.highlands);
            questionText.setText("In the 'Highlander' movie franchise, this quote is usually said before an immortal is killed.");
            aBtn.setTextSize(14);
            bBtn.setTextSize(14);
            cBtn.setTextSize(14);
            dBtn.setTextSize(14);
            aBtn.setText("\"Thou hast met thine end!\"");
            bBtn.setText("\"Game over!\"");
            cBtn.setText("\"I am the only one!\"");
            dBtn.setText("\"There can be only one!\"");

            aBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    aBtn.setBackgroundColor(Color.parseColor("#FF7C4DFF"));
                    incorrect();
                    question++;
                }
            });
            bBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bBtn.setBackgroundColor(Color.parseColor("#FF7C4DFF"));
                    incorrect();
                    question++;
                }
            });
            cBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cBtn.setBackgroundColor(Color.parseColor("#FF7C4DFF"));
                    incorrect();
                    question++;
                }
            });
            dBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dBtn.setBackgroundColor(Color.parseColor("#FF7C4DFF"));
                    correct();
                    question++;
                }
            });
        }
    }

    public void correct()
    {

        sound.play(
                rightSound, 1, 1, 1, 0, 1);

        aBtn.setEnabled(false);
        bBtn.setEnabled(false);
        cBtn.setEnabled(false);
        dBtn.setEnabled(false);
        resultText.setTextColor(Color.parseColor("#FFFFFF"));
        resultText.setText("Your answer is correct!");
        answered++;
        score += 1;
    }

    public void incorrect()
    {

        sound.play(
                wrongSound, 1, 1, 1, 0, 1);

        aBtn.setEnabled(false);
        bBtn.setEnabled(false);
        cBtn.setEnabled(false);
        dBtn.setEnabled(false);
        resultText.setTextColor(Color.parseColor("#FF0000"));
        resultText.setText("Your answer is incorrect!");
        answered++;
        score += 0;
    }

    public void dialog()
    {
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setCancelable(false);
        dialog.setTitle("Thank you for playing! \n Here are your results:");
        dialog.setMessage("You answered " + answered + " questions\n" +
                "Your score per questions answered is : " + (score/answered) * 100 + "\n" +
                "Your score of correct answers out of 10 is: " + (score/10) * 100 + ".");
        dialog.setPositiveButton("Reset", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                question = 1;
                score = 0;
                answered = 0;
                triviaQuestions();
            }
        })
                .setNegativeButton("Quit ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        question = 1;
                        score = 0;
                        answered = 0;
                        System.exit(0);
                    }
                })

                .setNeutralButton("Rate", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        // Create a alert dialog builder.
                        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        // Set icon value.
                        builder.setIcon(R.mipmap.ic_launcher);
                        // Set title value.
                        builder.setTitle("Thank you for playing!\nPlease Rate the App!");

                        // Get custom login form view.
                        final View customView = getLayoutInflater().inflate(R.layout.activity_rating, null);
                        // Set above view in alert dialog.
                        builder.setView(customView);
                        builder.setCancelable(true);

                        final AlertDialog alertdialog = builder.create();
                        alertdialog.show();
                    }
                });

        final AlertDialog alert = dialog.create();
        alert.show();
    }
}