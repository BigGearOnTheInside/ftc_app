package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.TouchSensor;

/**
 * Created by 15670 on 10/8/2016.
 */

@Autonomous(name = "Autonomous", group = "FTC Op Mode")
public class FTCAutomous extends LinearOpMode {

    //(we need it with lego touch sensor)
    TouchSensor sensor;
    DcMotor left;
    DcMotor right;

    @Override
    public void runOpMode() throws InterruptedException {


        sensor = hardwareMap.touchSensor.get("touch_sensor");
        left = hardwareMap.dcMotor.get("left_motor");
        right = hardwareMap.dcMotor.get("right_motor");

        left.setDirection(DcMotorSimple.Direction.FORWARD);
        right.setDirection(DcMotorSimple.Direction.FORWARD);

        while (true) {
            if(sensor.isPressed()) {

                //REVERSE
                left.setDirection(DcMotorSimple.Direction.REVERSE);
                right.setDirection(DcMotorSimple.Direction.REVERSE);

                //GO BACK
                left.setPower(50);
                right.setPower(50);

                //WAIT HALF SECOND
                wait(500);

                //STOP
                left.setPower(0);
                right.setPower(0);

                //FORWARD
                left.setDirection(DcMotorSimple.Direction.FORWARD);
                right.setDirection(DcMotorSimple.Direction.REVERSE);

                //TURN
                left.setPower(50);
                right.setPower(50);

                //WAIT UNTIL TURNED AROUND TODO test for exact turn time
                wait(500);

                //STOP
                left.setPower(0);
                right.setPower(0);

                //RESET
                left.setDirection(DcMotorSimple.Direction.FORWARD);
                right.setDirection(DcMotorSimple.Direction.FORWARD);

                //WAIT (for visible effect)
                wait(2000);
            }

            left.setPower(100);
            right.setPower(100);
        }
    }
}
