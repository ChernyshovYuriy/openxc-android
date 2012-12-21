package com.openxc.it.interfaces.bluetooth;

import android.test.AndroidTestCase;
import android.test.suitebuilder.annotation.SmallTest;

import com.openxc.interfaces.bluetooth.BluetoothVehicleInterface;
import com.openxc.sources.DataSourceException;

public class BluetoothVehicleInterfaceTest extends AndroidTestCase {
    String macAddress = "00:00:00:00:00:00";
    BluetoothVehicleInterface source;

    @Override
    protected void tearDown() throws Exception {
        if(source != null) {
            source.stop();
        }
        super.tearDown();
    }

    @SmallTest
    public void testValidaddress() throws DataSourceException {
        source = new BluetoothVehicleInterface(getContext(), macAddress);
    }

    @SmallTest
    public void testResourceMatching() throws DataSourceException {
        source = new BluetoothVehicleInterface(getContext(), macAddress);
        assertTrue(source.sameResource(macAddress));
    }
}
