package manor9421.com.flickrphoto;

import android.graphics.Point;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

/**
 * Created by manor on 9/18/16.
 */
public class MyFragment extends Fragment{

    AsynchronousPicAdd apa;

    public static MyFragment newInstance() {
        return new MyFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_flickr_pics, container, false);

        GridLayout g = (GridLayout)v.findViewById(R.id.ll);

        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x / g.getColumnCount();//ширина экрана

        apa = new AsynchronousPicAdd(getResources(),getActivity(),g,width);
        apa.execute();

        v.findViewById(R.id.stopButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!apa.isCancelled()){
                    apa.cancel(true);
                }
            }
        });

        return v;
    }
}
