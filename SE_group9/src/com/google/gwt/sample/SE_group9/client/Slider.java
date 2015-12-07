package com.google.gwt.sample.SE_group9.client;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.kiouri.sliderbar.client.view.SliderBarHorizontal;;;

public class Slider extends SliderBarHorizontal{
	//the new class created itself is the slider
	VerticalPanel vp = new VerticalPanel();
	Panel panel = RootPanel.get();
	public Slider() {
		vp.setWidth("500");
		Label lbl = new Label("Slider");
		setNotSelectedInFocus(); 
		drawMarks("black", 5);
		//set pngs in war foldefr for the different parts
		setLessWidget(new Image("less.png") );
		setScaleWidget(new Image("scale.png"),20);
		setMoreWidget(new Image("more.png"));
		setDragWidget(new Image("drag.png"));
		this.setMaxValue(114);
		this.setWidth("400px");
		this.setHeight("50");
		panel.setWidth("50");
		this.setValue(6);
	//	vp.clear();
		//vp.add(this);
		//vp.add(lbl);
		panel.add(this);
		panel.add(lbl);
	}
}


