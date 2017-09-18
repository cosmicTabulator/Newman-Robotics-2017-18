package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by Graham Cooke on 9/28/2016.
 */

@TeleOp(name = "TankOp", group = "Tank")

public class TankOpMode extends LinearOpMode {

    TankHardware robot = new TankHardware();

    @Override
    public void runOpMode() throws InterruptedException {

        robot.init(hardwareMap);

        waitForStart();

        double r = 0;
        double l = 0;
        double b;
        double a;
        double f = 0.75;

        double s = 0.3;

        double holdPos = 0;
        double armPos = 0;
        double initialPos = 0;

        boolean holdCam = false;
        boolean fire = false;

        while(opModeIsActive()){

            r = -gamepad1.right_stick_y * f;
            l = -gamepad1.left_stick_y * f;

            if(gamepad1.left_bumper){
                b = s;
            }
            else if(gamepad1.dpad_down){
                b = -s;
            }
            else{
                b = 0;
            }

//            if(gamepad1.a){
//                holdCam = true;
//                holdPos = robot.arm.getCurrentPosition();
//            }
//            if(holdCam){
//                armPos = robot.arm.getCurrentPosition();
//                if (Math.abs(holdPos - armPos) > 70) {
//                    if(armPos > holdPos){
//                        robot.arm.setPower(-0.2);
//                    }
//                    if(armPos < holdPos){
//                        robot.arm.setPower(0.2);
//                    }
//                }
//                else{
//                    robot.arm.setPower(0);
//                }
//                return;
//            }

            armPos = robot.arm.getCurrentPosition();

            if(gamepad1.right_bumper && !fire){
                fire = true;
                initialPos = robot.arm.getCurrentPosition();
            }
            if(fire){
                if(armPos < initialPos + 1440){
                    robot.arm.setPower(0.75);
                }
                else{
                    fire = false;
                }
            }

//          if(gamepad1.right_trigger > 0.1){
            robot.arm.setPower((double) gamepad1.right_trigger);
//              fire = false;
//          }

            telemetry.addData("Right", r);
            telemetry.addData("Left", l);
            telemetry.addData("Belt", s);
            telemetry.addData("Arm", fire);
            telemetry.addData("Arm Pos", armPos);
            telemetry.update();

            robot.right.setPower(r);
            robot.left.setPower(l);
            robot.belt.setPower(b);

            robot.waitForTick(10);
            idle();
        }

    }
}
