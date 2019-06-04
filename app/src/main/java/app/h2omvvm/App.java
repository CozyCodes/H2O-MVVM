
package app.h2omvvm;

import android.app.Application;
import android.databinding.DataBindingUtil;


import app.h2omvvm.databinding.AppDataBindingComponent;
import app.h2omvvm.dependencies.ApiComponent;
import app.h2omvvm.dependencies.DaggerApiComponent;
import app.h2omvvm.dependencies.DaggerNetworkComponent;
import app.h2omvvm.dependencies.NetworkComponent;
import app.h2omvvm.dependencies.NetworkModule;


public class App extends Application {

    private ApiComponent mApiComponent;
    public static final String BASE_URL = "http://services.hanselandpetal.com";

    @Override
    public void onCreate() {
        super.onCreate();
        resolveDependency();
        DataBindingUtil.setDefaultComponent(new AppDataBindingComponent());
    }

    private void resolveDependency() {
        mApiComponent = DaggerApiComponent.builder()
                .networkComponent(getNetworkComponent())
                .build();
    }

    public NetworkComponent getNetworkComponent() {
        return DaggerNetworkComponent.builder()
                .networkModule(new NetworkModule(BASE_URL))
                .build();
    }

    public ApiComponent getApiComponent() {
        return mApiComponent;
    }

}
