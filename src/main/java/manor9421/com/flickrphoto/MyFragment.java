package manor9421.com.flickrphoto;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.app.Fragment;
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

    AsynchronousPicAdd apa = new AsynchronousPicAdd();
    GridLayout g;
    int width;

    public static MyFragment newInstance() {
        return new MyFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_flickr_pics, container, false);

        g = (GridLayout)v.findViewById(R.id.ll);

        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x / g.getColumnCount();//ширина экрана
        /*
        Notification notification = new Notification.Builder(getActivity())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Haryo")
                .setContentText("Text-Text-Text")
                .setAutoCancel(true)
                .setPriority(Notification.PRIORITY_MAX)
                .setDefaults(Notification.DEFAULT_VIBRATE)
                .build();

        NotificationManager notificationManager =
                (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID,notification);
        */

        //showPictures();

        v.findViewById(R.id.stopButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAdding();
            }
        });

        v.findViewById(R.id.startButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPictures();
            }
        });

        return v;
    }

    private void stopAdding(){
        if(!apa.isCancelled()){
            apa.cancel(true);
        }
    }

    private void showPictures(){
        stopAdding();
        g.removeAllViews();
        apa = new AsynchronousPicAdd(getResources(),getActivity(),g,width);
        apa.execute();

    }

}
