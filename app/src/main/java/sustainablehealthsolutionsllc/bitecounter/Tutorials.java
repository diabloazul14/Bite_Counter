package sustainablehealthsolutionsllc.bitecounter;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class Tutorials extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorials);
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
        switch(item.getItemId()) {
            case R.id.action_graph:
                Intent intent = new Intent(Tutorials.this, Graph.class);
                startActivity(intent);
                return true;
            case R.id.action_aboutUs:
                Intent intentUs = new Intent(Tutorials.this, AboutUs.class);
                startActivity(intentUs);
                return true;
            case R.id.action_counter:
                Intent intentT = new Intent(Tutorials.this, BiteCounter.class);
                startActivity(intentT);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
