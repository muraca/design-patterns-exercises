package interpreter_visitor_basicregex.model;

import java.util.ArrayList;

public class GrammarScheme implements Visitor {
	
	StringBuffer output;
	ArrayList<RegularExpression> visited;
	
	public GrammarScheme() {
		output = new StringBuffer();
		visited = new ArrayList<>();
	}

	@Override
	public void visitFreeExpression(FreeExpression f) {
		output.append("*any* ");

	}

	@Override
	public void visitLiteralExpression(LiteralExpression l) {
		output.append(l.getLiteral() + " ");

	}

	@Override
	public void visitOrExpression(OrExpression o) {
		int counter = 0;
		for(RegularExpression e: visited) {
			if(e == o) {
				counter++;
			}
		}
		
		counter %= 3;
		
		if(counter == 0)
			output.append("(");
		else if(counter == 1)
			output.append("|");
		else if(counter == 2)
			output.append(") ");
		
		visited.add(o);
	}

	@Override
	public void visitComposedExpression(ComposedExpression c) {
		int counter = 0;
		for(RegularExpression e: visited) {
			if(e == c) {
				counter++;
			}
		}

		counter %= 2;
		
		if(counter == 0)
			output.append("(");
		else if(counter == 1)
			output.append(") ");
		
		visited.add(c);
	}

	@Override
	public String getOutput() {
		String out = output.toString();
		
		output = new StringBuffer();
		
		return out;
	}

}
