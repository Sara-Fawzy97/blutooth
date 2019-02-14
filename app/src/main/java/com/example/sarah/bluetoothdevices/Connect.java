package com.example.sarah.bluetoothdevices;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.UUID;

public class Connect extends AppCompatActivity {

    TextView textView;
    Button ledOn,ledOff;
String address=null;
BluetoothAdapter myBluetooth;
BluetoothSocket btSocket;
static final UUID myUUID =UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);
        textView=(TextView)findViewById(R.id.textView);
        ledOn=findViewById(R.id.on);
        ledOff=findViewById(R.id.off);

        //recieve the address from bluetooth device
       Bundle b=getIntent().getExtras();
        String user =b.getString("Extra_Adress");

        //Intent ne=getIntent();
       // address= ne.getStringExtra(MainActivity.);
    }


    public void led_on(View view){
        send("on");
    }
    public void led_off(View view){
        send("of");
    }


    private void send(String s )
{
    if(btSocket!=null){
      try{  btSocket.getOutputStream().write(s.toString().getBytes());
    } catch (IOException e)
      { Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();}
    }
}

 public void fan_on(View view)
 {send("fo");
 }
    public void fan_off(View view)
    {send("ff");
    }


}



