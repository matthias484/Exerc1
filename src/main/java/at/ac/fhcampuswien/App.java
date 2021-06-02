package at.ac.fhcampuswien;

public class App {

    public boolean checkPassword(String pw) {
        return checkPasswordLength(pw) && checkUpperAndLowerCase(pw) && checkNumbers(pw) && specialChars(pw) && checkContinuousNumbers(pw) && checkNumbersInARow(pw);
    }

    public boolean checkPasswordLength(String pw){
        if(pw.length() < 8 )
            return false;
        return pw.length() <= 25;
    }

    public boolean checkUpperAndLowerCase(String pw){

        boolean upperCase = false;
        boolean lowerCase = false;

        for(int i=0;i < pw.length();i++) {
            char ch = pw.charAt(i);
            if (Character.isUpperCase(ch))
                upperCase = true;
            if (Character.isLowerCase(ch))
                lowerCase = true;
            if(upperCase && lowerCase )
                return true;
        }
        return false;
    }

    public boolean checkNumbers(String pw){
        char[] chars = pw.toCharArray();
        for(char c : chars){
            if(Character.isDigit(c)){
                return true;
            }
        }
        return false;
    }

    public boolean specialChars(String pw){
        String specialCharactersString = "()#$?!%/@";
        for (int i=0; i < pw.length() ; i++) {
            char ch = pw.charAt(i);
            if(specialCharactersString.contains(Character.toString(ch))) {
                return true;
            }
        }
        return false;
    }

    public boolean checkContinuousNumbers(String pw){
        return !pw.contains("012") && !pw.contains("123") && !pw.contains("234") && !pw.contains("345") && !pw.contains("456") && !pw.contains("567") && !pw.contains("678") && !pw.contains("789");
    }

    public boolean checkNumbersInARow(String pw){
        return !pw.contains("0000") && !pw.contains("1111") && !pw.contains("2222") && !pw.contains("3333") && !pw.contains("4444") && !pw.contains("5555") && !pw.contains("6666") && !pw.contains("7777") && !pw.contains("8888") && !pw.contains("9999");
    }

}
