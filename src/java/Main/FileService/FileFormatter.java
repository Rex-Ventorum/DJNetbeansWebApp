/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.FileService;

/**
 *
 * @author Brandon
 */
public interface FileFormatter<I,O> {
    public abstract O toFormat(I unformatedObject);
    public abstract I fromFormat(O formatedObject);
}
