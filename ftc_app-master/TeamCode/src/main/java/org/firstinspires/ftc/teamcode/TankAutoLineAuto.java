package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsDigitalTouchSensor;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cColorSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
/**
 * Created by graha on 1/5/2017.
 */

@Autonomous(name = "TankAutoLineAuto", group = "Tank")

public class TankAutoLineAuto extends LinearOpMode {

    TankHardware robot = new TankHardware();
    ModernRoboticsDigitalTouchSensor touch;
    ModernRoboticsI2cRangeSensor sonarR;
    ModernRoboticsI2cRangeSensor sonarL;
    ModernRoboticsI2cGyro gyro;
    ModernRoboticsI2cColorSensor colorRight;
    ModernRoboticsI2cColorSensor colorLeft;
    ModernRoboticsI2cColorSensor colorDown;

    enum State {
        INIT, START, FINISH, DRIVEtoBALL, PARK, ALIGN, DRIVEtoWALL, TURNright, TURNleft, DRIVEtoLINE, DRIVEtoBEACON
    }

    enum Side {
        NULL,RED, BLUE
    }

    State state = State.INIT;
    State nextState = State.INIT;

    Side right = Side.NULL;
    Side left = Side.NULL;

    double rightDist;
    double leftDist;

    int heading;
    int startHeading;

    int rStart;
    int lStart;

    int red1,red2,blue1,blue2;

    int step = 0;

    int base;

    long start;
    long current;

    @Override
    public void runOpMode() throws InterruptedException {

        robot.init(hardwareMap);

        touch = hardwareMap.get(ModernRoboticsDigitalTouchSensor.class, "touch sensor");

        sonarR = hardwareMap.get(ModernRoboticsI2cRangeSensor.class, "sonar sensor right");
        sonarL = hardwareMap.get(ModernRoboticsI2cRangeSensor.class, "sonar sensor left");

        gyro = hardwareMap.get(ModernRoboticsI2cGyro.class, "gyro");

        colorRight = hardwareMap.get(ModernRoboticsI2cColorSensor.class, "color right");
        colorLeft = hardwareMap.get(ModernRoboticsI2cColorSensor.class, "color left");
        colorDown = hardwareMap.get(ModernRoboticsI2cColorSensor.class, "color down");

        gyro.calibrate();

        waitForStart();

        while(opModeIsActive()) {


            //Figure out if we want to do for Events
            switch(state) {
                case INIT:
                    robot.right.setPower(0);
                    robot.left.setPower(0);
                    robot.right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    robot.left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rStart = robot.right.getCurrentPosition();
                    lStart = robot.left.getCurrentPosition();
                    state = State.START;
                    red1 = colorRight.red();
                    red2 = colorLeft.red();
                    base = (red1 + red2)/2;
                    break;
                case START:
                    //do something
                    state = State.DRIVEtoBALL;
                    break;
                case DRIVEtoBALL:
                    robot.right.setPower(0.5);
                    robot.left.setPower(0.5);
                    if(touch.isPressed()){state = State.ALIGN;}
                    break;
                case PARK:
                    startClock();
                    robot.right.setPower(0);
                    robot.left.setPower(0);
                    if(checkClock(1000)) {state = nextState;}
                    break;
                case ALIGN:
                    rightDist = sonarR.getDistance(DistanceUnit.CM);
                    leftDist = sonarL.getDistance(DistanceUnit.CM);
                    if(leftDist + 1 > rightDist && leftDist - 1 < rightDist) {
                        state = State.TURNleft;
                        nextState = State.DRIVEtoWALL;
                        startHeading = gyro.getHeading();
                    }
                    break;
                case TURNleft:
                    robot.right.setPower(1);
                    robot.left.setPower(-1);
                    heading = gyro.getIntegratedZValue();
                    if(startHeading - heading > -90){state = nextState;}
                    break;
                case TURNright:
                    robot.right.setPower(-1);
                    robot.left.setPower(1);
                    heading = gyro.getIntegratedZValue();
                    if(startHeading - heading < 90){state = nextState;}
                    break;
                case DRIVEtoWALL:
                    robot.right.setPower(1);
                    robot.left.setPower(1);
                    leftDist = sonarL.getDistance(DistanceUnit.CM);
                    if(leftDist < 15){state = State.TURNright; nextState = State.DRIVEtoLINE;}
                    break;
                case DRIVEtoLINE:
                    robot.right.setPower(0.5);
                    robot.left.setPower(0.5);
                    colorDown.enableLed(true);
                    if(colorDown.alpha() > 1){
                        state = State.TURNleft;
                        nextState = State.DRIVEtoBEACON;
                        colorDown.enableLed(false);
                    }
                    break;
                case DRIVEtoBEACON:
                    robot.right.setPower(0.5);
                    robot.left.setPower(0.5);
                    blue1 = colorRight.blue();
                    blue2 = colorLeft.blue();
                    if(blue1 > 3) {
                        right = Side.BLUE;
                        left = Side.RED;
                    }
                    if(blue2 > 3){
                        right = Side.RED;
                        left = Side.BLUE;
                    }
                    break;
                case FINISH:
                    break;
            }

            robot.waitForTick(20);

            idle();

        }

        }

    void gotoStep(){

        switch (step){
            case 0:
                state = State.DRIVEtoBALL;
                break;
            case 1:
                state = State.ALIGN;
                break;
            case 2:
                state = State.TURNleft;
                break;
            case 3:
                state = State.DRIVEtoWALL;
                break;
            case 4:
                state = State.TURNright;
                break;
            case 5:
                state = State.DRIVEtoLINE;
                break;
            case 6:
                state = State.TURNleft;
                break;
            case 7:
                state = State.FINISH;
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            default:
                break;
        }
        step++;
        return;

    }

    void startClock(){
        start = System.currentTimeMillis();
    }

    boolean checkClock(long target){
        current = System.currentTimeMillis();
        return (current - start > target);
    }

//    void moveD(long distance,float power){
//
//        long pos = 0;
//        long r = robot.right.getCurrentPosition();
//        long l = robot.left.getCurrentPosition();
//        pos = r;
//        long start = r; // figure out better starting method
//        long travelled = pos - start;
//        while(Math.abs(travelled) < distance) {
//            if(distance > 0) {
//                robot.right.setPower(power);
//                robot.left.setPower(power);
//            }
//            else {
//                robot.right.setPower(power);
//                robot.left.setPower(power);
//            }
//            r = robot.right.getCurrentPosition();
//            pos = r;
//            travelled = pos - start;
//        }
//        robot.right.setPower(0);
//        robot.left.setPower(0);
//    }

//    void moveT(long time, float power) {
//
//        long start = System.nanoTime();
//        long current = System.nanoTime();
//        long count = current - start;
//        while(count*1000000 < time) {
//            robot.right.setPower(power);
//            robot.left.setPower(power);
//        }
//        robot.right.setPower(0);
//        robot.left.setPower(0);
//    }

}
