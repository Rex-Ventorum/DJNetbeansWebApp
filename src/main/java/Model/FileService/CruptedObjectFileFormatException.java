/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.FileService;

import java.io.IOException;

/**
 * This is a custom exception used by FileFormatter Objects. This should be thrown in place of any exception that occurs
 * while trying to reformat an object from a file.<br>
 * This class uses the equals,hashCode, and toString methods of it's parent classes. 
 * @author Brandon
 */
public class CruptedObjectFileFormatException extends IOException{
    private static final String CUSTOM_MESSAGE = "Unable To Recreate Object Based Off File Format";
    
    public CruptedObjectFileFormatException() {
        super(CUSTOM_MESSAGE);
    }

    public CruptedObjectFileFormatException(String message) {
        super(CUSTOM_MESSAGE);
    }

    public CruptedObjectFileFormatException(String message, Throwable cause) {
        super(CUSTOM_MESSAGE, cause);
    }

    public CruptedObjectFileFormatException(Throwable cause) {
        super(CUSTOM_MESSAGE,cause);
    }
    
}
