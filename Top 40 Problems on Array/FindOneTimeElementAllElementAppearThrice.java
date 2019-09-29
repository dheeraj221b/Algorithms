/**
 * FindOneTimeElementAllElementAppearThrice
Objec­tive:  Given an array of integers in which all the elements are appear thrice but one 
which appears only one. Write an algorithm to find that element.

Example
int [] arrA = {6,5,3,2,4,2,5,6,3,3,6,5,2};/
Output: 4
 */
public class FindOneTimeElementAllElementAppearThrice {

    public static void main(String[] args) {
       // int [] arrA = {6,5,3,2,4,2,5,6,3,3,6,5,2};
       int arrA [] = {1, 4, 5, 6, 1, 4, 6, 1, 4, 6};

        int num = 0;
        for (int i = 0; i < 32; i++) {
            int y = 1 << i;
            int count = 0;
            for(int j=0;j<arrA.length;j++){
                if((y & arrA[j]) != 0){
                    count++;
                }
            }
            if(count % 3 != 0){
                num = num | y;
            }
        }
        System.out.println(num);
    }
}