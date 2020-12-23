package prototype_halloween.controller;


import prototype_halloween.model.HalloweenLabel;

public class HalloweenController {
	
	private static int clickedLabel = 0;

	public static void setClickedLabel(int index) {
		clickedLabel = index;
	}

	public static HalloweenLabel getClickedLabel(int x, int y) {
		return HalloweenLabel.getLabels().get(clickedLabel).clone(x,y);
	}
	
	
}
