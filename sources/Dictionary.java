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
    public static HashMap<String, ArrayList<String>> slanglist = null;
    public static HashSet<String> history = null;
    
    public static void init() {
        try {
            File f1 = new File("../data/slanglist.bin");
            File f2 = new File("../data/history.bin");
            ObjectInputStream ois;
            ObjectOutputStream oos;
            BufferedReader br;
            if(f1.exists()) {
                ois = new ObjectInputStream(new FileInputStream(f1));
                Dictionary.slanglist = (HashMap<String, ArrayList<String>>)ois.readObject();
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
                    Dictionary.slanglist.put(name, defs);
                }
                br.close();
                Dictionary.saveSlanglist();
            }
            if(f2.exists()) {
                ois = new ObjectInputStream(new FileInputStream(f2));
                Dictionary.history = (HashSet<String>)ois.readObject();
            }
            else {
                Dictionary.history = new HashSet<>();
                Dictionary.saveHistory();
            }
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static ArrayList<Word> findByName(String name) {
        if(Dictionary.slanglist == null) {
            return null;
        }
        ArrayList<String> deflist = Dictionary.slanglist.get(name);
        if(deflist == null) {
            return null; // the slang is not found
        }
        // add to history
        Dictionary.history.add(name);
        Dictionary.saveHistory();
        // generate word list
        ArrayList<Word> foundlist = new ArrayList<>();
        for(int i = 0; i < deflist.size(); i++) {
            foundlist.add(new Word(name, deflist.get(i)));
        }
        return foundlist;
    }
    
    public static ArrayList<Word> findByDefinition(String definition) {
        if(Dictionary.slanglist == null) {
            return null;
        }
        ArrayList<String> namelist = new ArrayList<>();
        for(var e: Dictionary.slanglist.entrySet()) {
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
            Dictionary.history.add(namelist.get(i));
            foundlist.addAll(Dictionary.findByName(namelist.get(i)));
        }
        Dictionary.saveHistory();
        return foundlist;
    }
    
    public static boolean addSlangWord(String name, String definition) {
        if(Dictionary.slanglist.containsKey(name)) {
            return false;
        }
        else {
            ArrayList<String> deflist = new ArrayList<>();
            deflist.add(definition);
            Dictionary.slanglist.put(name, deflist);
            Dictionary.saveSlanglist();
            return true;
        }
    }
    
    public static void overwriteSlangWord(String name, String definition) {
        ArrayList<String> deflist = new ArrayList<>();
        deflist.add(definition);
        Dictionary.slanglist.put(name, deflist);
        Dictionary.saveSlanglist();
    }
    
    public static void addDuplicateSlangWord(String name, String definition) {
        Dictionary.slanglist.get(name).add(definition);
        Dictionary.saveSlanglist();
    }
    
    public static boolean removeByName(String name) {
        if(Dictionary.slanglist.containsKey(name)) {
            Dictionary.slanglist.remove(name);
            Dictionary.history.remove(name);
            Dictionary.saveProgress();
            return true;
        }
        return false;
    }
    
    public static ArrayList<Word> getRandomSlang() {
        ArrayList<Word> list = null;
        int n = Dictionary.slanglist.size();
        int i = (int)Math.floor(Math.random() * n);
        int cnt = 0;
        for(var e: Dictionary.slanglist.entrySet()) {
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
    
    public static void resetDictionary() {
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
                Dictionary.slanglist.put(name, defs);
            }
            br.close();
            // clear the history 
            Dictionary.history = new HashSet<>();
            // save progress
            Dictionary.saveProgress();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void editSlangWord(Word oldW, Word newW) {
        ArrayList<String> deflist = Dictionary.slanglist.get(oldW.getName());
        for(int i = 0; i < deflist.size(); i++) {
            if(deflist.get(i).compareTo(oldW.getDefinition()) == 0) {
                deflist.remove(i);
                break;
            }
        }
        boolean flag = Dictionary.addSlangWord(newW.getName(), newW.getDefinition());
        if(!flag) {
            Dictionary.addDuplicateSlangWord(newW.getName(), newW.getDefinition());
        }
        Dictionary.saveSlanglist();
    }
    
    public static void saveHistory() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("../data/history.bin"));
            oos.writeObject(Dictionary.history);
            oos.flush();
            oos.close();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void saveSlanglist() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("../data/slanglist.bin"));
            oos.writeObject(Dictionary.slanglist);
            oos.flush();
            oos.close();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void saveProgress() {
        Dictionary.saveSlanglist();
        Dictionary.saveHistory();
    }
}
