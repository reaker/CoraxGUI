import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by sebastian on 2017-04-05.
 */
public class MojeOkienko extends JFrame implements ActionListener {

    private JButton showDate, bExit;
    private JLabel labelShowDate;

    private MojeOkienko(){
        setSize(300,200);
        setTitle("My frame");
        setLayout(null);
        showDate = new JButton("Show date");
        showDate.setBounds(50,50,100,30);
        add(showDate);
        showDate.addActionListener(this);

        bExit = new JButton("Exit");
        bExit.setBounds(155,50,100,30);
        add(bExit);
        bExit.addActionListener(this);

        labelShowDate = new JLabel("Date: ");
        labelShowDate.setBounds(50, 100, 250, 20);
        labelShowDate.setForeground(Color.RED);
        labelShowDate.setFont(new Font("Dialog",Font.ITALIC,12));
        add(labelShowDate);

    }

    public static void main(String[] args) {
        MojeOkienko mojeOkienko = new MojeOkienko();

        mojeOkienko.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mojeOkienko.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source==showDate) {
            //System.out.println(new Date());
            labelShowDate.setText("Date: "+ new Date());

        }
        else if (source==bExit){dispose();}
    }
}
