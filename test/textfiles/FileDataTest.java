/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textfiles;

import java.io.IOException;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static textfiles.GUI.vocap;
import static textfiles.PrefixTree.createTree;
import static textfiles.PrefixTree.insertWord;
import static textfiles.PrefixTree.insertWord2;

/**
 *
 * @author Administrator
 */
public class FileDataTest {
    HashMap balance = new HashMap();
    TrieNode tree = createTree();
    String[] aryLines;
    public FileDataTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() throws IOException {
    
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws IOException {
    
    TrieNode tree2 = createTree();
    String file_name = "C:/Users/Administrator/Desktop/builing2/vocap&tran2.txt";
    ReadFile file = new ReadFile(file_name);
    
    
        aryLines = file.OpenFile();
      
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
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of searchWord method, of class FileData.
     */
    @Test
    public void testSearchWord() throws Exception {
        System.out.println("searchWord");
        String vocap = "";
       // TrieNode tree = null;
        String expResult = "";
        String result = FileData.searchWord(vocap, tree);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of searchWord2 method, of class FileData.
     */
    @Test
    public void testSearchWord2() throws Exception {
        System.out.println("searchWord2");
        String vocap = "";
        //HashMap balance = null;
        String expResult = "The word was NOT found";
        String result = FileData.searchWord2(vocap, balance);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of searchWordlist method, of class FileData.
     */
    @Test
    public void testSearchWordlist() throws Exception {
        System.out.println("searchWordlist");
        String vocap = "a";
        //String[] aryLines = null;
        //String[] expResult = null;--
        String[] result = FileData.searchWordlist(vocap, aryLines);
        System.out.println(result.length);
        for(int j=0; j < 10;j++){
            System.out.println(result[j]);
        }
        //assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

  
    
}