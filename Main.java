import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import java.util.*;
import io.github.cdimascio.dotenv.Dotenv;

public class  Main{
    public static void main(String args[]) throws SQLException{
        Dotenv dotenv = Dotenv.load();
        String url = dotenv.get("DB_URL");
        String user = dotenv.get("DB_USER");
        String pwd = dotenv.get("DB_PASSWORD");

        JFrame frame = new JFrame("OOPs_Project");
        frame.setSize(800, 800);

        ImageIcon backgroundIcon = new ImageIcon("D:\\All_projects\\OOPs_internship_candidate_finder\\2.jpg");
        Image backgroundImg = backgroundIcon.getImage().getScaledInstance(800, 800, Image.SCALE_SMOOTH);
        backgroundIcon = new ImageIcon(backgroundImg);

        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setBounds(0, 0, 800, 800);

// Set the content pane to the background label
        frame.setContentPane(backgroundLabel);
        JLabel l1 = new JLabel("Choose from the below given options: ");
        l1.setBounds(250, 300, 300, 50);

// Set font properties
        Font font = new Font("Arial", Font.BOLD, 20); // You can change the font family, style, and size here
        l1.setFont(font);

// Set text color
        l1.setForeground(Color.BLACK); // You can choose any color

        frame.add(l1);

        // Button 1
        JButton b1 = new JButton("Want to Hire!");
        b1.setBounds(250, 350, 150, 50);

// Set button color
        b1.setBackground(Color.GRAY);

// Set text color
        b1.setForeground(Color.WHITE);

// Set font properties
        Font buttonFont = new Font("Arial", Font.BOLD, 16); // You can change the font family, style, and size here
        b1.setFont(buttonFont);

        frame.add(b1);

// Button 2
        JButton b2 = new JButton("Get Hired!");
        b2.setBounds(420, 350, 150, 50);

// Set button color
        b2.setBackground(Color.GRAY);

// Set text color
        b2.setForeground(Color.WHITE);

// Set font properties
        b2.setFont(buttonFont);

        frame.add(b2);



        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                // Want to Hire's Login or signUp page.

                JFrame frame1 = new JFrame("Want to hire ?");
                frame1.setSize(800, 800);
                JButton b1 = new JButton("Login");
                JButton b2 = new JButton("SignUp");

                b1.setBounds(350, 300, 100, 50);
                b2.setBounds(350, 400, 100, 50);

                frame1.add(b1);
                frame1.add(b2);
                frame1.setLayout(null);
                frame1.setVisible(true);
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                b1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frame1.dispose();
                        // Want to hire's login page.

                        JFrame frame = new JFrame("Login");
                        frame.setSize(800, 800);
                        JButton b = new JButton("Login");
                        JLabel userLabel, passLabel;
                        userLabel = new JLabel("Username: ");
                        passLabel = new JLabel("Password: ");
                        JLabel l3 = new JLabel(null, null, 0);

                        userLabel.setBounds(20, 50, 100, 30);
                        passLabel.setBounds(20, 100, 100, 30);
                        l3.setBounds(10, 200, 300, 30);
                        frame.add(l3);
                        frame.add(userLabel);
                        frame.add(passLabel);

                        b.setBounds(100, 160, 100, 30);

                        JTextField tfUsername = new JTextField("");
                        JPasswordField tfPassword = new JPasswordField("");
                        tfUsername.setBounds(120, 50, 100, 30);
                        tfPassword.setBounds(120, 100, 100, 30);

                        frame.add(tfUsername);
                        frame.add(tfPassword);
                        frame.add(b);

                        frame.setLayout(null);
                        frame.setVisible(true);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                        b.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {

                                int flag = 0;
                                final String[] userName = new String[1];

                                try{

                                    Class.forName("com.mysql.cj.jdbc.Driver");
                                    Connection conn = DriverManager.getConnection(url,user,pwd);

                                    String username = tfUsername.getText();
                                    String password = new String(tfPassword.getPassword());

                                    PreparedStatement ps = conn.prepareStatement("SELECT Name FROM hirerLogin WHERE Name=? AND Password=?");
                                    ps.setString(1, username);
                                    ps.setString(2, password);

                                    ResultSet rs = ps.executeQuery();

                                    if (rs.next()) {
                                        flag = 1;
                                        userName[0] = username;
                                    } else {
                                        l3.setText("LOGIN Failed!!");
                                    }
                                }
                                catch (SQLException s){
                                    s.printStackTrace();
                                } catch (ClassNotFoundException z) {
                                    throw new RuntimeException(z);
                                }

                                if (flag == 1){
                                    frame.dispose();
                                    // Want to hire's login page.

                                    JFrame frame = new JFrame("Profile");
                                    frame.setSize(800, 800);
                                    JButton b1 = new JButton("Available Interns");
                                    JButton b2 = new JButton("Modify profile");
                                    JButton b3 = new JButton("Delete profile");

                                    JLabel l = new JLabel(null, null ,0);
                                    JLabel l1 = new JLabel(null, null ,0);
                                    JLabel l2 = new JLabel(null, null, 0);
                                    JLabel l3 = new JLabel(null, null, 0);

                                    l.setBounds(20, 150, 400, 30);
                                    l1.setBounds(30, 200, 600, 150);
                                    l2.setBounds(20, 400, 400, 30);
                                    l3.setBounds(30, 450, 600, 300);
                                    frame.add(l);
                                    frame.add(l1);
                                    frame.add(l2);
                                    frame.add(l3);

                                    b1.setBounds(100, 50, 150, 30);
                                    b2.setBounds(300, 50, 150, 30);
                                    b3.setBounds(500, 50, 150, 30);

                                    frame.add(b1);
                                    frame.add(b2);
                                    frame.add(b3);

                                    frame.setLayout(null);
                                    frame.setVisible(true);
                                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                                    try {
                                        Class.forName("com.mysql.cj.jdbc.Driver");
                                        Connection conn = DriverManager.getConnection(url, user, pwd);

                                        Statement st = conn.createStatement();
                                        ResultSet rs = st.executeQuery("SELECT * FROM hirerLogin WHERE Name = '" + userName[0] + "'"); // Replace 'username' with the actual username

                                        if (rs.next()) {
                                            String name = rs.getString("Name");
                                            String pkg = rs.getString("Package");
                                            String location = rs.getString("Location");
                                            String course = rs.getString("Course");

                                            l.setText("Your Profile Info: ");
                                            l1.setText("<html> Name: " + name + "<br> Package: " + pkg + "<br> Location: " + location + "<br> Course: " + course + "</html>");

                                        }

                                    } catch (SQLException s) {
                                        s.printStackTrace();
                                    } catch (ClassNotFoundException z) {
                                        throw new RuntimeException(z);
                                    }


                                    b1.addActionListener(new ActionListener() {
                                        public void actionPerformed(ActionEvent e) {

                                            // Available Interns

                                            try {
                                                Class.forName("com.mysql.cj.jdbc.Driver");
                                                Connection conn = DriverManager.getConnection(url, user, pwd);

                                                String selectedHirer = userName[0];
                                                PreparedStatement ps = conn.prepareStatement("SELECT hiredLogin.Name, hiredLogin.Year, hiredLogin.Mail, hiredLogin.University, hiredLogin.Course, hiredLogin.Location FROM hiredLogin INNER JOIN hirerLogin ON (hiredLogin.Course = hirerLogin.Course OR hiredLogin.Location = hirerLogin.Location) AND hirerLogin.Name = ?");
                                                ps.setString(1, selectedHirer);
                                                ResultSet rs = ps.executeQuery();

                                                StringBuilder sb = new StringBuilder();
                                                int count = 0;

                                                while (rs.next()) {
                                                    count++;
                                                    sb.append("<html>Intern ").append(count).append(":<br>")
                                                            .append(" Name: ").append(rs.getString(1)).append("<br>")
                                                            .append(" Year: ").append(rs.getString(2)).append("<br>")
                                                            .append(" Mail: ").append(rs.getString(3)).append("<br>")
                                                            .append(" University: ").append(rs.getString(4)).append("<br>")
                                                            .append(" Course: ").append(rs.getString(5)).append("<br>")
                                                            .append(" Location: ").append(rs.getString(6)).append("<br><br></html>");
                                                }

                                                l2.setText("Available Feasible Interns are: ");
                                                l3.setText(sb.toString());


                                            } catch (SQLException s) {
                                                s.printStackTrace();
                                            } catch (ClassNotFoundException z) {
                                                throw new RuntimeException(z);
                                            }

                                        }
                                    });
                                    b2.addActionListener(new ActionListener() {
                                        public void actionPerformed(ActionEvent e) {

                                            // Modify Profile

                                            JFrame frame = new JFrame("Update_Profile");
                                            frame.setSize(800, 800);

                                            String[] cities = {"Bangalore", "Hyderabad", "Chennai", "Mumbai", "NCR", "Pune", "Kolkata", "Ahmedabad", "Chandigarh", "Jaipur"};
                                            String[] courses = {"ALL", "CSE", "IT", "AI", "E&TC", "MECH", "CHEM", "CIVIL", "INSTRU", "OTHER"};

                                            JButton b = new JButton("Update");
                                            JLabel packageLabel, passLabel, cityLabel, courseLabel;
                                            packageLabel = new JLabel("Package(Lacs): ");
                                            cityLabel = new JLabel("Location: ");
                                            courseLabel = new JLabel("Course: ");
                                            passLabel = new JLabel("Password: ");
                                            JLabel l3 = new JLabel(null, null, 0);

                                            packageLabel.setBounds(20, 100, 100, 30);
                                            cityLabel.setBounds(20, 150, 150, 30);
                                            courseLabel.setBounds(20, 200, 200, 30);
                                            passLabel.setBounds(20, 250, 250, 30);
                                            l3.setBounds(10, 350, 350, 30);
                                            frame.add(l3);
                                            frame.add(packageLabel);
                                            frame.add(cityLabel);
                                            frame.add(courseLabel);
                                            frame.add(passLabel);

                                            b.setBounds(100, 300, 100, 30);

                                            JTextField tfPackage = new JTextField("");
                                            JComboBox<String> Course = new JComboBox<>(courses);
                                            JComboBox<String> cityList = new JComboBox<>(cities);
                                            JPasswordField tfPassword = new JPasswordField("");
                                            tfPackage.setBounds(120, 100, 100, 30);
                                            Course.setBounds(120, 150, 100, 30);
                                            cityList.setBounds(120, 200, 100, 30);
                                            tfPassword.setBounds(120, 250, 100, 30);

                                            frame.add(tfPackage);
                                            frame.add(Course);
                                            frame.add(cityList);
                                            frame.add(tfPassword);
                                            frame.add(b);

                                            frame.setLayout(null);
                                            frame.setVisible(true);
                                            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                                            b.addActionListener(new ActionListener() {
                                                public void actionPerformed(ActionEvent e) {
                                                    try {

                                                        Class.forName("com.mysql.cj.jdbc.Driver");
                                                        Connection conn = DriverManager.getConnection(url, user, pwd);

                                                        String packages = tfPackage.getText();
                                                        String course = Course.getSelectedItem().toString();
                                                        String city = cityList.getSelectedItem().toString();
                                                        String password = new String(tfPassword.getPassword());

                                                        PreparedStatement ps = conn.prepareStatement("Update hirerLogin Set Package=?, Location=?, Course=?, Password=? where Name='" + userName[0] + "'");
                                                        ps.setString(1, packages);
                                                        ps.setString(2, city);
                                                        ps.setString(3, course);
                                                        ps.setString(4, password);
                                                        ps.executeUpdate();

                                                        l2.setText("Profile Updated Successfully!!");
                                                        l3.setText("Profile Updated Successfully!!");

                                                    } catch (SQLException s) {
                                                        s.printStackTrace();
                                                    } catch (ClassNotFoundException z) {
                                                        throw new RuntimeException(z);
                                                    }

                                                }
                                            });
                                        }
                                    });
                                    b3.addActionListener(new ActionListener() {
                                        public void actionPerformed(ActionEvent e) {

                                            // Delete Profile

                                            try {
                                                Class.forName("com.mysql.cj.jdbc.Driver");
                                                Connection conn = DriverManager.getConnection(url, user, pwd);

                                                PreparedStatement ps = conn.prepareStatement("Delete from hirerLogin where Name= '" + userName[0] + "'");
                                                ps.executeUpdate();

                                                l.setText("Oops, No Profile Found!!");
                                                l1.setText("");
                                                l2.setText("Profile Deleted Successfully!!");

                                            } catch (SQLException s) {
                                                s.printStackTrace();
                                            } catch (ClassNotFoundException z) {
                                                throw new RuntimeException(z);
                                            }

                                        }
                                    });
                                }
                            }
                        });
                    }
                });

                b2.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frame1.dispose();
                        // Want to hire's signUp page.

                        JFrame frame = new JFrame("SignUp");
                        frame.setSize(800, 800);

                        String[] cities = {"Bangalore", "Hyderabad", "Chennai", "Mumbai", "NCR", "Pune", "Kolkata", "Ahmedabad", "Chandigarh", "Jaipur"};
                        String[] courses = {"ALL", "CSE", "IT", "AI", "E&TC", "MECH", "CHEM", "CIVIL", "INSTRU", "OTHER"};

                        JButton b = new JButton("SignUp");
                        JLabel userLabel, packageLabel, passLabel, cityLabel, courseLabel;
                        userLabel = new JLabel("Username: ");
                        packageLabel = new JLabel("Package(Lacs): ");
                        cityLabel = new JLabel("Location: ");
                        courseLabel = new JLabel("Course: ");
                        passLabel = new JLabel("Password: ");
                        JLabel l3 = new JLabel(null, null, 0);

                        userLabel.setBounds(20, 50, 100, 30);
                        packageLabel.setBounds(20, 100, 100, 30);
                        courseLabel.setBounds(20, 150, 200, 30);
                        cityLabel.setBounds(20, 200, 150, 30);
                        passLabel.setBounds(20, 250, 250, 30);
                        l3.setBounds(10, 350, 350, 30);
                        frame.add(l3);
                        frame.add(userLabel);
                        frame.add(packageLabel);
                        frame.add(cityLabel);
                        frame.add(courseLabel);
                        frame.add(passLabel);

                        b.setBounds(100, 300, 100, 30);

                        JTextField tfUsername = new JTextField("");
                        JTextField tfPackage = new JTextField("");
                        JComboBox<String> Course = new JComboBox<>(courses);
                        JComboBox<String> cityList = new JComboBox<>(cities);
                        JPasswordField tfPassword = new JPasswordField("");
                        tfUsername.setBounds(120, 50, 100, 30);
                        tfPackage.setBounds(120, 100, 100, 30);
                        Course.setBounds(120, 150, 100, 30);
                        cityList.setBounds(120, 200, 100, 30);
                        tfPassword.setBounds(120, 250, 100, 30);

                        frame.add(tfUsername);
                        frame.add(tfPackage);
                        frame.add(Course);
                        frame.add(cityList);
                        frame.add(tfPassword);
                        frame.add(b);

                        frame.setLayout(null);
                        frame.setVisible(true);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                        b.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {

                                int flag1 = 0;
                                final String[] userName = new String[1];

                                try {

                                    Class.forName("com.mysql.cj.jdbc.Driver");
                                    Connection conn = DriverManager.getConnection(url, user, pwd);

                                    String username = tfUsername.getText();
                                    String packages = tfPackage.getText();
                                    String course = Course.getSelectedItem().toString();
                                    String city = cityList.getSelectedItem().toString();
                                    String password = new String(tfPassword.getPassword());

                                    PreparedStatement ps = conn.prepareStatement("Insert into hirerLogin(Name, Package, Location, Course, Password) values(?, ?, ?, ?, ?)");
                                    ps.setString(1, username);
                                    ps.setString(2, packages);
                                    ps.setString(3, city);
                                    ps.setString(4, course);
                                    ps.setString(5, password);
                                    ps.executeUpdate();

                                    l3.setText("Signed In Successfully!!");
                                    flag1 = 1;
                                    userName[0] = username;

                                } catch (SQLException s) {
                                    s.printStackTrace();
                                } catch (ClassNotFoundException z) {
                                    throw new RuntimeException(z);
                                }

                                if(flag1 == 1){
                                    frame.dispose();
                                    // Want to hire's Profile page.

                                    JFrame frame = new JFrame("Profile");
                                    frame.setSize(800, 800);
                                    JButton b1 = new JButton("Available Interns");
                                    JButton b2 = new JButton("Modify profile");
                                    JButton b3 = new JButton("Delete profile");
                                    JButton b4 = new JButton("Log out");

                                    JLabel l = new JLabel(null, null ,0);
                                    JLabel l1 = new JLabel(null, null ,0);
                                    JLabel l2 = new JLabel(null, null, 0);
                                    JLabel l3 = new JLabel(null, null, 0);

                                    l.setBounds(20, 150, 400, 30);
                                    l1.setBounds(30, 200, 600, 150);
                                    l2.setBounds(20, 400, 400, 30);
                                    l3.setBounds(30, 450, 600, 300);
                                    frame.add(l);
                                    frame.add(l1);
                                    frame.add(l2);
                                    frame.add(l3);

                                    b1.setBounds(100, 50, 150, 30);
                                    b2.setBounds(300, 50, 150, 30);
                                    b3.setBounds(500, 50, 150, 30);
                                    b4.setBounds(700, 50 , 150, 30);
                                    frame.add(b1);
                                    frame.add(b2);
                                    frame.add(b3);
                                    frame.add(b4);

                                    frame.setLayout(null);
                                    frame.setVisible(true);
                                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                                    try {
                                        Class.forName("com.mysql.cj.jdbc.Driver");
                                        Connection conn = DriverManager.getConnection(url, user, pwd);

                                        Statement st = conn.createStatement();
                                        ResultSet rs = st.executeQuery("SELECT * FROM hirerLogin WHERE Name = '" + userName[0] + "'"); // Replace 'username' with the actual username

                                        if (rs.next()) {
                                            String name = rs.getString("Name");
                                            String pkg = rs.getString("Package");
                                            String location = rs.getString("Location");
                                            String course = rs.getString("Course");

                                            l.setText("Your Profile Info: ");
                                            l1.setText("<html> Name: " + name + "<br> Package: " + pkg + "<br> Location: " + location + "<br> Course: " + course + "</html>");

                                        }

                                    } catch (SQLException s) {
                                        s.printStackTrace();
                                    } catch (ClassNotFoundException z) {
                                        throw new RuntimeException(z);
                                    }


                                    b1.addActionListener(new ActionListener() {
                                        public void actionPerformed(ActionEvent e) {

                                            // Available Interns

                                            try {
                                                Class.forName("com.mysql.cj.jdbc.Driver");
                                                Connection conn = DriverManager.getConnection(url, user, pwd);

                                                String selectedHirer = userName[0];
                                                PreparedStatement ps = conn.prepareStatement("SELECT hiredLogin.Name, hiredLogin.Year, hiredLogin.Mail, hiredLogin.University, hiredLogin.Course, hiredLogin.Location FROM hiredLogin INNER JOIN hirerLogin ON (hiredLogin.Course = hirerLogin.Course OR hiredLogin.Location = hirerLogin.Location) AND hirerLogin.Name = ?");
                                                ps.setString(1, selectedHirer);
                                                ResultSet rs = ps.executeQuery();

                                                StringBuilder sb = new StringBuilder();
                                                int count = 0;

                                                while (rs.next()) {
                                                    count++;
                                                    sb.append("<html>Intern ").append(count).append(":<br>")
                                                            .append(" Name: ").append(rs.getString(1)).append("<br>")
                                                            .append(" Year: ").append(rs.getString(2)).append("<br>")
                                                            .append(" Mail: ").append(rs.getString(3)).append("<br>")
                                                            .append(" University: ").append(rs.getString(4)).append("<br>")
                                                            .append(" Course: ").append(rs.getString(5)).append("<br>")
                                                            .append(" Location: ").append(rs.getString(6)).append("<br><br></html>");
                                                }

                                                l2.setText("Available Feasible Interns are: ");
                                                l3.setText(sb.toString());


                                            } catch (SQLException s) {
                                                s.printStackTrace();
                                            } catch (ClassNotFoundException z) {
                                                throw new RuntimeException(z);
                                            }

                                        }
                                    });
                                    b2.addActionListener(new ActionListener() {
                                        public void actionPerformed(ActionEvent e) {

                                            // Modify Profile

                                            JFrame frame = new JFrame("Update_Profile");
                                            frame.setSize(800, 800);

                                            String[] cities = {"Bangalore", "Hyderabad", "Chennai", "Mumbai", "NCR", "Pune", "Kolkata", "Ahmedabad", "Chandigarh", "Jaipur"};
                                            String[] courses = {"ALL", "CSE", "IT", "AI", "E&TC", "MECH", "CHEM", "CIVIL", "INSTRU", "OTHER"};

                                            JButton b = new JButton("Update");
                                            JLabel packageLabel, passLabel, cityLabel, courseLabel;
                                            packageLabel = new JLabel("Package(Lacs): ");
                                            cityLabel = new JLabel("Location: ");
                                            courseLabel = new JLabel("Course: ");
                                            passLabel = new JLabel("Password: ");
                                            JLabel l3 = new JLabel(null, null, 0);

                                            packageLabel.setBounds(20, 100, 100, 30);
                                            cityLabel.setBounds(20, 150, 150, 30);
                                            courseLabel.setBounds(20, 200, 200, 30);
                                            passLabel.setBounds(20, 250, 250, 30);
                                            l3.setBounds(10, 350, 350, 30);
                                            frame.add(l3);
                                            frame.add(packageLabel);
                                            frame.add(cityLabel);
                                            frame.add(courseLabel);
                                            frame.add(passLabel);

                                            b.setBounds(100, 300, 100, 30);

                                            JTextField tfPackage = new JTextField("");
                                            JComboBox<String> Course = new JComboBox<>(courses);
                                            JComboBox<String> cityList = new JComboBox<>(cities);
                                            JPasswordField tfPassword = new JPasswordField("");
                                            tfPackage.setBounds(120, 100, 100, 30);
                                            Course.setBounds(120, 150, 100, 30);
                                            cityList.setBounds(120, 200, 100, 30);
                                            tfPassword.setBounds(120, 250, 100, 30);

                                            frame.add(tfPackage);
                                            frame.add(Course);
                                            frame.add(cityList);
                                            frame.add(tfPassword);
                                            frame.add(b);

                                            frame.setLayout(null);
                                            frame.setVisible(true);
                                            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                                            b.addActionListener(new ActionListener() {
                                                public void actionPerformed(ActionEvent e) {
                                                    try {

                                                        Class.forName("com.mysql.cj.jdbc.Driver");
                                                        Connection conn = DriverManager.getConnection(url, user, pwd);

                                                        String packages = tfPackage.getText();
                                                        String course = Course.getSelectedItem().toString();
                                                        String city = cityList.getSelectedItem().toString();
                                                        String password = new String(tfPassword.getPassword());

                                                        PreparedStatement ps = conn.prepareStatement("Update hirerLogin Set Package=?, Location=?, Course=?, Password=? where Name='" + userName[0] + "'");
                                                        ps.setString(1, packages);
                                                        ps.setString(2, city);
                                                        ps.setString(3, course);
                                                        ps.setString(4, password);
                                                        ps.executeUpdate();

                                                        l2.setText("Profile Updated Successfully!!");
                                                        l3.setText("Profile Updated Successfully!!");

                                                    } catch (SQLException s) {
                                                        s.printStackTrace();
                                                    } catch (ClassNotFoundException z) {
                                                        throw new RuntimeException(z);
                                                    }

                                                }
                                            });
                                        }
                                    });
                                    b3.addActionListener(new ActionListener() {
                                        public void actionPerformed(ActionEvent e) {

                                            // Delete Profile

                                            try {
                                                Class.forName("com.mysql.cj.jdbc.Driver");
                                                Connection conn = DriverManager.getConnection(url, user, pwd);

                                                PreparedStatement ps = conn.prepareStatement("Delete from hirerLogin where Name= '" + userName[0] + "'");
                                                ps.executeUpdate();

                                                l.setText("Oops, No Profile Found!!");
                                                l1.setText("");
                                                l2.setText("Profile Deleted Successfully!!");

                                            } catch (SQLException s) {
                                                s.printStackTrace();
                                            } catch (ClassNotFoundException z) {
                                                throw new RuntimeException(z);
                                            }

                                        }
                                    });
                                }

                            }
                        });
                    }
                });
            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                // Want to get hired's login or signUp page.

                JFrame frame1 = new JFrame("Want to get hired ?");
                frame1.setSize(800, 800);
                JButton b1 = new JButton("Login");
                JButton b2 = new JButton("SignUp");

                b1.setBounds(350, 300, 100, 50);
                b2.setBounds(350, 400, 100, 50);

                frame1.add(b1);
                frame1.add(b2);
                frame1.setLayout(null);
                frame1.setVisible(true);
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                b1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frame1.dispose();
                        // Want to get hired's login page.

                        JFrame frame = new JFrame("Login");
                        frame.setSize(800, 800);
                        JButton b = new JButton("Login");
                        JLabel userLabel, passLabel;
                        userLabel = new JLabel("Username: ");
                        passLabel = new JLabel("Password: ");
                        JLabel l3 = new JLabel(null, null, 0);

                        userLabel.setBounds(20, 50, 100, 30);
                        passLabel.setBounds(20, 100, 100, 30);
                        l3.setBounds(10, 200, 300, 30);
                        frame.add(l3);
                        frame.add(userLabel);
                        frame.add(passLabel);

                        b.setBounds(100, 160, 100, 30);

                        JTextField tfUsername = new JTextField("");
                        JPasswordField tfPassword = new JPasswordField("");
                        tfUsername.setBounds(120, 50, 100, 30);
                        tfPassword.setBounds(120, 100, 100, 30);

                        frame.add(tfUsername);
                        frame.add(tfPassword);
                        frame.add(b);

                        frame.setLayout(null);
                        frame.setVisible(true);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                        b.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {

                                int flag2 = 0;
                                final String[] userName = new String[1];

                                try{

                                    Class.forName("com.mysql.cj.jdbc.Driver");
                                    Connection conn = DriverManager.getConnection(url,user,pwd);

                                    String username = tfUsername.getText();
                                    String password = new String(tfPassword.getPassword());

                                    PreparedStatement ps = conn.prepareStatement("SELECT Name FROM hiredLogin WHERE Name=? AND Password=?");
                                    ps.setString(1, username);
                                    ps.setString(2, password);

                                    ResultSet rs = ps.executeQuery();

                                    if (rs.next()) {
                                        flag2 = 1;
                                        userName[0] = username;
                                    } else {
                                        l3.setText("LOGIN Failed!!");
                                    }
                                }
                                catch (SQLException s){
                                    s.printStackTrace();
                                } catch (ClassNotFoundException z) {
                                    throw new RuntimeException(z);
                                }


                                if (flag2 == 1){
                                    frame.dispose();
                                    // Want to hire's login page.

                                    JFrame frame = new JFrame("Profile");
                                    frame.setSize(800, 800);
                                    JButton b1 = new JButton("Available Hirers");
                                    JButton b2 = new JButton("Modify Profile");
                                    JButton b3 = new JButton("Delete Profile");

                                    JLabel l = new JLabel(null, null ,0);
                                    JLabel l1 = new JLabel(null, null ,0);
                                    JLabel l2 = new JLabel(null, null, 0);
                                    JLabel l3 = new JLabel(null, null, 0);

                                    l.setBounds(20, 150, 400, 30);
                                    l1.setBounds(30, 200, 600, 150);
                                    l2.setBounds(20, 400, 400, 30);
                                    l3.setBounds(30, 450, 600, 300);
                                    frame.add(l);
                                    frame.add(l1);
                                    frame.add(l2);
                                    frame.add(l3);

                                    b1.setBounds(100, 50, 150, 30);
                                    b2.setBounds(300, 50, 150, 30);
                                    b3.setBounds(500, 50, 150, 30);

                                    frame.add(b1);
                                    frame.add(b2);
                                    frame.add(b3);

                                    frame.setLayout(null);
                                    frame.setVisible(true);
                                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                                    try {
                                        Class.forName("com.mysql.cj.jdbc.Driver");
                                        Connection conn = DriverManager.getConnection(url, user, pwd);

                                        Statement st = conn.createStatement();
                                        ResultSet rs = st.executeQuery("SELECT * FROM hiredLogin WHERE Name = '" + userName[0] + "'");

                                        if (rs.next()) {
                                            String name = rs.getString("Name");
                                            String year = rs.getString("Year");
                                            String mail = rs.getString("Mail");
                                            String uni = rs.getString("University");
                                            String course = rs.getString("Course");
                                            String city = rs.getString("Location");

                                            l.setText("Your Profile Info: ");
                                            l1.setText("<html> Name: " + name + "<br> Year: " + year + "<br> Mail: " + mail + "<br> University: " + uni +  "<br> Course: " + course + "<br> Location: " + city + "</html>");

                                        }

                                    } catch (SQLException s) {
                                        s.printStackTrace();
                                    } catch (ClassNotFoundException z) {
                                        throw new RuntimeException(z);
                                    }

                                    b1.addActionListener(new ActionListener() {
                                        public void actionPerformed(ActionEvent e) {

                                            // Available Hirers

                                            try {
                                                Class.forName("com.mysql.cj.jdbc.Driver");
                                                Connection conn = DriverManager.getConnection(url, user, pwd);

                                                String selectedHired = userName[0];
                                                PreparedStatement ps = conn.prepareStatement("SELECT hirerLogin.Name, hirerLogin.Package, hirerLogin.Location, hirerLogin.Course FROM hirerLogin INNER JOIN hiredLogin ON (hirerLogin.Course = hiredLogin.Course OR hirerLogin.Location = hiredLogin.Location) AND hiredLogin.Name = ?");
                                                ps.setString(1, selectedHired);
                                                ResultSet rs = ps.executeQuery();

                                                StringBuilder sb = new StringBuilder();
                                                int count = 0;

                                                while (rs.next()) {
                                                    count++;
                                                    sb.append("<html>Hirer ").append(count).append(":<br>")
                                                            .append(" Name: ").append(rs.getString(1)).append("<br>")
                                                            .append(" Package: ").append(rs.getString(2)).append("<br>")
                                                            .append(" Location: ").append(rs.getString(3)).append("<br>")
                                                            .append(" Course: ").append(rs.getString(4)).append("<br><br></html>");
                                                }

                                                l2.setText("Available Potential Hirers are: ");
                                                l3.setText(sb.toString());


                                            } catch (SQLException s) {
                                                s.printStackTrace();
                                            } catch (ClassNotFoundException z) {
                                                throw new RuntimeException(z);
                                            }

                                        }
                                    });
                                    b2.addActionListener(new ActionListener() {
                                        public void actionPerformed(ActionEvent e) {

                                            // Modify Profile

                                            JFrame frame = new JFrame("Update_Profile");
                                            frame.setSize(800, 800);

                                            String[] cities = {"Bangalore", "Hyderabad", "Chennai", "Mumbai", "NCR", "Pune", "Kolkata", "Ahmedabad", "Chandigarh", "Jaipur"};
                                            String[] courses = {"CSE", "IT", "AI", "E&TC", "MECH", "CHEM", "CIVIL", "INSTRU", "OTHER"};

                                            JButton b = new JButton("Update");
                                            JLabel yearLabel, mailLabel, passLabel, unilabel, courseLabel, cityLabel;
                                            yearLabel = new JLabel("Year: ");
                                            mailLabel = new JLabel("Mail: ");
                                            unilabel = new JLabel("University: ");
                                            courseLabel = new JLabel("Course: ");
                                            cityLabel = new JLabel("Location: ");
                                            passLabel = new JLabel("Password: ");
                                            JLabel l3 = new JLabel(null, null, 0);

                                            yearLabel.setBounds(20, 100, 100, 30);
                                            mailLabel.setBounds(20, 150, 100, 30);
                                            unilabel.setBounds(20, 200, 100, 30);
                                            courseLabel.setBounds(20, 250, 100, 30);
                                            cityLabel.setBounds(20, 300, 100, 30);
                                            passLabel.setBounds(20, 350, 100, 30);
                                            l3.setBounds(10, 450, 450, 30);
                                            frame.add(l3);
                                            frame.add(yearLabel);
                                            frame.add(mailLabel);
                                            frame.add(unilabel);
                                            frame.add(courseLabel);
                                            frame.add(cityLabel);
                                            frame.add(passLabel);

                                            b.setBounds(100, 400, 100, 30);

                                            JTextField tfYear = new JTextField("");
                                            JTextField tfMail = new JTextField("");
                                            JTextField tfUni = new JTextField("");
                                            JComboBox<String> Course = new JComboBox<>(courses);
                                            JComboBox<String> cityList = new JComboBox<>(cities);
                                            JPasswordField tfPassword = new JPasswordField("");

                                            tfYear.setBounds(120, 100, 100, 30);
                                            tfMail.setBounds(120, 150, 100, 30);
                                            tfUni.setBounds(120, 200, 100, 30);
                                            Course.setBounds(120, 250, 100, 30);
                                            cityList.setBounds(120, 300, 100, 30);
                                            tfPassword.setBounds(120, 350, 100, 30);

                                            frame.add(tfYear);
                                            frame.add(tfMail);
                                            frame.add(tfUni);
                                            frame.add(Course);
                                            frame.add(cityList);
                                            frame.add(tfPassword);
                                            frame.add(b);

                                            frame.setLayout(null);
                                            frame.setVisible(true);
                                            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                                            b.addActionListener(new ActionListener() {
                                                public void actionPerformed(ActionEvent e) {
                                                    try {

                                                        Class.forName("com.mysql.cj.jdbc.Driver");
                                                        Connection conn = DriverManager.getConnection(url, user, pwd);

                                                        String year = tfYear.getText();
                                                        String mail = tfMail.getText();
                                                        String uni = tfUni.getText();
                                                        String course = Course.getSelectedItem().toString();
                                                        String city = cityList.getSelectedItem().toString();
                                                        String password = new String(tfPassword.getPassword());

                                                        PreparedStatement ps = conn.prepareStatement("Update hiredLogin Set Year=?, Mail=?, University=?, Course=?, Location=?, Password=? where Name='" + userName[0] + "'");
                                                        ps.setString(1, year);
                                                        ps.setString(2, mail);
                                                        ps.setString(3, uni);
                                                        ps.setString(4, course);
                                                        ps.setString(5, city);
                                                        ps.setString(6, password);
                                                        ps.executeUpdate();

                                                        l2.setText("Profile Updated Successfully!!");
                                                        l3.setText("Profile Updated Successfully!!");

                                                    } catch (SQLException s) {
                                                        s.printStackTrace();
                                                    } catch (ClassNotFoundException z) {
                                                        throw new RuntimeException(z);
                                                    }

                                                }
                                            });
                                        }
                                    });
                                    b3.addActionListener(new ActionListener() {
                                        public void actionPerformed(ActionEvent e) {

                                            // Delete Profile

                                            try {
                                                Class.forName("com.mysql.cj.jdbc.Driver");
                                                Connection conn = DriverManager.getConnection(url, user, pwd);

                                                PreparedStatement ps = conn.prepareStatement("Delete from hiredLogin where Name= '" + userName[0] + "'");
                                                ps.executeUpdate();

                                                l.setText("Oops, No Profile Found!!");
                                                l1.setText("");
                                                l2.setText("Profile Deleted Successfully!!");

                                            } catch (SQLException s) {
                                                s.printStackTrace();
                                            } catch (ClassNotFoundException z) {
                                                throw new RuntimeException(z);
                                            }

                                        }
                                    });
                                }
                            }
                        });
                    }
                });

                b2.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frame1.dispose();
                        // Want to get hired's signUp page.

                        JFrame frame = new JFrame("SignUp");
                        frame.setSize(800, 800);

                        String[] cities = {"Bangalore", "Hyderabad", "Chennai", "Mumbai", "NCR", "Pune", "Kolkata", "Ahmedabad", "Chandigarh", "Jaipur"};
                        String[] courses = {"CSE", "IT", "AI", "E&TC", "MECH", "CHEM", "CIVIL", "INSTRU", "OTHER"};

                        JButton b = new JButton("SignUp");
                        JLabel userLabel, yearLabel, mailLabel, passLabel, unilabel, courseLabel, cityLabel;
                        userLabel = new JLabel("Username: ");
                        yearLabel = new JLabel("Year: ");
                        mailLabel = new JLabel("Mail: ");
                        unilabel = new JLabel("University: ");
                        courseLabel = new JLabel("Course: ");
                        cityLabel = new JLabel("Location: ");
                        passLabel = new JLabel("Password: ");
                        JLabel l3 = new JLabel(null, null, 0);

                        userLabel.setBounds(20, 50, 100, 30);
                        yearLabel.setBounds(20, 100, 100, 30);
                        mailLabel.setBounds(20, 150, 100, 30);
                        unilabel.setBounds(20, 200, 100, 30);
                        courseLabel.setBounds(20, 250, 100, 30);
                        cityLabel.setBounds(20, 300, 100, 30);
                        passLabel.setBounds(20, 350, 100, 30);
                        l3.setBounds(10, 450, 450, 30);
                        frame.add(l3);
                        frame.add(userLabel);
                        frame.add(yearLabel);
                        frame.add(mailLabel);
                        frame.add(unilabel);
                        frame.add(courseLabel);
                        frame.add(cityLabel);
                        frame.add(passLabel);

                        b.setBounds(100, 400, 100, 30);

                        JTextField tfUsername = new JTextField("");
                        JTextField tfYear = new JTextField("");
                        JTextField tfMail = new JTextField("");
                        JTextField tfUni = new JTextField("");
                        JComboBox<String> Course = new JComboBox<>(courses);
                        JComboBox<String> cityList = new JComboBox<>(cities);
                        JPasswordField tfPassword = new JPasswordField("");

                        tfUsername.setBounds(120, 50, 100, 30);
                        tfYear.setBounds(120, 100, 100, 30);
                        tfMail.setBounds(120, 150, 100, 30);
                        tfUni.setBounds(120, 200, 100, 30);
                        Course.setBounds(120, 250, 100, 30);
                        cityList.setBounds(120, 300, 100, 30);
                        tfPassword.setBounds(120, 350, 100, 30);

                        frame.add(tfUsername);
                        frame.add(tfYear);
                        frame.add(tfMail);
                        frame.add(tfUni);
                        frame.add(Course);
                        frame.add(cityList);
                        frame.add(tfPassword);
                        frame.add(b);

                        frame.setLayout(null);
                        frame.setVisible(true);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                        b.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {

                                int flag3 = 0;
                                final String[] userName = new String[1];

                                try {

                                    // Want to get hired's signUp page.

                                    Class.forName("com.mysql.cj.jdbc.Driver");
                                    Connection conn = DriverManager.getConnection(url, user, pwd);

                                    String username = tfUsername.getText();
                                    String year = tfYear.getText();
                                    String mail = tfMail.getText();
                                    String uni = tfUni.getText();
                                    String course = Course.getSelectedItem().toString();
                                    String city = cityList.getSelectedItem().toString();
                                    String password = new String(tfPassword.getPassword());

                                    PreparedStatement ps = conn.prepareStatement("Insert into hiredLogin(Name, Year, Mail, University, Course, Location, Password) values(?, ?, ?, ?, ?, ?, ?)");
                                    ps.setString(1,username);
                                    ps.setString(2,year);
                                    ps.setString(3,mail);
                                    ps.setString(4,uni);
                                    ps.setString(5,course);
                                    ps.setString(6,city);
                                    ps.setString(7,password);
                                    ps.executeUpdate();

                                    l3.setText("Signed In Successfully!!");
                                    flag3 = 1;
                                    userName[0] = username;

                                } catch (SQLException s) {
                                    s.printStackTrace();
                                } catch (ClassNotFoundException z) {
                                    throw new RuntimeException(z);
                                }

                                if(flag3 == 1){
                                    frame.dispose();
                                    // Want to hire's Profile page.

                                    JFrame frame = new JFrame("Profile");
                                    frame.setSize(800, 800);
                                    JButton b1 = new JButton("Available Interns");
                                    JButton b2 = new JButton("Modify profile");
                                    JButton b3 = new JButton("Delete profile");

                                    JLabel l = new JLabel(null, null ,0);
                                    JLabel l1 = new JLabel(null, null ,0);
                                    JLabel l2 = new JLabel(null, null, 0);
                                    JLabel l3 = new JLabel(null, null, 0);

                                    l.setBounds(20, 150, 400, 30);
                                    l1.setBounds(30, 200, 600, 150);
                                    l2.setBounds(20, 400, 400, 30);
                                    l3.setBounds(30, 450, 600, 300);
                                    frame.add(l);
                                    frame.add(l1);
                                    frame.add(l2);
                                    frame.add(l3);

                                    b1.setBounds(100, 50, 150, 30);
                                    b2.setBounds(300, 50, 150, 30);
                                    b3.setBounds(500, 50, 150, 30);

                                    frame.add(b1);
                                    frame.add(b2);
                                    frame.add(b3);

                                    frame.setLayout(null);
                                    frame.setVisible(true);
                                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                                    try {
                                        Class.forName("com.mysql.cj.jdbc.Driver");
                                        Connection conn = DriverManager.getConnection(url, user, pwd);

                                        Statement st = conn.createStatement();
                                        ResultSet rs = st.executeQuery("SELECT * FROM hiredLogin WHERE Name = '" + userName[0] + "'");

                                        if (rs.next()) {
                                            String name = rs.getString("Name");
                                            String year = rs.getString("Year");
                                            String mail = rs.getString("Mail");
                                            String uni = rs.getString("University");
                                            String course = rs.getString("Course");
                                            String city = rs.getString("Location");

                                            l.setText("Your Profile Info: ");
                                            l1.setText("<html> Name: " + name + "<br> Year: " + year + "<br> Mail: " + mail + "<br> University: " + uni +  "<br> Course: " + course + "<br> Location: " + city + "</html>");

                                        }

                                    } catch (SQLException s) {
                                        s.printStackTrace();
                                    } catch (ClassNotFoundException z) {
                                        throw new RuntimeException(z);
                                    }

                                    b1.addActionListener(new ActionListener() {
                                        public void actionPerformed(ActionEvent e) {

                                            // Available Hirers

                                            try {
                                                Class.forName("com.mysql.cj.jdbc.Driver");
                                                Connection conn = DriverManager.getConnection(url, user, pwd);

                                                String selectedHired = userName[0];
                                                PreparedStatement ps = conn.prepareStatement("SELECT hirerLogin.Name, hirerLogin.Package, hirerLogin.Location, hirerLogin.Course FROM hirerLogin INNER JOIN hiredLogin ON (hirerLogin.Course = hiredLogin.Course OR hirerLogin.Location = hiredLogin.Location) AND hiredLogin.Name = ?");
                                                ps.setString(1, selectedHired);
                                                ResultSet rs = ps.executeQuery();

                                                StringBuilder sb = new StringBuilder();
                                                int count = 0;

                                                while (rs.next()) {
                                                    count++;
                                                    sb.append("<html>Hirer ").append(count).append(":<br>")
                                                            .append(" Name: ").append(rs.getString(1)).append("<br>")
                                                            .append(" Package: ").append(rs.getString(2)).append("<br>")
                                                            .append(" Location: ").append(rs.getString(3)).append("<br>")
                                                            .append(" Course: ").append(rs.getString(4)).append("<br><br></html>");
                                                }

                                                l2.setText("Available Potential Hirers are: ");
                                                l3.setText(sb.toString());


                                            } catch (SQLException s) {
                                                s.printStackTrace();
                                            } catch (ClassNotFoundException z) {
                                                throw new RuntimeException(z);
                                            }

                                        }
                                    });
                                    b2.addActionListener(new ActionListener() {
                                        public void actionPerformed(ActionEvent e) {

                                            // Modify Profile

                                            JFrame frame = new JFrame("Update_Profile");
                                            frame.setSize(800, 800);

                                            String[] cities = {"Bangalore", "Hyderabad", "Chennai", "Mumbai", "NCR", "Pune", "Kolkata", "Ahmedabad", "Chandigarh", "Jaipur"};
                                            String[] courses = {"CSE", "IT", "AI", "E&TC", "MECH", "CHEM", "CIVIL", "INSTRU", "OTHER"};

                                            JButton b = new JButton("Update");
                                            JLabel yearLabel, mailLabel, passLabel, unilabel, courseLabel, cityLabel;
                                            yearLabel = new JLabel("Year: ");
                                            mailLabel = new JLabel("Mail: ");
                                            unilabel = new JLabel("University: ");
                                            courseLabel = new JLabel("Course: ");
                                            cityLabel = new JLabel("Location: ");
                                            passLabel = new JLabel("Password: ");
                                            JLabel l3 = new JLabel(null, null, 0);

                                            yearLabel.setBounds(20, 100, 100, 30);
                                            mailLabel.setBounds(20, 150, 100, 30);
                                            unilabel.setBounds(20, 200, 100, 30);
                                            courseLabel.setBounds(20, 250, 100, 30);
                                            cityLabel.setBounds(20, 300, 100, 30);
                                            passLabel.setBounds(20, 350, 100, 30);
                                            l3.setBounds(10, 450, 450, 30);
                                            frame.add(l3);
                                            frame.add(yearLabel);
                                            frame.add(mailLabel);
                                            frame.add(unilabel);
                                            frame.add(courseLabel);
                                            frame.add(cityLabel);
                                            frame.add(passLabel);

                                            b.setBounds(100, 400, 100, 30);

                                            JTextField tfYear = new JTextField("");
                                            JTextField tfMail = new JTextField("");
                                            JTextField tfUni = new JTextField("");
                                            JComboBox<String> Course = new JComboBox<>(courses);
                                            JComboBox<String> cityList = new JComboBox<>(cities);
                                            JPasswordField tfPassword = new JPasswordField("");

                                            tfYear.setBounds(120, 100, 100, 30);
                                            tfMail.setBounds(120, 150, 100, 30);
                                            tfUni.setBounds(120, 200, 100, 30);
                                            Course.setBounds(120, 250, 100, 30);
                                            cityList.setBounds(120, 300, 100, 30);
                                            tfPassword.setBounds(120, 350, 100, 30);

                                            frame.add(tfYear);
                                            frame.add(tfMail);
                                            frame.add(tfUni);
                                            frame.add(Course);
                                            frame.add(cityList);
                                            frame.add(tfPassword);
                                            frame.add(b);

                                            frame.setLayout(null);
                                            frame.setVisible(true);
                                            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                                            b.addActionListener(new ActionListener() {
                                                public void actionPerformed(ActionEvent e) {
                                                    try {

                                                        Class.forName("com.mysql.cj.jdbc.Driver");
                                                        Connection conn = DriverManager.getConnection(url, user, pwd);

                                                        String year = tfYear.getText();
                                                        String mail = tfMail.getText();
                                                        String uni = tfUni.getText();
                                                        String course = Course.getSelectedItem().toString();
                                                        String city = cityList.getSelectedItem().toString();
                                                        String password = new String(tfPassword.getPassword());

                                                        PreparedStatement ps = conn.prepareStatement("Update hiredLogin Set Year=?, Mail=?, University=?, Course=?, Location=?, Password=? where Name='" + userName[0] + "'");
                                                        ps.setString(1, year);
                                                        ps.setString(2, mail);
                                                        ps.setString(3, uni);
                                                        ps.setString(4, course);
                                                        ps.setString(5, city);
                                                        ps.setString(6, password);
                                                        ps.executeUpdate();

                                                        l2.setText("Profile Updated Successfully!!");
                                                        l3.setText("Profile Updated Successfully!!");

                                                    } catch (SQLException s) {
                                                        s.printStackTrace();
                                                    } catch (ClassNotFoundException z) {
                                                        throw new RuntimeException(z);
                                                    }

                                                }
                                            });
                                        }
                                    });
                                    b3.addActionListener(new ActionListener() {
                                        public void actionPerformed(ActionEvent e) {

                                            // Delete Profile

                                            try {
                                                Class.forName("com.mysql.cj.jdbc.Driver");
                                                Connection conn = DriverManager.getConnection(url, user, pwd);

                                                PreparedStatement ps = conn.prepareStatement("Delete from hiredLogin where Name= '" + userName[0] + "'");
                                                ps.executeUpdate();

                                                l.setText("Oops, No Profile Found!!");
                                                l1.setText("");
                                                l2.setText("Profile Deleted Successfully!!");

                                            } catch (SQLException s) {
                                                s.printStackTrace();
                                            } catch (ClassNotFoundException z) {
                                                throw new RuntimeException(z);
                                            }

                                        }
                                    });
                                }
                            }
                        });
                    }
                });
            }
        });
    }
}