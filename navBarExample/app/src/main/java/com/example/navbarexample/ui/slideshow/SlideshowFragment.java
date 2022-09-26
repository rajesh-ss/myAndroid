package com.example.navbarexample.ui.slideshow;

import static android.content.Context.MODE_PRIVATE;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
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
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.navbarexample.R;
import com.example.navbarexample.databinding.FragmentSlideshowBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.text.DateFormat;
import java.util.Calendar;

public class SlideshowFragment extends Fragment implements DatePickerDialog.OnDateSetListener{

    private FragmentSlideshowBinding binding;
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
    TextView tvDate;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView = binding.textSlideshow;
        //slideshowViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        radioGroup=(RadioGroup) getView().findViewById(R.id.radioGender);
        swPrime = (Switch) getView().findViewById(R.id.swPrime);

        b1 = (CheckBox) getView().findViewById(R.id.b1);
        b2 = (CheckBox) getView().findViewById(R.id.b2);

        btn= (FloatingActionButton) getView().findViewById(R.id.fab);
        tg = (ToggleButton) getView().findViewById(R.id.tg);
        picker=(DatePicker)getView().findViewById(R.id.getDOB);

        addr = (EditText) getView().findViewById(R.id.addr);

        spinner = (Spinner) getView().findViewById(R.id.states_spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
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

        chOne = new LinearLayout(getContext());
        chOne.setOrientation(LinearLayout.VERTICAL);
        CardView cd = new CardView(getContext());
        String res = "";



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RadioButton radioButton = (RadioButton) getView().findViewById(radioGroup.getCheckedRadioButtonId());
                AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
                StringBuilder builder=new StringBuilder();


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


                // Storing data into SharedPreferences
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MySharedPref",MODE_PRIVATE);

// Creating an Editor object to edit(write to the file)
                SharedPreferences.Editor myEdit = sharedPreferences.edit();

// Storing the key and its value as the data fetched from edittext
                myEdit.putString("Gender", radioButton.getText().toString());
                myEdit.putString("DOB", builder.toString().toString());
                myEdit.putString("Address", addr.getText().toString());
                myEdit.putInt("prime", Integer.parseInt(String.valueOf(swPrime.isChecked()?1:0)));

// Once the changes have been made,
// we need to commit to apply those changes made,
// otherwise, it will throw an error
                myEdit.commit();



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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar mCalendar = Calendar.getInstance();
        mCalendar.set(Calendar.YEAR, year);
        mCalendar.set(Calendar.MONTH, month);
        mCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String selectedDate = DateFormat.getDateInstance(DateFormat.FULL).format(mCalendar.getTime());
        tvDate.setText(selectedDate);
    }
}