
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;

public class MainFrame extends JFrame {

    public static void main(String[] args) {
    
        Element panel = new Element();
        JFrame frame = new JFrame("Circuits");
        frame.add(panel);
        frame.setSize(535, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }
}

class Element extends JPanel  {
    private int element;
    protected static JTextField voltage;
    protected static JTextField resistor;
    protected static JTextField capacitor;
    protected static JTextField inductor;
    protected static JTextField frequency;
    protected static Complex volt;
    protected static Complex res;
    protected static Complex cap;
    protected static Complex ind;
    protected static Complex freq;
    protected final Complex imag = new Complex(0,1);
    protected JLabel v1;
    protected JLabel v2;
    protected JLabel v3;
    public Element() {

        setLayout(new FlowLayout());

        JButton lc = new JButton("LC");
        JButton rc = new JButton("RC");
        JButton rl = new JButton("RL");
        JButton rlc = new JButton("RLC");

        add(lc);
        add(rc);
        add(rlc);
        add(rl);

        lc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();
                frequency = new JTextField(2);
                JLabel fr = new JLabel("Frequency: ");
                add(fr);
                add(frequency);
                voltage = new JTextField(2);
                JLabel vl = new JLabel("Voltage: ");
                capacitor = new JTextField(2);
                JLabel cp = new JLabel("Capacitor: ");
                inductor = new JTextField(2);
                JLabel id = new JLabel("Inductor: ");
                add(vl);
                add(voltage);
                add(cp);
                add(capacitor);
                add(id);
                add(inductor);
                JButton calc = new JButton("Calculate!");
                add(calc);
                add(lc);
                add(rc);
                add(rlc);
                add(rl);
                calc.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        volt = new Complex(Double.parseDouble(voltage.getText()), 0);
                        cap = new Complex(Double.parseDouble(capacitor.getText()), 0);
                        ind = new Complex(Double.parseDouble(inductor.getText()), 0);
                        freq = new Complex(Double.parseDouble(frequency.getText())*Math.PI*2, 0);

                        Complex one = new Complex(1,0);
                        cap = one.divides((cap.times(freq).times(imag)));
                        ind = ind.times(freq).times(imag);

                        v1 = new JLabel("v1 = " + ((volt.times(cap).divides((cap.plus(ind))))).re());
                        v1.setBounds(50,350,100,50);
                        v2 = new JLabel("v2 = " + ((volt.times(ind).divides((cap.plus(ind))))).re());
                        v2.setBounds(50,375,100,50);
                        add(v1);
                        add(v2);
                        repaint();
                    }
                });
                revalidate();
                element = 1;    
                repaint();
            }
        });

        rc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();
                frequency = new JTextField(2);
                JLabel fr = new JLabel("Frequency: ");
                add(fr);
                add(frequency);
                voltage = new JTextField(2);
                JLabel vl = new JLabel("Voltage: ");
                resistor = new JTextField(2);
                JLabel rs = new JLabel("Resistor: ");
                capacitor = new JTextField(2);
                JLabel cp = new JLabel("Capacitor: ");
                add(vl);
                add(voltage);
                add(rs);
                add(resistor);
                add(cp);
                add(capacitor);
                JButton calc = new JButton("Calculate!");
                add(calc);
                add(lc);
                add(rc);
                add(rlc);
                add(rl);
                calc.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        volt = new Complex(Double.parseDouble(voltage.getText()), 0);
                        res = new Complex(Double.parseDouble(resistor.getText()), 0);
                        cap = new Complex(Double.parseDouble(capacitor.getText()), 0);
                        freq = new Complex(Double.parseDouble(frequency.getText())*Math.PI*2, 0);

                        Complex one = new Complex(1,0);
                        cap = one.divides((cap.times(freq).times(imag)));

                        v1 = new JLabel("v1 = " + ((volt.times(res).divides((cap.plus(res))))).re());
                        v1.setBounds(50,350,100,50);
                        v2 = new JLabel("v2 = " + ((volt.times(cap).divides((cap.plus(res))))).re());
                        v2.setBounds(50,375,100,50);
                        add(v1);
                        add(v2);
                        repaint();
                    }
                });
                revalidate();
                element = 2;
                repaint();
            }
        });

        rl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();
                frequency = new JTextField(2);
                JLabel fr = new JLabel("Frequency: ");
                add(fr);
                add(frequency);
                voltage = new JTextField(3);
                JLabel vl = new JLabel("Voltage: ");
                resistor = new JTextField(3);
                JLabel rs = new JLabel("Resistor: ");
                inductor = new JTextField(3);
                JLabel id = new JLabel("Inductor: ");
                add(vl);
                add(voltage);
                add(rs);
                add(resistor);
                add(id);
                add(inductor);
                JButton calc = new JButton("Calculate!");
                add(calc);
                add(lc);
                add(rc);
                add(rlc);
                add(rl);
                calc.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        volt = new Complex(Double.parseDouble(voltage.getText()), 0);
                        res = new Complex(Double.parseDouble(resistor.getText()), 0);
                        ind = new Complex(Double.parseDouble(inductor.getText()), 0);
                        freq = new Complex(Double.parseDouble(frequency.getText())*Math.PI*2, 0);

                        ind = ind.times(freq).times(imag);

                        v1 = new JLabel("v1 = " + ((volt.times(res).divides((ind.plus(res))))).re());
                        v1.setBounds(50,350,100,50);
                        v2 = new JLabel("v2 = " + ((volt.times(ind).divides((ind.plus(res))))).re());
                        v2.setBounds(50,375,100,50);
                        add(v1);
                        add(v2);
                        repaint();
                    }
                });
                revalidate();
                element = 3;
                repaint();
            }
        });

        rlc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();
                frequency = new JTextField(2);
                JLabel fr = new JLabel("Frequency: ");
                add(fr);
                add(frequency);
                voltage = new JTextField(2);
                JLabel vl = new JLabel("Voltage: ");
                resistor = new JTextField(2);
                JLabel rs = new JLabel("Resistor: ");
                capacitor = new JTextField(2);
                JLabel cp = new JLabel("Capacitor: ");
                inductor = new JTextField(2);
                JLabel id = new JLabel("Inductor: ");
                add(vl);
                add(voltage);
                add(rs);
                add(resistor);
                add(cp);
                add(capacitor);
                add(id);
                add(inductor);
                JButton calc = new JButton("Calculate!");
                add(calc);
                add(lc);
                add(rc);
                add(rlc);
                add(rl);
                calc.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        volt = new Complex(Double.parseDouble(voltage.getText()), 0);
                        res = new Complex(Double.parseDouble(resistor.getText()), 0);
                        cap = new Complex(Double.parseDouble(capacitor.getText()), 0);
                        ind = new Complex(Double.parseDouble(inductor.getText()), 0);
                        freq = new Complex(Double.parseDouble(frequency.getText())*Math.PI*2, 0);

                        Complex one = new Complex(1,0);
                        cap = one.divides((cap.times(freq).times(imag)));

                        ind = ind.times(freq).times(imag);

                        v1 = new JLabel("v1 = " + ((volt.times(res).divides((cap.plus(res).plus(ind))))).re());
                        v1.setBounds(50,350,100,50);
                        v2 = new JLabel("v2 = " + ((volt.times(ind).divides((cap.plus(res).plus(ind))))).re());
                        v2.setBounds(50,375,100,50);
                        v3 = new JLabel("v3 = " + ((volt.times(cap).divides((cap.plus(res).plus(ind))))).re());
                        v3.setBounds(50,400,100,50);
                        add(v1);
                        add(v2);  
                        add(v3);
                        repaint();
                    }
                });
                revalidate();
                element = 4;
                repaint();
            }
        });

    }


    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);
        if(element == 1){
            g2.draw(new Line2D.Double(150, 150, 150, 350)); //left
            g2.draw(new Line2D.Double(150, 150, 240, 150));
            g2.draw(new Line2D.Double(270, 150, 350, 150));
            g2.draw(new Line2D.Double(350, 150, 350, 350)); //right
            Capacitor c = new Capacitor(240, 150);
            c.draw(g2); //capacitor
            Inductor i = new Inductor(240, 350);
            i.draw(g2); //capacitor
            //g2.draw(new Line2D.Double(150, 350, 240, 350));
            g2.draw(new Line2D.Double(270, 350, 350, 350));
            Battery b = new Battery(180, 350);
            b.draw(g2); //battery
            g2.draw(new Line2D.Double(150, 350, 180, 350));
            g2.draw(new Line2D.Double(210, 350, 240, 350));
        }

        if(element == 2){
            g2.draw(new Line2D.Double(450, 150, 450, 300)); //right
            g2.draw(new Line2D.Double(50, 300, 200, 300)); //bottom left
            Battery b = new Battery(200, 300);
            b.draw(g2); //battery
            g2.draw(new Line2D.Double(230, 300, 450, 300)); //bottom right 
            g2.draw(new Line2D.Double(50, 300, 50, 150)); //left
            g2.draw(new Line2D.Double(50, 150, 100, 150)); //top left
            Resistor r = new Resistor(100, 150);
            r.draw(g2); //resistor
            g2.draw(new Line2D.Double(170, 150, 350, 150));
            Capacitor c = new Capacitor(350, 150);
            c.draw(g2); //capacitor
            g2.draw(new Line2D.Double(380, 150, 450, 150)); //top right
        }

        if(element == 3){
            g2.draw(new Line2D.Double(450, 150, 450, 300)); //right
            g2.draw(new Line2D.Double(50, 300, 200, 300)); //bottom left
            Battery b = new Battery(200, 300);
            b.draw(g2); //battery
            g2.draw(new Line2D.Double(230, 300, 450, 300)); //bottom right 
            g2.draw(new Line2D.Double(50, 300, 50, 150)); //left
            g2.draw(new Line2D.Double(50, 150, 100, 150)); //top left
            Resistor r = new Resistor(100, 150);
            r.draw(g2); //resistor
            g2.draw(new Line2D.Double(170, 150, 250, 150)); //top middle
            Inductor i = new Inductor(250, 150);
            i.draw(g2); //inductor
            g2.draw(new Line2D.Double(280, 150, 450, 150)); //top right
        }

        if(element == 4){
            g2.draw(new Line2D.Double(450, 150, 450, 300)); //right
            g2.draw(new Line2D.Double(50, 300, 200, 300)); //bottom left
            Battery b = new Battery(200, 300);
            b.draw(g2); //battery
            g2.draw(new Line2D.Double(230, 300, 450, 300)); //bottom right 
            g2.draw(new Line2D.Double(50, 300, 50, 150)); //left
            g2.draw(new Line2D.Double(50, 150, 100, 150)); //top left
            Resistor r = new Resistor(100, 150);
            r.draw(g2); //resistor
            g2.draw(new Line2D.Double(170, 150, 250, 150)); //top middle
            Inductor i = new Inductor(250, 150);
            i.draw(g2); //inductor
            g2.draw(new Line2D.Double(280, 150, 350, 150)); //top middle
            Capacitor c = new Capacitor(350, 150);
            c.draw(g2); //capacitor
            g2.draw(new Line2D.Double(380, 150, 450, 150)); //top right
        }

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(120, 150);
    }
}

class Capacitor {
    
    private int x, y;
    
    public Capacitor(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void draw(Graphics2D g2) {
        g2.draw(new Line2D.Double(x, y, x + 10, y));
        g2.draw(new Line2D.Double(x+10, y+15, x+10, y-15));
        g2.draw(new Line2D.Double(x+20, y+15, x+20, y-15));
        g2.draw(new Line2D.Double(x+20, y, x+30, y));
    }

}

class Inductor {
    
    private int x, y;
    
    public Inductor(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void draw(Graphics2D g2) {
        g2.draw(new Ellipse2D.Double(x, y-10, 10, 20));
        g2.draw(new Ellipse2D.Double(x+5, y-10, 10, 20));
        g2.draw(new Ellipse2D.Double(x+10, y-10, 10, 20));
        g2.draw(new Ellipse2D.Double(x+15, y-10, 10, 20));
        g2.draw(new Ellipse2D.Double(x+20, y-10, 10, 20));
    }
}


class Resistor {
    
    private int x, y;
    
    public Resistor(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void draw(Graphics2D g2) {
        g2.draw(new Line2D.Double(x, y, x+10, y));
        g2.draw(new Line2D.Double(x+10, y, x+20, y+15));
        g2.draw(new Line2D.Double(x+20, y+15, x+30, y-15));
        g2.draw(new Line2D.Double(x+30, y-15, x+40, y+15));
        g2.draw(new Line2D.Double(x+40, y+15, x+50, y-15));
        g2.draw(new Line2D.Double(x+50, y-15, x+60, y+15));
        g2.draw(new Line2D.Double(x+60, y+15, x+70, y));
        g2.draw(new Line2D.Double(x+70, y, x+80, y));
    }
}

class Battery {
    
    private int x, y;
    
    public Battery(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void draw(Graphics2D g2) {
        g2.draw(new Line2D.Double(x, y, x + 10, y));
        g2.draw(new Line2D.Double(x+10, y+15, x+10, y-15));
        g2.draw(new Line2D.Double(x+15, y+8, x+15, y-8));
        g2.draw(new Line2D.Double(x+15, y, x+30, y));
    }
}