package cf.varazdinevents.croatiaevents.base.ui.list;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.LinkedList;
import java.util.List;

import cf.varazdinevents.croatiaevents.base.utils.Schedule;
import io.reactivex.Flowable;
import timber.log.Timber;

/**
 * Created by antonio on 26/07/17.
 */

public abstract class SimpleListAdapter<T extends Listable, B extends ViewDataBinding>
        extends RecyclerView.Adapter<SimpleItemViewHolder<B>> {
    @NonNull
    final List<T> items = new LinkedList<>();
    private int dataVersion = 0;

    @Override
    public SimpleItemViewHolder<B> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SimpleItemViewHolder<>(createBinding(parent));
    }

    @NonNull
    protected abstract B createBinding(ViewGroup parent);

    @Override
    public void onBindViewHolder(SimpleItemViewHolder<B> holder, int position) {
        bind(holder.getBinding(), items.get(position));
    }

    protected abstract void bind(B binding, T item);

    public void setItems(@NonNull List<T> newItems) {
        dataVersion++;

        if (items.isEmpty()) {
            items.addAll(newItems);
            notifyDataSetChanged();
        } else if (newItems.isEmpty()) {
            int oldSize = getItemCount();
            items.clear();
            notifyItemRangeRemoved(0, oldSize);
        } else {
            final int oldVerson = dataVersion;
            final List<T> oldItems = items;
            Flowable.just(new DiffCallback<>(oldItems, newItems))
                    .map(callback -> DiffUtil.calculateDiff(callback, detectMoves()))
                    .subscribeOn(Schedule.compute())
                    .observeOn(Schedule.ui())
                    .subscribe(diffResult -> {
                        if (dataVersion != oldVerson) return;
                        else {
                            this.items.clear();
                            this.items.addAll(newItems);
                            Timber.d("dispaching on: " + Thread.currentThread().getName());

                            diffResult.dispatchUpdatesTo(this);
                        }
                    });
        }
    }

    private boolean detectMoves() {
        return false;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
