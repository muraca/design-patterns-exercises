package interpreter_visitor_basicregex.model;

public class LiteralExpression implements RegularExpression {

	private char literal;

	public LiteralExpression(char literal) {
		this.literal = literal;
	}
	
	@Override
	public boolean interpret(String s) {
		return s.charAt(0) == (literal);
	}

	@Override
	public void accept(Visitor v) {
		v.visitLiteralExpression(this);
		
	}
	
	public char getLiteral() {
		return literal;
	}

}
