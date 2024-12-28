package employeebook;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class EnterData extends JFrame implements ActionListener, ItemListener
{
    JLabel lblEID, lblEName, lblDept, lblDesg, lblDOJ, lblDOB, lblMS, lblDOM;
    JButton btnSubmit, btnCancel;
    JTextField txtEID, txtEName, txtDesg, txtDOJ, txtDOB, txtDOM;
    @SuppressWarnings("rawtypes")
    JComboBox cmbDepart;
    JRadioButton rbtnMarr, rbtnSing;
    static int index =0;
    static String employeeDetails[][]=new String[100][8];
    String status;
    ButtonGroup bg;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public EnterData()
    {
        lblEID = new JLabel("Employee ID:");
        lblEName = new JLabel("Employee Name:");
        lblDept = new JLabel("Department:");
        lblDesg = new JLabel("Designation:");
        lblDOJ = new JLabel("Date of Joining:");
        lblDOB = new JLabel("Date of Birth");
        lblMS = new JLabel("Marital Status:");
        lblDOM = new JLabel("Date of Marriage:");
        lblDOM.setVisible(false);
        //https://www.youtube.com/watch?v=MUaHQKTHvlE
        btnSubmit = new JButton("Submit");
        btnCancel = new JButton("Cancel");

        txtEID = new JTextField();
        txtEName = new JTextField();
        txtDesg = new JTextField();
        txtDOJ = new JTextField();
        txtDOB = new JTextField();
        txtDOM = new JTextField();
        txtDOM.setVisible(false);

        cmbDepart = new JComboBox();
        cmbDepart.addItem("Select");
        cmbDepart.addItem("Admin");
        cmbDepart.addItem("IT");
        cmbDepart.addItem("Accounts");
        cmbDepart.addItem("HR");

        rbtnMarr = new JRadioButton("Married");
        rbtnSing = new JRadioButton("Single");



        bg = new ButtonGroup();
        bg.add(rbtnMarr);
        bg.add(rbtnSing);

        setTitle("The Employee Form");
        setSize(327,400);
        setVisible(true);

        btnSubmit.addActionListener(this);
        btnCancel.addActionListener(this);
        rbtnMarr.addItemListener(this);
        rbtnSing.addItemListener(this);
    }

    public void addComponent()
    {
        setLayout(null);

        lblEID.setBounds(10, 20, 100, 20);
        add(lblEID);

        lblEName.setBounds(10,60,100,20);
        add(lblEName);

        lblDept.setBounds(10,100,100,20);
        add(lblDept);

        lblDesg.setBounds(10,140,100,20);
        add(lblDesg);

        lblDOJ.setBounds(10,180,100,20);
        add(lblDOJ);

        lblDOB.setBounds(10,220,100,20);
        add(lblDOB);

        lblMS.setBounds(10,260,100,20);
        add(lblMS);

        lblDOM.setBounds(10,300,100,20);
        add(lblDOM);

        btnSubmit.setBounds(30,320,100,25);
        add(btnSubmit);

        btnCancel.setBounds(177,320,100,25);
        add(btnCancel);

        txtEID.setBounds(130,20,150,20);
        add(txtEID);

        txtEName.setBounds(130,60,150,20);
        add(txtEName);

        txtDesg.setBounds(130,140,150,20);
        add(txtDesg);

        txtDOJ.setBounds(130,180,150,20);
        add(txtDOJ);

        txtDOB.setBounds(130,220,150,20);
        add(txtDOB);

        txtDOM.setBounds(130,300,150,20);
        add(txtDOM);

        cmbDepart.setBounds(130,100,150,20);
        add(cmbDepart);

        rbtnMarr.setBounds(130,260,80,20);
        add(rbtnMarr);

        rbtnSing.setBounds(220,260,100,20);
        add(rbtnSing);

        setResizable(false);

    }

    public void actionPerformed(ActionEvent e)
    {

        if(e.getSource() == btnSubmit)
        {
            employeeDetails[index][0] = txtEID.getText();
            employeeDetails[index][1] = txtEName.getText();
            employeeDetails[index][2] = cmbDepart.getSelectedItem().toString();
            employeeDetails[index][3] = txtDesg.getText();
            employeeDetails[index][4] = txtDOJ.getText();
            employeeDetails[index][5] = txtDOB.getText();
            employeeDetails[index][6] = status;

            if(status.equals("Married"))
            {
                employeeDetails[index][7] = txtDOM.getText();
            }
            else
            {
                employeeDetails[index][7] = "NA";
            }

            JOptionPane.showMessageDialog(this, "Records have been saved");
            int n = JOptionPane.showConfirmDialog(this, "Do you want to add more records?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if(n == JOptionPane.YES_OPTION)
            {
                index++;
                EnterData obj = new EnterData();
                obj.addComponent();
                this.dispose();
                System.out.println(index);
            }
            else
            {
                this.dispose();
                Menu m = new Menu();
                m.addComponent();
            }
        }
        if(e.getSource() == btnCancel)
        {
            this.dispose();
            Menu m = new Menu();
            m.addComponent();
        }
    }
    public void itemStateChanged(ItemEvent e)
    {
        if(e.getSource() == rbtnMarr)
        {
            lblDOM.setVisible(true);
            txtDOM.setVisible(true);
            status = "Married";
        }
        else
        {
            lblDOM.setVisible(false);
            txtDOM.setVisible(false);
            status = "Single";
        }
    }

}
