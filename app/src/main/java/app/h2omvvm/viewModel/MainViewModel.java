package app.h2omvvm.viewModel;

import android.content.Context;
import android.arch.lifecycle.ViewModel;


import app.h2omvvm.model.LoginUser;


public class MainViewModel extends ViewModel {
    private Context context;
    private LoginUser user;

    public MainViewModel(Context context, LoginUser user) {
        this.context = context;
        this.user = user;
    }

    public String getUsername(){
        return user.username;
    }
    public String getPassword(){
        return user.password;
    }



}
