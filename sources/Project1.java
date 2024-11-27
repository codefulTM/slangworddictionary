/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project.sources;

/**
 *
 * @author WINDOWS 10
 */
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

class UserInterface {
    private JPanel sidebar = null;
    private JPanel mainCnt = null;
    
    void initSidebar() {
        // define fonts
        Font h1 = new Font("Arial", Font.BOLD, 42);
        Font h2 = new Font("Arial", Font.BOLD, 30);
        Font h3 = new Font("Arial", Font.BOLD, 20);
        Font p = new Font("Arial", Font.PLAIN, 16);
        
        // define colors
        Color blue = Color.decode("#020122");
        Color orange = Color.decode("#FC9E4F");
        Color transparent = new Color(0, 0, 0, 0);
        
        this.sidebar = new JPanel();
        this.sidebar.setBackground(blue);
        this.sidebar.add(Box.createRigidArea(new Dimension(10, 0)));
        JPanel root = new JPanel();
        root.setLayout(new BoxLayout(root, BoxLayout.Y_AXIS));
        root.setBackground(transparent);
        // define headings
        JLabel heading1 = new JLabel("TM Dictionary");
        heading1.setFont(h2);
        heading1.setForeground(orange);
        JLabel heading2 = new JLabel("Menu");
        heading2.setFont(h2);
        heading2.setForeground(orange);
        root.add(heading1);
        root.add(heading2);
        
        // add rigid area
        root.add(Box.createRigidArea(new Dimension(0, 30)));
        
        // define group 1 - Basic functionalities
        JPanel group1 = new JPanel();
        group1.setLayout(new BoxLayout(group1, BoxLayout.Y_AXIS));
        group1.setBackground(orange);
        group1.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        // history area
        JPanel historyArea = new JPanel();
        historyArea.setLayout(new BoxLayout(historyArea, BoxLayout.Y_AXIS));
        historyArea.setBackground(transparent);
        JLabel ha1 = new JLabel("Search History");
        ha1.setFont(h3);
        ha1.setForeground(Color.BLACK);
        JLabel ha2 = new JLabel("<html>Click here to view your search history.</html>");
        ha2.setFont(p);
        ha2.setForeground(Color.BLACK);
        historyArea.add(ha1);
        historyArea.add(ha2);
        group1.add(historyArea);
        group1.add(Box.createRigidArea(new Dimension(0, 30)));
        // add new area
        JPanel addNewArea = new JPanel();
        addNewArea.setLayout(new BoxLayout(addNewArea, BoxLayout.Y_AXIS));
        addNewArea.setBackground(transparent);
        JLabel an1 = new JLabel("Add new");
        an1.setFont(h3);
        an1.setForeground(Color.BLACK);
        JLabel an2 = new JLabel("<html>Click here to add new slang word.</html>");
        an2.setFont(p);
        an2.setForeground(Color.BLACK);
        addNewArea.add(an1);
        addNewArea.add(an2);
        group1.add(addNewArea);
        group1.add(Box.createRigidArea(new Dimension(0, 30)));
        // add slang word of the day area
        JPanel swotdArea = new JPanel();
        swotdArea.setLayout(new BoxLayout(swotdArea, BoxLayout.Y_AXIS));
        swotdArea.setBackground(transparent);
        JLabel swotd1 = new JLabel("Slang word of the day");
        swotd1.setFont(h3);
        swotd1.setForeground(Color.BLACK);
        JLabel swotd2 = new JLabel("<html>Click here to view the slang word of the day!</html>");
        swotd2.setFont(p);
        swotd2.setForeground(Color.BLACK);
        swotdArea.add(swotd1);
        swotdArea.add(swotd2);
        group1.add(swotdArea);
        // add group 1 to sidebar
        root.add(group1);
        
        // add rigid area
        root.add(Box.createRigidArea(new Dimension(0, 20)));
        
        // define group 2 - Guess-the-word Area
        JPanel group2 = new JPanel();
        group2.setLayout(new BoxLayout(group2, BoxLayout.Y_AXIS));
        group2.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        group2.setBackground(orange);
        // guess the slang word area
        JPanel gtswArea = new JPanel();
        gtswArea.setLayout(new BoxLayout(gtswArea, BoxLayout.Y_AXIS));
        gtswArea.setBackground(transparent);
        JLabel gtsw1 = new JLabel("Guess the slang word");
        gtsw1.setFont(h3);
        gtsw1.setForeground(Color.BLACK);
        JLabel gtsw2 = new JLabel("<html>Try and guess the meaning of the slang word.</html>");
        gtsw2.setFont(p);
        gtsw2.setForeground(Color.BLACK);
        gtswArea.add(gtsw1);
        gtswArea.add(gtsw2);
        group2.add(gtswArea);
        group2.add(Box.createRigidArea(new Dimension(0, 30)));
        // guess the definition area
        JPanel gtdArea = new JPanel();
        gtdArea.setLayout(new BoxLayout(gtdArea, BoxLayout.Y_AXIS));
        gtdArea.setBackground(transparent);
        JLabel gtd1 = new JLabel("Guess the definition");
        gtd1.setFont(h3);
        gtd1.setForeground(Color.BLACK);
        JLabel gtd2 = new JLabel("<html>Try and guess the slang word using the definition</html>");
        gtd2.setFont(p);
        gtd2.setForeground(Color.BLACK);
        gtdArea.add(gtd1);    
        gtdArea.add(gtd2);
        group2.add(gtdArea);
        // add group 2 to sidebar
        root.add(group2);
        
        // add rigid area
        root.add(Box.createRigidArea(new Dimension(0, 20)));
        
        // define group 3 - Reset Area
        JPanel group3 = new JPanel();
        group3.setLayout(new BoxLayout(group3, BoxLayout.Y_AXIS));
        group3.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        group3.setBackground(orange);
        // Reset Area
        JPanel resetArea = new JPanel();
        resetArea.setLayout(new BoxLayout(resetArea, BoxLayout.Y_AXIS));
        resetArea.setBackground(transparent);
        JLabel r1 = new JLabel("Reset slang list");
        r1.setFont(h3);
        r1.setForeground(Color.BLACK);
        JLabel r2 = new JLabel("<html>Restore the slang list to our default ones</html>");
        r2.setFont(p);
        r2.setForeground(Color.BLACK);
        resetArea.add(r1);
        resetArea.add(r2);
        group3.add(resetArea);
        group3.add(Box.createRigidArea(new Dimension(0, 2)));
        // add group 3 to sidebar
        root.add(group3);
        
        this.sidebar.add(root);
        this.sidebar.add(Box.createRigidArea(new Dimension(10, 0)));
    }
    
    void initMainCnt() {
        // define fonts
        Font h1 = new Font("Arial", Font.BOLD, 42);
        Font h2 = new Font("Arial", Font.BOLD, 30);
        Font h3 = new Font("Arial", Font.BOLD, 20);
        Font p = new Font("Arial", Font.PLAIN, 16);
        
        // define colors
        Color blue = Color.decode("#020122");
        Color orange = Color.decode("#FC9E4F");
        Color transparent = new Color(0, 0, 0, 0);
        
        this.mainCnt = new JPanel();
        this.mainCnt.setBackground(Color.WHITE);
        this.mainCnt.setLayout(new GridBagLayout());
        this.mainCnt.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        gbc.weightx = 1;
        gbc.weighty = 0.2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        // define group 1 - Search area
        JPanel group1 = new JPanel();
        group1.setLayout(new BoxLayout(group1, BoxLayout.Y_AXIS));
        group1.setBackground(transparent);
        JLabel heading = new JLabel("TM Slang Words Dictionary");
        heading.setFont(h1);
        JTextField searchBar = new JTextField();
        searchBar.setPreferredSize(new Dimension(-1, 30));
        JPanel buttonGroup = new JPanel();
        buttonGroup.setLayout(new FlowLayout());
        JButton nameSearch = new JButton("Search by name");
        nameSearch.setBackground(orange);
        Border padding = BorderFactory.createEmptyBorder(5, 10, 5, 10);
        Border outline = BorderFactory.createLineBorder(Color.BLACK);
        Border b = BorderFactory.createCompoundBorder(outline, padding);
        nameSearch.setBorder(b);
        nameSearch.setSize(30,15);
        nameSearch.setFont(h3);
        JButton defSearch = new JButton("Search by definition");
        defSearch.setBackground(orange);
        defSearch.setBorder(b);
        defSearch.setSize(30,15);
        defSearch.setFont(h3);
        buttonGroup.add(nameSearch);
        buttonGroup.add(defSearch);
        buttonGroup.setBackground(transparent);
        group1.add(heading);
        group1.add(searchBar);
        group1.add(buttonGroup);
        this.mainCnt.add(group1, gbc);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 8;
        gbc.weightx = 1;
        gbc.weighty = 0.8;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        JPanel group2 = new JPanel();
        group2.setLayout(new FlowLayout(FlowLayout.LEFT));
        group2.setBackground(transparent);
        this.mainCnt.add(group2, gbc);
    }
    
    void display() {
        // initialize components
        this.initSidebar();
        this.initMainCnt();
        
        // create frame
        JFrame f = new JFrame("TM Dictionary");
        Container pane = f.getContentPane();
        pane.setLayout(new BorderLayout());
        
        
        // add jpanels to frame
        pane.add(this.sidebar, BorderLayout.WEST);
        pane.add(this.mainCnt, BorderLayout.CENTER);
        
        f.setSize(800, 400);
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
