package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import java.lang.Math;

/**
 * Created by Graham Cooke on 10/4/2016.
 */

@TeleOp(name = "OmniTeleop", group = "Omni")

public class OmniTeleOp extends LinearOpMode {

    OmniHardware robot = new OmniHardware();
    //ModernRoboticsI2cGyro gyro = null;

    @Override
    public void runOpMode() throws InterruptedException {

        //Define variables for program
        double fright;
        double bright;
        double fleft;
        double bleft;

        double arm;

        double y;
        double x;
        double r;
        double rot;
        double theta;

        //Initialize the robot
        robot.init(hardwareMap);
        //gyro = (ModernRoboticsI2cGyro)hardwareMap.gyroSensor.get("gyro");

        waitForStart();
        double totalrotval = 0;

        //While the OpMode is running
        while(opModeIsActive()){

            //Gets x and y values from the joystick

            y = -gamepad1.left_stick_y;
            x = gamepad1.left_stick_x;
            rot = gamepad1.right_stick_x;

            //If the distance from the center to the joystick is greater than one
            // shrink the relative x and y sizes so that the distance is one
            //totalrotval = gyro.getHeading();
            r = Math.sqrt((y*y) + (x*x));
            if (r > 1){
                theta = Math.atan(y / x);
                if (x < 0 && y < 0){theta = theta-Math.PI;}
                if (x < 0 && y > 0){theta = theta+Math.PI;}
                //i added these values here to change our reference direction
                y = Math.sin(theta + (totalrotval * Math.PI/180));
                x = Math.cos(theta + (totalrotval * Math.PI/180));
            }


            fright = -x + y - rot;
            bright = x + y - rot;
            fleft = - x - y - rot;
            bleft = x - y - rot;

            //Display the motor powers
            telemetry.addData("Front Right", fright);
            telemetry.addData("Back Right", bright);
            telemetry.addData("Front Left", fleft);
            telemetry.addData("Back Left", bleft);
            //telemetry.addData("Arm", arm);
            telemetry.update();


            //Set the motor powers to the computed ones
            robot.FRight.setPower(fright);
            robot.BRight.setPower(bright);
            robot.FLeft.setPower(fleft);
            robot.BLeft.setPower(bleft);
            //robot.Arm.setPower(arm);

            //Wait until current cycle has finished
            robot.waitForTick(20);

            idle();

        }

    }

}

