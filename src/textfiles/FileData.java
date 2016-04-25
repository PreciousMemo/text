package textfiles;
import java.io.IOException;
import static textfiles.PrefixTree.find;
import java.util.HashMap;
public class FileData {
    
    public static String searchWord(String vocap,TrieNode tree)throws IOException
    {
        
        String searchWord = vocap;
        String val=find(tree, searchWord);
        if (val != null)
        {
            return val;
        }else if(searchWord.isEmpty()){
            return ""; 
        }else{
            return "The word was NOT found"; 
        }
        
    }
    
    public static String searchWord2(String vocap,HashMap balance)throws IOException
    {
        String searchWord = vocap;
        String val = (String) balance.get(searchWord);
         if(val==null){
             val="The word was NOT found";
         }
         
         return val;
        
    }
    public static String[] searchWordlist(String vocap,String[] aryLines)throws IOException
    {
        String[] compword = new String[1000000];
        int i=0,g = 0,m=0;
        String searchWord = vocap;
        for(int j=1; j < aryLines.length;j=j+2){
           int l = aryLines[j].length();
           char[] letters;
            letters = aryLines[j].toCharArray();
           char[] sletter;
            sletter = searchWord.toCharArray();
            for(int k=0; k<(sletter.length);k++){
                
                if(sletter.length>=l){
                    break;
                }
                if (sletter[k] == letters[k]){
                   m++;
                   if(k+1==sletter.length && m == sletter.length){
                        compword[g] = aryLines[j];
                        g++;
                        i++;
                   }
               }
                
            }
            m=0;
        }
        String[] compwords = new String[g];
        for(i=0;i<g;i++){
            if(compword[i] == null){
                break;
            }else{
            compwords[i] = compword[i];
            }
        }
        
       return compwords;
    }
    
    
}
