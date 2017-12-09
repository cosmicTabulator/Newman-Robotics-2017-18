package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by Graham Cooke on 9/28/2016.
 */
public class SlideBotHardware {

    public DcMotor right = null;
    public DcMotor left = null;
    public DcMotor slide = null;

    public Servo latchUp = null;
    public Servo latchDown = null;

    public Servo arm = null;

    HardwareMap hwMap = null;
    private ElapsedTime period = new ElapsedTime();

    public SlideBotHardware(){
    }

    public void init(HardwareMap ahwMap){

        hwMap = ahwMap;

        right = hwMap.dcMotor.get("Right");
        left = hwMap.dcMotor.get("Left");
        slide = hwMap.dcMotor.get("Slide");

        latchUp = hwMap.servo.get("LatchUp");
        latchDown = hwMap.servo.get("LatchDown");

        arm = hwMap.servo.get("Arm");

        right.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        left.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        slide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        right.setDirection(DcMotor.Direction.REVERSE);

        right.setPower(0);
        left.setPower(0);
        slide.setPower(0);

        latchUp.setPosition(0);
        latchDown.setPosition(1);

        arm.setPosition(0.6);

    }


    public void waitForTick(long periodMs) throws InterruptedException{

        long remaining = periodMs - (long) period.milliseconds();

        if (remaining > 0){
            Thread.sleep(remaining);

            period.reset();
        }

    }
}