package kr.tjeit.finaltest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignInActivity extends BaseActivity {

    private android.widget.Button SignInBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);


        bindView();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {


        SignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, ProfileActivity.class);
                startActivity(intent);

            }
        });

    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindView() {

        this.SignInBtn = (Button) findViewById(R.id.SignInBtn);

    }
}
