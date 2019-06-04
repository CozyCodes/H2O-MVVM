package app.h2omvvm.view;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import app.h2omvvm.App;
import app.h2omvvm.R;
import app.h2omvvm.databinding.ActivityMainBinding;
import app.h2omvvm.model.LoginUser;
import app.h2omvvm.viewModel.MainViewModel;


public class MainActivity extends AppCompatActivity {

    private static final String EXTRA_USER = "extra_user";

    ActivityMainBinding binding;
    MainViewModel viewModel;

    public static Intent newIntent(Context context, LoginUser user){
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(EXTRA_USER, user);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        resolveDependency();
//        GET USER DATA
        LoginUser user = getIntent().getParcelableExtra(EXTRA_USER);

//        LoginUser user = new LoginUser("test", "test");

        viewModel = new MainViewModel(this, user);
        binding.setViewmodel(viewModel);
    }

    private void resolveDependency() {
        ((App) getApplication())
                .getApiComponent()
                .inject(MainActivity.this);
    }


}
