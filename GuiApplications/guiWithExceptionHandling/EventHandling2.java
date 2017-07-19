import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EventHandling2 extends JFrame implements ActionListener {

	public static JFrame win;

	public static void main(String[] args) {

		new EventHandling2();
	}

	Color bgColor = new Color(255, 255, 200);
	Color btnColor = new Color(73, 162, 166);
	Color txColor = new Color(81, 205, 232);
	Font lblFont = new Font("Georgia", Font.PLAIN, 20);
	Font txtFont = new Font("Comic Sans MS", Font.BOLD, 24);
	Font btnFont = new Font("Dialog", Font.PLAIN, 24);
	JTextField textfield;
	JButton button;
	JLabel label;
	JLabel happyBirthday;
	JLabel age;

	public void actionPerformed(ActionEvent e) {
		// If not the Button then return
		if (e.getSource() != button) {
			return;
		}

		// set birthday string to get the text from text field
		String birthday = textfield.getText();
		// print text field
		System.out.println(birthday);
		
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		try {
			LocalDate now = LocalDate.now();
			LocalDate birthdate = LocalDate.parse(birthday, dateFormat);
			System.out.println(dateFormat.format(birthdate));
			System.out.println(dateFormat.format(now));

			int comparison = birthdate.compareTo(now);
			System.out.println(comparison);

			// Getting the birthday month and current month
			Month birthMonth = birthdate.getMonth();
			Month currentMonth = now.getMonth();

			// if birth month and current month don't match it's not your
			// birthday.
			if (birthMonth.compareTo(currentMonth) != 0) {
				//System.out.println("It's not your birthdate");
				
			}

			// The birth month and current month match
			// Compare months
			int birthDay = birthdate.getDayOfMonth();
			int currentDay = now.getDayOfMonth();

			// if birth day and current day match
			// compare days
			if (birthDay == currentDay) {
				//System.out.println("It's your Birthday!");
				happyBirthday.setText("Happy Birthday!");
			}

			// Compare Years and get age.
			
			long yearsOld = birthdate.until(now, ChronoUnit.YEARS);
			age.setText(Long.toString(yearsOld));
			//System.out.println(yearsOld);

		} catch (DateTimeParseException e1) {
			//e1.printStackTrace();
			// Incorrect information entered error.
			JOptionPane.showMessageDialog(textfield, "Incorrect Format");
         textfield.setText("mm/dd/yyyy");
		}

	}

	public EventHandling2() {

		super("Birthday");
		this.getContentPane().setBackground(Color.decode("#1C3E40"));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textfield = new JTextField(10);
		label = new JLabel("Enter your Birthday");
		age = new JLabel("");
		age.setForeground(Color.white);
		age.setFont(txtFont);
		happyBirthday = new JLabel("");
		happyBirthday.setForeground(Color.white);
		happyBirthday.setFont(txtFont);
		button = new JButton("Go");
		label.setFont(lblFont);
		label.setForeground(btnColor);
		textfield.setText("mm/dd/yyyy");
		textfield.setHorizontalAlignment(JTextField.RIGHT);
		textfield.setFont(txtFont);
		textfield.setBackground(bgColor);
		textfield.setForeground(txColor);
		button.setForeground(btnColor);
		button.setToolTipText("Click to show age and next birthday");
		this.add(label);
		textfield.addActionListener(this);
		this.add(textfield);
		button.addActionListener(this);
		this.add(button);
		this.add(age);
		this.add(happyBirthday);
		
		// add layout
		this.setLayout(new FlowLayout());
		// set size of window
		this.setSize(500, 150);
		// set window visible
		this.setVisible(true);

	}

}
