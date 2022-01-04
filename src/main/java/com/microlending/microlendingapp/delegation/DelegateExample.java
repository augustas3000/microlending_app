package com.microlending.microlendingapp.delegation;

public class DelegateExample {

    public static void main(String[] args) {
        Employee employee = new Employee(new FastCoder(), new LovelyDesigner());
        employee.code();
        employee.design();
    }



}

interface WhoCanCode {
    void code();
}

interface WhoCanDesign {
    void design();
}

class Employee implements WhoCanCode, WhoCanDesign {

    //the employee is clever enough to pass responsibility to someone who can code and design
    WhoCanCode coder;
    WhoCanDesign designer;

    public Employee(WhoCanCode coder, WhoCanDesign designer) {
        this.coder = coder;
        this.designer = designer;
    }

    @Override
    public void code() {
        coder.code();
    }

    @Override
    public void design() {
        designer.design();
    }

}

class FastCoder implements WhoCanCode {
    @Override
    public void code() {
        System.out.println("Coded by FastCoder");
    }
}


class GoodDesigner implements WhoCanDesign {
    @Override
    public void design() {
        System.out.println("Designed by good designer");
    }
}


class LovelyDesigner implements WhoCanDesign {
    @Override
    public void design() {
        System.out.println("Designed by LOVELY designer");
    }
}