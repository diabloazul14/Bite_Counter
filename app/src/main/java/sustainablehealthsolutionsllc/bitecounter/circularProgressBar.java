package sustainablehealthsolutionsllc.bitecounter;

import android.view.View;
import android.widget.ProgressBar;

/**
 * Created by john on 2/23/15.
 */
public class circularProgressBar {

   //holds the data for the bar
   private float limit  = 0;
   private ProgressBar newCircle;

    /**
     *
     */
    public void counterProgress(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {

                float piece = 0;

                piece = 100/limit;
                float newPiece = 0;

//           newCircle = (ProgressBar) findViewById(R.id.circularProgressbar);
//
//                if()

            }
        });

    }

    /**
     *
     * @param limit
     */
    public void setLimit(float limit) {
        this.limit = limit;
    }

    /**
     *
     * @return
     */
    public float getLimit() {
        return limit;
    }

    /**
     *
     */
    public void reset() {
        newCircle.setProgress(0);
    }
}
