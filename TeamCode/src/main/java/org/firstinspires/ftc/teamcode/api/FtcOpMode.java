package org.firstinspires.ftc.teamcode.api;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcontroller.external.samples.HardwareK9bot;

import java.util.HashMap;

/**
 * Created by 15670 on 9/27/2016.
 */
public abstract class FtcOpMode extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {



        register();

        while(opModeIsActive()) {


            //WRITE VALUES
            armPosition = robot.ARM_HOME;
            clawPosition = robot.CLAW_HOME;

            console = new HashMap<>();

            //RUN
            run();

            //ADD TELEMETRY DATA
            for(String title : console.keySet()) {
                telemetry.addData(title, console.get(title));
            }
        }
    }

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


}
