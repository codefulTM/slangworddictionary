/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.sources;
import java.util.*;
/**
 *
 * @author WINDOWS 10
 */
public class Dictionary {
    private HashMap<String, ArrayList<String>> slanglist;
    private HashMap<String, ArrayList<String>> history;
    
    public void findByName(String name) {
        
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
    
    Dictionary(String filename) {
        
    }
    
    boolean addSlangWord(Word w) {
        return true;
    }
    
    void overwriteSlangWord(Word w) {
        
    }
    
    void addDuplicateSlangWord(Word w) {
        
    }
}
