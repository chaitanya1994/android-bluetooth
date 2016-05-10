package com.example.chaitanya.scopehomeautomation;

import android.bluetooth.BluetoothSocket;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CommunicationService {

    private BluetoothLibrary bluetoothLibrary;
    private ConnectedThread connectedThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bluetoothLibrary = new BluetoothLibrary();
        String param = "Hello";
        bluetoothLibrary.execute(param);
    }

    public void toggleBulb(View view) {
        //Do Something with the connected thread
    }

    @Override
    public void communicateWithDevice(BluetoothSocket socket) {
        Toast.makeText(MainActivity.this, "Connection Established", Toast.LENGTH_SHORT).show();
        connectedThread = new ConnectedThread(socket);
        connectedThread.start();
        findViewById(R.id.bluetooth_image).setVisibility(View.VISIBLE);
    }
}
