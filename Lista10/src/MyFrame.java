import javax.swing.JFrame;

public class MyFrame extends JFrame {

	public MyFrame(Look look) {
        super("Hello World");
        
        add(look.Draw());

        pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}