package com.akos.models.modules;

import javafx.scene.paint.Color;
import org.junit.*;
import org.meanbean.test.BeanTester;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */
public class RGBLedModuleModelTest {

    RGBLedModuleModel model;

    @Before
    public void setUp() throws Exception {
        model = new RGBLedModuleModel();
        model.setIntensity(0);
        model.setColor(new Color(0, 0, 0, 1));
        model.setPredefColor(RGBLedModuleModel.PredefColor.OFF);
    }

    @Test
    public void getterAndSetterCorrectness() throws Exception {
        new BeanTester().testBean(RGBLedModuleModelTest.class);
    }

    @Test
    public void testGetCompiledValue() throws Exception {
        model.setLedType(LEDType.MAIN_LED_RGB);
        Assert.assertArrayEquals(new String[]{"RGB 0,0,0"}, model.getCompiledValue());

        model.setLedType(LEDType.MAIN_LED_PRESET);
        Assert.assertArrayEquals(new String[]{"LEDC 0"}, model.getCompiledValue());

        model.setLedType(LEDType.BACK_LED);
        Assert.assertArrayEquals(new String[]{"backLED 0"}, model.getCompiledValue());
    }
}