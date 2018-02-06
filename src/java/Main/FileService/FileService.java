/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Main.FileService;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Brandon
 */
public interface FileService<T> {
    public abstract void writeToFile(T object, boolean append) throws IOException,IllegalArgumentException;
    public abstract List<T> readFromFile() throws IOException, IllegalArgumentException;
    public abstract String getServiceId();
    public abstract void setServiceId(String id);
    public abstract File getReadWriteFile();
    public abstract void setReadWriteFile(File file);
}
