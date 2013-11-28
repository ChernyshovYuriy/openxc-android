package com.openxc.measurements;

import com.openxc.units.Level;
import com.openxc.util.Range;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 11/28/13
 * Time: 11:39 AM
 */
public class AudioVolume extends BaseMeasurement<Level> {

    private final static Range<Level> RANGE = new Range<Level>(new Level(0), new Level(30));
    public final static String ID = "audio_volume_level";

    public AudioVolume(Number value) {
        super(new Level(value), RANGE);
    }

    public AudioVolume(Level value) {
        super(value, RANGE);
    }

    @Override
    public String getGenericName() {
        return ID;
    }
}