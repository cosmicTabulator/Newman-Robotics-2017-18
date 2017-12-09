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
public class auto_red_bottom extends LinearOpMode {

    double rightMotor, leftMotor;

    //Wheel diameter, used to find circumference in CM
    final static double inchToCM = 2.54; //Conversion factor of 1 inch to 2.54 CM

    final double wheelDiameter = 4 * inchToCM;
    final double wheelCircumference = Math.PI * wheelDiameter;
    double encoderValue, numRotations, totalDistance, change_in_numRotations, initial_NumRotations, encoder_zero;

    //inchToCm conversion factor convers inches to CM
    //Robot width used to calculate rotations needed for a turn
    final static double widthRobot = 40 * inchToCM; //40 inches

    // 1/4th  of circumference (C=pi*diameter)
    //Distance travelled by wheels when turning
    //Used to calculate number of rotations for turning 90 degrees
    double angleTurnDistance, angleTurnRotations, fractionOfCircumference;

    SlideBotHardware robot = new SlideBotHardware();

    public void rotate_clockwise(double degrees) {

        fractionOfCircumference = degrees / 360;
        angleTurnDistance = (Math.PI * widthRobot) * fractionOfCircumference;
        angleTurnRotations = angleTurnDistance / wheelCircumference;

        initial_NumRotations = numRotations;
        change_in_numRotations = 0;
        while (change_in_numRotations < angleTurnRotations) {
            //    encoderValue = robot.right.getCurrentPosition();
            numRotations = encoderValue / 1440;
            change_in_numRotations = numRotations - initial_NumRotations;

            leftMotor = 0.5;
            rightMotor = -0.5;
        }
        rightMotor = 0.0;
        leftMotor = 0.0;
        encoder_zero = robot.right.getCurrentPosition();
    }

    public void rotate_anticlockwise(double degrees) {

        fractionOfCircumference = degrees / 360;
        angleTurnDistance = (Math.PI * widthRobot) * fractionOfCircumference;
        angleTurnRotations = angleTurnDistance / wheelCircumference;

        initial_NumRotations = numRotations;
        change_in_numRotations = 0;
        while (change_in_numRotations < angleTurnRotations) {
            encoderValue = robot.right.getCurrentPosition();
            numRotations = encoderValue / 1440;

            double change_in_numRotations = numRotations - initial_NumRotations;

            leftMotor = -0.5;
            rightMotor = 0.5;
        }
        rightMotor = 0.0;
        leftMotor = 0.0;
        encoder_zero = robot.right.getCurrentPosition();
    }

    public void top_left_red_check1() {
        //If the robot travels 36" (94.44 cm) or more, robot stops
        //Goal is 36" from top left red start
        //This is the same for top right blue start
        //For the bottom red/blue starts, set distance to 60.98 CM (ie 24 in)...
        //Then, rotate robot 90 degrees and move forward 30.48 CM (ie 12 in)
        if (totalDistance >= 36 * inchToCM) {
            //Stops robot once robot has traveled 36" or more
            leftMotor = 0;
            rightMotor = 0;
            encoder_zero = robot.right.getCurrentPosition();
        }
        // turns towards goal
        rotate_anticlockwise(90);
    }

    public void top_right_blue_check1() {
        if (totalDistance >= 36 * inchToCM) {
            //Stops robot once robot has traveled 36" or more
            leftMotor = 0;
            rightMotor = 0;
            encoder_zero = robot.right.getCurrentPosition();
        }

        //turns towards goal
        rotate_clockwise(90);
    }

    public void bottom_left_red_check1() {
        if (totalDistance >= 24 * inchToCM) {
            leftMotor = 0;
            rightMotor = 0;

            rotate_clockwise(90);
            encoder_zero = robot.right.getCurrentPosition();
        }
    }

    public void bottom_left_red_check2() {
        //should check to see if it moves another 12 inches and then turn towards goal
        //note: should find change in rotations for the 12 inches
    }

    @Override
    public void runOpMode() throws InterruptedException {

        robot.init(hardwareMap);

        waitForStart();

        encoder_zero = robot.right.getCurrentPosition();

        while (opModeIsActive()) {
            encoderValue = robot.right.getCurrentPosition() - encoder_zero;
            numRotations =  encoderValue / 1440;
            totalDistance = wheelCircumference * numRotations;

            robot.left.setPower(leftMotor);
            robot.right.setPower(rightMotor);

            bottom_left_red_check1();

            robot.waitForTick(10);
            idle();
        }
    }

}

