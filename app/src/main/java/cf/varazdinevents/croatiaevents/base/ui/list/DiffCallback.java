package cf.varazdinevents.croatiaevents.base.ui.list;

import android.support.v7.util.DiffUtil;

import java.util.List;

import timber.log.Timber;

/**
 * Created by antonio on 26/06/17.
 */

public class DiffCallback<T extends Listable> extends DiffUtil.Callback {
    private List<T> old;
    private List<T> current;

    public DiffCallback(List<T> old, List<T> current) {
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
        Timber.d("calculating on: " + Thread.currentThread().getName());
        return old.get(oldItemPosition).getId().equals(current.get(newItemPosition).getId());
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return old.get(oldItemPosition).equals(current.get(newItemPosition));
    }
}
