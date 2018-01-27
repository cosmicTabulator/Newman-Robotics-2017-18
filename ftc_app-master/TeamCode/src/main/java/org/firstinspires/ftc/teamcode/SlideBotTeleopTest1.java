package org.firstinspires.ftc.teamcode;


import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cColorSensor;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;

/**
 * Created by Graham Cooke on 9/28/2016.
 */
@TeleOp(name = "SlideBotTeleOpTest1", group = "Tank")

public class SlideBotTeleopTest1 extends LinearOpMode {

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

        ModernRoboticsI2cRangeSensor right_distanceSensor;
        ModernRoboticsI2cRangeSensor left_distanceSensor;

        robot.init(hardwareMap);

        right_distanceSensor = hardwareMap.get(ModernRoboticsI2cRangeSensor.class, "right_sonar");
        left_distanceSensor = hardwareMap.get(ModernRoboticsI2cRangeSensor.class, "left_sonar");

        waitForStart();

        while(opModeIsActive()){

            lPower = c*gamepad1.left_stick_y;
            rPower = c*gamepad1.right_stick_y;

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

            if (gamepad2.dpad_left) {
                if (c > -1) {    //for increasing sensitivity
                    c += -0.005;
                }
            }

            if (gamepad2.dpad_right) {
                if (c < 0) {    //for decreasing sensitivity
                    c += 0.005;
                }
            }

            if (gamepad2.b) {
                double right_distance = right_distanceSensor.cmUltrasonic();
                double left_distance = left_distanceSensor.cmUltrasonic();

                while (Math.abs(right_distance - left_distance) > 0.2) {

                    if (right_distance > left_distance) {
                        robot.right.setPower(right_distance / left_distance);
                        robot.left.setPower(-1 * right_distance / left_distance);
                    } else if (left_distance > right_distance) {
                        robot.right.setPower(left_distance / right_distance);
                        robot.left.setPower(-1 * left_distance / right_distance);
                    }
                }
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
