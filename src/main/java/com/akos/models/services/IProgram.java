package com.akos.models.services;



import com.akos.models.modules.IModuleModel;

import java.util.*;

/**
 * Created by Ákos on 2015. 12. 21.
 * Email: akoshervay@gmail.com
 */
public interface IProgram {

    String getName();

    void setName(String name);

    List<IModuleModel> getElements();

    void setElements(List<IModuleModel> elements);

    void updateElements(IModuleModel module);

    UUID getId();

    int compareTo(Object o);

    String toString();
}
