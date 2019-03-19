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
    DcMotor leftMotor, rightMotor, liftMotor;
    double lefts, rights;

    @Override
    public void runOpMode() {
        //First Hub
        leftMotor = hardwareMap.dcMotor.get("leftMotor");
        rightMotor = hardwareMap.dcMotor.get("rightMotor");
        leftMotor.setDirection(DcMotor.Direction.REVERSE);


        //Second Hub
        liftMotor = hardwareMap.dcMotor.get("liftMotor");




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
            rightMotor.setPower(Range.clip(-rights, -.50, .75));

              telemetry.addData("Left Motor", leftMotor.getPower());
            telemetry.addData("Right Motor", rightMotor.getPower());
            telemetry.update();




            // Gamepad 2 controls
           // lifts = gamepad2.right_stick_y;
           // extend = gamepad2.left_stick_y;

            //armLift1.setPower(Range.clip(-lifts, -.50, .75));
            //armLift2.setPower(Range.clip(-lifts, -.50, .75));
            //armExtend.setPower(Range.clip(-extend, -.60, .75));

           /* telemetry.addData("Arm Motor 1", armLift1.getPower());
            telemetry.addData("Arm Motor 2", armLift2.getPower());
            telemetry.addData("Claw Motor", armExtend.getPower());
            telemetry.update();
*/



            if ( gamepad1.dpad_up)
            {
                liftMotor.setPower(.70);
            }

            if ( gamepad1.b)
            {
                liftMotor.setPower(0);
            }

            if ( gamepad1.dpad_down)
            {
                liftMotor.setPower(-.60);
            }






        }
    }
}