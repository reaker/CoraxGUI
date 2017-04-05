import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sebastian on 2017-04-05.
 */
public class RównanieGUI extends JFrame implements ActionListener {

    private JTextField  tA, tB, tC, tWynik;
    private JLabel info,lA, lB, lC;
    private JButton bWyjscie, bRozwiaz;


    private RównanieGUI(){
        setSize(450,250);
        setTitle("Rozwiazywanie rownania kwadratowehgo");
        setLayout(null);

        info = new JLabel("Wpisz wartosci a otrzymasz pierwiastki rownania kwadratowego");
        info.setBounds(10,10,400,30);
        add(info);

        lA = new JLabel("a", JLabel.RIGHT);
        lA.setBounds(10,50,30,20);
        tA=new JTextField();
        tA.setBounds(50,50,50,20);
        tA.setToolTipText("Podaj wspolczynnik a");
        add(tA);
        add(lA);

        lB = new JLabel("b", JLabel.RIGHT);
        lB.setBounds(110,50,30,20);
        tB=new JTextField();
        tB.setBounds(150,50,50,20);
        tB.setToolTipText("Podaj wspolczynnik b");
        add(tB);
        add(lB);

        lC = new JLabel("c", JLabel.RIGHT);
        lC.setBounds(210,50,30,20);
        tC=new JTextField();
        tC.setBounds(250,50,50,20);
        tC.setToolTipText("Podaj wspolczynnik c");
        add(tC);
        add(lC);

        bRozwiaz = new JButton("Rozwiaz rownanie");
        bRozwiaz.setBounds(40,110,140,20);
        add(bRozwiaz);
        bRozwiaz.addActionListener(this);

        bWyjscie = new JButton("Wyjscie");
        bWyjscie.setBounds(210,110,100,20);
        add(bWyjscie);
        bWyjscie.addActionListener(this);

        tWynik = new JTextField();
        tWynik.setBounds(15,150,400,20);
        add(tWynik);



    }

    public static void main(String[] args) {
        RównanieGUI app= new RównanieGUI();
        app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        app.setVisible(true);
        app.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source==bWyjscie){dispose();}
        else if (source==bRozwiaz){
            int a = Integer.parseInt(tA.getText());
            int b = Integer.parseInt(tB.getText());
            int c = Integer.parseInt(tC.getText());

            RównanieKwadratowe rownanie = new RównanieKwadratowe(a,b,c);
            String rozwiazanie = rownanie.solve();
            tWynik.setText(rozwiazanie);

        }
    }
}
