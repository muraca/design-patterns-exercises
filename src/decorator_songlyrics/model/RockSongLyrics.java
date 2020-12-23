package decorator_songlyrics.model;

public class RockSongLyrics implements Lyrics {
	
	public RockSongLyrics() {}
	
	@Override
	public String getLyrics() {
		return "All along the watchtower\n"
				+ "Princes kept the view\n"
				+ "While all the women came and went\n"
				+ "Barefoot servants, too\n"
				+ "Well, uh, outside in the cold distance\n"
				+ "A wildcat did growl\n"
				+ "Two riders were approaching\n"
				+ "And the wind began to howl, hey";
	}

}
