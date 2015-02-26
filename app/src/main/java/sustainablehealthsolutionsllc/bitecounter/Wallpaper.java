package sustainablehealthsolutionsllc.bitecounter;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class Wallpaper extends ActionBarActivity{

    private String filePath = "";

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    private void changeWallpaper(String filePath) {
        Resources res = getResources();
        Bitmap bitmap = BitmapFactory.decodeFile(filePath);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(res, bitmap);
        View view = findViewById(R.id.activity_counter);
        // API16+
        view.setBackground(bitmapDrawable);
        // < API16
        //view.setBackgroundDrawable(bitmapDrawable);
    }
    // To handle when an image is selected from the browser, add this to the Activity
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK) {

            // currImageURI is used to hold the content:// URI of the image
            Uri selectedImageUri = data.getData();
            String path = getRealPathFromURI(selectedImageUri);
            filePath = path;
//            editText1.setText(path);
        }
    }

    // And to convert the image URI to the direct file system path of the image file
    public String getRealPathFromURI(Uri contentUri) {

        // can post image
        String[] projection = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(contentUri,
                projection, // Which columns to return
                null,       // WHERE clause; which rows to return (all rows)
                null,       // WHERE clause selection arguments (none)
                null); // Order-by clause (ascending by name)
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();

        return cursor.getString(column_index);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

//        Button btn = (Button) findViewById(R.id.wallpaperBtn);
//
//        btn.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                RelativeLayout layout = (RelativeLayout) findViewById(R.id.activity_counter);
//                layout.setBackgroundResource(R.drawable.wall2);
//            }
//        });
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
