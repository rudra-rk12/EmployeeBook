package employeebook;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Menu extends JFrame implements ActionListener {

    JButton button1, button2, button3;
    JLabel name;

    public Menu(){

        button1 = new JButton("Enter Data");
        button2 = new JButton("Display Data");
        button3 = new JButton("Exit");

        name = new JLabel("EMPLOYEE BOOK");
        name.setFont(new Font("Lucida Handwriting", Font.PLAIN, 24));

        setTitle("EmployeeBook Application");
        setSize(320,250);
        setVisible(true);
        setResizable(false);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);

    }

    public void addComponent(){

        setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        g.gridx=0;
        g.gridy=0;
        g.weighty=0.1;
        g.anchor = g.CENTER;
        add(name, g);

        g.gridx = 0;
        g.gridy = 1;
        g.fill = g.HORIZONTAL;
        add(button1, g);

        g.gridx = 0;
        g.gridy = 2;
        g.fill = g.HORIZONTAL;
        add(button2, g);

        g.gridx = 0;
        g.gridy = 3;
        g.fill = g.HORIZONTAL;
        add(button3, g);
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource() == button1){

            EnterData obj = new EnterData();
            obj.addComponent();
            setVisible(false);
        }

        if(e.getSource()== button2){

            DisplayData obj = new DisplayData();
            obj.addComponent();
            setVisible(false);
        }

        if(e.getSource()== button3){

            this.dispose();
        }
    }
}
