package com.rebwon.design.chap5;

import com.rebwon.design.chap5.AttackStrategy.MissileStrategy;
import com.rebwon.design.chap5.AttackStrategy.PunchStrategy;
import com.rebwon.design.chap5.MovingStrategy.FlyingStrategy;
import com.rebwon.design.chap5.MovingStrategy.WalkingStrategy;
import com.rebwon.design.chap5.Robot.Atom;
import com.rebwon.design.chap5.Robot.TaekwonV;

public final class RobotClient {

    public static void main(String[] args) {
        Robot taekwonV = new TaekwonV("taekwonV");
        Robot atom = new Atom("atom");

        taekwonV.setAttackStrategy(new PunchStrategy());
        taekwonV.setMovingStrategy(new WalkingStrategy());

        atom.setAttackStrategy(new MissileStrategy());
        atom.setMovingStrategy(new FlyingStrategy());

        taekwonV.move();
        taekwonV.attack();

        atom.move();
        atom.attack();
    }
}
