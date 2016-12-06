package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by Graham Cooke on 9/28/2016.
 */
@TeleOp(name = "GamepadTest", group = "Tests")

public class GamepadTest extends LinearOpMode {

    TestHardware robot = new TestHardware();


    @Override
    public void runOpMode() throws InterruptedException {

        robot.init(hardwareMap);

        waitForStart();

        double lx;
        double rx;
        double ly;
        double ry;
        boolean a;
        boolean b;
        boolean x;
        boolean y;
        double rt;
        double lt;
        boolean rb;
        boolean lb;

        while(opModeIsActive()){

            rx = gamepad1.right_stick_x;
            lx = gamepad1.left_stick_x;
            ry = gamepad1.right_stick_y;
            ly = gamepad1.left_stick_y;

            a = gamepad1.a;
            b = gamepad1.b;
            x = gamepad1.x;
            y = gamepad1.y;

            rt = gamepad1.right_trigger;
            lt = gamepad1.left_trigger;

            rb = gamepad1.right_bumper;
            lb = gamepad1.left_bumper;

            telemetry.addData("RightX", rx);
            telemetry.addData("LeftX", lx);
            telemetry.addData("RightY", ry);
            telemetry.addData("LeftY", ly);
            telemetry.addData("A", a);
            telemetry.addData("B", b);
            telemetry.addData("X", x);
            telemetry.addData("Y", y);
            telemetry.addData("RightT", rt);
            telemetry.addData("LeftT", lt);
            telemetry.addData("RightB", rb);
            telemetry.addData("LeftB", lb);
            telemetry.update();

            robot.waitForTick(10);
            idle();
        }

    }
}
