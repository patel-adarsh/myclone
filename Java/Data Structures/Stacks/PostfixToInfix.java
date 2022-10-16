import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class PostfixToInfix {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
    
        // code
        System.out.println(infix(exp));
     }

    public static String infix(String str){
        
        Stack<String> operand = new Stack<>();

        for(int i=0 ; i<str.length() ; i++){
            
            char ch = str.charAt(i);

            if('0' <= ch && ch <= '9'){
                operand.push(ch+"");
            }
            else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                String b = operand.pop();
                String a = operand.pop();
                operand.push("("+a+ch+b+")");
            }
        }
        return operand.peek();
    }

    public static int prec(char ch){
        if(ch == '*' || ch == '/'){
            return 2;
        }
        else{
            return 1;
        }
    }
}
