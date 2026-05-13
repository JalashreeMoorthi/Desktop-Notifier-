import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Dashboard extends JFrame implements ActionListener {

    JTextField titleField;
    JTextArea messageArea;
    JTextField dateField;
    JTextField timeField;
    JButton saveBtn;

    Dashboard() {

        setTitle("Desktop Notifier Dashboard");
        setSize(500,500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel l1 = new JLabel("Title:");
        l1.setBounds(50,40,100,30);
        add(l1);

        titleField = new JTextField();
        titleField.setBounds(150,40,250,30);
        add(titleField);

        JLabel l2 = new JLabel("Message:");
        l2.setBounds(50,100,100,30);
        add(l2);

        messageArea = new JTextArea();

        JScrollPane sp = new JScrollPane(messageArea);
        sp.setBounds(150,100,250,100);
        add(sp);

        JLabel l3 = new JLabel("Date (YYYY-MM-DD):");
        l3.setBounds(50,230,150,30);
        add(l3);

        dateField = new JTextField();
        dateField.setBounds(220,230,180,30);
        add(dateField);

        JLabel l4 = new JLabel("Time (HH:MM:SS):");
        l4.setBounds(50,290,150,30);
        add(l4);

        timeField = new JTextField();
        timeField.setBounds(220,290,180,30);
        add(timeField);

        saveBtn = new JButton("Save Notification");
        saveBtn.setBounds(150,370,180,40);
        saveBtn.addActionListener(this);
        add(saveBtn);

        setVisible(true);

        NotificationScheduler.startScheduler();
    }

    public void actionPerformed(ActionEvent e) {

        try {

            Connection con = DBConnection.getConnection();

            String query =
                    "INSERT INTO notifications(title,message,notify_date,notify_time) VALUES(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, titleField.getText());
            ps.setString(2, messageArea.getText());
            ps.setString(3, dateField.getText());
            ps.setString(4, timeField.getText());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this,
                    "Notification Saved");

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}