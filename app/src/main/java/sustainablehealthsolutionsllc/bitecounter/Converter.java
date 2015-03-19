package sustainablehealthsolutionsllc.bitecounter;

/**
 * Created by Matthew on 2/25/2015.
 * @author Matthew Hansen
 */
public class Converter {
    boolean isMetric;
    float height;
    float weight;


    /**
     * This mutator function sets whether the
     * data being entered is in the metric
     * system or in the imperial system.
     */
    public void setIsMetric(boolean newIsMetric)  {
        this.isMetric = newIsMetric;
    }

    /**
     * This accessor function return a
     * boolean value of whether the function
     * is metric or not.
     */

    public boolean getIsMetric()  {
        return this.isMetric;
    }

    /**
     * This mutator function sets the height.
     * Although it is best if the user doesn't
     * use this function, because it may be
     * hard to decide if you set it in
     * meters or in inches which is uber
     * necessary for the bmi to have.
     * The getter function will do the
     * work for you. So relax.
     */
    public void setHeight(float newHeight) {
        this.height = newHeight;
    }

    /**
     * This accessor function actually
     * calls the calcHeight() function
     * in order to set the correct height.
     * Then it returns that value to the
     * caller.
     */
    public float getHeight()  {
        return this.height;
    }

    public void setWeight(float newWeight) {
        if(getIsMetric()) {
            this.weight = newWeight;
        } else {
            this.weight = .453592f * newWeight;
        }

    }

    public float getWeight () {
        return this.weight;
    }

    public void parser (float newHeight)  {
        String height = String.valueOf(newHeight);
        String delims = "[. ']+";
        String [] splitHeight = height.split(delims);
        Float large = Float.valueOf(splitHeight[0]);
        Float small = Float.valueOf(splitHeight[1]);
        if (small > 12) {
            setIsMetric(true);
            setHeight(large + small);
        } else {
            setIsMetric(false);
            large = large * 12;
            small = large + small;
            setHeight(small * .0254f);
        }


    }

}
