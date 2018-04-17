/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.views;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author beths
 */
public class View {

    BorderPane _view;

    public View(BorderPane view) {
        this._view = view;
    }

    public BorderPane getPanel() {
        return _view;
    }

}
