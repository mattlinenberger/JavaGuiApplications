import javax.swing.*;
import java.awt.*;


public class FancyGUI extends JFrame
{
   Color bgColor = new Color( 255, 255, 153 );
   Color txColor = new Color( 0, 0, 255 );
   Font lblFont = new Font( "Times New Roman", Font.PLAIN, 24 );
   Font txtFont = new Font( "Courier New", Font.BOLD, 24 ); 
   Font btnFont = new Font( "Dialog", Font.PLAIN, 24 );
   Icon lblIcon = new ImageIcon( "rightarrow.jpg" );
   Icon btnIcon = new ImageIcon( "uparrow.jpg" );

   
   public static void main(String[]args)
   {

      new FancyGUI();

   }
   
   public FancyGUI()
   {
      //Configure window
      super("GUI Embellishments");
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         JLabel label = new JLabel("\u00B0 F"); 
         //JLabel label = new JLabel(lblIcon);
         //label.setOpaque( true );
         label.setBackground( bgColor );
         label.setForeground( txColor );
         label.setFont( lblFont );
         //Configure text field
         JTextField textField = new JTextField( 10 ); 
         textField.setText( "0.0" ); 
         textField.setHorizontalAlignment( JTextField.RIGHT ); 
         textField.setFont( txtFont );
         textField.setBackground( bgColor );
         textField.setForeground( txColor );
         //configure button
         JButton button = new JButton( btnIcon );
         button.setToolTipText( "Click to increment value" );
         button.setFont( btnFont );
         button.setBackground( bgColor );
         button.setForeground( txColor );
         //add components
         this.setLayout(new FlowLayout());
         this.add(label);
         this.add(textField);
         this.add(button);
         //Set size and show
         textField.requestFocus( true );
         textField.selectAll( );
         this.setSize(500,150);
         this.setVisible(true);
   
   }
   
   
}


