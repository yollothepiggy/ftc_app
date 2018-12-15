package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name="OFFICIAL AUTO", group="Exercises")
/**
 * Created by mendezis on 11/28/2018.
 */


public class AutoCrater extends LinearOpMode {

    DcMotor leftMotor, rightMotor, liftMotor;

    public void runOpMode()
    {

        //First Hub
        leftMotor = hardwareMap.dcMotor.get("leftMotor");
        rightMotor = hardwareMap.dcMotor.get("rightMotor");
        leftMotor.setDirection(DcMotor.Direction.REVERSE);
        liftMotor = hardwareMap.dcMotor.get("liftMotor");

        waitForStart();

        sleep(2500);

        liftMotor.setPower(.5);
        sleep(3000);


        liftMotor.setPower(0);
        sleep(1000);

        leftMotor.setPower(-.75);
        rightMotor.setPower(.75);
        sleep(2000);

        leftMotor.setPower(-.10);
        rightMotor.setPower(-.10);
        sleep(1000);

        leftMotor.setPower(0);
        rightMotor.setPower(0);
        sleep(1000);

    }
}
