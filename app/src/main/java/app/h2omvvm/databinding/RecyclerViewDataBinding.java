
package app.h2omvvm.databinding;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;


import java.util.List;

import app.h2omvvm.adapter.DataAdapter;
import app.h2omvvm.model.DataModel;


public class RecyclerViewDataBinding {

    @BindingAdapter({"app:adapter", "app:data"})
    public void bind(RecyclerView recyclerView, DataAdapter adapter, List<DataModel> data) {
        recyclerView.setAdapter(adapter);
        adapter.updateData(data);
    }
}
