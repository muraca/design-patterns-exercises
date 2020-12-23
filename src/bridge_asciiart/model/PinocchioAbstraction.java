package bridge_asciiart.model;

public class PinocchioAbstraction implements AsciiAbstraction {

	@Override
	public String getAscii() {
		return ("        .\n"
				+ "        |\\\n"
				+ "       /| \\\n"
				+ "      / |  \\\n"
				+ "    .'. |   \\\n"
				+ "    '.|_(()))))\n"
				+ "       ((((/.(\n"
				+ "       ,))) _/\n"
				+ "      ((((_(\n"
				+ "       )/  \\\\\n"
				+ "        \\__/-)                     /\\__\n"
				+ "         \\_\\(\\                   .'\\ \\ '.\n"
				+ "         )\\ \\\\\\            ___..' o \\ \\.'\n"
				+ "        /  \\ \\\\\\           ''---.    \\_\\\n"
				+ "       /    '.\\\\\\    . ' ,       '--.'\\_\n"
				+ "      /.    .| \\-'---- O -           \\/O'.\n"
				+ "     (_/    \\ \\| )   ' . '           |O O \\___\n"
				+ "     /.'.__.'._.'                    | O|_O O/\n"
				+ "    /.'.   .'. |                     |O |O O/)\n"
				+ "   / O '._.' '.|                     |_O|_O'/\n"
				+ "  /         O  |                      ||/  /\n"
				+ " /'._________.'|                      \\ )_/\n"
				+ "/''.-.-.-.-.-.-|                       '. \\\n"
				+ "'.____________.'                        \\ _\\\n"
				+ "        |/ /mrf                        __'\\\\\n"
				+ "     __(,\\_\\_ _______  ____   __  ____(_'--_)__");

	}

	@Override
	public String getInfo() {
		return ("Pinocchio with Fata Turchina... (blue fairy?)");
	}

}
