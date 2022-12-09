package pack2;

public class fact {
	 static void permutation(String string){
        int [] factorials = new int[string.length()+1];
        factorials[0] = 1;
        for (int i = 1; i<=string.length();i++) {
            factorials[i] = factorials[i-1] * i;
        }

        for (int i = 0; i < factorials[string.length()]; i++) {
            String onePermutation="";
            String temp = string;
            int positionCode = i;
            for (int position = string.length(); position > 0 ;position--)
            {
                int selected = positionCode / factorials[position-1];
               // System.out.println(selected);
                onePermutation += temp.charAt(selected);
               // System.out.println(onePermutation+"  "+position);
                positionCode = positionCode % factorials[position-1];
                temp = temp.substring(0,selected) + temp.substring(selected+1);
               //
                System.out.println(temp+"   "+selected);
            }
            System.out.println(onePermutation);
        }
	}
	 public static void main(String[] args)
	 {
		permutation("abc"); 
	 }
}
