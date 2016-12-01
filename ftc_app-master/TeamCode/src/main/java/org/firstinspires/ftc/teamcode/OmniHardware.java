package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by Graham Cooke on 10/4/2016.
 */
public class OmniHardware {


    public DcMotor FRight = null;
    public DcMotor BRight = null;
    public DcMotor FLeft = null;
    public DcMotor BLeft = null;
    public DcMotor Arm = null;
    public DcMotor Sweeper = null;

    HardwareMap hwMap = null;
    private ElapsedTime period = new ElapsedTime();

    public void init(HardwareMap ahwMap){

        hwMap = ahwMap;

        FRight = hwMap.dcMotor.get("front right motor");
        BRight = hwMap.dcMotor.get("back right motor");
        FLeft = hwMap.dcMotor.get("front left motor");
        BLeft = hwMap.dcMotor.get("back left motor");

        Arm = hwMap.dcMotor.get("arm motor");
        Sweeper = hwMap.dcMotor.get("sweeper motor");

        FRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        FLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Arm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        Sweeper.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);



        FRight.setPower(0);
        BRight.setPower(0);
        FLeft.setPower(0);
        BLeft.setPower(0);
        Arm.setPower(0);
        Sweeper.setPower(0);

    }


    public void waitForTick(long periodMs) throws InterruptedException{

        long remaining = periodMs - (long) period.milliseconds();

        if (remaining > 0){
            Thread.sleep(remaining);

            period.reset();
        }

    }

}
