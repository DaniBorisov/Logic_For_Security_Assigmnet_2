import java.util.Date;

public class Testing extends Record {

    private boolean Result;
    private String Type;
    private Date date;

    public Testing(boolean result, String Type,Date date)
    {
        this.Result = result;
        this.Type = Type;
        this.date = date;
    }

    public boolean isResult() {
        return Result;
    }

    public void setResult(boolean result) {
        Result = result;
    }

    public String getType() {
        return Type;
    }

    @Override
    void setType() {

    }

    public void setType(String type) {
        Type = type;
    }

    public Date getDate() {
        return date;
    }

    @Override
    void setDate() {

    }

    public void setDate(Date date) {
        this.date = date;
    }
}
