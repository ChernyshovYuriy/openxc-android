package com.openxc.measurements;

import java.util.Locale;

import com.openxc.units.State;

import com.openxc.units.Boolean;

/**
 * A DoorStatus represents a door's ajar status.
 *
 * This measurement is only valid when used asynchronously, much like any other
 * key or button event in Java. An application registers to receive button
 * events, and decides what to do based on the returned ButtonId and
 * ButtonAction.
 *
 * TODO would you want to be able to query for a specific door's state
 * synchronously?
 */
public class VehicleDoorStatus
        extends BaseMeasurement<State<VehicleDoorStatus.DoorId>> {
    public final static String ID = "door_status";

    /**
     * The DoorId is the specific door of the vehicle.
     */
    public enum DoorId {
        DRIVER,
        PASSENGER,
        REAR_LEFT,
        REAR_RIGHT,
        BOOT
    }

    public VehicleDoorStatus(State<DoorId> value) {
        // TODO refactor to use a map instead of old-style event
        super(value);
    }

    public VehicleDoorStatus(DoorId value) {
        // TODO refactor to use a map instead of old-style event
        this(new State<DoorId>(value));
    }

    public VehicleDoorStatus(String value) {
        this(DoorId.valueOf(value.toUpperCase(Locale.US)));
    }

    @Override
    public String getSerializedValue() {
        return getValue().enumValue().toString();
    }

    @Override
    public String getGenericName() {
        return ID;
    }
}
