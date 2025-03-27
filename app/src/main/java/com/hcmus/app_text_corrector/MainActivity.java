package com.hcmus.app_text_corrector;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    private static final int REQUEST_CODE = 99;
    private EditText studentText;
    private TextView correctedText;
    private Button submitBtn, clearBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentText = findViewById(R.id.editTextStudent);
        correctedText = findViewById(R.id.textViewCorrected);
        submitBtn = findViewById(R.id.btnSubmit);
        clearBtn = findViewById(R.id.btnClear);

        submitBtn.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, CorrectionActivity.class);
            intent.putExtra("student_text", studentText.getText().toString());
            startActivityForResult(intent, REQUEST_CODE);
        });

        clearBtn.setOnClickListener(view -> {
            studentText.setText("");
            correctedText.setText("");
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            String corrected = data.getStringExtra("corrected_text");
            correctedText.setText("GV sửa: " + corrected);
        }
    }
}
