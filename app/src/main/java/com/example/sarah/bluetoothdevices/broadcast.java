package com.example.sarah.bluetoothdevices;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;

public class broadcast extends BroadcastReceiver {
    ArrayAdapter adapter;
    @Override
    public void onReceive(Context context, Intent intent) {
        String action=intent.getAction();
        if(BluetoothDevice.ACTION_FOUND.equals(action)) {
            BluetoothDevice bd = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);

    }
}}
