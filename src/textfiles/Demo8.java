package textfiles;


import java.awt.*;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.*;

import no.geosoft.cc.geometry.Geometry;
import no.geosoft.cc.graphics.*;
import static textfiles.GUI.tree2;
import static textfiles.PrefixTree.createTree;
import static textfiles.PrefixTree.insertWord2;
import textfiles.TrieNode;




public class Demo8 extends JFrame
  implements GInteraction
{
  private GScene  scene_;
  
  public Demo8() throws IOException
  {
    super ("G Graphics Library - Demo 8");
    setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    
    // Create the GUI
    JPanel topLevel = new JPanel();
    topLevel.setLayout (new BorderLayout());
    getContentPane().add (topLevel);        


    // Create the graphic canvas
    GWindow window = new GWindow();
    topLevel.add (window.getCanvas(), BorderLayout.CENTER);    
    
    // Create scene with default viewport and world extent settings
    scene_ = new GScene (window, "Scene");

    double w0[] = {0.0,    1200.0, 0.0};
    double w1[] = {1200.0, 1200.0, 0.0};
    double w2[] = {0.0,       0.0, 0.0};    
    scene_.setWorldExtent (w0, w1, w2);

    GStyle style = new GStyle();
    style.setForegroundColor (new Color (0, 0, 0));
    style.setBackgroundColor (new Color (255, 255, 255));
    style.setFont (new Font ("Dialog", Font.BOLD, 14));
    scene_.setStyle (style);
    
    
    GObject object = new TestObject ("",scene_ , 500.0, 100.0); 
    String file_name = "C:/Users/Administrator/Desktop/builing2/vocap&tran2.txt";
    ReadFile file = new ReadFile(file_name);
    TrieNode tree2 = createTree();
    //String[] aryLines = file.OpenFile();
    String[] aryLines = {"ab","ba","ca"};
    for (int i=0; i < aryLines.length; i++ ) {
            insertnode(tree2, aryLines[i],object);
        }
    
    pack();
    setSize (new Dimension (500, 500));
    setVisible (true);

    window.startInteraction (this);
  }

public void insertnode(TrieNode root, String word,GObject object)
    {   GObject objects  = new TestObject ("",object, 500.0, 50.0);
        int offset = 32;
        int l = word.length();
        char[] letters = word.toCharArray();
        int x=1;
        int y=300;
        String tran = "";
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
                  GObject objectn  = new TestObject (""+letters[i],objects,(x)*((letters[i]-offset)), y);
                  objects = objectn;
                  x = x+5;
                  y=y+(i*200);
              }else{
                  if (i+1 == l){
                  curNode.links[letters[i]-offset] = new TrieNode(letters[i],true,tran);
                  GObject objectn  = new TestObject (""+letters[i],objects,(x)*(letters[i]-offset), y);
                  objects = objectn;
                  x = x+5;
                  y=y+(i*200);
                  }
              }
              curNode = curNode.links[letters[i]-offset];
              
            }
        }
    }
  
  public void event (GScene scene, int event, int x, int y)
  {
    if (event == GWindow.BUTTON1_UP ||
        event == GWindow.BUTTON2_UP) {
      boolean isSelected = event == GWindow.BUTTON1_UP;

      GSegment selectedSegment = scene_.findSegment (x, y);
      if (selectedSegment == null) return;
      
      GStyle style = selectedSegment.getOwner().getStyle();
      if (style == null) return;

      if (isSelected)
        style.setBackgroundColor (new Color ((float) Math.random(),
                                             (float) Math.random(),
                                             (float) Math.random()));
      else
        style.unsetBackgroundColor();
        
      scene_.refresh();
    }
  }
  
  

  private class TestObject extends GObject
  {
    private TestObject  parent_;
    private double      x_, y_;
    private GSegment    circle_;
    private GSegment    line_;

    
    TestObject (String name, GObject parent, double x, double y)
    {
      parent_ = parent instanceof TestObject ? (TestObject) parent : null;
      
      x_ = x;
      y_ = y;

      line_ = new GSegment();
      addSegment (line_);
      
      circle_ = new GSegment();
      addSegment (circle_);

      circle_.setText (new GText (name, GPosition.MIDDLE));

      setStyle (new GStyle());
      
      parent.add (this);
    }

    
    double getX()
    {
      return x_;
    }


    double getY()
    {
      return y_;
    }
    
    
    
    public void draw()
    {
      if (parent_ != null) 
        line_.setGeometry (parent_.getX(), parent_.getY(), x_, y_);
      
      circle_.setGeometryXy (Geometry.createCircle (x_, y_, 40.0));
    }
  }
  
    

  public static void main (String[] args) throws IOException
  {
    new Demo8();
  }
}