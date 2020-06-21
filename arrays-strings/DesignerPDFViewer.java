import java.util.*;

/*
 * Given a word and an array representing the heights of each letter, return the area required to highlight the word in a PDF viewer.
 * https://www.hackerrank.com/challenges/designer-pdf-viewer
 */
public class DesignerPDFViewer {
    public int designerPdfViewer(int[] h, String word) {
        int tallest = 0;
        int len = word.length();

        for (int i = 0; i < len; i++) {
            int currentHeight = h[word.charAt(i) - 'a'];
            if (currentHeight > tallest) {
                tallest = currentHeight;
            }
        }

        return tallest * len;
    } 
}