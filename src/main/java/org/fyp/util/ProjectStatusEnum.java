package org.fyp.util;

public enum ProjectStatusEnum {
    PENDING(0),
    REJECTED(1),
    VALIDATED(2)
    ;
    private final int status;

    ProjectStatusEnum(int status){
        this.status=status;
    }
}
