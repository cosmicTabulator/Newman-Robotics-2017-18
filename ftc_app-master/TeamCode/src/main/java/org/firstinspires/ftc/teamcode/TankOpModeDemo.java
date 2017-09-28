package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by Graham Cooke on 9/28/2016.
 */
@TeleOp(name = "TankOpModeDemo", group = "Tank")

public class TankOpModeDemo extends LinearOpMode {

    TankHardwareDemo robot = new TankHardwareDemo();

    @Override
    public void runOpMode() throws InterruptedException {

        float lPower = 0;
        float rPower = 0;

        float drive;
        float turn;

        boolean tank = true;

        robot.init(hardwareMap);

        waitForStart();

        while(opModeIsActive()){

            drive = gamepad1.right_stick_y;
            turn = gamepad1.right_stick_x;

            if(gamepad1.dpad_up) {
                tank = true;
            } else if (gamepad1.dpad_down){
                tank = false;
            }

            if(!tank) {
                rPower = drive + turn;
                lPower = drive - turn;
            }

            if(tank) {
                lPower = gamepad1.left_stick_y;
                rPower = gamepad1.right_stick_y;
            }

            robot.left.setPower(lPower);
            robot.right.setPower(rPower);

            robot.waitForTick(10);
            idle();
        }

    }
}
