package org.example.functions.Models;

public class Studie {
    enum Eye {
        LEFT,
        RIGHT
    }
    private int patientID;
    private Eye eye;
    private double sphereDiopter;
    private double cylinderDiopter;
    private int axis;

    public Studie(int patientID, Eye eye, double sphereDiopter, double cylinderDiopter, int axis) {
        this.patientID = patientID;
        this.eye = eye;
        this.sphereDiopter = sphereDiopter;
        this.cylinderDiopter = cylinderDiopter;
        this.axis = axis;
    }
    public Studie(int patientID, String eye, double sphereDiopter, double cylinderD, int axis) {
        this.patientID = patientID;
        //string convert enum
        try {
            this.eye = Eye.valueOf(eye.toUpperCase());
        }catch (Exception e) {
            this.eye = Eye.LEFT;
        }

        this.sphereDiopter = sphereDiopter;
        this.cylinderDiopter = cylinderDiopter;
        this.axis = axis;
    }

    public int getPatientID() {
        return patientID;
    }

    public Eye getEye() {
        return eye;
    }

    public double getSphereDiopter() {
        return sphereDiopter;
    }

    public double getCylinderDiopter() {
        return cylinderDiopter;
    }

    public int getAxis() {
        return axis;
    }
}
