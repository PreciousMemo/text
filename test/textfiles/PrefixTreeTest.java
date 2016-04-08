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
        System.out.println("createTree");
        TrieNode expResult = null;
        TrieNode result = PrefixTree.createTree();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertWord method, of class PrefixTree.
     */
    @Test
    public void testInsertWord() {
        System.out.println("insertWord");
        TrieNode root = null;
        String word = "";
        String tran = "";
        HashMap balance = null;
        PrefixTree.insertWord(root, word, tran, balance);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertWord2 method, of class PrefixTree.
     */
    @Test
    public void testInsertWord2() {
        System.out.println("insertWord2");
        TrieNode root = null;
        String word = "";
        String tran = "";
        PrefixTree.insertWord2(root, word, tran);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of tWord method, of class PrefixTree.
     */
    @Test
    public void testTWord() {
        System.out.println("tWord");
        String word = "";
        String expResult = "";
        String result = PrefixTree.tWord(word);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class PrefixTree.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        TrieNode root = null;
        String word = "";
        String expResult = "";
        String result = PrefixTree.find(root, word);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
