package prj.java.infomng.design;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import javax.swing.JTextField;

public class JTextFieldLimit extends PlainDocument { // textfield의 글자 수를 제한 하기 위한 setDocument()메서드를 사용하기 위한 클래스.
  private int limit;
  
  public JTextFieldLimit(int limit) {
    super();
    this.limit = limit;
  }
  
  public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
    if (str == null) return;

    if ((getLength() + str.length()) <= limit) {
      super.insertString(offset, str, attr);
    }
  }
}