package org.firstinspires.ftc.teamcode;

        import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
        import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
        import com.qualcomm.robotcore.hardware.DcMotor;
        import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Sumo", group="Exercises")

//@Disabled

public class Racer extends LinearOpMode

{
    DcMotor leftMotor, rightMotor,lift, lift2;
    double lefts, rights;

    @Override
    public void runOpMode() {
        //First Hub
        leftMotor = hardwareMap.dcMotor.get("leftMotor");
        rightMotor = hardwareMap.dcMotor.get("rightMotor");
        rightMotor.setDirection(DcMotor.Direction.REVERSE);
        lift = hardwareMap.dcMotor.get("lift");
        lift2 = hardwareMap.dcMotor.get("lift2");

        telemetry.addData("mode", "waiting");
        telemetry.update();

        waitForStart();

        telemetry.addData("mode", "Active");
        telemetry.update();

        while (opModeIsActive())

        {

            lefts = gamepad1.left_stick_y;
            rights = gamepad1.right_stick_y;

            leftMotor.setPower(-Range.clip(-lefts, -1, 1));
            rightMotor.setPower(-Range.clip(-rights, -1, 1));

            telemetry.addData("Left Motor", leftMotor.getPower());
            telemetry.addData("Right Motor", rightMotor.getPower());
            telemetry.update();


            if (gamepad1.dpad_up)
            {
                lift.setPower(1);
                lift2.setPower(-1);
            }

            if (gamepad1.b)
            {
                lift.setPower(0);
                lift2.setPower(0);
            }

            if (gamepad1.dpad_down)
            {
                lift.setPower(-1);
                lift2.setPower(1);
            }


        }
    }
}