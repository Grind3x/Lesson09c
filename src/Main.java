public class Main {
    public static void main(String[] args) {

        TextDAO textDAO = new TextDAOFileImplementation();
        TextController textController = new TextController(textDAO);
        Text text = textController.loadText();

        System.out.println(text.charCount());

        }
    }


