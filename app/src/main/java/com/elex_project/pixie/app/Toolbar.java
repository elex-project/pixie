package com.elex_project.pixie.app;

import lombok.AccessLevel;
import lombok.Getter;

import javax.swing.*;

@Getter(AccessLevel.PACKAGE)
final class Toolbar extends JToolBar {
	Toolbar() {
		super();
		setFloatable(false);
		//setBorder(BorderFactory.createEmptyBorder(4,4,4,4));

		add(new JButton("A"));
	}


}
