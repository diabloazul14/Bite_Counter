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
}
