import java.util.*;

/*
 * Build some simple contacts functionality. Given an array of queries that are as follows:
 * add {contact} - add the contact
 * find {substring} - find the number of contacts which start with the substring
 * Solution is to build a trie (accessed via a head node) which stores the characters in the names of the contacts added and the number of children.
 * https://www.hackerrank.com/challenges/ctci-contacts
 */
public class Contacts {

    public static class Node {
        private static int NUMBER_OF_CHARS = 26;
        private Node[] children = new Node[NUMBER_OF_CHARS];
        int size = 0;

        private static int getCharIndex(char c) {
            return c - 'a';
        }

        private Node getNode(char c) {
            return children[getCharIndex(c)];
        }

        private void setNode(char c, Node node) {
            children[getCharIndex(c)] = node;
        }

        public void add(String s) {
            add(s, 0);
        }

        private void add(String s, int index) {
            size++;
            if (index == s.length()) return;

            char current = s.charAt(index);
            Node child = getNode(current);

            if (child == null) {
                child = new Node();
                setNode(current, child);
            }

            child.add(s, index + 1);
        }

        public int findCount(String s, int index) {
            if (index == s.length()) return size;

            Node child = getNode(s.charAt(index));
            if (child == null) return 0;
            return child.findCount(s, index + 1);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        Node trie = new Node();

        for (int nItr = 0; nItr < n; nItr++) {
            String[] opContact = scanner.nextLine().split(" ");

            String op = opContact[0];

            String contact = opContact[1];
            switch(op) {
                case "add":
                    trie.add(contact);
                    break;
                case "find":
                    System.out.println(trie.findCount(contact, 0));
                    break;
                default:
                    break;
            }
        }

        scanner.close();
    }
}
