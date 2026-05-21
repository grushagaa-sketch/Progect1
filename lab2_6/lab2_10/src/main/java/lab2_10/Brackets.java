package lab2_10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class Brackets {

    /*
    private static boolean correctStr(String str) {
        String all = "-1234567890\"';:.,()[]{}!?/ \t\n\r";
        boolean flag=true;
        for (int i=0; i<str.length(); i++) {
            if (!Character.isLetter(str.charAt(i))) {
                flag=false;
                for (int j=0; j<all.length();j++) {
                    if (all.charAt(j)==str.charAt(i)) {
                        flag=true;
                        break;
                    }
                }
                if (!flag) return false;
            }
        }
        return true;
    }

     */
    public static int correctJson(String file_name) throws NullPointerException, NotTextFileException, IOException {
        if (file_name==null) throw new NullPointerException();


        int i=0;
        Stack<Character> stack = new Stack<>();
        String str = "";
        try(FileReader fis = new FileReader(file_name)){

            int c;
            while ((c = fis.read())!=-1) {
                char cc = (char) c;

                if (!Character.isLetter(cc)) {
                    String allowed = "-1234567890\"';:.,()[]{}!?/ \t\n\r";
                    if (allowed.indexOf(cc) == -1) {
                        throw new NotTextFileException("недопустимый символ: " + cc);
                    }
                }

                str += cc;

                if (cc == '[' || cc == '(' || cc == '{') {
                    stack.push(cc);
                } else if (cc == ']' || cc == ')' || cc == '}') {
                    if (stack.empty()) return i;
                    char a = stack.pop();
                    if ((a=='[' && cc!=']') || (a=='(' && cc!=')') || (a=='{' && cc!='}')) {
                        return i;
                    }
                }

                ++i;
            }
            if (!stack.empty()) return i;

            //if (!correctStr(str)) throw new NotTextFileException("файл не текстовый");
            //System.out.println(correctStr(str));
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        int a=correctJson("JSON.json");
        System.out.println(a);
    }
}
