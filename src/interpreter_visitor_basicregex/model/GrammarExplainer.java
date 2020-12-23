package interpreter_visitor_basicregex.model;

import java.util.ArrayList;

public class GrammarExplainer implements Visitor {
	
	StringBuffer output;
	ArrayList<RegularExpression> visited;
	
	public GrammarExplainer() {
		output = new StringBuffer();
		visited = new ArrayList<>();
	}
	
	@Override
	public void visitFreeExpression(FreeExpression f) {
		output.append("FreeExpression, it could be any char except space or newLine.\n");

	}

	@Override
	public void visitLiteralExpression(LiteralExpression l) {
		output.append("LiteralExpression: " + l.getLiteral() + "\n");

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
			output.append("OrExpression: this character may be:\n");
		else if(counter == 1)
			output.append("or it may be:\n");
		else if(counter == 2)
			output.append("and nothing else.\n");
		
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
			output.append("This is the beginning of a ComposedExpression\n");
		else if(counter == 1)
			output.append("This is the end of a ComposedExpression\n");
		
		visited.add(c);

	}

	@Override
	public String getOutput() {
		String out = output.toString();
		
		output = new StringBuffer();
		
		return out;
	}

}
