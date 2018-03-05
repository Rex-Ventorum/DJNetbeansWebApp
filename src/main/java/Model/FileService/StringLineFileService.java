/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.FileService;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * This File Service Reads and Writes to A File Line By Line Allowing the file to be more readable/editable by user; 
 * A FileFormmater Object is required to encode and decode objects of type T
 * @author Brandon
 */
public class StringLineFileService<T> implements FileService<T>{
    
    public static final String RECORD_SEPERATOR = "----- NEW RECORD -----";
    private FileFormatter<T,List<String>> fileFormatter;
    private String serviceId;
    private File readWriteFile; 
    
    ////////////////////////////////////////
    // ---------- CONSTRUCTORS ---------- //
    ////////////////////////////////////////
    
    public StringLineFileService(File readWriteFile, FileFormatter<T,List<String>> fileFormatter){
        setReadWriteFile(readWriteFile);
        setFileFormatter(fileFormatter);
    }

    ////////////////////////////////////////
    // ------ INTERACTABLE METHODS ------ //
    ////////////////////////////////////////
    
    @Override
    public final void writeToFile(T object, boolean append) throws IOException, IllegalArgumentException {
        if(object == null) throw new IllegalArgumentException("Object My Not Be Null");
        
        PrintWriter writer = null;
        List<String> dataLines = fileFormatter.toFormat(object);
        try{
            writer = new PrintWriter(new BufferedWriter(new FileWriter(readWriteFile,append)));
            for(String s : dataLines){
                writer.println(s);
            }
            writer.println(RECORD_SEPERATOR);
        }catch(FileNotFoundException fnf){
            throw fnf;
        }catch(IOException ioe){
            throw ioe;
        }catch(Exception e){
            throw e;
        }finally{
            if(writer != null) writer.close();
        }
    }

    @Override
    public final List<T> readFromFile() throws IOException, IllegalArgumentException {
        BufferedReader reader = null;
        List<String> dataLines = new LinkedList<>();
        List<T> dataObjects = new LinkedList<>();
        
        try{
            reader = new BufferedReader(new FileReader(readWriteFile));
            String line = reader.readLine();
            while(line != null){
                if(line.equals(RECORD_SEPERATOR)){
                    dataObjects.add(fileFormatter.fromFormat(dataLines));
                    dataLines.clear();
                }else{
                    dataLines.add(line);
                }           
                line = reader.readLine();
            }
        }catch(FileNotFoundException fnf){
            throw fnf;
        }catch(IOException ioe){
            throw ioe;
        }catch(Exception e){
            throw e;
        }finally{
            if(reader != null) reader.close();
        }
        return dataObjects;
    }        
            
    ////////////////////////////////////////
    // --------- SETTER METHODS --------- //
    ////////////////////////////////////////
   
    public final void setFileFormatter(FileFormatter<T, List<String>> fileFormatter) throws IllegalArgumentException{
        if(fileFormatter == null) throw new IllegalArgumentException("File Formatter May Not Be Null");
        this.fileFormatter = fileFormatter;
    }
    
    @Override
    public final void setServiceId(String serviceId) {
       if(serviceId == null || serviceId.isEmpty()) throw new IllegalArgumentException("Service Id May Not Be Null");
       this.serviceId = serviceId;
    }
    @Override
    public final void setReadWriteFile(File readWriteFile) throws IllegalArgumentException{
        if(readWriteFile == null) throw new IllegalArgumentException("Read Write File May Not Be Null");
        this.readWriteFile = readWriteFile;
    }
    
    ////////////////////////////////////////
    // --------- GETTER METHODS --------- //
    ////////////////////////////////////////
    
    public final FileFormatter<T, List<String>> getFileFormatter() {
        return fileFormatter;
    }
    
    @Override
    public final String getServiceId() {
        return serviceId;
    }
    
    @Override
    public final File getReadWriteFile() {
        return readWriteFile;
    }
    
    ////////////////////////////////////////
    // --------- OTHER METHOID ---------- //
    ////////////////////////////////////////

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.serviceId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final StringLineFileService<?> other = (StringLineFileService<?>) obj;
        if (!Objects.equals(this.serviceId, other.serviceId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StringLineFileService{" + "fileFormatter=" + fileFormatter + ", serviceId=" + serviceId + ", readWriteFile=" + readWriteFile + '}';
    }

    
}
