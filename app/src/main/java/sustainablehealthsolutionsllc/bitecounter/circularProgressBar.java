package sustainablehealthsolutionsllc.bitecounter;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;

/**
 * Created by john on 2/23/15.
 */
public class circularProgressBar {


    //holds the data for the bar
   private int limit  = 0;
   private ProgressBar newCircle;

    circularProgressBar(int limits) {

        limit = limits;
    }

    /**
     *
     */
    public int counterProgress(final boolean isPushed) {

        int piece;

        Context context = null;

                //doesn't take floats
                piece = 100/limit;

                if(isPushed) {
                    piece++;
                }

        return piece;
    }

    /**
     *
     * @param limits
     */
    public void setLimit(int limits) {
        this.limit = limits;
    }

    /**
     *
     * @return
     */
    public int getLimit() {
        return limit;
    }

    /**
     *
     */
    public void reset() {
        newCircle.setProgress(0);
    }
}
