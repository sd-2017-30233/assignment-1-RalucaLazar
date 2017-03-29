package GUI;

import JDBC.JDBC;
import model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Enumeration;

/**
 * Created by Raluca on 25.03.2017.
 */
public class Controller {

    View view;
    JDBC jdbc;
    Employee registeredEmployee;
    Admin registeredAdmin;

    public Controller(View view){
        this.view = view;
        view.addComboListener(new ComboListener());
        view.addOk1Listener(new Ok1Listener());
        view.addOk2Listener(new Ok2Listener());
        view.addBack1Listener(new BackListener());
        view.addBack2Listener(new BackListener());
        view.addEmployeeBtnListener(new EmloyeeRBListener());
        view.addAdministratorBtnListener(new AdministratorRBListener());
    }

    class ComboListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String comboBox = (String) view.combo.getSelectedItem();
            switch (comboBox) {
                case "Employee": {
                    view.panel1.setVisible (true);
                    view.setContentPane(view.panel1);
                    view.pack();
                }
                break;
                case "Administrator": {
                    view.panel2.setVisible (true);
                    view.setContentPane(view.panel2);
                    view.pack();
                }
            }
        }
    }

    class Ok1Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String username = view.usernameTextField.getText();
            String password = view.passwordField.getText();
            registeredEmployee = new Employee();
            registeredEmployee.setUsername(username);
            registeredEmployee.setPassword(password);
            jdbc = new JDBC();
            try {
                if (registeredEmployee.isValid(jdbc.conn)) {
                    registeredEmployee.setId(registeredEmployee.getEmployeeId(jdbc.conn,username,password));
                    view.panel3.setVisible(true);
                    view.setContentPane(view.panel3);
                    view.pack();
                }
                else view.invalid.setText("Invalid username or password.");
            }catch(Exception exception)
            {
                exception.printStackTrace();
            }
        }
    }

    class Ok2Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String username = view.usernameTextField1.getText();
            String password = view.passwordField1.getText();
            registeredAdmin = new Admin();
            registeredAdmin.setUsername(view.usernameTextField1.getText());
            registeredAdmin.setPassword(view.passwordField1.getText());
            jdbc = new JDBC();
            try {
                if (registeredAdmin.isValid(jdbc.conn)) {
                    registeredAdmin.setId(registeredAdmin.getAdminId(jdbc.conn,username,password));
                    view.panel4.setVisible(true);
                    view.setContentPane(view.panel4);
                    view.pack();
                }
                else view.invalid1.setText("Invalid username or password.");
            }catch(Exception exception)
            {
                exception.printStackTrace();
            }
        }
    }

    class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.panel0.setVisible (true);
            view.setContentPane(view.panel0);
            view.pack();
        }
    }

    class EmloyeeRBListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String selected = getSelectedButtonText(view.btnGroup);
            switch (selected) {
                case "Add client": {
                    JPanel myPanel = new JPanel();
                    JTextField nameField = new JTextField(5);
                    JTextField idCardField = new JTextField(5);
                    JTextField PNCField = new JTextField(5);
                    JTextField addressField = new JTextField(5);

                    myPanel.add(new JLabel("Name:"));
                    myPanel.add(nameField);
                    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
                    myPanel.add(new JLabel("Id card number:"));
                    myPanel.add(idCardField);
                    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
                    myPanel.add(new JLabel("PNC:"));
                    myPanel.add(PNCField);
                    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
                    myPanel.add(new JLabel("Address:"));
                    myPanel.add(addressField);

                    int result = JOptionPane.showConfirmDialog(null, myPanel,
                            "", JOptionPane.OK_CANCEL_OPTION);
                    if (result == JOptionPane.OK_OPTION) {
                        try {
                            jdbc = new JDBC();
                            Client client = new Client();
                            client.setName(nameField.getText());
                            client.setIdCardNumber(idCardField.getText());
                            client.setPNC(PNCField.getText());
                            client.setAddress(addressField.getText());
                            registeredEmployee.addClient(jdbc.conn, client);
                        }catch (Exception e1){
                            e1.printStackTrace();
                        }
                    }
                }
                break;
                case "Update client": {
                    String s = JOptionPane.showInputDialog(null, "Client id: ");
                    int id = Integer.parseInt(s);
                    JPanel myPanel = new JPanel();
                    JTextField nameField = new JTextField(5);
                    JTextField addressField = new JTextField(5);
                    myPanel.add(new JLabel("Name:"));
                    myPanel.add(nameField);
                    myPanel.add(new JLabel("Address:"));
                    myPanel.add(addressField);
                    int result = JOptionPane.showConfirmDialog(null, myPanel,
                            "", JOptionPane.OK_CANCEL_OPTION);
                    if (result == JOptionPane.OK_OPTION) {
                        try {
                            jdbc = new JDBC();
                            Client client = new Client();
                            client.setName(nameField.getText());
                            client.setAddress(addressField.getText());
                            registeredEmployee.updateClient(jdbc.conn, client, id);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }
                }
                break;
                case "View client information": {
                    String s = JOptionPane.showInputDialog(null, "Client id: ");
                    int id = Integer.parseInt(s);
                    try {
                        jdbc = new JDBC();
                        registeredEmployee.viewClient(jdbc.conn,id);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
                break;
                case "Create account": {
                    JPanel myPanel = new JPanel();
                    JTextField typeField = new JTextField(5);
                    JTextField amountidCardField = new JTextField(5);
                    JTextField clientIdField = new JTextField(5);

                    myPanel.add(new JLabel("Type:"));
                    myPanel.add(typeField);
                    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
                    myPanel.add(new JLabel("Amount:"));
                    myPanel.add(amountidCardField);
                    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
                    myPanel.add(new JLabel("Client id:"));
                    myPanel.add(clientIdField);

                    int result = JOptionPane.showConfirmDialog(null, myPanel,
                            "", JOptionPane.OK_CANCEL_OPTION);
                    if (result == JOptionPane.OK_OPTION) {
                        try {
                            jdbc = new JDBC();
                            Account account = new Account();
                            account.setType(typeField.getText());
                            account.setAmount(Float.parseFloat(amountidCardField.getText()));
                            account.setDate(LocalDate.now().toString());
                            account.setClientId(Integer.parseInt(clientIdField.getText()));
                            registeredEmployee.createAccount(jdbc.conn, account);
                        }catch (Exception e1){
                            e1.printStackTrace();
                        }
                    }
                }
                break;
                case "Update account": {
                    String s = JOptionPane.showInputDialog(null, "Account id: ");
                    int id = Integer.parseInt(s);
                    JPanel myPanel = new JPanel();
                    JTextField typeField = new JTextField(5);
                    JTextField amountField = new JTextField(5);
                    myPanel.add(new JLabel("Type:"));
                    myPanel.add(typeField);
                    myPanel.add(new JLabel("Amount:"));
                    myPanel.add(amountField);
                    int result = JOptionPane.showConfirmDialog(null, myPanel,
                            "", JOptionPane.OK_CANCEL_OPTION);
                    if (result == JOptionPane.OK_OPTION) {
                        try {
                            jdbc = new JDBC();
                            registeredEmployee.updateAccount(jdbc.conn, typeField.getText(),Float.parseFloat(amountField.getText()), id);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }
                }
                break;
                case "Delete account": {
                    String s = JOptionPane.showInputDialog(null, "Account id: ");
                    int id = Integer.parseInt(s);
                    try {
                        jdbc = new JDBC();
                        registeredEmployee.deleteAccount(jdbc.conn,id);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
                break;
                case "View account information": {
                    String s = JOptionPane.showInputDialog(null, "Account id: ");
                    int id = Integer.parseInt(s);
                    try {
                        jdbc = new JDBC();
                        registeredEmployee.viewAccount(jdbc.conn,id);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
                break;
                case "Transfer money between accounts": {
                    JPanel myPanel = new JPanel();
                    JTextField sourceField = new JTextField(5);
                    JTextField destField = new JTextField(5);
                    JTextField amountField = new JTextField(5);

                    myPanel.add(new JLabel("Source id:"));
                    myPanel.add(sourceField);
                    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
                    myPanel.add(new JLabel("Destination id:"));
                    myPanel.add(destField);
                    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
                    myPanel.add(new JLabel("Amount:"));
                    myPanel.add(amountField);

                    int result = JOptionPane.showConfirmDialog(null, myPanel,
                            "", JOptionPane.OK_CANCEL_OPTION);
                    if (result == JOptionPane.OK_OPTION) {
                        try {
                            jdbc = new JDBC();
                            int s = Integer.parseInt(sourceField.getText());
                            int d = Integer.parseInt(destField.getText());
                            float amount = Float.parseFloat(amountField.getText());
                            registeredEmployee.transferMoney(jdbc.conn, s,d,amount);
                        }catch (Exception e1){
                            e1.printStackTrace();
                        }
                    }
                }
                break;
                case "Process bill": {
                    JPanel myPanel = new JPanel();
                    JTextField clientIdField = new JTextField(5);
                    JTextField accountIdField = new JTextField(5);
                    JTextField amountField = new JTextField(5);

                    myPanel.add(new JLabel("Client id:"));
                    myPanel.add(clientIdField);
                    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
                    myPanel.add(new JLabel("Account id:"));
                    myPanel.add(accountIdField);
                    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
                    myPanel.add(new JLabel("Sum:"));
                    myPanel.add(amountField);

                    int result = JOptionPane.showConfirmDialog(null, myPanel,
                            "", JOptionPane.OK_CANCEL_OPTION);
                    if (result == JOptionPane.OK_OPTION) {
                        try {
                            jdbc = new JDBC();
                            int c = Integer.parseInt(clientIdField.getText());
                            int a = Integer.parseInt(accountIdField.getText());
                            float amount = Float.parseFloat(amountField.getText());
                            registeredEmployee.processBill(jdbc.conn, c,a,amount);
                        }catch (Exception e1){
                            e1.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    class AdministratorRBListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String selected = getSelectedButtonText(view.btnGroup1);
            Admin admin = new Admin();
            switch (selected) {
                case "Add employee": {
                    JPanel myPanel = new JPanel();
                    JTextField nameField = new JTextField(5);
                    JTextField usernameField = new JTextField(5);
                    JPasswordField passwordField = new JPasswordField(5);

                    myPanel.add(new JLabel("Name:"));
                    myPanel.add(nameField);
                    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
                    myPanel.add(new JLabel("Username:"));
                    myPanel.add(usernameField);
                    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
                    myPanel.add(new JLabel("Password:"));
                    myPanel.add(passwordField);

                    int result = JOptionPane.showConfirmDialog(null, myPanel,
                            "", JOptionPane.OK_CANCEL_OPTION);
                    if (result == JOptionPane.OK_OPTION) {
                        try {
                            jdbc = new JDBC();
                            Employee employee = new Employee();
                            employee.setName(nameField.getText());
                            employee.setUsername(usernameField.getText());
                            employee.setPassword(passwordField.getText());
                            registeredAdmin.addEmployee(jdbc.conn, employee);
                        }catch (Exception e1){
                            e1.printStackTrace();
                        }
                    }
                }
                break;
                case "Update employee": {
                    String s = JOptionPane.showInputDialog(null, "Employee id: ");
                    int id = Integer.parseInt(s);
                    JPanel myPanel = new JPanel();
                    JTextField nameField = new JTextField(5);
                    JTextField usernameField = new JTextField(5);
                    JPasswordField passwordField = new JPasswordField(5);

                    myPanel.add(new JLabel("Name:"));
                    myPanel.add(nameField);
                    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
                    myPanel.add(new JLabel("Username:"));
                    myPanel.add(usernameField);
                    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
                    myPanel.add(new JLabel("Password:"));
                    myPanel.add(passwordField);

                    int result = JOptionPane.showConfirmDialog(null, myPanel,
                            "", JOptionPane.OK_CANCEL_OPTION);
                    if (result == JOptionPane.OK_OPTION) {
                        try {
                            jdbc = new JDBC();
                            Employee employee = new Employee();
                            employee.setName(nameField.getText());
                            employee.setUsername(usernameField.getText());
                            employee.setPassword(passwordField.getText());
                            registeredAdmin.updateEmployee(jdbc.conn, employee, id);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }
                    }
                break;
                case "Delete employee": {
                    String s = JOptionPane.showInputDialog(null, "Employee id: ");
                    int id = Integer.parseInt(s);
                    try {
                        jdbc = new JDBC();
                        registeredAdmin.deleteEmployee(jdbc.conn,id);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
                break;
                case "View employee": {
                    String s = JOptionPane.showInputDialog(null, "Employee id: ");
                    int id = Integer.parseInt(s);
                    try {
                        jdbc = new JDBC();
                        registeredAdmin.viewEmployee(jdbc.conn,id);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
                break;
                case "Generate employee report": {
                    JPanel myPanel = new JPanel();
                    JTextField employeeIdField = new JTextField(5);
                    JTextField startDateField = new JTextField(5);
                    JTextField endDateField = new JTextField(5);

                    myPanel.add(new JLabel("Employee id:"));
                    myPanel.add(employeeIdField);
                    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
                    myPanel.add(new JLabel("Start date:"));
                    myPanel.add(startDateField);
                    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
                    myPanel.add(new JLabel("End date:"));
                    myPanel.add(endDateField);

                    int result = JOptionPane.showConfirmDialog(null, myPanel,
                            "", JOptionPane.OK_CANCEL_OPTION);
                    if (result == JOptionPane.OK_OPTION) {
                        try {
                            jdbc = new JDBC();
                            int id = Integer.parseInt(employeeIdField.getText());
                            registeredAdmin.viewReport(jdbc.conn, id,startDateField.getText(),endDateField.getText());
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }

}
