package com.example.sarah.bluetoothdevices;


import android.bluetooth.BluetoothSocket;
import android.os.Handler;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public  class ConnectedThread extends Thread {
     BluetoothSocket socket;
     InputStream inputStream;
     OutputStream outputStream;

     public ConnectedThread(BluetoothSocket socket)
     {
         this.socket=socket;
         InputStream in=null;
         OutputStream out=null;

         try{
              in=socket.getInputStream();
              out=socket.getOutputStream();
         }
         catch(IOException e){}
         inputStream=in;
         outputStream=out;
     }

     public void recieve(){
          byte[]buffer=new byte[1000];
          int bytes;

          while (true){
               try{
                    bytes=inputStream.read(buffer);
                    Handler handler = null;
                    handler.obtainMessage(1,bytes,-1,buffer).sendToTarget();
               }catch (IOException e){break;}
          }
     }

}
