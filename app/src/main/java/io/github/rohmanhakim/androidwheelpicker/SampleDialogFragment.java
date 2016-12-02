package io.github.rohmanhakim.androidwheelpicker;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import io.github.rohmanhakim.androidwheelpicker.wheelpicker.OnItemSelectedListener;
import io.github.rohmanhakim.androidwheelpicker.wheelpicker.WheelPicker;

/**
 * Created by rohmanhakim <rohmanhakim@live.com> on 12/2/16 21:47.
 */
public class SampleDialogFragment extends DialogFragment {
    private WheelPicker wheelPicker;
    private String title;

    public SampleDialogFragment() {
        // Empty constructor is required for DialogFragment
        // Make sure not to add arguments to the constructor
        // Use `newInstance` instead as shown below
    }

    public static SampleDialogFragment newInstance(String title) {
        SampleDialogFragment frag = new SampleDialogFragment();
        frag.title = title;
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_sample_dialog, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getDialog().setTitle(title);

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            list.add("item " + i);
        }

        wheelPicker = (WheelPicker) view.findViewById(R.id.wp_countries);

        wheelPicker.setListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {
                Log.d("debug", "Item " + index);
            }
        });

        wheelPicker.setItems(list);

        wheelPicker.setItemsVisible(4);

        wheelPicker.setInitPosition(5);

        wheelPicker.setTextSize(30);

        wheelPicker.setViewPadding(20,0,20,0);


    }


}
