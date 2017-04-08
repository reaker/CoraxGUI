import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Created by sebastian on 2017-04-08.
 */
public class CelsiusToFahrenheitSuwak extends JFrame implements ChangeListener{

    private JLabel lCelsius, lFahrentheit;
    private JSlider sCelsius, sFahrentheit;
    private int tempCelsius, tempFahrentheit;

    private CelsiusToFahrenheitSuwak() {

        setSize(500, 300);
        setTitle("Celsius to Fahrentheit converter");
        setLayout(null);

        sCelsius = new JSlider(0,100,0);
        sCelsius.setBounds(50,50,300,50);
        sCelsius.setMajorTickSpacing(20);
        sCelsius.setMinorTickSpacing(5);
        sCelsius.setPaintLabels(true);
        sCelsius.setPaintTicks(true);
        add(sCelsius);
        sCelsius.addChangeListener(this);

        sFahrentheit = new JSlider(30,212,30);
        sFahrentheit.setBounds(50,150,300,50);
        sFahrentheit.setMajorTickSpacing(20);
        sFahrentheit.setMinorTickSpacing(5);
        sFahrentheit.setPaintLabels(true);
        sFahrentheit.setPaintTicks(true);
        add(sFahrentheit);
        sFahrentheit.setEnabled(false);
        sFahrentheit.addChangeListener(this);

        lCelsius = new JLabel("Celsius: 0");
        lCelsius.setBounds(380,40,300,50);
        add(lCelsius);

        lFahrentheit= new JLabel("Fahrentheit: 32");
        lFahrentheit.setBounds(380,140,300,50);
        add(lFahrentheit);
    }

    public static void main(String[] args) {
        CelsiusToFahrenheitSuwak app = new CelsiusToFahrenheitSuwak();
        app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        app.setVisible(true);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        Object s= e.getSource();
        if (s==sCelsius){
            tempCelsius=sCelsius.getValue();
            lCelsius.setText("Celsius: " + tempCelsius);
            tempFahrentheit = (int)Math.round((32.0+(9.0/5.0)*(double)tempCelsius));
            lFahrentheit.setText("Fahrentheit: " + tempFahrentheit );
            sFahrentheit.setValue(tempFahrentheit);
        }
    }
}


