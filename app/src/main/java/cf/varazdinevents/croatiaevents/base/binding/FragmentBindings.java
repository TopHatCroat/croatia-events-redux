package cf.varazdinevents.croatiaevents.base.binding;

import android.databinding.BindingAdapter;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.lang.ref.WeakReference;

import cf.varazdinevents.croatiaevents.base.ui.list.ListHolder;
import cf.varazdinevents.croatiaevents.base.ui.list.SimpleListAdapter;

/**
 * Created by antonio on 27/07/17.
 */

public class FragmentBindings {
    private final WeakReference<Fragment> fragment;

    public FragmentBindings(Fragment fragment) {
        this.fragment = new WeakReference<>(fragment);
    }

    @BindingAdapter("imageUrl")
    public void imageUrl(ImageView imageView, String url) {
        Glide
                .with(fragment.get())
                .load(url)
                .into(imageView);
    }
}
