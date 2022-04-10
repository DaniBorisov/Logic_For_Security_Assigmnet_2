import java.util.Date;

public class Testing {

    private boolean Result;
    private int id;
    private String Type;
    private String date;

    public Testing(String Type,String date, int  id)
    {
        this.Type = Type;
        this.date = date;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean getResult() {
        return Result;
    }

    public void setResult(boolean result) {
        Result = result;
    }

    String getType() {
        return this.Type;
    }

    public String getDate() {
        return this.date;
    }

    public String toString()
    {
        return "Tested with " + this.Type + " at: " +this.date + "  result: " + this.Result;
    }
}
