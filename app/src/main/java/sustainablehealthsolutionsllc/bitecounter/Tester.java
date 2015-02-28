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
            counterTest();
        }

        if (args[0].equals("converter"))  {
            converterTest();
        }

        if (args[0].equals("bmi"))  {
            bmiTest();
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

    private void bmiTest()  {
        BMI bmi = new BMI();
        bmi.setHeight(72);
        bmi.setWeight(280);
        bmi.calcBmi();
        System.out.println("The BMI is " + bmi.getBmi());

    }

    // Test 1 Passed
    private void countTest() {
        System.out.println("\nTest1:\n---------");
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

    // Test 2 Try to Assert but still display negative numbers
    private void countTest2() {
        System.out.println("\n\n\nTest2:\n---------");
        Counter counter = new Counter();

        // Limit NOW = 100 bites
        counter.setLimit(100);
        System.out.println("Limit (100): " + counter.getLimit());
        System.out.println("Num Bites (0): " + counter.getNumBites());

//		counter.setPastLimit(false);
        for (int i = 1; i <= 111; i++)
        {
            // Counter
            counter.incrementBite();

            // If limit > 100 bites, update New Limit
            if (counter.getPastLimit()) {
                counter.setLimit(counter.getNumBites());
            }
        }

        // NOW LIMIT = 111; NUMBITES = 111
        System.out.println("\nNew Limit (111): " + counter.getLimit());
        System.out.println("NumBites (111): " + counter.getNumBites());

        // TEST WITH NEGATIVE LIMIT
        counter.setLimit(-100);
        System.out.println("\nNegative Limit (-100): " + counter.getLimit());
        // ASSERT NON-NEGATIVE LIMIT
        assert (counter.getLimit() >= 0);
        System.out.println("Limit (Assert): " + counter.getLimit());


        // TEST REDUCE BY 20 2 TIMES
        counter.reduceBy20();
        System.out.println("\nLimit Reduce (-80): " + counter.getLimit());
        counter.reduceBy20();
        System.out.println("Limit Reduce (-64): " + counter.getLimit());

        // TEST NUMBITES
        System.out.println("\nNumBites (111): " + counter.getNumBites());
        counter.setNumBites(-2000);
        System.out.println("NumBites (-2000): " + counter.getNumBites());
        counter.setNumBites(-300);
        System.out.println("NumBites (-300): " + counter.getNumBites());
        // ASSERT NON-NEGATIVE NUMBITES
        assert (counter.getNumBites() >= 0);
        System.out.println("NumBites (Assert): " + counter.getNumBites());
    }

}
