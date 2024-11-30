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
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;

class MyMouseListener implements MouseListener {

    private JComponent component = null;

    MyMouseListener(JComponent component) {
        this.component = component;
    }

    public void mouseEntered(MouseEvent e) {
        component.setBackground(Color.decode("#FFBE88"));
    }

    public void mouseExited(MouseEvent e) {
        component.setBackground(Color.decode("#FC9E4F"));
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {

    }
}

class UserInterface {
    private JPanel sidebar = null;
    private JPanel mainCnt = null;
    private JFrame frame = null;
    private HashMap<String, JPanel> cards = null;

    JPanel createWordCards(Word w) {
        Font h2 = new Font("Arial", Font.BOLD, 30);
        Font h3 = new Font("Arial", Font.BOLD, 20);

        JPanel card = new JPanel();
        card.setPreferredSize(new Dimension(100, 200));
        card.setBackground(Color.decode("#E1F0C4"));
        card.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        card.setLayout(new BorderLayout());
        JLabel heading = new JLabel(w.getName());
        heading.setFont(h2);
        card.add(heading, BorderLayout.NORTH);
        JLabel desc = new JLabel(w.getDefinition());
        desc.setFont(h3);
        card.add(desc, BorderLayout.CENTER);

        return card;
    }

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
        // search area
        JPanel searchArea = new JPanel();
        searchArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CardLayout l = (CardLayout) mainCnt.getLayout();
                l.show(mainCnt, "searchCard");
            }
        });
        searchArea.addMouseListener(new MyMouseListener(searchArea));
        searchArea.setLayout(new BoxLayout(searchArea, BoxLayout.Y_AXIS));
        searchArea.setBackground(transparent);
        JLabel s1 = new JLabel("Search");
        s1.setFont(h3);
        s1.setForeground(Color.BLACK);
        JLabel s2 = new JLabel("<html>Click here to search.</html>");
        s2.setFont(p);
        s2.setForeground(Color.BLACK);
        searchArea.add(s1);
        searchArea.add(s2);
        group1.add(searchArea);
        group1.add(Box.createRigidArea(new Dimension(0, 30)));
        // history area
        JPanel historyArea = new JPanel();
        historyArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CardLayout l = (CardLayout) mainCnt.getLayout();
                l.show(mainCnt, "historyCard");
            }
        });
        historyArea.addMouseListener(new MyMouseListener(historyArea));
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
        addNewArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CardLayout l = (CardLayout) mainCnt.getLayout();
                l.show(mainCnt, "addNewCard");
            }
        });
        addNewArea.addMouseListener(new MyMouseListener(addNewArea));
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
        swotdArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CardLayout l = (CardLayout) mainCnt.getLayout();
                l.show(mainCnt, "dailySlangCard");
            }
        });
        swotdArea.addMouseListener(new MyMouseListener(swotdArea));
        swotdArea.setLayout(new BoxLayout(swotdArea, BoxLayout.Y_AXIS));
        swotdArea.setBackground(transparent);
        JLabel swotd1 = new JLabel("Slang words of the day");
        swotd1.setFont(h3);
        swotd1.setForeground(Color.BLACK);
        JLabel swotd2 = new JLabel("<html>Click here to view the slang words of today!</html>");
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
        gtswArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CardLayout l = (CardLayout) mainCnt.getLayout();
                l.show(mainCnt, "guessSlangCard");
            }
        });
        gtswArea.addMouseListener(new MyMouseListener(gtswArea));
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
        gtdArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CardLayout l = (CardLayout) mainCnt.getLayout();
                l.show(mainCnt, "guessDefCard");
            }
        });
        gtdArea.addMouseListener(new MyMouseListener(gtdArea));
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
        resetArea.addMouseListener(new MyMouseListener(resetArea));
        resetArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Dictionary.resetDictionary();
                JOptionPane.showMessageDialog(frame, "Reset successfully", "Notification", JOptionPane.INFORMATION_MESSAGE);
                resetHistoryCard();
            }
        });
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

    JPanel generateSearchCard() {
        Font h1 = new Font("Arial", Font.BOLD, 42);
        Font h2 = new Font("Arial", Font.BOLD, 30);
        Font h3 = new Font("Arial", Font.BOLD, 20);
        Font p = new Font("Arial", Font.PLAIN, 16);

        // define colors
        Color blue = Color.decode("#020122");
        Color orange = Color.decode("#FC9E4F");
        Color transparent = new Color(0, 0, 0, 0);

        JPanel searchCard = new JPanel();
        searchCard.setBackground(Color.WHITE);
        searchCard.setLayout(new GridBagLayout());
        searchCard.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        // define group 1 - Headings
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JPanel group1 = new JPanel();
        group1.setLayout(new BoxLayout(group1, BoxLayout.Y_AXIS));
        group1.setBackground(transparent);
        JLabel heading1 = new JLabel("TM Slang Words Dictionary");
        heading1.setFont(h1);
        group1.add(heading1);
        JLabel heading2 = new JLabel("Search");
        heading2.setFont(h2);
        group1.add(heading2);
        searchCard.add(group1, gbc);

        // define group 2 - Search area
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.1;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JPanel group2 = new JPanel();
        group2.setLayout(new BoxLayout(group2, BoxLayout.Y_AXIS));
        JTextField searchBar = new JTextField();
        searchBar.setPreferredSize(new Dimension(400, 30));
        JPanel buttonGroup = new JPanel();
        buttonGroup.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton nameSearch = new JButton("Search by name");
        nameSearch.addMouseListener(new MyMouseListener(nameSearch));
        nameSearch.setBackground(orange);
        Border padding = BorderFactory.createEmptyBorder(5, 10, 5, 10);
        Border outline = BorderFactory.createLineBorder(Color.BLACK);
        Border b = BorderFactory.createCompoundBorder(outline, padding);
        nameSearch.setBorder(b);
        nameSearch.setSize(30, 15);
        nameSearch.setFont(h3);
        JButton defSearch = new JButton("Search by definition");
        defSearch.addMouseListener(new MyMouseListener(defSearch));
        defSearch.setBackground(orange);
        defSearch.setBorder(b);
        defSearch.setSize(30, 15);
        defSearch.setFont(h3);
        JButton clearSearch = new JButton("Clear search");
        clearSearch.addMouseListener(new MyMouseListener(clearSearch));
        clearSearch.setBackground(orange);
        clearSearch.setBorder(b);
        clearSearch.setSize(30, 15);
        clearSearch.setFont(h3);
        buttonGroup.add(nameSearch);
        buttonGroup.add(defSearch);
        buttonGroup.add(clearSearch);
        buttonGroup.setBackground(transparent);
        group2.add(searchBar);
        group2.add(buttonGroup);
        group2.setBackground(Color.WHITE);
        searchCard.add(group2, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.8;
        gbc.anchor = GridBagConstraints.NORTHEAST;
        gbc.fill = GridBagConstraints.BOTH;
        // group 3 - search results
        JPanel group3 = new JPanel();
        group3.setLayout(new BoxLayout(group3, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(group3);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        searchCard.add(scrollPane, gbc);
        
        // add search actions
        nameSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                group3.removeAll();
                String txt = searchBar.getText();
                ArrayList<Word> res = Dictionary.findByName(txt);
                resetHistoryCard();
                if (res == null) {
                    JOptionPane.showMessageDialog(frame, "Can't find the word you're searching for", "Notification", 0);
                    return;
                }
                for (Word w : res) {
                    JPanel components = new JPanel();
                    components.setLayout(new BoxLayout(components, BoxLayout.Y_AXIS));

                    // define word area
                    JPanel wordArea = new JPanel();
                    wordArea.setLayout(new BoxLayout(wordArea, BoxLayout.X_AXIS));
                    wordArea.setBackground(Color.decode("#E1F0C4"));
                    wordArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                    JLabel word = new JLabel(w.getName());
                    word.setForeground(Color.BLACK);
                    word.setFont(h3);
                    JLabel def = new JLabel(w.getDefinition());
                    def.setForeground(Color.BLACK);
                    def.setFont(p);
                    wordArea.add(word);
                    wordArea.add(Box.createHorizontalGlue());
                    wordArea.add(def);
                    wordArea.add(Box.createHorizontalGlue());
                    components.add(wordArea);

                    // define button area
                    JPanel bttnArea = new JPanel();
                    JButton editBttn = new JButton("Edit");
                    editBttn.setFont(p);
                    editBttn.setBackground(orange);
                    editBttn.setForeground(Color.BLACK);
                    editBttn.addMouseListener(new MyMouseListener(editBttn));
                    editBttn.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Word oldW = new Word(word.getText(), def.getText());
                            JDialog dialog = new JDialog(frame, "Edit word");
                            dialog.setLayout(new GridLayout(3, 2, 10, 10));
                            dialog.setTitle("Edit the word information");
                            JLabel nameLabel = new JLabel("Name: ");
                            nameLabel.setFont(p);
                            nameLabel.setForeground(Color.BLACK);
                            dialog.add(nameLabel);
                            JTextField nameField = new JTextField(oldW.getName());
                            nameField.setPreferredSize(new Dimension(100, 30));
                            nameField.setFont(p);
                            nameField.setForeground(Color.BLACK);
                            dialog.add(nameField);

                            JLabel defLabel = new JLabel("Definition: ");
                            defLabel.setFont(p);
                            defLabel.setForeground(Color.BLACK);
                            dialog.add(defLabel);
                            JTextField defField = new JTextField(oldW.getDefinition());
                            defField.setPreferredSize(new Dimension(100, 30));
                            defField.setFont(p);
                            defField.setForeground(Color.BLACK);
                            dialog.add(defField);

                            JButton bttn1 = new JButton("Save");
                            bttn1.setBackground(orange);
                            bttn1.setFont(p);
                            bttn1.setForeground(Color.BLACK);
                            bttn1.addMouseListener(new MyMouseListener(bttn1));
                            bttn1.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    Word newW = new Word(nameField.getText(), defField.getText());
                                    Dictionary.editSlangWord(oldW, newW);
                                    JOptionPane.showMessageDialog(frame, "Editted successfully", "Notification", JOptionPane.INFORMATION_MESSAGE);
                                    group3.remove(components);
                                    group3.revalidate();
                                    group3.repaint();
                                }
                            });
                            dialog.add(bttn1);

                            JButton bttn2 = new JButton("Cancel");
                            bttn2.setBackground(orange);
                            bttn2.setFont(p);
                            bttn2.setForeground(Color.BLACK);
                            bttn2.addMouseListener(new MyMouseListener(bttn2));
                            bttn2.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    dialog.dispose();
                                }
                            });
                            dialog.add(bttn2);
                            dialog.pack();
                            dialog.setLocationRelativeTo(frame);
                            dialog.setVisible(true);
                        }
                    });

                    JButton removeBttn = new JButton("Remove");
                    removeBttn.setFont(p);
                    removeBttn.setBackground(orange);
                    removeBttn.setForeground(Color.BLACK);
                    removeBttn.addMouseListener(new MyMouseListener(editBttn));
                    removeBttn.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int opt = JOptionPane.showConfirmDialog(frame, "Are you sure you want to remove this word?", "Notification", JOptionPane.YES_NO_OPTION);
                            if (opt == JOptionPane.YES_OPTION) {
                                Dictionary.removeByName(word.getText());
                                JOptionPane.showMessageDialog(frame, "Removed successfully", "Notification", JOptionPane.INFORMATION_MESSAGE);
                                group3.remove(components);
                                group3.revalidate();
                                group3.repaint();
                            }
                        }
                    });
                    bttnArea.add(editBttn);
                    bttnArea.add(removeBttn);
                    components.add(bttnArea);
                    group3.add(components);
                    group3.revalidate();
                    group3.repaint();
                }
            }
        });
        defSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                group3.removeAll();
                String txt = searchBar.getText();
                ArrayList<Word> res = Dictionary.findByDefinition(txt);
                resetHistoryCard();
                if (res == null) {
                    JOptionPane.showMessageDialog(frame, "Can't find the word you're searching for", "Notification", 0);
                    return;
                }
                for (Word w : res) {
                    JPanel components = new JPanel();
                    components.setLayout(new BoxLayout(components, BoxLayout.Y_AXIS));

                    // define word area
                    JPanel wordArea = new JPanel();
                    wordArea.setLayout(new BoxLayout(wordArea, BoxLayout.X_AXIS));
                    wordArea.setBackground(Color.decode("#E1F0C4"));
                    wordArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                    JLabel word = new JLabel(w.getName());
                    word.setForeground(Color.BLACK);
                    word.setFont(h3);
                    JLabel def = new JLabel(w.getDefinition());
                    def.setForeground(Color.BLACK);
                    def.setFont(p);
                    wordArea.add(word);
                    wordArea.add(Box.createHorizontalGlue());
                    wordArea.add(def);
                    wordArea.add(Box.createHorizontalGlue());
                    components.add(wordArea);

                    // define button area
                    JPanel bttnArea = new JPanel();
                    JButton editBttn = new JButton("Edit");
                    editBttn.setFont(p);
                    editBttn.setBackground(orange);
                    editBttn.setForeground(Color.BLACK);
                    editBttn.addMouseListener(new MyMouseListener(editBttn));
                    editBttn.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Word oldW = new Word(word.getText(), def.getText());
                            JDialog dialog = new JDialog(frame, "Edit word");
                            dialog.setLayout(new GridLayout(3, 2, 10, 10));
                            dialog.setTitle("Edit the word information");
                            JLabel nameLabel = new JLabel("Name: ");
                            nameLabel.setFont(p);
                            nameLabel.setForeground(Color.BLACK);
                            dialog.add(nameLabel);
                            JTextField nameField = new JTextField(oldW.getName());
                            nameField.setPreferredSize(new Dimension(100, 30));
                            nameField.setFont(p);
                            nameField.setForeground(Color.BLACK);
                            dialog.add(nameField);

                            JLabel defLabel = new JLabel("Definition: ");
                            defLabel.setFont(p);
                            defLabel.setForeground(Color.BLACK);
                            dialog.add(defLabel);
                            JTextField defField = new JTextField(oldW.getDefinition());
                            defField.setPreferredSize(new Dimension(100, 30));
                            defField.setFont(p);
                            defField.setForeground(Color.BLACK);
                            dialog.add(defField);

                            JButton bttn1 = new JButton("Save");
                            bttn1.setBackground(orange);
                            bttn1.setFont(p);
                            bttn1.setForeground(Color.BLACK);
                            bttn1.addMouseListener(new MyMouseListener(bttn1));
                            bttn1.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    Word newW = new Word(nameField.getText(), defField.getText());
                                    Dictionary.editSlangWord(oldW, newW);
                                    JOptionPane.showMessageDialog(frame, "Editted successfully", "Notification", JOptionPane.INFORMATION_MESSAGE);
                                    group3.remove(components);
                                    group3.revalidate();
                                    group3.repaint();
                                }
                            });
                            dialog.add(bttn1);

                            JButton bttn2 = new JButton("Cancel");
                            bttn2.setBackground(orange);
                            bttn2.setFont(p);
                            bttn2.setForeground(Color.BLACK);
                            bttn2.addMouseListener(new MyMouseListener(bttn2));
                            bttn2.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    dialog.dispose();
                                }
                            });
                            dialog.add(bttn2);
                            dialog.pack();
                            dialog.setLocationRelativeTo(frame);
                            dialog.setVisible(true);
                        }
                    });

                    JButton removeBttn = new JButton("Remove");
                    removeBttn.setFont(p);
                    removeBttn.setBackground(orange);
                    removeBttn.setForeground(Color.BLACK);
                    removeBttn.addMouseListener(new MyMouseListener(editBttn));
                    removeBttn.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int opt = JOptionPane.showConfirmDialog(frame, "Are you sure you want to remove this word?", "Notification", JOptionPane.YES_NO_OPTION);
                            if (opt == JOptionPane.YES_OPTION) {
                                Dictionary.removeByName(word.getText());
                                JOptionPane.showMessageDialog(frame, "Removed successfully", "Notification", JOptionPane.INFORMATION_MESSAGE);
                                group3.remove(components);
                                group3.revalidate();
                                group3.repaint();
                            }
                        }
                    });
                    bttnArea.add(editBttn);
                    bttnArea.add(removeBttn);
                    components.add(bttnArea);
                    group3.add(components);
                    group3.revalidate();
                    group3.repaint();
                }
            }
        });
        clearSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                group3.removeAll();
                group3.revalidate();
                group3.repaint();
                searchBar.setText("");
            }
        });

        return searchCard;
    }

    void resetHistoryCard() {
        this.mainCnt.remove(cards.get("historyCard"));
        this.cards.put("historyCard", this.generateHistoryCard());
        this.mainCnt.add(cards.get("historyCard"), "historyCard");
        this.mainCnt.revalidate();
        this.mainCnt.repaint();
    }

    JPanel generateHistoryCard() {
        Font h1 = new Font("Arial", Font.BOLD, 42);
        Font h2 = new Font("Arial", Font.BOLD, 30);
        Font h3 = new Font("Arial", Font.BOLD, 20);
        Font p = new Font("Arial", Font.PLAIN, 16);

        // define colors
        Color blue = Color.decode("#020122");
        Color orange = Color.decode("#FC9E4F");
        Color transparent = new Color(0, 0, 0, 0);

        JPanel historyCard = new JPanel();
        historyCard.setBackground(Color.WHITE);
        historyCard.setLayout(new GridBagLayout());
        historyCard.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        // define group 1 - Headings
        JPanel group1 = new JPanel();
        group1.setLayout(new BoxLayout(group1, BoxLayout.Y_AXIS));
        group1.setBackground(transparent);
        JLabel heading1 = new JLabel("TM Slang Words Dictionary");
        heading1.setFont(h1);
        JLabel heading2 = new JLabel("History");
        heading2.setFont(h2);
        group1.add(heading1);
        group1.add(heading2);
        historyCard.add(group1, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.9;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTHEAST;
        // define group 2 - History
        JPanel group2 = new JPanel();
        group2.setLayout(new BoxLayout(group2, BoxLayout.Y_AXIS));
        group2.setBackground(transparent);
        JScrollPane scrollPane = new JScrollPane(group2);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        for (String s : Dictionary.history) {
            JPanel card = new JPanel();
            card.setLayout(new BoxLayout(card, BoxLayout.X_AXIS));
            JLabel word = new JLabel(s);
            word.setBackground(transparent);
            word.setForeground(Color.BLACK);
            card.add(Box.createHorizontalGlue());
            card.add(word);
            card.add(Box.createHorizontalGlue());
            card.setBackground(Color.decode("#E1F0C4"));
            card.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
            group2.add(card);
        }
        group2.add(Box.createVerticalGlue());
        historyCard.add(scrollPane, gbc);

        return historyCard;
    }

    JPanel generateAddNewCard() {
        Font h1 = new Font("Arial", Font.BOLD, 42);
        Font h2 = new Font("Arial", Font.BOLD, 30);
        Font h3 = new Font("Arial", Font.BOLD, 20);
        Font p = new Font("Arial", Font.PLAIN, 16);

        // define colors
        Color blue = Color.decode("#020122");
        Color orange = Color.decode("#FC9E4F");
        Color transparent = new Color(0, 0, 0, 0);

        JPanel addNewCard = new JPanel();
        addNewCard.setBackground(Color.WHITE);
        addNewCard.setLayout(new GridBagLayout());
        addNewCard.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        // define group 1 - Headings
        JPanel group1 = new JPanel();
        group1.setLayout(new BoxLayout(group1, BoxLayout.Y_AXIS));
        group1.setBackground(transparent);
        JLabel heading1 = new JLabel("TM Slang Words Dictionary");
        heading1.setFont(h1);
        JLabel heading2 = new JLabel("Add new slang word");
        heading2.setFont(h2);
        group1.add(heading1);
        group1.add(heading2);
        addNewCard.add(group1, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.9;
        gbc.anchor = GridBagConstraints.NORTHEAST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        // define group 2 - Add new form
        JPanel group2 = new JPanel();
        group2.setLayout(new BoxLayout(group2, BoxLayout.Y_AXIS));
        group2.setBackground(transparent);

        JPanel group2_nameField = new JPanel();
        group2_nameField.setLayout(new FlowLayout());
        group2_nameField.setBackground(Color.WHITE);
        JLabel name = new JLabel("Enter name: ");
        name.setFont(p);
        JTextField nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(300, 30));
        group2_nameField.add(name);
        group2_nameField.add(nameField);
        group2.add(group2_nameField);

        JPanel group2_defField = new JPanel();
        group2_defField.setLayout(new FlowLayout());
        group2_defField.setBackground(Color.WHITE);
        JLabel definition = new JLabel("Enter definition: ");
        definition.setFont(p);
        JTextField defField = new JTextField();
        defField.setPreferredSize(new Dimension(300, 30));
        group2_defField.add(definition);
        group2_defField.add(defField);
        group2.add(group2_defField);

        JButton addBtn = new JButton("Add slang");
        addBtn.setFont(p);
        addBtn.setPreferredSize(new Dimension(50, 30));
        addBtn.setBackground(orange);
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String def = defField.getText();
                if (name.equals("") || def.equals("")) {
                    JOptionPane.showMessageDialog(frame, "Missing slang name or definition!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    boolean addRes = Dictionary.addSlangWord(name, def);
                    if (!addRes) {
                        // overwrite or add duplicate
                        int res = JOptionPane.showConfirmDialog(frame, "Choose YES to overwrite, or NO to duplicate the slang.", "Notification", 0, JOptionPane.YES_NO_OPTION);
                        if (res == JOptionPane.YES_OPTION) {
                            Dictionary.overwriteSlangWord(name, def);
                        } else {
                            Dictionary.addDuplicateSlangWord(name, def);
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "Added successfully!", "Notification", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
        group2.add(addBtn);

        addNewCard.add(group2, gbc);
        return addNewCard;
    }

    JPanel generateDailySlangWords() {
        Font h1 = new Font("Arial", Font.BOLD, 42);
        Font h2 = new Font("Arial", Font.BOLD, 30);
        Font h3 = new Font("Arial", Font.BOLD, 20);
        Font p = new Font("Arial", Font.PLAIN, 16);

        // define colors
        Color blue = Color.decode("#020122");
        Color orange = Color.decode("#FC9E4F");
        Color transparent = new Color(0, 0, 0, 0);

        JPanel dailySlangsCard = new JPanel();
        dailySlangsCard.setBackground(Color.WHITE);
        dailySlangsCard.setLayout(new GridBagLayout());
        dailySlangsCard.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        // define group 1 - Headings
        JPanel group1 = new JPanel();
        group1.setLayout(new BoxLayout(group1, BoxLayout.Y_AXIS));
        group1.setBackground(transparent);
        JLabel heading1 = new JLabel("TM Slang Words Dictionary");
        heading1.setFont(h1);
        JLabel heading2 = new JLabel("Daily Slang Card");
        heading2.setFont(h2);
        group1.add(heading1);
        group1.add(heading2);
        dailySlangsCard.add(group1, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.9;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        // define group 2 - daily slang
        JPanel group2 = new JPanel();
        group2.setLayout(new BoxLayout(group2, BoxLayout.Y_AXIS));
        group2.setPreferredSize(new Dimension(300, 100));
        group2.setBackground(Color.decode("#E1F0C4"));
        group2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        ArrayList<Word> dailySlang = Dictionary.getDailySlang();
        // get daily slang word
        JLabel word = new JLabel(dailySlang.get(0).getName());
        word.setForeground(Color.BLACK);
        word.setFont(h3);
        word.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel def = new JLabel(dailySlang.get(0).getDefinition());
        def.setForeground(Color.BLACK);
        def.setFont(p);
        def.setAlignmentX(Component.CENTER_ALIGNMENT);
        group2.add(word);
        group2.add(def);
        dailySlangsCard.add(group2, gbc);

        return dailySlangsCard;
    }

    JPanel generateGuessDefinition() {
        Font h1 = new Font("Arial", Font.BOLD, 42);
        Font h2 = new Font("Arial", Font.BOLD, 30);
        Font h3 = new Font("Arial", Font.BOLD, 20);
        Font p = new Font("Arial", Font.PLAIN, 16);

        // define colors
        Color blue = Color.decode("#020122");
        Color orange = Color.decode("#FC9E4F");
        Color transparent = new Color(0, 0, 0, 0);

        JPanel guessDefCard = new JPanel();
        guessDefCard.setBackground(Color.WHITE);
        guessDefCard.setLayout(new GridBagLayout());
        guessDefCard.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        // define group 1 - Headings
        JPanel group1 = new JPanel();
        group1.setLayout(new BoxLayout(group1, BoxLayout.Y_AXIS));
        group1.setBackground(transparent);
        JLabel heading1 = new JLabel("TM Slang Words Dictionary");
        heading1.setFont(h1);
        JLabel heading2 = new JLabel("Guess the definition");
        heading2.setFont(h2);
        group1.add(heading1);
        group1.add(heading2);
        guessDefCard.add(group1, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.9;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        // define group 2 - Guess area
        JPanel group2 = new JPanel();
        group2.setLayout(new BoxLayout(group2, BoxLayout.Y_AXIS));
        group2.setBackground(Color.decode("#E1F0C4"));
        group2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        // get list of words
        ArrayList<Word> list = Dictionary.getCollectionOfRandSlangs();
        Word ans = list.get((int) Math.floor(Math.random() * list.size()));
        // display list of words
        JLabel def = new JLabel(ans.getDefinition());
        def.setFont(p);
        def.setAlignmentX(Component.CENTER_ALIGNMENT);
        group2.add(def);
        JPanel group2_choices = new JPanel();
        group2_choices.setLayout(new GridLayout(2, 2, 10, 10));
        group2_choices.setBackground(transparent);
        for (Word w : list) {
            JPanel wordCard = new JPanel();
            wordCard.setBackground(orange);
            JLabel wordName = new JLabel(w.getName());
            wordName.setFont(p);
            wordCard.add(wordName);
            wordCard.addMouseListener(new MyMouseListener(wordCard));
            wordCard.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (w.getName().equals(ans.getName())) {
                        JOptionPane.showMessageDialog(frame, "Congrats on choosing the correct answer!", "Notification", 0);
                        resetGuessDefinition();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Sorry, wrong answer :/", "Notification", 0);
                    }
                }
            });
            group2_choices.add(wordCard);
        }
        group2.add(group2_choices);
        guessDefCard.add(group2, gbc);
        return guessDefCard;
    }

    void resetGuessDefinition() {
        this.mainCnt.remove(cards.get("guessDefCard"));
        this.cards.put("guessDefCard", this.generateGuessDefinition());
        this.mainCnt.add(cards.get("guessDefCard"), "guessDefCard");
        CardLayout c = (CardLayout) this.mainCnt.getLayout();
        c.show(this.mainCnt, "guessDefCard");
        this.mainCnt.revalidate();
        this.mainCnt.repaint();
    }

    JPanel generateGuessSlangWords() {
        Font h1 = new Font("Arial", Font.BOLD, 42);
        Font h2 = new Font("Arial", Font.BOLD, 30);
        Font h3 = new Font("Arial", Font.BOLD, 20);
        Font p = new Font("Arial", Font.PLAIN, 16);

        // define colors
        Color blue = Color.decode("#020122");
        Color orange = Color.decode("#FC9E4F");
        Color transparent = new Color(0, 0, 0, 0);

        JPanel guessWordCard = new JPanel();
        guessWordCard.setBackground(Color.WHITE);
        guessWordCard.setLayout(new GridBagLayout());
        guessWordCard.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        // define group 1 - Headings
        JPanel group1 = new JPanel();
        group1.setLayout(new BoxLayout(group1, BoxLayout.Y_AXIS));
        group1.setBackground(transparent);
        JLabel heading1 = new JLabel("TM Slang Words Dictionary");
        heading1.setFont(h1);
        JLabel heading2 = new JLabel("Guess the slang word");
        heading2.setFont(h2);
        group1.add(heading1);
        group1.add(heading2);
        guessWordCard.add(group1, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.9;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        // define group 2 - Guess area
//        gbc.fill = GridBagConstraints.HORIZONTAL;
        JPanel group2 = new JPanel();
        group2.setBackground(Color.decode("#E1F0C4"));
        group2.setLayout(new BoxLayout(group2, BoxLayout.Y_AXIS));
        group2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        // get list of words
        ArrayList<Word> list = Dictionary.getCollectionOfRandSlangs();
        Word ans = list.get((int) Math.floor(Math.random() * list.size()));
        // display list of words
        JLabel word = new JLabel(ans.getName());
        word.setFont(p);
        word.setAlignmentX(Component.CENTER_ALIGNMENT);
        group2.add(word);
        JPanel group2_choices = new JPanel();
        group2_choices.setBackground(transparent);
        group2_choices.setLayout(new GridLayout(2, 2, 10, 10));
        for (Word w : list) {
            JPanel wordCard = new JPanel();
            wordCard.setBackground(orange);
            JLabel wordDef = new JLabel(w.getDefinition());
            wordDef.setFont(p);
            wordCard.add(wordDef);
            wordCard.addMouseListener(new MyMouseListener(wordCard));
            wordCard.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (w.getDefinition().equals(ans.getDefinition())) {
                        JOptionPane.showMessageDialog(frame, "Congrats on choosing the correct answer!", "Notification", 0);
                        resetGuessSlangWords();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Sorry, wrong answer :/", "Notification", 0);
                    }
                }
            });
            group2_choices.add(wordCard);
        }
        group2.add(group2_choices);
        guessWordCard.add(group2, gbc);
        return guessWordCard;
    }

    void resetGuessSlangWords() {
        this.mainCnt.remove(cards.get("guessSlangCard"));
        this.cards.put("guessSlangCard", this.generateGuessDefinition());
        this.mainCnt.add(cards.get("guessSlangCard"), "guessSlangCard");
        CardLayout c = (CardLayout) this.mainCnt.getLayout();
        c.show(this.mainCnt, "guessSlangCard");
        this.mainCnt.revalidate();
        this.mainCnt.repaint();
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

        // container for card layout
        this.mainCnt = new JPanel();
        CardLayout cl = new CardLayout();
        this.mainCnt.setLayout(cl);

        // creating cards
        this.cards = new HashMap<>();
        cards.put("searchCard", this.generateSearchCard());
        cards.put("historyCard", this.generateHistoryCard());
        cards.put("addNewCard", this.generateAddNewCard());
        cards.put("dailySlangCard", this.generateDailySlangWords());
        cards.put("guessSlangCard", this.generateGuessSlangWords());
        cards.put("guessDefCard", this.generateGuessDefinition());

        // adding cards
        this.mainCnt.add(cards.get("searchCard"), "searchCard");
        this.mainCnt.add(cards.get("historyCard"), "historyCard");
        this.mainCnt.add(cards.get("addNewCard"), "addNewCard");
        this.mainCnt.add(cards.get("dailySlangCard"), "dailySlangCard");
        this.mainCnt.add(cards.get("guessSlangCard"), "guessSlangCard");
        this.mainCnt.add(cards.get("guessDefCard"), "guessDefCard");

        cl.show(this.mainCnt, "searchCard");
    }

    void display() {
        SwingUtilities.invokeLater(() -> {
            // initialize components
            this.initSidebar();
            this.initMainCnt();

            // create frame
            this.frame = new JFrame("TM Dictionary");
            Container pane = this.frame.getContentPane();
            pane.setLayout(new BorderLayout());

            // add jpanels to frame
            pane.add(this.sidebar, BorderLayout.WEST);
            pane.add(this.mainCnt, BorderLayout.CENTER);

            this.frame.setSize(800, 400);
            this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            this.frame.setVisible(true);
        });
    }
}

public class Project1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Dictionary.init();
        UserInterface UI = new UserInterface();
        UI.display();
    }
}
