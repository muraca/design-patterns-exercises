package interpreter_visitor_basicregex.model;

public interface Visitor {
	public void visitFreeExpression(FreeExpression f);
	public void visitLiteralExpression(LiteralExpression l);
	public void visitOrExpression(OrExpression o);
	public void visitComposedExpression(ComposedExpression c);
	
	public String getOutput();
}
