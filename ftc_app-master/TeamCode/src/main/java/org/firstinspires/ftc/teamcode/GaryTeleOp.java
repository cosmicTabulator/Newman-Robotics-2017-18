package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by Graham Cooke on 9/28/2016.
 */
@TeleOp(name = "SlideBotTeleOp", group = "Tank")

public class SlideBotTeleop extends LinearOpMode {

    SlideBotHardware robot = new SlideBotHardware();

    enum slidePos{
        LOW, MED, HIGH;
    }

    float startSlidePos;

    @Override
    public void runOpMode() throws InterruptedException {

        float lPower = 0;
        float rPower = 0;
        float sensitivity = 1.0;

        float c = 0.8f;

        float drive;
        float turn;

        float slide;

        int cooldown = 0;
        double position = 0;

        boolean tank = true;

        robot.init(hardwareMap);

        waitForStart();

        startSlidePos = robot.slide.getCurrentPos();
        slidePOS startSlideEnumPos = LOW;

        while(opModeIsActive()){

            slide = gamepad1.right_trigger;

            lPower = c*gamepad1.left_stick_y;
            rPower = c*gamepad1.right_stick_y;

            robot.left.setPower(lPower * sensitivity);
            robot.right.setPower(rPower * sensitivity);

            this.moveSlide(slide, !gamepad1.right_bumper, startSlideEnumPos);

            if(gamepad1.dpad_up){
                position = 1;
            }


            if(gamepad1.dpad_down){
                position = 0.5;
            }

            if (gamepad1.a){
                sensitivity -= (sensitivity / 2) % 1.0;
            }
            if(gamepad.b){
                sensitivity = (sensitivity * 2) % 1.0;
            }

            robot.latchUp.setPosition(position);
            robot.latchDown.setPosition(1-position);

            telemetry.addData("Servo Position", position);
            telemetry.addData("Cooldown", cooldown);
            telemetry.update();

            robot.waitForTick(10);
            idle();
        }
    }

    void moveSlide(float slide, boolean up, slidePos liftLevel){

        switch(liftLevel) {
            case(LOW)
                pos = robot.slide.getCurrentPosition();
                if(up) {
                    while (pos <= startSlidePos + 120) {
                        robot.slide.setPower(slide);
                    }
                    liftLevel = MED;
                }else{
                    while (startSlidePos <= pos) {
                        robot.slide.setPower(-slide);
                    }
                    liftLevel = LOW;
                }
            case(MED)
                    pos = robot.slide.getCurrentPosition();
                if(up) {
                    while (pos <= startSlidePos + 240) {
                        robot.slide.setPower(slide);
                    }
                    liftLevel = HIGH;
                }else{
                    while (startSlidePos + 120 < pos) {
                        robot.slide.setPower(-slide);
                    }
                    liftLevel = LOW;
                }
            case(HIGH)
                    pos = robot.slide.getCurrentPosition();
                if(up) {
                    while (pos <= startSlidePos + 360) {
                        robot.slide.setPower(slide);
                    }
                    liftLevel = HIGH;
                }else{
                    while (startSlidePos + 240 < pos) {
                        robot.slide.setPower(-slide);
                    }
                    liftLevel = MED;
                }
    }
}
