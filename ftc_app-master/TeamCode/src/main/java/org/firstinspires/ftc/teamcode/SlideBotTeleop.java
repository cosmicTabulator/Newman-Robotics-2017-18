package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
/**
 * Created by Graham Cooke on 9/28/2016.
 */
@TeleOp(name = "SlideBotTeleOp", group = "Tank")

public class SlideBotTeleop extends LinearOpMode {

    SlideBotHardware robot = new SlideBotHardware();

    @Override
    public void runOpMode() throws InterruptedException {

        float lPower = 0;
        float rPower = 0;

        float c = -0.7f;

        float drive;
        float turn;

        float slide;

        int cooldown = 0;
        double position = 0.5;
        double armPos = 0.5;

        robot.init(hardwareMap);

        waitForStart();

        while(opModeIsActive()){

            lPower = c*gamepad1.left_stick_y;
            rPower = c*gamepad1.right_stick_y;


            while (gamepad1.dpad_left) {
                lPower = 0.2f;
                rPower = 0.2f;
            }

            robot.left.setPower(lPower);
            robot.right.setPower(rPower);

            slide = gamepad2.left_stick_y;

            robot.slide.setPower(slide);

            if(gamepad2.dpad_up){
                position = 0.65;
            }

            if(gamepad2.x){
                armPos = 0.6;
            }

            if(gamepad2.b){
                armPos = 0.1;
            }

            if(gamepad2.dpad_down){
                position = 0;
            }


            robot.latchUp.setPosition(position);
            robot.latchDown.setPosition(1-position);
            robot.arm.setPosition(armPos);

            telemetry.addData("Servo Position", position);
            telemetry.addData("Cooldown", cooldown);
            telemetry.update();

            robot.waitForTick(10);
            idle();
        }
    }
}
