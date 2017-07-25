package l8.cb.com.l18firebaseauthen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //firebase mai sab kuck is static
        FirebaseUser curr = FirebaseAuth.getInstance().getCurrentUser();
        if(curr == null){

            Intent i = AuthUI.getInstance().createSignInIntentBuilder()
                    .setIsSmartLockEnabled(false)
                    //.setAvailableProviders(new AuthUI().IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build())
                    .build();

            startActivityForResult(i,123);
        }else{

        }
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        if(requestCode == 123){

            Toast.makeText(this, FirebaseAuth.getInstance().getCurrentUser().getDisplayName(), Toast.LENGTH_SHORT).show();

        }
    }
}
