/**
 * FindElementsWhichAppearMoreThanNByKTimes
 */
public class FindElementsWhichAppearMoreThanNByKTimes {

    static class Element {
        int element;
        int count;

        public Element(int element, int count) {
            this.element = element;
            this.count = count;
        }

        @Override
        public String toString() {
            return this.element + " : " + this.count;
        }
    }

    public static int findIndex(Element[] elements, int num) {
        for (int i = 0; i < elements.length; i++) {
            Element element = elements[i];
            if (element != null && element.element == num) {
                return i;
            }
        }
        return -1;
    }

    public static void addToArray(Element[] elements, int num) {
        boolean isEmpty = false;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == null) {
                isEmpty = true;
                Element element = new Element(num, 1);
                elements[i] = element;
                break;
            } else if (elements[i].count == 0) {
                isEmpty = true;
                elements[i].count = elements[i].count + 1;
                elements[i].element = num;
            }
        }

        if (!isEmpty) {
            for (int i = 0; i < elements.length; i++) {
                elements[i].count = elements[i].count - 1;
            }
        }

    }

    public static void main(String[] args) {
        int[] arrA = { 2, 2, 4, 4, 3, 5, 3, 4, 4, 6, 4, 3, 3, 8 };
        int k = 4;

        int res = arrA.length / k;
        Element elements[] = new Element[res];
        for (int i = 0; i < arrA.length; i++) {
            int index = findIndex(elements, arrA[i]);
            if (index >= 0) {
                elements[index].count = elements[index].count + 1;
            } else {
                addToArray(elements, arrA[i]);
            }
        }

        for (int i = 0; i < elements.length; i++) {
            int count = 0;

            for (int j = 0; j < arrA.length; j++) {
                if (elements[i] != null && arrA[j] == elements[i].element) {
                    count++;
                }
            }

            if (count > res) {
                System.out.println(elements[i].element + " appear more than " + count + " times");
            }
        }

    }

}