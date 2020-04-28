// MainFrame.java

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
    
    protected Container container;
    protected JPanel mainPanel;
    
    // drop down menus for the time menu, index, instrument, and the price to watch
    protected JComboBox<String> time = new JComboBox<>(new String[] {"6 Months", "1 Year", "2 Years", "5 Years"});
    protected JComboBox<String> instruments = new JComboBox<>(new String[] {"Piano", "Xylophone", "Harmonica", "Guitar", "Violin", "Flute"});
    protected JComboBox<String> priceToWatch = new JComboBox<>(new String[] {"Open Price", "Close Price", "High Price", "Low Price"});
    
    // text and labels on the page
    protected JLabel whatIndex, selectInstrument, selectTime, whichPrice;

    // radio buttons for the stock market index
    protected JRadioButton NYSE, NASDAQ, DJIA;
    protected ButtonGroup indexGroup;
    protected JButton playButton;
    protected JLabel pageTitle;
    
    public MainFrame() {
        super();
        
        container = this.getContentPane();
        mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        mainPanel.setLayout(new GridLayout(12,0));
        whatIndex = new JLabel("Select the preferred Stock Index:");
        selectInstrument = new JLabel("Select the intrument that you like:");
        selectTime = new JLabel("Select the time:");
        whichPrice = new JLabel("Select the price category:");
        pageTitle = new JLabel("STOCK MARKET DATA SONIFICATION", SwingConstants.CENTER);

        NYSE = new JRadioButton("NYSE");
        NASDAQ = new JRadioButton("NASDAQ");
        DJIA = new JRadioButton("DJIA");
        indexGroup = new ButtonGroup(); 
        playButton = new JButton("Play");
        
        // this.setLayout(new GridLayout(12,0));
        addComponents();
        this.setSize(800, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end constructor
    
    
    public void addComponents() {
        Font font = new Font("Verdana", Font.BOLD, 20);
        pageTitle.setFont(font);
        mainPanel.add(pageTitle);
        mainPanel.add(whatIndex);
        // grouping the index buttons together
        indexGroup.add(this.NYSE);
        indexGroup.add(this.NASDAQ);
        indexGroup.add(this.DJIA);
        // adding index buttons to the separate menu frame first
        mainPanel.add(this.NYSE, JFrame.CENTER_ALIGNMENT); 
        mainPanel.add(this.NASDAQ, JFrame.CENTER_ALIGNMENT);
        mainPanel.add(this.DJIA, JFrame.CENTER_ALIGNMENT);
        // adding the time dropdown to the page
        mainPanel.add(this.selectTime, JFrame.CENTER_ALIGNMENT);
        mainPanel.add(time, JPanel.CENTER_ALIGNMENT);
        // adding the instrument dropdown to the page
        mainPanel.add(this.selectInstrument, JFrame.CENTER_ALIGNMENT);
        mainPanel.add(instruments, JFrame.CENTER_ALIGNMENT);
        // adding the price drop down menu
        mainPanel.add(whichPrice, JFrame.CENTER_ALIGNMENT);
        mainPanel.add(priceToWatch, JFrame.CENTER_ALIGNMENT);
        mainPanel.add(playButton);
        container.add(mainPanel);
    } // end addComponents

    
} // end class def
