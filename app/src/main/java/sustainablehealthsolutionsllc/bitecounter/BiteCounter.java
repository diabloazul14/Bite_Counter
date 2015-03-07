
/**
 * Created by john on 2/25/15.
 */

package sustainablehealthsolutionsllc.bitecounter;

import android.content.Context;
import android.content.DialogInterface;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.app.AlertDialog;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class BiteCounter extends ActionBarActivity {

    Context context = getApplicationContext();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        addListenerImageButton();
        loadImageToLayout();
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

    public void startAlertDialog (View view) {
        BMI bmi = new BMI();

        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Please enter your weight and height");

        LinearLayout lila1= new LinearLayout(this);
        lila1.setOrientation(LinearLayout.VERTICAL);



        final TextView weightMessage = new TextView(this);
        weightMessage.setText("Enter your weight in lbs or kg");
        lila1.addView(weightMessage);
        final EditText weight= new EditText(this);
        lila1.addView(weight);


        final TextView heightLargeMessage = new TextView(this);
        heightLargeMessage.setText("Enter your height in feet or meters");
        lila1.addView(heightLargeMessage);
        final EditText heightLarge = new EditText(this);
        lila1.addView(heightLarge);

        final TextView heightSmallMessage = new TextView(this);
        heightSmallMessage.setText("Enter your height in inches or centimeters");
        lila1.addView(heightSmallMessage);
        final EditText heightSmall = new EditText(this);
        lila1.addView(heightSmall);

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
                String heightLargeInput = heightLarge.getText().toString();
                String heightSmallInput = heightSmall.getText().toString();
                Integer newWeight = Integer.parseInt(weightInput);
                Integer newHeightLarge = Integer.parseInt(heightLargeInput);
                Integer newHeightSmall = Integer.parseInt(heightSmallInput);

                if (weightInput.equals("") || heightLargeInput.equals("") || heightSmallInput.equals("")) {
                    Context context = getApplicationContext();
                    CharSequence text = "Please reclick the BMI button and enter in all of the fields or we can't calculate your BMI :(";
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else if (newHeightLarge > 10 || newHeightSmall > 100) {
                    CharSequence text = "Please enter your BMI information again :)";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else {
                    SharedPreferences settings = context.getSharedPreferences("PREFS_NAME", 0);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("weight", newWeight);
                    editor.putInt("heightLarge", newHeightLarge);
                    editor.putInt("heightSmall", newHeightSmall);
                    editor.apply();
                }
            }
        });
        alertDialog.show();
    }
    }

