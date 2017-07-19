import java.applet.Applet;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EventHandling3 extends Applet implements ActionListener {

	Color background = new Color(0, 0, 0);
	Color bgColor = new Color(107, 232, 105);
	Color bgColor2 = new Color(246, 173, 255);
	Color txColor = new Color(255, 0, 0);
	Font lblFont = new Font("Times New Roman", Font.PLAIN, 24);
	Font txtFont = new Font("Courier New", Font.BOLD, 24);
	Font btnFont = new Font("Dialog", Font.PLAIN, 24);
	JTextField fareTextField = new JTextField(10);
	JTextField celsTextField = new JTextField(10);
	JButton fareButton = new JButton(">>");
	// Create Button
	JButton celsButton = new JButton("<<");

	// init( ) method builds the GUI
	public void init() {
		// set size
		setSize(500, 75);
		setBackground(Color.decode("#7CE8FF"));
		// Create Labels
		JLabel far = new JLabel("\u00B0 F");
		far.setFont(lblFont);
		far.setForeground(txColor);
		JLabel cel = new JLabel("\u00B0 C");
		cel.setFont(lblFont);
		cel.setForeground(txColor);
		fareButton.setBackground(bgColor);
		fareButton.setToolTipText("Click to convert degrees to Fahrenheit to Celsius");
		celsButton.setBackground(bgColor2);
		celsButton.setToolTipText("Click to convert degrees to Celsius to Fahrenheit");
		fareTextField.setBackground(bgColor);
		fareTextField.setHorizontalAlignment(JTextField.RIGHT);
		celsTextField.setBackground(bgColor2);
		celsTextField.setHorizontalAlignment(JTextField.RIGHT);
		// add components
		add(fareTextField);
		add(far);
		add(fareButton);
		add(celsButton);
		add(celsTextField);
		add(cel);
		fareButton.addActionListener(this);
		celsButton.addActionListener(this);
		setLayout(new FlowLayout());
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == fareButton) {
			fahrenheitToCelsius();
		}
		if (e.getSource() == celsButton) {
			celsiusToFahrenheit();
		}
	}

	public void fahrenheitToCelsius() {

		try {
			// Get the input from the text field and perform calculations from F to C
			double input = Double.parseDouble(fareTextField.getText());
			double calculations = ((input - 32) * 5 / 9);

			// Format the calculations to 2 decimal points and place in opposite text field
			NumberFormat formatter = new DecimalFormat("#0.00");
			celsTextField.setText(formatter.format(calculations));
			// System.out.println(formatter.format(calculations));

		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(fareTextField, "not a valid temperature.");
			celsTextField.setText("");
			fareTextField.setText("");
		}

	}

	public void celsiusToFahrenheit() {
		try {
			// Get the input from the text field and perform calculations from C to F
			double input = Double.parseDouble(celsTextField.getText());
			double calculations = ((input * 9) / 5 + 32);

			// Format the calculations to 2 decimal points and place in opposite text field
			NumberFormat formatter = new DecimalFormat("#0.00");
			fareTextField.setText(formatter.format(calculations));
			// System.out.println(calculations);

		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(celsTextField, "not a valid temperature.");
			celsTextField.setText("");
			fareTextField.setText("");
		}

	}

}
