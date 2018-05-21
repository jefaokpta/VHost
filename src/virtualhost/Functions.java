/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualhost;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jefaokpta
 */
public class Functions {
    Process ls_proc;
    DataInputStream ls_in;
    private String ls_str;
    
    public int execScript(){
        int res = 1;
        try {   
            ls_proc = Runtime.getRuntime().exec("/tmp/vhosts.sh");
            ls_in = new DataInputStream(ls_proc.getInputStream());
            while ((ls_str=ls_in.readLine()) != null) {
                if(ls_str.length()==1)
                    res=Integer.parseInt(ls_str);
            }
            removePass();
            removeSh();
        } catch (IOException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    public void setPermissions(){
        String res;
        try {   
            ls_proc = Runtime.getRuntime().exec("chmod a+x /tmp/vhosts.sh");
            ls_in = new DataInputStream(ls_proc.getInputStream());
            while ((ls_str=ls_in.readLine()) != null) {
                   res=ls_str;
            }
        } catch (IOException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    public void removeSh(){
        int res = 1;
        try {   
            ls_proc = Runtime.getRuntime().exec("rm /tmp/vhosts.sh");
            ls_in = new DataInputStream(ls_proc.getInputStream());
            while ((ls_str=ls_in.readLine()) != null) {
                   res=Integer.parseInt(ls_str);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void removePass(){
        int res = 1;
        try {   
            ls_proc = Runtime.getRuntime().exec("rm /tmp/vhosts.pass");
            ls_in = new DataInputStream(ls_proc.getInputStream());
            while ((ls_str=ls_in.readLine()) != null) {
                   res=Integer.parseInt(ls_str);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int sites(String pass,String site){
        File makeFile=new File("/tmp/vhosts.sh");
            FileWriter fwrite;
        try {
            fwrite = new FileWriter(makeFile);
            fwrite.write("#!/bin/bash\n");
            fwrite.write("echo '"+pass+"' | sudo -S -u root cp /tmp/"+site+" /etc/apache2/sites-enabled\n");
            fwrite.write("echo '"+pass+"' | sudo -S -u root mv /tmp/"+site+" /etc/apache2/sites-available\n");
            fwrite.write("echo $?");
            fwrite.flush();
            fwrite.close();
            setPermissions();
            
        } catch (IOException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return execScript();
    }
    public void addEtcHosts(String host,String domain,String pass,String alias){
        List<String> list=new ArrayList<String>();
        File makeFile=new File("/tmp/hosts");
        FileWriter fwrite;
        int exists=0;
        try {   
            ls_proc = Runtime.getRuntime().exec("cat /etc/hosts");
            ls_in = new DataInputStream(ls_proc.getInputStream());
            while ((ls_str=ls_in.readLine()) != null) {
                   list.add(ls_str);
            }
            fwrite = new FileWriter(makeFile);
            for(int i=0;i<list.size();i++){
                if(list.get(i).contains(domain))
                    exists=1;
                fwrite.write(list.get(i)+"\n");
            }
            if(exists==0)
                fwrite.write(host+" "+domain+" www."+domain+" "+alias+"\n");
            fwrite.flush();
            fwrite.close();
            
            makeFile=new File("/tmp/vhosts.sh");
            fwrite=new FileWriter(makeFile);
            fwrite.write("#!/bin/bash\n");
            fwrite.write("echo '"+pass+"' | sudo -S -u root mv /tmp/hosts /etc\n");
            fwrite.write("echo $?");
            fwrite.flush();
            fwrite.close();
            setPermissions();
        } catch (IOException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        }
        execScript();
    }
    public void removeEtcHosts(String host,String pass,String domain){
        List<String> list=new ArrayList<String>();
        File makeFile=new File("/tmp/hosts");
        FileWriter fwrite;
        try {   
            ls_proc = Runtime.getRuntime().exec("cat /etc/hosts");
            ls_in = new DataInputStream(ls_proc.getInputStream());
            while ((ls_str=ls_in.readLine()) != null) {
                   list.add(ls_str);
                   //System.out.println(ls_str+" "+domain.length());
            }
            fwrite = new FileWriter(makeFile);
            for(int i=0;i<list.size();i++){
                try{
                   //if(!list.get(i).substring((list.get(i).indexOf(" ")+1), (list.get(i).indexOf(" ")+1+domain.length())).equals(domain))
                    if(!list.get(i).contains(domain))
                        fwrite.write(list.get(i)+"\n");
                }catch(StringIndexOutOfBoundsException ex){
                    fwrite.write(list.get(i)+"\n");
                }
            }
            fwrite.flush();
            fwrite.close();
            
            makeFile=new File("/tmp/vhosts.sh");
            fwrite=new FileWriter(makeFile);
            fwrite.write("#!/bin/bash\n");
            fwrite.write("echo '"+pass+"' | sudo -S -u root mv /tmp/hosts /etc\n");
            fwrite.write("echo $?");
            fwrite.flush();
            fwrite.close();
            setPermissions();
        } catch (IOException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        }
        execScript();
    }
}
