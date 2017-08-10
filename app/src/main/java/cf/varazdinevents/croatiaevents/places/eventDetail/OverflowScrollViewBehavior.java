package cf.varazdinevents.croatiaevents.places.eventDetail;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Px;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import timber.log.Timber;

/**
 * Created by antonio on 03/08/17.
 */

public class OverflowScrollViewBehavior extends CoordinatorLayout.Behavior<View> {
    @Px
    public static final int MAX_OVERFLOW_AMOUNT = 200;

    private int overScrollY;
    private boolean isTouching = false;

    public OverflowScrollViewBehavior() {
    }

    public OverflowScrollViewBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public void onStopNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child,
                                   @NonNull View target, int type) {
//        final ViewGroup group = (ViewGroup) target;
//        final int count = group.getChildCount();
//        for (int i = 0; i < count; i++) {
//            final View view = group.getChildAt(i);
//            ViewCompat.animate(view).translationY(0).start();
//        }
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child,
                                       @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        overScrollY = 0;
        return true;
    }

    @Override
    public boolean onTouchEvent(CoordinatorLayout parent, View child, MotionEvent ev) {
        if (ev.getAction() == android.view.MotionEvent.ACTION_DOWN) {
            isTouching = true;
        } else if (ev.getAction() == android.view.MotionEvent.ACTION_UP) {
            isTouching = false;
        }
        return true;
    }

    @Override
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child,
                               @NonNull View target, int dxConsumed, int dyConsumed,
                               int dxUnconsumed, int dyUnconsumed, int type) {
        if (dyUnconsumed == 0) {
            return;
        }
        Timber.d("Overscroll y : " + overScrollY + " uncomsumed: " + dyUnconsumed);

        overScrollY -= dyUnconsumed;
        if(overScrollY < -MAX_OVERFLOW_AMOUNT) {
            overScrollY = -MAX_OVERFLOW_AMOUNT;
            if(!isTouching) animateToRest((ViewGroup) target);
            ((NestedScrollView) child).stopNestedScroll();
            return;
        } else if(overScrollY > MAX_OVERFLOW_AMOUNT) {
            overScrollY = MAX_OVERFLOW_AMOUNT;
            if(!isTouching) animateToRest((ViewGroup) target);
            ((NestedScrollView) child).stopNestedScroll();

            return;
        }

        final ViewGroup group = (ViewGroup) target;
        final int count = group.getChildCount();
        for (int i = 0; i < count; i++) {
            final View view = group.getChildAt(i);
            view.setTranslationY(overScrollY);
        }
    }

    private void animateToRest(@NonNull ViewGroup target) {
        final ViewGroup group = target;
        final int count = group.getChildCount();
        for (int i = 0; i < count; i++) {
            final View view = group.getChildAt(i);
            ViewCompat.animate(view).translationY(0).start();
        }
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return true;
    }
}
