import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sebastian on 2017-04-07.
 */
public class PasswordTest extends JFrame implements ActionListener{

    private PanelHasla panelHasla;
    private JTextArea notatnik;
    private JScrollPane jScrollPane;
    private JButton bDodaj;

    PasswordTest(){
        setTitle("Demonstracja okna dialogowego");
        setSize(270,340);
        setLayout(null);
        setLocationRelativeTo(null);

        notatnik = new JTextArea();
        notatnik.setWrapStyleWord(true);
        jScrollPane = new JScrollPane(notatnik);
        jScrollPane.setBounds(20,20,200,200);

        bDodaj = new JButton("Dodaj Użytkownika");
        bDodaj.setBounds(70,230,150,20);

        add(jScrollPane);
        add(bDodaj);

        bDodaj.addActionListener(this);
    }

    //=============================================================================
    @Override
    public void actionPerformed(ActionEvent e) {
        if (panelHasla==null){
            panelHasla=new PanelHasla(this);
        }
        panelHasla.setVisible(true);
        panelHasla.setFocus();

        if (panelHasla.isOK()){
            notatnik.append(panelHasla.getlUser()+", ");
            notatnik.append(panelHasla.getPassword()+ "\n");
        }
    }

    //=============================================================================
    public static void main(String[] args) {
        PasswordTest app = new PasswordTest();
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}


class PanelHasla extends JDialog implements ActionListener{

    private JLabel lUser, lHaslo;
    private JTextField tUser;
    private  JPasswordField tHaslo;
    private JButton bOk, bCancel;
    private boolean okData;

    PanelHasla(JFrame owner){
        super(owner, "Wprowadzanie hasla", true);
        setSize(300,180);
        setLayout(null);
        setLocationRelativeTo(null);

        lUser = new JLabel("Użytkownik: ",JLabel.RIGHT);
        lUser.setBounds(0,10,100,20);
        add(lUser);

        tUser = new JTextField();
        tUser.setBounds(110,10,100,20);
        add(tUser);

        lHaslo = new JLabel("Hasło: ",JLabel.RIGHT);
        lHaslo.setBounds(0,50,100,20);
        add(lHaslo);

        tHaslo= new JPasswordField();
        tHaslo.setBounds(110,50,100,20);
        add(tHaslo);

        bOk = new JButton("OK");
        bOk.setBounds(40,90,80,20);
        add(bOk);
        bOk.addActionListener(this);

        bCancel= new JButton("Cancel");
        bCancel.setBounds(140,90,80,20);
        add(bCancel);
        bCancel.addActionListener(this);

        System.out.println(getPassword());
    }

    String getlUser() {
        return tUser.getText();
    }
    String getPassword(){

        return new String(tHaslo.getPassword());
    }
    boolean isOK(){
        return okData;
    }
    void setFocus(){
        tUser.requestFocusInWindow();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object s= e.getSource();

        if (s==bOk){okData=true;}
        else okData= false;

        setVisible(false);
    }
}
