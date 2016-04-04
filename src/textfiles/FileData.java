package textfiles;
import java.io.IOException;
import static textfiles.PrefixTree.find;
import java.util.HashMap;
//import static textfiles.PrefixTree.printTree;

public class FileData {
    
    public static String searchWord(String vocap,TrieNode tree)throws IOException
    {
//        String file_name = "C:/Users/Administrator/Desktop/vocap2.txt";
//        ReadFile file = new ReadFile(file_name);
//        String[] aryLines = file.OpenFile();
//        String[] tran = readtranslate();
//        TrieNode tree = createTree();    
//        HashMap balance = new HashMap();
//        int i;
//        for ( i=0; i < aryLines.length; i++ ) {
//          //  System.out.println( aryLines[ i ] ) ;
//            insertWord(tree, aryLines[i],tran[i],balance);
//        }
//        String searchWord = vocap;
//        String val = (String) balance.get(searchWord);
// //       System.out.println("l  = "+val);
//        return val;
        
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
//        String file_name = "C:/Users/Administrator/Desktop/vocap2.txt";
//        ReadFile file = new ReadFile(file_name);
//        String[] aryLines = file.OpenFile();
//        String[] tran = readtranslate();
//        TrieNode tree = createTree();    
//        HashMap balance = new HashMap();
//        int i;
//        for ( i=0; i < aryLines.length; i++ ) {
//          //  System.out.println( aryLines[ i ] ) ;
//            insertWord(tree, aryLines[i],tran[i],balance);
//        }
        String searchWord = vocap;
        String val = (String) balance.get(searchWord);
        /* int s = balance.size();
         System.out.println("l  = "+s);
         balance.remove("about");
         Set set = balance.entrySet();
         Iterator iterator = set.iterator();
         while(iterator.hasNext()) {
           Map.Entry mentry = (Map.Entry)iterator.next();
           System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
           System.out.println(mentry.getValue());
         }
         System.out.println("l  = "+s);
         s = searchWord.hashCode();
         String a =(String) balance.get(2);
         System.out.println("l  = "+s);
         */
         if(val==null){
             val="The word was NOT found";
         }
         
         return val;
       
//        String searchWord = vocap;
//        String val=find(tree, searchWord);
//        if (val != null)
//        {
//            return val;
//        }else if(searchWord.isEmpty()){
//            return ""; 
//        }else{
//            return "The word was NOT found"; 
//        }
        
    }
    public static String[] searchWordlist(String vocap,String[] aryLines)throws IOException
    {
//        HashMap balance = new HashMap();
//        String file_name = "C:/Users/Administrator/Desktop/vocap2.txt";
//        ReadFile file = new ReadFile(file_name);
//        String[] aryLines = file.OpenFile();
//        String[] tran = readtranslate();
        String[] compword = new String[1000000];
//        TrieNode tree = createTree();    
        int i=0,g = 0,m=0;
//        for ( i=0; i < aryLines.length; i++ ) {
//          //  System.out.println( aryLines[ i ] ) ;
//            insertWord(tree, aryLines[i],tran[i],balance);
//        }
        String searchWord = vocap;
        for(int j=1; j < aryLines.length;j=j+2){
           int l = aryLines[j].length();
           char[] letters;
            letters = aryLines[j].toCharArray();
           char[] sletter;
            sletter = searchWord.toCharArray();
            
            //System.out.println("l  = "+l);
            //System.out.println("sletter.length  = "+sletter.length);
            for(int k=0; k<(sletter.length);k++){
                //System.out.println("sletter[k] = "+sletter[k]);
                //System.out.println("letters[k] = "+letters[k]);
                
                if(sletter.length>=l){
                    break;
                }
                if (sletter[k] == letters[k]){
                   //System.out.println("k = "+k);
                   //System.out.println("l = "+l);
                   m++;
                 //  System.out.println("m = "+m+" sletter.length = "+sletter.length);
                   if(k+1==sletter.length && m == sletter.length){
                        compword[g] = aryLines[j];
                        g++;
                        i++;
                   }
               }
                
            }
            m=0;
        //System.out.println("j = "+j);
        }
       return compword;
    }
    
//    public static String[] gettranslate(){
//        
//        
//        
//    }
    
    public static String[] readtranslate()throws IOException{
        
        String file_name = "C:/Users/Administrator/Desktop/translate.txt";
        ReadFile file = new ReadFile(file_name);
        String[] aryLines = file.OpenFile();  
//        int i;
//        for ( i=0; i < aryLines.length; i++ ) {
//            System.out.println( aryLines[ i ] ) ;
//        }
        
        return aryLines;
        
    }
    
    
}
