package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp(name="OFFICIAL TeleOp", group="Exercises")

//@Disabled

public class test extends LinearOpMode

{
    DcMotor leftMotor, rightMotor;
    double lefts, rights;

    @Override
    public void runOpMode() {
        //First Hub
        leftMotor = hardwareMap.dcMotor.get("leftMotor");
        rightMotor = hardwareMap.dcMotor.get("rightMotor");
        leftMotor.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addData("mode", "waiting");
        telemetry.update();

        waitForStart();

        telemetry.addData("mode", "Active");
        telemetry.update();

        while (opModeIsActive())

        {

            // Gamepad 1 controls

            lefts = gamepad1.left_stick_y;
            rights = gamepad1.right_stick_y;



            leftMotor.setPower(Range.clip(-lefts, -.50, .75));
            telemetry.addData("Left Motor", leftMotor.getPower());
            telemetry.addData("Right Motor", rightMotor.getPower());
            telemetry.update();
            rightMotor.setPower(Range.clip(-rights, -.50, .75));



        }
    }
}