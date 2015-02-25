package sustainablehealthsolutionsllc.bitecounter;

/**
 * Created by Matthew on 2/24/2015.
 */
public class BMI {
    boolean isEntered;
    float height;
    float weight;
    float bmi;

    /**
     * This mutator function sets isEntered
     * to true or false depending on
     * whether or not the value of it
     * is zero or not. When the value is zero,
     * it is considered uninitialized.
     */
    public void setIsEntered()  {
        if (this.height != 0 && this.weight != 0)  {
            this.isEntered = true;
        } else {
            this.isEntered = false;
        }
    }

    /**
     * This mutator function returns isEntered's value.
     * @return
     */
    public boolean getIsEntered()  {
        return this.isEntered;
    }

    /**
     * This mutator function sets the height
     * value of this class.
     * @param newHeight
     */
    public void setHeight(float newHeight)  {
        this.height = newHeight;
    }

    /**
     * This accessor function returns the
     * height of this class.
     * @return
     */
    public float getHeight()  {
        return this.height;
    }

    /**
     * This mutator function sets the weight
     * of this class.
     * @param newWeight
     */
    public void setWeight(float newWeight)  {
        this.weight = newWeight;
    }

    /**
     * This accessor function returns the
     * weight of this class.
     * @return
     */
    public float getWeight()  {
        return this.weight;
    }

    /**
     * This mutator function sets the Bmi
     * of this class. Although it is better
     * to use the calcBmi().
     * @param newBmi
     */
    public void setBmi(float newBmi)  {
        this.bmi = newBmi;
    }

    /**
     * This accessor function returns
     * the bmi of this class.
     * @return
     */
    public float getBmi()  {
        return this.bmi;
    }

    /**
     * This function calculates the bmi
     * of this class. It first makes sure that
     * the height and weight have been entered.
     * If they haven't been entered it displays
     * a warning that a height and weight need
     * to be entered.
     */
    public void calcBmi() {
        setIsEntered();
        if (getIsEntered()) {
            this.bmi = 703 * (this.weight / (this.height * this.height));
        } else {
            //I need to change this into either a toast or something
            //better than toast(If that's possible). But Probably a input form.
            System.out.println("You need to enter in a height and a weight");
        }
    }

}
