package com.example.jailson.showupartist.gui;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.example.jailson.showupartist.R;
import com.example.jailson.showupartist.entity.Event;

import org.lucasr.twowayview.TwoWayView;

import java.util.ArrayList;

public class InitialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);

        /*TwoWayView:*/
        TwoWayView twoWayView = (TwoWayView) findViewById(R.id.initial_twoWayView);
        twoWayView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(InitialActivity.this, "Event "+i, Toast.LENGTH_LONG).show();
            }
        });

        ArrayList<Event> events = new ArrayList<Event>();
        for(int i = 0; i <= 7; i++){

            Event event = new Event();
            events.add(event);
        }
        AdapterTwoWayView adapterTwoWayView = new AdapterTwoWayView(this, events);
        twoWayView.setAdapter(adapterTwoWayView);
    }

    public class AdapterTwoWayView extends BaseAdapter{

        private Context mContext;
        private LayoutInflater mInflater;
        private ArrayList<Event> mDataSource;

        public AdapterTwoWayView(Context context, ArrayList<Event> items){

            this.mContext = context;
            this.mDataSource = items;
            mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return this.mDataSource.size();
        }

        @Override
        public Object getItem(int i) {
            return this.mDataSource.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            View rowView = mInflater.inflate(R.layout.layout_twowayview, viewGroup, false);



            return rowView;
        }
    }
}
