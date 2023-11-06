package meujogo.modelo;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Jogador {

	private int x;
	private int y;
	private int dx;
	private int dy;
	private Image imagem;
	private int altura;
	private int largura;
	
	private List <Tiro> tiros;
	
	public Jogador() {
		this.x=100;
		this.y=100;
		
		tiros = new ArrayList<Tiro>();
	}
	public void load() {
		ImageIcon referencia =  new ImageIcon("res\\br-callister (2).png");
		imagem= referencia.getImage();
		altura= imagem.getHeight(null);
		largura=imagem.getWidth(null);
	}
	public void update() {
		x+=dx;
		y+=dy;
	}
	
	public void tiroSimples() {
		this.tiros.add(new Tiro(x+largura, y+(altura/2)));
	}
	public void keyPressed(KeyEvent tecla) {
		int codigo = tecla.getKeyCode();
		

		if(codigo== KeyEvent.VK_E) {
			tiroSimples();
		}
		
		if(codigo== KeyEvent.VK_W) {
			dy=-3;
		}
		if(codigo== KeyEvent.VK_S) {
			dy=3;
		}
		if(codigo== KeyEvent.VK_A) {
			dx=-3;
		}
		if(codigo== KeyEvent.VK_D) {
			dx=3;
		}
	}
	public void keyRelease(KeyEvent tecla) {
		int codigo = tecla.getKeyCode();
		
		if(codigo== KeyEvent.VK_W) {
			dy=0;
		}
		if(codigo== KeyEvent.VK_S) {
			dy=0;
		}
		if(codigo== KeyEvent.VK_A) {
			dx=0;
		}
		if(codigo== KeyEvent.VK_D) {
			dx=0;
		}
	}
	
	public List<Tiro> getTiros() {
		return tiros;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public Image getImagem() {
		return imagem;
	}
	
}
