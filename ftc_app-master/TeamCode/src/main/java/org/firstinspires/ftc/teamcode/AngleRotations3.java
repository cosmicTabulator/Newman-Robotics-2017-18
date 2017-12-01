package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

import java.lang.Math;



/**
 * Created by brendanmatulis on 11/30/17.
 */

//This program is for the autonomous phase
// It allows the robot to rotate using specified parameters, including angles

public class AngleRotations3 extends LinearOpMode {

    static double distanceLeftY, distanceRightY, sonarDistanceX;
    static float rightMotor, leftMotor;

    //Wheel diameter, used to find circumference in CM
    final static double inchToCM = 2.54; //Conversion factor of 1 inch to 2.54 CM

    final static double diameter = 10.16;
    final static double wheelCircumference = Math.PI * diameter;
    static double encoderValue;
    static double numRotations;
    static double totalDistance = wheelCircumference * numRotations;


    //inchToCm conversion factor convers inches to CM
    //Robot width used to calculate rotations needed for a turn
    // 40 inches


    // 1/4th  of circumference (C=pi*diameter)
    //Distance travelled by wheels when turning
    //Used to calculate number of rotations for turning 90 degrees

    public void rotate_clockwise(double degrees, double widthRobot,
                                        double wheelDiameter, double encoderValue,
                                        double wheelCircumference) {
        double wheelCircumference = Math.PI * wheelDiameter
        double numRotations;
        double total
        double fractionOfCircumference = degrees / 360;
        double angleTurnDistance = (Math.PI * widthRobot) * fractionOfCircumference;
        double angleTurnRotations = rightAngleTurnDistance / wheelCircumference;

        final double initial_NumRotations = numRotations;
        while (change_in_numRotations < angleTurnRotations) {
            encoderValue = robot.right.getCurrentPosition();
            numRotations = encoderValue / 1440;

            double change_in_numRotations = numRotations - initial_NumRotations;

            leftMotor = 0.5;
            rightMotor = -0.5;
        }
        rightMotor = 0.0;
        leftMotor = 0.0;
    }

}
