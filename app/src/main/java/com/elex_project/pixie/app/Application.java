package com.elex_project.pixie.app;

import lombok.AccessLevel;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter(AccessLevel.PACKAGE)
public final class Application extends JPanel {

	private Toolbar toolbar;
	private Statusbar statusbar;
	private BarcodeView barcodeView;
	private InputPanel inputPanel;
	private JSplitPane splitPane;

	private Application() {
		super(new BorderLayout());

		splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);

		toolbar = new Toolbar();
		statusbar = new Statusbar();
		barcodeView = new BarcodeView();
		inputPanel = new InputPanel();

		splitPane.add(barcodeView, JSplitPane.LEFT);
		splitPane.add(inputPanel, JSplitPane.RIGHT);

		add(toolbar, BorderLayout.NORTH);
		add(splitPane, BorderLayout.CENTER);
		add(statusbar, BorderLayout.SOUTH);

	}

	public static void main(String... args) {
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception ignore) {
			// If Nimbus is not available, you can set the GUI to another look and feel.
		}

		Application application = new Application();

		final JFrame jFrame = new JFrame();
		jFrame.setContentPane(application);
		jFrame.setJMenuBar(new Menubar());
		jFrame.setTitle("2D/1D Barcode Generator");
		jFrame.setSize(800, 600);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setLocationRelativeTo(null);

		SwingUtilities.invokeLater(() -> {
			jFrame.setVisible(true);
			application.getSplitPane().setDividerLocation(0.5f);
		});
	}
}
