import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LockerApplication {
    private static String savedPassword = null;

    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Locker Application");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setLayout(new FlowLayout());

        // Create the label and password field
        JLabel instructionLabel = new JLabel("Enter your passcode:");
        JPasswordField passwordField = new JPasswordField(20);
        JButton enterButton = new JButton("Enter");

        // Add components to the frame
        frame.add(instructionLabel);
        frame.add(passwordField);
        frame.add(enterButton);

        // Add action listener to the button
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
                        JOptionPane.showMessageDialog(frame, "Correct Password", "Info", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Incorrect Password", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

                // Clear the password field
                passwordField.setText("");
            }
        });

        // Set frame visibility
        frame.setVisible(true);
    }
}
