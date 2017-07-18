package l17.cb.com.l17firebase;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class AuthenActivity extends AppCompatActivity {

    EditText etEmail, etPass;
    Button btn;
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener ;

    @Override
    protected void onStart() {
        super.onStart();

        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authen);

        mAuth = FirebaseAuth.getInstance();
        etEmail = (EditText) findViewById(R.id.etName);
        etPass = (EditText) findViewById(R.id.etPass);
        btn = (Button) findViewById(R.id.btn);

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if(firebaseAuth.getCurrentUser() == null){
                    //sign in pending
                }else{

                    startActivity(new Intent(AuthenActivity.this, MainActivity.class));

                }

            }
        };

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startSignIn();
            }


        });

    }

    void startSignIn() {


        String email = etEmail.getText().toString();
        String pass = etPass.getText().toString();

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(pass)) {

            Toast.makeText(this, "Please enter all the fields", Toast.LENGTH_SHORT).show();

        } else {
            mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (!task.isSuccessful()) {

                        Toast.makeText(AuthenActivity.this, "Some Unknown Error Occured", Toast.LENGTH_SHORT).show();

                    }

                }
            });

        }
    }
}

