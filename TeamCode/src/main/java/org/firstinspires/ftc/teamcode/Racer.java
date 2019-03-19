package org.firstinspires.ftc.teamcode;

        import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
        import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
        import com.qualcomm.robotcore.hardware.DcMotor;
        import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Drag", group="Exercises")

//@Disabled

public class Racer extends LinearOpMode

{
    DcMotor leftMotor, rightMotor;
    double lefts, rights;

    @Override
    public void runOpMode() {
        //First Hub
        leftMotor = hardwareMap.dcMotor.get("leftMotor");
        rightMotor = hardwareMap.dcMotor.get("rightMotor");
        leftMotor.setDirection(DcMotor.Direction.REVERSE);


        while (opModeIsActive())

        {

            lefts = gamepad1.left_stick_y;
            rights = gamepad1.right_stick_y;

            leftMotor.setPower(Range.clip(-lefts, -.50, .75));
            rightMotor.setPower(Range.clip(-rights, -.50, .75));

            telemetry.addData("Left Motor", leftMotor.getPower());
            telemetry.addData("Right Motor", rightMotor.getPower());
            telemetry.update();
        }
    }
}