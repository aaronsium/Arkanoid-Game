import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Back ground 4.
 */
public class BackGround4 implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(0x35A1BD));
        d.fillRectangle(0, 0, 800, 800);
        //left rain
        d.setColor(Color.WHITE);
        d.drawLine(200, 560, 100, 800);
        d.drawLine(210, 560, 110, 800);
        d.drawLine(220, 560, 120, 800);
        d.drawLine(230, 560, 130, 800);
        d.drawLine(240, 560, 140, 800);
        d.drawLine(250, 560, 150, 800);
        d.drawLine(260, 560, 160, 800);
        //right rain
        d.drawLine(600, 560, 500, 800);
        d.drawLine(610, 560, 510, 800);
        d.drawLine(620, 560, 520, 800);
        d.drawLine(630, 560, 530, 800);
        d.drawLine(640, 560, 540, 800);
        d.drawLine(650, 560, 550, 800);
        d.drawLine(660, 560, 560, 800);
        d.setColor(Color.DARK_GRAY);
        d.fillCircle(640, 575, 55);
        d.setColor(Color.GRAY);
        d.fillCircle(670, 605, 15);
        d.fillCircle(600, 595, 20);
        d.fillCircle(620, 625, 30);
        d.fillCircle(650, 625, 20);


        d.setColor(new Color(70, 70, 70));
        d.fillCircle(250, 520, 55);
        d.setColor(new Color(87, 87, 87));
        d.fillCircle(270, 560, 15);

        d.setColor(new Color(90, 90, 90));
        d.fillCircle(225, 585, 30);
        d.setColor(Color.GRAY);
        d.fillCircle(250, 585, 20);

    }

    @Override
    public void timePassed() {

    }
}
