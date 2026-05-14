package Main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login {

    public static void main(String[] args) {

        JFrame frame = new JFrame("LifeAid Login");
        frame.setSize(350, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        // Logo
        JLabel logo = new JLabel("LifeAid");
        logo.setFont(new Font("Arial", Font.BOLD, 32));
        logo.setForeground(Color.RED);
        logo.setBounds(100, 30, 200, 40);
        panel.add(logo);

        JLabel subtitle = new JLabel("First aid app");
        subtitle.setBounds(120, 65, 120, 20);
        panel.add(subtitle);

        // Login Title
        JLabel login = new JLabel("Log in");
        login.setFont(new Font("Arial", Font.BOLD, 28));
        login.setBounds(120, 110, 120, 40);
        panel.add(login);

        JLabel welcome = new JLabel("Welcome back!");
        welcome.setBounds(110, 145, 150, 20);
        panel.add(welcome);

        // Username Field
        JTextField emailField = new JTextField();
        emailField.setBounds(40, 190, 260, 40);
        panel.add(emailField);

        // Password Field
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(40, 250, 260, 40);
        panel.add(passwordField);

        // Forgot Password
        JLabel forgot = new JLabel("Forgot password?");
        forgot.setForeground(Color.BLUE);
        forgot.setBounds(180, 300, 120, 20);
        panel.add(forgot);

        // Login Button
        JButton loginBtn = new JButton("Log in");
        loginBtn.setBounds(40, 340, 260, 45);
        loginBtn.setBackground(Color.RED);
        loginBtn.setForeground(Color.WHITE);
        panel.add(loginBtn);

        // OR
        JLabel or = new JLabel("or");
        or.setBounds(160, 410, 30, 20);
        panel.add(or);

        // Google Button
        JButton googleBtn = new JButton("Continue with Google");
        googleBtn.setBounds(40, 440, 260, 40);
        panel.add(googleBtn);

        // Facebook Button
        JButton fbBtn = new JButton("Continue with Facebook");
        fbBtn.setBounds(40, 490, 260, 40);
        panel.add(fbBtn);

        // LOGIN FUNCTION
        loginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String username = emailField.getText();
                String password = new String(passwordField.getPassword());

                // Correct username and password
                if (username.equals("Johan Lopez") && password.equals("12345")) {

                    frame.dispose(); // close login window

                    // Open Body.java
                    Body.main(null);

                } else {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Incorrect Username or Password"
                    );
                }
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}