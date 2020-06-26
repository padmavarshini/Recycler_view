package info.androidhive.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Wedding> WeddingList = new ArrayList<>();
    private RecyclerView recyclerView;
    private WeddingAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new WeddingAdapter(WeddingList);

        recyclerView.setHasFixedSize(true);

        // vertical RecyclerView
        // keep movie_list_row.xml width to `match_parent`
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());

        // horizontal RecyclerView
        // keep movie_list_row.xml width to `wrap_content`
        // RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(mLayoutManager);

        // adding inbuilt divider line
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        // adding custom divider line with padding 16dp
        // recyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.HORIZONTAL, 16));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(mAdapter);

        // row click listener
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Wedding wedding = WeddingList.get(position);
                Toast.makeText(getApplicationContext(), wedding.getPerson1() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        prepareWeddingData();
    }

    /**
     * Prepares sample data to provide data set to adapter
     */
    private void prepareWeddingData() {
        Wedding wedding = new Wedding("Mrs&Dr.Dennis koilpillai", " ", "01-06");
        WeddingList.add(wedding);

        wedding = new Wedding("Mrs&Mr Vincent Manohar", "Mrs&Mr.Jeyakumar", "02-06");
        WeddingList.add(wedding);

         wedding = new Wedding (" Mrs&Mr.Vetriselvan", "Mr&Mrs Rajesh", "03-06");
        WeddingList.add(wedding);

        wedding = new Wedding("Mr&Mrs.Samuel Devadoss", "Mr&Mrs.Ram", "04-06");
        WeddingList.add(wedding);


         wedding = new Wedding ("Mr&Mrs Jacob", "Mrs&Mr Cive Jeba Anand", "05-06");
        WeddingList.add(wedding);

       wedding = new Wedding ("Mrs&Mr.Sam Sigamani", "Mr&Mrs Ram", "06-06");
        WeddingList.add(wedding);

        wedding = new Wedding("Mrs&Dr.Nicodemus", "Mr&Mrs John", "07-06");
        WeddingList.add(wedding);

        wedding = new Wedding("Mrs&Mr.S.Wellington Manova", "Mrs&Mr K.J.Vasanth", "08-06");
        WeddingList.add(wedding);

         wedding = new Wedding("Mrs&Mr.M.V.Pavithran", "Mrs&Mr Santhanaraj", "09-06");
        WeddingList.add(wedding);

        wedding = new Wedding("S.Rajesh", "Mrs&Mr Dr.G.Prasad", "10-06");
        WeddingList.add(wedding);

       wedding = new Wedding("Mrs&Mr.Rajesh", "K.Ganesan", "11-06");
        WeddingList.add(wedding);

         wedding = new Wedding ("R.Michel", "R.Jeyasingh", "12-06");
        WeddingList.add(wedding);

       wedding = new Wedding( "Mrs&Mr ABP:Kingston", "Mrs&Mr Anathapaul", "13-06");
        WeddingList.add(wedding);

         wedding = new Wedding ("P.Aruldoss", "Mrs&Mr.Jebaraj", "14-06");
        WeddingList.add(wedding);

         wedding = new Wedding ("Mrs&Mr Rajkumar", "Mrs&Mr Samuelraj", "15-06");
        WeddingList.add(wedding);


        wedding = new Wedding("Mrs&Mr Stalin Kumaresan", "Mrs&Mr D.Jebakumar", "16-06");
        WeddingList.add(wedding);

        // notify adapter about data set changes
        // so that it will render the list with new data
        mAdapter.notifyDataSetChanged();
    }

}
