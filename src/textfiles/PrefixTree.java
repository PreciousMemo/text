package textfiles;
import java.util.HashMap;

class TrieNode
{
    char letter;
    TrieNode[] links;
    boolean fullWord;
    String value="";
    TrieNode(char letter, boolean fullWord,String values)
    {
        this.letter = letter;
        links = new TrieNode[99];
        this.fullWord = fullWord;
        value = values;
    }
}

public class PrefixTree
{
    
    public static TrieNode createTree()
    {
        return(new TrieNode('\0', false,null));
    }
    
    static void insertWord(TrieNode root, String word,String tran,HashMap balance)
    {   
        int offset = 32;
        int l = word.length();
        char[] letters = word.toCharArray();
        TrieNode curNode = root;
        String ss = "";
        for (int i = 0; i < l; i++)
        {
            if(letters[i] == '﻿'){
            }else if(letters[i] == '/'){
                curNode.links[letters[i]-offset] = new TrieNode(letters[i],true,tran);
                balance.put(ss, tran);
                break;
            }else if(letters[i] == '’'){
                curNode.links[97] = new TrieNode(letters[i],false,null);
                      balance.put(ss, "The word was NOT found");
            }else if(letters[i] == '‘'){
                curNode.links[98] = new TrieNode(letters[i],false,null);
                      balance.put(ss, "The word was NOT found");
            }else{
                
              ss = ss+letters[i];

              
              if (i+1 == l){
                  curNode.links[letters[i]-offset] = new TrieNode(letters[i],true,tran);
                  balance.put(ss, tran);    
              }else{
                   if (curNode.links[letters[i]-offset]==null){
                  curNode.links[letters[i]-offset] = new TrieNode(letters[i],false,null);
                  balance.put(ss, "The word was NOT found");
                   }
              }
              
              
              
              curNode = curNode.links[letters[i]-offset];
            }
        }
    }
    
    
    static void insertWord2(TrieNode root, String word,String tran)
    {
        int offset = 32;
        int l = word.length();
        char[] letters = word.toCharArray();
        TrieNode curNode = root;
        String ss = "";
        for (int i = 0; i < l; i++)
        {
            if(letters[i] == '﻿'){
            }else if(letters[i] == '/'){
                curNode.links[letters[i]-offset] = new TrieNode(letters[i],true,tran); 
                break;
            }else if(letters[i] == '’'){
                curNode.links[97] = new TrieNode(letters[i],false,null);
            }else if(letters[i] == '‘'){
                curNode.links[98] = new TrieNode(letters[i],false,null);
            }else{
                
              ss = ss+letters[i];
              if (curNode.links[letters[i]-offset] == null){
                  if (i+1 == l){
                      curNode.links[letters[i]-offset] = new TrieNode(letters[i],true,tran);
                  }else{
                      curNode.links[letters[i]-offset] = new TrieNode(letters[i],false,null);
                  }              
              }else{
                  if (i+1 == l){
                  curNode.links[letters[i]-offset] = new TrieNode(letters[i],true,tran);
                  }
              }
              curNode = curNode.links[letters[i]-offset];
            }
        }
    }
    
    
    
    
    static String tWord(String word)
    {
        System.out.println(word);
        int l = word.length();
        int k=l;
        char[] letters = word.toCharArray();
        String ss = "";
        for (int i = 0; i < l; i++)
        {
            ss = ss+letters[i];
            if("<eant>".equals(ss) || "﻿<Doc>".equals(ss) || "<Doc>".equals(ss) || "<esearch>".equals(ss) || "<ecat>".equals(ss) || "<ethai>".equals(ss) || "<esyn>".equals(ss) || "<id>".equals(ss) || "</Doc>".equals(ss)){
               ss = "99";     
               break;
            }else if("<eentry>".equals(ss) || "<tentry>".equals(ss)){
                ss = "";
                for(int j=i+1;j < k-9;j++){
                ss = ss+letters[j];
                }
                break;
            }
        }
        
        return ss;
    }

    static String find(TrieNode root, String word)
    {
        char[] letters = word.toCharArray();
        int l = letters.length;
        int offset = 32;
        TrieNode curNode = root;
        int i;
        for (i = 0; i < l; i++)
        {
            if (curNode == null){
                return null;
            }
            curNode = curNode.links[letters[i]-offset];
        }
        
        if (i == l && curNode == null){
            return null;
        }
        return curNode.value;  
    }
}
