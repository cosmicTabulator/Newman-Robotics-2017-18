package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsDigitalTouchSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by graha on 1/5/2017.
 */

@Autonomous(name = "TankAutoSimpleAuto", group = "Tank")

public class TankAutoSimpleAuto extends LinearOpMode {

    TankHardware robot = new TankHardware();
    ModernRoboticsDigitalTouchSensor touch;

    enum State {
        INIT, START, FINISH, FORWARD, PARK
    }

    State state = State.INIT;

    int rStart;
    int lStart;

    @Override
    public void runOpMode() throws InterruptedException {

        robot.init(hardwareMap);

        touch = hardwareMap.get(ModernRoboticsDigitalTouchSensor.class, "touch sensor");

        waitForStart();

        while(opModeIsActive()) {

            switch(state) {
                case INIT:
                    robot.right.setPower(0);
                    robot.left.setPower(0);
                    robot.right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    robot.left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rStart = robot.right.getCurrentPosition();
                    lStart = robot.left.getCurrentPosition();
                    state = State.START;
                    break;
                case START:
                    //do something
                    state = State.FORWARD;
                    break;
                case FORWARD:
                    robot.right.setPower(0.5);
                    robot.left.setPower(0.5);
                    if(touch.isPressed()){state = State.PARK;}
                    break;
                case PARK:
                    robot.right.setPower(0);
                    robot.left.setPower(0);
                    state = State.FINISH;
                    break;
                case FINISH:
                    break;
            }

            robot.waitForTick(20);

            idle();

        }

        }

    void moveD(long distance,float power){

        long pos = 0;
        long r = robot.right.getCurrentPosition();
        long l = robot.left.getCurrentPosition();
        pos = r;
        long start = r; // figure out better starting method
        long travelled = pos - start;
        while(Math.abs(travelled) < distance) {
            if(distance > 0) {
                robot.right.setPower(power);
                robot.left.setPower(power);
            }
            else {
                robot.right.setPower(power);
                robot.left.setPower(power);
            }
            r = robot.right.getCurrentPosition();
            pos = r;
            travelled = pos - start;
        }
        robot.right.setPower(0);
        robot.left.setPower(0);
    }

    void moveT(long time, float power) {

        long start = System.nanoTime();
        long current = System.nanoTime();
        long count = current - start;
        while(count*1000000 < time) {
            robot.right.setPower(power);
            robot.left.setPower(power);
        }
        robot.right.setPower(0);
        robot.left.setPower(0);
    }

    void resetEncoders(){

        return;

    }

    }
