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
        double s;
        double a;

        while(opModeIsActive()){


            r = -gamepad1.right_stick_y;
            l = -gamepad1.left_stick_y;

            if(gamepad1.left_bumper){
              s = 1;
            }
            else{
              s = 0;
            }

            if(gamepad1.right_bumper){
                a = -0.6;
            }
            else if(gamepad1.right_trigger > 0.1){
                a = -0.8;
            }
            else{
                a = 0;
            }

            telemetry.addData("Right", r);
            telemetry.addData("Left", l);
            telemetry.addData("Sweeper", s);
            telemetry.addData("Arm", a);
            telemetry.update();

            robot.right.setPower(r);
            robot.left.setPower(l);
            robot.sweeper.setPower(s);
            robot.arm.setPower(a);

            robot.waitForTick(10);
            idle();
        }

    }
}
