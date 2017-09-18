package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cColorSensor;

/**
 * Created by Graham Cooke on 9/28/2016.
 */
@TeleOp(name = "ColorTest", group = "Tests")

public class ColorTest extends LinearOpMode {

    ColorTestHardware robot = new ColorTestHardware();

    ModernRoboticsI2cColorSensor color;

    @Override
    public void runOpMode() throws InterruptedException {

        robot.init(hardwareMap);

        color = hardwareMap.get(ModernRoboticsI2cColorSensor.class, "color");

        waitForStart();

        color.enableLed(false);

        while(opModeIsActive()){

            if(gamepad1.right_bumper){color.enableLed(true);}
            else{color.enableLed(false);}


            telemetry.addData("argb", color.argb());
            telemetry.addData("Alpha",color.alpha());
            telemetry.addData("Red", color.red());
            telemetry.addData("Green", color.green());
            telemetry.addData("Blue", color.blue());
            telemetry.addData("String?", color.toString());
            telemetry.update();

            robot.waitForTick(10);
            idle();
        }

    }
}
