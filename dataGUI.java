import javax.swing.*;
import java.awt.*;

public class dataGUI extends JFrame {

    public dataGUI(){
        setTitle("Notes App");
        setSize(600,600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("Simple GUI with TextFields");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        
        // Create a panel to hold components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));
        
        // Create labels and text fields
        JLabel label1 = new JLabel("First TextField:");
        JTextField textField1 = new JTextField(10);
        JLabel label2 = new JLabel("Second TextField:");
        JTextField textField2 = new JTextField(10);
        
        // Add components to the panel
        panel.add(label1);
        panel.add(textField1);
        panel.add(label2);
        panel.add(textField2);
        
        // Add panel to frame
        frame.add(panel);
        
        // Make frame visible
        frame.setVisible(true);
    }
}
