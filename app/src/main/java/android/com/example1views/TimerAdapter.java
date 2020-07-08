package android.com.example1views;


import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TimerAdapter extends RecyclerView.Adapter<TimerAdapter.MyViewHolder> {

    private ArrayList<String> al_data;
    private List<MyViewHolder> lstHolders;

    public TimerAdapter(ArrayList<String> al_data) {
        this.al_data = al_data;
        lstHolders = new ArrayList<>();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_timer;
        public Button bt_timer;
        private int counterValue = 0;
        private int timerValue = 1000 * 60;

        private CountDownTimer timer = new CountDownTimer(timerValue, 1000) {
            @Override
            public void onTick(long milliSeconds) {
                counterValue = counterValue + 1;
//                synchronized(this){
                    tv_timer.setText("" + counterValue);
//                }
            }

            @Override
            public void onFinish() {
                tv_timer.setText("0");
                counterValue = 0;
                bt_timer.setEnabled(true);
            }
        };

        public MyViewHolder(View view) {
            super(view);
            tv_timer = (TextView) view.findViewById(R.id.tv_timer);
            bt_timer = (Button) view.findViewById(R.id.bt_timer);
            bt_timer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    timer.start();
                    bt_timer.setEnabled(false);
                }
            });
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_layout, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
//        lstHolders.get(position);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }


    @Override
    public int getItemCount() {
        return al_data.size();
    }

}