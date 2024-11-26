/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project.sources;

/**
 *
 * @author WINDOWS 10
 */
import java.awt.event.*;
import javax.swing.*;

class UserInterface {
    private JPanel sidebar = null;
    private JPanel mainCnt = null;
    
    void initSidebar() {
        this.sidebar = new JPanel();
        
        // define headings
        JLabel heading1 = new JLabel("TM Dictionary");
        JLabel heading2 = new JLabel("Menu");
        this.sidebar.add(heading1);
        this.sidebar.add(heading2);
        
        // define group 1 - Basic functionalities
        JPanel group1 = new JPanel();
        // history area
        JPanel historyArea = new JPanel();
        JLabel ha1 = new JLabel("Search History");
        JLabel ha2 = new JLabel("Click here to view your search history.");
        historyArea.add(ha1);
        historyArea.add(ha2);
        group1.add(historyArea);
        // add new area
        JPanel addNewArea = new JPanel();
        JLabel an1 = new JLabel("Add new");
        JLabel an2 = new JLabel("Click here to add new slang word.");
        addNewArea.add(an1);
        addNewArea.add(an2);
        group1.add(addNewArea);
        // add slang word of the day area
        JPanel swotdArea = new JPanel();
        JLabel swotd1 = new JLabel("Slang word of the day");
        JLabel swotd2 = new JLabel("Click here to view the slang word of the day!");
        swotdArea.add(swotd1);
        swotdArea.add(swotd2);
        group1.add(swotdArea);
        // add group 1 to sidebar
        this.sidebar.add(group1);
        
        // define group 2 - Guess-the-word Area
        JPanel group2 = new JPanel();
        // guess the slang word area
        JPanel gtswArea = new JPanel();
        JLabel gtsw1 = new JLabel("Guess the slang word");
        JLabel gtsw2 = new JLabel("Try and guess the meaning of the slang word.");
        gtswArea.add(gtsw1);
        gtswArea.add(gtsw2);
        group2.add(gtswArea);
        // guess the definition area
        JPanel gtdArea = new JPanel();
        JLabel gtd1 = new JLabel("Guess the definition");
        JLabel gtd2 = new JLabel("Try and guess the slang word using the definition");
        gtdArea.add(gtd1);    
        gtdArea.add(gtd2);
        group2.add(gtdArea);
        // add group 2 to sidebar
        this.sidebar.add(group2);
        
        // define group 3 - Reset Area
        JPanel group3 = new JPanel();
        // Reset Area
        JPanel resetArea = new JPanel();
        JLabel r1 = new JLabel("Reset slang list");
        JLabel r2 = new JLabel("Restore the slang list to our default ones");
        resetArea.add(r1);
        resetArea.add(r2);
        group3.add(resetArea);
        // add group 3 to sidebar
        this.sidebar.add(group3);
    }
    
    void initMainCnt() {
        this.mainCnt = new JPanel();
        
        // define group 1 - Search area
        JPanel group1 = new JPanel();
        JLabel heading = new JLabel("TM Slang Words Dictionary");
        JTextField searchBar = new JTextField("Type here to search for Slang words!");
        JButton nameSearch = new JButton("Search by name");
        JButton defSearch = new JButton("Search by definition");
        group1.add(heading);
        group1.add(searchBar);
        group1.add(nameSearch);
        group1.add(defSearch);
        this.mainCnt.add(group1);
        
        // define group 2 - Search result
        JPanel group2 = new JPanel();
        this.mainCnt.add(group2);
        
        
    }
    
    void display() {
        // initialize components
        this.initSidebar();
        this.initMainCnt();
        
        // create frame
        JFrame f = new JFrame("TM Dictionary");
        
        // add jpanels to frame
        f.add(this.sidebar);
        f.add(this.mainCnt);
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setVisible(true);
    }
}

public class Project1 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        UserInterface UI = new UserInterface();
        UI.display();
    }
}
