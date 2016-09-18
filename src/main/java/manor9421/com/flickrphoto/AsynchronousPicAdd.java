package manor9421.com.flickrphoto;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.Display;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;

import java.io.IOException;
import java.util.List;

/**
 * Created by manor on 9/18/16.
 */
public class AsynchronousPicAdd extends AsyncTask<Void,Drawable,Void>{

    Resources r;
    Context c;
    GridLayout g;
    int width;

    public AsynchronousPicAdd(Resources r, Context c, GridLayout g,int width) {
        this.r = r;
        this.c = c;
        this.g = g;
        this.width = width;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        FlickrFetchr flickrFetchr = new FlickrFetchr();

        List<GalleryItem> galleryItemList = flickrFetchr.fetchItems();// получили список с url картинок



        for(GalleryItem galleryItem: galleryItemList) {
            String url = galleryItem.getUrl();
            try {
                byte[] bitmapBytes = new FlickrFetchr().getUrlBytes(url);// получаем байты картинки
                Bitmap bitmap = BitmapFactory
                        .decodeByteArray(bitmapBytes, 0, bitmapBytes.length);
                Drawable drawable = new BitmapDrawable(r,bitmap);
                publishProgress(drawable); // вызов onProgressUpdate
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Drawable... drawables) {
        super.onProgressUpdate(drawables);

        try {
            ImageView iv = new ImageView(c);
            GridLayout.LayoutParams ivPar = new GridLayout.LayoutParams();
            ivPar.width = width;
            ivPar.height = width;
            iv.setLayoutParams(ivPar);
            iv.setBackground(drawables[0]);

            g.addView(iv);
        }catch (Exception e){

        }
    }
}
