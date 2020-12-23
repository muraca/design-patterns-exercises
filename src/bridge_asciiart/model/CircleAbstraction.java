package bridge_asciiart.model;

public class CircleAbstraction implements AsciiAbstraction {
	
	@Override
	public String getAscii() {
		return ("         , - ~ ~ ~ - ,\n"
				+ "     , '               ' ,\n"
				+ "   ,                       ,\n"
				+ "  ,                         ,\n"
				+ " ,                           ,\n"
				+ " ,                           ,\n"
				+ " ,                           ,\n"
				+ "  ,                         ,\n"
				+ "   ,                       ,\n"
				+ "     ,                  , '\n"
				+ "       ' - , _ _ _ ,  '");

	}

	@Override
	public String getInfo() {
		return("This is a circle (kinda).");
		
	}


}
