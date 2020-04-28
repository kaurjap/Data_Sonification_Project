// ReadFile.java


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class ReadFile {
    
    protected String filename;
    protected File theFile;
    protected String time;
    
    public ReadFile() {
        this.filename = "";
        this.time = "";
    } // end constructor
    
    public ReadFile(String filename, String time) {
        this.filename = filename;
        this.time = time;
    } // end constructor with parameters
    
    
    public void readDataTo(ArrayList<StockPrice> arr) {
        // perform the operations to read data from the file
        float open;
        float high;
        float low;
        float close;
        float adjClose;
        String dateString;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        // clear the already existing data from the array if any
        if (!arr.isEmpty()) {
            arr.clear();
        } // end if
        
        try {
            BufferedReader theFile = new BufferedReader(new FileReader(this.filename));
            Scanner inFile = new Scanner(theFile);
            inFile.useDelimiter(",");
            inFile.nextLine(); // get the first line out of the way
            while (inFile.hasNextLine()) {
                dateString = inFile.next();
                Date date = formatter.parse(dateString);
                open = inFile.nextFloat();
                high = inFile.nextFloat();
                low = inFile.nextFloat();
                close = inFile.nextFloat();
                adjClose = inFile.nextFloat();
                inFile.nextLine();
                if (inTimeRange(date)) {
                    StockPrice price = new StockPrice(date, open, high, low, close, adjClose);
                    arr.add(price);
                } // end if
            } // end while
        } catch (Exception e) {
            System.out.println("inside catch of ReadFile...");
            System.out.println(e.getMessage());
        } // end try-catch
    } // end readDataTo
    
    public boolean inTimeRange(Date date) {
        boolean inTime = false;
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        if (this.time.equals("6 Months")) {
            if (c.get(Calendar.YEAR) >= 2019) {
                if (c.get(Calendar.MONTH) >= 10) {  // 10 because year is read one less for some reason
                    inTime = true;
                } else if (c.get(Calendar.MONTH) <= 4 && c.get(Calendar.YEAR) == 2020) {
                    inTime = true;
                } // end inner if
            } // end if
        } else if (this.time.equals("1 Year")) {
            if (c.get(Calendar.YEAR) >= 2019) {
                inTime = true;
            }
        } else if (this.time.equals("2 Years")) {
            if (c.get(Calendar.YEAR) >= 2018) {
                inTime = true;
            }
        } else if (this.time.equals("5 Years")) {
            inTime = true;
        } // end if
        return inTime;
    } // end inTimeRange
    
    
    
    // access methods
    public String getFilename() {
        return this.filename;
    } // end getter

    public void setFilename(String filename) {
        this.filename = filename;
    } // end setter

    public String getTime() {
        return time;
    } // end getTime

    public void setTime(String time) {
        this.time = time;
    } // end setTime
    
} // end class def
