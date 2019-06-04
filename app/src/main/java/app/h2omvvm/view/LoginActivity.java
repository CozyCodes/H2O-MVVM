package app.h2omvvm.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import app.h2omvvm.R;
import app.h2omvvm.databinding.ActivityLoginBinding;
import app.h2omvvm.viewModel.LoginViewModel;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        viewModel = new LoginViewModel(this);
        binding.setViewmodel(viewModel);
    }
}
