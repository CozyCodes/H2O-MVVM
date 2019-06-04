package app.h2omvvm.interfaces;


import app.h2omvvm.response.MyOrderResp;
import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by Cozycodes on 5/26/2017.
 */

public interface CozyApi {

    @POST("admin_getusers.php")
    Observable<MyOrderResp> getAllUsers(@Body RequestBody body);

    @POST("admin_allorders.php")
    Observable<MyOrderResp> getAllOrders(@Body RequestBody body);

    @POST("admin_more_allorders.php")
    Observable<MyOrderResp> getMoreAllOrders(@Body RequestBody body);

    @POST("admin_searchorders.php")
    Observable<MyOrderResp> getSearchOrder(@Body RequestBody body);

}
