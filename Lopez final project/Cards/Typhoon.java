package Cards;

import Main.Body;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Typhoon extends JFrame {

    public Typhoon() {

        setTitle("Typhoon Safety Guide");

        // FULL SCREEN
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(245, 245, 245));
        mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));

        // BACK BUTTON
        JLabel back = new JLabel("← Back to Categories");
        back.setForeground(Color.GRAY);
        back.setFont(new Font("SansSerif", Font.BOLD, 14));
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.setAlignmentX(Component.LEFT_ALIGNMENT);

        back.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new Body();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                back.setForeground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                back.setForeground(Color.GRAY);
            }
        });

        mainPanel.add(back);
        mainPanel.add(Box.createVerticalStrut(15));

        // Top Card
        JPanel topCard = createCardPanel();
        topCard.setLayout(new BorderLayout(10, 10));

        JPanel iconPanel = new JPanel();

        // GRAY COLOR
        iconPanel.setBackground(new Color(128, 128, 128));

        iconPanel.setPreferredSize(new Dimension(40, 40));

        JLabel storm = new JLabel("🌀");
        storm.setForeground(Color.WHITE);
        storm.setFont(new Font("SansSerif", Font.BOLD, 18));
        iconPanel.add(storm);

        JPanel textPanel = new JPanel();
        textPanel.setOpaque(false);
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Typhoon Safety");
        title.setFont(new Font("SansSerif", Font.BOLD, 16));

        // SUBTITLE RED
        JLabel subtitle = new JLabel("⚠ Stay indoors and monitor weather updates!");
        subtitle.setForeground(Color.RED);
        subtitle.setFont(new Font("SansSerif", Font.PLAIN, 12));

        textPanel.add(title);
        textPanel.add(Box.createVerticalStrut(5));
        textPanel.add(subtitle);

        topCard.add(iconPanel, BorderLayout.WEST);
        topCard.add(textPanel, BorderLayout.CENTER);

        mainPanel.add(topCard);
        mainPanel.add(Box.createVerticalStrut(15));

        // STEPS
        JPanel stepsPanel = createCardPanel();
        stepsPanel.setLayout(new BoxLayout(stepsPanel, BoxLayout.Y_AXIS));

        JLabel stepsTitle = new JLabel("🌀 Safety Steps");
        stepsTitle.setFont(new Font("SansSerif", Font.BOLD, 15));

        stepsPanel.add(stepsTitle);
        stepsPanel.add(Box.createVerticalStrut(15));

        addStep(stepsPanel, "1", "Stay Indoors",
                "Remain inside a strong building during the typhoon.");

        addStep(stepsPanel, "2", "Secure Windows and Doors",
                "Close and lock all windows and doors properly.");

        addStep(stepsPanel, "3", "Prepare Emergency Supplies",
                "Keep food, water, flashlights, and batteries ready.");

        addStep(stepsPanel, "4", "Avoid Flooded Areas",
                "Do not walk or drive through floodwaters.");

        addStep(stepsPanel, "5", "Monitor Weather Updates",
                "Listen to official news and emergency alerts.");

        addStep(stepsPanel, "6", "Evacuate if Needed",
                "Follow evacuation orders from authorities immediately.");

        mainPanel.add(stepsPanel);
        mainPanel.add(Box.createVerticalStrut(15));

        // TIPS
        JPanel tipsPanel = createCardPanel();
        tipsPanel.setLayout(new BoxLayout(tipsPanel, BoxLayout.Y_AXIS));

        JLabel tipsTitle = new JLabel("💡 Important Tips");
        tipsTitle.setFont(new Font("SansSerif", Font.BOLD, 15));

        tipsPanel.add(tipsTitle);
        tipsPanel.add(Box.createVerticalStrut(10));

        addBullet(tipsPanel, "Charge phones and power banks before the storm");
        addBullet(tipsPanel, "Store clean drinking water");
        addBullet(tipsPanel, "Keep important documents waterproof");

        mainPanel.add(tipsPanel);
        mainPanel.add(Box.createVerticalStrut(15));

        // WARNINGS
        JPanel warningPanel = createCardPanel();
        warningPanel.setLayout(new BoxLayout(warningPanel, BoxLayout.Y_AXIS));

        JLabel warningTitle = new JLabel("❗ Warnings");
        warningTitle.setForeground(Color.RED);
        warningTitle.setFont(new Font("SansSerif", Font.BOLD, 15));

        warningPanel.add(warningTitle);
        warningPanel.add(Box.createVerticalStrut(10));

        addBullet(warningPanel, "Avoid touching fallen electrical wires");
        addBullet(warningPanel, "Do not go outside during strong winds");
        addBullet(warningPanel, "Stay away from rivers and coastal areas");

        mainPanel.add(warningPanel);
        mainPanel.add(Box.createVerticalStrut(20));

        // EMERGENCY BUTTON (RED)
        JButton emergencyBtn = new JButton(
                "<html><center>In case of emergency:<br><b>View Emergency Hotlines</b></center></html>"
        );

        emergencyBtn.setBackground(Color.RED);
        emergencyBtn.setForeground(Color.WHITE);
        emergencyBtn.setFont(new Font("SansSerif", Font.BOLD, 14));
        emergencyBtn.setFocusPainted(false);
        emergencyBtn.setBorder(new EmptyBorder(15, 15, 15, 15));

        emergencyBtn.addActionListener(e -> {

            String hotlines =
                    "🚨 Emergency Hotlines:\n\n" +
                    "1. National Emergency Hotline\n" +
                    "   📞 911\n\n" +
                    "2. Davao City Disaster Office\n" +
                    "   📞 (082) 296-9626\n\n" +
                    "3. Philippine Red Cross Davao\n" +
                    "   📞 (082) 227-6657\n\n" +
                    "4. Bureau of Fire Protection\n" +
                    "   📞 160\n\n" +
                    "5. Davao Rescue 911\n" +
                    "   📞 911";

            JOptionPane.showMessageDialog(
                    this,
                    hotlines,
                    "Emergency Hotlines",
                    JOptionPane.WARNING_MESSAGE
            );
        });

        mainPanel.add(emergencyBtn);

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setBorder(null);

        add(scrollPane);
        setVisible(true);
    }

    // CARD DESIGN
    static JPanel createCardPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);

        panel.setBorder(new CompoundBorder(
                new LineBorder(new Color(220, 220, 220), 1, true),
                new EmptyBorder(15, 15, 15, 15)
        ));

        panel.setAlignmentX(Component.LEFT_ALIGNMENT);

        return panel;
    }

    // STEP DESIGN
    static void addStep(JPanel parent, String num, String title, String desc) {

        JPanel stepPanel = new JPanel(new BorderLayout(10, 0));
        stepPanel.setOpaque(false);

        JLabel number = new JLabel(num, SwingConstants.CENTER);
        number.setOpaque(true);

        // GRAY COLOR
        number.setBackground(new Color(128, 128, 128));

        number.setForeground(Color.WHITE);
        number.setPreferredSize(new Dimension(25, 25));
        number.setFont(new Font("SansSerif", Font.BOLD, 12));

        JPanel text = new JPanel();
        text.setOpaque(false);
        text.setLayout(new BoxLayout(text, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 13));

        JLabel descLabel = new JLabel(
                "<html><body style='width:220px'>" + desc + "</body></html>"
        );

        descLabel.setForeground(Color.GRAY);
        descLabel.setFont(new Font("SansSerif", Font.PLAIN, 11));

        text.add(titleLabel);
        text.add(Box.createVerticalStrut(3));
        text.add(descLabel);

        stepPanel.add(number, BorderLayout.WEST);
        stepPanel.add(text, BorderLayout.CENTER);

        parent.add(stepPanel);
        parent.add(Box.createVerticalStrut(15));
    }

    // BULLETS
    static void addBullet(JPanel panel, String text) {
        JLabel label = new JLabel("• " + text);
        label.setFont(new Font("SansSerif", Font.PLAIN, 12));
        label.setForeground(Color.DARK_GRAY);

        panel.add(label);
    }
}