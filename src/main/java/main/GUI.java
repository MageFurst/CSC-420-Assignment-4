package main;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public class GUI {

    public void loadGUI() throws ExecutionException, InterruptedException {

        ArrayList<String> countries = new CountriesMap().countries;

        JFrame frame = new JFrame();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        JPanel holder = new JPanel();
        holder.setLayout(new MigLayout("align 50%"));
        JPanel flagsection = new JPanel();
        flagsection.setLayout(new MigLayout("top,center"));
        JPanel selectsection = new JPanel();
        selectsection.setLayout(new MigLayout("bottom,center"));
        JPanel loadingbar = new JPanel();
        loadingbar.setLayout(new MigLayout("align 50% 50%"));

        JProgressBar jpb = new JProgressBar();
        JLabel loadlabel = new JLabel();
        jpb.setIndeterminate(false);
        jpb.setMaximum(countries.size());

        loadingbar.add(jpb, "wrap");
        loadingbar.add(loadlabel,"center");
        frame.add(loadingbar);

        ImageLoaderWorker imageworker = new ImageLoaderWorker(countries, jpb, loadlabel, holder);
        imageworker.execute();

        frame.setVisible(true);

        JLabel picture = new JLabel();
        picture.setIcon(new ImageIcon());


        JLabel applicationtitle = new JLabel("Eurasia + Oceania Flag Selection Menu");
        applicationtitle.setFont(new Font("",Font.BOLD,28));
        JLabel countryhelp = new JLabel("Drag & drop from this menu, type, or paste a country's name into the text box below to see the corresponding country's flag.");

        JList countrieslist = new JList(countries.toArray());
        countrieslist.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        countrieslist.setDragEnabled(true);

        flagsection.add(picture);

        HashMap<String,BufferedImage> result = (HashMap)imageworker.get();

        CountryTextField countrytext = new CountryTextField("",20, result, picture);

        selectsection.add(applicationtitle, "center,span");
        selectsection.add(countryhelp, "center,span");
        selectsection.add(countrieslist, "center,span");
        selectsection.add(countrytext, "center,span");


        holder.add(selectsection,"span");
        holder.add(flagsection,"center,span");
        frame.add(holder);
        holder.setVisible(false);
        frame.setVisible(true);

    }
}
