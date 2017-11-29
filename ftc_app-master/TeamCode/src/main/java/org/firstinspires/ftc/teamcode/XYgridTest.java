package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

import java.lang.Math;



/**
 * Created by brendanmatulis on 11/15/17.
 */

//This program is for the autonomas phase
// It contains a orientation program and a drive forward program
// It uses dead reckoning, based on encoders data

@Autonomous(name = "xyGrid", group = "Tank")
public class XYgridTest extends LinearOpMode {

        static double distanceLeftY, distanceRightY, sonarDistanceX;
        static float rightMotor, leftMotor;

        //Wheel diameter, used to find circumference in CM
        static double diameter = 10.16;
        static double circumference = Math.PI * diameter;
        static double rotations = 0;
        static double totalDistance = circumference * rotations;

        TankHardwareSensors robot = new TankHardwareSensors();

        public static void orientateRobot() {

            //Orientates robot with respect to wall
            /*if (distanceLeftY > distanceRightY) {
                leftMotor += .05;
            } else if (distanceLeftY < distanceRightY) {
                rightMotor += .05;
            } else {
                //Go forwards
            } */

        };


        @Override
        public void runOpMode() throws InterruptedException {

            robot.init(hardwareMap);

            waitForStart();

            while (opModeIsActive()) {
                distanceLeftY = robot.distanceSensorLeftY.getDistance(DistanceUnit.CM);
                distanceRightY = robot.distanceSensorRightY.getDistance(DistanceUnit.CM);
                sonarDistanceX = robot.sonarSensorX.getUltrasonicLevel();

                robot.left.setPower(leftMotor);
                robot.right.setPower(rightMotor);

                rotations = robot.right.getCurrentPosition() / 1440;

                //If the robot travels 36" (94.44 cm) or more, robot stops
                //Goal is 36" from top left red start
                //This is the same for top right blue start
                //For the bottom red/blue starts, set distance to 60.98 CM (ie 24 in)...
                //Then, rotate robot 90 degrees and move forward 30.48 CM (ie 12 in)
                if (totalDistance >= 94.44) {
                    leftMotor = 0;
                    rightMotor = 0;
                }

                robot.waitForTick(10);
                idle();
            }
        }

}
