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

        float c = 0.8f;

        float drive;
        float turn;

        boolean tank = true;
        int tank_count = 0;

        robot.init(hardwareMap);

        waitForStart();

        while(opModeIsActive()){

            drive = gamepad1.right_stick_y;
            turn = gamepad1.right_stick_x;

            // if left joystick is untouched for 1000 ms, then exit tank mode
            //else, use tank mode again
            if(gamepad1.left_stick_y * gamepad1.left_stick_x == 0) {
                tank_count += 1;
            }else if(gamepad1.left_stick_y * gamepad1.left_stick_x != 0){
                tank_count = 0;
            }

            if (tank_count < 30){
                tank = true;
            }else if (tank_count >= 100){
                tank = false;
            }

            if(!tank) {
                rPower = c*(drive + turn);
                lPower = c*(drive - turn);
            }

            if(tank) {
                lPower = c*gamepad1.left_stick_y;
                rPower = c*gamepad1.right_stick_y;
            }

            robot.left.setPower(lPower);
            robot.right.setPower(rPower);

            robot.waitForTick(10);
            idle();
        }

    }
}
