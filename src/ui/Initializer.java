package ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adrianlrx <adrianlrx@gmail.com>
 */
public class Initializer {
    
    private String syspath = System.getProperty("user.home");
    private String filename = ".keystore";
    private String filepath;
    private FileInputStream fis;
    private KeyStore keyStore;

    public Initializer() { 
        this.filepath = syspath+File.separator+filename;
    }

    public Initializer(String filepath) {
        this.filepath = filepath;
    }
    
    public void init(char[] password){
        try {
            fis = new FileInputStream(filepath);
            this.keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(fis, password);
            fis.close();

        } catch(FileNotFoundException e){
            createDefaultStore(password);
            
        } catch (KeyStoreException ex) {
            Logger.getLogger(Initializer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Initializer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Initializer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CertificateException ex) {
            Logger.getLogger(Initializer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public  void createDefaultStore(char[] password){
        createStore(filepath, password);
    }
    
    public void createStore(String path, char[] pass){
        try {
                
                this.keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                this.keyStore.load(null, pass);
                FileOutputStream fos = new FileOutputStream(path);
                this.keyStore.store(fos, pass);
                fos.close();
            } catch (KeyStoreException ex) {
                Logger.getLogger(Initializer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Initializer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
            Logger.getLogger(Initializer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Initializer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CertificateException ex) {
            Logger.getLogger(Initializer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getSyspath() {
        return syspath;
    }

    public KeyStore getKeyStore() {
        return keyStore;
    }

    public void setKeyStore(KeyStore keyStore) {
        this.keyStore = keyStore;
    }
    
    public static void main(String[] args) throws Exception {
        Initializer in = new Initializer();
        in.init("phantomhyde".toCharArray());
        
        Enumeration<String> all = in.getKeyStore().aliases();
        
        while (all.hasMoreElements()) {
            String string = all.nextElement();
            System.out.println(string);
        }
        
    }
}
