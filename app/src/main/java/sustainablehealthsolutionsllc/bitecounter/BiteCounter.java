package sustainablehealthsolutionsllc.bitecounter;


/**
 * Created by john on 2/25/15.
 */

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.app.AlertDialog;
import android.widget.EditText;


public class BiteCounter extends ActionBarActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_counter);
            // Create Change Wallpaper Button
//            Button b = (Button) findViewById(R.id.wallpaperBtn);
//            b.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    // Use intent to start WallpaperBrowser Activity
//                    Intent intent = new Intent(BiteCounter.this, WallpaperBrowser.class);
//                    startActivity(intent);
//                }
//            });

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

            alertDialog.setMessage("Enter your weight in lbs or kg");
            final EditText weight= new EditText(this);
            alertDialog.setView(weight);

            alertDialog.setMessage("Enter your height in feet or meters");
            final EditText heightLarge = new EditText(this);
            alertDialog.setView(heightLarge);

            alertDialog.setMessage("Enter your height in inches or centimeters");
            final EditText heightSmall = new EditText(this);
            alertDialog.setView(heightSmall);

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
                }
            });
            alertDialog.show();
        }
    }

