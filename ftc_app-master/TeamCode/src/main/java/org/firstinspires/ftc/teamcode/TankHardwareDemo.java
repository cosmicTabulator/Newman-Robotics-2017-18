package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by Graham Cooke on 9/28/2016.
 */
public class TankHardwareDemo {

    public DcMotor right = null;
    public DcMotor left = null;


    HardwareMap hwMap = null;
    private ElapsedTime period = new ElapsedTime();

    public TankHardwareDemo(){
    }

    public void init(HardwareMap ahwMap){

        hwMap = ahwMap;

        right = hwMap.dcMotor.get("Right");
        left = hwMap.dcMotor.get("Left");

        right.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        left.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        right.setDirection(DcMotor.Direction.REVERSE);

        right.setPower(0);
        left.setPower(0);

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
