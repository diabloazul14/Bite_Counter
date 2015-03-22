
/**
 * Created by john on 2/25/15.
 */

package sustainablehealthsolutionsllc.bitecounter;

import android.content.Context;
import android.content.DialogInterface;
import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.AvoidXfermode;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.AsyncTask;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.app.AlertDialog;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import sustainablehealthsolutionsllc.bitecounter.AndroidLayout;

import sustainablehealthsolutionsllc.bitecounter.AndroidView;

public class BiteCounter extends ActionBarActivity {
    private static final String errMsg = "errMsg";
    static Context context;
    private static final int PROGRESS = 0x1;
    BMI bmi = new BMI();
    @AndroidView(R.id.circle_progress_bar)
    private ProgressBar circleProgress;
    private int pStatus;
    private Counter counter = new Counter();
    private static final String LOG_ERROR = "ERROR:Issue with line:";
    Integer date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        addListenerImageButton();
        loadImageToLayout();
        this.context = getApplicationContext();
        counter.setNumBites(counter.retrieveBites(context));
        counter.setLimit(counter.retrieveLimit(context));
            //set up to convert count to a text view

        circleProgress = (ProgressBar) findViewById(R.id.circle_progress_bar);

        TextView viewText = (TextView) findViewById(R.id.countView);

            String starText = Integer.toString(this.counter.getNumBites());

            viewText.setText(starText,TextView.BufferType.EDITABLE);

            counter.setLimit(100); //THis line needs to be replaced eventually once
                                    // THe 7 day average function comes into play.
        addListenerGraphButton();

        Calendar calendar = Calendar.getInstance();
        this.date = calendar.get(Calendar.DAY_OF_WEEK);
    }

    public void onStart()  {
        super.onStart();
        counter.setNumBites(counter.retrieveBites(context));
        counter.setLimit(counter.retrieveLimit(context));
    }

    public void onResume() {
        super.onResume();
        Calendar calendar = Calendar.getInstance();
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == this.date) {
            counter.setNumBites(counter.retrieveBites(context)); //This line needs to be uncommented but is like this for testing
        } else {
            counter.resetCounter();
            this.date = dayOfWeek;
        }

       counter.setLimit(counter.retrieveLimit(context));
       counter.saveLimit(context);

       Log.i(errMsg, Integer.toString(hourOfDay));
       Log.i(errMsg, Integer.toString(dayOfWeek));
       if (hourOfDay == 0) {
          counter.resetCounter();
           Log.i(errMsg, "The time of the day is ................" + Integer.toString(hourOfDay));
       }
        Log.i(errMsg, "The time of the day is ................" + Integer.toString(hourOfDay));
       circleProgress.setMax(counter.getLimit());
       circleProgress.setProgress(0);
       Log.i(errMsg, dayOfWeek + "This is the day of the week!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
       switch (dayOfWeek) {
          case 1:
             counter.saveSunday(context);
              bmi.saveSundayWeight(context);
             break;
          case 2:
             counter.saveMonday(context);
              bmi.saveMondayWeight(context);
             break;
          case 3:
             counter.saveTuesday(context);
              bmi.saveTuesdayWeight(context);
             break;
          case 4:
             counter.saveWednesday(context);
              bmi.saveWednesdayWeight(context);
             break;
          case 5:
             counter.saveThursday(context);
              bmi.saveThursdayWeight(context);
             break;
          case 6:
             counter.saveFriday(context);
              counter.saveFriday(context);
             break;
          case 7:
            counter.saveSaturday(context);
              bmi.saveSaturdayWeight(context);
             break;
          default:
             Log.i(errMsg, "The day wasn't saved correctly");
             break;
          }
    }

    public void onStop() {
        super.onStop();
        counter.saveBites(context);
        counter.saveLimit(context);
        Calendar calendar = Calendar.getInstance();
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        switch (dayOfWeek) {
            case 1:
                counter.saveSunday(context);
                bmi.saveSundayWeight(context);
                break;
            case 2:
                counter.saveMonday(context);
                bmi.saveMondayWeight(context);
                break;
            case 3:
                counter.saveTuesday(context);
                bmi.saveTuesdayWeight(context);
                break;
            case 4:
                counter.saveWednesday(context);
                bmi.saveWednesdayWeight(context);
                break;
            case 5:
                counter.saveThursday(context);
                bmi.saveThursdayWeight(context);
                break;
            case 6:
                counter.saveFriday(context);
                counter.saveFriday(context);
                break;
            case 7:
                counter.saveSaturday(context);
                bmi.saveSaturdayWeight(context);
                break;
            default:
                Log.i(errMsg, "The day wasn't saved correctly");
                break;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        counter.saveBites(context);
        counter.saveLimit(context);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current bite number and limit
        savedInstanceState.putInt("bites", this.counter.retrieveBites(this.context));
        savedInstanceState.putInt("limit", this.counter.retrieveLimit(this.context));

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);

    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);

        // Restore state members from saved instance
        int restoredBites = savedInstanceState.getInt("bites");
        int restoredLimit = savedInstanceState.getInt("limit");
        this.counter.setNumBites(restoredBites);
        this.counter.setLimit(restoredLimit);
    }

    public void counter(View view) {


        TextView text = (TextView) findViewById(R.id.countView);

        circleProgress = (ProgressBar) findViewById(R.id.circle_progress_bar);

        circleProgress.setMax(counter.getLimit());

        counter.incrementBite(context);

        pStatus = counter.getNumBites();
                circleProgress.setProgress(pStatus);


        //need to do this weird set so progress bar will update

               circleProgress.setProgress(pStatus);

    if(pStatus == 100) {
        circleProgress.getProgressDrawable().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
    }
        String num = Integer.toString(counter.getNumBites());

        text.setText(num, TextView.BufferType.EDITABLE);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_counter, menu);
            return true;
        }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }

    /**
     * This function activates when the Weight Button is pushed.
     * It creates an alertdialog that prompts the user for
     * information.
     * @param view
     */
    public void startAlertDialog (View view) {

        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Please enter your weight");

        LinearLayout lila1= new LinearLayout(this);
        lila1.setOrientation(LinearLayout.VERTICAL);

        final TextView weightMessage = new TextView(this);
        weightMessage.setText("Please Enter your weight in lbs");
        lila1.addView(weightMessage);
        final EditText weight = new EditText(this);
        lila1.addView(weight);


//        final TextView heightLargeMessage = new TextView(this);
//        heightLargeMessage.setText("Please enter your height");
//        lila1.addView(heightLargeMessage);
//        final EditText heightLarge = new EditText(this);
//        lila1.addView(heightLarge);

        alertDialog.setView(lila1);

        alertDialog.setButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // No updates are done, so it exits the alert dialog.
            }
        });
        alertDialog.setButton2("Confirm", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // here you can add functions
                String weightInput = weight.getText().toString();

                if (weightInput.equals("") ){
                    CharSequence text = "Please reenter your weight";
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }  else {
                    Float newWeight = Float.valueOf(weightInput);
                    Converter converter = new Converter();
//                    converter.parser(newHeight);
                    converter.setWeight(newWeight);  //Needs to be implemented after converter.parser
                    bmi.setWeight(converter.getWeight());

                    Calendar calendar = Calendar.getInstance();
                    int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
                    switch (dayOfWeek) {
                        case 1:
                            bmi.saveSundayWeight(context);
                            break;
                        case 2:
                            bmi.saveMondayWeight(context);
                            break;
                        case 3:
                            bmi.saveTuesdayWeight(context);
                            break;
                        case 4:
                            bmi.saveWednesdayWeight(context);
                            break;
                        case 5:
                            bmi.saveThursdayWeight(context);
                            break;
                        case 6:
                            bmi.saveFridayWeight(context);
                            break;
                        case 7:
                            bmi.saveSaturdayWeight(context);
                            break;
                        default:
                            Log.i(errMsg, "The day wasn't saved correctly");
                            break;
                    }
                    //The below shared preferences may not need to exist because of the
                    //above switch statement
                    SharedPreferences settings = context.getSharedPreferences("PREFS_NAME", 0);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putFloat("weight", bmi.getWeight());
                    editor.apply();
                }
            }
        });
        alertDialog.show();
    }
    public void addListenerImageButton(){
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton1);
        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BiteCounter.this, WallpaperBrowser.class);
                startActivity(intent);
            }
        });
    }
    public void addListenerGraphButton(){
        Button graphButton = (Button) findViewById(R.id.button3);
        graphButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BiteCounter.this, graphtest.class);
                startActivity(intent);
            }
        });
    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void loadImageToLayout() {
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.bite_counter);
        SharedPreferences settings = getSharedPreferences("image_data", 0);
        int encodedImage = settings.getInt("image_data", 0);

        int pos = encodedImage;
        Drawable wall = loadReadBitmap(encodedImage);
        rl.setBackground(wall);

        Bundle bundle = getIntent().getExtras();
        if (getIntent().getIntExtra("imageID", 99) != 99) {
            pos = bundle.getInt("imageID");
        }
//        int pos = getIntent().getExtras().getInt("imageID");

        switch (pos) {
            case 0:
                Drawable wall0 = loadReadBitmap(pos);
                rl.setBackground(wall0);
                saveCurrentBackground(pos);
                break;
            case 1:
                Drawable wall1 = loadReadBitmap(pos);
                rl.setBackground(wall1);
//                    wall = wall1.getConstantState().newDrawable();
                saveCurrentBackground(pos);
                break;
            case 2:
                Drawable wall2 = loadReadBitmap(pos);
                rl.setBackground(wall2);
                saveCurrentBackground(pos);
                break;
            case 3:
                Drawable wall3 = loadReadBitmap(pos);
                rl.setBackground(wall3);
                saveCurrentBackground(pos);
                break;
            case 4:
                Drawable wall4 = loadReadBitmap(pos);
                rl.setBackground(wall4);
                saveCurrentBackground(pos);
                break;
            case 5:
                Drawable wall5 = loadReadBitmap(pos);
                rl.setBackground(wall5);
                saveCurrentBackground(pos);
                break;
            case 6:
                Drawable wall6 = loadReadBitmap(pos);
                rl.setBackground(wall6);
                saveCurrentBackground(pos);
                break;
            case 7:
                Drawable wall7 = loadReadBitmap(pos);
                rl.setBackground(wall7);
                saveCurrentBackground(pos);
                break;
            default:
                break;
        }
    }
    public void saveCurrentBackground(int pos) {
        SharedPreferences settings = getSharedPreferences("image_data", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("image_data", pos);
        editor.apply();
    }
    public Drawable loadReadBitmap(int position){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), mThumbIds[position]);
        return new BitmapDrawable(getResources(), bitmap);
    }

    private Integer[] mThumbIds = {
            R.drawable.wall0, R.drawable.wall1,
            R.drawable.wall2, R.drawable.wall3,
            R.drawable.wall4, R.drawable.wall5,
            R.drawable.wall6, R.drawable.wall7,
    };

    public class BiteCounterFragment extends ActionBarActivity {

        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            ViewGroup rootView = (ViewGroup) inflater.inflate(
                    R.layout.fragment_layout, container, false);

            return rootView;
        }
    }
}

