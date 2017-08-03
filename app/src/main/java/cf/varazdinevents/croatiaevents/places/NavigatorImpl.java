package cf.varazdinevents.croatiaevents.places;

import android.support.v4.app.FragmentManager;

import cf.varazdinevents.croatiaevents.R;
import cf.varazdinevents.croatiaevents.base.BaseActivity;
import cf.varazdinevents.croatiaevents.base.BaseFragment;
import cf.varazdinevents.croatiaevents.places.eventDetail.EventDetailFragment;
import cf.varazdinevents.croatiaevents.places.events.EventsFragment;
import cf.varazdinevents.croatiaevents.tools.Creator;

/**
 * Created by antonio on 02/08/17.
 */

public class NavigatorImpl implements Navigator {
    private final FragmentManager fragmentManager;
    private final BaseActivity activity;

    public NavigatorImpl(BaseActivity activity, FragmentManager fragmentManager) {
        this.activity = activity;
        this.fragmentManager = fragmentManager;
    }

    @Override
    public void toListEvents() {
        goToFragment(
                EventsFragment.TAG,
                () -> EventsFragment.newInstance()
        );
    }

    @Override
    public void toEventDetails(int eventId) {
        goToFragment(
                EventsFragment.TAG,
                EventDetailFragment.TAG,
                () -> EventDetailFragment.newInstance(eventId)
        );
    }

    @Override
    public void goBack() {
        if (fragmentManager.getBackStackEntryCount() == 1) {
            activity.finish();
        } else {
            fragmentManager.popBackStack();
        }
    }

    private <T extends BaseFragment> void goToFragment(final String tag, final Creator<T> creator) {
        goToFragment(null, tag, creator);
    }

    private <T extends BaseFragment> void goToFragment(final String oldTag, final String newTag, final Creator<T> creator) {
        final BaseFragment oldFragment = (BaseFragment) fragmentManager.findFragmentByTag(oldTag);
        final BaseFragment newFragment = (BaseFragment) fragmentManager.findFragmentByTag(newTag);

        if(oldFragment == null && newFragment == null) {
            fragmentManager.beginTransaction()
                    .setCustomAnimations(R.anim.enter_up, R.anim.exit_down, R.anim.enter_left, R.anim.exit_right)
                    .addToBackStack(null)
                    .add(R.id.content_holder, creator.create(), newTag)
                    .commit();
        } else if (newFragment == null) {
            fragmentManager.beginTransaction()
                    .setCustomAnimations(R.anim.enter_right, R.anim.exit_left, R.anim.enter_left, R.anim.exit_right)
                    .addToBackStack(null)
                    .hide(oldFragment)
                    .add(R.id.content_holder, creator.create(), newTag)
                    .commit();
        } else {
            fragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .hide(oldFragment)
                    .show(newFragment)
                    .commit();
        }
    }
}
