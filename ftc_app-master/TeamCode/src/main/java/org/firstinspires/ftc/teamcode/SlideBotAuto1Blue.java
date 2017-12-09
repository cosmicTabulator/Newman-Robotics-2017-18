package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cColorSensor;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by graha on 11/27/2017.
 */

@Autonomous(name = "SildeBotAutoBasic1Blue", group = "Slide")

public class SlideBotAuto1Blue extends LinearOpMode {

    SlideBotHardware robot = new SlideBotHardware();

    ModernRoboticsI2cColorSensor color;
    ModernRoboticsI2cGyro gyro;

    @Override
    public void runOpMode()throws InterruptedException{

        robot.init(hardwareMap);

        color = hardwareMap.get(ModernRoboticsI2cColorSensor.class, "color");
        gyro = hardwareMap.get(ModernRoboticsI2cGyro.class, "gyro");

        gyro.calibrate();

        waitForStart();

        robot.arm.setPosition(0.1);

        color.enableLed(true);

        wait(1000);

        if(color.blue() > color.red()){

            turn(-90);

        }
        else{

            turn(90);
        }

        robot.left.setPower(0);
        robot.right.setPower(0);

    }

    public void wait(int ticks)throws InterruptedException{

        Thread.sleep(ticks);

    }

    public void turn(int degrees){
        int inititalHeading = gyro.getHeading();
        if(degrees > 0){
            while(gyro.getHeading() < (degrees + inititalHeading)){
                robot.right.setPower(-0.5);
                robot.left.setPower(0.5);
            }
        }
        else{
            while(gyro.getHeading() > (degrees + inititalHeading)) {
                robot.right.setPower(0.5);
                robot.left.setPower(-0.5);
            }
        }

        robot.right.setPower(0);
        robot.left.setPower(0);

    }
}


