package com.akos.modules;

import javafx.scene.input.DataFormat;
import javafx.util.Pair;

import java.io.Serializable;
import java.util.*;

/**
 * Created by Ákos on 2015. 12. 16.
 * Email: akoshervay@gmail.com
 */
public class DragDropContainer implements Serializable {


    private static final long serialVersionUID = 916373769247640846L;

    private final List<Pair<String, ?>> mDataPairs = new ArrayList<>();

    public static final DataFormat AddNode =
            new DataFormat("com.akos.gui.Modules.DraggableNode.add");

    public static final DataFormat DragNode =
            new DataFormat("com.akos.gui.Modules.DraggableNode.drag");

    public static final DataFormat AddLink =
            new DataFormat("com.akos.gui.Modules.ModuleLink.add");

    public DragDropContainer() {
    }

    public <E> void addData(String key, E value) {
        mDataPairs.add(new Pair<>(key, value));
    }

    public Object getValue(String key) {

        for (Pair<String, ?> data : mDataPairs) {

            if (data.getKey().equals(key))
                return data.getValue();

        }

        return null;
    }

    public List<Pair<String, ?>> getData() {
        return mDataPairs;
    }
}
