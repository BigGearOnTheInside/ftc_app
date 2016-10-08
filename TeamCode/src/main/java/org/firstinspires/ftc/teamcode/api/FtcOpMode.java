package org.firstinspires.ftc.teamcode.api;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.robotcontroller.external.samples.HardwareK9bot;

import java.util.HashMap;

/**
 * Created by 15670 on 9/27/2016.
 */

public abstract class FtcOpMode extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {



        register();

        waitForStart();

        console = new HashMap<>();

        while(opModeIsActive()) {


            //CHECK FOR BUTTON
            if(gamepad1.right_bumper) {
                speed = 0.5F;
            }
            if(gamepad1.left_bumper) {
                speed = 1F;
            }

            //WRITE VALUES
            armPosition = robot.ARM_HOME;
            clawPosition = robot.CLAW_HOME;
            forward = -(speed*gamepad1.left_stick_y);
            dir = gamepad1.left_stick_x;

            //RUN
            run();

            //ADD TELEMETRY DATA
            for(String title : console.keySet()) {
                telemetry.addData(title, console.get(title));
            }
            telemetry.update();

            idle();
        }
    }

    public void move(float forward, float dir) {
        robot.leftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        robot.rightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        if(dir == 0F) {
            robot.leftMotor.setPower(forward);
            robot.rightMotor.setPower(forward);
        } else {
            robot.leftMotor.setPower(forward * dir);
            robot.rightMotor.setPower(forward * -dir);
        }
    }

//    public void lazyJoystickMove() {
//        if(gamepad1.left_stick_y < 0) { //left stick pushed forward
//            robot.leftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
//            robot.leftMotor.setPower(1F);
//        }
//        else if(gamepad1.left_stick_y > 0) { //left stick pushed back
//            robot.leftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
//            robot.leftMotor.setPower(1.0);
//        }
//        else
//        {/*is zero*/}
//
//        if(gamepad1.right_stick_y < 0) { //right stick pushed forward
//            robot.rightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
//            robot.rightMotor.setPower(1F);
//        }
//        else if(gamepad1.right_stick_y > 0) { //right stick pushed back
//            robot.rightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
//            robot.rightMotor.setPower(1F);
//        }
//        else
//        {/*is zero*/}
//
//    }

    //REGISTER
    private void register() {
        console = new HashMap<>();
        robot.init(hardwareMap);
    }

    public HardwareK9bot robot;
    public HashMap<String, String> console;
    public double armPosition;
    public double clawPosition;
    public abstract void run();
    public float forward;
    public float dir;
    public float speed;


}
