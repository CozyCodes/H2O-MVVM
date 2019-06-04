package app.h2omvvm.dependencies;



import app.h2omvvm.view.MainActivity;
import dagger.Component;


@CustomScope
@Component(modules = ApiModule.class, dependencies = NetworkComponent.class)
public interface ApiComponent {

    void inject(MainActivity activity);
}
