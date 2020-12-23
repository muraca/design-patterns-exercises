package interpreter_visitor_basicregex.model;

import java.util.ArrayList;

public class ComposedExpression implements RegularExpression {
	
	ArrayList<RegularExpression> expressions;
	
	public ComposedExpression () {
		expressions = new ArrayList<>();
	}
	
	public ComposedExpression (String s) {
		expressions = new ArrayList<>();
		
		for (int i = 0; i < s.length(); i++) { 
			char c = (s.charAt(i));
			if (c == ' ')
				expressions.add(new FreeExpression());
			else
				expressions.add(new LiteralExpression(c));
		}
	}
	
	public void addExpression (RegularExpression exp) {
		if(exp instanceof ComposedExpression) {
			ComposedExpression ce = (ComposedExpression) exp;
			for(RegularExpression e: ce.expressions)
				addExpression(e);
		}
		else
			expressions.add(exp);
	}

	@Override
	public boolean interpret(String s) {
		if(s.length() != expressions.size())
			return false;
		
		for(int i = 0; i < s.length(); i++) {
			if(!expressions.get(i).interpret(new String(new char[]{s.charAt(i)})))
				return false;
		}
		
		
		return true;
	}

	@Override
	public void accept(Visitor v) {
		v.visitComposedExpression(this);
		
		for(RegularExpression e: expressions)
			e.accept(v);
		
		v.visitComposedExpression(this);
		
	}
	
	
	
}
