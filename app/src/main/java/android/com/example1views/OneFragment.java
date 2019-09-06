package android.com.example1views;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class OneFragment extends Fragment {

    public OneFragment() {
        // Required empty public constructor
    }

    FragmentComm fragmentComm;
    RecyclerView recyclerView;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser && recyclerView!=null){
            // reload the api
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        fragmentComm = (FragmentComm)context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_one, container, false);
        TextView textView = view.findViewById(R.id.tv_frag_one);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast();

            }
        });
        // api call
        return view;
    }

    private void showToast() {
        Toast.makeText(getActivity(),"Frag One Clicked",Toast.LENGTH_LONG).show();
        fragmentComm.setDataFrag(2,"I'm From 1st Fragment");
    }

}
