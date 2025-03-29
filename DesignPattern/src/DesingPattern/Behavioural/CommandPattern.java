package DesingPattern.Behavioural;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * Objects passed and Executed as Command
 *
 */

interface Command {
    void undo();
    void execute();
}

abstract class AbstractCommand implements Command {
    TextEditor editor;

    public AbstractCommand(TextEditor editor) {
        this.editor = editor;
    }

    public TextEditor getEditor() {
        return editor;
    }
}

class ClearTextCommand extends AbstractCommand {
    String undo = "";

    public ClearTextCommand(TextEditor editor) {
        super(editor);
    }

    @Override
    public void undo() {
        getEditor().setText(undo);
    }

    @Override
    public void execute() {
        undo = getEditor().getText();
        getEditor().setText("");
    }
}

class TextEditor {
    String text = "";
    Deque<Command> q = new LinkedList<>();

    public void executeCommand(Command cmd) {
        cmd.execute();
        q.offer(cmd);
    }

    public void undo() {
        Command cmd = q.poll();

        if (cmd != null) {
            cmd.undo();
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Deque<Command> getQ() {
        return q;
    }

    public void setQ(Deque<Command> q) {
        this.q = q;
    }
}

public class CommandPattern {

    public static void main(String args[]) {
        TextEditor editor = new TextEditor();
        Command cmd = new ClearTextCommand(editor);
        System.out.println(editor.getText());
        System.out.println("=================");
        editor.setText("123456");
        System.out.println(editor.getText());
        System.out.println("=================");

        editor.executeCommand(cmd);
        System.out.println(editor.getText());
        System.out.println("=================");

        editor.undo();
        System.out.println(editor.getText());
    }
}
