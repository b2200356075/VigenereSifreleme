import javax.swing.*;

public class Main {
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {

    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//çalışılan işletim sisteminin arayüzünü kullanmamızı sağlayan komut


        /**
         * Şifreleyici, şifreleme yaparken Vigenere şifreleme mantığını kullanır.
         * Vigenere şifreleme, özet olarak şifrelenmesi istenen bir mesajın anahtar kullanılarak şifrelenmesidir.
         */



        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                form f = new form();
                f.setVisible(true);
            }
        });
    }
}
