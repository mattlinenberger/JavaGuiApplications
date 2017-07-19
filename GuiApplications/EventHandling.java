import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import static java.lang.character.*;

public class EventHandling implements ActionListener {
	public static JFrame win;

	public static void main(String[] args) {
		new EventHandling();

	}

	// Set embellishments
	Color bgColor = new Color(75, 75, 0);
	Color txColor = new Color(255, 0, 0);
	Font lblFont = new Font("Times New Roman", Font.PLAIN, 24);
	Font txtFont = new Font("Courier New", Font.BOLD, 24);
	Font btnFont = new Font("Dialog", Font.PLAIN, 24);
	// add images
	Icon upArrow = new ImageIcon("uparrow.jpg");
	Icon downArrow = new ImageIcon("downarrow.jpg");
	// define components
	JTextField textField;
	JButton upButton;
	JButton downButton;
	JLabel label;
	int count = 0;

	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			count = Integer.parseInt(textField.getText());
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(textField, "not an integer");
		}

		if (count < 0) {
			JOptionPane.showMessageDialog(textField, "Count cannot be less than 0.");
			textField.setText("0");
			return;
		}

		if (e.getSource() == upButton) {
			count++;
			textField.setText(Integer.toString(count));
		} else if (e.getSource() == downButton) {
			if (count != 0) {
				count--;
			}

		}

		textField.setText(Integer.toString(count));
	}

	public EventHandling() {
		// window management
		JFrame win = new JFrame("Counter");
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.getContentPane().setBackground(Color.decode("#999999"));
		JLabel label = new JLabel("X=");
		label.setForeground(Color.decode("#222222"));
		textField = new JTextField(10);
		textField.setText("0");
		textField.setHorizontalAlignment(JTextField.RIGHT);
		textField.setFont(txtFont);
		textField.setBackground(bgColor);
		textField.setForeground(txColor);
		textField.setToolTipText("Current counter value");
		downButton = new JButton(downArrow);
		downButton.setFont(btnFont);
		downButton.setForeground(txColor);
		downButton.setToolTipText("Click to decrement counter");
		downButton.addActionListener(this);
		textField.addActionListener(this);
		upButton = new JButton(upArrow);
		upButton.setToolTipText("Click to increment value");
		upButton.setFont(btnFont);
		upButton.setForeground(txColor);
		upButton.addActionListener(this);
		win.add(downButton);
		win.add(label);
		win.add(textField);
		win.add(upButton);
		win.setLayout(new FlowLayout());
		win.setSize(400, 125);
		win.setVisible(true);
		textField.requestFocus(true);
		textField.selectAll();
	}

}
