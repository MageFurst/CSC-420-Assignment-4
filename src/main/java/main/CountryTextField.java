package main;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class CountryTextField extends JTextField {

    String text;
    int columns;
    HashMap<String,BufferedImage> map;
    JLabel picturelabel;

    public CountryTextField(String text, int columns, HashMap<String, BufferedImage> map, JLabel picturelabel){
        this.text = text;
        this.columns = columns;
        this.map = map;
        this.picturelabel = picturelabel;
        this.setColumns(columns);

        this.getDocument().addDocumentListener(new TextChangeListener());

    }

    public class TextChangeListener implements DocumentListener{
        @Override
        public void changedUpdate(DocumentEvent e){
            handleTextChange();
        }
        @Override
        public void removeUpdate(DocumentEvent e){
            handleTextChange();
        }
        @Override
        public void insertUpdate(DocumentEvent e){
            handleTextChange();
        }
    }

    public void handleTextChange() {
        BufferedImage x = null;
        try {
            x = map.get(getText());
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        if(x != null){
            picturelabel.setIcon(new ImageIcon(x));
        }
        else {
            BufferedImage y = null;
            try{
                y = ImageIO.read(new File(this.getClass().getClassLoader().getResource("Unknown.jpg").getFile()));
            }
            catch(IOException exception){
                exception.printStackTrace();
            }
            picturelabel.setIcon(new ImageIcon(y));
        }
        picturelabel.repaint();
    }


}
