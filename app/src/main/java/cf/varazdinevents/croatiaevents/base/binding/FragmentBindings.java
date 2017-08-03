package cf.varazdinevents.croatiaevents.base.binding;

import android.databinding.BindingAdapter;
import android.support.v4.app.Fragment;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.transition.TransitionFactory;

import java.lang.ref.WeakReference;

import cf.varazdinevents.croatiaevents.R;

/**
 * Created by antonio on 27/07/17.
 */

public class FragmentBindings {
    private final WeakReference<Fragment> fragment;

    public FragmentBindings(Fragment fragment) {
        this.fragment = new WeakReference<>(fragment);
    }

    @BindingAdapter(value = {"imageUrl", "imageUrlHeader"}, requireAll = false)
    public void imageUrl(ImageView imageView, String url, boolean header) {
        RequestBuilder builder = Glide.with(fragment.get())
                .load(url)
                .apply(RequestOptions.placeholderOf(R.drawable.placeholder_image));
        if (header) {
            builder.apply(RequestOptions.centerCropTransform());
        }

        builder.into(imageView);
    }
}
