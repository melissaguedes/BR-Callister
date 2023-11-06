package meujogo.modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Fase extends JPanel implements ActionListener{
	
	private Image fundo;
	private Jogador jogador;
	private Timer timer;
	
	public Fase() {
		
		setFocusable(true);
		setDoubleBuffered(true);
		
		ImageIcon referencia = new ImageIcon("res\\background_fase1.png");
		fundo = referencia.getImage();
		
		jogador= new Jogador();
		jogador.load();
		
		addKeyListener(new TecladoAdapter());
		
		timer= new Timer(5, this);
		timer.start();
	}
	public void paint(Graphics g) {
		Graphics2D graficos = (Graphics2D) g;
		graficos.drawImage(fundo, 0, 0, null);
		graficos.drawImage(jogador.getImagem(),jogador.getX(), jogador.getY(), this); 
		
		List<Tiro> tiros = jogador.getTiros();
		
		for(int i=0;i<tiros.size();i++) {
		Tiro m = tiros.get(i);	
		m.load();
		graficos.drawImage(m.getImagem(), m.getX(),m.getY(),this);
		}
		
		g.dispose();
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		jogador.update();
		List<Tiro> tiros = jogador.getTiros();
		
		for(int i=0;i<tiros.size();i++) {
			Tiro m = tiros.get(i);
			if(m.isVisivel()) {
				m.update();
			}else {
				tiros.remove(i);
			}
		}
		repaint();
		
	}
	private class TecladoAdapter implements KeyListener{
		@Override
		
		public void keyPressed(KeyEvent e) {
			jogador.keyPressed(e);
		}
		@Override
		public void keyReleased(KeyEvent e) {
			jogador.keyRelease(e);
		}
		@Override
		public void keyTyped(KeyEvent e) {
			  throw new UnsupportedOperationException("Not supported yet.");
			
		}
	}
	
	
}
