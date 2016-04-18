/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textfiles;

import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static textfiles.GUI.tree;
import static textfiles.PrefixTree.createTree;
import static textfiles.PrefixTree.insertWord;
import static textfiles.PrefixTree.insertWord2;

/**
 *
 * @author Administrator
 */
public class PrefixTreeTest {
    
    public PrefixTreeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createTree method, of class PrefixTree.
     */
    @Test
    public void testCreateTree() {
     
    }

    /**
     * Test of insertWord method, of class PrefixTree.
     */
    @Test
    public void testInsertWord() {
        System.out.println("insertWord");
        TrieNode root = createTree();
        HashMap balance = new HashMap();
        String word = "and";
        String tran = "1";
        PrefixTree.insertWord(root, word, tran, balance);
        word = "ant";
        tran = "2";
        PrefixTree.insertWord(root, word, tran, balance);
        word = "adtt";
        tran = "3";
        PrefixTree.insertWord(root, word, tran, balance);
        String[] vo = new String[balance.size()];
        String[] tr = new String[balance.size()];
        vo = (String[]) balance.keySet().toArray(vo);
        tr = (String[]) balance.values().toArray(tr);
        for(int i=0; i<balance.size();i++){
        System.out.println(vo[i]);
        System.out.println(tr[i]);
        }
        System.out.println("####################################################");
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of insertWord2 method, of class PrefixTree.
     */
    @Test
    public void testInsertWord2() {
        System.out.println("insertWord");
        TrieNode root = createTree();
        String word = "and";
        String tran = "1";
        PrefixTree.insertWord2(root, word, tran);
        word = "ant";
        tran = "2";
        PrefixTree.insertWord2(root, word, tran);
        word = "adtt";
        tran = "3";
        PrefixTree.insertWord2(root, word, tran);
        String result = PrefixTree.find(root, "and");
        System.out.println("and  =   "+result);
        result = PrefixTree.find(root, "ant");
        System.out.println("ant  =   "+result);
        result = PrefixTree.find(root, "adtt");
        System.out.println("adtt  =   "+result);
        result = PrefixTree.find(root, "an");
        System.out.println("an  =   "+result);
        result = PrefixTree.find(root, "adddddd");
        System.out.println("adddddd  =   "+result);
        System.out.println("####################################################");
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of tWord method, of class PrefixTree.
     */
    @Test
    public void testTWord() {
        System.out.println("tWord");
        String word = "<eant>ant";
        String expResult = "99";
        String result = PrefixTree.tWord(word);
        assertEquals(expResult, result);
        System.out.print("<eant>ant  =   "+expResult);
        word = "<tentry>ant</eentry>";
        expResult = "ant";
        result = PrefixTree.tWord(word);
        assertEquals(expResult, result);
        System.out.println("<eentry>ant</eentry>  =   "+result);
        System.out.println("####################################################");
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class PrefixTree.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        TrieNode root = createTree();
        insertWord2(root, "asdf","true");
        insertWord2(root, "asff","true2");
        String word = "a";
        String expResult = null;
        String result = PrefixTree.find(root, word);
        assertEquals(expResult, result);
        System.out.println("a  =   "+result);
        word = "asd";
        expResult = null;
        result = PrefixTree.find(root, word);
        assertEquals(expResult, result);
        System.out.println("asd  =   "+result);
        word = "asdf";
        expResult = "true";
        result = PrefixTree.find(root, word);
        assertEquals(expResult, result);
        System.out.println("asdf  =   "+result);
        word = "asff";
        expResult = "true2";
        result = PrefixTree.find(root, word);
        assertEquals(expResult, result);
        System.out.println("asff  =   "+result);
        System.out.println("####################################################");
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
