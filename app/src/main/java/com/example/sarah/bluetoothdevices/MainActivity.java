package com.example.sarah.bluetoothdevices;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Set;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {


    Button addDevices;
    BluetoothAdapter blue;
    ListView list,list2;
    TextView paired,discover;
    BluetoothSocket socket;
 ArrayAdapter<String> adapter;
    String EXTRA_ADDRESS="address";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        addDevices= findViewById(R.id.add);
        list=(ListView)findViewById(R.id.list);
        list2=(ListView)findViewById(R.id.list2);
        paired=(TextView) findViewById(R.id.paired);
        discover=(TextView) findViewById(R.id.discover);
        blue=BluetoothAdapter.getDefaultAdapter();
     //   OutputStream outputStream = socket.getOutputStream();
        pairedDevices();


    }

    public void pairedDevices ()
    {
        //to open bluetooth
        if (!blue.isEnabled())
        { Intent enableBT= new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivity(enableBT);
        }
        else {
            //to pair devices
            Set<BluetoothDevice> bondedDevices = blue.getBondedDevices();
            String []arrayList=new String [bondedDevices.size()];
            int i=0; //index of array
                paired.setText("Paired Devices:");
            for (BluetoothDevice device : bondedDevices) {
                arrayList[i]=device.getName();
                i++;
            }
            adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, arrayList);
            list.setAdapter(adapter);
            list.setOnItemClickListener(clickListener);

        }
    }
    AdapterView.OnItemClickListener clickListener= new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
           // get device mac address
            String in =((TextView) view).getText().toString();
           String ad=in.substring((in.length())-17);
          Intent intent= new Intent(MainActivity.this,Connect.class);
            //new activity will recieve that
          intent.putExtra(EXTRA_ADDRESS,ad);
 //Bundle b= new Bundle();
 //b.putString("name","sara");
 //intent.putExtras(b);
          startActivity(intent);
        }
    };


    //  هنا عشان يعمل scan على الاجهزة كنت بحاول اجرب ومكنش بيظبط  hna kont b7awl 3shan y3ml scan w mknsh by3ml
  public void add_devices(View view)
  { blue.startDiscovery();
      IntentFilter intentFilter=new IntentFilter(BluetoothDevice.ACTION_FOUND);
      registerReceiver(br,intentFilter);

      BroadcastReceiver br=new BroadcastReceiver() {
          @Override
          public void onReceive(Context context, Intent intent) {

              String action=intent.getAction();
              if(BluetoothDevice.ACTION_FOUND.equals(action))
              {
                  BluetoothDevice bd=intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                  //  Log.i("","Device "+bd.getName());
                  adapter.add(bd.getName());
                  list2.setAdapter(adapter);
                  //  list2.setAdapter(adapter);
                  //   Toast.makeText(getApplicationContext(),bd.getName(),Toast.LENGTH_LONG).show();
                  // blue.cancelDiscovery();
              }
          }};

  }






}
