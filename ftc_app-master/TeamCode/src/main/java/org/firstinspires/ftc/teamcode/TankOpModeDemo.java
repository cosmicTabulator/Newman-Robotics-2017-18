package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by Graham Cooke on 9/28/2016.
 */
@TeleOp(name = "TankDemo", group = "Tests")

public class TankOpModeDemo extends LinearOpMode {

    TankHardwareDemo robot = new TankHardwareDemo();

    @Override
    public void runOpMode() throws InterruptedException {

        float lPower = 0;
        float rPower = 0;

        robot.init(hardwareMap);

        waitForStart();

        while(opModeIsActive()){

            lPower = -gamepad1.left_stick_y;
            rPower = -gamepad1.right_stick_y;

            robot.left.setPower(lPower);
            robot.right.setPower(rPower);
            
            robot.waitForTick(10);
            idle();
        }

    }
}
