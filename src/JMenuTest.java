import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sebastian on 2017-04-06.
 */
public class JMenuTest extends JFrame implements ActionListener {

    private JMenuBar menuBar;
    private JMenu menuPlik, menuNarzedzia, menuPomoc,menuOpcje;
    private JMenuItem mOtworz, mZapisz, mWyjscie, mNarz1, mNarz2, mOpcja1, mOProgramie;
    private JCheckBoxMenuItem chOpcja2;

    private JMenuTest(){
        setTitle("Menu");
        setSize(400,400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setLocationRelativeTo(null);

        menuBar = new JMenuBar();
        menuPlik = new JMenu("Plik");

        mOtworz = new JMenuItem("Otwórsz",'o');
        mZapisz = new JMenuItem("Zapisz");
        mWyjscie= new JMenuItem("Wyjscie");

        mWyjscie.addActionListener(this);
        mWyjscie.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));

        menuPlik.add(mOtworz);
        menuPlik.add(mZapisz);
        menuPlik.addSeparator();
        menuPlik.add(mWyjscie);


        menuNarzedzia = new JMenu("Narzedzia");

        mNarz1 = new JMenuItem("Kolor");
        mNarz2 = new JMenuItem("polozenie");

        mNarz2.setEnabled(false);
        menuNarzedzia.add(mNarz1);
        menuNarzedzia.add(mNarz2);




            menuOpcje = new JMenu("Opcje");
            mOpcja1 = new JMenuItem("opcja 1");
            chOpcja2 = new JCheckBoxMenuItem("opcja 2");

            chOpcja2.addActionListener(this);
            menuOpcje.add(mOpcja1);
            menuOpcje.add(chOpcja2);

        menuNarzedzia.add(menuOpcje);



        menuPomoc = new JMenu("Pomoc");

        mOProgramie = new JMenuItem("O programie");

        menuPomoc.add(mOProgramie);

        mOProgramie.addActionListener(this);
        setJMenuBar(menuBar);
        menuBar.add(menuPlik);
        menuBar.add(menuNarzedzia);

        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(menuPomoc);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source==mWyjscie){dispose();}
        else if (source==chOpcja2){
            if (chOpcja2.isSelected()){
                mNarz1.setEnabled(true);
            }
            else mNarz1.setEnabled(false);
        }

        else if (source==mOProgramie){
            JOptionPane.showMessageDialog(this,"Proram demonstruje wykorzystanie JMenuBar i JMenu\n Wersja 1.0");
        }


    }


    public static void main(String[] args) {
        JMenuTest jMenuTest = new JMenuTest();
        jMenuTest.setVisible(true);
    }
}
