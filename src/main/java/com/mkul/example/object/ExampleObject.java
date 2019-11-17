package com.mkul.example.object;

public class ExampleObject {

    private String name;

    public ExampleObject(String objectName)
    {

        name = objectName;
    }

    @Override
    public int hashCode() {
        return name.length()*super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;
        if(obj == this)
            return true;
        if(obj instanceof ExampleObject)
        {
            return name.equals(((ExampleObject) obj).name);
        }
        return false;
    }

    @Override
    public String toString() {
        return name;
    }
}
