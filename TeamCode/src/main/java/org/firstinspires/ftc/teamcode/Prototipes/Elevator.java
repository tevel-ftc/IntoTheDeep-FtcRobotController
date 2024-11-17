package org.firstinspires.ftc.teamcode.Prototipes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class Elevator {

    private DcMotor elevatorExtend;
    private DcMotor elevatorArm;

    private OpMode opMode;

    public Elevator(OpMode opMode) {
        this.opMode = opMode;
    }

    public void initElevator(){
        elevatorExtend  = opMode.hardwareMap.get(DcMotor.class, "elevatorExtend");
        elevatorArm = opMode.hardwareMap.get(DcMotor.class, "elevatorArm");
        elevatorArm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    // this function use value (like the gamepad stick) to give the extension motor power.
    public void extend(double extension){
        elevatorExtend.setPower(extension);
        if (elevatorExtend.getPower()<=0.3){
            elevatorExtend.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }
    }
    // this function use value (like the gamepad stick) to give the rotation motor power.
    public void rotateForword(){
//        elevatorArm.setPower(rotation);
        if(elevatorArm.getCurrentPosition()>=20000){
            elevatorArm.setTargetPosition(elevatorArm.getCurrentPosition());
        }
        else {elevatorArm.setTargetPosition(elevatorArm.getCurrentPosition()+200);} // todo check real limit numbers

    }
    public void rotateBackword(){
//        elevatorArm.setPower(rotation);
        if(elevatorArm.getCurrentPosition()<=20000){
            elevatorArm.setTargetPosition(elevatorArm.getCurrentPosition());
        }
        else {elevatorArm.setTargetPosition(elevatorArm.getCurrentPosition()-200);} // todo check real limit numbers
    }

}

