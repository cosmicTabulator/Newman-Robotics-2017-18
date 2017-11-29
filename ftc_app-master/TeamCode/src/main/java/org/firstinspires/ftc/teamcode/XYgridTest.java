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

//This program is for the autonomous phase
// It contains a orientation program and a drive forward program
// It uses dead reckoning, based on encoders data


@Autonomous(name = "xyGrid", group = "Tank")
public class XYgridTest extends LinearOpMode {

        static double distanceLeftY, distanceRightY, sonarDistanceX;
        static float rightMotor, leftMotor;

        //Wheel diameter, used to find circumference in CM
        final static double inchToCM = 2.54; //Conversion factor of 1 inch to 2.54 CM

        static double diameter = 10.16;
        static double wheelCircumference = Math.PI * diameter;
        static double encoderValue;
        static double numRotations;
        static double totalDistance = circumference * numRotations;


        //inchToCm conversion factor convers inches to CM
        //Robot width used to calculate rotations needed for a turn
        static double widthRobot = 40 * inchToCm; //40 inches


        // 1/4th  of circumference (C=pi*diameter)
        //Distance travelled by wheels when turning
        //Used to calculate number of rotations for turning 90 degrees
        double rightAngleTurnDistance = (Math.PI * widthRobot) / 4;
        double rightAngleTurnRotations = rightAngleTurnDistance / wheelCircumference;


        TankHardwareSensors robot = new TankHardwareSensors();

        public static void orientateRobot() {

            //Orientates robot with respect to wall
            if (distanceLeftY > distanceRightY) {
                leftMotor += .05;
            } else if (distanceLeftY < distanceRightY) {
                rightMotor += .05;
            } else {
                //Go forwards
            }

        }

        public static void rotate_90_degrees_clockwise() {

            final double initial_NumRotations = numRotations;
            while (change_in_numRotations < rightAngleTurnRotations) {
                encoderValue = robot.right.getCurrentPosition();
                numRotations = encoderValue / 1440;

                double change_in_numRotations = numRotations - initial_NumRotations;

                leftMotor = 0.5;
                rightMotor = -0.5;
            }
            rightMotor = 0.0;
            leftMotor = 0.0;
        }

    public static void rotate_90_degrees_anticlockwise() {

        final double initial_NumRotations = numRotations;
        while (change_in_numRotations < rightAngleTurnRotations) {
            encoderValue = robot.right.getCurrentPosition();
            numRotations = encoderValue / 1440;

            double change_in_numRotations = numRotations - initial_NumRotations;

            leftMotor = -0.5;
            rightMotor = 0.5;
        }
        rightMotor = 0.0;
        leftMotor = 0.0;
    }

    public static void top_left_red_check1() {
        //If the robot travels 36" (94.44 cm) or more, robot stops
        //Goal is 36" from top left red start
        //This is the same for top right blue start
        //For the bottom red/blue starts, set distance to 60.98 CM (ie 24 in)...
        //Then, rotate robot 90 degrees and move forward 30.48 CM (ie 12 in)
        if (totalDistance >= 36 * inchToCm) {
            //Stops robot once robot has traveled 36" or more
            leftMotor = 0;
            rightMotor = 0;
        }
        // turns towards goal
        rotate_90_degrees_anticlockwise();
    }

    public static void top_right_blue_check1() {
        if (totalDistance >= 36 * inchToCm) {
            //Stops robot once robot has traveled 36" or more
            leftMotor = 0;
            rightMotor = 0;
        }

        //turns towards goal
        rotate_90_degrees_clockwise();
    }

    public static void bottom_left_red_check1() {
        if (totalDistance >= 24 * inchToCM) {
            leftMotor = 0;
            rightMotor = 0;

            rotate_90_degrees_clockwise();
        }
    }

    public static void bottom_left_red_check2() {
            //should check to see if it moves another 12 inches and then turn towards goal
            //note: should find change in rotations for the 12 inches
    }

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

                encoderValue = robot.right.getCurrentPosition();
                numRotations =  encoderValue / 1440;


                //runs program for top left red
                //top_left_red_check1();

                //runs program for top right blue
                //sees how far it has gone and then rotates or stops accordingly
                //top_right_blue_check1();


                robot.waitForTick(10);
                idle();


            }
        }

}
