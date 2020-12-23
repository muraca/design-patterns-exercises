package interpreter_visitor_basicregex.model;

public interface RegularExpression {
	public boolean interpret(String s);
	public void accept(Visitor v);
}
