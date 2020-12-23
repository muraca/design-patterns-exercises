package bridge_asciiart.model;

public class CubeAbstraction implements AsciiAbstraction {

	@Override
	public String getAscii() {
		return ("                         ___+._______\n"
				+ "                    __-\"\"   --     __\"\"\"----._____\n"
				+ "             __.--\"\" -- ___--+---_____.     __  .+'|\n"
				+ "       _.-'\"\"  __    +:\"__   | ._..+\"\" __    .+'   F\n"
				+ "     J\"--.____         __ \"\"\"\"\"+\"         .+'  .J  F\n"
				+ "     J        \"\"\"\"\"---.___       --   .+'\"     F'  F\n"
				+ "      L                   \"\"\"\"\"--...+'    .J       F\n"
				+ "      L   F\"9      --.            |   .   F'      J\n"
				+ "      L   -_J      L_J      F\"9   | ;'J    .+J .J J\n"
				+ "      |                     L_J   | F.'  .'| J F' J\n"
				+ "      |        |\"\"\"--.__          | '   |\"\"  J    J\n"
				+ "      J   ._   J ;;; |  \"L        |   . |-___J    |\n"
				+ "      J   L J  J ;-' |   L        | .'J |_  .'  . |\n"
				+ "      J    \"\"  J    .---_L  F\"9   | F.' | .'   FJ |\n"
				+ "       L       J .-'  __ |  L_J   | '   :'     ' .+\n"
				+ "       L       '--.___   |        |       .J   .'\n"
				+ "       |  F\"9         \"\"\"'        |   .   F' .'\n"
				+ "       |  -_J      F\"9            | .'J    .'\n"
				+ "       +__         -_J      F\"9   | F.'  .'\n"
				+ "          \"\"\"--___          L_J   | '  .'   hs\n"
				+ "                  \"\"\"---___       |  .'\n"
				+ "                           \"\"---._|.'");
	}

	@Override
	public String getInfo() {
		return ("A cool ice cube, straight outta Compton uh?");
	}

}
