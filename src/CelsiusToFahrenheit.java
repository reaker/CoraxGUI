import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.jar.JarFile;

/**
 * Created by sebastian on 2017-04-05.
 */
public class CelsiusToFahrenheit extends JFrame implements ActionListener{

    private JTextField tCelsius, tFahrentheit;
    private JLabel lCelsius, lFahrentheit;
    private double tempCelsius, tempFahrentheit;
    private JButton bConvert;
    private JCheckBox chBigFont;
    private ButtonGroup bgSize;
    private JRadioButton rbSmall, rbMiddle, rbBig;

    private CelsiusToFahrenheit(){


        setSize(400,300);
        setTitle("Celsius to Fahrentheit converter");
        setLayout(null);

        lCelsius = new JLabel("Celsius: ");
        lCelsius.setBounds(20,20, 150, 20);
        add(lCelsius);

        tCelsius = new JTextField("");
        tCelsius.setBounds(170,20,150,20);
        tCelsius.addActionListener(this);
        add(tCelsius);
        tCelsius.setToolTipText("Enter temperature in Celsius.");

        lFahrentheit= new JLabel("Fahrentheit: ");
        lFahrentheit.setBounds(20,70, 150, 20);
        add(lFahrentheit);

        tFahrentheit= new JTextField("");
        tFahrentheit.setBounds(170,70,150,20);
        add(tFahrentheit);

        bConvert = new JButton("Convert!");
        bConvert.setBounds(70,100,150,20);
        bConvert.addActionListener(this);
        add(bConvert);

        chBigFont = new JCheckBox("Big letters");
        chBigFont.setBounds(251,100,150,20);
        add(chBigFont);
        chBigFont.addActionListener(this);


        bgSize = new ButtonGroup();
        rbSmall = new JRadioButton("Small",true);
        rbSmall.setBounds(50,150,100,20);
        bgSize.add(rbSmall);
        add(rbSmall);
        rbSmall.addActionListener(this);

        rbMiddle = new JRadioButton("Middle");
        rbMiddle.setBounds(150,150,100,20);
        bgSize.add(rbMiddle);
        add(rbMiddle);
        rbMiddle.addActionListener(this);

        rbBig = new JRadioButton("Big");
        rbBig.setBounds(250,150,100,20);
        bgSize.add(rbBig);
        add(rbBig);
        rbBig.addActionListener(this);

    }

    public static void main(String[] args) {
        CelsiusToFahrenheit app = new CelsiusToFahrenheit();
        app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        app.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source==bConvert || source==tCelsius) {
            tempCelsius = Double.parseDouble(tCelsius.getText());
            tempFahrentheit = 32.0 + (9.0 / 5.0) * tempCelsius;

            tFahrentheit.setText("" + tempFahrentheit);
        }

        else if (source==rbSmall){
            tFahrentheit.setFont(new Font("SansSerif", Font.BOLD,8));
        }

        else if (source==rbMiddle){
            tFahrentheit.setFont(new Font("SansSerif", Font.BOLD,14));
        }
        else if (source==rbBig){
            tFahrentheit.setFont(new Font("SansSerif", Font.BOLD,20));
        }

        else if (source==chBigFont){
            if (chBigFont.isSelected()){  //true
                tFahrentheit.setFont(new Font("SansSerif", Font.BOLD,20));
            }
            else {                        //false
                tFahrentheit.setFont(new Font("SansSerif",Font.PLAIN,12));
            }
        }
    }
}

