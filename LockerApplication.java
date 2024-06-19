import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LockerApplication {
    private static String savedPassword = null;

    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Locker Application");
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setLayout(new BorderLayout());

        // Create the top panel for instructions and password field
        JPanel topPanel = new JPanel(new BorderLayout());
        JLabel instructionLabel = new JLabel("Enter your passcode:");
        JPasswordField passwordField = new JPasswordField(20);
        topPanel.add(instructionLabel, BorderLayout.NORTH);
        topPanel.add(passwordField, BorderLayout.CENTER);

        // Create the bottom panel for buttons
        JPanel bottomPanel = new JPanel(new GridLayout(4, 3, 5, 5));
        JButton[] numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            bottomPanel.add(numberButtons[i]);
            int finalI = i;
            numberButtons[i].addActionListener(e -> {
                passwordField.setText(passwordField.getText() + finalI);
            });
        }

        JButton enterButton = new JButton("Enter");
        JButton clearButton = new JButton("Clear");
        bottomPanel.add(enterButton);
        bottomPanel.add(clearButton);

        // Add components to the frame
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(bottomPanel, BorderLayout.CENTER);

        // Add action listener to the enter button
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputPassword = new String(passwordField.getPassword());

                if (savedPassword == null) {
                    // Set the password for the first time
                    savedPassword = inputPassword;
                    JOptionPane.showMessageDialog(frame, "Password Set", "Info", JOptionPane.INFORMATION_MESSAGE);
                    instructionLabel.setText("Password set. Enter your password to unlock:");
                } else {
                    // Verify the password
                    if (savedPassword.equals(inputPassword)) {
                        JOptionPane.showMessageDialog(frame, "Correct Password", "Info",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Incorrect Password", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

                // Clear the password field
                passwordField.setText("");
            }
        });

        // Add action listener to the clear button
        clearButton.addActionListener(e -> passwordField.setText(""));

        // Set frame visibility
        frame.setVisible(true);
    }
}
