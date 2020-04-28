// Main.java

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// Main.java

public class Main extends BottomPanel implements ActionListener {
   
    // array to store all the stockprices based on the user's selections
    protected ArrayList<StockPrice> stockprices;
    protected ArrayList<Integer> pitches;
    protected ReadFile reader;
    protected SoundPlayer player;
    //protected BottomPanel bottomPanel;
    //protected Graph myGraph;
    
     // the MAIN function
    public static void main(String[] args) {
        Main main = new Main();
    } // end main

    
    
    public Main() {
        super();
        stockprices = new ArrayList<>();
        reader = new ReadFile();
        player = new SoundPlayer();
        pitches = new ArrayList<>();
        //myGraph = new Graph();
        //bottomPanel = new BottomPanel();
        //myGraph.setBottomPanel(bottomPanel);
        //bottomPanel.getPlayButton().addActionListener(this);
        playButton.addActionListener(this);
    } // end constructor
  
    @Override
    public void actionPerformed(ActionEvent e) {

        // check the time selected
        String timeSelected;
        timeSelected = (String) time.getSelectedItem();
        // radio buttons with stock indexes
        if (NYSE.isSelected()) {
            reader.setTime(timeSelected);
            reader.setFilename("./NYSE.csv");
            reader.readDataTo(stockprices);
        } else if (NASDAQ.isSelected()) {
            reader.setTime(timeSelected);
            reader.setFilename("./NASDAQ.csv");
            reader.readDataTo(stockprices);
        } else if (DJIA.isSelected()) {
            reader.setTime(timeSelected);
            reader.setFilename("./DJIA.csv");
            reader.readDataTo(stockprices);
        } else {
            
        } // end if
                
        System.out.println("StockPrices Array size after reading: " + stockprices.size());
        
        // change the instrument accordingly
        String selected;
        selected = (String) instruments.getSelectedItem();
        if (selected.equals("Piano")) {
            player.setInstrument(PIANO);
        } else if (selected.equals("Xylophone")) {
            player.setInstrument(XYLOPHONE);
        } else if (selected.equals("Harmonica")) {
            player.setInstrument(HARMONICA);
        } else if (selected.equals("Guitar")) {
            player.setInstrument(GUITAR);
        } else if (selected.equals("Violin")) {
            player.setInstrument(VIOLIN);
        } else if (selected.equals("Flute")) {
            player.setInstrument(FLUTE);
        } // end if
    
        // set the value to play for a stockprice equal to the selection made by the user
        String priceType;
        priceType = (String) priceToWatch.getSelectedItem();
        for (int i = 0; i < stockprices.size(); i++) {
            if (priceType.equals("Open Price")) {
                    stockprices.get(i).setValueToPlay(stockprices.get(i).getOpenPrice() * 100);
            } else if (priceType.equals("High Price")) {
                    stockprices.get(i).setValueToPlay(stockprices.get(i).getHighPrice() * 100);
            } else if (priceType.equals("Low Price")) {
                    stockprices.get(i).setValueToPlay(stockprices.get(i).getLowPrice() * 100);
            } else if (priceType.equals("Close Price")) {
                    stockprices.get(i).setValueToPlay(stockprices.get(i).getClosePrice() * 100);
            } // end if
        } // end for
        
        // find maximum and minimum prices of the existing data
        float maxNum;
        float minNum;
        maxNum = getMaxNum();
        minNum = getMinNum();
        // find the range of the existing data
        float rangeFrom = maxNum - minNum;
        
        Graph myGraph = new Graph(minNum, maxNum, rangeFrom, stockprices);
        
        /*
        output = output_start + ((output_end - output_start) / (input_end - input_start)) * (input - input_start)
        
        Or, think about it this way
        slope = (output_end - output_start) / (input_end - input_start)
        output = output_start + slope * (input - input_start)
        */
       
        // make sure the pitches array is empty before adding any elements to it
        if (!pitches.isEmpty()) {
            pitches.clear();
        } // end if
        
        float rangeTo = 97; // range of the notes that can be played on the MIDI, first note that will be played is 10
        int priceCasted; // number that will be added to the pitches dictionary as the price
        float numConverted;
        float slope;
        slope = rangeTo/rangeFrom;
        // convert each data value in the arrayList to correspond to new values in the new range
        for (int i = 0; i < stockprices.size(); i++) {
            // calculation to convert the number to the 30-127 range (audible)
            numConverted = 30 + slope * (stockprices.get(i).getValueToPlay() - minNum);
            priceCasted = (int) numConverted;
            // make sure the pitches array is Empty before this data is played
            pitches.add(priceCasted);
        } // end for
        
        // the pitches arrayList is now populated with the pitches to play
        // now play the sound accordingly
        System.out.println("Instrument: " + player.getInstrument());
        for (int i = 0; i < pitches.size(); i++) {
            player.setPitch(pitches.get(i));
            player.playSound();
            System.out.println(pitches.get(i) + " ----->    $" + stockprices.get(i).getValueToPlay()/100);
            System.out.println("Count " + i);
            // to change the date, prolly add a new Runnable here somewhere
        } // end for

    } // end actionPerformed
    
    
    
     // other methods
     public float getMaxNum() {
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
     
    public float getMinNum() {
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
    
    // constants representing different midi instruments
    public static int
        PIANO = 0,
        XYLOPHONE = 13,
        HARMONICA = 22,
        GUITAR = 24,
        VIOLIN = 40,
        TRUMPET = 56,
        FLUTE = 73;
    
} // end class def
