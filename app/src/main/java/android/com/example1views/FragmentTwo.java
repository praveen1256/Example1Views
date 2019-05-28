package android.com.example1views;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentTwo extends Fragment {

    String TAG = "MainActivity LifeCycle FragmentTwo ";

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.v(TAG,TAG+" : onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(TAG,TAG+" : onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.v(TAG,TAG+" : onCreateView");
        return inflater.inflate(R.layout.fragment_two,null,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.v(TAG,TAG+" : onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.v(TAG,TAG+" : onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.v(TAG,TAG+" : onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.v(TAG,TAG+" : onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.v(TAG,TAG+" : onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.v(TAG,TAG+" : onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.v(TAG,TAG+" : onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.v(TAG,TAG+" : onDetach");
        super.onDetach();
    }
}
