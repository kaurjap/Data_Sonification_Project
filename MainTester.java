
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class MainTester {
    
    protected static ArrayList<StockPrice> stockprices = new ArrayList<>();

    public static void main(String[] args) {
        
        
//        Date date = new Date(2020, 04, 28);
//        StockPrice price = new StockPrice();
//        price.setDate(date);
//        System.out.println(price.getDate().toString());
//       
//        Calendar c = Calendar.getInstance();
//        c.setTime(date);
//        System.out.println(c.get(Calendar.YEAR));
//        System.out.println(c.get(Calendar.MONTH));
//        System.out.println(c.get(Calendar.DAY_OF_MONTH));
//    
        ReadFile reader = new ReadFile("src/NYSE.csv", "1 Year");
        reader.readDataTo(stockprices);
        
        for (int i = 0; i < stockprices.size(); i++) {
            System.out.println(stockprices.get(i).getHighPrice());
            stockprices.get(i).setValueToPlay(stockprices.get(i).getHighPrice() * 100);
        } // end for
        
        float maxNum;
        float minNum;
        maxNum = getMaxNum();
        minNum = getMinNum();
        float rangeFrom = maxNum - minNum;

        
        Graph myGraph = new Graph(minNum, maxNum, rangeFrom, stockprices);
        
        
    } // end main
    
    public static float getMaxNum() {
        float currentPrice;
        float maxNum = stockprices.get(0).getValueToPlay(); // set zeroeth term as the initial max
        for (int i = 0; i < stockprices.size(); i++) {
            currentPrice = stockprices.get(i).getValueToPlay();
                if (currentPrice > maxNum) {
                    maxNum = currentPrice;
                } // end if
        } // end for
        return maxNum;
    } // end getMaxNum
     
    public static float getMinNum() {
        float currentPrice;
        float minNum = stockprices.get(0).getValueToPlay(); // set zeroeth term as the initial min
        for (int i = 1; i < stockprices.size(); i++) {
            currentPrice = stockprices.get(i).getValueToPlay();
            if (currentPrice < minNum) {
                minNum = currentPrice;
            } // end if
        } // end for
        return minNum;
    } // end getMinNum
    
    
} // end class def
