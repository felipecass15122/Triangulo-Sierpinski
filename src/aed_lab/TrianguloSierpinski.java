import javax.swing.JFrame;


public class TrianguloSierpinski extends JFrame {
    	public TrianguloSierpinski() {
		initGui();
	}

    private void initGui() {
        // titulo
        this.setTitle("Sierpinski");
        
        // tamanho em pixels altura e largura
        setSize(550, 550);

        // janela aparecer no meio
        setLocationRelativeTo(null);

        // terminar a aplicacao ao fechar a janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Desenho desenho = new Desenho();
        Desenho_inverso desenho = new Desenho_inverso();

        this.add(desenho);
        // tornar a janela visivel
        setVisible(true);

    }

}
