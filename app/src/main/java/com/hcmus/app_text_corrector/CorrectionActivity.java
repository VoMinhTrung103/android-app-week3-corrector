package com.hcmus.app_text_corrector;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hcmus.app_text_corrector.R;

public class CorrectionActivity extends Activity {
    private EditText correctedText;
    private Button correctBtn, resetBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correction);

        correctedText = findViewById(R.id.editTextCorrected);
        correctBtn = findViewById(R.id.btnCorrect);
        resetBtn = findViewById(R.id.btnReset);

        String studentText = getIntent().getStringExtra("student_text");
        correctedText.setText(studentText);

        correctBtn.setOnClickListener(view -> {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("corrected_text", correctedText.getText().toString());
            setResult(Activity.RESULT_OK, resultIntent);
            finish();
        });

        resetBtn.setOnClickListener(view -> correctedText.setText(studentText));
    }
}
