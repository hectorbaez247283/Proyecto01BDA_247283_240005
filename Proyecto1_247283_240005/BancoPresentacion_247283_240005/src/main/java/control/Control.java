/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Christopher
 * @author Francisco
 */
public class Control {

    public static void setImageLabel(JFrame frame, JLabel labelName, String root) {
        ImageIcon img = new ImageIcon(root);
        Icon icon = new ImageIcon(img.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
        labelName.setIcon(icon);
        frame.repaint();
    }

    public static void soloLetras(KeyEvent e) {
        char c = e.getKeyChar();
        // Solo permite la entrada de letras con acentos (áéíóúüÁÉÍÓÚÜ)
        if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= 'á' && c <= 'ü') || (c >= 'Á' && c <= 'Ü'))) {
            e.consume(); // Ignora el evento si no es una letra con acentos
            Toolkit.getDefaultToolkit().beep(); // Emite un sonido de advertencia
        }
    }

    public static void soloNumeros(KeyEvent e, int length) {
        char c = e.getKeyChar();
        // Solo permite la entrada de números y controla la longitud máxima
        if (!((c >= '0' && c <= '9'))) {
            e.consume(); // Ignora el evento si no es un número o se excede el límite de caracteres
            Toolkit.getDefaultToolkit().beep(); // Emite un sonido de advertencia
        }
    }
}
