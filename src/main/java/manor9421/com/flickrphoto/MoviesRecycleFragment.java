package manor9421.com.flickrphoto;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesRecycleFragment extends Fragment {


    public static MyFragment newInstance() {
        return new MyFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        RecyclerView moviesRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_movies_recycle, container, false);

        final Movie[] movies = new Movie[]{
                new Movie(R.drawable.ima,"Hello",2016,"Ya","TEXT TEXTTEXT TEXTTEXT TEXTTEXT TEXTTEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT"),
                new Movie(R.drawable.ima,"Hello1",2015,"Ya","TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT"),
                new Movie(R.drawable.ima,"Hello2",2014,"Ya","TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT"),
                new Movie(R.drawable.ima,"Hello3",2013,"Ya","TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT"),
                new Movie(R.drawable.ima,"Hello4",2012,"Ya","TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT"),
                new Movie(R.drawable.ima,"Hello4",2012,"Ya","TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT"),
                new Movie(R.drawable.ima,"Hello4",2012,"Ya","TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT"),
                new Movie(R.drawable.ima,"Hello4",2012,"Ya","TEXT TETEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT XT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT"),
                new Movie(R.drawable.ima,"Hello5",2011,"Ya","TEXTTEXT TEXT  TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT")
        };

        MovieAdapter adapter = new MovieAdapter(movies);
        moviesRecycler.setAdapter(adapter);
        /*LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        moviesRecycler.setLayoutManager(layoutManager);*/
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        moviesRecycler.setLayoutManager(manager);
        adapter.setCardViewListener(new MovieAdapter.CardViewListener(){
            public void onClick(int position){
                Toast.makeText(getActivity(),""+movies[position].getName(),Toast.LENGTH_SHORT).show();
            }
        });


        return moviesRecycler;
    }

}
