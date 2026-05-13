import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginPage extends JFrame implements ActionListener {

    JTextField userField;
    JPasswordField passField;
    JButton loginBtn;

    LoginPage() {

        setTitle("Login");
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

        loginBtn = new JButton("Login");
        loginBtn.setBounds(130,170,120,40);
        loginBtn.addActionListener(this);
        add(loginBtn);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {

            Connection con = DBConnection.getConnection();

            String query =
                    "SELECT * FROM users WHERE username=? AND password=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, userField.getText());
            ps.setString(2, passField.getText());

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                JOptionPane.showMessageDialog(this,
                        "Login Successful");

                new Dashboard();
                dispose();

            } else {

                JOptionPane.showMessageDialog(this,
                        "Invalid Username or Password");
            }

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}