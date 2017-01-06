package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by graha on 1/5/2017.
 */

@Autonomous(name = "TankAutoDriveForward", group = "Tank")

public class TankAutoDriveForward extends LinearOpMode {

    TankHardware robot = new TankHardware();

    @Override
    public void runOpMode() throws InterruptedException {

        robot.init(hardwareMap);

        waitForStart();

        while(opModeIsActive()) {

            //do stuff

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

    }
}
