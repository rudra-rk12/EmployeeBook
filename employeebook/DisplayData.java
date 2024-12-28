package employeebook;

import java.awt.event.ActionEvent;          
import java.awt.event.ActionListener;       
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.*;

public class DisplayData extends JFrame implements ActionListener
{

    JLabel lblEID, lblEName, lblDept, lblDesg, lblDOJ, lblDOB, lblMS, lblDOM;
    JButton btnSearch, btnCancel, btnClear;
    JTextField txtEID, txtEName, txtDept, txtDesg, txtDOJ, txtDOB, txtMS, txtDOM;


    public DisplayData()
    {
        lblEID = new JLabel("Employee ID:");
        lblEName = new JLabel("Employee Name:");
        lblDept = new JLabel("Department:");
        lblDesg = new JLabel("Designation:");
        lblDOJ = new JLabel("Date of Joining:");
        lblDOB = new JLabel("Date of Birth");
        lblMS = new JLabel("Marital Status:");
        lblDOM = new JLabel("Date of Marriage:");

        txtEID = new JTextField();

        txtEName = new JTextField();
        txtEName.setEditable(false);

        txtDept = new JTextField();
        txtDept.setEditable(false);

        txtDesg = new JTextField();
        txtDesg.setEditable(false);

        txtDOJ = new JTextField();
        txtDOJ.setEditable(false);

        txtDOB = new JTextField();
        txtDOB.setEditable(false);

        txtMS = new JTextField();
        txtMS.setEditable(false);

        txtDOM = new JTextField();
        txtDOM.setEditable(false);

        btnSearch = new JButton("Search");
        btnCancel = new JButton("Cancel");
        btnClear = new JButton("Clear");

        setTitle("The Employee Form");
        setSize(320,410);
        setVisible(true);

        btnSearch.addActionListener(this);
        btnCancel.addActionListener(this);
        btnClear.addActionListener(this);

        JOptionPane.showMessageDialog(this, "Enter Employee ID to display the data.");

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

        btnSearch.setBounds(10,340,80,25);
        add(btnSearch);

        btnCancel.setBounds(100,340,80,25);
        add(btnCancel);

        btnClear.setBounds(190, 340,80,25);
        add(btnClear);

        txtEID.setBounds(130,20,150,20);
        add(txtEID);

        txtEName.setBounds(130,60,150,20);
        add(txtEName);

        txtDept.setBounds(130,100,150,20);
        add(txtDept);

        txtDesg.setBounds(130,140,150,20);
        add(txtDesg);

        txtDOJ.setBounds(130,180,150,20);
        add(txtDOJ);

        txtDOB.setBounds(130,220,150,20);
        add(txtDOB);

        txtMS.setBounds(130,260,150,20);
        add(txtMS);

        txtDOM.setBounds(130,300,150,20);
        add(txtDOM);

        setResizable(false);

    }

    public void actionPerformed(ActionEvent e)
    {
        int flag = 0;
        if(e.getSource()==btnSearch)
        {
            String s=txtEID.getText();

            for(int i =0;i<EnterData.employeeDetails.length;i++)
            {
                if(s.equals(EnterData.employeeDetails[i][0]))
                {
                    flag = 1;
                    txtEName.setText(EnterData.employeeDetails[i][1].toString());
                    txtDept.setText(EnterData.employeeDetails[i][2].toString());
                    txtDesg.setText(EnterData.employeeDetails[i][3].toString());
                    txtDOJ.setText(EnterData.employeeDetails[i][4].toString());
                    txtDOB.setText(EnterData.employeeDetails[i][5].toString());
                    txtMS.setText(EnterData.employeeDetails[i][6].toString());
                    txtDOM.setText(EnterData.employeeDetails[i][7].toString());
                }
            }
            if(flag==0)
            {
                JOptionPane.showMessageDialog(this, "No Records Found");
            }
        }
        if(e.getSource() == btnCancel)
        {
            this.dispose();
            Menu m = new Menu();
            m.addComponent();
        }
        if(e.getSource()== btnClear)
        {
            txtEID.setText("");
            txtEName.setText("");
            txtDept.setText("");
            txtDesg.setText("");
            txtDOJ.setText("");
            txtDOB.setText("");
            txtMS.setText("");
            txtDOM.setText("");
        }
    }

}
