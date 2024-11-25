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
    private ArrayList<String> history = null;
    
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
                this.history = (ArrayList<String>)ois.readObject();
            }
            else {
                this.history = new ArrayList<>();
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
        if(this.slanglist == null) {
            return null;
        }
        ArrayList<String> namelist = new ArrayList<>();
        for(HashMap.Entry<String, ArrayList<String>> e: this.slanglist.entrySet()) {
            ArrayList<String> defSet = e.getValue();
            for(int i = 0; i < defSet.size(); i++) {
                if(defSet.get(i).contains(definition)) {
                    namelist.add(e.getKey());
                    break;
                }
            }
        }
        ArrayList<Word> foundlist = new ArrayList<>();
        for(int i = 0; i < namelist.size(); i++) {
            foundlist.addAll(this.findByName(namelist.get(i)));
        }
        return foundlist;
    }
    
    public ArrayList<String> getHistory() {
        return this.history;
    }
    
    boolean addSlangWord(String name, String definition) {
        if(this.slanglist.containsKey(name)) {
            return false;
        }
        else {
            ArrayList<String> deflist = new ArrayList<>();
            deflist.add(definition);
            this.slanglist.put(name, deflist);
            return true;
        }
    }
    
    void overwriteSlangWord(String name, String definition) {
        ArrayList<String> deflist = new ArrayList<>();
        deflist.add(definition);
        this.slanglist.put(name, deflist);
    }
    
    void addDuplicateSlangWord(String name, String definition) {
        this.slanglist.get(name).add(definition);
    }
    
    boolean removeByName(String name) {
        if(this.slanglist.containsKey(name)) {
            this.slanglist.remove(name);
            return true;
        }
        return false;
    }
    
    ArrayList<Word> getRandomSlang() {
        ArrayList<Word> list = null;
        // dem so key trong slang list -> n
        int n = this.slanglist.size();
        int i = (int)Math.floor(Math.random() * n);
        int cnt = 0;
        for(var e: this.slanglist.entrySet()) {
            if(cnt == i) {
                list = new ArrayList<>();
                ArrayList<String> deflist = e.getValue();
                for(int j = 0; j < deflist.size(); j++) {
                    list.add(new Word(e.getKey(), deflist.get(j)));
                }
                return list;
            }
            cnt++;
        }
        return list;
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
