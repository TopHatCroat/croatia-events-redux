package cf.varazdinevents.croatiaevents.base.binding;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import cf.varazdinevents.croatiaevents.base.ui.list.ListViewModel;
import cf.varazdinevents.croatiaevents.base.ui.list.SimpleListAdapter;

/**
 * Created by antonio on 27/07/17.
 */

public class BindingAdapters {
    @BindingAdapter(value = "visibility")
    public static void visibility(View view, boolean visible) {
        view.setVisibility(visible? View.VISIBLE : View.INVISIBLE);
    }

    @BindingAdapter(value = "listModel")
    public static void listModel(RecyclerView view, ListViewModel model) {
        SimpleListAdapter adapter = ((SimpleListAdapter) view.getAdapter());
        adapter.setItems(((List) model.getItems().get()));
    }
}
