package sustainablehealthsolutionsllc.bitecounter;

/**
 * Created by Matthew on 2/25/2015.
 */
public class Converter {
    boolean isMetric;
    double height;
    double feet;
    double inches;
    double centimeters;
    double meters;

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
     * This function sets the height.
     * It is called when the getter is
     * called in order for the caller
     * to receive the height in the right
     * units of measurement.
     */
    public void calcHeight()  {
        if (this.isMetric)  {
            this.setHeight(this.meters + (this.centimeters * .01));
        } else {
            this.setHeight((this.feet * 12) + this.inches);
        }
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
    public void setHeight(double newHeight) {
        this.height = newHeight;
    }

    /**
     * This accessor function actually
     * calls the calcHeight() function
     * in order to set the correct height.
     * Then it returns that value to the
     * caller.
     */
    public double getHeight()  {
        this.calcHeight();
        return this.height;
    }

    /**
     * This Mutator function sets the
     * feet variable in this class.
     */
    public void setFeet(double newFeet)  {
        this.feet = newFeet;
    }

    /**
     * This accessor function returns
     * the value of the feet in this
     * class.
     */
    public double getFeet()  {
        return this.feet;
    }

    /**
     * This mutator function sets the
     * inches of this class.
     */
    public void setInches(double newInches)  {
        this.inches = newInches;
    }

    /**
     * This accessor function returns
     * the inches of this class.
     */
    public double getInches()  {
        return this.inches;
    }

    /**
     * This mutator function sets the
     * meters variable of this class.
     */
    public void setMeters(double newMeters)  {
        this.meters = newMeters;
    }

    /**
     * This accessor function
     * returns the meters
     * variable of this class.
     */
    public double getMeters()  {
        return this.meters;
    }

    /**
     * This mutator functions sets the centimeters
     * of this class.
     */
    public void setCentimeters(double newCentimeters)  {
        this.centimeters = newCentimeters;
    }

    /**
     * This accessor function returns the
     * centimeters of this class
     */
    public double getCentimeters()  {
        return this.centimeters;
    }

}
