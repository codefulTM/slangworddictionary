/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.sources;

/**
 *
 * @author WINDOWS 10
 */
import java.io.*;
        
public class Word implements Serializable {
    private String name;
    private String definition;
    
    public Word(String name, String definition) {
        this.name = name;
        this.definition = definition;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getDefinition() {
        return this.definition;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setDefinition(String definition) {
        this.definition = definition;
    } 
}
