package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.Hardware;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsDigitalTouchSensor;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;

/**
 * Created by Graham Cooke on 10/11/2016.
 */

@Autonomous(name = "OmniAuto", group = "Omni")

public class OmniAuto extends LinearOpMode{

    OmniHardware robot = new OmniHardware();
    ModernRoboticsDigitalTouchSensor touch = null;
    ModernRoboticsI2cGyro gyro = null;

    @Override
    public void runOpMode() throws InterruptedException {

        robot.init(hardwareMap);
        touch = (ModernRoboticsDigitalTouchSensor)hardwareMap.touchSensor.get("Touch sensor");
        gyro = (ModernRoboticsI2cGyro)hardwareMap.gyroSensor.get("gyro");

        waitForStart();

        while(opModeIsActive()){


            gyro.getHeading();

            if(touch.isPressed()){

            }

            robot.waitForTick(20);

            idle();
        }

    }

    void moveD(double angle, double speed, long distance) throws InterruptedException{

        //find our position before moving
        long startL = robot.FRight.getCurrentPosition();
        long startR = robot.FLeft.getCurrentPosition();

        double fright;
        double bright;
        double fleft;
        double bleft;

        double pos = 0;
        long rpos;
        long lpos;
        double x1;
        double x2;
        double y1;
        double y2;
        double xf;
        double yf;

        //calculate the and and y powers from the desired angle of motion
        double y = Math.sin(angle);
        double x = Math.cos(angle);
        x = speed*x;
        y = speed*y;


        //calculate the motor powers
        fright = -x + y;
        bright = x + y;
        fleft = -x - y;
        bleft = x - y;

        //print the motor powers to the phones
        telemetry.addData("Front Right", fright);
        telemetry.addData("Back Right", bright);
        telemetry.addData("Front Left", fleft);
        telemetry.addData("Back Left", bleft);
        telemetry.update();

        //power the motors
        robot.FRight.setPower(fright);
        robot.BRight.setPower(bright);
        robot.FLeft.setPower(fleft);
        robot.BLeft.setPower(bleft);


        //while the distance travelled has not surpassed the target
        while(distance < pos){

            //get encoder values(by subtracting the values before we started moving)
            rpos = robot.FRight.getCurrentPosition() - startR;
            lpos = robot.FLeft.getCurrentPosition() - startL;

            //get the x and y parts of each motor vector
            x1 = -rpos/Math.sqrt(2);
            y1 = rpos/Math.sqrt(2);
            x2 = -lpos/Math.sqrt(2);
            y2 = -lpos/Math.sqrt(2);

            //add the vectors
            xf = x1 + x2;
            yf = y1 + y2;

            //calculate the magnitude of the final vector
            pos = Math.sqrt(Math.pow(xf, 2) + Math.pow(yf, 2));

        }

        //stop the motors
        robot.FRight.setPower(0);
        robot.BRight.setPower(0);
        robot.FLeft.setPower(0);
        robot.BLeft.setPower(0);
    }

    void moveT(double theta, double r, long t) throws InterruptedException{

        double fright;
        double bright;
        double fleft;
        double bleft;

        //calculate the x and y powers based on the angle of motion
        double y = Math.sin(theta);
        double x = Math.cos(theta);
        x = r*x;
        y = r*y;

        //calculate the motor powers
        fright = -x + y;
        bright = x + y;
        fleft = -x - y;
        bleft = x - y;

        //print the motor powers to the phone
        telemetry.addData("Front Right", fright);
        telemetry.addData("Back Right", bright);
        telemetry.addData("Front Left", fleft);
        telemetry.addData("Back Left", bleft);
        telemetry.update();

        //power the motors
        robot.FRight.setPower(fright);
        robot.BRight.setPower(bright);
        robot.FLeft.setPower(fleft);
        robot.BLeft.setPower(bleft);

        //wait for the desired time
        Thread.sleep(t);

        //stop the motors
        robot.FRight.setPower(0);
        robot.BRight.setPower(0);
        robot.FLeft.setPower(0);
        robot.BLeft.setPower(0);
    }
}
