package l6.cb.com.todolist;

/**
 * Created by ip510 feih on 19-06-2017.
 */

public class MyPojo {

    String topic;
    String detail;
    Boolean isChecked = false ;
    RVAdapter.MyViewHolder viewHolder ;


    public void setChecked(Boolean checked) {
        isChecked = checked;
    }


    public MyPojo(String topic, String detail) {
        this.topic = topic;
        this.detail = detail;
    }

    public String getTopic() {
        return topic;
    }

    public String getDetail() {

        return detail;
    }

    public Boolean getChecked() {

        return isChecked;
    }

    public String toString(){

        return this.topic + " @ " + this.detail + " @ " + this.isChecked ;
    }

    public RVAdapter.MyViewHolder getViewHolder() {
        return viewHolder;
    }

    public void setViewHolder(RVAdapter.MyViewHolder viewHolder) {

        this.viewHolder = viewHolder;
    }


}
