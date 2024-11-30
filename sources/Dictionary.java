/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.sources;
import java.util.*;
import java.io.*;
import java.time.*;
/**
 *
 * @author WINDOWS 10
 */
public class Dictionary {
    public static HashMap<String, ArrayList<String>> slanglist = null;
    public static HashSet<String> history = null;
    
    public static void init() {
        try {
            File f1 = new File("src/project/data/slanglist.bin");
            File f2 = new File("src/project/data/history.bin");
            ObjectInputStream ois;
            ObjectOutputStream oos;
            BufferedReader br;
            if(f1.exists()) {
                ois = new ObjectInputStream(new FileInputStream(f1));
                Dictionary.slanglist = (HashMap<String, ArrayList<String>>)ois.readObject();
                ois.close();
            }
            else {
                Dictionary.slanglist = new HashMap<>();
                br = new BufferedReader(new FileReader("src/project/data/slang.txt"));
                String line;
                String name;
                ArrayList<String> defs;
                while((line = br.readLine()) != null) {
                    String[] substrs = line.split("[`|]");
                    name = substrs[0].toLowerCase();
                    defs = new ArrayList<>(Arrays.asList(Arrays.copyOfRange(substrs, 1, substrs.length)));
                    for(String s: defs) {
                        s = s.toLowerCase();
                    }
                    Dictionary.slanglist.put(name, defs);
                }
                br.close();
                Dictionary.saveSlanglist();
            }
            if(f2.exists()) {
                ois = new ObjectInputStream(new FileInputStream(f2));
                Dictionary.history = (HashSet<String>)ois.readObject();
                System.out.println(Dictionary.history.size());
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
        ArrayList<String> deflist = Dictionary.slanglist.get(name.toLowerCase());
        if(deflist == null) {
            return null; // the slang is not found
        }
        // add to history
        Dictionary.history.add(name.toLowerCase());
        Dictionary.saveHistory();
        // generate word list
        ArrayList<Word> foundlist = new ArrayList<>();
        for(int i = 0; i < deflist.size(); i++) {
            foundlist.add(new Word(name.toLowerCase(), deflist.get(i)));
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
                if(defSet.get(i).contains(definition.toLowerCase())) {
                    namelist.add(e.getKey());
                    break;
                }
            }
        }
        if(namelist.size() == 0) {
            return null;
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
        if(Dictionary.slanglist.containsKey(name.toLowerCase())) {
            return false;
        }
        else {
            ArrayList<String> deflist = new ArrayList<>();
            deflist.add(definition.toLowerCase());
            Dictionary.slanglist.put(name.toLowerCase(), deflist);
            Dictionary.saveSlanglist();
            return true;
        }
    }
    
    public static void overwriteSlangWord(String name, String definition) {
        ArrayList<String> deflist = new ArrayList<>();
        deflist.add(definition.toLowerCase());
        Dictionary.slanglist.put(name.toLowerCase(), deflist);
        Dictionary.saveSlanglist();
    }
    
    public static void addDuplicateSlangWord(String name, String definition) {
        Dictionary.slanglist.get(name.toLowerCase()).add(definition.toLowerCase());
        Dictionary.saveSlanglist();
    }
    
    public static boolean removeByName(String name) {
        String modifiedName = name.toLowerCase();
        if(Dictionary.slanglist.containsKey(modifiedName)) {
            Dictionary.slanglist.remove(modifiedName);
            Dictionary.history.remove(modifiedName);
            Dictionary.saveProgress();
            return true;
        }
        return false;
    }
    
    public static ArrayList<Word> getDailySlang() {
        LocalDate start = LocalDate.of(2024, 11, 29);
        LocalDate end = LocalDate.now();
        Period p = Period.between(start, end);
        int n = Dictionary.slanglist.size();
        int idx = p.getDays() % n;
        int cnt = 0;
        ArrayList<Word> list = null;
        for(var e: Dictionary.slanglist.entrySet()) {
            if(cnt == idx) {
                System.out.println(e.getKey());
                System.out.println(e.getValue());
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
    
    public static ArrayList<Word> getCollectionOfRandSlangs() {
        int cntSlangs = Dictionary.slanglist.size();
        int cntChoices = 4;
        if(cntSlangs < 4) {
            cntChoices = cntSlangs;
        }
        HashSet<Integer> idxSet = new HashSet<>();
        while(idxSet.size() < cntChoices) {
            idxSet.add((int)Math.floor(Math.random() * cntSlangs));
        }
        ArrayList<Word> wordlists = new ArrayList<>();
        int idx = 0;
        for(var e: Dictionary.slanglist.entrySet()) {
            if(idxSet.contains(idx)) {
                String name = e.getKey();
                int numOfDefs = e.getValue().size();
                String def = e.getValue().get((int)Math.floor(Math.random() * numOfDefs));
                Word temp = new Word(name, def);
                wordlists.add(temp);
                if(wordlists.size() == cntChoices) {
                    break;
                }
            }
            idx++;
        }
        return wordlists;
    }
    
    public static void resetDictionary() {
        try {
            // regenerate the slang list from slang.txt and write back to the binary file
            BufferedReader br = new BufferedReader(new FileReader("src/project/data/slang.txt"));
            String line;
            String name;
            ArrayList<String> defs;
            while((line = br.readLine()) != null) {
                String[] substrs = line.split("[`|]");
                name = substrs[0].toLowerCase();
                defs = new ArrayList<>(Arrays.asList(Arrays.copyOfRange(substrs, 1, substrs.length)));
                for(String s: defs) {
                    s = s.toLowerCase();
                }
                Dictionary.slanglist.put(name, defs);
            }
            br.close();
            // regenerate history
            Dictionary.history.clear();
            // save progress
            Dictionary.saveProgress();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static boolean editSlangWord(Word oldW, Word newW) {
        ArrayList<String> deflist = Dictionary.slanglist.get(oldW.getName());
        if(deflist == null) {
            System.out.println("Can't find slang list being editted");
            return false;
        }
        boolean foundOldWord = false;
        for(int i = 0; i < deflist.size(); i++) {
            if(deflist.get(i).compareTo(oldW.getDefinition().toLowerCase()) == 0) {
                foundOldWord = true;
                deflist.remove(i);
                if(deflist.size() == 0) {
                    Dictionary.slanglist.remove(oldW.getName());
                }
                break;
            }
        }
        if(!foundOldWord) {
            System.out.println("Can't find slang list being editted");
            return false;
        }
        boolean res = Dictionary.addSlangWord(newW.getName(), newW.getDefinition());
        if(!res) {
            Dictionary.addDuplicateSlangWord(oldW.getName(), newW.getDefinition());
        }
        Dictionary.saveSlanglist();
        return true;
    }
    
    public static void saveHistory() {
        try {
            System.out.println("Current history size: " + Dictionary.history.size());
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/project/data/history.bin"));
            oos.writeObject(Dictionary.history);
            oos.close();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void saveSlanglist() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/project/data/slanglist.bin"));
            oos.writeObject(Dictionary.slanglist);
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
