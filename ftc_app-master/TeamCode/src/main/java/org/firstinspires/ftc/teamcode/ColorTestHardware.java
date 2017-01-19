package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by Graham Cooke on 9/28/2016.
 */
public class ColorTestHardware {

    HardwareMap hwMap = null;
    private ElapsedTime period = new ElapsedTime();

    public ColorTestHardware(){
    }

    public void init(HardwareMap ahwMap){

        hwMap = ahwMap;

    }


    public void waitForTick(long periodMs) throws InterruptedException{

        long remaining = periodMs - (long) period.milliseconds();

        if (remaining > 0){
            Thread.sleep(remaining);

            period.reset();
        }

    }
}

// stuff
