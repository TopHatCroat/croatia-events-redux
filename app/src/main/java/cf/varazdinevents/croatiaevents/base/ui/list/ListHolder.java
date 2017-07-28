package cf.varazdinevents.croatiaevents.base.ui.list;

import android.support.v7.widget.RecyclerView;

/**
 * Created by antonio on 26/07/17.
 */

public interface ListHolder<T> {
    ListListener<T> getListener();

    SimpleListAdapter getAdapter();

    RecyclerView.LayoutManager createLayoutManger();
}
