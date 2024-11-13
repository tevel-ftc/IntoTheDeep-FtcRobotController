package org.firstinspires.ftc.teamcode.Prototipes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class Elevator {
    private DcMotor elevatorExtend;
    private DcMotor elevatorArm;

    private OpMode opMode;

    Elevator(OpMode opMode) {
        this.opMode = opMode;
    }

    public void initElevator(){
        elevatorExtend  = opMode.hardwareMap.get(DcMotor.class, "elevatorExtend");
        elevatorArm = opMode.hardwareMap.get(DcMotor.class, "elevatorArm");
    }

    // this function use value (like the gamepad stick) to give the extension motor power.
    public void extend(double extension){
        elevatorExtend.setPower(extension);
    }

    // this function use value (like the gamepad stick) to give the rotation motor power.
    public void rotate(double rotation){
        elevatorArm.setPower(rotation);
    }
}
