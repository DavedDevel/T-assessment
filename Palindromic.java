import java.util.Optional;

public class Palindromic {

        public static void main(String[] args) {
            if(args.length>0) {
                var sequence = args[0];
                System.out.println(longestPalidrome(sequence));
            }else{
                System.out.println("");
            }
        }

        private static String longestPalidrome(String sequence){

            if(Optional.ofNullable(sequence).isEmpty()){
                return "";
            }
            var size=-1;
            var candidate = "";
            for (var i =0; i<sequence.length();i++){
                for(var j= sequence.length()-1-i;j>0;j--){
                    if(isPalindrome(sequence, i, j)){
                        if(j-i> size){
                            size=j-i;
                            candidate=sequence.length()-1==j?sequence.substring(i):sequence.substring(i,j+1);
                        }
                    }
                }
            }

            return candidate;
        }

        private static boolean isPalindrome(String sequence, int i, int j){
            while(i<j && sequence.charAt(i)==sequence.charAt(j)){
                i++;
                j--;
            }
            return i==j || j<i;
        }



}
