import java.util.*;

/*
 * Given a set of input queries, perform the correct action on the heap. It seems that they don't want you to implement a heap here, but just use PriorityQueue to handle
 * the data.
 * https://www.hackerrank.com/challenges/qheap1
 */
public class QHeap {
        public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            String[] query = in.nextLine().split(" ");

            switch(query[0]) {
                case "1":
                    pq.add(Integer.parseInt(query[1]));
                    break;
                case "2":
                    pq.remove(Integer.parseInt(query[1]));
                    break;
                case "3":
                    System.out.println(pq.peek());
                    break;
                default:
                    break;
            }
        }
    }
}