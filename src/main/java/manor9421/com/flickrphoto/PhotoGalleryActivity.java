package manor9421.com.flickrphoto;

import android.support.v4.app.Fragment;

public class PhotoGalleryActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return MyFragment.newInstance();
    }
}
