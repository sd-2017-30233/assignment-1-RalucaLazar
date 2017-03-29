package GUI;

/**
 * Created by Raluca on 25.03.2017.
 */

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class View extends JFrame {

    public JPanel panel0;
    public JPanel panel1;
    public JPanel panel2;
    public JPanel panel3;
    public JPanel panel4;
    public JLabel welcomeLabel;
    public JLabel signInLabel;
    public JLabel usernameLabel;
    public JLabel passwordLabel;
    public JLabel signInLabel1;
    public JLabel usernameLabel1;
    public JLabel passwordLabel1;
    public JLabel employeeLabel;
    public JLabel adminLabel;
    public JButton okButton;
    public JButton okButton1;
    public JButton okButton2;
    public JButton backButton1;
    public JButton backButton2;
    public JMenuBar jmenu;
    public JComboBox combo;
    public JPasswordField passwordField;
    public JTextField usernameTextField;
    public JPasswordField passwordField1;
    public JTextField usernameTextField1;

    public JButton performButton;
    public JRadioButton addCRB;
    public JRadioButton updateCRB;
    public JRadioButton viewCRB;
    public JRadioButton createARB;
    public JRadioButton updateARB;
    public JRadioButton deleteARB;
    public JRadioButton viewARB;
    public JRadioButton transferRB;
    public JRadioButton processRB;
    public JLabel actionsLabel;
    ButtonGroup btnGroup;

    public JButton performButton1;
    public JRadioButton addERB;
    public JRadioButton updateERB;
    public JRadioButton deleteERB;
    public JRadioButton viewERB;
    public JRadioButton generateRRB;
    public JLabel actionsLabel1;
    ButtonGroup btnGroup1;

    public JLabel invalid;
    public JLabel invalid1;


    public View() {
        //construct preComponents

        panel0 = new JPanel();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();

        panel0.setLayout (null);
        panel1.setLayout (null);
        panel2.setLayout (null);
        panel3.setLayout (null);
        panel4.setLayout (null);
        panel0.setVisible (true);
        panel1.setVisible (false);
        panel2.setVisible (false);
        panel3.setVisible (false);
        panel4.setVisible (false);

        panel0.setBackground(Color.lightGray);

        JMenu fileMenu = new JMenu ("File");
        JMenuItem exitItem = new JMenuItem ("Exit");
        fileMenu.add (exitItem);
        JMenu helpMenu = new JMenu ("Help");
        JMenuItem contentsItem = new JMenuItem ("Contents");
        helpMenu.add (contentsItem);
        JMenuItem aboutItem = new JMenuItem ("About");
        helpMenu.add (aboutItem);
        String[] comboItems = {"Employee", "Administrator"};

        Font font = new Font("Serif",Font.BOLD + Font.ITALIC,50);
        Font font1 = new Font("Serif",Font.ITALIC,30);

        welcomeLabel = new JLabel ("Welcome");
        okButton = new JButton ("Ok");
        okButton1 = new JButton ("Ok");
        okButton2 = new JButton ("Ok");
        backButton1 = new JButton ("Back");
        backButton2 = new JButton ("Back");
        jmenu = new JMenuBar();
        jmenu.add (fileMenu);
        jmenu.add (helpMenu);
        combo = new JComboBox (comboItems);
        signInLabel = new JLabel ("Sign in");
        usernameLabel = new JLabel ("Username:");
        passwordLabel = new JLabel ("Password:");
        usernameTextField = new JTextField (5);
        passwordField = new JPasswordField ();
        signInLabel1 = new JLabel ("Sign in");
        usernameLabel1 = new JLabel ("Username:");
        passwordLabel1 = new JLabel ("Password:");
        usernameTextField1 = new JTextField (5);
        passwordField1 = new JPasswordField ();
        employeeLabel = new JLabel("--Employee--");
        adminLabel = new JLabel("--Administrator--");
        btnGroup = new ButtonGroup();

        performButton = new JButton ("Perform");
        addCRB = new JRadioButton ("Add client");
        updateCRB = new JRadioButton ("Update client");
        viewCRB = new JRadioButton ("View client information");
        createARB = new JRadioButton ("Create account");
        updateARB = new JRadioButton ("Update account");
        deleteARB = new JRadioButton ("Delete account");
        viewARB = new JRadioButton ("View account information");
        transferRB = new JRadioButton ("Transfer money between accounts");
        processRB = new JRadioButton ("Process bill");
        actionsLabel = new JLabel ("Actions");
        btnGroup1 = new ButtonGroup();

        invalid = new JLabel ("");
        invalid.setForeground(Color.red);
        invalid1 = new JLabel ("");
        invalid1.setForeground(Color.red);

        btnGroup.add(addCRB);
        btnGroup.add(updateCRB);
        btnGroup.add(viewCRB);
        btnGroup.add(createARB);
        btnGroup.add(updateARB);
        btnGroup.add(deleteARB);
        btnGroup.add(viewARB);
        btnGroup.add(transferRB);
        btnGroup.add(processRB);

        performButton1 = new JButton ("Perform");
        addERB = new JRadioButton ("Add employee");
        updateERB = new JRadioButton ("Update employee");
        deleteERB = new JRadioButton ("Delete employee");
        viewERB = new JRadioButton ("View employee");
        generateRRB = new JRadioButton ("Generate employee report");
        actionsLabel1 = new JLabel ("Actions");
        btnGroup1.add(addERB);
        btnGroup1.add(updateERB);
        btnGroup1.add(deleteERB);
        btnGroup1.add(viewERB);
        btnGroup1.add(generateRRB);

        //adjust size and set layout
        setPreferredSize (new Dimension (784, 454));
        setLayout (null);

        //add components
        panel0.add (welcomeLabel);
        panel0.add (okButton);
        panel0.add (jmenu);
        panel0.add (combo);

        panel1.add (okButton1);
        panel1.add (backButton1);
        panel1.add(signInLabel);
        panel1.add(usernameLabel);
        panel1.add(passwordLabel);
        panel1.add(usernameTextField);
        panel1.add(passwordField);
        panel1.add(employeeLabel);
        panel1.add(invalid);

        panel2.add (okButton2);
        panel2.add (backButton2);
        panel2.add(signInLabel1);
        panel2.add(usernameLabel1);
        panel2.add(passwordLabel1);
        panel2.add(usernameTextField1);
        panel2.add(passwordField1);
        panel2.add(adminLabel);
        panel2.add(invalid1);

        panel3.add (performButton);
        panel3.add (addCRB);
        panel3.add (updateCRB);
        panel3.add (viewCRB);
        panel3.add (createARB);
        panel3.add (updateARB);
        panel3.add (deleteARB);
        panel3.add (viewARB);
        panel3.add (transferRB);
        panel3.add (processRB);
        panel3.add (actionsLabel);

        panel4.add (performButton1);
        panel4.add (addERB);
        panel4.add (updateERB);
        panel4.add (deleteERB);
        panel4.add (viewERB);
        panel4.add (generateRRB);
        panel4.add (actionsLabel1);

        //set component bounds (only needed by Absolute Positioning)
        welcomeLabel.setBounds (320, 70, 290, 70);
        welcomeLabel.setForeground(Color.DARK_GRAY);
        welcomeLabel.setFont(font);

        okButton.setBounds (365, 320, 67, 29);
        okButton1.setBounds (445, 305, 70, 30);
        okButton2.setBounds (445, 305, 70, 30);
        backButton1.setBounds (335, 305, 70, 30);
        backButton2.setBounds (335, 305, 70, 30);
        jmenu.setBounds (0, 0, 785, 25);
        combo.setBounds (350, 220, 100, 25);


        signInLabel.setBounds (380, 70, 100, 50);
        signInLabel.setFont(font1);
        employeeLabel.setBounds (390, 100, 100, 50);
        usernameLabel.setBounds (300, 180, 100, 25);
        usernameTextField.setBounds (380, 180, 145, 25);
        passwordLabel.setBounds (300, 220, 100, 25);
        passwordField.setBounds (380, 220, 145, 25);
        invalid.setBounds (350, 260, 200, 25);

        signInLabel1.setBounds (380, 70, 100, 50);
        signInLabel1.setFont(font1);
        adminLabel.setBounds (380, 100, 100, 50);
        usernameLabel1.setBounds (300, 180, 100, 25);
        usernameTextField1.setBounds (380, 180, 145, 25);
        passwordLabel1.setBounds (300, 220, 100, 25);
        passwordField1.setBounds (380, 220, 145, 25);
        invalid1.setBounds (350, 260, 200, 25);

        performButton.setBounds (330, 370, 100, 25);
        addCRB.setBounds (315, 75, 100, 25);
        updateCRB.setBounds (315, 105, 100, 25);
        viewCRB.setBounds (315, 135, 170, 25);
        createARB.setBounds (315, 165, 150, 25);
        updateARB.setBounds (315, 195, 145, 25);
        deleteARB.setBounds (315, 225, 130, 25);
        viewARB.setBounds (315, 255, 175, 25);
        transferRB.setBounds (315, 285, 225, 25);
        processRB.setBounds (315, 315, 100, 25);
        actionsLabel.setBounds (340, 20, 100, 25);

        performButton1.setBounds (345, 335, 100, 25);
        addERB.setBounds (315, 115, 170, 25);
        updateERB.setBounds (315, 150, 150, 25);
        deleteERB.setBounds (315, 185, 145, 25);
        viewERB.setBounds (315, 220, 130, 25);
        generateRRB.setBounds (315, 255, 175, 25);
        actionsLabel1.setBounds (370, 40, 100, 25);

        this.setJMenuBar(jmenu);
        this.setTitle("BankAccounts");
        this.setPreferredSize (new Dimension (784, 600));
        this.setResizable(false);
        this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel0);
        this.pack();
        this.setVisible (true);
    }


    void addComboListener(ActionListener mal)
    {
        okButton.addActionListener(mal);
    }

    void addOk1Listener(ActionListener mal)
    {
        okButton1.addActionListener(mal);
    }

    void addOk2Listener(ActionListener mal)
    {
        okButton2.addActionListener(mal);
    }

    void addBack1Listener(ActionListener mal)
    {
        backButton1.addActionListener(mal);
    }


    void addBack2Listener(ActionListener mal)
    {
        backButton2.addActionListener(mal);
    }

    void addEmployeeBtnListener(ActionListener mal)
    {
        performButton.addActionListener(mal);
    }

    void addAdministratorBtnListener(ActionListener mal)
    {
        performButton1.addActionListener(mal);
    }

}
