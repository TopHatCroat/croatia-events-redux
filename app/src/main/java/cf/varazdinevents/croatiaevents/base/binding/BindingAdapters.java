package cf.varazdinevents.croatiaevents.base.binding;

import android.databinding.BindingAdapter;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.google.common.base.Strings;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import cf.varazdinevents.croatiaevents.base.ui.list.ListHolder;
import cf.varazdinevents.croatiaevents.base.ui.list.SimpleListAdapter;
import cf.varazdinevents.croatiaevents.tools.AndroidTools;

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

    @BindingAdapter(value = {"dateAsText", "dateFormat"}, requireAll = true)
    public static void dateAsText(TextView textView, Date date, String format) {
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            textView.setText(sdf.format(date));
        }
    }

    @BindingAdapter(value = "htmlText")
    public static void htmlText(TextView textView, String text) {
        if (Strings.isNullOrEmpty(text))
            return;

        Handler handler = new Handler();
        handler.post(() -> {
            String result = "";
            if (AndroidTools.is24()) {
                result = Html.fromHtml(text, Html.FROM_HTML_MODE_LEGACY).toString();
            } else {
                result = String.valueOf(Html.fromHtml(text));
            }

            textView.setText(result);
        });
    }

    @BindingAdapter("setupRecycler")
    public void setupRecycler(RecyclerView view, ListHolder model) {
        SimpleListAdapter adapter = model.getAdapter();
        view.setAdapter(adapter);
        view.setLayoutManager(model.createLayoutManger());
    }
}
