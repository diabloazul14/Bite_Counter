package sustainablehealthsolutionsllc.bitecounter;

/**
 * Created by Matthew on 2/27/2015.
 */
public class Tester {
    public static void main(String args[])  {
        Tester test = new Tester();
        test.run(args);
    }

    private void run(String[] args)  {
        if (args[0].equals("counter"))  {
            countTest();
        }

        if (args[0].equals("converter"))  {
            converterTest();
        }

        if (args[0].equals("bmi"))  {
            bmiTest();
            bmiTest1();
            bmiTest2();
        }
        System.out.println("Tests Completed :)");

    }

    private void counterTest()  {
        Counter counter = new Counter();
        int limit = 0;
        for (int i = 0; i < 100; i++)  {
            counter.incrementBite();
            limit = i;
        }
        limit = limit * 10;
        counter.setLimit(limit);
        System.out.println("Are we past the limit? ");
        if (counter.getPastLimit())  {
            System.out.println("Past the limit");
        } else {
            System.out.println("Not past the limit");
        }
    }

    private void converterTest()  {
        Converter converter = new Converter();
        converter.setIsMetric(true);
        if (converter.getIsMetric())  {
            converter.setMeters(1);
            converter.setCentimeters(64);
            System.out.println("Meters: " + converter.getMeters());
            System.out.println("Centimeters: " + converter.getCentimeters());
            System.out.println("Height(Meters): " + converter.getHeight());
        } else {
            converter.setFeet(7);
            converter.setInches(20);
            System.out.println("Feet: " + converter.getFeet());
            System.out.println("Inches: " + converter.getInches());
            System.out.println("Height(Inches): " + converter.getHeight());
        }
    }

    private void bmiTest() {
        BMI bmi = new BMI();
        bmi.setHeight(72);
        bmi.setWeight(280);
        bmi.calcBmi();
        System.out.println("The BMI is " + bmi.getBmi());

    }
    /***
     * bmiTest1
     * by John Decker
     */
    private void bmiTest1() {

        BMI bmiTest = new BMI();

        //I am trying to break it
        bmiTest.setBmi(300000000);
        bmiTest.calcBmi();
        bmiTest.setIsEntered();
        bmiTest.height = 10000;
        bmiTest.bmi = -55550;

        //this is to check if we have entered information
        assert((bmiTest.getIsEntered() != true));

        bmiTest.calcBmi();
        bmiTest.setWeight(-400000);
        bmiTest.calcBmi();
        System.out.println("The BMI is " + bmiTest.getBmi());
    }

    private void bmiTest2() {

        BMI bmiTest2 = new BMI();


        for(int i = -2000; i < 4000; ++i) {
            bmiTest2.setWeight(i);
            bmiTest2.setHeight(i*34);

            //lets see if it is entered?
            assert(bmiTest2.getIsEntered());


        }

    }

    private void countTest() {
        Counter counter = new Counter();
        int count = 0;
        for (int i = 0; i <= 100; i++)
        {
            counter.incrementBite();
            count = i;
        }
        counter.setLimit(count);
        System.out.println("Limit: " + counter.getLimit());
        counter.reduceBy20();
        System.out.println("Limit After Reduce: " + counter.getLimit());
    }


}
