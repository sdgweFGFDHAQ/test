package TesT.test;

import junit.framework.TestCase;

public class SaleMachineTest extends TestCase {

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }
    public void testSaleMachine1() {
        SaleMachine salemachine1 = new SaleMachine();
        String expectedResult = "Input Information\n" +
                "Type:Beer;Money:5 Cents; Change:0\n\n" +
                "Current State\n" +
                "Beer:                  5" + "\n" +
                "Orange Juice:          6" + "\n" +
                "5 Cents:               7" + "\n" +
                "1 Dollar:              6";
        assertEquals(expectedResult, salemachine1.operation("Beer", "5C"));
    }

    public void testSaleMachine2() {
        SaleMachine salemachine2 = new SaleMachine();
        String expectedResult = "Input Information\n" +
                "Type: OrangeJuice; Money:5 Cents; Change:0\n\n" +
                "Current State\n" +
                "Beer:                  6" + "\n" +
                "Orange Juice:          5" + "\n" +
                "5 Cents:               7" + "\n" +
                "1 Dollar:              6";
        assertEquals(expectedResult, salemachine2.operation("OrangeJuice", "5C"));
    }

    public void testSaleMachine3() {
        SaleMachine salemachine3 = new SaleMachine();
        String expectedResult = "Input Information\n" +
                "Type:Beer; Money:1 Dollar; Change:5 Cents\n\n" +
                "Current State\n" +
                "Beer:                  5" + "\n" +
                "Orange Juice:          6" + "\n" +
                "5 Cents:               5" + "\n" +
                "1 Dollar:              7";
        assertEquals(expectedResult, salemachine3.operation("Beer", "1D"));
    }

    public void testSaleMachine4() {

        SaleMachine salemachine4 = new SaleMachine(6, 6, 6, 0);
        String result = salemachine4.operation("OrangeJuice", "1D");
        String expectedResult = "Failure Information\n" + "OrangeJuice Shortage";
        assertEquals("You have pay for the beer.Please pick it up.", expectedResult, result);
    }


    public void testSaleMachine5() {
        SaleMachine salemachine5 = new SaleMachine();
        String result = salemachine5.operation("OrangeJuice", "1D");
        String expectedResult = "Input Information\n" +
                "Type: OrangeJuice; Money: 1 Dollar; Change: 5 Cents\n\n" +
                "Current State\n" +
                "Beer:                  6" + "\n" +
                "Orange Juice:          5" + "\n" +
                "5 Cents:               5" + "\n" +
                "1 Dollar:              7";
        assertEquals(expectedResult, result);
    }

    public void testSaleMachine6() {
        SaleMachine salemachine6 = new SaleMachine(0, 6, 6, 6);
        String result = salemachine6.operation("OrangeJuice", "1D");
        String expectedResult = "Failure Information\n" + "Change Shortage";
        assertEquals(expectedResult, salemachine6.operation("Beer", "1D"));
    }

    public void testSaleMachine7() {
        SaleMachine salemachine7 = new SaleMachine(6, 6, 0, 6);
        String expectedResult = "Failure Information\n" + "Beer Shortage";
        assertEquals(expectedResult, salemachine7.operation("Beer", "1D"));
    }
}

