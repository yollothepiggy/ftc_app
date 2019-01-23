package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Crane", group="Exercises")

//@Disabled

public class crane extends LinearOpMode

{
    DcMotor rotation, main, brace, dropper;
    double rotations, mains, droppers;

    @Override
    public void runOpMode() {
        rotation = hardwareMap.dcMotor.get("rotation");
        main = hardwareMap.dcMotor.get("main");
        brace = hardwareMap.dcMotor.get("brace");
        dropper = hardwareMap.dcMotor.get("dropper");

        telemetry.addData("mode", "waiting");
        telemetry.update();

        waitForStart();

        telemetry.addData("mode", "Active");
        telemetry.update();

        while (opModeIsActive())

        {

            // Gamepad 1 controls

            rotations = gamepad1.left_stick_x;
            mains = gamepad1.left_stick_y;
            droppers = gamepad1.right_stick_y;

            rotation.setPower(Range.clip(-rotations, -.20, .20));
            main.setPower(Range.clip(-mains, -.20, .50));
            dropper.setPower(Range.clip(-droppers, -.40, .50));

            while (gamepad1.dpad_left)
            {
            brace.setPower(-.35);
            }

            if (gamepad1.b)
            {
                brace.setPower(0);
            }

            while (gamepad1.dpad_right)
            {
                brace.setPower(.35);
            }

            //abcdefghijklmnopqrstuvwxyz
        }
    }
}