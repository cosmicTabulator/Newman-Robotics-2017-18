package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by Graham Cooke on 9/28/2016.
 */
public class TankHardware {

    HardwareMap hwMap = null;
    private ElapsedTime period = new ElapsedTime();

    public DcMotor right = null;
    public DcMotor left = null;
    public DcMotor arm = null;
    public DcMotor belt = null;

    public TankHardware(){
    }

    public void init(HardwareMap ahwMap){

        hwMap = ahwMap;

        right = hwMap.dcMotor.get("right motor");
        left = hwMap.dcMotor.get("left motor");

        arm = hwMap.dcMotor.get("arm motor");

        belt = hwMap.dcMotor.get("belt motor");

        right.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        left.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        arm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        belt.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        right.setPower(0);
        left.setPower(0);
        arm.setPower(0);
        belt.setPower(0);

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
