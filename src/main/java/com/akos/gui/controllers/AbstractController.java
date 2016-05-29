package com.akos.gui.controllers;

import com.akos.services.MainService;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public abstract class AbstractController {

    protected MainService mainService;

    public AbstractController(MainService mainService) {
        this.mainService = mainService;

    }
}
