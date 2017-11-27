package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by graha on 11/27/2017.
 */

@Autonomous(name = "SildeBotAutoBasic1Red", group = "Slide")

public class SlideBotAutoBasic1Red extends LinearOpMode{

    SlideBotHardware robot = new SlideBotHardware();

    @Override
    public void runOpMode()throws InterruptedException{

        robot.init(hardwareMap);

        waitForStart();



    }
}
