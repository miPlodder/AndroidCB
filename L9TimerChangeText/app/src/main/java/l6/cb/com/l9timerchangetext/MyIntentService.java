package l6.cb.com.l9timerchangetext;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

//by default this INtent Service will run on BACKGROUND THREAD
//this thread cannot be explicitly stopped
public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyIntentService");
    }
    @Override

    protected void onHandleIntent(Intent intent) {

    }

}
