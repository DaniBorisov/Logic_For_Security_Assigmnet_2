import java.util.Date;

public abstract class Record {

    private Testing[] tests;

    private Date date;
    private String type;

    abstract Date getDate();
    abstract void setDate();
    abstract String getType();
    abstract void setType();


}
