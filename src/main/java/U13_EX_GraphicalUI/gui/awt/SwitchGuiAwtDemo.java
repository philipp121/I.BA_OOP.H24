/*
 * Copyright 2024 Hochschule Luzern Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package U13_EX_GraphicalUI.gui.awt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Einfaches GUI auf AWT basierend.
 */
@SuppressWarnings("serial")
public final class SwitchGuiAwtDemo extends Frame implements ActionListener, WindowListener {

    private static final Logger LOG = LoggerFactory.getLogger(SwitchGuiAwtDemo.class);

    private final Label labelState = new Label("The switch is OFF.");
    private final Button buttonOn = new Button("On");
    private final Button buttonOff = new Button("Off");

    /**
     * Konstruktor.
     */
    public SwitchGuiAwtDemo() {
        super("Switch");

        this.addWindowListener(this);
        this.buttonOn.addActionListener(this);
        this.buttonOff.addActionListener(this);

        this.setLayout(new BorderLayout());
        this.add(buttonOn, BorderLayout.NORTH);
        this.add(labelState, BorderLayout.CENTER);
        this.add(buttonOff, BorderLayout.SOUTH);

        this.pack();
        this.setVisible(true);
        LOG.info("GUI-Frame aktiviert und sichtbar.");
    }

    /*
     * (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(final ActionEvent event) {
        if (event.getSource() == buttonOn) {
            labelState.setText("The switch is ON.");
            labelState.setBackground(Color.GREEN);
            LOG.info("ActionEvent von ON-Button empfangen und verarbeitet.");
        }
        if (event.getSource() == buttonOff) {
            labelState.setText("The switch is OFF.");
            labelState.setBackground(Color.RED);
            LOG.info("ActionEvent von OFF-Button empfangen und verarbeitet.");
        }
    }

    /**
     * main-Methode.
     * @param args nicht verwendet.
     */
    @SuppressWarnings("unused")
    public static void main(final String[] args) {
        LOG.info("Applikation startet...");
        new SwitchGuiAwtDemo();
    }

    /**
     * @see WindowListener#windowOpened(WindowEvent)
     */
    @Override
    public void windowOpened(final WindowEvent event) {
        // nothing to do
    }

    /**
     * @see WindowListener#windowClosing(WindowEvent)
     */
    @Override
    public void windowClosing(final WindowEvent event) {
        LOG.info("Applikation terminiert...");
        System.exit(0);
    }

    /**
     * @see WindowListener#windowClosed(WindowEvent)
     */
    @Override
    public void windowClosed(final WindowEvent event) {
        // nothing to do
    }

    /**
     * @see WindowListener#windowIconified(WindowEvent)
     */
    @Override
    public void windowIconified(final WindowEvent event) {
        // nothing to do
    }

    /**
     * @see WindowListener#windowDeiconified(WindowEvent)
     */
    @Override
    public void windowDeiconified(final WindowEvent event) {
        // nothing to do
    }

    /**
     * @see WindowListener#windowActivated(WindowEvent)
     */
    @Override
    public void windowActivated(final WindowEvent event) {
        // nothing to do
    }

    /**
     * @see WindowListener#windowDeactivated(WindowEvent)
     */
    @Override
    public void windowDeactivated(final WindowEvent event) {
        // nothing to do
    }
}
