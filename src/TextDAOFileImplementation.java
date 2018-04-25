import java.io.*;

public class TextDAOFileImplementation implements TextDAO {
    @Override
    public Text loadText() {
        Text text = null;
        String str = "";
        String s = "";
        try (BufferedReader br = new BufferedReader(new FileReader("text.txt"))) {
            for (;(s=br.readLine())!=null;) {
                str += s;
            }
            text = new Text(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }
}
