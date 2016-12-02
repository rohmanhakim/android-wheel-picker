package io.github.rohmanhakim.androidwheelpicker.wheelpicker;

import java.util.TimerTask;

/**
 * Created by rohmanhakim <rohmanhakim@live.com> on 12/2/16 22:09.
 */
final class InertiaTimerTask extends TimerTask {

    float a;
    final float velocityY;
    final WheelPicker wheelPicker;

    InertiaTimerTask(WheelPicker loopview, float velocityY) {
        super();
        wheelPicker = loopview;
        this.velocityY = velocityY;
        a = Integer.MAX_VALUE;
    }

    @Override
    public final void run() {
        if (a == Integer.MAX_VALUE) {
            if (Math.abs(velocityY) > 2000F) {
                if (velocityY > 0.0F) {
                    a = 2000F;
                } else {
                    a = -2000F;
                }
            } else {
                a = velocityY;
            }
        }
        if (Math.abs(a) >= 0.0F && Math.abs(a) <= 20F) {
            wheelPicker.cancelFuture();
            wheelPicker.handler.sendEmptyMessage(MessageHandler.WHAT_SMOOTH_SCROLL);
            return;
        }
        int i = (int) ((a * 10F) / 1000F);
        WheelPicker wp = wheelPicker;
        wp.totalScrollY = wp.totalScrollY - i;
        if (!wheelPicker.isLoop) {
            float itemHeight = wheelPicker.lineSpacingMultiplier * wheelPicker.maxTextHeight;
            if (wheelPicker.totalScrollY <= (int) ((float) (-wheelPicker.initPosition) * itemHeight)) {
                a = 40F;
                wheelPicker.totalScrollY = (int) ((float) (-wheelPicker.initPosition) * itemHeight);
            } else if (wheelPicker.totalScrollY >= (int) ((float) (wheelPicker.items.size() - 1 - wheelPicker.initPosition) * itemHeight)) {
                wheelPicker.totalScrollY = (int) ((float) (wheelPicker.items.size() - 1 - wheelPicker.initPosition) * itemHeight);
                a = -40F;
            }
        }
        if (a < 0.0F) {
            a = a + 20F;
        } else {
            a = a - 20F;
        }
        wheelPicker.handler.sendEmptyMessage(MessageHandler.WHAT_INVALIDATE_LOOP_VIEW);
    }
}

