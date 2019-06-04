package app.h2omvvm.viewModel;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import app.h2omvvm.databinding.AppDataBindingComponent;
import app.h2omvvm.model.LoginUser;
import app.h2omvvm.view.DataActivity;
import app.h2omvvm.view.MainActivity;


public class LoginViewModel implements ViewModel {
    private Context context;

    public ObservableField<String> loginMessage;
    public ObservableInt loginMessageVisibility;
    private String editTextUsernameValue = "";
    private String editTextPasswordValue = "";

    public LoginViewModel(Context context) {
        this.context = context;
        this.loginMessage = new ObservableField<>("");
        this.loginMessageVisibility = new ObservableInt(View.INVISIBLE);
    }

    public void loginAuthentication(View view){
        if ( (editTextUsernameValue.equals("mithran")) && (editTextPasswordValue.equals("mithran"))) {
            loginMessage.set("");
            loginMessageVisibility.set(View.INVISIBLE);
            LoginUser user = new LoginUser(editTextUsernameValue, editTextPasswordValue);
            context.startActivity(MainActivity.newIntent(context, user));
            DataBindingUtil.setDefaultComponent(new AppDataBindingComponent());
            context.startActivity(new Intent (context,DataActivity.class));

        }else if ( (editTextUsernameValue.equals("")) || (editTextPasswordValue.equals(""))) {
            loginMessage.set("Username or Password can't be empty!");
            loginMessageVisibility.set(View.VISIBLE);

        } else {
            loginMessage.set("Username = mithran \n Password = mithran");
            loginMessageVisibility.set(View.VISIBLE);
        }
    }

    public TextWatcher getUsernameUpdate(){
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                editTextUsernameValue = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        };
    }

    public TextWatcher getPasswordUpdate(){
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                editTextPasswordValue= s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        };
    }

    @Override
    public void destroy() {

    }
}
