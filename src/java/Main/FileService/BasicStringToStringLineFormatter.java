/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Main.FileService;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Brandon
 */
public class BasicStringToStringLineFormatter implements FileFormatter<String,List<String>> {
    private static final String CNRL = "\n";
        
    ////////////////////////////////////////
    // ------ INTERACTABLE METHODS ------ //
    ////////////////////////////////////////
    
    @Override
    public final List<String> toFormat(String string) throws IllegalArgumentException {
        if(string == null) throw new IllegalArgumentException("");
        return Arrays.asList(string.split(CNRL));
    }

    @Override
    public final String fromFormat(List<String> dataLines){
        if(dataLines == null) throw new  IllegalArgumentException("Error");
        String string = "";
        for(String line : dataLines){
            string += line + CNRL;
        }
        return string;
    }
    //This is a basic worker object and thus either is or is not the same insance and can use inhereated equals and has from Object

    @Override
    public String toString() {
        return "Basic String To String Line Formatter";
    }
    
}
