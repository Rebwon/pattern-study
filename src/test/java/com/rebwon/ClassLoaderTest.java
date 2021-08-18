package com.rebwon;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.net.URL;
import java.net.URLClassLoader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public final class ClassLoaderTest {

    // ClassPath 안에서는 무조건 URLClassLoader를 사용하더라도, 상위 클래스 로더 전략에 의해서
    // AppClassLoader를 통해 rebwonClass1과 rebwonClass2를 읽어오게 된다.
    // 아래의 테스트 코드는 서로 다른 클래스로더로 동작하길 기대한 테스트였지만,
    // ClassPath를 통해 상위 클래스 로더 전략에 의해서 AppClassLoader로
    // rebwonClass1와 rebwonClass2가 로드됬다.
    @Test
    void appClassLoader() throws Exception {
        URL url = new URL("file:C:\\Users\\msolo\\java\\xunit-study\\src\\test\\java\\com\\rebwon");
        URLClassLoader c1 = new URLClassLoader(new URL[]{url});
        Class rebwonClass1 = c1.loadClass("com.rebwon.Rebwon");

        URLClassLoader c2 = new URLClassLoader(new URL[]{url});
        Class rebwonClass2 = c2.loadClass("com.rebwon.Rebwon");

        ClassLoader c3 = rebwonClass1.getClassLoader();
        ClassLoader c4 = rebwonClass2.getClassLoader();

        System.out.println("URLClassLoader1: " + c1);
        System.out.println("URLClassLoader2: " + c2);
        System.out.println("URLClassLoader1 ParentClassLoader: " + c1.getParent());
        System.out.println("URLClassLoader2 ParentClassLoader: " + c2.getParent());
        System.out.println("rebwonClass1 loaded by: " + c3);
        System.out.println("rebwonClass2 loaded by: " + c4);

        assertThat(c1).isNotEqualTo(c3);

        assertThat(c2).isNotEqualTo(c4);

        assertThat(c1).isNotEqualTo(c3);
        assertThat(c1).isNotEqualTo(c4);

        assertThat(c2).isNotEqualTo(c3);
        assertThat(c2).isNotEqualTo(c4);

        assertThat(c3).isEqualTo(c4);
    }

    // Temp 폴더는 클래스 패스가 아니므로 URLClassLoader의 상위 클래스 로더인
    // AppClassLoader가 Rebwon.class를 읽지 못하므로(AppClassLoader는 클래스패스만 읽는다.)
    // 따라서 URLClassLoader가 가져오게 되며, rebwonClass1과 rebwonClass2는 서로 다른
    // 클래스 로더를 사용하여 가져온다.
    @Test
    void appTempClassLoader() throws Exception {
        URL url = new URL("file:C:\\Users\\msolo\\java\\xunit-study\\temp\\");
        URLClassLoader c1 = new URLClassLoader(new URL[]{url});
        Class rebwonClass1 = c1.loadClass("Rebwon");

        URLClassLoader c2 = new URLClassLoader(new URL[]{url});
        Class rebwonClass2 = c2.loadClass("Rebwon");

        ClassLoader c3 = c1.getParent();
        ClassLoader c4 = c2.getParent();

        ClassLoader c5 = rebwonClass1.getClassLoader();
        ClassLoader c6 = rebwonClass2.getClassLoader();

        System.out.println("URLClassLoader1: " + c1);
        System.out.println("URLClassLoader2: " + c2);
        System.out.println("URLClassLoader1 ParentClassLoader: " + c3);
        System.out.println("URLClassLoader2 ParentClassLoader: " + c4);
        System.out.println("rebwonClass1 loaded by: " + c5);
        System.out.println("rebwonClass2 loaded by: " + c6);

        System.out.println("C1 == C5 " + (c1==c5));
        System.out.println("C2 == C6 " + (c2==c6));
        System.out.println("C3 == C5 " + (c3==c5));
        System.out.println("C4 == C6 " + (c4==c6));
        System.out.println("C3 == C4 " + (c3==c4));
        System.out.println("C5 == C6 " + (c5==c6));
    }

    // 같은 클래스 파일이라도 서로 다른 클래스 로더가 로딩했다면, 별개의 클래스로 인식되어서
    // Class.cast()가 작동하지 않고 ClassCastException이 발생한다는 것을 보여주는 테스트.
    @Test
    void classCastException() throws Exception {
        URL url = new URL("file:C:\\Users\\msolo\\java\\xunit-study\\temp\\");
        URLClassLoader c1 = new URLClassLoader(new URL[]{url});
        Class rebwonClass1 = c1.loadClass("Rebwon");
        Object rebwon1 = rebwonClass1.getDeclaredConstructor().newInstance();

        URLClassLoader c2 = new URLClassLoader(new URL[]{url});
        Class rebwonClass2 = c2.loadClass("Rebwon");
        Object rebwon2 = rebwonClass2.getDeclaredConstructor().newInstance();

        assertThat(rebwonClass1).isNotEqualTo(rebwonClass2);

        assertThatExceptionOfType(ClassCastException.class)
            .isThrownBy(() -> rebwonClass1.cast(rebwon2));
    }
}
