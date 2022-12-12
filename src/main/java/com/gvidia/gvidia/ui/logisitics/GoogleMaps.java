/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gvidia.gvidia.ui.logisitics;

import com.gvidia.gvidia.business.enterprise.location.Address;
import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import com.teamdev.jxbrowser.js.JsObject;
import com.teamdev.jxbrowser.view.swing.BrowserView;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

import java.io.File;

import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;

/**
 *
 * @author Nisha
 */
public class GoogleMaps extends JFrame{

    public GoogleMaps(MarkerListener listener) {
        EngineOptions options =
                EngineOptions.newBuilder(HARDWARE_ACCELERATED)
                        .licenseKey("1BNDHFSC1G4QI02K8L32PAUZQ9RF6TZCKCSAMEJ9V9M6Y24KIE5P9Z7EG7IXNGY2B7AHIQ").build();
        Engine engine = Engine.newInstance(options);
        Browser browser = engine.newBrowser();
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        SwingUtilities.invokeLater(() -> {
            BrowserView view = BrowserView.newInstance(browser);

            this.add(view, BorderLayout.CENTER);
            this.setSize(800, 500);
            this.setVisible(true);

            this.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e){

                    browser.mainFrame().ifPresent(frame -> {
                        JsObject latLng = frame.executeJavaScript("app.getMarker()");
                        if(latLng != null) {
                            Address address = new Address((Double)latLng.property("lat").get(), (Double)latLng.property("lng").get());
                            listener.getMarker(address);
                            GoogleMaps.this.dispose();
                        } else JOptionPane.showMessageDialog(GoogleMaps.this,"Select a Location");

                    });

                }
            });

            browser.navigation().loadUrl(getUrl());

        });
    }

    private String getUrl() {
        return "file:///C:/Users/kaustubh/Downloads/A/chip%20(1)/ChipConnect/src/main/java/com/nshmadhani/chipconnect/ui/logisitics/map.html";
    }


    public interface MarkerListener {
        public void getMarker(Address addr);
    }


    public static void main(String[] args) {
        new GoogleMaps((address) -> {
            System.out.println(address);
        });
    }
}