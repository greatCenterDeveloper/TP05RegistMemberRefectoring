package com.swj.tp05registmemberrefectoring;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.RadioButton;

import com.swj.tp05registmemberrefectoring.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        binding.btnRegist.setOnClickListener(view -> {
            String s = "";
            RadioButton rbGender =
                    findViewById(binding.rgGender.getCheckedRadioButtonId());
            RadioButton rbCity =
                    findViewById(binding.rgCity.getCheckedRadioButtonId());
            s += binding.name.getText().toString() + " ";
            s += rbGender.getText().toString() + " ";
            s += rbCity.getText().toString() + " ";
            s += binding.phone01.getText().toString() + "-";
            s += binding.phone02.getText().toString() + "-";
            s += binding.phone03.getText().toString() + " ";

            if(binding.cbEmail.isChecked())
                s += binding.cbEmail.getText().toString() + ",";

            if(binding.cbPhone.isChecked())
                s += binding.cbPhone.getText().toString() + ",";

            if(binding.cbVisit.isChecked())
                s += binding.cbVisit.getText().toString() + ",";

            if(binding.cbSms.isChecked())
                s += binding.cbSms.getText().toString();

            if(s.charAt(s.length()-1) == ',')
                s = s.substring(0, s.length()-1);

            s += "\n";

            binding.tvMemberList.append(s);

            binding.name.requestFocus();
            binding.name.setText("");
            binding.rgGender.clearCheck();
            binding.rgCity.clearCheck();
            binding.phone01.setText("");
            binding.phone02.setText("");
            binding.phone03.setText("");
            binding.cbEmail.setChecked(false);
            binding.cbPhone.setChecked(false);
            binding.cbVisit.setChecked(false);
            binding.cbSms.setChecked(false);

            getSystemService(InputMethodManager.class).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        });

        binding.phone01.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(
                    CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(
                    CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length() == 3) binding.phone02.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        binding.phone02.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(
                    CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(
                    CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length() == 4) binding.phone03.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
    }
}