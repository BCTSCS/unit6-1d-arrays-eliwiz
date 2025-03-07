package Data;
import Data.fileOperator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.*;

public class DataGUI extends JFrame {
    private JTextField inputArea;
    private JTextArea result;
    public static int counter = 0;
    private String[] albumArray = new String[498];
    private String[] artistArray = new String[498];
    private String[] genreArray = new String[498];




    public DataGUI() {
        try
    {
        File f = new File("./Data/albums.txt");
        Scanner albumFile = new Scanner(f);
        this.albumArray = fileOperator.fileToStringArray(498, albumFile);

        File f2 = new File("./Data/artists.txt");
        Scanner artistFile = new Scanner(f2);
        this.artistArray = fileOperator.fileToStringArray(498, artistFile);

        File f3 = new File("./Data/genres.txt");
        Scanner genreFile = new Scanner(f3);
        this.genreArray = fileOperator.fileToStringArray(498, genreFile);

    }catch(
    IOException e)
    { 
    e.printStackTrace();  // Prints error details for debugging
    System.out.println("Error reading files. Please check if the files exist.");
    }


        setTitle("Smart Playlist");
        setSize(1000, 400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputArea = new JTextField(20);
        JButton GenreButton = new JButton("Find most common genre");
        JButton ArtistButton = new JButton("Find most common artist");
        JButton AlbumbyArtistButton = new JButton("Find Albums an Artist released");
        JButton searchButton = new JButton("Save Search");
        result = new JTextArea(10, 40);
        result.setEditable(false);

        add(inputArea);
        add(ArtistButton);
        add(GenreButton);
        add(AlbumbyArtistButton);
        add(searchButton);
        add(result);

        GenreButton.addActionListener(e -> MCGenre());
        ArtistButton.addActionListener(e -> MCArtist());
        AlbumbyArtistButton.addActionListener(e -> AlbumByArtist());
        searchButton.addActionListener(e -> saveScreen());

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        DataGUI gui = new DataGUI();
        gui.setVisible(true);
    });
    }

    private void MCGenre() {
        String mcg = fileOperator.mostCommon(this.genreArray);
        result.setText("The most common genre is: "+ mcg);

    }

    private void MCArtist() {
        String mcg = fileOperator.mostCommon(this.artistArray);
        result.setText("The most common genre is: "+ mcg);
    }

    private void AlbumByArtist() {
        String[] album_list = fileOperator.findAlbumByArtist(inputArea.getText(), this.artistArray, this.albumArray);
        String formatted = "";
        System.out.println(album_list);
        for (String albums : album_list){
            formatted += "-"+albums +"\n";
        }
        result.setText(inputArea.getText() + " has released these albums:\n" + formatted);

    }

    public void saveScreen() {
        counter++;
        try {
            int w = result.getWidth();
            int h = result.getHeight();
            int type = BufferedImage.TYPE_INT_ARGB;
            BufferedImage sshot = new BufferedImage(w, h, type);

            Graphics2D g2d = sshot.createGraphics();
            result.paint(g2d);

            File out = new File("Search " + counter + ".png");
            ImageIO.write(sshot, "png", out);
            g2d.dispose();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
