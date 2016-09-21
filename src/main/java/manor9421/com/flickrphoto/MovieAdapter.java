package manor9421.com.flickrphoto;

import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by manor on 9/21/16.
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private Movie[] movies;
    private CardViewListener cardViewListener;

    public MovieAdapter(Movie[] movies) {
        this.movies = movies;
    }

    public interface CardViewListener{
        public void onClick(int position);
    }
    public void setCardViewListener(CardViewListener cardViewListener){
        this.cardViewListener = cardViewListener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        // конструктор
        public ViewHolder(CardView cardView) {
            super(cardView);
            this.cardView = cardView;
        }
    }

    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Создание нового представления
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_card,parent,false);
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        //Заполнение заданного представления данными
        CardView cardView = holder.cardView;
        ImageView movieImage = (ImageView) cardView.findViewById(R.id.movieImage);
        Drawable drawable = ResourcesCompat.getDrawable(cardView.getResources(),movies[position].getImageRes(),null);
        TextView movieName = (TextView) cardView.findViewById(R.id.movieName);
        TextView movieYear = (TextView) cardView.findViewById(R.id.movieYear);
        TextView movieDirector = (TextView) cardView.findViewById(R.id.movieDirector);
        TextView movieDescription = (TextView) cardView.findViewById(R.id.movieDescription);

        movieImage.setImageDrawable(drawable);
        movieName.setText(movies[position].getName());
        movieYear.setText("Year: "+movies[position].getYear()+"");
        movieDirector.setText("Director: "+movies[position].getDirector());
        movieDescription.setText(movies[position].getDescription());
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getActivity(),""+movies[position].getName(),Toast.LENGTH_SHORT).show();
                if(cardViewListener != null){
                    cardViewListener.onClick(position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        //Возвращает количество вариантов в наборе данных
        return movies.length;// кол-во элементов данных
    }
}
