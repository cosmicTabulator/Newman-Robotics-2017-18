//package org.firstinspires.ftc.teamcode;
//
//import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cColorSensor;
//import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.hardware.HardwareMap;
//
//@Autonomous(name = "SildeBotAutoCryptoBox", group = "Slide")
//
//public class SlideBotAutoCryptoBox extends LinearOpMode {
//
//    SlideBotHardware robot = new SlideBotHardware();
//
//    ModernRoboticsI2cColorSensor color;
//    ModernRoboticsI2cGyro gyro;
//
//    double rightMotor, leftMotor;
//    final double wheelDiameter = 4 * inchToCM;
//    final double wheelCircumference = Math.PI * wheelDiameter;
//    double encoderValue, numRotations, totalDistance, change_in_numRotations, initial_NumRotations, encoder_zero;
//
//    encoderValue = robot.right.
//    numRotations = encoderValue / 1440;
//
//
//    //Wheel diameter, used to find circumference in CM
//    final static double inchToCM = 2.54; //Conversion factor of 1 inch to 2.54 CM
//
//    @Override
//    public void runOpMode()throws InterruptedException{
//
//        robot.init(hardwareMap);
//
//        color = hardwareMap.get(ModernRoboticsI2cColorSensor.class, "color");
//        gyro = hardwareMap.get(ModernRoboticsI2cGyro.class, "gyro");
//
//        gyro.calibrate();
//
//        waitForStart();
//
////        robot.arm.setPosition(0.1);
////
////        color.enableLed(true);
////
////        wait(1000);
////
////        if(color.blue() > color.red()){
////
////            turn(-90);
////
////        }
////        else{
////
////            turn(90);
////        }
////
//        robot.left.setPower(0);
//        robot.right.setPower(0);
//
//
//
//    }
//
//    public void wait(int ticks)throws InterruptedException{
//
//        Thread.sleep(ticks);
//
//    }
//
//    public void turn(int degrees){
//        int inititalHeading = gyro.getHeading();
//        if(degrees > 0) {
//            while(gyro.getHeading() < (degrees + inititalHeading)){
//                robot.right.setPower(-0.5);
//                robot.left.setPower(0.5);
//            }
//        }
//        else{
//            while(gyro.getHeading() > (degrees + inititalHeading)) {
//                robot.right.setPower(0.5);
//                robot.left.setPower(-0.5);
//            }
//        }
//
//        robot.right.setPower(0);
//        robot.left.setPower(0);
//    }
//
//
//}
//
//
