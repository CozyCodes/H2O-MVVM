package app.h2omvvm.viewModel;

import android.app.ProgressDialog;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;


import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import app.h2omvvm.BR;
import app.h2omvvm.R;
import app.h2omvvm.adapter.DataAdapter;
import app.h2omvvm.interfaces.CozyApi;
import app.h2omvvm.model.DataModel;
import app.h2omvvm.response.MyOrderResp;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class DataViewModel extends BaseObservable {
    private static final String TAG = "DataViewModel";
    private DataAdapter adapter;
    private List<DataModel> data;
    private CozyApi apiService;

    public DataViewModel() {
        data = new ArrayList<>();
        adapter = new DataAdapter();
    }

    public void setUp() {
        // perform set up tasks, such as adding listeners, data population, etc.
//        populateData();
        getOnlineProducts();
    }

    public void tearDown() {
        // perform tear down tasks, such as removing listeners
    }

    @Bindable
    public List<DataModel> getData() {
        return this.data;
    }

    @Bindable
    public DataAdapter getAdapter() {
        return this.adapter;
    }

    private void populateData() {
        // populate the data from the source, such as the database.
        for (int i = 0; i < 50; i++) {
            DataModel dataModel = new DataModel();
            dataModel.setTitle(String.valueOf(i));
            data.add(dataModel);
        }
        notifyPropertyChanged(BR.data);
    }

    private void getOnlineProducts() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://thulasiram.in/htoo/apis/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        apiService = retrofit.create(CozyApi.class);

        JSONObject paramObject = null;

        try {
            paramObject = new JSONObject();
            paramObject.put("id", "8");
            Log.v("paramObject",paramObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),paramObject.toString() );
        final Observable<MyOrderResp> observable = apiService.getAllUsers(requestBody).subscribeOn
                (Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());

        observable.subscribe(new Observer<MyOrderResp>() {

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(MyOrderResp value) {

//                productList = new ArrayList<>();
                String user_id ="";
                List<MyOrderResp> orderVal = value.getOrder();
                Log.v("get_response",value.getRes_msg());
                String res_msg = value.getRes_msg();
                for (int i = 0; i < orderVal.size(); i++) {

                        DataModel dataModel = new DataModel();
                        dataModel.setTitle(orderVal.get(i).getDisplay_name());
                        dataModel.setName(orderVal.get(i).getID());

                        data.add(dataModel);

                    notifyPropertyChanged(BR.data);
                }





            }

            @Override
            public void onError(Throwable e) {
                Log.d("error",e.toString());
            }

            @Override
            public void onComplete() {
                Log.v("inhere","--");
//                observable.unsubscribeOn(Schedulers.newThread());
            }


        });
    }

}
