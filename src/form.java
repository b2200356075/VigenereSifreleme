import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class form extends JFrame{
    private JPanel panel1;
    private JButton button1;
    private JFormattedTextField formattedTextField1;
    private JFormattedTextField formattedTextField2;
    private JFormattedTextField formattedTextField3;


    // içine aldığı yazı alanında, alfabede bulunmayan karakterleri kaldıran fonksiyon
    public JFormattedTextField fixTitle(JFormattedTextField formattedTextField){

        String message = formattedTextField.getText();


        while(message.length() != 0){
         /* yazı alanında yazı bulunduğu sürece bu döngüyü tekrarlar, yazının sonundan başlayarak
         alfabede bulunmayan karakterleri kaldırır
         alfabede bulunan bir karaktere denk geldiği an döngüden çıkar */


            formattedTextField.setText(message);


            if(message.length() != 0){
                char lastChar = message.charAt(message.length()-1);

                if(Cryptor.getAlphabet().indexOf(lastChar) != -1 || lastChar == ' '){
                    break;
                }
                else{
                    message = message.substring(0,message.length()-1);
                    formattedTextField.setText(message);
                }
            }

        }

        return formattedTextField;

    }


    // verilen en ve yükseklik değerlerine sahip paneli ekranın tam ortasına yerleştirir
    public void setBoundsAtMiddle(int width, int height){

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();



        int newX = (screenWidth - width)/2;
        int newY = (screenHeight - height)/2;

        setBounds(newX,newY,width,height);

    }



    public form(){


        ArrayList<Cryptor> options = new ArrayList<>();
        options.add(new Encryptor());
        options.add(new Decryptor());
        // options isimli ArrayList, Encryptor ve Decryptor tipinden birer nesneyi, içindeki fonksiyonları kullanmak üzere tutar.

        final int[] index = {0};


        add(panel1);

        setTitle("Şifreleyici ve şifre çözücü");
        
        setBoundsAtMiddle(600,300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // açılan form kapatıldığında, formu RAM üzerinden silmeye yarayan komut

        button1.setText("Şifreleyici");


        formattedTextField1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {

                String message = formattedTextField1.getText();

                String key = formattedTextField2.getText();
                if(key.length() != 0){

                    String cipherText = options.get(index[0]).getCipherText(message,key);
                    formattedTextField3.setText(cipherText);
                }

            }


        });


        formattedTextField2.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

                char c = e.getKeyChar();

                if(Cryptor.getAlphabet().indexOf(c) == -1){
                    e.setKeyCode(0); // eğer alfabede olmayan bir karakter girilirse, bu karakteri siler
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {

                // anahtar kısmında boşluk olmaması gerektiğinden boşlukları siler.
                formattedTextField2.setText(formattedTextField2.getText().replace(" ",""));
                formattedTextField2 = fixTitle(formattedTextField2);

                String message = formattedTextField1.getText();
                String key = formattedTextField2.getText();


                // eğer anahtar kısmı boşsa, kod hata vereceğinden dolayı
                // bir koşul bloğuyla bu durumun önüne geçilir.
                if(formattedTextField2.getText().length() != 0){
                    String cipherText = options.get(index[0]).getCipherText(message,key);
                    formattedTextField3.setText(cipherText);
                }

            }



        });


        // düğmeye basıldığında işlev, şifreleme ve şifre çözme arasında yer değiştirir
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                index[0] +=1;
                if(index[0] >= options.size()){
                    index[0] = 0;
                    button1.setText("Şifreleyici");
                }
                else{
                    button1.setText("Şifre çözücü");
                }


                //1. yazı alanı ile 3. yazı alanındaki yazıların yerini değiştirir.
                String cipherText = formattedTextField3.getText();
                formattedTextField3.setText(formattedTextField1.getText());
                formattedTextField1.setText(cipherText);

            }
        });


    }

}
