package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.api.FtcOpMode;

/**
 * Created by 15670 on 9/27/2016.
 */

@TeleOp(name = "TeleOP", group = "TeleOP")
public class FTCTeleOP extends FtcOpMode {

    @Override
    public void run() {
        //console.put("Hello", "Hello World");
        console.put("F", forward + "");
        console.put("D", dir + "");

        //MOVE
        move(forward, dir);
    }

}
