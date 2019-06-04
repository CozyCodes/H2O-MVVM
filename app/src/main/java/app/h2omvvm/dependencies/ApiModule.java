package app.h2omvvm.dependencies;



import app.h2omvvm.interfaces.CozyApi;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;


@Module
public class ApiModule {

    @Provides
    @CustomScope
    CozyApi provideFlowerService(Retrofit retrofit) {
        return retrofit.create(CozyApi.class);
    }
}
