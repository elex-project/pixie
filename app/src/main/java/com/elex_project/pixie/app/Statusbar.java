package com.elex_project.pixie.app;

import lombok.AccessLevel;
import lombok.Getter;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

@Getter(AccessLevel.PACKAGE)
final class Statusbar extends JPanel {

	private JLabel lblMessage;

	Statusbar() {
		super(new BorderLayout());

		setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED),
				BorderFactory.createEmptyBorder(4, 8, 4, 8)));
		lblMessage = new JLabel();
		add(lblMessage, BorderLayout.CENTER);

		lblMessage.setText("Hello");
	}
}
