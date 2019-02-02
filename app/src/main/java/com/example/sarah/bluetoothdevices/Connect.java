package com.example.sarah.bluetoothdevices;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Connect extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);
        textView=(TextView)findViewById(R.id.textView);

        Bundle b=getIntent().getExtras();
        String user =b.getString("name");
    //    String get= getIntent().getExtras().getString("EXTRA_ADDRESS");
        textView.setText(user);
    }
}
