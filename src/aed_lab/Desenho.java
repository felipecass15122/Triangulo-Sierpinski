//DESENHA OS TRIANGULOS PRETOS


import java.awt.Canvas;
import java.awt.Graphics;

public class Desenho extends Canvas {

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        criaTriangulo(g);

    }

    private void criaTriangulo(Graphics g) {
        double largura = getWidth() - 5;
        double altura = getHeight() - 5;

        criaTrianguloRecu(g, 0, 2, 0, altura, largura / 2, 0, largura, altura);

    }

    private void criaTrianguloRecu(Graphics g, int nivel, int nivelMax,
            double x1, double y1, double x2, double y2, double x3, double y3) {
        if (nivel < nivelMax) {
//             chamada dos 3 triangulos
//             triangulo esquerda
            criaTrianguloRecu(g, nivel + 1, nivelMax, x1, y1, (x1 + x2) / 2,
                    (y1 + y2) / 2, (x1 + x3) / 2, (y1 + y3) / 2);
//             triangulo de cima
            criaTrianguloRecu(g, nivel + 1, nivelMax, (x1 + x2) / 2,
                    (y1 + y2) / 2, x2, y2, (x2 + x3) / 2, (y2 + y3) / 2);
   //          triangulo de direita
            criaTrianguloRecu(g, nivel + 1, nivelMax, (x1 + x3) / 2,
                    (y1 + y3) / 2, (x2 + x3) / 2, (y2 + y3) / 2, x3, y3);
        } else {
            // desenhar
            int[] vx = {(int) x1, (int) x2, (int) x3};
            int[] vy = {(int) y1, (int) y2, (int) y3};
            g.fillPolygon(vx, vy, 3);

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
