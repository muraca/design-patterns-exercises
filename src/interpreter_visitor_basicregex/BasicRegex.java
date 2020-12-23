package interpreter_visitor_basicregex;

import interpreter_visitor_basicregex.model.*;

public class BasicRegex {
	public static void main(String[] args) {
		ComposedExpression syntaxTree = new ComposedExpression("a ada");
		syntaxTree.addExpression(new OrExpression('a', 'b'));
				
		Visitor v = new GrammarScheme();
		syntaxTree.accept(v);
		System.out.println(v.getOutput());
		
		String str = "aaadab";
		System.out.println("Testing: " + str);
		
		if (syntaxTree.interpret(str))
			System.out.println("It's good!");
		else
			System.out.println("It's wrong!");
		
		str = "afadaa";
		System.out.println("Testing: " + str);
		
		if (syntaxTree.interpret(str))
			System.out.println("It's good!");
		else
			System.out.println("It's wrong!");
		
		str = ("a adaa");
		System.out.println("Testing: " + str);
		
		if (syntaxTree.interpret(str))
			System.out.println("It's good!");
		else
			System.out.println("It's wrong!");
		
		
		v = new GrammarExplainer();
		syntaxTree.accept(v);
		System.out.println(v.getOutput());
	}
}
