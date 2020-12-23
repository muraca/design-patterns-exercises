package interpreter_visitor_basicregex.model;

public class OrExpression implements RegularExpression {

	private LiteralExpression first;
	private LiteralExpression second;

	public OrExpression(LiteralExpression first, LiteralExpression second) {
		this.first = first;
		this.second = second;
	}
	
	public OrExpression(char first, char second) {
		if(first == ' ')
			this.first = new FreeExpression();
		else
			this.first = new LiteralExpression(first);
		

		if(second == ' ')
			this.second = new FreeExpression();
		else
			this.second = new LiteralExpression(second);
	}

	@Override
	public boolean interpret(String s) {
		return first.interpret(s) || second.interpret(s);
	}

	@Override
	public void accept(Visitor v) {
		v.visitOrExpression(this);
		
		first.accept(v);
		
		v.visitOrExpression(this);
		
		second.accept(v);

		v.visitOrExpression(this);
	}

	
}
