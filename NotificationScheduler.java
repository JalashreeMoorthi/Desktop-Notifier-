import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

public class NotificationScheduler {

    public static void startScheduler() {

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {

            public void run() {

                try {

                    Connection con = DBConnection.getConnection();

                    String currentDate =
                            LocalDate.now().toString();

                    String currentTime =
                            LocalTime.now().withNano(0).toString();

                    String query =
                            "SELECT * FROM notifications WHERE notify_date=? AND notify_time=?";

                    PreparedStatement ps =
                            con.prepareStatement(query);

                    ps.setString(1, currentDate);
                    ps.setString(2, currentTime);

                    ResultSet rs = ps.executeQuery();

                    while(rs.next()) {

                        String title = rs.getString("title");
                        String msg = rs.getString("message");

                        JOptionPane.showMessageDialog(
                                null,
                                msg,
                                title,
                                JOptionPane.INFORMATION_MESSAGE
                        );
                    }

                } catch(Exception e) {
                    e.printStackTrace();
                }
            }

        }, 0, 1000);
    }
}