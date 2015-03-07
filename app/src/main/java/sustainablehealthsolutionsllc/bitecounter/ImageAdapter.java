package sustainablehealthsolutionsllc.bitecounter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return mThumbIds[position];
    }

    public long getItemId(int position) {
        return position;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            // Auto-resize images' thumbnails in gridView
            LinearLayout.LayoutParams params = new LinearLayout
                    .LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,
                                  LinearLayout.LayoutParams.FILL_PARENT);
            imageView.setLayoutParams(new GridView.LayoutParams(params));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            // Set padding
            imageView.setPadding(0, 0, 0, 0);

        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // references to our images' thumbnails
    private Integer[] mThumbIds = {
            R.drawable.grid0, R.drawable.grid1,
            R.drawable.grid2, R.drawable.grid3,
            R.drawable.grid4, R.drawable.grid5,
            R.drawable.grid6, R.drawable.grid7
    };
}