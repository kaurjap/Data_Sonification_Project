// Graph.java
// the Swing part of the GUI is wrapped around SwingUtilities.invokeLater
// the JavaFX setscene part of the GUI is wrapped around platform.runLater, but not in this case because we need to run the graph first

import java.applet.Applet;
import java.awt.Container;
import java.util.ArrayList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javax.swing.JFrame;


public class Graph extends Applet {
    
    protected float totalDataPoints;
    protected float rangeYAxis; // range of the data on the y-axis
    protected float yMin;
    protected float yMax;
    protected float yInterval;
    protected ArrayList<StockPrice> prices;
    
    public Graph() {
        this.prices = new ArrayList<>();
    } // end constructor
    
    // make this act like the main function in the other example
    public Graph(float yMin, float yMax, float rangeYAxis, ArrayList<StockPrice> arr) {
        this.yMin = yMin/100;
        this.yMax = yMax/100;
        this.rangeYAxis = rangeYAxis/100;
        this.prices = new ArrayList<>();
        this.prices = arr;
        this.setDataSize();
        this.setYInterval();
        init();
    } // end constructor
    
    // to create and show the GUI
    @Override
    @SuppressWarnings("unchecked")
    public void init() {
        // sets up the whole GUI of the page
        JFrame frame = new JFrame();
        Container pane = frame.getContentPane();
        JFXPanel fxPanel = new JFXPanel(); // to add the graph to the swing GUI
        
        // setting up the Axes
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis("Stock Prices (dollars)", yMin, yMax, yInterval);
        xAxis.setLabel("Time");
        
        // setting up the LineChart using the LineChart class
        LineChart<String, Number> trendline = new LineChart<>(xAxis, yAxis);
        // the data is created as a series and then added to the linechart (trendline)
        XYChart.Series series = new XYChart.Series<>();
        series.setName("Prices");
        trendline.setTitle("Stock Data Over Time");
        String currentDate;
        float currentPrice;
        for (int i = 0; i < prices.size(); i++) {
            currentDate = prices.get(i).getDate();
            currentPrice = (prices.get(i).getValueToPlay())/100;
            series.getData().add(new XYChart.Data<>(currentDate, currentPrice));
        } // end for

        // adding the trendline/chart to the series
        trendline.getData().add(series);
        
        // scene is like a container in JFrame
        // setting the scene in order to add the graph to the panel
        Scene scene = new Scene(trendline, 800, 600);
        fxPanel.setScene(scene); 
        
        pane.add(fxPanel);
        frame.setSize(1000, 1000);
        frame.setVisible(true);
        
    } // end init
    
    // access methods and some specific setters
    public void setYInterval() {
        this.yInterval = rangeYAxis/totalDataPoints;
    } // end setYInterval
    
    public void setDataSize() {
        this.totalDataPoints = prices.size();
    } // end setSizeData

    
    
    // access methods
    public void setRangeYAxis(float rangeYAxis) {
        this.rangeYAxis = rangeYAxis;
    }

    public void setyMin(float yMin) {
        this.yMin = yMin;
    }

    public void setyMax(float yMax) {
        this.yMax = yMax;
    }

    public void setPrices(ArrayList<StockPrice> prices) {
        this.prices = prices;
    }
    
    public float getRangeYAxis() {
        return rangeYAxis;
    }

    public float getyMin() {
        return yMin;
    }

    public float getyMax() {
        return yMax;
    }

    public ArrayList<StockPrice> getPrices() {
        return prices;
    }

} // end class def
