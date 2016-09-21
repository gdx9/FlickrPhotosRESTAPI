package manor9421.com.flickrphoto;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

public class MoviesActiviry extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        FragmentManager fm = getFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.moviesFrame);

        if (fragment == null) {
            fragment = new MoviesRecycleFragment();
            fm.beginTransaction()
                    .add(R.id.moviesFrame, fragment)
                    .commit();
        }
    }
}
