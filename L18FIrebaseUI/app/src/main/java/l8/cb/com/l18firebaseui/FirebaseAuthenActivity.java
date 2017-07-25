package l8.cb.com.l18firebaseui;

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

public class FirebaseAuthenActivity extends AppCompatActivity {

    EditText etEmail, etPass;
    Button btn;
    FirebaseAuth mAuthen;
    FirebaseAuth.AuthStateListener mAuthenListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_authen);

        etEmail = (EditText) findViewById(R.id.etEmail);
        etPass = (EditText) findViewById(R.id.etPass);
        btn = (Button) findViewById(R.id.btn);
        mAuthen = FirebaseAuth.getInstance();

        //changes when the state is changed
        mAuthenListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if (firebaseAuth.getCurrentUser() != null) {

                    Toast.makeText(FirebaseAuthenActivity.this, "Already signed in", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(FirebaseAuthenActivity.this, DBFirebaseBasicActivity.class));
                    mAuthen.signOut();

                }

            }
        };

        mAuthen.addAuthStateListener(mAuthenListener);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                signIn();

            }
        });

    }

    private void signIn() {

        String email = etEmail.getText().toString();
        String pass = etPass.getText().toString();

        if (!TextUtils.isEmpty(email) || !TextUtils.isEmpty(pass)) {

            mAuthen.signInWithEmailAndPassword(email, pass)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (!task.isSuccessful()) {

                                Toast.makeText(FirebaseAuthenActivity.this, "Problem", Toast.LENGTH_SHORT).show();

                            }

                        }
                    });
        } else {

            Toast.makeText(this, "Fill all the field", Toast.LENGTH_SHORT).show();

        }
    }
}
