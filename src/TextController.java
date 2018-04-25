public class TextController {
    TextDAO textDAO;

    public TextController(TextDAO textDAO) {
        this.textDAO = textDAO;
    }

    public TextDAO getTextDAO() {
        return textDAO;
    }

    public void setTextDAO(TextDAO textDAO) {
        if (textDAO == null) {
            throw new IllegalArgumentException();
        }
        this.textDAO = textDAO;
    }

    public Text loadText() {
        return textDAO.loadText();
    }
}
