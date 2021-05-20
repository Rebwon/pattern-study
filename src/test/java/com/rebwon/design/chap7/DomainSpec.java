package com.rebwon.design.chap7;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("VendingMachine 도메인")
public final class DomainSpec {

    @Test
    @DisplayName("밴딩머신에 재고가 있고 음료 가격 이상의 돈이 있을 때 음료를 뽑을 수 있다")
    void name1() {

    }

    @Test
    @DisplayName("거스름돈이나 현재 넣은 돈을 반환할 수 있으며 반환한 돈을 리턴한다")
    void name2() {

    }

    @Test
    @DisplayName("음료의 가격과 재고를 지정할 수 있다")
    void name3() {

    }

    @Test
    @DisplayName("돈을 넣으면 현재 넣은 돈의 총합이 리턴된다")
    void name4() {

    }

    @Test
    @DisplayName("돈을 넣지 않고 음료 버튼이나 반환 버튼이 눌려지면 에러 메세지를 출력한다")
    void name5() {
    }

    @Test
    @DisplayName("돈이 있어도 음료 가격보다 돈의 액수가 적으면 음료를 뽑지 못한다는 에러 메세지를 출력한다")
    void name6() {

    }

    @Test
    @DisplayName("음료가 매진되었을 경우 돈이 투입되면 곧바로 반환하고 에러 메세지를 출력한다")
    void name7() {

    }

    @Test
    @DisplayName("음료가 매진되었을 경우 버튼이 눌려지면 에러 메세지를 출력한다")
    void name8() {

    }

}
