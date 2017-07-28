package cf.varazdinevents.croatiaevents.base.binding;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import cf.varazdinevents.croatiaevents.base.ui.list.ListHolder;
import cf.varazdinevents.croatiaevents.base.ui.list.SimpleListAdapter;

/**
 * Created by antonio on 27/07/17.
 */

public class BindingAdapters {
    @BindingAdapter(value = "visibility")
    public static void visibility(View view, boolean visible) {
        view.setVisibility(visible ? View.VISIBLE : View.INVISIBLE);
    }

    @BindingAdapter(value = "listItems")
    public static void listItems(RecyclerView view, List items) {
        SimpleListAdapter adapter = ((SimpleListAdapter) view.getAdapter());
        if (adapter != null)
            adapter.setItems(items);
    }

    @BindingAdapter(value = "dateAsText")
    public static void dateAsText(TextView textView, Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        textView.setText(sdf.format(date));
    }

    @BindingAdapter("setupRecycler")
    public void setupRecycler(RecyclerView view, ListHolder model) {
        SimpleListAdapter adapter = model.getAdapter();
        view.setAdapter(adapter);
        view.setLayoutManager(model.createLayoutManger());
    }
}
