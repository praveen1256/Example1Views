package android.com.example1views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class TwoFragment extends Fragment {

    public TwoFragment() {
        // Required empty public constructor
    }

    View view;
    EditText editText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_two, container, false);
        editText = view.findViewById(R.id.et_frag2);
        return view;
    }

    public void setData(String message){
        editText.setText(message);
    }

}
