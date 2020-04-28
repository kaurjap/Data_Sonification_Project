
import java.applet.Applet;
import java.awt.Container;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;

// Graph.java
// the Swing part of the GUI is wrapped around SwingUtilities.invokeLater
// the JavaFX setscene part of the GUI is wrapped around platform.runLater

public class Graph extends Applet {
    
    protected float totalDataPoints;
    protected float rangeYAxis; // range of the data on the y-axis
    protected float yMin;
    protected float yMax;
    protected float yInterval;
    protected ArrayList<StockPrice> prices;
    //protected JPanel bottomPanel;
    
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
        //this.bottomPanel = bottomPanel;
        this.setDataSize();
        this.setYInterval();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                init(); // run the init method
            } // end run
        });
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
        
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis("Stock Prices (dollars)", yMin, yMax, yInterval);
        xAxis.setLabel("Time");
        
        LineChart<String, Number> trendline = new LineChart<>(xAxis, yAxis);
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
        
        Scene scene = new Scene(trendline, 800, 600);
        fxPanel.setScene(scene); 
        
        pane.add(fxPanel);
        //pane.add(this.bottomPanel);
        frame.setSize(500, 500);
        frame.setVisible(true);
        
        
//        JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
//        split.setTopComponent(fxPanel);
//        split.setBottomComponent(this.bottomPanel);
//        
//        Platform.runLater(new Runnable() {
//            
//            @Override
//            public void run() {
//                Scene scene = new Scene(trendline, 800, 600);
//                fxPanel.setScene(scene);                    
//            } // end run
//        }); // end platform.runLater
//        
        
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

//    public void setBottomPanel(JPanel bottomPanel) {
//        this.bottomPanel = bottomPanel;
//    }

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

//    public JPanel getBottomPanel() {
//        return bottomPanel;
//    }
    
    
} // end class def
