package org.firstinspires.ftc.teamcode;


import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cColorSensor;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by Graham Cooke on 9/28/2016.
 */
@TeleOp(name = "TestOp", group = "Tests")

public class SensorTest extends LinearOpMode {

    TestHardware robot = new TestHardware();


    ModernRoboticsI2cColorSensor color;
    ModernRoboticsI2cGyro gyro;
    ModernRoboticsI2cRangeSensor sonar;

    @Override
    public void runOpMode() throws InterruptedException {

        robot.init(hardwareMap);

        color = hardwareMap.get(ModernRoboticsI2cColorSensor.class, "color");
        gyro = hardwareMap.get(ModernRoboticsI2cGyro.class, "gyro");
        sonar = hardwareMap.get(ModernRoboticsI2cRangeSensor.class, "sonar");

        waitForStart();

        while(opModeIsActive()){
            telemetry.addData("Sonar", sonar.cmUltrasonic());

            robot.waitForTick(10);
            idle();
        }

    }
}
