
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author japneetkaur
 */
@SuppressWarnings("serial")
public class BottomPanel extends JFrame {
    
    Container container;
    
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
    
    public BottomPanel() {
        super();
        container = this.getContentPane();
        whatIndex = new JLabel("Select the preferred Stock Index:");
        selectInstrument = new JLabel("Select the intrument that you like:");
        selectTime = new JLabel("Select the time:");
        whichPrice = new JLabel("Select the price category:");
        
        NYSE = new JRadioButton("NYSE");
        NASDAQ = new JRadioButton("NASDAQ");
        DJIA = new JRadioButton("DJIA");
        indexGroup = new ButtonGroup(); 
        playButton = new JButton("Play");
        
        this.setLayout(new FlowLayout());
        addComponents();
        this.setSize(800, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end constructor
    
    
    public void addComponents() {
        // grouping the index buttons together
        indexGroup.add(this.NYSE);
        indexGroup.add(this.NASDAQ);
        indexGroup.add(this.DJIA);
        // adding index buttons to the separate menu frame first
        this.add(this.NYSE, JFrame.CENTER_ALIGNMENT); 
        this.add(this.NASDAQ, JFrame.CENTER_ALIGNMENT);
        this.add(this.DJIA, JFrame.CENTER_ALIGNMENT);
        // adding the time dropdown to the page
        this.add(this.selectTime, JFrame.CENTER_ALIGNMENT);
        this.add(time, JPanel.CENTER_ALIGNMENT);
        // adding the instrument dropdown to the page
        this.add(this.selectInstrument, JFrame.CENTER_ALIGNMENT);
        this.add(instruments, JFrame.CENTER_ALIGNMENT);
        // adding the price drop down menu
        this.add(whichPrice, JFrame.CENTER_ALIGNMENT);
        this.add(priceToWatch, JFrame.CENTER_ALIGNMENT);
        this.add(playButton);
    } // end addComponents

    
    // access methods
    public JComboBox<String> getTime() {
        return time;
    }

    public JComboBox<String> getInstruments() {
        return instruments;
    }

    public JComboBox<String> getPriceToWatch() {
        return priceToWatch;
    }

    public JLabel getWhatIndex() {
        return whatIndex;
    }

    public JLabel getSelectInstrument() {
        return selectInstrument;
    }

    public JLabel getSelectTime() {
        return selectTime;
    }

    public JLabel getWhichPrice() {
        return whichPrice;
    }

    public JRadioButton getNYSE() {
        return NYSE;
    }

    public JRadioButton getNASDAQ() {
        return NASDAQ;
    }

    public JRadioButton getDJIA() {
        return DJIA;
    }

    public ButtonGroup getIndexGroup() {
        return indexGroup;
    }

    public JButton getPlayButton() {
        return playButton;
    }
    
    
    
} // end class def
