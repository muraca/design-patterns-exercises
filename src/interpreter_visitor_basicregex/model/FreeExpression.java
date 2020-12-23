package interpreter_visitor_basicregex.model;

public class FreeExpression extends LiteralExpression {

	public FreeExpression() {
		super(' ');
	}
	
	@Override
	public boolean interpret(String s) {
		return ! (s.equals(" ") || s.equals("\n"));
	}

	@Override
	public void accept(Visitor v) {
		v.visitFreeExpression(this);
		
	}
	
}
