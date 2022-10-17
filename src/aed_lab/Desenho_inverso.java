// DESENHA OS TRIANGULOS BRANCOS 

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class Desenho_inverso extends Canvas {

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        criaTriangulo(g);

    }

    private void criaTriangulo(Graphics g) {
        double largura = getWidth() - 5;
        double altura = getHeight() - 5;

        criaTrianguloMaior(g, 0, altura, largura / 2, 0, largura, altura);
        
        criaTrianguloRecu(g, 0, 7, 0, altura, largura / 2, 0, largura, altura);

    }

    private void criaTrianguloMaior(Graphics g, double x1, double y1, double x2, double y2, double x3, double y3) {
        int[] vx = {(int) x1, (int) x2, (int) x3};
        int[] vy = {(int) y1, (int) y2, (int) y3};

        g.setColor(Color.BLACK);
        g.fillPolygon(vx, vy, 3);
    }
//    private void criaTBranco(Graphics g, double x1, double y1, double x2, double y2, double x3, double  y3){
//        double x12 = (x1+x2)/2;
//        double y12 = (y1+y2)/2;
//        double x23 = (x3+x2)/2;
//        double y23 = (y3+y2)/2;
//        double x13 = (x1+x3)/2;
//        double y13 = (y1+y3)/2;
//        
//        //desenhar
//        int[] vx = {(int) x12, (int) x23, (int) x13};
//        int[] vy = {(int) y12, (int) y23, (int) y13};
//        g.setColor(Color.WHITE);
//        g.fillPolygon(vx, vy, 3);
//    }

    private void criaTrianguloRecu(Graphics g, int nivel, int nivelMax,
            double x1, double y1, double x2, double y2, double x3, double y3) {
        double x12 = (x1 + x2) / 2;
        double y12 = (y1 + y2) / 2;
        double x23 = (x3 + x2) / 2;
        double y23 = (y3 + y2) / 2;
        double x13 = (x1 + x3) / 2;
        double y13 = (y1 + y3) / 2;

        if (nivel < nivelMax) {
            
            //desenhar
            int[] vx = {(int) x12, (int) x23, (int) x13};
            int[] vy = {(int) y12, (int) y23, (int) y13};
            g.setColor(Color.WHITE);
            g.fillPolygon(vx, vy, 3);
            
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
//          triangulo esquerda
            criaTrianguloRecu(g, nivel + 1, nivelMax, x1, y1, (x1 + x2) / 2, (y1 + y2) / 2, (x1 + x3) / 2, (y1 + y3) / 2);
//           triangulo de cima
            criaTrianguloRecu(g, nivel + 1, nivelMax, (x1 + x2) / 2, (y1 + y2) / 2, x2, y2, (x2 + x3) / 2, (y2 + y3) / 2);
//           triangulo de direita
            criaTrianguloRecu(g, nivel + 1, nivelMax, (x1 + x3) / 2, (y1 + y3) / 2, (x2 + x3) / 2, (y2 + y3) / 2, x3, y3);

        }

    }

}
