package manor9421.com.flickrphoto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void startFlickr(View view) {
        Intent intent = new Intent(this, FlickrPhoto.class);
        startActivity(intent);
    }

    public void startMovies(View view) {
        Intent intent = new Intent(this, MoviesActiviry.class);
        startActivity(intent);
    }
}
