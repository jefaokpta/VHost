/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualhost;

import java.awt.Color;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author jefaokpta
 */
public class Visual extends javax.swing.JFrame {
    String pass;
    String ls_str, res = "", user = null, retScript = null;
    Process ls_proc;
    DataInputStream ls_in;
    Functions run=new Functions();
    DefaultListModel listModel=new DefaultListModel();
    Credits cred;
    public void publicHosts(){
        try {
            
            ls_proc = Runtime.getRuntime().exec("ls /etc/apache2/sites-available");
            ls_in = new DataInputStream(ls_proc.getInputStream());
            while ((ls_str=ls_in.readLine()) != null) {
                if(!ls_str.equals("default")&&!ls_str.equals("default-ssl")&&
                        !ls_str.equals("000-default.conf")&&!ls_str.equals("default-ssl.conf")){
                   listModel.addElement(ls_str);
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO INTERNO", JOptionPane.ERROR_MESSAGE);
        } catch(StringIndexOutOfBoundsException ex){
            listModel.addElement(ls_str);
        }
            
    }
    /**
     * Creates new form Visual
     */
    public Visual() {
        initComponents(); 
        Passwd ini=new Passwd(this, rootPaneCheckingEnabled);
        ini.setVisible(true);
        try {   
            ls_proc = Runtime.getRuntime().exec("cat /etc/vhosts.pass");
            ls_in = new DataInputStream(ls_proc.getInputStream());
            while ((ls_str=ls_in.readLine()) != null) {
                   pass=ls_str;
            }
            File makeFile=new File("/tmp/vhosts.sh");
            FileWriter fwrite=new FileWriter(makeFile);
            fwrite.write("#!/bin/bash\n");
            fwrite.write("echo '"+pass+"' | sudo -S -u root rm /etc/vhosts.pass\n");
            fwrite.write("echo $?");
            fwrite.flush();
            fwrite.close();
            run.setPermissions();
            run.execScript();
            //=============================
            publicHosts();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO INTERNO", JOptionPane.ERROR_MESSAGE);
        }
          
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jpListHosts = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlistHosts = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jtDomain = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtLocalPath = new javax.swing.JTextField();
        btnSeek = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jtHost = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtPort = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaDetails = new javax.swing.JTextArea();
        jbWrite = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jtAlias = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jtAlogs = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtLogs = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("::::: VHosts :::::");

        jToolBar1.setBorder(null);
        jToolBar1.setFloatable(false);
        jToolBar1.setAutoscrolls(true);
        jToolBar1.setBorderPainted(false);

        jLabel8.setText("   ");
        jToolBar1.add(jLabel8);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/virtualhost/Add-icon.png"))); // NOI18N
        jLabel1.setText("   ");
        jLabel1.setToolTipText("Add Host");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jToolBar1.add(jLabel1);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/virtualhost/Close-icon.png"))); // NOI18N
        jLabel2.setText("   ");
        jLabel2.setToolTipText("Remove Host");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jToolBar1.add(jLabel2);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/virtualhost/refresh-icon.png"))); // NOI18N
        jLabel7.setText("   ");
        jLabel7.setToolTipText("Reinicia Apache");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jToolBar1.add(jLabel7);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/virtualhost/Browser-icon.png"))); // NOI18N
        jLabel11.setText("   ");
        jLabel11.setToolTipText("Visualizar Host");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jToolBar1.add(jLabel11);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/virtualhost/Info-icon.png"))); // NOI18N
        jLabel10.setText("   ");
        jLabel10.setToolTipText("Sobre");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jToolBar1.add(jLabel10);

        jpListHosts.setBorder(javax.swing.BorderFactory.createTitledBorder("Hosts"));

        jlistHosts.setModel(listModel);
        jlistHosts.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jlistHosts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlistHostsMouseClicked(evt);
            }
        });
        jlistHosts.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jlistHostsValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jlistHosts);

        javax.swing.GroupLayout jpListHostsLayout = new javax.swing.GroupLayout(jpListHosts);
        jpListHosts.setLayout(jpListHostsLayout);
        jpListHostsLayout.setHorizontalGroup(
            jpListHostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
        );
        jpListHostsLayout.setVerticalGroup(
            jpListHostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpListHostsLayout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Configuração Básica"));

        jLabel3.setText("Domínio:");

        jLabel4.setText("Caminho Local: ");

        btnSeek.setText("Procurar");
        btnSeek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeekActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSeek)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(1, 1, 1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtDomain, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                            .addComponent(jtLocalPath))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtDomain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtLocalPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSeek))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Configurações Avançadas"));

        jLabel5.setText("IP/Host:");

        jtHost.setText("127.0.0.1");

        jLabel6.setText("Porta:");

        jtPort.setText("80");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalhes"));

        jtaDetails.setColumns(20);
        jtaDetails.setRows(5);
        jtaDetails.setToolTipText("Aqui voçê pode inserir parâmetros customizados para o seu HOST");
        jScrollPane1.setViewportView(jtaDetails);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                .addContainerGap())
        );

        jbWrite.setText("Salvar");
        jbWrite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbWriteActionPerformed(evt);
            }
        });

        jLabel13.setText("Apelido (Alias): ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbWrite))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtHost, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtAlias, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 98, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jtAlias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbWrite))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Logs"));

        jLabel12.setText("Logs de Acesso: /var/log/apache2/");

        jLabel9.setText("Logs de Erros: /var/log/apache2/");

        jtLogs.setText("error.log");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtAlogs, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtLogs, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jtAlogs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jtLogs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpListHosts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpListHosts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(770, 789));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbWriteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbWriteActionPerformed
        if(jtDomain.getText().equals("")||jtLocalPath.getText().equals("")||jtHost.getText().equals("")
                ||jtPort.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Existem campos obrigatórios não preenchidos.", "Campos em Branco", JOptionPane.WARNING_MESSAGE);
        else{
            File makeFile=new File("/tmp/"+jtDomain.getText()+"");
            FileWriter fwrite;
            try {
                fwrite = new FileWriter(makeFile);
                fwrite.write("<VirtualHost "+(jtHost.getText().equals("127.0.0.1")?"*":jtHost.getText())+""
                        + ":"+jtPort.getText()+">\n");
                fwrite.write("\n");
                fwrite.write("ServerName "+jtDomain.getText()+"\n");
                fwrite.write("ServerAlias www."+jtDomain.getText()+"\n");
                if(!jtAlias.getText().equals("")) fwrite.write("ServerAlias "+jtAlias.getText()+"\n");
                fwrite.write("DocumentRoot "+jtLocalPath.getText()+"\n");
                fwrite.write("\n");
                fwrite.write("<Directory \""+jtLocalPath.getText()+"\">\n");
                
                fwrite.write("##paramsBegin\n");
                fwrite.write(jtaDetails.getText()+"\n");
                fwrite.write("##paramsEnd\n");
                
                fwrite.write("Options Indexes FollowSymLinks MultiViews\n");
                fwrite.write("AllowOverride All\n");
                fwrite.write("Order allow,deny\n");
                fwrite.write("Allow from all\n");
                fwrite.write("</Directory>\n");
                fwrite.write("\n");
                if(!jtAlogs.getText().equals("")) fwrite.write("CustomLog /var/log/apache2/"+jtAlogs.getText()+" common\n");
                fwrite.write("ErrorLog /var/log/apache2/"+(jtLogs.getText().equals("")?"error.log":jtLogs.getText())+"\n");
                fwrite.write("</VirtualHost>\n");
                fwrite.flush();
                fwrite.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Algo deu errado na escrita...\n"+ex.getMessage(), "OPS", JOptionPane.ERROR_MESSAGE);
            }
            //manda p apache2
            if(run.sites(pass, jtDomain.getText())==0){
                //reescreve lista de HOSTS
                listModel.removeAllElements();
                publicHosts();
                UIManager ui=new UIManager();
                ui.put("OptionPane.messageForeground", Color.red);
                jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/virtualhost/refresh-icon-red.png")));             
                JOptionPane.showMessageDialog(null, "Acessos disponíveis:\n"
                        + "http://"+jtDomain.getText()+"\n"
                        + "http://www."+jtDomain.getText()+"\n"
                        + (!jtAlias.getText().equals("")?"Alias: http://"+jtAlias.getText()+"\n":"")
                        + "NÂO DEIXE DE REINICIAR O APACHE!",
                        "Dados Salvos com Sucesso", JOptionPane.INFORMATION_MESSAGE);               
            }
            else
                JOptionPane.showMessageDialog(null, "Algo deu errado...\nTem certeza que o Apache está instalado?", "OPS", JOptionPane.ERROR_MESSAGE);
            run.addEtcHosts(jtHost.getText(), jtDomain.getText(),pass,jtAlias.getText());
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jbWriteActionPerformed

    private void btnSeekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeekActionPerformed
        JFileChooser fc=new JFileChooser();
        int retFile;
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.setMultiSelectionEnabled(false);
        retFile=fc.showOpenDialog(null);
        if(retFile==JFileChooser.APPROVE_OPTION){
            jtLocalPath.setText(String.valueOf(fc.getSelectedFile()));
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSeekActionPerformed

    private void jlistHostsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jlistHostsValueChanged
        //me deu dor de cabeça    
        // TODO add your handling code here:
    }//GEN-LAST:event_jlistHostsValueChanged

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        jtDomain.setText("");
        jtLocalPath.setText("");
        jtHost.setText("127.0.0.1");
        jtPort.setText("80");
        jtLogs.setText("error.log");
        jtaDetails.setText("");
        jtAlias.setText("");
        jtAlogs.setText("");
        jlistHosts.clearSelection();       
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jlistHostsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlistHostsMouseClicked
        if(jlistHosts.getSelectedValue()!=null){
            jtDomain.setText("");
            jtLocalPath.setText("");
            jtHost.setText("");
            jtPort.setText("");
            jtLogs.setText("");
            jtAlogs.setText("");
            jtAlias.setText("");
            jtaDetails.setText("");
            try {
                jtaDetails.setText("");
                int param=0;
                ls_proc = Runtime.getRuntime().exec("cat /etc/apache2/sites-available/"+jlistHosts.getSelectedValue().toString()+"");
                ls_in = new DataInputStream(ls_proc.getInputStream());
                while ((ls_str=ls_in.readLine()) != null) {
                    if(ls_str.length()>12){
                        if(ls_str.contains("<VirtualHost")){
                            if(ls_str.substring(ls_str.indexOf("<VirtualHost ")+13, ls_str.indexOf(":")).equals("*"))
                                jtHost.setText("127.0.0.1");
                            else
                                jtHost.setText(ls_str.substring(ls_str.indexOf("<VirtualHost ")+13, ls_str.indexOf(":")));
                            jtPort.setText(ls_str.substring(ls_str.indexOf(":")+1, ls_str.indexOf(">")));
                        }
                        else if(ls_str.contains("ServerName"))
                            jtDomain.setText(ls_str.substring(ls_str.indexOf("ServerName ")+11));
                        else if(ls_str.contains("DocumentRoot"))
                            jtLocalPath.setText(ls_str.substring(ls_str.indexOf("DocumentRoot ")+13));
                        else if(ls_str.contains("ErrorLog"))
                            jtLogs.setText(ls_str.substring(ls_str.indexOf("2/")+2));
                        else if(ls_str.contains("CustomLog")){
                            jtAlogs.setText(ls_str.substring(ls_str.indexOf("2/")+2).replace(" common", ""));
                            //jtAlogs.setText(ls_str.substring(0, ls_str.indexOf("")));
                        }
                        else if(ls_str.contains("ServerAlias"))
                            jtAlias.setText(ls_str.substring(ls_str.indexOf("ServerAlias ")+12));
                    }
                    if(ls_str.equals("##paramsBegin"))
                        param=1; 
                    else if(ls_str.equals("##paramsEnd"))
                        param=0;
                    if(param==1)    
                        if(!ls_str.equals("##paramsBegin"))
                            jtaDetails.setText(jtaDetails.getText()+ls_str+"\n");
                }
            } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO INTERNO", JOptionPane.ERROR_MESSAGE);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jlistHostsMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        if(jlistHosts.getSelectedValue()!=null){
            FileWriter fwrite = null;
            try {
                File makeFile=new File("/tmp/vhosts.sh");
                fwrite = new FileWriter(makeFile);
                fwrite.write("#!/bin/bash\n");
                fwrite.write("echo '"+pass+"' | sudo -S -u root rm /etc/apache2/sites-available/"+jtDomain.getText()+"\n");
                fwrite.write("echo '"+pass+"' | sudo -S -u root rm /etc/apache2/sites-enabled/"+jtDomain.getText()+"\n");               
                fwrite.write("echo $?");
                fwrite.flush();
                fwrite.close();
                run.setPermissions();
                
             } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO INTERNO", JOptionPane.ERROR_MESSAGE);
             }
            if(run.execScript()==0){
                jlistHosts.clearSelection();
                listModel.removeAllElements();
                run.removeEtcHosts(jtHost.getText(), pass, jtDomain.getText());
                jLabel1MouseClicked(evt);
                publicHosts(); 
                JOptionPane.showMessageDialog(null, "Host apagado com sucesso!", "REMOVIDO", JOptionPane.INFORMATION_MESSAGE);               
            }
            else
                JOptionPane.showMessageDialog(null, "Algo deu errado...", "OPS", JOptionPane.WARNING_MESSAGE);
        }
        else
            JOptionPane.showMessageDialog(null, "Selecione um HOST!", "OPS", JOptionPane.WARNING_MESSAGE);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        cred=new Credits(this, rootPaneCheckingEnabled);
        //this.setVisible(false);
        cred.setVisible(true);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        FileWriter fwrite = null;
        File makeFile=new File("/tmp/vhosts.sh");
        try {
            fwrite=new FileWriter(makeFile);
            fwrite.write("#!/bin/bash\n");
            fwrite.write("echo '"+pass+"' | sudo -S -u root service apache2 restart\n");
            fwrite.write("echo $?");
            fwrite.flush();
            fwrite.close();
        } catch (IOException ex) {
            Logger.getLogger(Visual.class.getName()).log(Level.SEVERE, null, ex);
        }      
            run.setPermissions();
            if(run.execScript()==0){
                jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/virtualhost/refresh-icon.png")));
                JOptionPane.showMessageDialog(null, "Configurações ativadas.", "ATIVO", JOptionPane.INFORMATION_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(null, "Algo deu errado...", "OPS", JOptionPane.WARNING_MESSAGE);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        if(!jtDomain.getText().equals("")){
            try {
                Runtime.getRuntime().exec("firefox http://"+jtDomain.getText()+"");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Algo deu errado...\nRequer: Firefox\n"+ex.getMessage(), "OPS", JOptionPane.WARNING_MESSAGE);
            }
        }
        else
            JOptionPane.showMessageDialog(null, "Selecione um HOST", "OPS", JOptionPane.WARNING_MESSAGE);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Visual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Visual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Visual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Visual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Visual().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSeek;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton jbWrite;
    private javax.swing.JList jlistHosts;
    private javax.swing.JPanel jpListHosts;
    private javax.swing.JTextField jtAlias;
    private javax.swing.JTextField jtAlogs;
    private javax.swing.JTextField jtDomain;
    private javax.swing.JTextField jtHost;
    private javax.swing.JTextField jtLocalPath;
    private javax.swing.JTextField jtLogs;
    private javax.swing.JTextField jtPort;
    private javax.swing.JTextArea jtaDetails;
    // End of variables declaration//GEN-END:variables
}
