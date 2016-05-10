package com.example.chaitanya.scopehomeautomation;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;

/**
 * Created by chaitanya on 10/05/16.
 */
public interface CommunicationService {

    void communicateWithDevice(BluetoothSocket socket);
}
