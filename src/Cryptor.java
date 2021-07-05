import java.util.ArrayList;

public class Cryptor{


    private static String alphabet;

    //şifreleme yapılacak alfabe: eğer alfabe değişirse bu şifrelenecek mesaj ve anahtar aynı olsa bile çıktı değişir
    //kullanılacak alfabedeki her karakter sadece birer kez yazılmalıdır.
    public Cryptor(){
        this.alphabet = "abcdefghijklmnopqrstuvwxyz";
    }

    public String getCipherText(String message, String key){
        return "";
    }


    // String türünde bir veri alır ve tüm karakterlerini sayısal değerlere dönüştürür.
    // Eğer alfabede bulunmayan bir karakter string veri tipinin içindeyse, boşlukmuş gibi muamele görür.
    public ArrayList<Integer> toIntegerFormat(String s){

        ArrayList<Integer> integers = new ArrayList<>();
        int index;

        for(int i = 0; i < s.length();i++){

            if(s.charAt(i) == ' ' || getAlphabet().indexOf(s.charAt(i)) == -1){
                integers.add(null);
            }
            else{
                char letter = s.charAt(i);
                index = getAlphabet().indexOf(letter) + 1;
                integers.add(index);
            }


        }


        return integers;

    }

    // Integer ArrayList tipindeki veri tipini String veri tipine dönüştürür
    public String toStringFormat(ArrayList<Integer> integers){
        String message = "";


        for(Integer integer: integers){
            if(integer != null){
                char letter = getAlphabet().charAt(integer -1);
                message += letter;
            }

            else{
                message += " ";
            }

        }

        return message;
    }


    public static String getAlphabet() {
        return alphabet;
    }
}
