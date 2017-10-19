package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by Graham Cooke on 9/28/2016.
 */
@TeleOp(name = "BeltBotTeleOp", group = "Tank")

public class BeltBotTeleOp extends LinearOpMode {

    BeltBotHardware robot = new BeltBotHardware();

    @Override
    public void runOpMode() throws InterruptedException {

        float lPower = 0;
        float rPower = 0;

        float c = 0.8f;

        float drive;
        float turn;

        float belt;

        int cooldown = 0;
        int position = 0;

        boolean tank = true;

        robot.init(hardwareMap);

        waitForStart();

        while(opModeIsActive()){
            
            drive = gamepad1.right_stick_y;
            turn = gamepad1.right_stick_x;

            belt = gamepad1.right_trigger - gamepad1.left_trigger;

            if(gamepad1.dpad_up) {
                tank = true;
            } else if (gamepad1.dpad_down){
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

            if(gamepad1.x) {
                robot.belt.setPower(-belt);
            } else {
                robot.belt.setPower(belt);
            }

            if(gamepad1.x){
                position = 0;
            }

            if(gamepad1.y){
                position = 1;
            }

            robot.latch.setPosition(position);

            telemetry.addData("Servo Position", position);
            telemetry.addData("Cooldown", cooldown);
            telemetry.update();

            robot.waitForTick(10);
            idle();
        }

    }
}
