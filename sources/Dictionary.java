/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.sources;
import java.util.*;
import java.io.*;
/**
 *
 * @author WINDOWS 10
 */
public class Dictionary {
    private HashMap<String, ArrayList<String>> slanglist = null;
    private HashMap<String, ArrayList<String>> history = null;
    
    Dictionary() {
        try {
            File f1 = new File("../data/slanglist.bin");
            File f2 = new File("../data/history.bin");
            ObjectInputStream ois;
            ObjectOutputStream oos;
            BufferedReader br;
            if(f1.exists()) {
                ois = new ObjectInputStream(new FileInputStream(f1));
                this.slanglist = (HashMap<String, ArrayList<String>>)ois.readObject();
                ois.close();
            }
            else {
                br = new BufferedReader(new FileReader("../data/slang.txt"));
                String line;
                String name;
                ArrayList<String> defs;
                while((line = br.readLine()) != null) {
                    String[] substrs = line.split("[`|]");
                    name = substrs[0];
                    defs = (ArrayList<String>)Arrays.asList(Arrays.copyOfRange(substrs, 1, substrs.length));
                    this.slanglist.put(name, defs);
                }
                oos = new ObjectOutputStream(new FileOutputStream(f1));
                oos.writeObject(this.slanglist);
                oos.flush();
                oos.close();
            }
            
            if(f2.exists()) {
                ois = new ObjectInputStream(new FileInputStream(f2));
                this.history = (HashMap<String, ArrayList<String>>)ois.readObject();
            }
            else {
                this.history = new HashMap<String, ArrayList<String>>();
            }
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public ArrayList<Word> findByName(String name) {
        if(this.slanglist == null) {
            return null;
        }
        ArrayList<String> deflist = this.slanglist.get(name);
        if(deflist == null) {
            return null; // the slang is not found
        }
        ArrayList<Word> foundlist = new ArrayList<>();
        for(int i = 0; i < deflist.size(); i++) {
            foundlist.add(new Word(name, deflist.get(i)));
        }
        return foundlist;
    }
    
    public ArrayList<Word> findByDefinition(String definition) {
        ArrayList<Word> foundlist = new ArrayList<Word>();
        return foundlist;
    }
    
    public ArrayList<Word> getHistory() {
        ArrayList<Word> historyList = new ArrayList<Word>();
        return historyList;
    }
    
    boolean addSlangWord(String name, String definition) {
        return true;
    }
    
    void overwriteSlangWord(String name, String definition) {
        
    }
    
    void addDuplicateSlangWord(String name, String definition) {
        
    }
    
    boolean removeByName(String name) {
        return true;
    }
    
    Word getRandomSlang() {
        Word w = new Word("", "");
        return w;
    }
    
    boolean resetDictionary(String filename) {
        return true;
    }
    
    boolean saveProgress(String filename) {
        return true;
    }
    
    boolean addSlangWord(Word w) {
        return true;
    }
    
    void overwriteSlangWord(Word w) {
        
    }
    
    void addDuplicateSlangWord(Word w) {
        
    }
}
