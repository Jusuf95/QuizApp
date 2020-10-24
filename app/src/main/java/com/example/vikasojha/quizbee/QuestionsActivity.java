package com.example.vikasojha.quizbee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionsActivity extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
                            "Tko se izvrgava opasnosti za drugoga, taj vadi kestene iz...",
                            "Nakon odsviranog koncerta gotovo uvijek slijedi...",
                            "Koji biser Jadrana nije nacionalni park?",
                            "Kojoj vrsti riječi pripada riječ oblačan?",
                            "Koji je auto 1991. u Osjeku stradao pod gusjenicama tenka?",
                            "Drugi dio kog filmskog serijala je poznat pod nazivom \"Drumski ratnik\"?",
                            "Novac na bankomatu nećete moći podignuti ako ste zaboravili...",
                            "Koji od kemijskih elemenata nije nazvan po nobelovcu?",
                            "Koji je Imoćanin rođen u Splitu proslavio Pulu?",
                            "Kako se zove album Dina Dvornika iz 1993. godine?"
                         };
    String answers[] = {"vatre","fis","Biševo","pridjevima","fićo","Pobješnjeli Max","pin","nobelj","Mate Parlov","Priroda i društvo"};
    String opt[] = {
                    "vatre","šume","vode","nabujale rijeke",
                    "cis","dis","fis","bis",
                    "Brijuni","Biševo","Kornat","Mljet",
                    "pridjevima","prijedlozima","prilozima","imenicama",
                    "peglica","fićo","buba","spaček",
                    "Pobješnjeli Max","Smrtonosno oružje","Umri muški","Terminator",
                    "pen","puk","pin","tan",
                    "ajnštajnij","fermij","kirij","nobelj",
                    "Marijan beneš","Mate Parlov","Antun Josipović","Željko Mavrović",
                     "Matematika","Zemljopis","Priroda i društvo","Tjelesni odgoj"
                   };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        final TextView score = (TextView)findViewById(R.id.textView4);
        TextView textView=(TextView)findViewById(R.id.DispName);
        Intent intent = getIntent();
        String name= intent.getStringExtra("myname");

        if (name.trim().equals(""))
            textView.setText("Hello User");
        else
        textView.setText("Hello " + name);

        submitbutton=(Button)findViewById(R.id.button3);
        quitbutton=(Button)findViewById(R.id.buttonquit);
        tv=(TextView) findViewById(R.id.tvque);

        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if(ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null)
                    score.setText(""+correct);

                if(flag<questions.length)
                {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                }
                else
                {
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),ResultActivity.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ResultActivity.class);
                startActivity(intent);
            }
        });
    }

}