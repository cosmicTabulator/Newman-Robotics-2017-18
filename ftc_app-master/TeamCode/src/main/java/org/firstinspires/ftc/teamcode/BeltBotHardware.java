package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by Graham Cooke on 9/28/2016.
 */
public class BeltBotHardware {

    public DcMotor right = null;
    public DcMotor left = null;
    public DcMotor belt = null;

    public Servo latch = null;


    HardwareMap hwMap = null;
    private ElapsedTime period = new ElapsedTime();

    public BeltBotHardware(){
    }

    public void init(HardwareMap ahwMap){

        hwMap = ahwMap;

        right = hwMap.dcMotor.get("Right");
        left = hwMap.dcMotor.get("Left");
        belt = hwMap.dcMotor.get("Belt");

        latch = hwMap.servo.get("Latch");

        right.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        left.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        belt.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        right.setDirection(DcMotor.Direction.REVERSE);

        right.setPower(0);
        left.setPower(0);
        belt.setPower(0);

        latch.setPosition(0);
        latch.scaleRange(0, 0.5);

    }


    public void waitForTick(long periodMs) throws InterruptedException{

        long remaining = periodMs - (long) period.milliseconds();

        if (remaining > 0){
            Thread.sleep(remaining);

            period.reset();
        }

    }
}