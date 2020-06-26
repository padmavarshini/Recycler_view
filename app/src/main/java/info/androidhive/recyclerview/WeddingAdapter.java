package info.androidhive.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class WeddingAdapter extends RecyclerView.Adapter<WeddingAdapter.MyViewHolder> {

    private List<Wedding> WeddingList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView Person1, Person2, date;

        public MyViewHolder(View view) {
            super(view);
            Person1 = (TextView) view.findViewById(R.id.Person1);
            Person2 = (TextView) view.findViewById(R.id.Person2);
           date = (TextView) view.findViewById(R.id.date);
        }
    }


    public WeddingAdapter(List<Wedding> WeddingList) {
        this.WeddingList = WeddingList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.wedding_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
       Wedding wedding = WeddingList.get(position);
        holder.Person1.setText(wedding.getPerson1());
        holder.Person2.setText(wedding.getPerson2());
        holder.date.setText(wedding.getDate());
    }

    @Override
    public int getItemCount() {
        return WeddingList.size();
    }
}
