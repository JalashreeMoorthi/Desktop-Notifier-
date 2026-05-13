import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class RegisterPage extends JFrame implements ActionListener {

    JTextField userField;
    JPasswordField passField;
    JButton registerBtn, loginBtn;

    RegisterPage() {

        setTitle("Register");
        setSize(400,300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel l1 = new JLabel("Username:");
        l1.setBounds(50,50,100,30);
        add(l1);

        userField = new JTextField();
        userField.setBounds(150,50,150,30);
        add(userField);

        JLabel l2 = new JLabel("Password:");
        l2.setBounds(50,100,100,30);
        add(l2);

        passField = new JPasswordField();
        passField.setBounds(150,100,150,30);
        add(passField);

        registerBtn = new JButton("Register");
        registerBtn.setBounds(50,170,110,40);
        registerBtn.addActionListener(this);
        add(registerBtn);

        loginBtn = new JButton("Login");
        loginBtn.setBounds(190,170,110,40);
        loginBtn.addActionListener(this);
        add(loginBtn);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==registerBtn) {

            try {

                Connection con = DBConnection.getConnection();

                String query = "INSERT INTO users(username,password) VALUES(?,?)";

                PreparedStatement ps = con.prepareStatement(query);

                ps.setString(1, userField.getText());
                ps.setString(2, passField.getText());

                ps.executeUpdate();

                JOptionPane.showMessageDialog(this,
                        "Registration Successful");

            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }

        if(e.getSource()==loginBtn) {
            new LoginPage();
            dispose();
        }
    }
}