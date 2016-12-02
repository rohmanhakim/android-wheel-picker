package io.github.rohmanhakim.androidwheelpicker.wheelpicker;


import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * Created by rohmanhakim <rohmanhakim@live.com> on 12/2/16 22:07.
 */
public class WheelPickerGestureListener extends GestureDetector.SimpleOnGestureListener {
    final WheelPicker wheelPicker;

    WheelPickerGestureListener(WheelPicker loopview) {
        wheelPicker = loopview;
    }

    @Override
    public final boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        wheelPicker.scrollBy(velocityY);
        return true;
    }
}
