package sustainablehealthsolutionsllc.bitecounter;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.Calendar;

/**
 * This class is awesome. It holds all the information you'ld
 * need for a bite counter.
 */
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
    public void incrementBite(Context context) {
        this.numBites += 1;
        saveBites(context);
        saveLimit(context);

    }

    /**
     * This function takes the current limit and reduces it
     * by 20 percent.
     */
    public void reduceBy20(Context context) {
        float average = average(context);
        float reduced = average - (average / 5);
        this.limit = Math.round(reduced);


    }

    /**
     * This function simply sets the number of bites
     * back to zero and sets the pastLimit boolean
     * to false. It doesn't change the limit though.
     */
    public void resetCounter() {

        this.numBites = 0;
        this.pastLimit = false;
    }

    /**
     * This function saveds the numBites into a
     * location on the machine that allows a person
     * to quit the app and restart it with the correct
     * number of bites still being displayed.
     * @param context
     */
    public void saveBites (Context context)  {
        SharedPreferences settings = context.getSharedPreferences("PREFS_NAME", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("numberOfBites", this.numBites);
        editor.apply();
    }

    /**
     * This function finds the number of bites
     * from the previous section and returns it
     * to whatever function is calling it.
     * @param context
     * @return
     */
    public int retrieveBites(Context context)  {
        SharedPreferences settings = context.getSharedPreferences("PREFS_NAME", 0);
        int numBites = settings.getInt("numberOfBites", 0);
        return numBites;
    }

    /**
     * This function saves the limit into shared preferences.
     * @param context
     */
    public void saveLimit(Context context) {
        SharedPreferences settings = context.getSharedPreferences("PREFS_NAME", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("theLimit", this.limit);
        editor.apply();
    }

    /**
     * THis function retrieves the limit from shared preferences.
     * @param context
     * @return
     */
    public int retrieveLimit(Context context)  {
        SharedPreferences settings = context.getSharedPreferences("PREFS_NAME", 0);
        int theLimit = settings.getInt("theLimit", 0);
        return theLimit;
    }


    /**
     * This function saves mondays bites into shared preferences.
     * @param context
     */
    public void saveMonday(Context context) {
        SharedPreferences settings = context.getSharedPreferences("PREFS_NAME", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("monday", this.numBites);
        editor.apply();
    }

    /**
     * This function retrieves mondays bites from shared preferences.
     * @param context
     * @return
     */
    public int retrieveMonday(Context context)  {
        SharedPreferences settings = context.getSharedPreferences("PREFS_NAME", 0);
        int dailyNumBites = settings.getInt("monday", 0);
        return dailyNumBites;
    }

    /**
     * This function saves tuesday's bites into shared preferences.
     * @param context
     */
    public void saveTuesday(Context context) {
        SharedPreferences settings = context.getSharedPreferences("PREFS_NAME", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("tuesday", this.numBites);
        editor.apply();
    }

    /**
     * This function retrieves tuesday bites from shared preferences.
     * @param context
     * @return
     */
    public int retrieveTuesday(Context context)  {
        SharedPreferences settings = context.getSharedPreferences("PREFS_NAME", 0);
        int dailyNumBites = settings.getInt("tuesday", 0);
        return dailyNumBites;
    }

    /**
     * This function saves wednesday's bites into shared preferences.
     * @param context
     */
    public void saveWednesday(Context context) {
        SharedPreferences settings = context.getSharedPreferences("PREFS_NAME", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("wednesday", this.numBites);
        editor.apply();
    }

    /**
     * This function retrieves wednesday's bites from shared preferences.
     * @param context
     * @return
     */
    public int retrieveWednesday(Context context)  {
        SharedPreferences settings = context.getSharedPreferences("PREFS_NAME", 0);
        int dailyNumBites = settings.getInt("wednesday", 0);
        return dailyNumBites;
    }

    /**
     * This function saves thursday's bites into shared preferences.
     * @param context
     */
    public void saveThursday(Context context) {
        SharedPreferences settings = context.getSharedPreferences("PREFS_NAME", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("thursday", this.numBites);
        editor.apply();
    }

    /**
     * This function retrieves thursday's bites from shared preferences.
     * @param context
     * @return
     */
    public int retrieveThursday(Context context)  {
        SharedPreferences settings = context.getSharedPreferences("PREFS_NAME", 0);
        int dailyNumBites = settings.getInt("thursday", 0);
        return dailyNumBites;
    }

    /**
     * This function saves friday's bites into shared preferences.
     * @param context
     */
    public void saveFriday(Context context) {
        SharedPreferences settings = context.getSharedPreferences("PREFS_NAME", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("friday", this.numBites);
        editor.apply();
    }

    /**
     * This function retrieves fridays bites from shared preferences.
     * @param context
     * @return
     */
    public int retrieveFriday(Context context)  {
        SharedPreferences settings = context.getSharedPreferences("PREFS_NAME", 0);
        int dailyNumBites = settings.getInt("friday", 0);
        return dailyNumBites;
    }

    /**
     * This function saves saturday's bites into shared preferences.
     * @param context
     */
    public void saveSaturday(Context context) {
        SharedPreferences settings = context.getSharedPreferences("PREFS_NAME", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("saturday", this.numBites);
        editor.apply();
    }

    /**
     * This function retrieves saturday's bites from shared preferences.
     * @param context
     * @return
     */
    public int retrieveSaturday(Context context)  {
        SharedPreferences settings = context.getSharedPreferences("PREFS_NAME", 0);
        int dailyNumBites = settings.getInt("saturday", 0);
        return dailyNumBites;
    }

    /**
     * This function saves sunday's bites into shared preferences.
     * @param context
     */
    public void saveSunday(Context context) {
        SharedPreferences settings = context.getSharedPreferences("PREFS_NAME", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("sunday", this.numBites);
        editor.apply();
    }

    /**
     * This function retrieves sunday's bites from shared preferences.0
     * @param context
     * @return
     */
    public int retrieveSunday(Context context)  {
        SharedPreferences settings = context.getSharedPreferences("PREFS_NAME", 0);
        int dailyNumBites = settings.getInt("sunday", 0);
        return dailyNumBites;
    }
    //This is a useless comment.

    public float average(Context context) {
        int average = 0;
        //Sum up the 7 days
        average = retrieveSunday(context) + retrieveMonday(context) + retrieveTuesday(context)
                + retrieveWednesday(context) + retrieveThursday(context)
                + retrieveFriday(context) + retrieveSaturday(context);
        //Divide By 7
        float finalAverage = average;
        finalAverage = finalAverage / 7;
        return finalAverage;
    }
}