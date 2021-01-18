package com.elex_project.pixie.app;

import javax.swing.*;

final class Menubar extends JMenuBar {
	Menubar() {
		super();

		add(mnuFile());
	}

	private JMenu mnuFile() {
		final JMenu mnuFile = new JMenu("File");

		final JMenuItem mnuExit = new JMenuItem("Exit");

		mnuFile.add(mnuExit);
		return mnuFile;
	}
}
