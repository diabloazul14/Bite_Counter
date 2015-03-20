package sustainablehealthsolutionsllc.bitecounter;


import org.achartengine.ChartFactory;
import org.achartengine.chart.BarChart.Type;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;
import android.content.Context;
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

public class graphtest extends ActionBarActivity {
    Counter counter = new Counter();
    BMI bmi = new BMI();
    Context context;
    Calendar calendar = Calendar.getInstance();
    private View mChart;
    private String[] mMonth = new String[] {
            "", "", "", "", "", "", ""
    };
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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graphtest);
        context = getApplicationContext();

        // Getting reference to the button btn_chart
        Button btnChart = (Button) findViewById(R.id.btn_chart);
        Button btnChart2 = (Button) findViewById(R.id.btn_chart2);
        Button btnCounter = (Button) findViewById(R.id.btn_counter);

        OnClickListener clickListenerCounter = new OnClickListener() {

            @Override
            public void onClick(View v) {
                // Draw the Income vs Expense Chart
                int count = counter.getNumBites();
                count++;
                counter.setNumBites(count);
            }
        };

        // Defining click event listener for the button btn_chart
        OnClickListener clickListener = new OnClickListener() {

            @Override
            public void onClick(View v) {
                // Draw the Income vs Expense Chart
                openChart();
            }
        };
        // Defining click event listener for the button btn_chart
        OnClickListener clickListener2 = new OnClickListener() {

            @Override
            public void onClick(View v) {
                // Draw the Income vs Expense Chart
                openChart2();
            }
        };
        // Setting event click listener for the button btn_chart of the MainActivity layout
        btnChart.setOnClickListener(clickListener);
        btnChart2.setOnClickListener(clickListener2);
        btnCounter.setOnClickListener(clickListenerCounter);

    }

    private void openChart(){
        int[] x = {0, 1, 2, 3, 4, 5, 6};
//         int[] income = {400,250,270,300,280,350,370,380};
        int[] income = {counter.getNumBites(),  counter.retrieveMonday(context),
                        /*counter.retrieveTuesday(context)*/40, counter.retrieveWednesday(context),
                        counter.retrieveThursday(context),counter.retrieveFriday(context), 80};
//            int[] expense = {220,270,290,280,260,300,30,340};

        // Creating an XYSeries for Income
        XYSeries incomeSeries = new XYSeries("Income");
        // Creating an XYSeries for Expense
//            XYSeries expenseSeries = new XYSeries("Expense");
        // Adding data to Income and Expense Series
        for(int i=0;i<x.length;i++){
            incomeSeries.add(i,income[i]);
//                expenseSeries.add(i,expense[i]);
        }

        // Creating a dataset to hold each series
        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
        // Adding Income Series to the dataset
        dataset.addSeries(incomeSeries);
        // Adding Expense Series to dataset
//            dataset.addSeries(expenseSeries);

        // Creating XYSeriesRenderer to customize incomeSeries
        XYSeriesRenderer incomeRenderer = new XYSeriesRenderer();
        incomeRenderer.setColor(Color.rgb(88,87,87)); //color of the graph set to black
        incomeRenderer.setFillPoints(true);
        incomeRenderer.setLineWidth(2);
        incomeRenderer.setDisplayChartValues(true);

        incomeRenderer.setDisplayChartValuesDistance(10); //setting chart value distance

        // Creating a XYMultipleSeriesRenderer to customize the whole chart
        XYMultipleSeriesRenderer multiRenderer = new XYMultipleSeriesRenderer();
        multiRenderer.setOrientation(XYMultipleSeriesRenderer.Orientation.HORIZONTAL);
        multiRenderer.setXLabels(0);
        multiRenderer.setChartTitle("Bite Chart");
//        multiRenderer.setXTitle("");
//        multiRenderer.setYTitle("");

        /***
         * Customizing graphs
         */
        // setting text size of chart value
        incomeRenderer.setChartValuesTextSize(35);
        incomeRenderer.setChartValuesTextAlign(Align.CENTER);
        incomeRenderer.setChartValuesSpacing(20);
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
        multiRenderer.setAntialiasing(true); // true
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
        multiRenderer.setYLabels(0); //10
        // setting y axis max value, Since i'm using static values inside the graph so i'm setting y max value to 4000.
        // if you use dynamic values then get the max y value and set here
        multiRenderer.setYAxisMax(100);
        multiRenderer.setYAxisMin(0);
        multiRenderer.setXLabelsColor(Color.rgb(88,87,87));
        //setting used to move the graph on xaxiz to .5 to the right
        multiRenderer.setXAxisMin(-.5); //-.5

        // setting max values to be display in x axis
        multiRenderer.setXAxisMax(7);
        //setting bar size or space between two bars
        multiRenderer.setBarSpacing(0.5);
        //Setting background color of the graph to transparent
        multiRenderer.setBackgroundColor(Color.TRANSPARENT);
        //Setting margin color of the graph to transparent
        multiRenderer.setMarginsColor(getResources().getColor(R.color.transparent_background));
        multiRenderer.setApplyBackgroundColor(true);

        //setting the margin size for the graph in the order top, left, bottom, right
        multiRenderer.setMargins(new int[]{30, 30, 30, 30}); // 30,30,30,30

        dateOfWeek();
        for(int i=0; i< x.length;i++){
//            multiRenderer.addXTextLabel(i, mMonth[i]);
            multiRenderer.addXTextLabel(i, mMonth[i]);
        }

        // Adding incomeRenderer and expenseRenderer to multipleRenderer
        // Note: The order of adding dataseries to dataset and renderers to multipleRenderer
        // should be same
        multiRenderer.addSeriesRenderer(incomeRenderer);
//            multiRenderer.addSeriesRenderer(expenseRenderer);

        //this part is used to display graph on the xml
        LinearLayout chartContainer = (LinearLayout) findViewById(R.id.chart);
        //remove any views before u paint the chart
        chartContainer.removeAllViews();
        //drawing bar chart
        mChart = ChartFactory.getBarChartView(graphtest.this, dataset, multiRenderer,Type.DEFAULT);
        //adding the view to the linearlayout
        chartContainer.addView(mChart);
    }
    private void openChart2(){
        int[] x = {0, 1, 2, 3, 4, 5, 6};
//         int[] income = {400,250,270,300,280,350,370,380};
        float[] income = {bmi.retrieveSundayWeight(context), bmi.retrieveMondayWeight(context),
                bmi.retrieveTuesdayWeight(context),90, counter.getNumBites(),
                bmi.retrieveThursdayWeight(context),50};
//            int[] expense = {220,270,290,280,260,300,30,340};

        // Creating an XYSeries for Income
        XYSeries incomeSeries = new XYSeries("Income");
        // Creating an XYSeries for Expense
//            XYSeries expenseSeries = new XYSeries("Expense");
        // Adding data to Income and Expense Series
        for(int i=0;i<x.length;i++){
            incomeSeries.add(i,income[i]);
//                expenseSeries.add(i,expense[i]);
        }

        // Creating a dataset to hold each series
        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
        // Adding Income Series to the dataset
        dataset.addSeries(incomeSeries);
        // Adding Expense Series to dataset
//            dataset.addSeries(expenseSeries);

        // Creating XYSeriesRenderer to customize incomeSeries
        XYSeriesRenderer incomeRenderer = new XYSeriesRenderer();
        incomeRenderer.setColor(Color.rgb(88,87,87)); //color of the graph set to black
        incomeRenderer.setFillPoints(true);
        incomeRenderer.setLineWidth(2);
        incomeRenderer.setDisplayChartValues(true);

        incomeRenderer.setDisplayChartValuesDistance(0); // 10 //setting chart value distance

        // Creating a XYMultipleSeriesRenderer to customize the whole chart
        XYMultipleSeriesRenderer multiRenderer = new XYMultipleSeriesRenderer();
        multiRenderer.setOrientation(XYMultipleSeriesRenderer.Orientation.HORIZONTAL);
        multiRenderer.setXLabels(0);
        multiRenderer.setChartTitle("Weight Chart");
//        multiRenderer.setXTitle("");
//        multiRenderer.setYTitle("");

        /***
         * Customizing graphs
         */
        // setting text size of chart value
        incomeRenderer.setChartValuesTextSize(30);
        incomeRenderer.setChartValuesTextAlign(Align.CENTER);
        incomeRenderer.setChartValuesSpacing(20);
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
        multiRenderer.setAntialiasing(true); // true
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
        multiRenderer.setYLabels(0); //10
        // setting y axis max value, Since i'm using static values inside the graph so i'm setting y max value to 4000.
        // if you use dynamic values then get the max y value and set here
        multiRenderer.setYAxisMax(500);
        multiRenderer.setYAxisMin(0);
        multiRenderer.setXLabelsColor(Color.rgb(88,87,87));
        //setting used to move the graph on xaxiz to .5 to the right
        multiRenderer.setXAxisMin(-.5); //-.5

        // setting max values to be display in x axis
        multiRenderer.setXAxisMax(7);
        //setting bar size or space between two bars
        multiRenderer.setBarSpacing(0.5);
        //Setting background color of the graph to transparent
        multiRenderer.setBackgroundColor(Color.TRANSPARENT);
        //Setting margin color of the graph to transparent
        multiRenderer.setMarginsColor(getResources().getColor(R.color.transparent_background));
        multiRenderer.setApplyBackgroundColor(true);

        //setting the margin size for the graph in the order top, left, bottom, right
        multiRenderer.setMargins(new int[]{30, 30, 30, 30}); // 30,30,30,30

        dateOfWeek();
        for(int i=0; i< x.length;i++){
/*            multiRenderer.addXTextLabel(i, mMonth[i]);*/
            multiRenderer.addXTextLabel(i, mMonth[i]);
        }

        // Adding incomeRenderer and expenseRenderer to multipleRenderer
        // Note: The order of adding dataseries to dataset and renderers to multipleRenderer
        // should be same
        multiRenderer.addSeriesRenderer(incomeRenderer);
//            multiRenderer.addSeriesRenderer(expenseRenderer);

        //this part is used to display graph on the xml
        LinearLayout chartContainer = (LinearLayout) findViewById(R.id.chart2);
        //remove any views before u paint the chart
        chartContainer.removeAllViews();
        //drawing bar chart
        mChart = ChartFactory.getBarChartView(graphtest.this, dataset, multiRenderer,Type.DEFAULT);
        //adding the view to the linearlayout
        chartContainer.addView(mChart);
    }
}
