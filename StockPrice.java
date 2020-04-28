// DataPoint.java
 
import java.text.SimpleDateFormat;
import java.util.Date;

/* This class represents a specific point in the data. It represents a specific stock price. 
 * An aggregation of all class objects of this class are the elements in the array list of 
 * data used in the main class.
*/


public class StockPrice {
    
    protected Date date;
    protected float openPrice;
    protected float highPrice;
    protected float lowPrice;
    protected float closePrice;
    protected float adjClose;
    protected float valueToPlay;
    
    
    public StockPrice() {
        this.date = new Date();
        this.openPrice = 0;
        this.highPrice = 0;
        this.lowPrice = 0;
        this.closePrice = 0;
        this.adjClose = 0;
        this.valueToPlay = 0;
    } // end constructor
    
    public StockPrice(Date date, float openPrice, float highPrice, float lowPrice, float closePrice, float adjClose) {  
        this.date = date;
        this.openPrice = openPrice;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.closePrice = closePrice;
        this.adjClose = adjClose;
    } // end parameterized constructor
    
    public void printInfo() {
        System.out.println(this.getDate());
        System.out.println(this.openPrice);
        System.out.println(this.highPrice);
        System.out.println(this.lowPrice);
        System.out.println(this.closePrice);
        System.out.println(this.adjClose);
    } // end printInfo
    
    // access methods
    public String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(this.date);
    } // end getDate

    public float getOpenPrice() {
        return this.openPrice;
    } // end getOpenPrice

    public float getHighPrice() {
        return this.highPrice;
    } // end getHighPrice

    public float getLowPrice() {
        return this.lowPrice;
    } // end getLowPrice

    public float getClosePrice() {
        return this.closePrice;
    } // end getClosePrice
    
    public void setOpenPrice(float openPrice) {
        this.openPrice = openPrice;
    } // end setOpenPrice

    public void setHighPrice(float highPrice) {
        this.highPrice = highPrice;
    } // end setHighPrice

    public void setLowPrice(float lowPrice) {
        this.lowPrice = lowPrice;
    } // end setLowPrice

    public void setClosePrice(float closePrice) {
        this.closePrice = closePrice;
    } // end setClosePrice

    public float getAdjClose() {
        return adjClose;
    } // end getAdjClose

    public void setAdjClose(float adjClose) {
        this.adjClose = adjClose;
    } // end set AdjClose

    public float getValueToPlay() {
        return valueToPlay;
    } // end getValueToPlay

    public void setValueToPlay(float valueToPlay) {
        this.valueToPlay = valueToPlay;
    } // end setValueToPlay

    public void setDate(Date date) {
        this.date = date;
    } // end setDate
    
} // end class def
    