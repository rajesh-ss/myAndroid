package com.example.myapplication;

import static android.content.ContentValues.TAG;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity5 extends AppCompatActivity {


    ScrollView par;
    LinearLayout chOne;
    RadioButton genderradioButton;
    RadioGroup radioGroup;
    Switch swPrime;
    FloatingActionButton btn;
    ConstraintLayout layout;
    CheckBox b1,b2;
    ToggleButton tg;
    DatePicker picker;
    Spinner spinner;
    EditText addr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        //par = (ScrollView) findViewById(R.id.par);

        radioGroup=(RadioGroup)findViewById(R.id.radioGender);
        swPrime = (Switch) findViewById(R.id.swPrime);

        b1 = (CheckBox) findViewById(R.id.b1);
        b2 = (CheckBox) findViewById(R.id.b2);

        btn= (FloatingActionButton) findViewById(R.id.fab);
        tg = (ToggleButton) findViewById(R.id.tg);
        picker=(DatePicker)findViewById(R.id.getDOB);

        addr = (EditText) findViewById(R.id.addr);

        spinner = (Spinner) findViewById(R.id.states_spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(MainActivity5.this,
                R.array.states_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        // switch view
        swPrime.setShowText(true);
        swPrime.setChecked(true);

        chOne = new LinearLayout(this);
        chOne.setOrientation(LinearLayout.VERTICAL);
        CardView cd = new CardView(this);
        String res = "";



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RadioButton radioButton = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
                AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity5.this);
                StringBuilder builder=new StringBuilder();;
                builder.append((picker.getMonth() + 1)+"/");//month is 0 based
                builder.append(picker.getDayOfMonth()+"/");
                builder.append(picker.getYear());




                if(swPrime.isChecked()){
                    builder1.setTitle("Prime User: The details are");
                }
                else{
                    builder1.setTitle("Non Prime User: The details are");
                }

                String res = "";

                res += "Gender: "+radioButton.getText()+"\n";
                res +="Primary email: ";
                if(b1.isChecked()) {
                    res+=b1.getText();
                    res+="\n";
                }
                if(b2.isChecked()){
                    res+=b2.getText();
                    res+="\n";
                }

                res+= "Profile Visibility: "+tg.getText();
                res+="\n";

                res+="Your Date of birth is: ";
                res+=builder.toString();
                res+="\n";

                res+="State: "+String.valueOf(spinner.getSelectedItem());
                res+="\n";
                res+="Address: "+addr.getText().toString();





                builder1.setMessage(res);



                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Confirm",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                dialog.cancel();

                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();

            }
        });

    }

    public void onclickbuttonMethod(View v){
        int selectedId = radioGroup.getCheckedRadioButtonId();
        genderradioButton = (RadioButton) findViewById(selectedId);
        if(selectedId==-1){
            Toast.makeText(MainActivity5.this,"Nothing selected", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(MainActivity5.this,genderradioButton.getText(), Toast.LENGTH_SHORT).show();
        }

    }

}