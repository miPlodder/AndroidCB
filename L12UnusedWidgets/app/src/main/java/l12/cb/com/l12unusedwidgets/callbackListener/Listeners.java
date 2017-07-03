package l12.cb.com.l12unusedwidgets.callbackListener;

/**
 * Created by ip510 feih on 03-07-2017.
 */

public class Listeners {

    interface MyOnClick{
        void onClick();
    }

    private MyOnClick onClick;

    public void setMyOnClick(MyOnClick myOnClick){

        this.onClick = onClick;

    }

}
