package sustainablehealthsolutionsllc.bitecounter;

import android.annotation.TargetApi;
import android.content.Intent;
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
import android.widget.ImageButton;
import android.widget.RelativeLayout;


public class BiteCounter extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        addListenerImageButton();
        loadImageToLayout();
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
        int pos = 0;
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.bite_counter);
        Bundle bundle = getIntent().getExtras();
        if (getIntent().getIntExtra("imageID", 0) != 0) {
            pos = bundle.getInt("imageID");
        }
//        int pos = getIntent().getExtras().getInt("imageID");

        switch (pos) {
            case 0:
                Drawable wall0 = loadReadBitmap(pos);
                rl.setBackground(wall0);
                break;
            case 1:
                Drawable wall1 = loadReadBitmap(pos);
                rl.setBackground(wall1);
                break;
            case 2:
                Drawable wall2 = loadReadBitmap(pos);
                rl.setBackground(wall2);
                break;
            case 3:
                Drawable wall3 = loadReadBitmap(pos);
                rl.setBackground(wall3);
                break;
            case 4:
                Drawable wall4 = loadReadBitmap(pos);
                rl.setBackground(wall4);
                break;
            case 5:
                Drawable wall5 = loadReadBitmap(pos);
                rl.setBackground(wall5);
                break;
            case 6:
                Drawable wall6 = loadReadBitmap(pos);
                rl.setBackground(wall6);
                break;
            case 7:
                Drawable wall7 = loadReadBitmap(pos);
                rl.setBackground(wall7);
                break;
            default:
                break;
        }
    }

    private Integer[] mThumbIds = {
            R.drawable.wall0, R.drawable.wall1,
            R.drawable.wall2, R.drawable.wall3,
            R.drawable.wall4, R.drawable.wall5,
            R.drawable.wall6, R.drawable.wall7
    };

    public Drawable loadReadBitmap(int position){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), mThumbIds[position]);
        return new BitmapDrawable(getResources(), bitmap);
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
}

