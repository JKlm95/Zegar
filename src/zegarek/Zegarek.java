
package zegarek;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Zegarek extends JFrame
{
public Zegarek ()
{
    super("Zegarek");
    this.setBounds(300, 300, 250, 70);
    
    initComponents();
    
    this.setDefaultCloseOperation(3);


}
public void initComponents() 
{
    panel.add(etykieta);
    this.getContentPane().add(panel);
    panel.add(czas);
    
    ActionListener stoper = new Zegar();
    
    Timer zegar = new Timer(1000, stoper);
    zegar.start();
    

}
JPanel panel = new JPanel();
JLabel etykieta = new JLabel("Czas: ");
JLabel czas = new JLabel(pobierzCzas());

private class Zegar implements ActionListener
{

        
        public void actionPerformed(ActionEvent e) 
        {
        
        
        czas.setText(pobierzCzas());
        
        
        }   
}
    
public String pobierzCzas()
{
    GregorianCalendar kalendarz = new GregorianCalendar();
        
        String h = ""+ kalendarz.get(Calendar.HOUR_OF_DAY);
        String m = ""+ kalendarz.get(Calendar.MINUTE);
        String s = ""+ kalendarz.get(Calendar.SECOND);
        
        if (Integer.parseInt(h)<10)
            h = "0" + h;
        if (Integer.parseInt(m)<10)
            m = "0" + m;
        if (Integer.parseInt(s)<10)
            s = "0" + s;
        
    return h+":"+m+":"+s;
    
    
}

    public static void main(String[] args) 
    {
        new Zegarek ().setVisible(true);
          
       
    }
    
}
