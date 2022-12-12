/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gvidia.gvidia.ui.base;

import com.gvidia.gvidia.business.EcoSystem;

/**
 *
 * @author Nisha
 */
public class Controller {

    private EcoSystem mEcoSystem;
    private MainJFrame mMainFrame;

    public Controller(EcoSystem mEcoSystem, MainJFrame mMainFrame) {
        this.mEcoSystem = mEcoSystem;
        this.mMainFrame = mMainFrame;
    }

    public EcoSystem getmEcoSystem() {
        return mEcoSystem;
    }

    public void setmEcoSystem(EcoSystem mEcoSystem) {
        this.mEcoSystem = mEcoSystem;
    }

    public MainJFrame getmMainFrame() {
        return mMainFrame;
    }

    public void setmMainFrame(MainJFrame mMainFrame) {
        this.mMainFrame = mMainFrame;
    }

}

