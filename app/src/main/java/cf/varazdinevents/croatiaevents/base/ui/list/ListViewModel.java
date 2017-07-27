package cf.varazdinevents.croatiaevents.base.ui.list;

import android.databinding.ObservableField;

import java.util.List;

/**
 * Created by antonio on 26/07/17.
 */

public interface ListViewModel<T> {
    ObservableField<List<T>> getItems();

    ListListener<T> getListener();
}
