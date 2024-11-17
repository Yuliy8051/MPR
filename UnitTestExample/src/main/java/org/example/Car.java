package org.example;

public class Car {
    private boolean isBroken;
    private boolean isFixable;
    private boolean isDestroyed;

    public Car(boolean isBroken, boolean isFixable) {
        this.isBroken = isBroken;
        this.isFixable = isFixable;
        this.isDestroyed = false;
    }

    public boolean isBroken() {
        return isBroken;
    }

    public void setBroken(boolean broken) {
        isBroken = broken;
    }

    public boolean isFixable() {
        return isFixable;
    }

    public void setFixable(boolean fixable) {
        isFixable = fixable;
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }

    public void setDestroyed(boolean destroyed) {
        isDestroyed = destroyed;
    }
}
