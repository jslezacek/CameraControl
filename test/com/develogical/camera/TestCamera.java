package com.develogical.camera;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.Sequence;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.reflect.Member;

@RunWith(value = JMock.class)
public class TestCamera {
    Mockery context = new Mockery();

    Sensor s = context.mock(Sensor.class);
    MemoryCard m = context.mock(MemoryCard.class);
    Camera c = new Camera(s);
    byte[] testarray = new byte[0];

    @Test
    public void switchingTheCameraOnPowersUpTheSensor() {
        context.checking(new Expectations() {{
        exactly(1).of(s).powerUp();}
        });

        c.powerOn();
    }


    @Test
    public void switchingTheCameraOffPowersDownTheSensor() {
        context.checking(new Expectations() {{
            exactly(1).of(s).powerDown();}
        });

        c.powerOff();
    }

    @Test
    // expected state OFF
    public void pressShutterWhenPowerOffDoesNada() {
        context.checking(new Expectations() {{
            never(s);
        }
        });

        c.pressShutter();
    }

    @Test
    public void pressShutterWhenPowerOnCopiesData() {
            context.checking(new Expectations() {{
                exactly(1).of(s).readData(); will(returnValue(testarray));
                exactly(1).of(m).write(testarray);
            }
            });
            c.pressShutter();
    }
}
