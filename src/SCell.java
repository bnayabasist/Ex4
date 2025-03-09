//SCell represents a single cell in a spreadsheet, storing its data, type, and order.
public class SCell implements Cell {
    private String _line;
    private int order =0;
    int type = Ex2Utils.TEXT;
    // Default constructor, creates an SCell with an empty string.
    public SCell() {this("");}
    //Constructor, creates an SCell with the given string data.
    public SCell(String s) {setData(s);}
    //Gets the order of the cell.
    @Override
    public int getOrder() {
        return order;
    }

    //Returns the string representation of the cell, which is its data.
    @Override
    public String toString() {
        return getData();
    }
    //Sets the data of the cell and determines its type.
    @Override
    public void setData(String s) {

    if(s!=null) {
        type = Ex2Utils.TEXT;
        if (isNumber(s)) {
            type = Ex2Utils.NUMBER;
        }
        if(s.startsWith("=")) {
            type = Ex2Utils.FORM;
        }
        if (s.startsWith("=if")){
            type = Ex2Utils.IF;
        }
        if (s.startsWith("=min")){
            type = Ex2Utils.Function;
        }
        if (s.startsWith("=max")){
            type = Ex2Utils.Function;
        }
        if (s.startsWith("=sum")){
            type = Ex2Utils.Function;
        }
        if (s.startsWith("=average")){
            type = Ex2Utils.Function;
        }
        _line = s;
    }
}
    //Gets the data of the cell.
    @Override
    public String getData() {
        return _line;
    }
    // Gets the type of the cell.
    @Override
    public int getType() {
        return type;
    }
    //Sets the type of the cell.
    @Override
    public void setType(int t) {
        type = t;
    }
    //Sets the order of the cell.
    @Override
    public void setOrder(int t) {
        this.order = t;
    }
    //Checks if a string represents a number.
    public static boolean isNumber(String line) {
        boolean ans = false;
        try {
            double v = Double.parseDouble(line);
            ans = true;
        }
        catch (Exception e) {;}
        return ans;
    }
}
