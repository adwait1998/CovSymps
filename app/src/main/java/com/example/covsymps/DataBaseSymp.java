package com.example.covsymps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class DataBaseSymp extends AppCompatActivity {
    //EditText name_input,symptoms_input;
    Button addButtom;
    String []symplist = {"Fever","Runny Nose","Cough","Cold","Headache","Diarrhoea","SoreThroat","Muscle Ache","Nausea","Loss of Smell/Taste","Tired","Short Breath"};
    Spinner spin;
    RatingBar ratingBar;
    TextView tvRate;
    ArrayAdapter<String> adapter;
    String mysymptoms;
    String symp;
    HashMap<String,String> Final_list;
    String temp;
    String Fever;
    String Cold;
    String RN;
    String HA;
    String T;
    String ST;
    String MA;
    String N;
    String Di;
    String LSMT;
    String Cough;
    String SB;
    String RR;
    String HR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base_symp);
        spin = (Spinner)findViewById(R.id.spinner);
        ratingBar = (RatingBar)findViewById(R.id.ratingBar);
        tvRate = (TextView)findViewById(R.id.textViewRating);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,symplist);
        spin.setAdapter(adapter);
        Final_list = new HashMap<>();
        String TAG = "HASHOUTPUT";

        Covid_Symtoms_Spin covid_symtoms_spin = new Covid_Symtoms_Spin();
        covid_symtoms_spin.setCold(0.0f);
        covid_symtoms_spin.setFever(0.0f);
        covid_symtoms_spin.setRunnyNose(0.0f);
        covid_symtoms_spin.setHeadAche(0.0f);
        covid_symtoms_spin.setCough(0.0f);
        covid_symtoms_spin.setDiarrhoea(0.0f);
        covid_symtoms_spin.setHeartRate(0.0f);
        covid_symtoms_spin.setLossSmellTaste(0.0f);
        covid_symtoms_spin.setRespiratoryRate(0.0f);
        covid_symtoms_spin.setMuscleAche(0.0f);
        covid_symtoms_spin.setNausea(0.0f);
        covid_symtoms_spin.setShortBreath(0.0f);
        covid_symtoms_spin.setSoreThroat(0.0f);
        covid_symtoms_spin.setTired(0.0f);


        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean b) {
                tvRate.setText(mysymptoms + ":"+rating);
                if(mysymptoms.equals("Fever"))
                {
                    covid_symtoms_spin.setFever(rating);
                }
                if(mysymptoms.equals("Runny Nose")){
                    covid_symtoms_spin.setRunnyNose(rating);
                }
                if (mysymptoms.equals("Headache")){
                    covid_symtoms_spin.setHeadAche(rating);
                }
                if (mysymptoms.equals("Cold"))
                {
                    covid_symtoms_spin.setCold(rating);
                }
                if (mysymptoms.equals("Cough"))
                {
                    covid_symtoms_spin.setCough(rating);
                }
                if (mysymptoms.equals("Diarrhoea"))
                {
                    covid_symtoms_spin.setDiarrhoea(rating);
                }
                if (mysymptoms.equals("SoreThroat"))
                {
                    covid_symtoms_spin.setSoreThroat(rating);
                }
                if (mysymptoms.equals("Muscle Ache"))
                {
                    covid_symtoms_spin.setMuscleAche(rating);
                }
                if (mysymptoms.equals("Nausea"))
                {
                    covid_symtoms_spin.setNausea(rating);
                }
                if (mysymptoms.equals("Loss of Smell/Taste"))
                {
                    covid_symtoms_spin.setLossSmellTaste(rating);
                }
                if (mysymptoms.equals("Tired"))
                {
                    covid_symtoms_spin.setTired(rating);
                }
                if (mysymptoms.equals("Short Breath"))
                {
                    covid_symtoms_spin.setShortBreath(rating);
                }
                temp = String.valueOf(covid_symtoms_spin.getFever());
                Toast.makeText(DataBaseSymp.this,temp,Toast.LENGTH_SHORT).show();
            }
        });

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View view, int position, long l) {
                symp = adapter.getItemAtPosition(position).toString();
                Toast.makeText(DataBaseSymp.this,symp,Toast.LENGTH_SHORT).show();
                if(symp.equalsIgnoreCase("Select"))
                {

                }
                else
                {
                    mysymptoms = symp;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }



        });

        addButtom = findViewById(R.id.add_symptom);
        addButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Final_list.put("Fever",String.valueOf(covid_symtoms_spin.getFever()));
                Final_list.put("Runny Nose",String.valueOf(covid_symtoms_spin.getRunnyNose()));
                Final_list.put("Cold",String.valueOf(covid_symtoms_spin.getCold()));
                Final_list.put("HeadAche",String.valueOf(covid_symtoms_spin.getHeadAche()));
                Final_list.put("Diarrhoea",String.valueOf(covid_symtoms_spin.getDiarrhoea()));
                Final_list.put("SoreThroat",String.valueOf(covid_symtoms_spin.getSoreThroat()));
                Final_list.put("Muscle Ache",String.valueOf(covid_symtoms_spin.getMuscleAche()));
                Final_list.put("Nausea",String.valueOf(covid_symtoms_spin.getNausea()));
                Final_list.put("Loss of Smell/Taste",String.valueOf(covid_symtoms_spin.getLossSmellTaste()));
                Final_list.put("Tired",String.valueOf(covid_symtoms_spin.getTired()));
                Final_list.put("Short Breath",String.valueOf(covid_symtoms_spin.getShortBreath()));
                Final_list.put("Cough",String.valueOf(covid_symtoms_spin.getCough()));

                SQLiteHelper myDB = new SQLiteHelper(DataBaseSymp.this);
                Fever = Final_list.get("Fever");
                RN = Final_list.get("Runny Nose");
                Cold = Final_list.get("Cold");
                HA = Final_list.get("HeadAche");
                Cough = Final_list.get("Cough");
                Di = Final_list.get("Diarrhoea");
                ST = Final_list.get("SoreThroat");
                MA = Final_list.get("Muscle Ache");
                N = Final_list.get("Nausea");
                LSMT = Final_list.get("Loss of Smell/Taste");
                T = Final_list.get("Tired");
                SB = Final_list.get("Short Breath");


                myDB.addSymptoms(Fever,RN,Cold,HA,Cough,N,MA,ST,T,Di,SB,LSMT);

            }
        });

    }
}