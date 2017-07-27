package cf.varazdinevents.croatiaevents.base.ui.list;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

/**
 * Created by antonio on 26/07/17.
 */

public class SimpleItemViewHolder<B extends ViewDataBinding> extends RecyclerView.ViewHolder {
    protected final B binding;
    public SimpleItemViewHolder(B binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public B getBinding() {
        return binding;
    }
}
