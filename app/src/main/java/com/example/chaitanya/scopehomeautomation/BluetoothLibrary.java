package com.example.chaitanya.scopehomeautomation;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.util.Set;

/**
 * Created by chaitanya on 10/05/16.
 */
public class BluetoothLibrary extends AsyncTask<String, String, BluetoothSocket> {

    public CommunicationService communicationService;
    private ConnectThread connectThread;

    public static BluetoothDevice checkPairedDevices() {

        return null;
    }


    @Override
    protected BluetoothSocket doInBackground(String... params) {

        BluetoothAdapter bluetooth = BluetoothAdapter.getDefaultAdapter()
        Set<BluetoothDevice> pairedDevices = bluetooth.getBondedDevices();

        if (pairedDevices.size() > 0) {
            for (BluetoothDevice device : pairedDevices) {
                if (device.getName().equalsIgnoreCase("HC-05")) {
                    Log.d("FOUND DEVICE --------", device.getName());
                    connectThread = new ConnectThread(device);
                    connectThread.run();
                    return connectThread.getSocket();
                }
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(BluetoothSocket socket) {
        super.onPostExecute(socket);
        Log.d("ON POST EXECUTE", "----SOCKET RECIEVED-------\n\n\n\n");
        communicationService.communicateWithDevice(socket);
    }

}
