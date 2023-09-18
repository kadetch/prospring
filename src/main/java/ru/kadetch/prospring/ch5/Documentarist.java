package ru.kadetch.prospring.ch5;

public class Documentarist {
    private GrammyGuitarist guitarist;

    public void execute(){
        guitarist.sing();
        guitarist.talk();
    }

    public void setGuitarist(GrammyGuitarist guitarist){
        this.guitarist = guitarist;
    }
}
