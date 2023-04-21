package prj.java.infomng.design;

import javax.swing.text.*;

public class RegexTextField extends DocumentFilter {
    private final String regex;

    public RegexTextField(String regex) {
        this.regex = regex;
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
            throws BadLocationException {
        StringBuilder builder = new StringBuilder();
        builder.append(fb.getDocument().getText(0, fb.getDocument().getLength()));
        builder.insert(offset, string);

        if (builder.toString().matches(regex)) {
            super.insertString(fb, offset, string, attr);
        } else {
            // 입력값이 정규식과 일치하지 않는 경우
            // 아무 작업도 하지 않고 입력값을 무시합니다.
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
            throws BadLocationException {
        StringBuilder builder = new StringBuilder();
        builder.append(fb.getDocument().getText(0, fb.getDocument().getLength()));
        builder.replace(offset, offset + length, text);

        if (builder.toString().matches(regex)) {
            super.replace(fb, offset, length, text, attrs);
        } else {
            // 입력값이 정규식과 일치하지 않는 경우
            // 아무 작업도 하지 않고 입력값을 무시합니다.
        }
    }
}
