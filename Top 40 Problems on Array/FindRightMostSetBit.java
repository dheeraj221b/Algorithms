/**
 * FindRightMostSetBit
Objective: Given a number, write and algorithm  to find the right most set bit in it (In binary representation).
Example:
Number : 1
Binary representation: 1
Position of right most set bit: 1

Number : 6
Binary representation: 1 1 0
Position of right most set bit: 2

Number : 11
Binary representation: 1 0 1 1
Position of right most set bit: 1

Number : 24
Binary representation:  1 1 0 0 0
Position of right most set bit: 4
 */
public class FindRightMostSetBit {

    public static void main(String[] args) {
        
        int no = 12;
        
        findRightMostBitNaiveApproach(no);

        findRightMostBitFormulaApproach(no);
    }

    public static void findRightMostBitNaiveApproach(int no) {
        int pos = 1;
        while(no > 0){
            if(no % 2 == 0){
                pos++;
                no = no / 2;
            }else{
                break;
            }
        }
        System.out.println(pos);
    }

    public static void findRightMostBitFormulaApproach(int n) {
        double pos = 1 + Math.log(n & ~(n-1)) / Math.log(2);
        System.out.println(pos);
    }

}