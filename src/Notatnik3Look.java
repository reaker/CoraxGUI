
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by sebastian on 2017-04-08.
 */
public class Notatnik3Look extends JFrame implements ActionListener {

    private JButton bSzukaj, bColor;
    private JMenuBar menuBar;
    private JMenu menuPlik, menuNarzedzia, menuPomoc,menuOpcje, menuLookAndFeel;
    private JMenuItem mOtworz, mZapisz, mWyjscie, mNarz1, mNarz2, mOpcja1, mOProgramie, mpWklej, mpDolacz, mpKopiuj, mNimbus, mMetal, mWindows ;
    private JCheckBoxMenuItem chOpcja2;
    private JTextArea notatnik;
    private JTextField tSzukany;
    private JPopupMenu popup;
    private String wybranyTekst;
    private JComboBox colorCombo;
    private JColorChooser jColorChooser;

    private Notatnik3Look(){
        setTitle("Menu");
        setSize(400,400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setLocationRelativeTo(null);

        //Menu Bar
        menuBar = new JMenuBar();

        //Menu Plik
        menuPlik = new JMenu("Plik");

        mOtworz = new JMenuItem("Otwórz",'o');
        mOtworz.addActionListener(this);
        mOtworz.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));

        mZapisz = new JMenuItem("Zapisz", 'z');
        mZapisz.addActionListener(this);
        mZapisz.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));

        mWyjscie= new JMenuItem("Wyjscie",'w');
        mWyjscie.addActionListener(this);
        mWyjscie.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));

        menuPlik.add(mOtworz);
        menuPlik.add(mZapisz);
        menuPlik.addSeparator();
        menuPlik.add(mWyjscie);

        //Menu Narzedzia
        menuNarzedzia = new JMenu("Narzędzia");

        mNarz1 = new JMenuItem("Narzędzie 1");
        mNarz2 = new JMenuItem("Przelicznik metry na stopy");

        menuNarzedzia.add(mNarz1);
        menuNarzedzia.add(mNarz2);

        mNarz2.addActionListener(this);

        //Menu LookAndFeel
        menuLookAndFeel = new JMenu("Look and Feel");
        mWindows = new JMenuItem("Windows");
        mMetal = new JMenuItem("Metal");
        mNimbus = new JMenuItem("Nimbus");
        menuLookAndFeel.add(mMetal);
        menuLookAndFeel.add(mNimbus);
        menuLookAndFeel.add(mWindows);

        mMetal.addActionListener(this);
        mWindows.addActionListener(this);
        mNimbus.addActionListener(this);

        //Podmenu Opcje
        menuOpcje = new JMenu("Opcje");
        mOpcja1 = new JMenuItem("Opcja 1");
        chOpcja2 = new JCheckBoxMenuItem("Zablokuj Narzędzie 1");

        chOpcja2.addActionListener(this);
        menuOpcje.add(mOpcja1);
        menuOpcje.add(chOpcja2);

        menuNarzedzia.add(menuOpcje);

        //Menu Pomoc
        menuPomoc = new JMenu("Pomoc");

        mOProgramie = new JMenuItem("O programie");
        menuPomoc.add(mOProgramie);
        mOProgramie.addActionListener(this);

        //Notatnik
        notatnik = new JTextArea();
        JScrollPane scrollPane= new JScrollPane(notatnik);
        scrollPane.setBounds(50,50,300,300);
        add(scrollPane);

        //Szukanie tekstu
        tSzukany = new JTextField();
        tSzukany.setBounds(50,380,100,20);
        add(tSzukany);

        bSzukaj = new JButton("Szukaj");
        bSzukaj.setBounds(190,380,100,20);
        bSzukaj.addActionListener(this);
        add(bSzukaj);

        //Popup Menu
        popup = new JPopupMenu();
        mpDolacz = new JMenuItem("Dolacz");
        mpKopiuj = new JMenuItem("Kopiuj");
        mpWklej = new JMenuItem("Wklej");

        mpKopiuj.addActionListener(this);
        mpWklej.addActionListener(this);
        mpDolacz.addActionListener(this);

        popup.add(mpDolacz);
        popup.add(mpKopiuj);
        popup.add(mpWklej);

        notatnik.setComponentPopupMenu(popup);

        //Combo Box
        colorCombo = new JComboBox();
        colorCombo.setBounds(380,50,100,20);
        colorCombo.addItem("czarny");
        colorCombo.addItem("różowy");
        colorCombo.addItem("zielony");
        colorCombo.addItem("czerwony");
        colorCombo.addItem("niebieski");

        colorCombo.addActionListener(this);
        add(colorCombo);

        //Color chooser
        bColor = new JButton("Wybierz kolor");
        bColor.setBounds(390,380,100,20);
        bColor.addActionListener(this);
        add(bColor);




        setJMenuBar(menuBar);
        menuBar.add(menuPlik);
        menuBar.add(menuNarzedzia);
        menuBar.add(menuLookAndFeel);
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(menuPomoc);


    }


    //================================================================================================
    @Override
    public void actionPerformed(ActionEvent e) {
        Object s = e.getSource();

        //Akcja dla Otwórz
        if (s==mOtworz){
            JFileChooser fc = new JFileChooser();
            if (fc.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
                File plik = fc.getSelectedFile();
                //JOptionPane.showMessageDialog(null,"Wybrany plik to "+ plik.getAbsolutePath());

                Scanner scan;
                try {
                    scan = new Scanner(plik);
                    while (scan.hasNext()){
                        notatnik.append(scan.nextLine()+ "\n");

                    }
                    scan.close();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        }

        //Akcja dla Zapisz
        else if (s==mZapisz){
            JFileChooser fc= new JFileChooser();
            if (fc.showSaveDialog(null)==JFileChooser.APPROVE_OPTION){
                File plik = fc.getSelectedFile();
                //JOptionPane.showMessageDialog(null,"Wybrany plik to "+ plik.getAbsolutePath());

                PrintWriter printWriter;
                try {
                    printWriter = new PrintWriter(plik);
                    Scanner scanner = new Scanner(notatnik.getText());
                    while (scanner.hasNext()){
                        printWriter.println(scanner.nextLine() + "\n");
                    }
                    printWriter.close();

                } catch (FileNotFoundException e1) {e1.printStackTrace();}
            }
        }

        //Akcja dla Wyjście
        else if (s==mWyjscie){
            int odp = JOptionPane.showConfirmDialog(null,"Czy na pewno wyjść?", "Pytanie", JOptionPane.YES_NO_OPTION);
            if (odp==JOptionPane.YES_OPTION) dispose();
            else if (odp==JOptionPane.NO_OPTION){JOptionPane.showMessageDialog(null, "Wiedziałem...");}
        }

        //Akcja dla opcja2
        else if (s==chOpcja2){
            if (chOpcja2.isSelected()){
                mNarz1.setEnabled(false);
            }
            else mNarz1.setEnabled(true);
        }

        //Akcja dla O Programie
        else if (s==mOProgramie){
            JOptionPane.showMessageDialog(this,"Proram demonstruje wykorzystanie JMenuBar i JMenu\n Wersja 1.0","Pomoc",JOptionPane.INFORMATION_MESSAGE);
        }

        //Akcja dla Przelicznika mery na stopy
        else if (s==mNarz2) {
            String sMetry = JOptionPane.showInputDialog("Podaj dlugosc w metrzach");
            double metry = Double.parseDouble(sMetry);
            double stopy = metry /0.3048;
            String sStopy= String.format("%.2f", stopy);
            JOptionPane.showMessageDialog(null, metry+" metrów to "+sStopy + " stóp");
        }

        //Akcja dla Szukaj
        else if (s==bSzukaj){
            String tekst = notatnik.getText();
            String szukane = tSzukany.getText();
            String wystapienia = "";
            int i = 0;
            int index;
            int startIndex=0;

            while ((index= tekst.indexOf(szukane,startIndex))!=-1){
                startIndex=index+szukane.length();
                i++;
                wystapienia = wystapienia + " " + index;
            }
            JOptionPane.showMessageDialog(null,"Wyrażenie: \""+szukane + "\" wystąpiło: "+ i + " razy na indeksach: "+ wystapienia,"Szukaj",JOptionPane.INFORMATION_MESSAGE);
        }
        //Akcja dla Dołącz, Wklej, Kopiuj
        else if (s==mpDolacz){notatnik.append("\n" + wybranyTekst);}
        else if (s==mpWklej){notatnik.insert(wybranyTekst,notatnik.getCaretPosition());}
        else if (s==mpKopiuj){wybranyTekst = notatnik.getSelectedText();}

        //Akcja dla Combo Boxa
        else if (s==colorCombo){
            String color= colorCombo.getSelectedItem().toString();
            if (color.equals("zielony")){notatnik.setForeground(Color.GREEN);}
            else if (color.equals("czerwony")){notatnik.setForeground(Color.RED);}
            else if (color.equals("niebieski")){notatnik.setForeground(Color.BLUE);}
            else if (color.equals("czarny")){notatnik.setForeground(Color.BLACK);}
            else if (color.equals("różowy")){notatnik.setForeground(Color.PINK);}
        }
        //Akcja dla Color Chooser
        else if (s==bColor){
            Color wybranyKolor = JColorChooser.showDialog(null,"Wybierz kolor",Color.BLACK);
            notatnik.setForeground(wybranyKolor);
        }
        else if (s==mMetal){
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                SwingUtilities.updateComponentTreeUI(this);
            }  catch (Exception e1) {
                e1.printStackTrace();
            }

        }
        else if (s==mNimbus){
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                SwingUtilities.updateComponentTreeUI(this);
            }  catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        else if (s==mWindows){
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                SwingUtilities.updateComponentTreeUI(this);
            }  catch (Exception e1) {
                e1.printStackTrace();
            }

        }
    }





    //===================================================================================================
    public static void main(String[] args) {
        Notatnik3Look jMenuTest = new Notatnik3Look();
        jMenuTest.setVisible(true);
        jMenuTest.setSize(520,500);
    }
}
