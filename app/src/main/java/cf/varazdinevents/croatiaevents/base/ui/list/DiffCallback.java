package cf.varazdinevents.croatiaevents.base.ui.list;

import android.support.v7.util.DiffUtil;

import java.util.List;

import timber.log.Timber;

/**
 * Created by antonio on 26/06/17.
 */

public class DiffCallback<T extends Listable> extends DiffUtil.Callback {
    private final SimpleListAdapter adapter;
    private List<T> old;
    private List<T> current;

    public DiffCallback(SimpleListAdapter adapter, List<T> old, List<T> current) {
        this.adapter = adapter;
        this.old = old;
        this.current = current;
    }

    @Override
    public int getOldListSize() {
        return old.size();
    }

    @Override
    public int getNewListSize() {
        return current.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return this.adapter.areItemsTheSame(old.get(oldItemPosition), current.get(newItemPosition));
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return this.adapter.areContentsTheSame(old.get(oldItemPosition), current.get(newItemPosition));
    }
}
