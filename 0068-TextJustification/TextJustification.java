
import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        List<String> line = new ArrayList<>();
        int currLen = 0;
        for (String word : words) {
            int wordLen = word.length();
            int size = line.size();
            if ((currLen + size + wordLen) > maxWidth) {
                res.add(justify(line, currLen, maxWidth));
                line.clear();
                currLen = 0;
            }
            line.add(word);
            currLen += wordLen;
        }
        String lastLine = String.join(" ", line);
        lastLine += " ".repeat(maxWidth - lastLine.length());
        res.add(lastLine);
        return res;
    }

    private String justify(List<String> line, int currLen, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        int gaps = line.size() - 1;
        if (gaps == 0) {
            return line.get(0) + " ".repeat(maxWidth - currLen);
        }
        int totalSpaces = maxWidth - currLen;
        int space = totalSpaces / gaps;
        int extra = totalSpaces % gaps;
        for (int i = 0; i <= gaps; i++) {
            sb.append(line.get(i));
            if (i < gaps) {
                sb.append(" ".repeat(space + (i < extra ? 1 : 0)));
            }
        }
        return sb.toString();
    }
}

/*
 * public List<String> fullJustify(String[] words, int maxWidth) {
 * List<String> res = new ArrayList<>();
 * int currentWidth = 0;
 * List<List<String>> lines = new ArrayList<>();
 * List<String> line = new ArrayList<>();
 * for (String word : words) {
 * if (currentWidth + word.length() + (line.isEmpty() ? 0 : 1) > maxWidth) {
 * lines.add(new ArrayList<>(line));
 * line.clear();
 * currentWidth = 0;
 * }
 * line.add(word);
 * currentWidth += word.length() + (line.size() > 1 ? 1 : 0);
 * }
 * if (!line.isEmpty()) {
 * lines.add(new ArrayList<>(line));
 * }
 * 
 * for (int i = 0; i < lines.size() - 1; i++) {
 * res.add(justify(lines.get(i), maxWidth));
 * }
 * String lastLine = String.join(" ", lines.get(lines.size() - 1));
 * res.add(lastLine + " ".repeat(maxWidth - lastLine.length()));
 * return res;
 * }
 * 
 * private String justify(List<String> line, int maxWidth) {
 * StringBuilder sb = new StringBuilder();
 * int length = line.stream().mapToInt(String::length).sum();
 * int totalSpace = maxWidth - length;
 * 
 * if (line.size() == 1) {
 * sb.append(line.get(0));
 * sb.append(" ".repeat(totalSpace));
 * return sb.toString();
 * }
 * 
 * int a = totalSpace / (line.size() - 1);
 * int b = totalSpace % (line.size() - 1);
 * sb.append(line.get(0));
 * for (int i = 1; i < line.size(); i++) {
 * sb.append(" ".repeat(a));
 * if (i <= b)
 * sb.append(' ');
 * sb.append(line.get(i));
 * }
 * return sb.toString();
 * }
 */