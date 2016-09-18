package manor9421.com.flickrphoto;

/**
 * Created by manor on 9/16/16.
 */
public class GalleryItem {
    private String mCaption;
    private String mId;
    private String mUrl;
    private String mUrlC;

    public String getCaption() {
        return mCaption;
    }

    public void setCaption(String caption) {
        mCaption = caption;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }
    public String getmUrlC() {
        return mUrlC;
    }
    public void setmUrlC(String mUrlC) {
        this.mUrlC = mUrlC;
    }
    @Override
    public String toString() {
        return mCaption;
    }
}
