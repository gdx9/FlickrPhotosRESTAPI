package manor9421.com.flickrphoto;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;

public class FlickrPhoto extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return MyFragment.newInstance();
    }
}
