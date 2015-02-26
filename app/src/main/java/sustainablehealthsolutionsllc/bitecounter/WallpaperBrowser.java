package sustainablehealthsolutionsllc.bitecounter;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;


/**
 * Created by Nghia on 2/25/2015.
 */
public class WallpaperBrowser extends ActionBarActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wallpaper_browser);

        // Create grid view to display background photo
        GridView gridview = (GridView) findViewById(R.id.wallpaper_browser);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(WallpaperBrowser.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
