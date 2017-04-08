import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

/**
 * Created by sebastian on 2017-04-07.
 */
public class PasswordFieldTest extends JFrame implements ActionListener{

    private JPasswordField pHaslo;



    PasswordFieldTest(){
        setTitle("Test hasła");
        setSize(400,400);
        setLayout(null);

        pHaslo= new JPasswordField();
        pHaslo.setBounds(50,50,150,20);
        pHaslo.setEchoChar('$');
        pHaslo.addActionListener(this);

        add(pHaslo);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, String.valueOf(pHaslo.getPassword()));

    }



    public static void main(String[] args) {
        PasswordFieldTest app = new PasswordFieldTest();
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}
