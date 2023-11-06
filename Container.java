package meujogo;

import javax.swing.JFrame;

import meujogo.modelo.Fase;

public class Container extends JFrame{
	
	public Container() {
		add(new Fase());
		setTitle ("Br-Callister");
		setSize(1024,512);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(false);
		setVisible(true);
	}
	public static void main(String[]args) {
		new Container ();
	}
}
