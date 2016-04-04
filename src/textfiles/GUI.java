package textfiles;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import static textfiles.FileData.searchWord;
import static textfiles.FileData.searchWord2;
import static textfiles.FileData.searchWordlist;
import static textfiles.PrefixTree.createTree;
import static textfiles.PrefixTree.insertWord;
import static textfiles.PrefixTree.insertWord2;
import static textfiles.PrefixTree.tWord;
//import textfiles.WriteFile;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
/**
 *
 * @author Administrator
 */

public class GUI extends javax.swing.JFrame {
    static String vocap;
    String words;
    String words2;
    String[] wordlist;
    static TrieNode tree = createTree();
    static TrieNode tree2 = createTree();
    String file_name = "C:/Users/Administrator/Desktop/builing2/vocap&tran2.txt";
    ReadFile file = new ReadFile(file_name);
    String[] aryLines;
    static HashMap balance = new HashMap();
//   String[] tran;
    /**
     * Creates new form GUI
     * @throws java.io.IOException
     */
    public GUI() throws IOException {
        this.aryLines = file.OpenFile();
      
        vocap = "";
        for (int i=1; i < aryLines.length; i++ ) {
            insertWord2(tree2, aryLines[i],aryLines[i+1]);
            i++;
        }
        
        for (int i=1; i < aryLines.length; i++ ) {
            
            insertWord(tree, aryLines[i],aryLines[i+1],balance);
            i++;
        }
         double bh = balance.size();
         System.out.println(bh);
        System.out.println("fin");
        initComponents();

           
            //setVisible(true);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        searchvocap = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        vocaplist = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tranbox = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        times = new javax.swing.JTextField();
        times1 = new javax.swing.JTextField();
        addvocap = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DICTIONARY");
        getContentPane().setLayout(null);

        searchvocap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchvocapActionPerformed(evt);
            }
        });
        searchvocap.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchvocapKeyReleased(evt);
            }
        });
        getContentPane().add(searchvocap);
        searchvocap.setBounds(20, 30, 240, 30);

        vocaplist.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "", "", "", "", "" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        vocaplist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vocaplistMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(vocaplist);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(290, 30, 170, 220);

        tranbox.setColumns(20);
        tranbox.setRows(5);
        tranbox.setTabSize(1);
        tranbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tranboxKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tranbox);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(20, 70, 240, 180);

        jLabel1.setText("คำศัพท์ที่ต้องการค้นหา");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 10, 240, 14);

        jLabel2.setText("คำที่ใกล้เคียง");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(290, 10, 170, 14);

        jLabel3.setText("เวลาที่ใช้ในการค้นหา");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 260, 100, 14);

        jLabel5.setText("ns/10");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(260, 280, 40, 30);

        times.setText("0.0");
        times.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timesActionPerformed(evt);
            }
        });
        getContentPane().add(times);
        times.setBounds(20, 280, 110, 30);

        times1.setText("0.0");
        times1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                times1ActionPerformed(evt);
            }
        });
        getContentPane().add(times1);
        times1.setBounds(140, 280, 110, 30);

        addvocap.setText("เพิ่มคำศัพท์");
        addvocap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addvocapMouseClicked(evt);
            }
        });
        addvocap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addvocapActionPerformed(evt);
            }
        });
        getContentPane().add(addvocap);
        addvocap.setBounds(330, 280, 90, 23);

        jLabel4.setText("tire");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 320, 110, 14);

        jLabel6.setText("tire+hash");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(140, 320, 110, 14);

        setBounds(0, 0, 492, 384);
    }// </editor-fold>//GEN-END:initComponents

    private void searchvocapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchvocapActionPerformed
       
    }//GEN-LAST:event_searchvocapActionPerformed

    private void searchvocapKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchvocapKeyReleased
        // TODO add your handling code here:
         vocap = searchvocap.getText();    
        try {
           long x1 = System.nanoTime();
           words = searchWord(vocap,tree2);
           long y1 = System.nanoTime();
           long x2 = System.nanoTime();
           words2 = searchWord2(vocap,balance);
           long y2 = System.nanoTime();
           double time1 = (y1-x1)/10.0;
           String a1 = ""+time1;
           double time2 = (y2-x2)/10.0;
           String a2 = ""+time2;
           //System.out.println("time " + (time));
           times.setText(a1);
           times1.setText(a2);
           wordlist = searchWordlist(vocap,aryLines);
           tranbox.setText(words2.replace("|", "\n"));
           vocaplist.setListData(wordlist);
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchvocapKeyReleased

    private void tranboxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tranboxKeyReleased
       
    }//GEN-LAST:event_tranboxKeyReleased

    private void timesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timesActionPerformed

    private void times1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_times1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_times1ActionPerformed

    private void vocaplistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vocaplistMouseClicked
        // TODO add your handling code here:
        int a = vocaplist.getLeadSelectionIndex();
        String b = wordlist[a];
        searchvocap.setText(b);
        vocap = searchvocap.getText();
        try {
            long x1 = System.nanoTime();
           words = searchWord(vocap,tree2);
           long y1 = System.nanoTime();
           long x2 = System.nanoTime();
           words2 = searchWord2(vocap,balance);
           long y2 = System.nanoTime();
           double time1 = (y1-x1)/10;
           String a1 = ""+time1;
           double time2 = (y2-x2)/10;
           String a2 = ""+time2;
           //System.out.println("time " + (time));
           times.setText(a1);
           times1.setText(a2);
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        tranbox.setText(words2.replace("|", "\n"));
    }//GEN-LAST:event_vocaplistMouseClicked

    private void addvocapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addvocapActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_addvocapActionPerformed

    private void addvocapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addvocapMouseClicked
//        String a = tranbox1.getText();
//        String b = searchvocap1.getText(); 
//        WriteFile data = new WriteFile( "C:/Users/Administrator/Desktop/vocapGG.txt" , true );
//        try { 
//            data.WriteToFile( b );
//            data.WriteToFile( a );
//            tranbox1.setText("");
//            searchvocap1.setText("");
//// setVisible(true);
////        GUIaddvocap form = new GUIaddvocap();
////        form.setVisible(true);
//        } catch (IOException ex) {
//            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
//        }
        GUIaddvocap form = new GUIaddvocap();
        form.setVisible(true);
    }//GEN-LAST:event_addvocapMouseClicked

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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new GUI().setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addvocap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField searchvocap;
    private javax.swing.JTextField times;
    private javax.swing.JTextField times1;
    private javax.swing.JTextArea tranbox;
    private javax.swing.JList<String> vocaplist;
    // End of variables declaration//GEN-END:variables
}
