package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by Graham Cooke on 9/28/2016.
 */
@TeleOp(name = "TestOpMode", group = "Test")

public class TestOpMode extends LinearOpMode {

    TestHardware robot = new TestHardware();


    @Override
    public void runOpMode() throws InterruptedException {

        robot.init(hardwareMap);

        waitForStart();

        while(opModeIsActive()){

            robot.waitForTick(10);
            idle();
        }

    }
}
