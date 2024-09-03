package com.dsa.algorithms.domain.java;

public interface KeyBoard {
    void type();
}

class MechanicalKeyBoard implements KeyBoard {
    @Override
    public void type() {
        System.out.println("Mechanical KeyBoard is typing");
    }
}

class MembraneKeyBoard implements KeyBoard {
    @Override
    public void type() {
        System.out.println("Membrane KeyBoard is typing");
    }
}

class Computer {
    private KeyBoard keyBoard;
    public Computer(KeyBoard keyBoard) {
        this.keyBoard = keyBoard;
    }
    public void type() {
        keyBoard.type();
    }
}

class ComputerFunction {
    KeyBoard mech = new MechanicalKeyBoard();
    Computer computer = new Computer(mech);

    public void type() {
        computer.type();
    }
}
