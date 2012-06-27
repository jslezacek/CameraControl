package com.develogical.camera;

public class Camera {

    private Sensor sensor;

    public Camera(Sensor s) {
        this.sensor = s;
    }

    public void pressShutter() {
        // not implemented
    }

    public void powerOn() {
        this.sensor.powerUp();
    }

    public void powerOff() {
       // not implemented
    }
}

