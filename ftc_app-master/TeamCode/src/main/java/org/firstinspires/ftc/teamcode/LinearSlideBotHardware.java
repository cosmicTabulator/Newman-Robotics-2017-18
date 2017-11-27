package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by Graham Cooke on 9/28/2016.
 */
public class LinearSlideBotHardware {

    public DcMotor right = null;
    public DcMotor left = null;
    public DcMotor LinSlide = null;

    public Servo right_grabber = null;
    public Servo left_grabber = null;


    HardwareMap hwMap = null;
    private ElapsedTime period = new ElapsedTime();

    public LinearSlideBotHardware(){
    }

    public void init(HardwareMap ahwMap){

        hwMap = ahwMap;

        right = hwMap.dcMotor.get("Right");
        left = hwMap.dcMotor.get("Left");
        LinSlide = hwMap.dcMotor.get("Belt");

        right_grabber = hwMap.servo.get("Latch");

        right.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        left.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        LinSlide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        right.setDirection(DcMotor.Direction.REVERSE);

        right.setPower(0);
        left.setPower(0);
        LinSlide.setPower(0);

        right_grabber.setPosition(0);
        left_grabber.setPosition(0);
        right_grabber.scaleRange(0, 0.5);
        left_grabber.scaleRange(0, 0.5);

    }


    public void waitForTick(long periodMs) throws InterruptedException{

        long remaining = periodMs - (long) period.milliseconds();

        if (remaining > 0){
            Thread.sleep(remaining);

            period.reset();
        }

    }
}