package ru.sberbank.model;

import java.util.List;

/**
 * Created by Idony on 28.05.2016.
 */
public class CollectionFromForm {
    Long idCol;

    public Long getIdCol() {
        return idCol;
    }

    public void setIdCol(Long idCol) {
        this.idCol = idCol;
    }

    List<ObjectFromWithID> objectFromWithIDs;

    public List<ObjectFromWithID> getObjectFromWithIDs() {
        return objectFromWithIDs;
    }

    public void setObjectFromWithIDs(List<ObjectFromWithID> objectFromWithIDs) {
        this.objectFromWithIDs = objectFromWithIDs;
    }


}
