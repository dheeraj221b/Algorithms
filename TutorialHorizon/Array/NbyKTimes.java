/**
 * NbyKTimes
 */
public class NbyKTimes {

    public static void main(String[] args) {
        int[] arr = { 2, 2, 4, 4, 3, 5, 3, 4, 4, 6, 4, 3, 3, 8 };
        int K = 4;
        int k = arr.length / K;

        Element[] elements = new Element[k];

        for (int j = 0; j < elements.length; j++) {
            elements[j] = new Element(0);
        }

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];

            int presentPos = isPresentInElementsArr(num, elements);

            if (presentPos != -1) {
                Element element = elements[presentPos];
                element.count = element.count + 1;
                element.num = num;
            } else {
                reductAllElementCount(num, elements);
            }
        }

        for (int i = 0; i < elements.length; i++) {
            Element element = elements[i];
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (element.num == arr[j]) {
                    count++;
                }
            }
            if (count > k) {
                System.out.println(element.num + " appear " + count + " times");
            }
        }

    }

    public static int isPresentInElementsArr(int num, Element elements[]) {
        int len = elements.length;

        for (int i = 0; i < len; i++) {
            Element element = elements[i];
            if (element.num == num || element.count == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void reductAllElementCount(int num, Element[] elements) {
        for (int i = 0; i < elements.length; i++) {
            Element element = elements[i];
            element.count = element.count - 1;
        }
    }

    static class Element {
        int num;
        int count;

        public Element(int num) {
            this.num = num;
            this.count = 1;
        }
    }

}