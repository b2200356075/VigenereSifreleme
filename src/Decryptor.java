import java.util.ArrayList;

public class Decryptor extends Cryptor{

    private String alphabet;

    public Decryptor(){
        this.alphabet = Cryptor.getAlphabet();
    }

    //Girdi olarak şifrelenmiş yazıyı ve anahtarı alır ve şifreli yazının şifresini çözer.
    @Override
    public String getCipherText(String message, String key){


        ArrayList<Integer> messageInteger = toIntegerFormat(message);
        ArrayList<Integer> keyInteger = toIntegerFormat(key);
        ArrayList<Integer> cipherInteger = new ArrayList<>();

        int keyIndex = 0;

        for(Integer integer: messageInteger){

            int sum = 0;

            if(integer == null){
                cipherInteger.add(integer);
                keyIndex -=1;
            }
            else if(integer < keyInteger.get(keyIndex)){
                sum = integer - keyInteger.get(keyIndex) + (alphabet.length() + 1);
                cipherInteger.add(sum);
            }
            else{
                sum = integer - keyInteger.get(keyIndex) + 1;
                cipherInteger.add(sum);
            }



            keyIndex += 1;

            if(keyIndex == keyInteger.size()){
                keyIndex = 0;
            }

        }

        String cipherText = toStringFormat(cipherInteger);
        return cipherText;
    }
}
