
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

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        addListenerImageButton();
        loadImageToLayout();
        this.context = getApplicationContext();
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
        final EditText weight = new EditText(this);
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


                if (weightInput.equals("") || heightLargeInput.equals("") || heightSmallInput.equals("")) {
//                    Context context = getApplicationContext();
                    CharSequence text = "Please reclick the BMI button and enter in all of the fields or we can't calculate your BMI :(";
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }  else {
                    Integer newWeight = Integer.parseInt(weightInput);
                    Integer newHeightLarge = Integer.parseInt(heightLargeInput);
                    Integer newHeightSmall = Integer.parseInt(heightSmallInput);
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
    }

