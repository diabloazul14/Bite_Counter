package sustainablehealthsolutionsllc.bitecounter;


import org.achartengine.ChartFactory;
import org.achartengine.chart.BarChart.Type;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint.Align;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.Calendar;

/**
 * Display Graphs:
 * This class will display the two bites and weights graphs
 * and updates the graphs when users swipe to the layout
 * linked to this class.
 */
public class Graph extends ActionBarActivity {

    // Instances Declaration
    Counter counter = new Counter();
    BMI bmi = new BMI();
    Context context;
    Calendar calendar = Calendar.getInstance();
    private View mChart;
    private Integer[] bites = new Integer[] {
            0,0,0,0,0,0,0
    };
    private float[] weights = new float[] {
            0f,0f,0f,0f,0f,0f,0f
    };
    private String[] mMonth = new String[] {
            "", "", "", "", "", "", ""
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graph);
        context = getApplicationContext();

        // Getting reference to the button btn_chart
        Button btnBack = (Button) findViewById(R.id.backButton);
        biteGraph();
        weightGraph();
        // back button to go to first activity
        OnClickListener clickListenerBack = new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Graph.this, BiteCounter.class);
                startActivity(intent);
            }
        };
        btnBack.setOnClickListener(clickListenerBack);
    }

    /**
     * Date of Week:
     * This simply updates date of week and display on the graph correctly
     */
    public void dateOfWeek() {
        int dayCurrent = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayCurrent == 1) {
            mMonth[6] = "Today";   mMonth[5] = "Sat";  mMonth[4] = "Fri";
            mMonth[3] = "Thur"; mMonth[2] = "Wed"; mMonth[1] = "Tue";
            mMonth[0] = "Mon";
        }
        if (dayCurrent == 2) {
            mMonth[6] = "Today";   mMonth[5] = "Sun";    mMonth[4] = "Sat";
            mMonth[3] = "Fri";   mMonth[2] = "Thu";  mMonth[1] = "Wed";
            mMonth[0] = "Tue";
        }
        if (dayCurrent == 3) {
            mMonth[6] = "Tue";  mMonth[5] = "Mon";    mMonth[4] = "Sun";
            mMonth[3] = "Sat"; mMonth[2] = "Fri";    mMonth[1] = "Thu";
            mMonth[0] = "Wed";
        }
        if (dayCurrent == 4) {
            mMonth[6] = "Today"; mMonth[5] = "Tue"; mMonth[4] = "Mon";
            mMonth[3] = "Sun";   mMonth[2] = "Sat"; mMonth[1] = "Fri";
            mMonth[0] = "Thu";
        }
        if (dayCurrent == 5) {
            mMonth[6] = "Today"; mMonth[5] = "Wed";   mMonth[4] = "Tue";
            mMonth[3] = "Mon"; mMonth[2] = "Sun"; mMonth[1] = "Sat";
            mMonth[0] = "Fri";
        }
        if (dayCurrent == 6) {
            mMonth[6] = "Today"; mMonth[5] = "Thu";   mMonth[4] = "Wed";
            mMonth[3] = "Tue"; mMonth[2] = "Mon"; mMonth[1] = "Sun";
            mMonth[0] = "Sat";
        }
        if (dayCurrent == 7) {
            mMonth[6] = "Today"; mMonth[5] = "Fri";   mMonth[4] = "Thu";
            mMonth[3] = "Wed"; mMonth[2] = "Tue"; mMonth[1] = "Mon";
            mMonth[0] = "Sun";
        }
    }

    /**
     * Bite of Week:
     * This simply updates bites of week and display on the graph correctly
     */
    public void biteOfWeek() {
        int dayCurrent = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayCurrent == 1) {
            bites[6] = counter.retrieveSunday(context);
            bites[5] = counter.retrieveSaturday(context);
            bites[4] = counter.retrieveFriday(context);
            bites[3] = counter.retrieveThursday(context);
            bites[2] = counter.retrieveWednesday(context);
            bites[1] = counter.retrieveTuesday(context);
            bites[0] = counter.retrieveMonday(context);
        }
        if (dayCurrent == 2) {
            bites[6] = counter.retrieveMonday(context);
            bites[5] = counter.retrieveSunday(context);
            bites[4] = counter.retrieveSaturday(context);
            bites[3] = counter.retrieveFriday(context);
            bites[2] = counter.retrieveThursday(context);
            bites[1] = counter.retrieveWednesday(context);
            bites[0] = counter.retrieveTuesday(context);
        }
        if (dayCurrent == 3) {
            bites[6] = counter.retrieveTuesday(context);
            bites[5] = counter.retrieveMonday(context);
            bites[4] = counter.retrieveSunday(context);
            bites[3] = counter.retrieveSaturday(context);
            bites[2] = counter.retrieveFriday(context);
            bites[1] = counter.retrieveThursday(context);
            bites[0] = counter.retrieveWednesday(context);
        }
        if (dayCurrent == 4) {
            bites[6] = counter.retrieveWednesday(context);
            bites[5] = counter.retrieveTuesday(context);
            bites[4] = counter.retrieveMonday(context);
            bites[3] = counter.retrieveSunday(context);
            bites[2] = counter.retrieveSaturday(context);
            bites[1] = counter.retrieveFriday(context);
            bites[0] = counter.retrieveThursday(context);
        }
        if (dayCurrent == 5) {
            bites[6] = counter.retrieveThursday(context);
            bites[5] = counter.retrieveWednesday(context);
            bites[4] = counter.retrieveTuesday(context);
            bites[3] = counter.retrieveMonday(context);
            bites[2] = counter.retrieveSunday(context);
            bites[1] = counter.retrieveSaturday(context);
            bites[0] = counter.retrieveFriday(context);
        }
        if (dayCurrent == 6) {
            bites[6] = counter.retrieveFriday(context);
            bites[5] = counter.retrieveThursday(context);
            bites[4] = counter.retrieveWednesday(context);
            bites[3] = counter.retrieveTuesday(context);
            bites[2] = counter.retrieveMonday(context);
            bites[1] = counter.retrieveSunday(context);
            bites[0] = counter.retrieveSaturday(context);
        }
        if (dayCurrent == 7) {
            bites[6] = counter.retrieveSaturday(context);
            bites[5] = counter.retrieveFriday(context);
            bites[4] = counter.retrieveThursday(context);
            bites[3] = counter.retrieveWednesday(context);
            bites[2] = counter.retrieveTuesday(context);
            bites[1] = counter.retrieveMonday(context);
            bites[0] = counter.retrieveSunday(context);
        }
    }

    /**
     * Weight of Week:
     * This simply updates weight of week and display on the graph correctly
     */
    public void weightOfWeek() {
        int dayCurrent = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayCurrent == 1) {
            weights[6] = (int) bmi.retrieveSundayWeight(context);
            weights[5] = (int) bmi.retrieveSaturdayWeight(context);
            weights[4] = (int) bmi.retrieveFridayWeight(context);
            weights[3] = (int) bmi.retrieveThursdayWeight(context);
            weights[2] = (int) bmi.retrieveWednesdayWeight(context);
            weights[1] = (int) bmi.retrieveTuesdayWeight(context);
            weights[0] = (int) bmi.retrieveMondayWeight(context);
        }
        if (dayCurrent == 2) {
            weights[6] = (int) bmi.retrieveMondayWeight(context);
            weights[5] = (int) bmi.retrieveSundayWeight(context);
            weights[4] = (int) bmi.retrieveSaturdayWeight(context);
            weights[3] = (int) bmi.retrieveFridayWeight(context);
            weights[2] = (int) bmi.retrieveThursdayWeight(context);
            weights[1] = (int) bmi.retrieveWednesdayWeight(context);
            weights[0] = (int) bmi.retrieveTuesdayWeight(context);
        }
        if (dayCurrent == 3) {
            weights[6] = (int) bmi.retrieveTuesdayWeight(context);
            weights[5] = (int) bmi.retrieveMondayWeight(context);
            weights[4] = (int) bmi.retrieveSundayWeight(context);
            weights[3] = (int) bmi.retrieveSaturdayWeight(context);
            weights[2] = (int) bmi.retrieveFridayWeight(context);
            weights[1] = (int) bmi.retrieveThursdayWeight(context);
            weights[0] = (int) bmi.retrieveWednesdayWeight(context);
        }
        if (dayCurrent == 4) {
            weights[6] = (int) bmi.retrieveWednesdayWeight(context);
            weights[5] = (int) bmi.retrieveTuesdayWeight(context);
            weights[4] = (int) bmi.retrieveMondayWeight(context);
            weights[3] = (int) bmi.retrieveSundayWeight(context);
            weights[2] = (int) bmi.retrieveSaturdayWeight(context);
            weights[1] = (int) bmi.retrieveFridayWeight(context);
            weights[0] = (int) bmi.retrieveThursdayWeight(context);
        }
        if (dayCurrent == 5) {
            weights[6] = (int) bmi.retrieveThursdayWeight(context);
            weights[5] = (int) bmi.retrieveWednesdayWeight(context);
            weights[4] = (int) bmi.retrieveTuesdayWeight(context);
            weights[3] = (int) bmi.retrieveMondayWeight(context);
            weights[2] = (int) bmi.retrieveSundayWeight(context);
            weights[1] = (int) bmi.retrieveSaturdayWeight(context);
            weights[0] = (int) bmi.retrieveFridayWeight(context);
        }
        if (dayCurrent == 6) {
            weights[6] = (int) bmi.retrieveFridayWeight(context);
            weights[5] = (int) bmi.retrieveThursdayWeight(context);
            weights[4] = (int) bmi.retrieveWednesdayWeight(context);
            weights[3] = (int) bmi.retrieveTuesdayWeight(context);
            weights[2] = (int) bmi.retrieveMondayWeight(context);
            weights[1] = (int) bmi.retrieveSundayWeight(context);
            weights[0] = (int) bmi.retrieveSaturdayWeight(context);
        }
        if (dayCurrent == 7) {
            weights[6] = (int) bmi.retrieveSaturdayWeight(context);
            weights[5] = (int) bmi.retrieveFridayWeight(context);
            weights[4] = (int) bmi.retrieveThursdayWeight(context);
            weights[3] = (int) bmi.retrieveWednesdayWeight(context);
            weights[2] = (int) bmi.retrieveTuesdayWeight(context);
            weights[1] = (int) bmi.retrieveMondayWeight(context);
            weights[0] = (int) bmi.retrieveSundayWeight(context);
        }
    }

    /**
     * Bite Graph:
     * Draw the customized bite graph and display it on the related layout
     */
    private void biteGraph(){
        int[] x = {0, 1, 2, 3, 4, 5, 6};
        // update bites of week
        biteOfWeek();

        // Creating an XYSeries for bites
        XYSeries bitesSeries = new XYSeries("bites");
        // Adding data to bites and Expense Series
        for(int i=0;i<x.length;i++){
            bitesSeries.add(i,bites[i]);
        }

        // Creating a dataset to hold each series
        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
        // Adding bites Series to the dataset
        dataset.addSeries(bitesSeries);

        // Creating XYSeriesRenderer to customize bitesSeries
        XYSeriesRenderer bitesRenderer = new XYSeriesRenderer();
        bitesRenderer.setColor(Color.rgb(88,87,87)); //color of the graph set to black
        bitesRenderer.setFillPoints(true);
        bitesRenderer.setLineWidth(2);
        bitesRenderer.setDisplayChartValues(true);
        bitesRenderer.setDisplayChartValuesDistance(10); //setting chart value distance

        // Creating a XYMultipleSeriesRenderer to customize the whole chart
        XYMultipleSeriesRenderer multiRenderer = new XYMultipleSeriesRenderer();
        multiRenderer.setOrientation(XYMultipleSeriesRenderer.Orientation.HORIZONTAL);
        multiRenderer.setXLabels(0);
        multiRenderer.setChartTitle("Bites");

        /***
         * Customizing graphs
         */
        // setting text size of chart value
        bitesRenderer.setChartValuesTextSize(35);
        // setting text align of chart value
        bitesRenderer.setChartValuesTextAlign(Align.CENTER);
        // setting text spacing of chart value
        bitesRenderer.setChartValuesSpacing(20);
        // setting text size of the title
        multiRenderer.setChartTitleTextSize(30); //28
        // setting text size of the axis title
        multiRenderer.setAxisTitleTextSize(30); //24
        // setting text size of the graph lable
        multiRenderer.setLabelsTextSize(30); //24
        // setting zoom buttons visiblity
        multiRenderer.setZoomButtonsVisible(false);
        // setting pan enablity which uses graph to move on both axis
        multiRenderer.setPanEnabled(false, false);
        // setting click false on graph
        multiRenderer.setClickEnabled(false);
        // setting zoom to false on both axis
        multiRenderer.setZoomEnabled(false, false);
        // setting lines to display on y axis
        multiRenderer.setShowGridY(false);
        // setting lines to display on x axis
        multiRenderer.setShowGridX(false);
        // setting legend to fit the screen size
        multiRenderer.setFitLegend(false); // true
        // setting displaying line on grid
        multiRenderer.setShowGrid(false);
        // setting zoom to false
        multiRenderer.setZoomEnabled(false);
        // setting external zoom functions to false
        multiRenderer.setExternalZoomEnabled(false);
        // setting displaying lines on graph to be formatted(like using graphics)
        multiRenderer.setAntialiasing(true); // true
        // setting to in scroll to false
        multiRenderer.setInScroll(false);
        // setting to set legend height of the graph
        multiRenderer.setShowLegend(false);
        multiRenderer.setLegendHeight(30);
        // setting x axis label align
        multiRenderer.setXLabelsAlign(Align.CENTER);
        // setting y axis label to align
        multiRenderer.setYLabelsAlign(Align.LEFT);
        // setting text style
        multiRenderer.setTextTypeface("arial", Typeface.BOLD);
        // setting no of values to display in y axis
        multiRenderer.setYLabels(0);
        // setting y axis max value, Since i'm using static values inside the graph so i'm setting y max value to 4000.
        // if you use dynamic values then get the max y value and set here
        multiRenderer.setYAxisMax(/*counter.retrieveLimit(context)*/200);
        // setting y min value
        multiRenderer.setYAxisMin(0);
        // setting x label's color
        multiRenderer.setXLabelsColor(Color.rgb(88,87,87));
        //setting used to move the graph on x-axis to .5 to the right
        multiRenderer.setXAxisMin(-.5);
        // setting max values to be display in x axis
        multiRenderer.setXAxisMax(7);
        //setting bar size or space between two bars
        multiRenderer.setBarSpacing(0.5);
        //setting background color of the graph to transparent
        multiRenderer.setBackgroundColor(Color.TRANSPARENT);
        //setting margin color of the graph to transparent
        multiRenderer.setMarginsColor(getResources().getColor(R.color.transparent_background));
        // setting enablity background color
        multiRenderer.setApplyBackgroundColor(true);
        //setting the margin size for the graph in the order top, left, bottom, right
        multiRenderer.setMargins(new int[]{30, 30, 30, 30}); // 30,30,30,30
        // update date of week
        dateOfWeek();
        for(int i=0; i< x.length;i++) {
            multiRenderer.addXTextLabel(i, mMonth[i]);
        }

        // Adding bitesRenderer and expenseRenderer to multipleRenderer
        // Note: The order of adding dataseries to dataset and renderers to multipleRenderer
        // should be same
        multiRenderer.addSeriesRenderer(bitesRenderer);
        //this part is used to display graph on the xml
        LinearLayout chartContainer = (LinearLayout) findViewById(R.id.chart);
        //remove any views before u paint the chart
        chartContainer.removeAllViews();
        //drawing bar chart
        mChart = ChartFactory.getBarChartView(Graph.this, dataset, multiRenderer,Type.DEFAULT);
        //adding the view to the linear layout
        chartContainer.addView(mChart);
    }

    /**
     * Weight Graph:
     * DDraw the customized weight graph and display it on the related layout
     */
    private void weightGraph(){
        int[] x = {0, 1, 2, 3, 4, 5, 6};
        // update weight of week
        weightOfWeek();

        // Creating an XYSeries for weights
        XYSeries weightsSeries = new XYSeries("weights");
        // Adding data to weights and Expense Series
        for(int i=0;i<x.length;i++) {
            weightsSeries.add(i,weights[i]);
        }

        // Creating a dataset to hold each series
        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
        // Adding weights Series to the dataset
        dataset.addSeries(weightsSeries);

        // Creating XYSeriesRenderer to customize weightsSeries
        XYSeriesRenderer weightsRenderer = new XYSeriesRenderer();
        weightsRenderer.setColor(Color.rgb(88,87,87)); //color of the graph set to black
        weightsRenderer.setFillPoints(true);
        weightsRenderer.setLineWidth(2);
        weightsRenderer.setDisplayChartValues(true);
        weightsRenderer.setDisplayChartValuesDistance(0); // 10 //setting chart value distance

        // Creating a XYMultipleSeriesRenderer to customize the whole chart
        XYMultipleSeriesRenderer multiRenderer = new XYMultipleSeriesRenderer();
        multiRenderer.setOrientation(XYMultipleSeriesRenderer.Orientation.HORIZONTAL);
        multiRenderer.setXLabels(0);
        multiRenderer.setChartTitle("Weights");

        /***
         * Customizing graphs
         */
        // setting text size of chart value
        weightsRenderer.setChartValuesTextSize(30);
        // setting text value of chart value
        weightsRenderer.setChartValuesTextAlign(Align.CENTER);
        // setting text spacing of chart value
        weightsRenderer.setChartValuesSpacing(20);
        // setting text size of the title
        multiRenderer.setChartTitleTextSize(30); //28
        //setting text size of the axis title
        multiRenderer.setAxisTitleTextSize(30); //24
        //setting text size of the graph lable
        multiRenderer.setLabelsTextSize(30); //24
        //setting zoom buttons visiblity
        multiRenderer.setZoomButtonsVisible(false);
        //setting pan enablity which uses graph to move on both axis
        multiRenderer.setPanEnabled(false, false);
        //setting click false on graph
        multiRenderer.setClickEnabled(false);
        //setting zoom to false on both axis
        multiRenderer.setZoomEnabled(false, false);
        //setting lines to display on y axis
        multiRenderer.setShowGridY(false);
        //setting lines to display on x axis
        multiRenderer.setShowGridX(false);
        //setting legend to fit the screen size
        multiRenderer.setFitLegend(false); // true
        //setting displaying line on grid
        multiRenderer.setShowGrid(false);
        //setting zoom to false
        multiRenderer.setZoomEnabled(false);
        //setting external zoom functions to false
        multiRenderer.setExternalZoomEnabled(false);
        //setting displaying lines on graph to be formatted(like using graphics)
        multiRenderer.setAntialiasing(true);
        //setting to in scroll to false
        multiRenderer.setInScroll(false);
        //setting to set legend height of the graph
        multiRenderer.setShowLegend(false);
        multiRenderer.setLegendHeight(30);
        //setting x axis label align
        multiRenderer.setXLabelsAlign(Align.CENTER);
        //setting y axis label to align
        multiRenderer.setYLabelsAlign(Align.LEFT);
        //setting text style
        multiRenderer.setTextTypeface("arial", Typeface.BOLD);
        //setting no of values to display in y axis
        multiRenderer.setYLabels(0);
        // setting y axis max value, Since i'm using static values inside the graph so i'm setting y max value to 4000.
        // if you use dynamic values then get the max y value and set here
        multiRenderer.setYAxisMax(/*bmi.retrieveLimit(context)*/200);
        // setting y min value
        multiRenderer.setYAxisMin(0);
        // setting x label's color
        multiRenderer.setXLabelsColor(Color.rgb(88,87,87));
        //setting used to move the graph on xaxiz to .5 to the right
        multiRenderer.setXAxisMin(-.5);
        // setting max values to be display in x axis
        multiRenderer.setXAxisMax(7);
        //setting bar size or space between two bars
        multiRenderer.setBarSpacing(0.5);
        //setting background color of the graph to transparent
        multiRenderer.setBackgroundColor(Color.TRANSPARENT);
        //setting margin color of the graph to transparent
        multiRenderer.setMarginsColor(getResources().getColor(R.color.transparent_background));
        // setting enblity background color
        multiRenderer.setApplyBackgroundColor(true);
        //setting the margin size for the graph in the order top, left, bottom, right
        multiRenderer.setMargins(new int[]{30, 30, 30, 30}); // 30,30,30,30
        // update date of week
        dateOfWeek();
        for(int i=0; i< x.length;i++){
            multiRenderer.addXTextLabel(i, mMonth[i]);
        }

        // Adding weightsRenderer and expenseRenderer to multipleRenderer
        // Note: The order of adding dataseries to dataset and renderers to multipleRenderer
        // should be same
        multiRenderer.addSeriesRenderer(weightsRenderer);
//            multiRenderer.addSeriesRenderer(expenseRenderer);
        //this part is used to display graph on the xml
        LinearLayout chartContainer = (LinearLayout) findViewById(R.id.chart2);
        //remove any views before u paint the chart
        chartContainer.removeAllViews();
        //drawing bar chart
        mChart = ChartFactory.getBarChartView(Graph.this, dataset, multiRenderer,Type.DEFAULT);
        //adding the view to the linearlayout
        chartContainer.addView(mChart);
    }
}
