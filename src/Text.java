import java.util.*;

public class Text {
    private String text;
    private String unsupported = "./,/!/(/)/\'/\"/?/:/;/-/ ";
    private List<String> unsupportedChars = new ArrayList<>(Arrays.asList(unsupported.split("/")));

    public Text() {
    }

    public Text(String text) {
        this.text = text;
    }

    public Map<Character, Integer> charCount() {
        Map<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < text.length(); i++) {
            if (isSupportedChar(text.charAt(i))) {
                Integer n = map.get(Character.toLowerCase(text.charAt(i)));
                if (n == null) map.put(Character.toLowerCase(text.charAt(i)), 1);
                else map.put(Character.toLowerCase(text.charAt(i)), ++n);
            }
        }
        return sortMap(map);
    }

    private Map<Character, Integer> sortMap(Map<Character, Integer> map) {
        if (map == null) {
            throw new IllegalArgumentException();
        }
        Map<Character, Integer> linkedMap = new LinkedHashMap<>();
        Character tmp = ' ';
        boolean del = false;

        int j = map.size();
        for (; j > linkedMap.size(); ) {
            boolean stop = false;
            for (Iterator<Character> itr = map.keySet().iterator(); !stop; ) {
                Character k = itr.next();
                tmp = k;
                Integer v = map.get(k);

                if (v.equals(Collections.max(map.values()))) {
                    linkedMap.put(k, v);
                    del = true;
                    stop = true;
                }
            }
            if (del) {
                map.remove(tmp);
                del = false;
            }
        }
        return linkedMap;
    }

    private boolean isSupportedChar(char ch) {
        for (String unsupportedChar : unsupportedChars) {
            if (ch == unsupportedChar.charAt(0)) {
                return false;
            }
        }
        return true;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Text text1 = (Text) o;
        return Objects.equals(text, text1.text);
    }

    @Override
    public int hashCode() {

        return Objects.hash(text);
    }

    @Override
    public String toString() {
        return "Text{" +
                "text='" + text + '\'' +
                '}';
    }
}
