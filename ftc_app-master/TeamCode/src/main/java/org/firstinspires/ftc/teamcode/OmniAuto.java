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

            if(touch.isPressed() == true){

            }

            robot.waitForTick(20);

            idle();
        }

    }

    void moveD(double theta, double r, long d) throws InterruptedException{

        double fright;
        double bright;
        double fleft;
        double bleft;

        double pos = 0;
        long rpos;
        long lpos;
        double x1 = 0;
        double x2 = 0;
        double y1 = 0;
        double y2 = 0;
        double xf = 0;
        double yf = 0;

        double y = Math.sin(theta);
        double x = Math.cos(theta);
        x = r*x;
        y = r*y;


        fright = -x + y;
        bright = x + y;
        fleft = -x - y;
        bleft = x - y;

        telemetry.addData("Front Right", fright);
        telemetry.addData("Back Right", bright);
        telemetry.addData("Front Left", fleft);
        telemetry.addData("Back Left", bleft);
        telemetry.update();

        robot.FRight.setPower(fright);
        robot.BRight.setPower(bright);
        robot.FLeft.setPower(fleft);
        robot.BLeft.setPower(bleft);

        while(d < pos){

            rpos = robot.FRight.getCurrentPosition();
            lpos = robot.FLeft.getCurrentPosition();

            x1 = rpos/(1/Math.sqrt(2));
            y1 = rpos/(1/Math.sqrt(2));
            x2 = lpos/(1/Math.sqrt(2));
            y2 = lpos/(1/Math.sqrt(2));

            xf = x1 + x2;
            yf = y1 + y2;

            pos = Math.sqrt(Math.pow(xf, 2) + Math.pow(yf, 2));

        }

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

        double y = Math.sin(theta);
        double x = Math.cos(theta);
        x = r*x;
        y = r*y;


        fright = -x + y;
        bright = x + y;
        fleft = -x - y;
        bleft = x - y;

        telemetry.addData("Front Right", fright);
        telemetry.addData("Back Right", bright);
        telemetry.addData("Front Left", fleft);
        telemetry.addData("Back Left", bleft);
        telemetry.update();

        robot.FRight.setPower(fright);
        robot.BRight.setPower(bright);
        robot.FLeft.setPower(fleft);
        robot.BLeft.setPower(bleft);

        Thread.sleep(t);

        robot.FRight.setPower(0);
        robot.BRight.setPower(0);
        robot.FLeft.setPower(0);
        robot.BLeft.setPower(0);
    }
}
