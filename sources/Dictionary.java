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
    private HashSet<String> history = null;
    
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
                br.close();
                this.saveSlanglist();
            }
            if(f2.exists()) {
                ois = new ObjectInputStream(new FileInputStream(f2));
                this.history = (HashSet<String>)ois.readObject();
            }
            else {
                this.history = new HashSet<>();
                this.saveHistory();
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
        // add to history
        this.history.add(name);
        this.saveHistory();
        // generate word list
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
        for(var e: this.slanglist.entrySet()) {
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
            this.history.add(namelist.get(i));
            foundlist.addAll(this.findByName(namelist.get(i)));
        }
        this.saveHistory();
        return foundlist;
    }
    
    public HashSet<String> getHistory() {
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
            this.saveSlanglist();
            return true;
        }
    }
    
    void overwriteSlangWord(String name, String definition) {
        ArrayList<String> deflist = new ArrayList<>();
        deflist.add(definition);
        this.slanglist.put(name, deflist);
        this.saveSlanglist();
    }
    
    void addDuplicateSlangWord(String name, String definition) {
        this.slanglist.get(name).add(definition);
        this.saveSlanglist();
    }
    
    boolean removeByName(String name) {
        if(this.slanglist.containsKey(name)) {
            this.slanglist.remove(name);
            this.history.remove(name);
            this.saveProgress();
            return true;
        }
        return false;
    }
    
    ArrayList<Word> getRandomSlang() {
        ArrayList<Word> list = null;
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
    
    void resetDictionary() {
        try {
            // regenerate the slang list from slang.txt and write back to the binary file
            BufferedReader br = new BufferedReader(new FileReader("../data/slang.txt"));
            String line;
            String name;
            ArrayList<String> defs;
            while((line = br.readLine()) != null) {
                String[] substrs = line.split("[`|]");
                name = substrs[0];
                defs = (ArrayList<String>)Arrays.asList(Arrays.copyOfRange(substrs, 1, substrs.length));
                this.slanglist.put(name, defs);
            }
            br.close();
            // clear the history 
            this.history = new HashSet<>();
            // save progress
            this.saveProgress();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    void saveHistory() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("../data/history.bin"));
            oos.writeObject(this.history);
            oos.flush();
            oos.close();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    void saveSlanglist() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("../data/slanglist.bin"));
            oos.writeObject(this.slanglist);
            oos.flush();
            oos.close();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    void saveProgress() {
        saveSlanglist();
        saveHistory();
    }
}
