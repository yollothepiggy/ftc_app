package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Crane", group="Exercises")

//@Disabled

public class crane extends LinearOpMode

{
    DcMotor rotation, main, brace, dropper,leftMotor, rightMotor;
    double rotations, mains, droppers, lefts, rights;

    @Override
    public void runOpMode() {
        rotation = hardwareMap.dcMotor.get("rotation");
        main = hardwareMap.dcMotor.get("main");
        brace = hardwareMap.dcMotor.get("brace");
        dropper = hardwareMap.dcMotor.get("dropper");
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

            rotations = gamepad1.left_stick_x;
            droppers = gamepad1.right_stick_y;
            rotation.setPower(Range.clip(-rotations, -.20, .20));
            dropper.setPower(Range.clip(-droppers, -.40, .50));

            if (gamepad1.dpad_left)
            {
            main.setPower(-.35);
            }

            if (gamepad1.b)
            {
                main.setPower(0);
                brace.setPower(0);
            }

            if (gamepad1.dpad_right)
            {
                main.setPower(.35);
            }

            if (gamepad1.dpad_up)
            {
                brace.setPower(.35);
            }

            if (gamepad1.dpad_down)
            {
                brace.setPower(-.35);
            }

            lefts = gamepad2.left_stick_y;
            rights = gamepad2.right_stick_y;

            leftMotor.setPower(Range.clip(-lefts, -.50, .50));
            rightMotor.setPower(Range.clip(-rights, -.50, .50));

        }
    }
}