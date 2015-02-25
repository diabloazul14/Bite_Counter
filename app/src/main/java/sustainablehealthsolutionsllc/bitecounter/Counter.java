package sustainablehealthsolutionsllc.bitecounter;

public class Counter {
    int numBites;
    int limit;
    boolean pastLimit;

    /**
     * This is the default constructor for the Counter class.
     */
    Counter() {
        this.numBites = 0;
        this.limit = 0;
        this.pastLimit = false;
    }

    /**
     * This is a constructor for the Counter class that
     * sets the Limit when it is constructed.
     * @param newLimit
     */
    Counter(int newLimit) {
        this.numBites = 0;
        this.limit = newLimit;
        this.pastLimit = false;
    }

    /**
     * This is a mutator function that sets the
     * number of bites.
     * @param newNumBites
     */
    public void setNumBites(int newNumBites) {
        this.numBites = newNumBites;
    }

    /**
     * This is an accessor function that returns
     * the Counter objects number of bites.
     * @return
     */
    public int getNumBites() {
        return this.numBites;
    }

    /**
     * This is a mutator function that sets
     * the limit.
     * @param newLimit
     */
    public void setLimit(int newLimit) {
        this.limit = newLimit;
    }

    /**
     * This is an accessor function that returns the
     * limit of the counter class.
     * @return
     */
    public int getLimit() {
        return this.limit;
    }

    /**
     * This is a mutator that sets the isLimit value
     * of the class.
     * @param newIsLimit
     */
    public void setPastLimit(boolean newIsLimit) {
        this.pastLimit = newIsLimit;
    }

    /**
     * This getter determines whether or not
     * the number of bites is higher than the limit.
     * If it returns true than it's past the limit.
     * If it returns false it isn't past the limit.
     * @return
     */
    public boolean getPastLimit() {
        return (this.getNumBites() > this.getLimit());
    }

    /**
     * This function increments the number of bites by 1.
     */
    public void incrementBite() {
        this.numBites += 1;
    }

    /**
     * This function takes the current limit and reduces it
     * by 20 percent.
     */
    public void reduceBy20() {
        this.limit = this.limit - (this.limit / 5);
    }
}
