import java.util.*;

/*
 * Implement a queue using 2 stacks. Parse the input which contains a list of queries. The first number in the query indicates the type of action required:
 * 1 - enqueue (this is the only query with a second value, which is the data to enqueue).
 * 2 - dequeue 
 * 3 - Log the next item in the queue to std out without removing it 
 * https://www.hackerrank.com/challenges/queue-using-two-stacks
 */
public class QueueUsing2Stacks {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        
        int queries = Integer.parseInt(in.nextLine());
        Queue q = new Queue();

        for(int i = 0; i < queries; i++) {
            String[] query = in.nextLine().split("\\s+");

            switch(query[0]) {
                case "1":
                    q.enqueue(Integer.parseInt(query[1]));
                    break;
                case "2":
                    q.dequeue();
                    break;
                case "3":
                    System.out.println(q.peek());
                    break;
                default:
                    break;
            }
        }
    }

    public static class Queue {
        Stack<Object> forward;
        Stack<Object> reversed;

        public Queue() {
            forward = new Stack<>();
            reversed = new Stack<>();
        }

        public void enqueue(Integer data) {
            forward.push(data);
        }

        public Object dequeue() {
            shiftStacks();
            return reversed.pop();
        }

        public Object peek() {
            shiftStacks();

            return reversed.peek();
        }

        private void shiftStacks() {
          if (reversed.isEmpty()) {
                while(!forward.isEmpty()) {
                    reversed.push(forward.pop());
                }
            }
        }
    }
}