package main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public class ImageLoaderWorker extends SwingWorker{

    ArrayList<String> imagelist;
    JProgressBar jpb;
    JLabel jl;
    JPanel jf;
    HashMap<String, BufferedImage> images;

    public ImageLoaderWorker(ArrayList<String> imagelist, JProgressBar jpb, JLabel jl, JPanel jFinal){
        this.imagelist = imagelist;
        this.jpb = jpb;
        this.jl = jl;
        this.jf = jFinal;
        images = new HashMap<>();
    }

    @Override
    protected HashMap doInBackground() {
        for(String country : imagelist){
            String imageURL = this.getClass().getClassLoader().getResource(country.replaceAll(" ", "_") + ".jpg").getFile();
            BufferedImage myPicture = null;
            try {
                myPicture = ImageIO.read(new File(imageURL));
                images.put(country, myPicture);
                jpb.setValue(imagelist.indexOf(country) + 1);
                jl.setText("Loading...(" + imagelist.indexOf(country) + "/" + imagelist.size() + ")");
                System.out.println(country);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return images;
    }

    @Override
    protected void done() {
        try {
            get();
            jpb.getParent().setVisible(false);
            jf.setVisible(true);
            jf.repaint();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }


}
