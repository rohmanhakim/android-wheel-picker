package io.github.rohmanhakim.androidwheelpicker.wheelpicker;

/**
 * Created by rohmanhakim <rohmanhakim@live.com> on 12/2/16 22:04.
 */
public class OnItemSelectedRunnable implements Runnable {
    final WheelPicker loopView;

    OnItemSelectedRunnable(WheelPicker loopview) {
        loopView = loopview;
    }

    @Override
    public final void run() {
        loopView.onItemSelectedListener.onItemSelected(loopView.getSelectedItem());
    }
}
